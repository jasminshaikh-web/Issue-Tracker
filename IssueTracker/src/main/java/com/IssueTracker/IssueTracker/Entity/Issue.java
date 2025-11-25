package com.IssueTracker.IssueTracker.Entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name="issue",schema = "issue")
@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="assignee_id",referencedColumnName = "id")
	private Users assigneeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reporter_id",referencedColumnName = "id")
	private Users reporterId;
	
	@Enumerated(EnumType.STRING)
	private Status Status;
	
	@Column(name="story_point")
	private Long storyPoint;
	
	@Column(name="priority_level")
	@Enumerated(EnumType.STRING)
	private PriorityLevel priorityLevel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="created_by",referencedColumnName = "id")
	private Users createdBy;
	
	@Column(name="created_date")
	private ZonedDateTime createdDate;
	
	@Column(name="activated_date")
	private ZonedDateTime activatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="project_id")
	private Project projectId;

	public enum Status {
	   New,
	   Active,
	   Blocked,
	   Closed,
	   Resolved,
	   Removed;
	}
}