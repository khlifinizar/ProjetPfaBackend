package tn.essat.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import tn.essat.model.Categorie;

import tn.essat.model.Event;

import tn.essat.repo.IEvent;
import tn.essat.service.IEventservice;
import tn.essat.service.impl.FileStorageServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Eventrest {
	@Autowired IEventservice ev;
	 @Autowired
	    private final FileStorageServiceImpl fileStorageService;
	 @Autowired
	 IEvent  ec;
	 
	
	public Eventrest(IEventservice ev, FileStorageServiceImpl fileStorageService) {
		
		this.ev = ev;
		this.fileStorageService = fileStorageService;
	}
	@GetMapping("eventss")
	  public List <Event> getall(){
		return (List <Event>) ev.getall();}
	  @DeleteMapping("deleteevent/{id}")
	  void remove(@PathVariable("id") int id ) {
		  ev.remove(id);
		  
		  
		  
		  
	  }@PostMapping(value = "event",consumes = MediaType.APPLICATION_JSON_VALUE)
	  public Event save(@RequestBody Event e) {
		 
		 
		  return ev.save(e);
	  }
	  @GetMapping("getevent/{id}")
	  public Optional<Event> getEventByid(@PathVariable("id")int id){
		  return ev.getEventByid(id);
		  
	  }
	  @PutMapping("upEvent")
	  public Event updateEvent(Event e) {
			 return ev.updateEvent(e);
		}
	  
	  @PostMapping("/upload/{id}")
      public void uploadFile(@RequestParam(value = "file") MultipartFile file,@PathVariable("id") int id) {
     String  baseURL = "http://127.0.0.1:8080/api/getfile/";
     Optional<Event> productById = ev.getEventByid(id);
     
   
         String fileName = fileStorageService.storeFile(file);
         Event picture = new Event();
         picture=productById.get();
         
         picture.setSmall(baseURL + fileName);
         ev.save(picture);
     
    

     
    
      }
  
	  @GetMapping("getfile/{fileName}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        // Load file as Resource
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	        }

	        // Fallback to the default content type if type could not be determined
	        if (contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);}
	  @PutMapping("/valider/{id}")
		public ResponseEntity<Event> valider(@PathVariable("id") int id, @RequestBody Event ev) {
			
			Optional<Event> evvv = ec.findById(id);
			if (evvv.isPresent()) {
				Event souss = evvv.get();
				
				souss.setNom(souss.getNom());
				souss.setSmall(souss.getSmall());
				souss.setId(souss.getId());
				souss.setHeure_debut(souss.getHeure_debut());
				souss.setHeure_fin(souss.getHeure_fin());
				souss.setEtat(souss.getEtat());
				souss.setDescription(souss.getDescription());
				souss.setDate_debut(souss.getDate_debut());
				souss.setDate_fin(souss.getDate_fin());
				souss.setEtat("valider");
			
				

				return new ResponseEntity<>(ec.save(souss), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
