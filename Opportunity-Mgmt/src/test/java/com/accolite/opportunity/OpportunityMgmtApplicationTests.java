package com.accolite.opportunity;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.exception.ResourceNotFoundException;
import com.accolite.model.Opportunity;
import com.accolite.repository.OpportunityRepository;
import com.accolite.service.OpportunityService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpportunityManagementApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	@Autowired
	private OpportunityService service;
	
	@MockBean
	private OpportunityRepository repository;
	
	@Test
	public void getAllTest()
	{
		 when(repository.findAll()).thenReturn(Stream
				.of(new Opportunity(2,"java dev",3,"john","java","suresh","ram@gmail.com","banglore","01/06/20","23/05/20"),new Opportunity(18,"java dev",0,"john","java","jp","jp@gmail.com","0","10/Jul/2020","25/Jun/2020")).collect(Collectors.toList()));
	
		assertEquals(2,service.getAll().size());
	}
	@Test
	public void deleteOpportunityTest() {
	
	when(repository.deleteOpportunity(2)).thenReturn(true);
	try {
		service.deleteOpportunity(2);
		
	} catch (ResourceNotFoundException e) {
		fail("Unexpected exception: " + e);
	}
	verify(repository,times(1)).deleteOpportunity(2);
	
}
	@Test
	public void addOpportunitryTest()
	{
		Opportunity o = new Opportunity(2,"java dev",3,"john","java","suresh","ram@gmail.com","banglore","01/06/20","23/05/20");
		when(repository.addOpportunity(o)).thenReturn(true);
		assertEquals("Inserted SucessFully",service.addOpportunity(o));

	}

	@Test
	public void updateOpportunityTest() {
		Opportunity o = new Opportunity(2,"java dev",3,"john","java","suresh","ram@gmail.com","banglore","01/06/20","23/05/20");
	when(repository.updateOpportunity(o)).thenReturn(true);
	assertEquals("Updated SucessFully",service.upadateOpportunity(o));
	}
	
	
	@Test
	public void checkUserTest() {
		String token = "112535508737671762177";

		when(repository.checkUser(token)).thenReturn(true);
		assertEquals("Login sucessfull and User is Authenticated", service.checkUser(token));
	}

}
