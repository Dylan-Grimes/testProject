package com.qa.dto;

import com.qa.persistence.model.Team;

public class TeamDto {

	Long id;
	String textName;
	Double teamRank;
	
	public TeamDto() {
		super();
	}

	public TeamDto(Long id, String teamName, Double teamRank) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.teamRank = teamRank;
	}

	public TeamDto(Team team) {
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
	
	
}
