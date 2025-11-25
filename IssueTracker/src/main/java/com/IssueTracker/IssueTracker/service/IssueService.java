package com.IssueTracker.IssueTracker.service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IssueTracker.IssueTracker.Entity.Issue;
import com.IssueTracker.IssueTracker.Entity.Issue.Status;
import com.IssueTracker.IssueTracker.Exceptions.IssueTrackerException;
import com.IssueTracker.IssueTracker.Exceptions.UserNotFoundException;
import com.IssueTracker.IssueTracker.Request.IssueRequest;
import com.IssueTracker.IssueTracker.Response.IssueResponse;
import com.IssueTracker.IssueTracker.repository.IssueRepository;
import com.IssueTracker.IssueTracker.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	@Autowired
	private UsersRepository userRepository;
	
	
	private final DozerBeanMapper dozerMapper;
	

	public IssueService(IssueRepository issueRepository, UsersRepository userRepository,
			 DozerBeanMapper dozerMapper) {
		super();
		this.issueRepository = issueRepository;
		this.userRepository = userRepository;
		this.dozerMapper=dozerMapper;
	}


	public void addIssues(IssueRequest issueRequest) {
		userRepository.findById(issueRequest.getAssigneeId()).orElseThrow(()->new UserNotFoundException("Unknow Assigneed user with ID "+issueRequest.getAssigneeId()));
		userRepository.findById(issueRequest.getReporterId()).orElseThrow(()->new UserNotFoundException("Unknow Reporter user with ID "+issueRequest.getReporterId()));
		userRepository.findById(issueRequest.getCreatedById()).orElseThrow(()->new UserNotFoundException("Unknow CreatedBy user with ID "+issueRequest.getCreatedById()));
//		if(issueRequest.getStatus().equalsIgnoreCase(Status))
//		Status status = null;
		try {
//		Status status=Status.valueOf(issueRequest.getStatus());
		}catch (IllegalArgumentException  e) {
			throw new IssueTrackerException("Invalid Stauts: "+issueRequest.getStatus());
		}
		Issue issue=dozerMapper.map(issueRequest, Issue.class);
		issue.setCreatedDate(ZonedDateTime.now());
		issue.setActivatedDate(ZonedDateTime.now());
		try {
			issueRepository.save(issue);		

		} catch (Exception e) {
			Throwable cause = e.getCause();
			if(cause instanceof SQLException) {
				throw new IssueTrackerException("Issue already exsist");
			}else {
				throw new InvalidParameterException(cause.toString());
			}
		}
		
	}

	@Transactional
	public IssueResponse getIssue(Long Id) {
		Optional<Issue> issue=Optional.of(issueRepository.findById(Id).orElseThrow(()->new IssueTrackerException("No Data found for ID:-"+Id)));
		
//		if(issue==null) {
//			throw 
//		}
		IssueResponse issueResponse;
		issueResponse= dozerMapper.map(issue.get(), IssueResponse.class);
		 return issueResponse;
	}


	public List<IssueResponse> getData() {
		List<Issue> Response = issueRepository.findAll();
		return Response.stream().map(response->dozerMapper.map(Response, IssueResponse.class))
				.toList();
		
//		String[] inputData= {"hello","Name","Bike","Book","Smart","hike","hetch"};
//		
//		//Two way to check String Start with character 
//		//1. startsWith() method 
//		//2. chartAt() method
//		Predicate<String> predicate=s->s.startsWith("B");
//		Predicate<String> predicateStartWithR=s->s.contains("o");
////				s->s.charAt(0)=='h';
//
//		List<String> list=new ArrayList<>();
//		
//		for(String s:inputData) {
//			if(predicateStartWithR.test(s)) {
//				list.add(s);
//			}
//		}
//		
//		String input="programming";
//		
//		Map<Character, Long> list=input.chars()
//								.mapToObj(c-> (char)c)
//								.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		
//		return list.entrySet().stream().filter(entry->entry.getValue()>1)
//								.forEach(entry->System.out.println("Repeate values"+entry.getKey()+""+entry.getValue()));
////		return list;	
	}
}
