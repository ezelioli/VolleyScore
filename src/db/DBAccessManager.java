package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.DatabaseException;
import domain.*;

public class DBAccessManager implements DatabaseAccess {
	private DBManager db;
	
	public DBAccessManager(String url) throws DatabaseException{
		try {
			this.db = new DBManager(DBManager.JDBCDriver, DBManager.JDBCURL + url);
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}catch(ClassNotFoundException e) {
			throw new DatabaseException(e.getMessage());
		}
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
	public ArrayList<Championship> loadChampionships() throws DatabaseException {
		ArrayList<Championship> championships = new ArrayList<Championship>();
		try {
			String query = "SELECT name FROM championship;";
			ResultSet rs = db.executeQuery(query);
			while(rs.next()){
				championships.add(new Championship(rs.getString(1)));
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
			String query = ""; //TODO: implement query for loading teams of a given championship from database
			ResultSet rs = db.executeQuery(query);
			while(rs.next()){
				teams.add(new Team(rs.getString(1)));
			}
		}catch(SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return teams;
	}
}
