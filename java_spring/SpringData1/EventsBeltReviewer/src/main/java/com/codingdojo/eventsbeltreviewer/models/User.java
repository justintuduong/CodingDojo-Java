package com.codingdojo.eventsbeltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "users")
public class User {

// ------------------------------------------------------------------------------------
// users Table
// ------------------------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 2, message = "*Requires at least 2 Characters.")
	private String firstName;

	@Size(min = 2, message = "*Requires at least 2 Characters.")
	private String lastName;

	@Size(min = 1, message = "*Email cannot be empty.")
	@Email(message = "*Email must be valid.")
	private String email;

	@Size(min = 1, message = "*City cannot be empty.")
	private String city;

	@Size(min = 2, max = 2, message = "*State cannot be empty.")
	private String state;

	@Size(min = 5, message = "*Password must be greater than 5 characters.")
	private String password;

	@Transient
	private String passwordConfirmation;

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;

// ------------------------------------------------------------------------------------
// PrePersist & PreUpdate
// ------------------------------------------------------------------------------------

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

// ------------------------------------------------------------------------------------
// 1 to many Relationships (events created)
// ------------------------------------------------------------------------------------

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Event> events;
	
	
// ------------------------------------------------------------------------------------
// many to many Relationships
// ------------------------------------------------------------------------------------

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_events", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "event_id"))
	private List<Event> eventsJoined;

// ------------------------------------------------------------------------------------
// Constructors
// ------------------------------------------------------------------------------------


	public User() {
	}

	public User(Long id, @Size(min = 2, message = "*Requires at least 2 Characters.") String firstName,
			@Size(min = 2, message = "*Requires at least 2 Characters.") String lastName,
			@Size(min = 1, message = "*Email cannot be empty.") @Email(message = "*Email must be valid.") String email,
			@Size(min = 1, message = "*City cannot be empty.") String city,
			@Size(min = 2, max = 2, message = "*State cannot be empty.") String state,
			@Size(min = 5, message = "*Password must be greater than 5 characters.") String password,
			String passwordConfirmation, Date createdAt, Date updatedAt, List<Event> events, List<Event> eventsJoined) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
		this.state = state;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.events = events;
		this.eventsJoined = eventsJoined;
	}


//------------------------------------------------------------------------------------
//Getters and Setters
//------------------------------------------------------------------------------------
	

	public List<Event> getEventsJoined() {
		return eventsJoined;
	}
	
	public void setEventsJoined(List<Event> eventsJoined) {
		this.eventsJoined = eventsJoined;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

}
