package com.codingdojo.lookify.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.codingdojo.lookify.services.LookifyService;


public class HTMLController {
	
	@Autowired
	LookifyService lookifyService;
//  ----------------------------------------------------------------
//  Splash Page
//  ----------------------------------------------------------------
	
	@GetMapping("/")
	public String index() {
		return "/index.html";
	}

}
