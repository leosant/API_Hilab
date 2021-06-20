package com.hilab.api_people.model.util;

public enum Status {
	
	ACTIVE("Active"),
	INACTIVE("Inactive");
	
	private String description;
	
	Status(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
