package com.qa.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String teamName;
	Double teamRank;
	
	public Team() {
		super();
	}
	
	public Team(Long id, String teamName, Double teamRank) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamRank = teamRank;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Double getTeamRank() {
		return teamRank;
	}
	public void setTeamRank(Double teamName) {
		this.teamRank = teamRank;
	}
	
	// Should be a factory pattern 
	public static Team createTeam() {
		return new Team();
	}
	
}
