package com.issue.tracker.issue.tracker.Response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import com.issue.tracker.issue.tracker.Entity.Issue;
import com.issue.tracker.issue.tracker.Entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponse {
	private Long id;
	private String name;
	private String description;
	private String createdBy;
	private LocalDateTime createdAt;
//	private List<UsersResponse> users;
	private List<IssueResponse> issues;
}
