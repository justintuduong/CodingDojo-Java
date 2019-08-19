package com.codingdojo.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.Course;
import com.codingdojo.studentroster.repositories.CourseRepository;


@Service

public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
//  ----------------------------------------------------------------
//  find all
//  ----------------------------------------------------------------

	public List<Course> findAll() {
		return courseRepository.findAll();
	}
//	
//	public List<Student> findByDormIsNull(){
//		return studentRepository.findByDormIsNull();
//	}
	

//  ----------------------------------------------------------------
//  create 
//  ----------------------------------------------------------------
	
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	// Find one by id
	public Course findById(Long id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
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
