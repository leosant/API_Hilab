package com.hilab.api_people.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hilab.api_people.dto.AddressDTO;
import com.hilab.api_people.model.Address;
import com.hilab.api_people.service.AddressService;

@RestController
@RequestMapping(value ="/phones")
public class PhoneController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressDTO> findById(@PathVariable String id) {
		Address obj = addressService.findById(id);
		return ResponseEntity.ok().body(new AddressDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody AddressDTO objDto) {
		Address obj = addressService.fromDto(objDto);
		obj = addressService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		addressService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody AddressDTO objDto, @PathVariable String id) {
		Address obj = addressService.fromDto(objDto);
		obj.setId(id);
		obj = addressService.update(obj);
		return ResponseEntity.noContent().build();
	}
}
