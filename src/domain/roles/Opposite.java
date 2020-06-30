package domain.roles;

import domain.Player;

import java.time.LocalDate;

public class Opposite extends Player {

	public Opposite(String name, String surname, LocalDate birthday, String nationality, int number) {
		super(name, surname, birthday, nationality, number, "opposite");
	}

}
