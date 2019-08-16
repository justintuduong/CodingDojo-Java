package com.codingdojo.studentroster.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.repositories.ContactRepository;
import com.codingdojo.studentroster.repositories.StudentRepository;

@Service

public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	
//  ----------------------------------------------------------------
//  find all
//  ----------------------------------------------------------------

	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	

//  ----------------------------------------------------------------
//  create 
//  ----------------------------------------------------------------
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	
//	// Find one by id
//	public Language findLanguage(Long id) {
//		Optional<Language> optionalLanguage = languageRepository.findById(id);
//		if (optionalLanguage.isPresent()) {
//			return optionalLanguage.get();
//		} else {
//			return null;
//		}
//	}
//
//
//	// update
//	public void updateLanguage(@Valid Language language) {
//		languageRepository.save(language);
//	}
//	
//	// delete
//	public void deleteLanguage(Long id) {
//		languageRepository.deleteById(id);
//		return;
//	}

}
