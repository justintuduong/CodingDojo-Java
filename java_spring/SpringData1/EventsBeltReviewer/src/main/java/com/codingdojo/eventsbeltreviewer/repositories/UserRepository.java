package com.codingdojo.eventsbeltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventsbeltreviewer.models.User;

@Repository
public interface UserRepository extends CrudRepository <User, Long> {

//	find by email
    User findByEmail(String email);
    
}
