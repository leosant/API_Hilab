package com.hilab.api_people.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilab.api_people.dto.AddressDTO;
import com.hilab.api_people.model.Address;
import com.hilab.api_people.repository.AddressRepository;
import com.hilab.api_people.service.exception.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public Address findById(String id) {
		Optional<Address> address = addressRepository.findById(id); 
		return address.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public Address insert(Address obj) {
		return addressRepository.insert(obj);
	}
	
	public Address fromDto(AddressDTO obj) {
		return new Address(obj.getId(), obj.getType(), obj.getZipcode(), obj.getState(),
		obj.getCity(), obj.getStreet(), obj.getNumber(), obj.getComplement(), obj.getDistrict(), obj.getPeople());
	}
	
	public void delete(String id) {
		findById(id);
		addressRepository.deleteById(id);
	}
	
	public Address update(Address obj) {
		Address newObj = findById(obj.getId());	
		updateData(newObj, obj);
		return addressRepository.save(newObj);
	}
	
	private void updateData(Address newObj, Address obj) {
		newObj.setType(obj.getType());
		newObj.setZipcode(obj.getZipcode());
		newObj.setState(obj.getState());
		newObj.setCity(obj.getCity());
		newObj.setStreet(obj.getStreet());
		newObj.setNumber(obj.getNumber());
		newObj.setComplement(obj.getComplement());
		newObj.setDistrict(obj.getDistrict());
		newObj.setPeople(obj.getPeople());
	}
}
