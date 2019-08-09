package com.codingdojo.routing.codingcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/coding")
@RestController

public class CodingController {
	
	@RequestMapping("")
	public String display() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/python")
	public String python() {
		return "Python/Django was awesome!";
	}

	@RequestMapping("/java")
	public String java() {
		return "Java/Spring is better!";
	}

}
