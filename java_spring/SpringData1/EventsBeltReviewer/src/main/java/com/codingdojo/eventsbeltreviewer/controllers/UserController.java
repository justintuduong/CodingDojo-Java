package com.codingdojo.eventsbeltreviewer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.services.UserService;
import com.codingdojo.eventsbeltreviewer.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;

// ------------------------------------------------------------------------------------
// RENDER Login & Registration page
// ------------------------------------------------------------------------------------
	
	@GetMapping("/")
	public String registration(@ModelAttribute("user")User user, BindingResult result) {
		return "/User/loginAndRegistration.jsp";
	}

// ------------------------------------------------------------------------------------
// POST Registration
// ------------------------------------------------------------------------------------

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "/User/loginAndRegistration.jsp";
		} else {
			User u = userService.registerUser(user);
			session.setAttribute("user", u);
			return "redirect:/events";
		}
	}

// ------------------------------------------------------------------------------------
// POST Login
// ------------------------------------------------------------------------------------
	
	@PostMapping(value = "/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes error ,HttpSession session) {
		Boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User user = userService.findByEmail(email);
			session.setAttribute("user", user);
			return "redirect:/events";
		} else {
			error.addFlashAttribute("error", "Invalid credentials.");
			return "redirect:/";
		}
	}
// ------------------------------------------------------------------------------------
// Logout
// ------------------------------------------------------------------------------------

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
		// redirect to login page
	}

}
