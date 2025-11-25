package com.IssueTracker.IssueTracker.dozer;

import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;

import com.IssueTracker.IssueTracker.Entity.Issue;
import com.IssueTracker.IssueTracker.Request.IssueRequest;
import com.IssueTracker.IssueTracker.Response.IssueResponse;
public class IssueDozer extends BeanMappingBuilder {

	@Override
	protected void configure() {

		mapping(Issue.class, IssueResponse.class)
		.fields("assigneeId.id", "assigneeId")
		.fields("reporterId.id", "reporterId")
		.fields("status", "status")
		.fields("priorityLevel", "priorityLevel")
		.fields("createdBy.id", "createdById")
		.fields("createdDate", "createdDate",FieldsMappingOptions.copyByReference())
		.fields("activatedDate", "activatedDate",FieldsMappingOptions.copyByReference())
		.fields("projectId", "projectResponse");
		
		mapping(IssueRequest.class, Issue.class)
		.fields("assigneeId","assigneeId.id")
		.fields("reporterId","reporterId.id")
		.fields("status","status")
		.fields("storyPoint","storyPoint")
		.fields("priorityLevel","priorityLevel")
		.fields("createdById","createdBy.id")
		.fields("projectId", "projectId.id");	
		}
}
