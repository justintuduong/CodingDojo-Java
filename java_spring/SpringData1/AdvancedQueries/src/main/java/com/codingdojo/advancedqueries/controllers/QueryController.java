package com.codingdojo.advancedqueries.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.codingdojo.advancedqueries.services.ApiService;


@Controller
public class QueryController {
	
	@Autowired
	ApiService apiService;
	
	@GetMapping("/")
	public String allRoutes() {
		return "/contacts/new.jsp";
	}
	

}
