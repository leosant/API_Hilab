	package com.hilab.api_people.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.hilab.api_people.model.Address;
import com.hilab.api_people.model.People;
import com.hilab.api_people.model.Phone;
import com.hilab.api_people.model.util.Status;
import com.hilab.api_people.model.util.Type;
import com.hilab.api_people.repository.AddressRepository;
import com.hilab.api_people.repository.PeopleRepository;
import com.hilab.api_people.repository.PhoneRepository;

@Configuration
public class Instatiation implements CommandLineRunner{
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PhoneRepository phoneRepository;

	@Override
	public void run(String... args) throws Exception {
		
		 SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		 formatDate.setTimeZone(TimeZone.getTimeZone("GMT"));
		 
		 peopleRepository.deleteAll();
		 addressRepository.deleteAll();
		 phoneRepository.deleteAll();
		 
		 People leonardo = new People(null, Status.ACTIVE, "Leonardo", "Santos", formatDate.parse("20/03/1996"));
		 People lucas = new People(null, Status.INACTIVE, "Lucas", "Montano", formatDate.parse("08/10/1990"));
		 People maria = new People(null, Status.ACTIVE, "Maria", "Brow", formatDate.parse("28/02/1998"));
		 
		 peopleRepository.saveAll(Arrays.asList(leonardo, lucas, maria));
		 
		 Address adLeo = new Address(null, Type.DELIVERY, (long) 71722745, "Distrito Federal", "Ceilândia", "CNM",
				 15, "Casa", "Distrito ferdeal", leonardo);
		 
		 Phone phoneLeo = new Phone(null, Arrays.asList("6198562312"));
		 
		 addressRepository.save(adLeo);
		 phoneRepository.save(phoneLeo);
		 
		 leonardo.setAddress(adLeo);
		 leonardo.setPhone(phoneLeo);
		 
		 peopleRepository.save(leonardo);
		 
	}

}
