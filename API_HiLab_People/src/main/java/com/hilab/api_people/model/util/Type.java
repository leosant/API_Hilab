package com.hilab.api_people.model.util;

public enum Type {
	PHYSICAL("Physical"),
	DELIVERY("Delivery");
	
	private String description;
	
	Type(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
}
