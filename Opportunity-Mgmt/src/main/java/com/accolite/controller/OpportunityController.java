package com.accolite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.accolite.service.OpportunityService;

@RestController
@RequestMapping("/opportunity")
public class OpportunityController {

	@Autowired
	OpportunityService opportunityService;

	@GetMapping("/")
	public List<Opportunity> getAll(@RequestHeader("Authorization") String token) {

		if (opportunityService.checkUser(token)) {
			return opportunityService.getAll();
		}
		return null;
	}

	@PostMapping("/")
	public String addOpportunity(@RequestBody Opportunity o, @RequestHeader("Authorization") String token) {
		if (opportunityService.checkUser(token)) {
			return opportunityService.addOpportunity(o);
		}
		return "401 Unauthorized";
	}

	@PutMapping("/")
	public String updateOpportunity(@RequestBody Opportunity o, @RequestHeader("Authorization") String token) {
		if (opportunityService.checkUser(token)) {
			return opportunityService.upadateOpportunity(o);
		}

		return "401 Unauthorized";

	}

	@DeleteMapping("/{id}")
	public String deleteOpportunity(@PathVariable("id") int id, @RequestHeader("Authorization") String token)
			throws ResourceNotFoundException {

		if (opportunityService.checkUser(token)) {
			return opportunityService.deleteOpportunity(id);
		}
		return "401 Unauthorized";
	}

}
