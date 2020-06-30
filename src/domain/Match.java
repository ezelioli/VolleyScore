package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Match {
	private Team home;
	private Team opponent;
	private LocalDate date;
	private LocalTime duration;
	private String result;
	
	public Match(Team home, Team opponent, LocalDate date, LocalTime duration) {
		this.home = home;
		this.opponent = opponent;
		this.date = date;
		this.duration = duration;
		this.result = "not disputed";
	}

	public Team getHome() {
		return home;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public Team getOpponent() {
		return opponent;
	}

	public void setOpponent(Team opponent) {
		this.opponent = opponent;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
