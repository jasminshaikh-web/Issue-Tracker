package com.IssueTracker.IssueTracker.Request;

import com.IssueTracker.IssueTracker.Entity.PriorityLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueRequest {

	private String name;
    private Long assigneeId;
    private Long reporterId;
    private String status;
    private Long storyPoint;
    private PriorityLevel priorityLevel;
    private Long createdById;
//    private date createdDate;
//    private Date activatedDate;
    private Long projectId;
}
