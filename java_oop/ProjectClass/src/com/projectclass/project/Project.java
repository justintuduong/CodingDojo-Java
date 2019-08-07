package com.projectclass.project;

public class Project {
	public String name = "";
	public String description = "";

	public String elevatorPitch() {
		return this.name + ": " + this.description;
	}

	public Project() {};
	public Project(String name) {};
	public Project(String name, String description) {}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};
}
