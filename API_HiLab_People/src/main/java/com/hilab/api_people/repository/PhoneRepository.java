package com.hilab.api_people.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hilab.api_people.model.Phone;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String>{

}
