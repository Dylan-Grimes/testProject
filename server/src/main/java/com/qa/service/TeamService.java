package com.qa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.dto.TeamDto;
import com.qa.persistence.model.Team;
import com.qa.persistence.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

	public List<TeamDto> getTeams(){
		List<Team> teams = teamRepository.findAll();
		List<TeamDto> teamsDto = new ArrayList<TeamDto>();
		teams.forEach(team -> teamsDto.add(new TeamDto(team)));
		return teamsDto;
	}
	
	public TeamDto createTeam(TeamDto teamDto){
		teamDto.setId(null);
		Team team = Team.createTeam();
		team.setTeamName(teamDto.getTeamName());
		team.setTeamRank(teamDto.getTeamRank());
		
		return new TeamDto(teamRepository.saveAndFlush(team));
	}
	
	public TeamDto updateTeam(TeamDto teamDto){
		Team team = teamRepository.getOne(teamDto.getId());
		team.setTeamName(teamDto.getTeamName());
		team.setTeamRank(teamDto.getTeamRank());
		teamRepository.flush();
		return new TeamDto(team);
	}
	
	public TeamDto deleteTeam(Long id){
		Team team = teamRepository.getOne(id);
		TeamDto teamDto = new TeamDto(team);
		teamRepository.deleteById(id);
		return teamDto;
	}
}
