package domain;

import java.time.LocalDate;

public abstract class Athlete extends Person{
	private int number;
	private String role;
	
	public Athlete(String name, String surname, LocalDate birthday, String nationality, int number, String role) {
		super(name, surname, birthday, nationality);
		this.number = number;
		this.role = role;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Athlete [ number = " + number + ", role = " + role + "]";
	}
}
