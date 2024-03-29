package com.codingdojo.advancedqueries.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country {

	// ------------------------------------------------------------------------------------
	// countries Table
	// ------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min=1)
	private String code;
	
	@Size(min=1)
	private String name;
	
	@Size(min=1)
	private String continent;
	
	@Size(min=1)
	private String region;
	
	@NotNull
	private Float surface_area;
	
	@NotNull
	private Short indep_year;
	
	@NotNull
	private Integer population;
	
	@NotNull
	private Float life_expectancy;
	
	@NotNull
	private Float gnp;
	
	@NotNull
	private Float gnp_old;
	
	@Size(min=1)
	private String local_name;
	
	@Size(min=1)
	private String government_form;
	
	@Size(min=1)
	private String head_of_state;
	
	@NotNull
	private Integer capital;
	
	@Size(min=1)
	private String code2;


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
	// One to Many Relationships
	// ------------------------------------------------------------------------------------

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<Language> language;

	@OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
	private List<City> city;
	
	// ------------------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------------------
	
	public Country() {
	}
	
	public Country(String code, String name, String continent, String region, Float surface_area, Short indep_year,
			 Integer population, Float life_expectancy, Float gnp, Float gnp_old, String local_name, String government_form, String head_of_state, Integer capital, String code2,
			List<Language> language, List<City> city) {

		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
		this.language = language;
		this.city = city;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Float getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(Float surface_area) {
		this.surface_area = surface_area;
	}

	public Short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(Float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}

	public Float getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(Float gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
	}

	
}