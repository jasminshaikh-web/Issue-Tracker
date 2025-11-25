package com.IssueTracker.IssueTracker.dozer;

import org.dozer.loader.api.BeanMappingBuilder;

import com.IssueTracker.IssueTracker.Entity.Project;
import com.IssueTracker.IssueTracker.Request.ProjectRequest;
import com.IssueTracker.IssueTracker.Response.ProjectResponse;

public class ProjectDozer extends BeanMappingBuilder{

	@Override
	protected void configure() {
		mapping(Project.class, ProjectResponse.class)
		.fields("createdBy.id", "createdBy")
		.fields("updatedBy.id", "updatedBy")
		.fields("team.id", "teamId");

		mapping(ProjectRequest.class, Project.class)
		.fields("createdBy","createdBy.id")
		.fields("updatedBy","updatedBy.id")
		.fields("teamId","team.id");

//		mapping(TeamMemberRequest.class,TeamMember.class)
//		.fields("teamId","teamId.id")
//		.fields("teamUsers","teamUsers",FieldsMappingOptions.customConverter(TeamUserCustomConverter.class));
//		
//		mapping(TeamUserRequest.class, Users.class)
//		.fields("name", "name")
//		.fields("email","email")
//		.fields("designation","designation");
	}

}
