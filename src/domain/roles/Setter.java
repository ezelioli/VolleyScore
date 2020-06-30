package domain.roles;

import domain.Player;

import java.time.LocalDate;

public class Setter extends Player {

	public Setter(String name, String surname, LocalDate birthday, String nationality, int number) {
		super(name, surname, birthday, nationality, number, "libero");
	}

}
