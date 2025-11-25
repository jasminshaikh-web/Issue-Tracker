package com.IssueTracker.IssueTracker.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

	private Long id;
	private String name;
	private String description;
	private Long createdBy;
	private Long updatedBy;
	private Long teamId;
}
