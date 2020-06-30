package domain.roles;

import domain.Player;

import java.time.LocalDate;

public class Middleblocker extends Player {

	public Middleblocker(String name, String surname, LocalDate birthday, String nationality, int number) {
		super(name, surname, birthday, nationality, number, "middle-blocker");
	}
}
