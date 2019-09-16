package com.codingdojo.eventsbeltreviewer.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventsbeltreviewer.models.UsersEvents;

@Repository
public interface UsersEventsRepository extends CrudRepository <UsersEvents, Long>{

	List<UsersEvents> findByUserId(Long id);
	
	
}
