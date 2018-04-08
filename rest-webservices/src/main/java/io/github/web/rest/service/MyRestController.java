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
    public List<Team> getTeams() {
        return teamsService.getTeams();
    }

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public Team getTeamByQuery(@RequestParam("index") int index) {
        return teamsService.getTeam(index);
    }

    @RequestMapping(value = "/team/{index}", method = RequestMethod.GET)
    public Team getTeamByPath(@PathVariable("index") int index) {
        return teamsService.getTeam(index);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public ResponseEntity<Boolean> addTeam(@RequestBody Team team) {
        teamsService.addTeam(team);
        return new ResponseEntity<Boolean>(HttpStatus.CREATED);
    }

}
