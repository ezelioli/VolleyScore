package domain;

import java.time.LocalDate;

public class PlayerInfo extends Athlete{
    Team team;

    public PlayerInfo(String name, String surname, LocalDate birthday, String nationality, int number, String role){
        super(name, surname, birthday, nationality, number, role);
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
