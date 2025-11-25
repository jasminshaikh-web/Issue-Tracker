package com.IssueTracker.IssueTracker.Entity;

import lombok.Getter;

@Getter
public enum PriorityLevel {
	High("High"),
	   Low("Low"),
	   Medium("Medium"),
	   Critical("Critical");
	private final String priorityLevel;

	private PriorityLevel(String priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	
}
