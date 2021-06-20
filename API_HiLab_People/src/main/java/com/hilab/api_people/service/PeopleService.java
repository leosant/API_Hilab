package com.hilab.api_people.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilab.api_people.dto.PeopleDTO;
import com.hilab.api_people.model.People;
import com.hilab.api_people.repository.PeopleRepository;
import com.hilab.api_people.service.exception.ObjectNotFoundException;

@Service
public class PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	public List<People> findAll() {
		return peopleRepository.findAll();
	}
	
	public People findById(String id) {
		Optional<People> people = peopleRepository.findById(id); 
		return people.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public People insert(People obj) {
		return peopleRepository.insert(obj);
	}
	
	public People fromDto(PeopleDTO obj) {
		return new People(obj.getId(), obj.getStatus(), obj.getGivenName(), 
				obj.getFamilyName(), obj.getBirthDate());
	}
	
	public void delete(String id) {
		findById(id);
		peopleRepository.deleteById(id);
	}
	
	public People update(People obj) {
		People newObj = findById(obj.getId());	
		updateData(newObj, obj);
		return peopleRepository.save(newObj);
	}
	
	private void updateData(People newObj, People obj) {
		newObj.setStatus(obj.getStatus());
		newObj.setGivenName(obj.getGivenName());
		newObj.setFamilyName(obj.getFamilyName());
		newObj.setBirthDate(obj.getBirthDate());		
	}
}
