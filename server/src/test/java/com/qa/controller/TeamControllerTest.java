package com.qa.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.dto.TeamDto;
import com.qa.persistence.repository.TeamRepository;
import com.qa.service.TeamService;

@RunWith(MockitoJUnitRunner.class)
public class TeamControllerTest {

	@InjectMocks
	private TeamController teamController;
	
	@Mock
	private TeamService teamService;
	
	@Test
	public void getTeamsTest() {
		List<TeamDto> teamDtos = new ArrayList<TeamDto>();
		teamDtos.add(new TeamDto(1L, "Name", 1.0));
		teamDtos.add(new TeamDto(3L, "More Name", 2.0));
		
		Mockito.when(teamService.getTeams()).thenReturn(teamDtos);
		
		assertEquals(HttpStatus.OK, teamController.getTeams().getStatusCode());
	}
	

	@Test
	public void createTeamTest() {
		TeamDto dto = new TeamDto(null, "Name", 1.0);
		Mockito.when(teamService.createTeam(dto)).thenReturn(new TeamDto(2L, "Name", 1.0));
		
		assertEquals((Long) 2L, teamController.createTeam(dto).getBody().getId());
		assertEquals(HttpStatus.CREATED, teamController.createTeam(dto).getStatusCode());
	}
	

	@Test
	public void updateTeamTest() {
		TeamDto dto = new TeamDto(1L, "Name", 2.0);
		Mockito.when(teamService.updateTeam(dto)).thenReturn(new TeamDto(1L, "Name", 1.0));
		
		assertEquals((Long) 1L, teamController.updateTeam(dto).getBody().getId());
		assertEquals(HttpStatus.ACCEPTED, teamController.updateTeam(dto).getStatusCode());
	}
	
	@Test
	public void deleteTeamTest() {
		Long id = 1L;
		TeamDto dto = new TeamDto(1L, "Name", 1.0);
		Mockito.when(teamService.deleteTeam(id)).thenReturn(dto);
		
		assertEquals((Long) 1L, teamController.deleteTeam(id).getBody().getId());
		assertEquals(HttpStatus.ACCEPTED, teamController.deleteTeam(id).getStatusCode());
		
	}
		
}
