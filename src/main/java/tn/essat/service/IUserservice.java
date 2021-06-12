package tn.essat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.essat.model.User;

public interface IUserservice {
	public List<User> findUserByEmailAndPassword(String email,String password);
	public List<User> getall();
	public void remove( int id );
	  public void save( User u);
	  public  Optional<User> getUserByid(int id);
	  public  User updateUser(User u);

	

}
