package domain.roles;

import domain.Player;

import java.time.LocalDate;

public class Libero extends Player {
	public Libero(String name, String surname, LocalDate birthday, String nationality, int number) {
		super(name, surname, birthday, nationality, number, "libero");
	}
}
