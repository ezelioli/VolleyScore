package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.DatabaseException;
import domain.*;

public class DBAccessManager implements DatabaseAccess {

	private static final String url = "data/VolleyScoreDatabase.db";
	private static DBAccessManager uniqueInstance = null;

	private DBManager db;
	
	private DBAccessManager() throws DatabaseException{
		try {
			this.db = new DBManager(DBManager.JDBCDriver, DBManager.JDBCURL + url);
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}catch(ClassNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public static DBAccessManager getInstance() throws DatabaseException{
		if(uniqueInstance == null){
			return new DBAccessManager();
		}
		return uniqueInstance;
	}
	
	public boolean isConnected(){
		return db.connected;
	}

	@Override
	public void saveChampionship(Championship championship) throws DatabaseException {
		try{
			String query = "INSERT INTO championship VALUES (\"" + championship.getName() + "\");";
			db.executeUpdate(query);
		}catch(SQLException e){
			throw new DatabaseException(e.getMessage());
		}
	}

	@Override
	public void saveTeam(Team team, Championship championship) throws DatabaseException {
		try{
			String query = "INSERT INTO team VALUES (\"" + team.getName() + "\", \"" + championship.getName() + "\");";
			db.executeUpdate(query);
		}catch(SQLException exception){
			throw new DatabaseException(exception.getMessage());
		}
	}

	@Override
	public void savePlayer(PlayerInfo playerInfo) throws DatabaseException {
		try{
			String query = "INSERT INTO player VALUES (\"" + playerInfo.getName() + "\", \"" + playerInfo.getSurname()
					+ "\", \"" + playerInfo.getBirthday() + "\", \"" + playerInfo.getNumber() + "\", \"" +
					playerInfo.getRole() + "\", \"" + playerInfo.getTeam() + "\", \"" + playerInfo.getNationality() +
					"\");";
			db.executeUpdate(query);
		}catch(SQLException exception){
			throw new DatabaseException(exception.getMessage());
		}
	}

	@Override
	public ArrayList<Championship> loadChampionships() throws DatabaseException {
		ArrayList<Championship> championships = new ArrayList<Championship>();
		try {
			String query = "SELECT name FROM championship;";
			ResultSet rs = db.executeQuery(query);
			while(rs.next()){
				Championship newChampionship = new Championship(rs.getString(1));
				championships.add(newChampionship);
			}
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return championships;
	}

	@Override
	public ArrayList<Team> loadTeamsOfChampionship(Championship championship) throws DatabaseException {
		ArrayList<Team> teams = new ArrayList<Team>();
		try {
			String query = "SELECT name FROM team WHERE championship = \"" + championship.getName() + "\";";
			ResultSet rs = db.executeQuery(query);
			while(rs.next()){
				Team newTeam = new Team(rs.getString(1));
				teams.add(newTeam);
			}
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return teams;
	}

	@Override
	public ArrayList<PlayerInfo> loadPlayersOfTeam(Team team) throws DatabaseException {
		ArrayList<PlayerInfo> players = new ArrayList<PlayerInfo>();
		try {
			String query = "SELECT name, surname, birthday, nationality, number, role FROM player WHERE team = \"" +
					team.getName() + "\";";
			ResultSet rs = db.executeQuery(query);
			while(rs.next()){
				String playerName = rs.getString(1);
				String playerSurname = rs.getString(2);
				LocalDate playerBirthday = rs.getDate(3).toLocalDate();
				String playerNationality = rs.getString(4);
				int playerNumber = rs.getInt(5);
				String playerRole = rs.getString(6);
				PlayerInfo newPlayer = new PlayerInfo(playerName, playerSurname, playerBirthday, playerNationality, playerNumber, playerRole);
				players.add(newPlayer);
			}
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return players;
	}
}
