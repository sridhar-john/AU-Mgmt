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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.exception.ResourceNotFoundException;
import com.accolite.model.Opportunity;
import com.accolite.service.Opportunityservice;

@RestController
@RequestMapping("/opportunity")
public class Opportunitycontroller {

	@Autowired
	Opportunityservice opportunityService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/")
	public List<Opportunity> getAll()
	{
		return opportunityService.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public String addEmployee(@RequestBody Opportunity o)
	{
		return opportunityService.addOpportunity(o);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/")
	public String updateEmployee(@RequestBody Opportunity o)
	{
		return opportunityService.upadateOpportunity(o);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable("id") int id) throws ResourceNotFoundException
	{
		return opportunityService.deleteOpportunity(id);
	}


}
