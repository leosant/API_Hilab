package com.hilab.api_people.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hilab.api_people.model.util.Status;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document
public class People implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Include
	private String id;
	
	private Status status;
	
	@NotEmpty(message = "Inform the given name")
	private String givenName;
	
	@NotEmpty(message = "Inform the family name")
	private String familyName;
	
	private Date birthDate;
	
	@DBRef(lazy = true)
	private Address address;
	
	@DBRef(lazy = true)
	private Phone phone;
	
	public People() {}

	public People(String id, Status status, String givenName, String familyName, Date birthDate) {
		this.id = id;
		this.status = status;
		this.givenName = givenName;
		this.familyName = familyName;
		this.birthDate = birthDate;
	}
	
	
	
}
