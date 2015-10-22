package io.github.web.rest.service;

import java.util.List;

public class Team {

	private String name;
	private List<Player> players;

	public Team() {
	}

	public Team(String name, List<Player> players) {
		this.name = name;
		this.players = players;
	}

	// Getters and setters

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [players=" + players + ", name=" + name + "]";
	}

}
