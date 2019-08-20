package com.codingdojo.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.services.UserService;

@Controller

public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "/LogAndReg/registrationPage.jsp";
	}

	@PostMapping(value = "/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "/registration";
		} else {
			userService.registerUser(user);
			session.setAttribute("user_id", user.getId());
			return "redirect:/home";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "/LogAndReg/loginPage.jsp";
	}

	@PostMapping(value = "/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session) {
		Boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User user = userService.findByEmail(email);
			session.setAttribute("user_id", user.getId());
			return "redirect:/home";
		} else {
			return "redirect:/login";
		}

	}

	// if the user is authenticated, save their user id in session
	// else, add error messages and return the login page

	@GetMapping("/home")
	public String home(HttpSession session, Model model) {
		Long user_id = (Long) session.getAttribute("user_id");
		User u = userService.findUserById(user_id);
		model.addAttribute("user", u);
		return "/LogAndReg/homePage.jsp";
		// get user from session, save them in the model and return the home page
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
		// redirect to login page
	}

}