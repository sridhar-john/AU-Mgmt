package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.service.OpportunityService;

@RestController
@RequestMapping("/opportunity")
public class UserController {

	@Autowired
	OpportunityService opportunityService;

	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity<String> checkUser(@RequestHeader("Authorization") String token) {
		HttpStatus httpstatus = null;
		if (opportunityService.checkUser(token)) {
			httpstatus = HttpStatus.OK;
		} else {
			httpstatus = HttpStatus.NOT_FOUND;

		}

		ResponseEntity<String> responseEntity = new ResponseEntity<String>("200 ok", httpstatus);

		return responseEntity;

	}

}
