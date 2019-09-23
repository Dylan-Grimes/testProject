package com.qa.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.dto.TeamDto;
import com.qa.persistence.model.Team;
import com.qa.persistence.repository.TeamRepository;

@RunWith(MockitoJUnitRunner.class)
public class TeamServiceTest {
	
	@Mock
	private TeamRepository teamRepository;
	
	@InjectMocks
	private TeamService teamService;
	
	@Test
	public void getTeamsTest() {
		List<Team> listOfTeams = new ArrayList<Team>();
		listOfTeams.add(new Team(1L, "Text"));
		listOfTeams.add(new Team(5L, "More Text"));
		
		List<TeamDto> listOfTeamDtos = new ArrayList<TeamDto>();
		listOfTeamDtos.add(new TeamDto(1L, "Text"));
		listOfTeamDtos.add(new TeamDto(5L, "More Text"));
		
		Mockito.when(teamRepository.findAll()).thenReturn(listOfTeams);
		assertEquals(listOfTeamDtos.get(1).getId(), teamService.getTeams().get(1).getId());
		assertEquals(listOfTeamDtos.get(1).getText(), teamService.getTeams().get(1).getText());
	}
	

	@Test
	public void updateTeamTest() {
		TeamDto dto = new TeamDto(1L, "new Text");
		Team team = new Team(1L, "old Text");
		
		Mockito.when(teamRepository.getOne(dto.getId())).thenReturn(team);
		assertEquals("new Text", teamService.updateTeam(dto).getText());
		assertEquals((Long) 1L, teamService.updateTeam(dto).getId());
	}
	
	@Test
	public void deleteTeamTest() {
		Long id = 1L;
		Team team = new Team(id, "Text");
		Mockito.when(teamRepository.getOne(id)).thenReturn(team);
		
		assertEquals("Text", teamService.deleteTeam(id).getText());
		verify(teamRepository, Mockito.times(1)).deleteById(id);
	}
	
}
