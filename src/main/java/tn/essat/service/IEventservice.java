package tn.essat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tn.essat.model.Event;

public interface IEventservice {
	public List<Event> geteventbycat(@Param("x") int id);

	public List<Event> getall();

	public void remove(int id);

	public Event save(Event e);

	public Optional<Event> getEventByid(int id);

	public Event updateEvent(Event e);
	
	

}
