package com.codingdojo.displaydate.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping

public class DisplayDate {
	

	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String dateTemplate(Model model) {
		Date date = new java.util.Date();
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String timeTemplate(Model model) {
		Date time = new java.util.Date();
		model.addAttribute("time", time);
		return "time.jsp";
	}
}
