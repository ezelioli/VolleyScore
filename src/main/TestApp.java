package main;

import java.awt.EventQueue;

import db.DatabaseAccess;
import db.DBAccessManager;
import domain.*;
import exceptions.DatabaseException;
import exceptions.PropertiesFileNotFoundException;
import gui.menu.MainMenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class TestApp {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DatabaseAccess db = initDatabase();
				Properties properties = null;
				try {
					properties = loadProperties();
				}catch(PropertiesFileNotFoundException exception){
					System.out.println(exception.getMessage());
				}catch(InvalidPropertiesFormatException exception){
					System.out.println(exception.getMessage());
				}
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

			private Properties loadProperties() throws PropertiesFileNotFoundException, InvalidPropertiesFormatException {
				Properties properties = new Properties();
				FileInputStream settingsFile;
				try{
					settingsFile = new FileInputStream("settings.xml");
					properties.loadFromXML(settingsFile);
				}catch(FileNotFoundException exception){
					throw new PropertiesFileNotFoundException(exception.getMessage());
				}catch(IOException exception){
					throw new PropertiesFileNotFoundException(exception.getMessage());
				}
				return properties;
			}
		});
	}

}
