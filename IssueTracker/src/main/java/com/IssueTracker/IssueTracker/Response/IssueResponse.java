package com.IssueTracker.IssueTracker.Response;

import java.time.ZonedDateTime;

import com.IssueTracker.IssueTracker.Entity.PriorityLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueResponse {
	private Long id;
	private String name;
    private Long assigneeId;
    private Long reporterId;
    private String status;
    private Long storyPoint;
    private PriorityLevel priorityLevel;
    private Long createdById;
    private ZonedDateTime createdDate;
    private ZonedDateTime activatedDate;
    private ProjectResponse projectResponse;
}
