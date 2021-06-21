package com.hilab.api_people.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hilab.api_people.model.Address;
import com.hilab.api_people.service.AddressService;

@RestController
@RequestMapping(value ="/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Address> findById(@PathVariable String id) {
		Address obj = addressService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}