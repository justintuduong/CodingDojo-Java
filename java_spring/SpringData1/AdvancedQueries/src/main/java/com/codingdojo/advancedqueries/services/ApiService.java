package com.codingdojo.advancedqueries.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.advancedqueries.repositories.CityRepository;
import com.codingdojo.advancedqueries.repositories.CountryRepository;
import com.codingdojo.advancedqueries.repositories.LanguageRepository;

@Service
public class ApiService {
	
	@Autowired
	CountryRepository countryRepo;
	
	@Autowired
	LanguageRepository langRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	public Country findCountry(Country country) {
		
		return countryRepository.findAllCountrySortByLanguage(Language);
	}

}
