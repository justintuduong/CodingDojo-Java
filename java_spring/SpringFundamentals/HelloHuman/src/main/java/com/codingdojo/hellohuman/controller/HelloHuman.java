package com.codingdojo.hellohuman.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping
@RestController


public class HelloHuman {
		
		@RequestMapping("/")
		public String home(@RequestParam(value="first_name", required=false) String first_name, @RequestParam(value="last_name", required=false) String last_name)  {
			if (first_name == null & last_name == null) {
				first_name = "Human";
				last_name = "";
			}
			if (last_name == null) {
				last_name = "";
			}
			if (first_name == null) {
				first_name = "";
			}
			return "<h1>Hello " + first_name + " " + last_name + "</h1> <p>Welcome to SpringBoot! </p> <a href='/'> Back </a>";
		}
		

}
