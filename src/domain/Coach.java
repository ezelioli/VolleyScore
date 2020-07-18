package domain;

import java.time.LocalDate;

public class Coach extends Person{
    private String role;
    private Team team;

    public Coach(String name, String surname, LocalDate birthday, String nationality){
        super(name, surname, birthday, nationality);
        role = "head";
    }

    public Coach(String name, String surname, LocalDate birthday, String nationality, String role){
        super(name, surname, birthday, nationality);
        this.role = role;
        this.team = null;
    }

    public Coach(String name, String surname, LocalDate birthday, String nationality, Team team){
        super(name, surname, birthday, nationality);
        this.role = "head";
        this.team = team;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach{" + "level='" + role + '\'' + '}';
    }
}
