package com.codingdojo.routing.dojocontroller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class DojoController {

	@RequestMapping("/{dojo}")

	public String dojo(@PathVariable("dojo") String dojo) {
		
		if (dojo.equals("dojo")) {
			return "The dojo is awesome!";
		}
		
		if (dojo.equals("burbank-dojo")) {
			return "Burbank!";
		}
		
		if (dojo.equals("san-jose")) {
			return "San Jose!";
		}
		return dojo;
	}

}
