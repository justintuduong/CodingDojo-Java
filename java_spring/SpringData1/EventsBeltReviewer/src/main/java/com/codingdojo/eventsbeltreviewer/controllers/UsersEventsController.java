package com.codingdojo.eventsbeltreviewer.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.eventsbeltreviewer.models.Event;
import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.models.UsersEvents;
import com.codingdojo.eventsbeltreviewer.services.EventService;

@Controller
@RequestMapping("/events")
public class UsersEventsController {
	
	@Autowired
	EventService eventService;
	
	
	
//  ----------------------------------------------------------------
//  Join Event Function
//  ----------------------------------------------------------------
	
	@PostMapping("/{id}/join")
	public String joinEvent(@PathVariable("id") Long event_id, HttpSession session) {
		Event event = eventService.findById(event_id); //finds event object
		
		User user = (User) session.getAttribute("user");  //finds user object
		
		UsersEvents joinEvent = new UsersEvents (user, event);
		
		eventService.joinEvent(joinEvent);
		
		System.out.println("controller");
		return "redirect:/events/";
	}
	
	

}
