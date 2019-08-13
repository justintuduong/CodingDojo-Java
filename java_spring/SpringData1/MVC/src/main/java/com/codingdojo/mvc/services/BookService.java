package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {

	// adding the book repository as a dependency
//	private final BookRepository bookRepository;
//
//	public BookService(BookRepository bookRepository) {
//	this.bookRepository = bookRepository;

	@Autowired
	BookRepository bookRepository;

//	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	//
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> book = bookRepository.findById(id);

		if (book.isPresent()) {
			Book update = book.get();
			update.setTitle(title);
			update.setDescription(desc);
			update.setLanguage(lang);
			update.setNumberOfPages(numOfPages);
			return bookRepository.save(update);
		}
		return null;
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		return;

	}

	public void updateBook(@Valid Book book) {
		bookRepository.save(book);
	}

}
