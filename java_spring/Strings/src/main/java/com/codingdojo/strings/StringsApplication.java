package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//-----------------------------------------------------------------------------
//import dependencies
//-----------------------------------------------------------------------------

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication // an open source framework used to create a Micro Service
@RestController // used to create RESTful web services using Spring MVC

//-----------------------------------------------------------------------------
//Class/routes/logic
//-----------------------------------------------------------------------------

public class StringsApplication {
        public static void main(String[] args) {
                SpringApplication.run(StringsApplication.class, args);
        }
        
        @RequestMapping("/")
        public String hello() { // 3
                return "Hello client! How are you doing?";
        }
        @RequestMapping("/random")
        public String random() { // 3
        	return "Spring Boot is great! So easy to just respond with strings";
        }
}