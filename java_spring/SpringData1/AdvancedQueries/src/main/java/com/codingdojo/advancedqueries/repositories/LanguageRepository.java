package com.codingdojo.advancedqueries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codingdojo.advancedqueries.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository <Language, Long> {

}
