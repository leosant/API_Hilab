package com.hilab.api_people.dto;

import java.io.Serializable;
import java.util.List;

import com.hilab.api_people.model.People;
import com.hilab.api_people.model.Phone;

import lombok.Data;

@Data
public class PhoneDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private List<String> number;
	private People people;
	
	public PhoneDTO() {}
	
	public PhoneDTO(Phone obj) {
		id = obj.getId();
		number = obj.getNumber();
		people = obj.getPeople();
	}
	
}
