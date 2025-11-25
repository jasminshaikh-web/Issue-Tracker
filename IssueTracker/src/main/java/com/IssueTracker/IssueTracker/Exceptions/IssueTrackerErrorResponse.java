package com.IssueTracker.IssueTracker.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTrackerErrorResponse {

	private int statusCode;
	private String message;
	
//	private IssueTrackerErrorResponse(String message) {
//		super();
//		this.message = message;
//	}
	
	
	
	
}
