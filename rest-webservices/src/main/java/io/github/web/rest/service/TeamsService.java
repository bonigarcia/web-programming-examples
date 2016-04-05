package io.github.web.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TeamsService {

    private List<Team> teams;

    public TeamsService() {
        teams = new ArrayList<>();
        Player p1 = new Player("Player 1", "p1");
        Player p2 = new Player("Player 2", "p2");
        Player p3 = new Player("Player 3", "p3");
        Player p4 = new Player("Player 4", "p4");

        List<Player> l1 = new ArrayList<>();
        l1.add(p1);
        l1.add(p2);
        Team t1 = new Team("t1", l1);

        List<Player> l2 = new ArrayList<>();
        l2.add(p3);
        l2.add(p4);
        Team t2 = new Team("t2", l2);

        teams.add(t1);
        teams.add(t2);
    }

    public Team getTeam(int index) {
        return teams.get(index);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

}
