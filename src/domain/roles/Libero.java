package domain.roles;

import domain.Player;

public class Libero extends Player {
	public Libero(String name, String surname, int age, String nationality, int number) {
		super(name, surname, age, nationality, number, "libero");
	}
}
