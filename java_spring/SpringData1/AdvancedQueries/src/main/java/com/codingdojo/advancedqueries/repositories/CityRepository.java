package com.codingdojo.advancedqueries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.advancedqueries.models.City;

@Repository
public interface CityRepository extends CrudRepository <City, Long>{

}
