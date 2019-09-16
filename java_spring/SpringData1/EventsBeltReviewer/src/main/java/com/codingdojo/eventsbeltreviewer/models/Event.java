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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {

// ------------------------------------------------------------------------------------
// events Table
// ------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(min = 1, message = "Name cannot be left empty.")
	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;

	@Size(min = 1, message = "City cannot be left empty.")
	private String city;

	@Size(min = 2, max = 2, message = "State cannot be left empty.")
	private String state;

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
	// many to 1 Relationships
	// ------------------------------------------------------------------------------------

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	// ------------------------------------------------------------------------------------
	// many to many Relationships
	// ------------------------------------------------------------------------------------

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_events", joinColumns = @JoinColumn(name = "event_id"), 
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;


	// ------------------------------------------------------------------------------------
	// Constructors
	// ------------------------------------------------------------------------------------

	public Event() {
	}

	public Event(Long id, @Size(min = 1, message = "Name cannot be left empty.") String name, String date,
			@Size(min = 1, message = "City cannot be left empty.") String city,
			@Size(min = 2, max = 2, message = "State cannot be left empty.") String state, Date createdAt,
			Date updatedAt, User user, List<User> users) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.city = city;
		this.state = state;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.users = users;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
