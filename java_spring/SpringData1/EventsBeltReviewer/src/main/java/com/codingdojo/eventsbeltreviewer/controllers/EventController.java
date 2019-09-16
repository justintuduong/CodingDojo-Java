package com.codingdojo.eventsbeltreviewer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.eventsbeltreviewer.models.Event;
import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.models.UsersEvents;
import com.codingdojo.eventsbeltreviewer.services.EventService;



@Controller
@RequestMapping("/events")

public class EventController {
	@Autowired
	private EventService eventService;
	
	

	@GetMapping("")
	private String home(Model model, HttpSession session, @ModelAttribute("event") Event event) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		User user = (User) session.getAttribute("user");
		model.addAttribute("user_id", user.getId());
		
				
		List<Event> eventsNearby = eventService.findByState(user.getState());
		model.addAttribute("eventsNearby", eventsNearby);
		
		List<Event> otherEvents = eventService.findByStateNot(user.getState());
		model.addAttribute("otherEvents", otherEvents);
		
		List<UsersEvents> eventsJoined = eventService.findByUserId(user.getId());
		
		model.addAttribute("eventsJoined", eventsJoined);
	
		return "/Events/eventsPage.jsp";
	}

	@PostMapping("/new")
	private String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "/Events/eventsPage.jsp";
		} else {
			eventService.createOrUpdate(event);
			return "redirect:/events";
		}
	}
	
	@GetMapping("/{id}/edit")
	private String editEvent(Model model, HttpSession session, @PathVariable("id") Long event_id, @ModelAttribute("event") Event event, BindingResult result) {
		if (session.getAttribute("user") == null) {
			return "redirect:/";
		}
		Event oneEvent = eventService.findById(event_id);
		model.addAttribute("event", oneEvent);
		if (session.getAttribute("user") == oneEvent.getUser()) {
			return "redirect:/events";
		}
		return "/Events/editEvent.jsp";
	}
	
	@PutMapping("/{id}/edit/process")
	private String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result) {
		if (result.hasErrors()) {
			return "/Events/editEvent.jsp";
		} else {
			eventService.createOrUpdate(event);
			return "redirect:/events";
		}
	}
	
	@GetMapping("/{id}")
	private String showOne(Model model, HttpSession session, @PathVariable("id")Long event_id) {
		Event oneEvent = eventService.findById(event_id);
		model.addAttribute("event", oneEvent);
		
		return "/Events/showOne.jsp";
	}
	
//  ----------------------------------------------------------------
//  delete
//  ----------------------------------------------------------------
	
	@DeleteMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long event_id, HttpSession session) {
		eventService.deleteEvent(event_id);
	return "redirect:/events";
	}
	

	
	
	
	
	
	
	

}
