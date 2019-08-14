package com.codingdojo.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "languages")
public class Language {

//------------------------------------------------------------------------------------
// Language Table
//------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, max = 20)
	private String name;

	@Size(min = 2, max = 20)
	private String creator;

	@NotNull
	private String version;
	
//------------------------------------------------------------------------------------
// createdAt and updatedAt
//------------------------------------------------------------------------------------
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


//------------------------------------------------------------------------------------
// Constructors
//------------------------------------------------------------------------------------

	public Language() {
	}

	public Language(String name, String creator, String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}

//------------------------------------------------------------------------------------
//Getters and Setters
//------------------------------------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}