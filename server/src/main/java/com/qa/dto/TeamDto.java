package com.qa.dto;

import com.qa.persistence.model.Team;

public class TeamDto {

	Long id;
	String text;
	
	public TeamDto() {
		super();
	}

	public TeamDto(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public TeamDto(Team team) {
		this.id = team.getId();
		this.text = team.getText();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
