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

import tn.essat.model.User;
import tn.essat.service.IUserservice;
import tn.essat.service.impl.UserService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserRest {
	@Autowired
	IUserservice uss;
	
	  @GetMapping("/user/{email}/{password}")
	    public List<User> loginUser(@PathVariable(name = "email") String email, @PathVariable(name = "password") String password) {
	        
	        return ( List<User>)uss.findUserByEmailAndPassword(email, password);
	    }
	  @GetMapping("users")
	  public List <User> getall(){
		return (List <User>) uss.getall();}
	  
	  
	  
	  @DeleteMapping("delete/{id}")
	  void remove(@PathVariable("id") int id ) {
		  uss.remove(id);
		  
		  
		  
		  
	  }@PostMapping("save")
	  public void save(@RequestBody User u) {
		  uss.save(u);
	  }
	  @GetMapping("getuser/{id}")
	  public Optional<User> getUserByid(@PathVariable("id")int id){
		  return uss.getUserByid(id);
		  
	  }
	  @PutMapping("upuser")
	  public User updateUser(User u) {
			return uss.updateUser(u);
		}
	  
		  
		  
		  
		  
		  
	  }


