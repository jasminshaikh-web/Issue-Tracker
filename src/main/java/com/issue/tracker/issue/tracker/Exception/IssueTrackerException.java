package com.issue.tracker.issue.tracker.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueTrackerException {
	private int stausCode;
	private String message;
	
	public IssueTrackerException(String message) {
		super();
		this.message=message;
	}

}
