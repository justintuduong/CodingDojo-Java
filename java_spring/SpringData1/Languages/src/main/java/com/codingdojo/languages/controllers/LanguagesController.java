package com.codingdojo.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")

public class LanguagesController {
	
	@Autowired
	LanguageService languageService;
	
//  ----------------------------------------------------------------
//  find all
//  ----------------------------------------------------------------

	@GetMapping("")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		
		
		return "/languages/index.jsp";
	}

// ----------------------------------------------------------------
// find one by id
// ----------------------------------------------------------------

	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long language_id) {
		Language language = languageService.findLanguage(language_id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}

// ----------------------------------------------------------------
// render create page
// ----------------------------------------------------------------

//	@GetMapping("/new")
//	public String newLanguage(@ModelAttribute("language") Language language) {
//		return "/languages/new.jsp";
//	}

// ----------------------------------------------------------------
// process create
// ----------------------------------------------------------------

	@PostMapping("/process")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}

// ----------------------------------------------------------------
// render edit page
// ----------------------------------------------------------------

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/edit.jsp";
	}

// ----------------------------------------------------------------
// process edit
// ----------------------------------------------------------------
	@PostMapping("/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}

// ----------------------------------------------------------------
// process delete
// ----------------------------------------------------------------
	@DeleteMapping("/{id}/delete")
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
