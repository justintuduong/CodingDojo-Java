package com.codingdojo.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.ContactService;
import com.codingdojo.studentroster.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	ContactService contactService;

//----------------------------------------------------------------
//find all
//----------------------------------------------------------------

	@GetMapping("")
	public String index(Model model) {
		List<Student> students = studentService.allStudents();
		model.addAttribute("students", students);
		return "/students/index.jsp";
	}

//----------------------------------------------------------------
//render student create page
//----------------------------------------------------------------

	@GetMapping("/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/students/new.jsp";
	}

//----------------------------------------------------------------
//process create
//----------------------------------------------------------------

	@PostMapping("/new/process")
	public String create(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "/students/new";
		} else {
			studentService.createStudent(student);
			return "redirect:/students";
		}
	}

////----------------------------------------------------------------
////find one by id
////----------------------------------------------------------------
//
//@GetMapping("/{id}")
//public String show(Model model, @PathVariable("id") Long language_id) {
//	Language language = languageService.findLanguage(language_id);
//	model.addAttribute("language", language);
//	return "/languages/show.jsp";
//}

//
////----------------------------------------------------------------
////render edit page
////----------------------------------------------------------------
//
//@GetMapping("/{id}/edit")
//public String edit(@PathVariable("id") Long id, Model model) {
//	Language language = languageService.findLanguage(id);
//	model.addAttribute("language", language);
//	return "/languages/edit.jsp";
//}
//
////----------------------------------------------------------------
////process edit
////----------------------------------------------------------------
//@PutMapping("/{id}")
//public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
//	if (result.hasErrors()) {
//		return "/languages/edit.jsp";
//	} else {
//		languageService.updateLanguage(language);
//		return "redirect:/languages";
//	}
//}
//
////----------------------------------------------------------------
////process delete
////----------------------------------------------------------------
//@DeleteMapping("/{id}/delete")
//public String destroy(@PathVariable("id") Long id) {
//	languageService.deleteLanguage(id);
//	return "redirect:/languages";
//}

}
