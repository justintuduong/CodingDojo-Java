package com.codingdojo.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
    // this method retrieves all the books from the database
    List<Book> findAll();

    // this method 
   
    
    // this method deletes a book that starts with a specific title
    void deleteById(Long id);

	Book save(Optional<Book> updateBook);
}
