package com.listaequipos.models;

import java.util.ArrayList;
import java.util.List;

public class Roster {
	private List<Team> teamsList = new ArrayList<>();
	private int numberOfTeams = 0;

	public Roster() {
	}

	public List<Team> getTeamsList() {
		return teamsList;
	}

	public void setTeamsList(List<Team> teamsList) {
		this.teamsList = teamsList;
	}
	
	public void addTeam(String teamName) {
		teamsList.add(new Team(teamName));
		numberOfTeams++;
	}
	
	public int getNumberOfTeams() {
		return numberOfTeams;
	}

	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}

	public void removeTeam(int id) {
		teamsList.remove(id);
		if(numberOfTeams > 0) numberOfTeams--;
	}
	
	public Team getTeam(int id) {
		return teamsList.get(id);
	}
	
	
}
