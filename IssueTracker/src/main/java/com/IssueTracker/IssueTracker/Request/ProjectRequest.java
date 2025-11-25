package com.IssueTracker.IssueTracker.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequest {
	private String name;
    private String description;
    private Long createdBy;
    private Long updatedBy;
    private Long teamId;
}
