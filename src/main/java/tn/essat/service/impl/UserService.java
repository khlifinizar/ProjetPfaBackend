package tn.essat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.essat.model.User;
import tn.essat.repo.IUser;
import tn.essat.service.IUserservice;
@Service
public class UserService implements IUserservice {
	@Autowired
	IUser US;

	@Override
	public List<User> findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return US.findUserByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		return US.findAll();
	}

	@Override
	public void remove(int id) {
		US.deleteById(id);
		
	}

	@Override
	public void save(User u) {
		US.save(u);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<User> getUserByid(int id) {
		// TODO Auto-generated method stub
		return US.findById(id);
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return US.save(u);
	}

	
	

}
