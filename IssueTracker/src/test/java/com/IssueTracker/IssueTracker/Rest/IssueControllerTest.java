package com.IssueTracker.IssueTracker.Rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.IssueTracker.IssueTracker.Entity.PriorityLevel;
import com.IssueTracker.IssueTracker.Request.IssueRequest;
import com.IssueTracker.IssueTracker.service.IssueService;

@WebMvcTest(IssueController.class)
@ActiveProfiles(profiles="test")
public class IssueControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Mock
	private IssueService issueService;
	
	@BeforeEach
	void setup() {
		this.mockMvc=MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	void saveIssue_shouldSaveIssue() {
		
		//Given 
		IssueRequest issueRequest=IssueRequest.builder()
								.name("Get API")
								.assigneeId(1L)
								.reporterId(1L)
								.status("Active")
								.storyPoint(1L)
								.priorityLevel(PriorityLevel.High)
								.createdById(1L)
								.projectId(1L)
								.build();
		//When
//		when(issueService.addIssues(any(IssueRequest.class))).the;
//        when(issueService.addIssues(issueRequest));

		
	}
	
}