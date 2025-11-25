package com.issue.tracker.issue.tracker.request;

import java.time.LocalDate;
import java.util.Set;

import org.antlr.v4.runtime.misc.NotNull;

import com.issue.tracker.issue.tracker.Entity.Issue.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public class CreateIssueRequest {

		@NonNull
	    private String title;

	    private String description;

	    @NonNull
	    private Long projectId;

	    @NonNull
	    private Long statusId;

	    @NonNull
	    private Long assigneeId;

	    @NonNull
	    private Long reporterId;

	    @NonNull
	    private Priority priority;

	    private LocalDate dueDate;

	    private Set<Long> labelIds;  // optional
	}

