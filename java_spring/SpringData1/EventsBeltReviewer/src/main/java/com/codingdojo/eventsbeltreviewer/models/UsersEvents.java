package com.codingdojo.eventsbeltreviewer.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "users_events")

public class UsersEvents {

// ------------------------------------------------------------------------------------
// users Table
// ------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	private User user;						// make singular for next time for easier query

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")			
	private Event event;					// make singular for next time for easier query

	
	
// ------------------------------------------------------------------------------------
// Constructors
// ------------------------------------------------------------------------------------

	public UsersEvents() {
	}

	public UsersEvents(User user, Event event) {
		this.user = user;
		this.event = event;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	
	
}
