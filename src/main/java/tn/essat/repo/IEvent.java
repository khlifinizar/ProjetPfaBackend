package tn.essat.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.essat.model.Event;
@Repository
public interface IEvent extends JpaRepository<Event, Integer> {
	 @Query("select e from Event e where e.cat.id=:x")
     public List <Event> geteventbycat(@Param("x")int id);
	

}
