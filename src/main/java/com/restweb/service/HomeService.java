package com.restweb.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restweb.controller.ws.HomeController;
import com.restweb.dao.HomeDaoImpl;
import com.restweb.entity.Person;

@Service
public class HomeService {


	public static Logger log = Logger.getLogger(HomeController.class);
	
	@Autowired
	HomeDaoImpl homeDaoImpl;
	
	public void savePerson(Person p) {
		
		homeDaoImpl.savePerson(p);
		
	}

	public Person getPersonById(int id) {
		
		log.info("inside gerPersonBy Id service method");
		
		Person personById = homeDaoImpl.getPersonById(id);
		
		return personById;
	}

	
	public void editPerson(Person person) {
		
		homeDaoImpl.editPerson(person);
		
	}

	public void deletePersonById(int id) {
		
		homeDaoImpl.deletePersonById(id);
		
	}

	public List<Person> getPerson() {
		
		System.out.println("inside service");
		
		 List<Person> l = homeDaoImpl.getPerson();
		 
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return l;
		
	}

}
