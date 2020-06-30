package domain;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;

    public Game(){
        players = new ArrayList<Player>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        players.add(player);
    }
}
