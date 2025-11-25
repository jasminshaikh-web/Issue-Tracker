package com.IssueTracker.IssueTracker.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="team",schema = "Issue")
@Entity
@Builder
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name="team_users",
			schema="issue",
			joinColumns = @JoinColumn(name="team_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<Users> users;

	
//	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<TeamMember> members;
}
