package domain.roles;

import domain.Player;

import java.time.LocalDate;

public class Spiker extends Player {

	public Spiker(String name, String surname, LocalDate birthday, String nationality, int number) {
		super(name, surname, birthday, nationality, number, "spiker");
	}
}
