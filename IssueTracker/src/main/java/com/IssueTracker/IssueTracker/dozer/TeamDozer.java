package com.IssueTracker.IssueTracker.dozer;

import org.dozer.loader.api.BeanMappingBuilder;

import com.IssueTracker.IssueTracker.Entity.Users;
import com.IssueTracker.IssueTracker.Request.TeamUserRequest;

public class TeamDozer extends BeanMappingBuilder{

	@Override
	protected void configure() {
//		mapping(TeamMemberRequest.class, TeamMember.class)
//		.fields("teamId","teamId.id")
//		.fields("teamUsers","teamUsers",FieldsMappingOptions.customConverter(TeamUserCustomConverter.class));
//		
		mapping(TeamUserRequest.class, Users.class)
		.fields("name", "name")
		.fields("email","email")
		.fields("designation","designation");
		
	}

}
