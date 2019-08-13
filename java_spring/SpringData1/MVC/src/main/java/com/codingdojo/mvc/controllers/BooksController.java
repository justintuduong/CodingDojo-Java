package com.codingdojo.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.services.BookService;

@Controller

public class BooksController {
	private final BookService bookService;

	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
//   ----------------------------------------------------------------
//   find all
//   ----------------------------------------------------------------

	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "/books/index.jsp";
	}

//  ----------------------------------------------------------------
//  find one by id
//  ----------------------------------------------------------------

	@RequestMapping("/books/{id}")
	public String show(Model model, @PathVariable("id") Long book_id) {
		Book book = bookService.findBook(book_id);
		model.addAttribute("book", book);
		return "/books/show.jsp";
	}

//  ----------------------------------------------------------------
//  render create page
//  ----------------------------------------------------------------

	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "/books/new.jsp";
	}

//  ----------------------------------------------------------------
//  process create
//  ----------------------------------------------------------------

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/new.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}

//  ----------------------------------------------------------------
//  render edit page
//  ----------------------------------------------------------------

	@RequestMapping("/books/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "/books/edit.jsp";
	}

//  ----------------------------------------------------------------
//  process edit
//  ----------------------------------------------------------------
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "/books/edit.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books";
		}
	}

//  ----------------------------------------------------------------
//  process delete
//  ----------------------------------------------------------------
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

}
