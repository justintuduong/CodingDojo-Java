package com.codingdojo.studentroster.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Student;
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
	
	public List<Student> findByDormIsNull(){
		return studentRepository.findByDormIsNull();
	}
	

//  ----------------------------------------------------------------
//  create 
//  ----------------------------------------------------------------
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	// Find one by id
	public Student findById(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if (optionalStudent.isPresent()) {
			return optionalStudent.get();
		} else {
			return null;
		}
	}

//	// delete
//	public void deleteLanguage(Long id) {
//		languageRepository.deleteById(id);
//		return;
//	}

}
