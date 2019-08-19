package com.codingdojo.studentroster.services;


//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.studentroster.models.CourseStudent;
import com.codingdojo.studentroster.repositories.CourseStudentRepository;

@Service

public class CourseStudentService {
	@Autowired
	CourseStudentRepository courseStudentRepository;
	

	public CourseStudent createRelationship(CourseStudent courseStudent) {
		return courseStudentRepository.save(courseStudent);
	}	
	
	// delete
	public void deleteRelationship(Long id) {
		courseStudentRepository.deleteById(id);
		return;
	}

}
