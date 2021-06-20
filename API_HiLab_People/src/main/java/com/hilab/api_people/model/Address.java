package com.hilab.api_people.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hilab.api_people.model.util.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

@Data
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Include
	private String id;
	
	private Type type;
	
	private Long zipcode;
	
	private String state;
	
	private String city;
	
	private String street;
	
	private Integer number;
	
	private String complement;
	
	private String district;
	
	private People people;
	
}
