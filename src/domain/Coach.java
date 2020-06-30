package domain;

import java.time.LocalDate;

public class Coach extends Person{
    private String level;
    private Team team;

    public Coach(String name, String surname, LocalDate birthday, String nationality){
        super(name, surname, birthday, nationality);
        level = "basic";
    }

    public Coach(String name, String surname, LocalDate birthday, String nationality, String level, Team team){
        super(name, surname, birthday, nationality);
        this.level = level;
        this.team = team;
    }

    public Coach(String name, String surname, LocalDate birthday, String nationality, Team team){
        super(name, surname, birthday, nationality);
        this.level = "basic";
        this.team = team;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach{" + "level='" + level + '\'' + '}';
    }
}
