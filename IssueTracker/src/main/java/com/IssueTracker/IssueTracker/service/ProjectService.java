package com.IssueTracker.IssueTracker.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.IssueTracker.IssueTracker.Entity.Project;
import com.IssueTracker.IssueTracker.Entity.Team;
import com.IssueTracker.IssueTracker.Entity.TeamMember;
import com.IssueTracker.IssueTracker.Entity.Users;
import com.IssueTracker.IssueTracker.Request.ProjectRequest;
import com.IssueTracker.IssueTracker.Request.TeamRequest;
import com.IssueTracker.IssueTracker.Request.TeamUserRequest;
import com.IssueTracker.IssueTracker.Response.ProjectResponse;
import com.IssueTracker.IssueTracker.repository.ProjectRepository;
import com.IssueTracker.IssueTracker.repository.TeamMemberRepository;
import com.IssueTracker.IssueTracker.repository.TeamRepository;
import com.IssueTracker.IssueTracker.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private TeamMemberRepository memberRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	private final DozerBeanMapper beanMapper;

	
	

	public ProjectService(ProjectRepository projectRepository, TeamRepository teamRepository,
			TeamMemberRepository memberRepository, UsersRepository usersRepository, DozerBeanMapper beanMapper) {
		super();
		this.projectRepository = projectRepository;
		this.teamRepository = teamRepository;
		this.memberRepository = memberRepository;
		this.usersRepository = usersRepository;
		this.beanMapper = beanMapper;
	}

	/*
	 * Method to get project details based on id 
	 */
	public ProjectResponse getProject(Long id) {
	 	Optional<Project> project= projectRepository.findById(id);
	 	
		return beanMapper.map(project.get(), ProjectResponse.class);
	}
	
	/*
	 * Method will save project info
	 */
	public void addProject(ProjectRequest projectRequest) throws SQLException {
		
		Project project=beanMapper.map(projectRequest, Project.class);
//		if(teamRepository.findById(projectRequest.getTeamId()) == null) {
//			TeamMember teamMember=TeamMember.builder()
//								.team(null)
//		}
		try {
			projectRepository.save(project);
		}catch (Exception e) {
			Throwable throwable=e.getCause();
			if(throwable instanceof SQLException) {
				throw new SQLException(e.getMessage());
			}
		}
	}
	@Transactional
	public Team addTeam(TeamRequest teamRequest) {
		List<Users> users=usersRepository.findAllById(teamRequest.getTeamUsers());
		Team team=Team.builder()
				.name(teamRequest.getTeamName())
				.users(users)
				.build();
//		Team team=new Team(null, teamName);
//		teamRepository.save(team);
		return teamRepository.save(team);
	}
//
//	public void addTeamMembers(TeamMemberRequest teamMemberRequest) {
////		List<Users> list = new ArrayList<Users>();
////		list.forEach(tr->list.add(Users.builder()
////				.name(tr.getName())
////				.designation(tr.getDesignation())
////				.email(tr.getEmail())
////				.build()));
//		
//		TeamMember teamMember=TeamMember.builder()
//							.teamId(Team.builder().id(teamMemberRequest.getTeamId()).build())
//							.teamUsers(teamMemberRequest.getTeamUsers())
//							.build();
//							
//		try {
//			memberRepository.save(teamMember);
//		} catch (Exception e) {
//		Throwable throwable=e.getCause();
//		if(throwable instanceof SQLException) {
//			throw new IssueTrackerException("Having issue while saving team members data");
//		}
//		}
//	}
	
	public void addUsers(TeamUserRequest teamUserRequest) throws SQLException {
		Users users=beanMapper.map(teamUserRequest, Users.class);
		try {
			usersRepository.save(users);
		}catch (Exception e) {
			Throwable throwable=e.getCause();
			if(throwable instanceof SQLException) {
				throw new SQLException(e.getMessage());
			}
		}
	}

}
