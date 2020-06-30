package domain;

import java.util.ArrayList;

public class Championship {
    private String name;
    private ArrayList<Match> matches;

    public Championship(String name){
        this.name = name;
        matches = new ArrayList<Match>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMatch(Match match){
        matches.add(match);
    }

    public ArrayList<Match> getMatches() {
        return matches;
    }
}
