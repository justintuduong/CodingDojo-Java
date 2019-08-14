package com.codingdojo.languages.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service

public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;
	
	// Find all

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	// Find one by id
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}

	// creates
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}

	// update
	public void updateLanguage(@Valid Language language) {
		languageRepository.save(language);
	}
	
	// delete
	public void deleteLanguage(Long id) {
		languageRepository.deleteById(id);
		return;
	}

}
