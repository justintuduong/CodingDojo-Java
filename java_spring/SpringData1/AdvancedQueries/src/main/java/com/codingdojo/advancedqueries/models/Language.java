package com.codingdojo.advancedqueries.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "languages")

public class Language {

	// ------------------------------------------------------------------------------------
	// languages Table
	// ------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1)
	private String country_code;
	@Size(min=1)
	private String language;
	@Size(min=1)
	private String is_official;
	@Size(min=1)
	private Float percentage;

	
	

	// ------------------------------------------------------------------------------------
	// createdAt and updatedAt
	// ------------------------------------------------------------------------------------
	
//		@Column(updatable = false)
//		@DateTimeFormat(pattern = "yyyy-MM-dd")
//		private Date createdAt;
//	
//		@PrePersist
//		protected void onCreate() {
//			this.createdAt = new Date();
//		}
//	
//		@DateTimeFormat(pattern = "yyyy-MM-dd")
//		private Date updatedAt;
//	
//		@PreUpdate
//		protected void onUpdate() {
//			this.updatedAt = new Date();
//		}
	
	
	// ------------------------------------------------------------------------------------
	// many to 1 Relationships
	// ------------------------------------------------------------------------------------
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	// ------------------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------------------
	
	public Language(String country_code, String language, String is_official, Float percentage, Country country) {
		this.country_code = country_code;
		this.language = language;
		this.is_official = is_official;
		this.percentage = percentage;
		this.country = country;
	}
	
	
	// ------------------------------------------------------------------------------------
	// Getters and Setters
	// ------------------------------------------------------------------------------------


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCountry_code() {
		return country_code;
	}



	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}



	public String getLanguage() {
		return language;
	}



	public void setLanguage(String language) {
		this.language = language;
	}



	public String getIs_official() {
		return is_official;
	}



	public void setIs_official(String is_official) {
		this.is_official = is_official;
	}



	public Float getPercentage() {
		return percentage;
	}



	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}

	
	
	public Country getCountry() {
		return country;
	}



	public void setCountry(Country country) {
		this.country = country;
	}

	
}
