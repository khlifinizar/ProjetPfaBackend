package tn.essat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.essat.model.User;

@Repository
public interface IUser extends JpaRepository<User, Integer>  {
	List<User> findUserByEmailAndPassword(String email,String password);


}
