package io.github.web.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyRestController {

    @Autowired
    private MyService teamsService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ResponseEntity<List<Team>> getTeams() {
        List<Team> teams = teamsService.getTeams();

        HttpStatus status = HttpStatus.OK;
        ResponseEntity<List<Team>> response = new ResponseEntity<>(teams,
                status);
        return response;
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeamByQuery(
            @RequestParam("index") int index) {
        return getTeam(index);
    }

    @RequestMapping(value = "/team/{index}", method = RequestMethod.GET)
    public ResponseEntity<Team> getTeamByPath(
            @PathVariable("index") int index) {
        return getTeam(index);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public ResponseEntity<Integer> addTeam(@RequestBody Team team) {
        teamsService.addTeam(team);
        int teamSize = teamsService.size();

        HttpStatus status = HttpStatus.CREATED;
        ResponseEntity<Integer> response = new ResponseEntity<>(teamSize,
                status);
        return response;
    }

    private ResponseEntity<Team> getTeam(int index) {
        Team team = teamsService.getTeam(index);

        HttpStatus status = HttpStatus.OK;
        ResponseEntity<Team> response = new ResponseEntity<>(team, status);
        return response;
    }

}
