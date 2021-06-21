package com.hilab.api_people.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hilab.api_people.model.Address;
import com.hilab.api_people.repository.AddressRepository;
import com.hilab.api_people.service.exception.ObjectNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public Address findById(String id) {
		Optional<Address> obj = addressRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
