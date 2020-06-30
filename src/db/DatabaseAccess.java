package db;

import java.util.ArrayList;

import exceptions.DatabaseException;
import domain.*;

public interface DatabaseAccess {

	public void saveChampionship(Championship championship) throws DatabaseException;

	public void saveTeam(Team team, Championship championship) throws DatabaseException;

	public void savePlayer(PlayerInfo playerInfo) throws DatabaseException;

	public ArrayList<Championship> loadChampionships() throws DatabaseException;

	public ArrayList<Team> loadTeamsOfChampionship(Championship championship) throws DatabaseException;

	public ArrayList<PlayerInfo> loadPlayersOfTeam(Team team) throws DatabaseException;

}
