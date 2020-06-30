package domain;

import java.util.ArrayList;

public abstract class Player extends Athlete{
    private ArrayList<Grade> attacks;
    private ArrayList<Grade> receptions;
    private ArrayList<Grade> serves;

    public Player(String name, String surname, int age, String nationality, int number, String role){
        super(name, surname, age, nationality, number, role);
        attacks = new ArrayList<Grade>();
        receptions = new ArrayList<Grade>();
        serves = new ArrayList<Grade>();
    }

    public void attack(Grade grade) {
        attacks.add(grade);
    }

    public void receive(Grade grade) {
        receptions.add(grade);
    }

    public void serve(Grade grade) {
        serves.add(grade);
    }

    public void resetScores(){
        attacks.clear();
        receptions.clear();
        serves.clear();
    }

    public int getStatsByGrade(ArrayList<Grade> stats, Grade grade){
        int count = 0;
        for(Grade g : stats){
            if(g == grade){
                count++;
            }
        }
        return count;
    }

    public int getAttacksByGrade(Grade grade){
        return getStatsByGrade(attacks, grade);
    }

    public int getServesByGrade(Grade grade){
        return getStatsByGrade(serves, grade);
    }

    public int getReceptionsByGrade(Grade grade){
        return getStatsByGrade(receptions, grade);
    }
}
