package com.codingdojo.dojosurvey.survey;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping

public class SurveyController {

	// renders form
	@RequestMapping(value="/")		
	public String index(Model model) {
		return "index.jsp";
	}

	// processes POST form
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processResult(HttpSession session, 
			@RequestParam(value="name") String name, 
			@RequestParam(value="location") String location, 
			@RequestParam(value="language") String language, 
			@RequestParam(value="comment") String comment) {
		
		session.setAttribute("name", name); 
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		return "redirect:/result";
	}
	
	// renders results
	@RequestMapping("/result")
	public String result(Model model, HttpSession session) {
		String name = (String)session.getAttribute("name");
		String location = (String)session.getAttribute("location");
		String language = (String)session.getAttribute("language");
		String comment = (String)session.getAttribute("comment");
		
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		
		return "result.jsp";
	}

}
