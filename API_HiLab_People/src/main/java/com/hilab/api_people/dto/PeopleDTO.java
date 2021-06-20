package com.hilab.api_people.dto;

import java.io.Serializable;
import java.util.Date;

import com.hilab.api_people.model.People;
import com.hilab.api_people.model.util.Status;

import lombok.Data;

@Data
public class PeopleDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	private Status status;
	
	private String givenName;
	
	private String familyName;
	
	private Date birthDate;
	
	public PeopleDTO() {}
	
	public PeopleDTO(People obj) {
		id = obj.getId();
		status = obj.getStatus();
		givenName = obj.getGivenName();
		familyName = obj.getFamilyName();
		birthDate = obj.getBirthDate();
	}
	
}
