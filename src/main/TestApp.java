package main;

import java.awt.EventQueue;

import db.DatabaseAccess;
import db.DBAccessManager;
import domain.*;
import domain.roles.*;
import exceptions.DatabaseException;
import gui.menu.MainMenu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TestApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DatabaseAccess db = initDatabase();
				ArrayList<Championship> championships = new ArrayList<Championship>();
				ArrayList<Team> provaTeams = new ArrayList<Team>();

				try{
					championships = db.loadChampionships();
					provaTeams = db.loadTeamsOfChampionship(championships.get(1));
				}catch(Exception exception){
					System.out.println(exception.getMessage());
					System.exit(-1);
				}

				for(Team team : provaTeams){
					System.out.println(team.getName());
				}

				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);

			}

			public DatabaseAccess initDatabase(){
				try{
					DatabaseAccess db = DBAccessManager.getInstance();
					return db;
				}catch(DatabaseException exception){
					System.out.println(exception.getMessage());
				}
				return null;
			}
		});
	}

}
