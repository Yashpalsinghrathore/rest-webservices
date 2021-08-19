package com.restweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restweb.entity.Person;

public interface HomeDao extends JpaRepository<Person,Integer> {

	@Query("SELECT p FROM Person p WHERE p.name = :personname")
	 Person findByPersonname(@Param("personname")String personname);
}
