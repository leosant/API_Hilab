package com.hilab.api_people.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.hilab.api_people.dto.PeopleDTO;
import com.hilab.api_people.model.Address;
import com.hilab.api_people.model.People;
import com.hilab.api_people.model.Phone;
import com.hilab.api_people.service.PeopleService;

@RestController
@RequestMapping(value ="/peoples")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping
	public ResponseEntity<List<PeopleDTO>> findAll() {
		List<People> list = peopleService.findAll();
		List<PeopleDTO> listDto = list.stream().map(x -> new PeopleDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PeopleDTO> findById(@PathVariable String id) {
		People obj = peopleService.findById(id);
		return ResponseEntity.ok().body(new PeopleDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PeopleDTO objDto) {
		People obj = peopleService.fromDto(objDto);
		obj = peopleService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		peopleService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody PeopleDTO objDto, @PathVariable String id) {
		People obj = peopleService.fromDto(objDto);
		obj.setId(id);
		obj = peopleService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/address")
	public ResponseEntity<Address> findAddress(@PathVariable String id) {
		People obj = peopleService.findById(id);
		return ResponseEntity.ok().body(obj.getAddress());
	}
	
	@GetMapping("/{id}/phones")
	public ResponseEntity<Phone> findPhone(@PathVariable String id) {
		People obj = peopleService.findById(id);
		return ResponseEntity.ok().body(obj.getPhone());
	}
}
