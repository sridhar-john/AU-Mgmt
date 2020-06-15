package com.accolite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.exception.ResourceNotFoundException;
import com.accolite.model.Opportunity;
import com.accolite.repository.OpportunityRepository;

@Service
public class OpportunityService {

	@Autowired
	OpportunityRepository opportunityRepository;

	/* For Opportunity */
	public List<Opportunity> getAll() {
		return opportunityRepository.findAll();

	}

	public String addOpportunity(Opportunity o) {
		String responseString;
		if (opportunityRepository.addOpportunity(o))
			responseString = "Inserted SucessFully";
		else {
			responseString = "Somthing went wrong not added,please try again";
		}

		return responseString;

	}

	public String upadateOpportunity(Opportunity o) {
		String responseString;
		if (opportunityRepository.updateOpportunity(o))
			responseString = "Updated SucessFully";
		else {
			responseString = "Somthing went wrong not updated,please try again";
		}

		return responseString;
	}

	public String deleteOpportunity(int id) throws ResourceNotFoundException {
		if (opportunityRepository.deleteOpportunity(id))
			return "Deleted SucessFully";
		throw new ResourceNotFoundException("Somthing went wrong not Deleted,please try again");
	}

	/* for User */
	public boolean checkUser(String token) {

		if (opportunityRepository.checkUser(token))
			return true;
		else {
			return false;
		}

	}
}
