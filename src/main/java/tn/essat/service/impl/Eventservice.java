package tn.essat.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.essat.model.Event;
import tn.essat.repo.IEvent;
import tn.essat.service.IEventservice;
@Service
public class Eventservice implements IEventservice{
	@Autowired
	IEvent ev;

	@Override
	public List<Event> geteventbycat(int id) {
		// TODO Auto-generated method stub
		return (List<Event>) ev.geteventbycat(id)  ;
	}

	@Override
	public List<Event> getall() {
		// TODO Auto-generated method stub
		return (List<Event>) ev.findAll();
	}

	@Override
	public void remove(int id) {
		ev.deleteById(id);
		
	}

	@Override
	public Event save(Event e) {
		return ev.save(e);
		
	}

	

	@Override
	public Event updateEvent(Event e) {
		// TODO Auto-generated method stub
		return ev.save(e);
	}

	@Override
	public Optional<Event> getEventByid(int id) {
		// TODO Auto-generated method stub
		return ev.findById(id);
	}


}
