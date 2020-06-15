package com.accolite.opportunity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accolite.model.Opportunity;
import com.accolite.repository.OpportunityRepository;

@SpringBootTest
public class OpportunityManagementDaoTest {

	@MockBean
	JdbcTemplate jdbcTemplate;

	@Autowired
	OpportunityRepository repository;

	@Test
	public void addOpportunityDaoTest() {

		Opportunity o = OpportunityManagementControllertest.addOpportunityforTest();

		Mockito.when(jdbcTemplate.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(1);

		repository.addOpportunity(o);
		verify(jdbcTemplate, times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString());

	}

	@Test
	public void updateOpportunityDAOTest() {

		Opportunity o = OpportunityManagementControllertest.updateOpportunityforTest();
		System.out.println(o);

		Mockito.when(jdbcTemplate.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(1);

		repository.updateOpportunity(o);
		verify(jdbcTemplate, times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyInt(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(), ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
	}

	@Test
	public void deleteopportunityTest() {
		Mockito.when(jdbcTemplate.update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt())).thenReturn(1);
		repository.deleteOpportunity(1);
		verify(jdbcTemplate, times(1)).update(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt());
	}

	@Test
	public void getAllOpportunitiesTest() {

		List<Opportunity> opportunityList = new ArrayList<>();
		opportunityList.add(new Opportunity(1, "java dev", 3, "surya", "java", "sridhar", "sridhar@gmail.com",
				"chennai", "02/may/2020", "05/apr/2020"));
		Mockito.when(jdbcTemplate.query(Mockito.anyString(), Mockito.any(RowMapper.class))).thenReturn(opportunityList);
		List<Opportunity> list = repository.findAll();
		assertEquals(opportunityList.size(), list.size());
	}

	@Test
	public void checkUser() {
		Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(), Mockito.anyObject(), Mockito.eq(Integer.class)))
				.thenReturn(1);
		String token = "12345";
		boolean ans = repository.checkUser(token);
		assertEquals(true, ans);
	}

}
