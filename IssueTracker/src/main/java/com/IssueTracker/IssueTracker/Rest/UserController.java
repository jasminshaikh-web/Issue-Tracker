package com.IssueTracker.IssueTracker.Rest;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IssueTracker.IssueTracker.Request.TeamUserRequest;
import com.IssueTracker.IssueTracker.service.ProjectService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	ProjectService projectService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUsera(@RequestBody TeamUserRequest teamUserRequest) throws SQLException{
		 projectService.addUsers(teamUserRequest);
		return new ResponseEntity<>(HttpStatus.OK) ;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long Id){
		return null;
		
	}

}
