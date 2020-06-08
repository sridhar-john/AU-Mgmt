package com.accolite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.exception.ResourceNotFoundException;
import com.accolite.model.Opportunity;
import com.accolite.service.Opportunityservice;

@RestController
@RequestMapping("/opportunity")
@CrossOrigin(origins = "http://localhost:4200")
public class Opportunitycontroller {

	@Autowired
	Opportunityservice opportunityService;
	
/* For  User */

	
    @GetMapping("/users")
	String checkUser(@RequestHeader("Authorization") String token)
	{
			return opportunityService.checkUser(token);
	}

	/* For  Opportunity */

	
	@GetMapping("/")
	public List<Opportunity> getAll(@RequestHeader("Authorization") String token)
	{
		
		if(opportunityService.checkUser(token)=="Login sucessfull and User is Authenticated")
		{
				return opportunityService.getAll();
		}
		return null;
	}
	
	@PostMapping("/")
	public String addEmployee(@RequestBody Opportunity o,@RequestHeader("Authorization") String token)
	{
		if(opportunityService.checkUser(token)=="Login sucessfull and User is Authenticated")
		{
			return opportunityService.addOpportunity(o);
		}
		return "User is Not authenticated please login!";
	}
	
	@PutMapping("/")
	public String updateEmployee(@RequestBody Opportunity o,@RequestHeader("Authorization") String token)
	{
		if(opportunityService.checkUser(token)=="Login sucessfull and User is Authenticated")
		{
			return opportunityService.upadateOpportunity(o);
		}
		return "User is Not authenticated please login!";
		
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id,@RequestHeader("Authorization") String token) throws ResourceNotFoundException
	{
		
		if(opportunityService.checkUser(token)=="Login sucessfull and User is Authenticated")
		{
			return opportunityService.deleteOpportunity(id);
		}
		return "User is Not authenticated please login!";
	}


}
