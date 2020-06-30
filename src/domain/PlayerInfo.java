package domain;

public class PlayerInfo extends Athlete{
    Team team;

    public PlayerInfo(String name, String surname, int age, String nationality, int number, String role){
        super(name, surname, age, nationality, number, role);
    }

    public void setTeam(Team team){
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
