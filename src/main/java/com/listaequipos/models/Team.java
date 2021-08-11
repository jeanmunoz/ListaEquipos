package com.listaequipos.models;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String teamName;
	private List<Player> playersList = new ArrayList<>();
	private int numberOfPlayers = 0;
	
	public Team() {
	}
	
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public Team(String teamName) {
		this.teamName = teamName;
	}
	
	public Team(String teamName, List<Player> playerList) {
		this.teamName = teamName;
		this.playersList = playerList;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public List<Player> getPlayerList() {
		return playersList;
	}
	public void setPlayerList(List<Player> playerList) {
		this.playersList = playerList;
	}
	public void addPlayer(String firstName, String lastName, int age) {
		playersList.add(new Player(firstName, lastName, age));
		numberOfPlayers++;
	}
	public void removePlayer(int id) {
		playersList.remove(id);
		if(numberOfPlayers > 0) numberOfPlayers--;
	}
}
