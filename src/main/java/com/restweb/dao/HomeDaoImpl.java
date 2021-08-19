package com.restweb.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.restweb.entity.Person;

@Component(value = "pp")
@Primary
public class HomeDaoImpl  implements  UserDetailsService {

	@Autowired
	HomeDao homeDao;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person user = homeDao.findByPersonname(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), getAuthority());
	}
	
	
	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	
	public Person findOne(String username) {
		return homeDao.findByPersonname(username);
	}
	
	public void savePerson(Person p) {
		
		p.setPassword(bcryptEncoder.encode(p.getPassword()));
		
		homeDao.save(p);
		
		System.out.println("person saved successfully");
		
	}

	public Person getPersonById(int id) {
		
		Person byId = homeDao.getById(id);
		
		return byId;
	}

	public void editPerson(Person person) {
		
		person.setPassword(bcryptEncoder.encode(person.getPassword()));
		
		homeDao.save(person);
		
		
	}

	public void deletePersonById(int id) {
		
		homeDao.deleteById(id);
		
		
	}

	public List<Person> getPerson() {
		
		System.out.println("inside repo");
		
		return  homeDao.findAll();
		
}

}
