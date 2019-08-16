package com.codingdojo.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Student;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	   List<Contact> findAll();

	    void deleteById(Long id);

}
