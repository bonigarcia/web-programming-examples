package com.utad.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsRestController {

	@Autowired
	private TeamsService teamsService;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamsService.getTeams();
	}

	@RequestMapping(value = "/team/{index}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable("index") int index) {
		return teamsService.getTeam(index);
	}

	@RequestMapping(value = "/teams", method = RequestMethod.POST)
	public ResponseEntity<Boolean> addTeam(@RequestBody Team team) {
		teamsService.addTeam(team);
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
	}
}
