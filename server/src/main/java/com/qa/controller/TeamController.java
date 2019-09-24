package com.qa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dto.TeamDto;
import com.qa.service.TeamService;
import com.qa.models.Teams;

@RestController
@CrossOrigin
public class TeamController {
	
	@Autowired
	private TeamService service;
	private TeamsRepository repository;

//	@RequestMapping(value = "team", method = RequestMethod.GET)
////	public ResponseEntity<List<TeamDto>> getTeams(){
////		return new ResponseEntity<List<TeamDto>>(service.getTeams(), HttpStatus.OK);
////	}

	@RequestMapping(value = "teams", method = RequestMethod.GET)
	public List<Teams> listAllTeams() {
		return repository.findAll();
	}
	
	@RequestMapping(path = "team/", method = {RequestMethod.POST})
	public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto team){
		return new ResponseEntity<TeamDto>(service.createTeam(team), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "team/", method = {RequestMethod.PUT})
	public ResponseEntity<TeamDto> updateTeam(@RequestBody TeamDto team){
		return new ResponseEntity<TeamDto>(service.updateTeam(team), HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(path = "team/{id}", method = {RequestMethod.DELETE})
	public ResponseEntity<TeamDto> deleteTeam(@PathVariable Long id){
		return new ResponseEntity<TeamDto>(service.deleteTeam(id), HttpStatus.ACCEPTED);
	}
}
