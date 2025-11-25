package com.issue.tracker.issue.tracker.Service;

import java.util.Optional;

import com.issue.tracker.issue.tracker.Response.IssueResponse;
import com.issue.tracker.issue.tracker.Response.ProjectResponse;
import com.issue.tracker.issue.tracker.request.CreateIssueRequest;
import com.issue.tracker.issue.tracker.request.UpdateIssueRequest;

public interface IssueServices{
	    IssueResponse createIssue(CreateIssueRequest request);
	    IssueResponse getIssues(Long id);
	    ProjectResponse getProject(Long id);
	    IssueResponse updateIssue(Long id, UpdateIssueRequest updateIssueRequest);
	}

