package com.issue.tracker.issue.tracker.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.issue.tracker.issue.tracker.Response.IssueResponse;
import com.issue.tracker.issue.tracker.Response.ProjectResponse;
import com.issue.tracker.issue.tracker.Service.IssueServiceImpl;
import com.issue.tracker.issue.tracker.request.CreateIssueRequest;
import com.issue.tracker.issue.tracker.request.UpdateIssueRequest;

		@RestController
		@RequestMapping("/api/issues")
		public class IssueController {

		    @Autowired
		    IssueServiceImpl impl;

		    @PostMapping("/save")
		    public ResponseEntity<IssueResponse> createIssue(@RequestBody CreateIssueRequest request) {
		        IssueResponse response = impl.createIssue(request);
		        return ResponseEntity.status(HttpStatus.CREATED).body(response);
		    }
		    
		    @GetMapping("/{id}")
		    public ResponseEntity<IssueResponse> getIssue(@PathVariable Long id) {
		        IssueResponse response =  impl.getIssues(id);
		        return ResponseEntity.status(HttpStatus.OK).body(response);
		    }
		    
		    @GetMapping("project/{projectId}/issues")
		    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long projectId){
		    	ProjectResponse projectResponse =impl.getProject(projectId);
		    	return ResponseEntity.status(HttpStatus.OK).body(projectResponse);
		    			
		    }
		    @PutMapping("/{id}")
		    public ResponseEntity<IssueResponse> updateIssue(@PathVariable Long id,@RequestBody UpdateIssueRequest updateIssueRequest ){
		    	IssueResponse issueResponse =impl.updateIssue(id,updateIssueRequest);
		    	return ResponseEntity.status(HttpStatus.OK).body(issueResponse);
		    			
		    }

		    // You can add other endpoints like GET, PUT, DELETE here
		
}
