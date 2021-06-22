package com.hilab.api_people.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilab.api_people.dto.PhoneDTO;
import com.hilab.api_people.model.Phone;
import com.hilab.api_people.repository.PhoneRepository;
import com.hilab.api_people.service.exception.ObjectNotFoundException;

@Service
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;
	
	public Phone findById(String id) {
		Optional<Phone> phone = phoneRepository.findById(id); 
		return phone.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
	}
	
	public Phone insert(Phone obj) {
		return phoneRepository.insert(obj);
	}
	
	public Phone fromDto(PhoneDTO obj) {
		return new Phone(obj.getId(), obj.getNumber());
	}
	
	public void delete(String id) {
		findById(id);
		phoneRepository.deleteById(id);
	}
	
	public Phone update(Phone obj) {
		Phone newObj = (Phone) findById(obj.getId());	
		updateData(newObj, obj);
		return phoneRepository.save(newObj);
	}
	
	private void updateData(Phone newObj, Phone obj) {
		newObj.setId(obj.getId());
		newObj.setNumber(obj.getNumber());
		newObj.setPeople(obj.getPeople());
	}
}
