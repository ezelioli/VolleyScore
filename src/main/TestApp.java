package main;

import java.awt.EventQueue;

import db.DatabaseAccess;
import db.DBAccessManager;
import domain.*;
import domain.roles.*;
import exceptions.DatabaseException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class TestApp {
	private static final String dburl = "data/VolleyScoreDatabase.db";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DatabaseAccess db = initDatabase(dburl);
				ArrayList<Championship> championships = new ArrayList<Championship>();

				try{
					championships = db.loadChampionships();
				}catch(Exception exception){
					System.out.println(exception.getMessage());
					System.exit(-1);
				}

				Championship champ = new Championship("Serie C");
				championships.add(champ);

				try{
					db.saveChampionship(champ);
				}catch(DatabaseException exception){
					System.out.println(exception.getMessage());
					System.exit(-1);
				}

				Team team1 = new Team("Vigili");
				Team team2 = new Team("Pieve");
				Team team3 = new Team("San Martino");
				Match m1 = new Match(team1, team2, LocalDate.now(), LocalTime.now());
				m1.setResult("3 - 1");
				Match m2 = new Match(team3, team1, LocalDate.now(), LocalTime.now());
				champ.addMatch(m1);
				champ.addMatch(m2);

				for(Match match : champ.getMatches())
					System.out.println(match.getHome().getName() + " vs " + match.getOpponent().getName() + " : " + match.getResult());

				Game game = new Game();
				Libero l = new Libero("Davide", "Terenziani", 23, "Italy", 7);
				Spiker s1 = new Spiker("Enrico", "Zelioli", 23, "Italy", 22);
				Setter p = new Setter("Carlo", "Carotenuto", 23, "Italy", 4);

				game.addPlayer(l);
				game.addPlayer(s1);
				game.addPlayer(p);

				p.serve(Grade.PLUS);
				s1.attack(Grade.PERFECT);
				p.serve(Grade.ERROR);
				l.receive(Grade.PERFECT);
				s1.attack(Grade.PLUS);
				s1.attack(Grade.ERROR);

				for(Player player : game.getPlayers())
					System.out.println(player.getName() + " " + player.getAttacksByGrade(Grade.PERFECT));

			}

			public DatabaseAccess initDatabase(String url){
				try{
					DatabaseAccess db = new DBAccessManager(dburl);
					return db;
				}catch(DatabaseException exception){
					System.out.println(exception.getMessage());
				}
				return null;
			}
		});
	}

}
