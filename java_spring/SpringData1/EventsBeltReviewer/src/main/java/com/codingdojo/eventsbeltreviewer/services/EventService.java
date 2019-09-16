package com.codingdojo.eventsbeltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.eventsbeltreviewer.models.Event;
import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.models.UsersEvents;
import com.codingdojo.eventsbeltreviewer.repositories.EventRepository;
import com.codingdojo.eventsbeltreviewer.repositories.UserRepository;
import com.codingdojo.eventsbeltreviewer.repositories.UsersEventsRepository;

@Service
public class EventService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired 
	UsersEventsRepository usersEventsRepository;


	public Event createOrUpdate(Event event) {
		return eventRepository.save(event);
	}
	
	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}
	
	public List<Event> findAllEvents() {
		return eventRepository.findAll();
	}
	
	public List<Event> findByState(String state) {
		return eventRepository.findByState(state);
	}
	public List<Event> findByStateNot(String state) {
		return eventRepository.findByStateNot(state);
	}

	
	public Event findById(Long id) {
		Optional<Event> optionalEvent = eventRepository.findById(id);
		if (optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}
	
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

	public UsersEvents joinEvent(UsersEvents joinEvent) {
		return usersEventsRepository.save(joinEvent);
	}

	public List<UsersEvents> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return usersEventsRepository.findByUserId(id);
	}
	
	


}
