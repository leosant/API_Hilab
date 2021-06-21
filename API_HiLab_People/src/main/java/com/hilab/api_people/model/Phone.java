package com.hilab.api_people.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Phone implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	private String id;
	private List<String> number;
	private People people;
	
	public Phone() {}
	
	public Phone(String id, List<String> number) {
		this.id = id;
		this.number = number;
	}
}
