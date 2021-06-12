package tn.essat.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.essat.model.Categorie;

import tn.essat.service.ICategorieservice;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class Categorierest {
	@Autowired
	ICategorieservice cat;
	
	  public Categorierest(ICategorieservice cat) {
		
		this.cat = cat;
	}
	@GetMapping("cats")
	  public List <Categorie> getall(){
		return (List <Categorie>) cat.getall();}
	  @DeleteMapping("deletecat/{id}")
	  void remove(@PathVariable("id") int id ) {
		  cat.remove(id);
		  
		  
		  
		  
	  }@PostMapping("savecat")
	  public void save(@RequestBody Categorie c) {
		  cat.save(c);
	  }
	  @GetMapping("getcat/{id}")
	  public Optional<Categorie> getcatByid(@PathVariable("id")int id){
		  return cat.getCategorieByid(id);
		  
	  }
	  @PutMapping("upcat")
	  public void updatecat(Categorie c) {
			 cat.updateCategorie(c);
		}

}
