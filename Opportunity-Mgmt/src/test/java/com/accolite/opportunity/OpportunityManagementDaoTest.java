package com.accolite.opportunity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import com.accolite.model.Opportunity;
import com.accolite.repository.Opportunityrepository;

@SpringBootTest
public class OpportunityManagementDaoTest {

	
	@MockBean
	JdbcTemplate jdbcTemplate;

	@Autowired
	Opportunityrepository repository;
	

	

	
	@Test
	public void addOpportunityDaoTest() {
		Opportunity emp = new Opportunity();
		//emp.setId(1);
		emp.setOpportunity_name("java dev");
		emp.setExperience(3);
		emp.setHiring_manager("surya");
		emp.setSkill("java");
		emp.setCreator("sridhar");
		emp.setCreator_email("sridhar@gmail.com");
		emp.setJob_location("chennai");
		emp.setJoining_date("25/may/2020");
		emp.setUpdated_date("2/apr/2020");
		
		System.out.println(emp);
		
		Mockito.when(
				jdbcTemplate.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(),
						ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
						ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString()))
				.thenReturn(1);

		repository.addOpportunity(emp);
		verify(jdbcTemplate, times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString());

	}

	@Test
	public void updateOpportunityDAOTest() {
		Opportunity emp = new Opportunity();
		emp.setId(1);
		emp.setOpportunity_name("java dev");
		emp.setExperience(3);
		emp.setHiring_manager("surya");
		emp.setSkill("java");
		emp.setCreator("sridhar");
		emp.setCreator_email("sridhar@gmail.com");
		emp.setJob_location("chennai");
		emp.setJoining_date("25/may/2020");
		emp.setUpdated_date("2/apr/2020");

		System.out.println(emp);

		Mockito.when(jdbcTemplate.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt()))
		.thenReturn(1);

		repository.updateOpportunity(emp);
		verify(jdbcTemplate, times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
	}
	
	@Test
	public void deleteopportunityTest()
	{
		Mockito.when(jdbcTemplate.update(ArgumentMatchers.anyString(),ArgumentMatchers.anyInt())).thenReturn(1);
		repository.deleteOpportunity(1);
		verify(jdbcTemplate,times(1)).update(ArgumentMatchers.anyString(),ArgumentMatchers.anyInt());
	}
	
	
}
