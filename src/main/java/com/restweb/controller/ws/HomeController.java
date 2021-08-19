package com.restweb.controller.ws;

import java.util.List;
import io.swagger.annotations.Authorization;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restweb.entity.Person;
import com.restweb.service.HomeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/person")
@Api(value="/person",tags="Person Management")
public class HomeController {

	public static Logger log = Logger.getLogger(HomeController.class);
	
	 
	@Autowired
	HomeService homeService;
	
	
	
	@GetMapping("/getPersonById/{id}")
	//@ApiOperation(value ="get single person object by id")
	@ApiOperation(value = "get single person object by id", authorizations = { @Authorization(value="jwtToken") })
	public Person getPerson(@PathVariable int id)
	{	
	
		System.out.println("gerPersonById");
		
		log.debug("inside getPersonById method");
		
		Person personById = homeService.getPersonById(id);
		
		return personById;
		
	}
	
	/*
	 * @ApiOperation(value ="get list of person",notes =
	 * "will get list of all person object",tags = {"Person Management"})
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200,message = "Successfully retrieved list"),
	 * 
	 * @ApiResponse(code = 401, message =
	 * "You are not authorized to view the resource"),
	 * 
	 * @ApiResponse(code = 403, message =
	 * "Accessing the resource you were trying to reach is forbidden"),
	 * 
	 * @ApiResponse(code = 404, message =
	 * "The resource you were trying to reach is not found")
	 * 
	 * 
	 * 
	 * })
	 */
	@GetMapping("/getPerson")
	@ApiOperation(value = "get list of person", authorizations = { @Authorization(value="jwtToken") })
	public List<Person> getPerson()
	{
		System.out.println("inside controller");
		
		return homeService.getPerson();
		
		
		
	}
	
	@PostMapping("/savePerson")
	//@ApiOperation(value ="create new person object and save")
	@ApiOperation(value = "create new person object and save", authorizations = { @Authorization(value="jwtToken") })
	public void savePerson(@RequestBody Person person)
	{
		
		System.out.println("home controller");
		
		homeService.savePerson(person);
		
		
		
	}
	
	@PutMapping("/editPerson")
	//@ApiOperation(value ="update the person object")
	@ApiOperation(value = "update the person object", authorizations = { @Authorization(value="jwtToken") })
	public void editPerson(@RequestBody Person person)
	{
		
		
		
		homeService.editPerson(person);
		
		
	}
	
	@DeleteMapping("/deletePersonById/{id}")
	//@ApiOperation(value ="delete person object by id")
	@ApiOperation(value = "delete person object by id", authorizations = { @Authorization(value="jwtToken") })
	public void deletePerson(@PathVariable("id") int id)
	{
		
		homeService.deletePersonById(id);
	
		System.out.println("deleted successflly");
	}
	
	
	
}
