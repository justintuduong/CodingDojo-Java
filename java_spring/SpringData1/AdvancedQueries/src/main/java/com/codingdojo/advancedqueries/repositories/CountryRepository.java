package com.codingdojo.advancedqueries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.advancedqueries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository <Country, Long>{

}
