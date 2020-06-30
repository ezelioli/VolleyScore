package domain;

public class Coach extends Person{
    private String level;
    private Team team;

    public Coach(String name, String surname, int age, String nationality){
        super(name, surname, age, nationality);
        level = "basic";
    }

    public Coach(String name, String surname, int age, String nationality, String level, Team team){
        super(name, surname, age, nationality);
        this.level = level;
        this.team = team;
    }

    public Coach(String name, String surname, int age, String nationality, Team team){
        super(name, surname, age, nationality);
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
