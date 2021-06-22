package com.hilab.api_people.dto;

import java.io.Serializable;

import com.hilab.api_people.model.Address;
import com.hilab.api_people.model.People;
import com.hilab.api_people.model.util.Type;

import lombok.Data;

@Data
public class AddressDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
	
	public AddressDTO() {}
	
	public AddressDTO(Address obj) {
		id = obj.getId();
		type = obj.getType();
		zipcode = obj.getZipcode();
		state = obj.getState();
		city = obj.getCity();
		street = obj.getStreet();
		number = obj.getNumber();
		complement = obj.getComplement();
		district = obj.getDistrict();
		people = obj.getPeople();
	}
	
}
