package domain.roles;

import domain.Player;

public class Middleblocker extends Player {

	public Middleblocker(String name, String surname, int age, String nationality, int number) {
		super(name, surname, age, nationality, number, "middle-blocker");
	}
}
