package com.accolite.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accolite.model.Opportunity;

@Repository
public class OpportunityRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/* For User */

	private final String CHECK_USER = "SELECT count(*) FROM googleuser WHERE id = ?";

	/* For opportunity */

	private final String GET_ALL = "SELECT * FROM opportunity";
	private final String INSERT_OPPORTUNITY = "INSERT INTO opportunity(opportunity_name,experience,hiring_manger,skill,creator,creator_email,job_location,joining_date,updated_date) values(?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_OPPORTUNITY = "UPDATE opportunity set opportunity_name=?,experience=?,hiring_manger=?,skill=?,creator=?,creator_email=?,job_location=?,joining_date=?,updated_date=? WHERE id=?";
	private final String DELETE_OPPORTUNITY = "DELETE FROM opportunity WHERE id = ?";

	/* For User */

	public boolean checkUser(String token) {
		if (jdbcTemplate.queryForObject(CHECK_USER, new Object[] { token }, Integer.class) > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* For opportunity */

	private RowMapper<Opportunity> rowMapper = (ResultSet rs, int rowNUM) -> {
		Opportunity o = new Opportunity();
		o.setId(rs.getInt(1));
		o.setopportunityName(rs.getString(2));
		o.setExperience(rs.getInt(3));
		o.sethiringManager(rs.getString(4));
		o.setSkill(rs.getString(5));
		o.setCreator(rs.getString(6));
		o.setcreatorEmail(rs.getString(7));
		o.setjobLocation(rs.getString(8));
		o.setjoiningDate(rs.getString(9));
		o.setupdatedDate(rs.getString(10));

		return o;
	};

	public List<Opportunity> findAll() {
		return jdbcTemplate.query(GET_ALL, rowMapper);
	}

	public boolean addOpportunity(Opportunity o) {
		if (jdbcTemplate.update(INSERT_OPPORTUNITY, o.getopportunityName(), o.getExperience(), o.gethiringManager(),
				o.getSkill(), o.getCreator(), o.getcreatorEmail(), o.getjobLocation(), o.getjoiningDate(),
				o.getupdatedDate()) > 0)
			return true;
		else {
			return false;
		}
	}

	public boolean updateOpportunity(Opportunity o) {
		if (jdbcTemplate.update(UPDATE_OPPORTUNITY, o.getopportunityName(), o.getExperience(), o.gethiringManager(),
				o.getSkill(), o.getCreator(), o.getcreatorEmail(), o.getjobLocation(), o.getjoiningDate(),
				o.getupdatedDate(), o.getId()) > 0)
			return true;
		else {
			return false;
		}
	}

	public boolean deleteOpportunity(int id) {
		if (jdbcTemplate.update(DELETE_OPPORTUNITY, id) > 0)
			return true;
		else {
			return false;
		}
	}

}
