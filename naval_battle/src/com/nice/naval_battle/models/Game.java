package com.nice.naval_battle.models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> playerList;

    public Game() {
        playerList = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        playerList.add(player);
    }

    public boolean shoot(Player origin, Player target, String xIndex, int yIndex) {
        boolean asserted = target.getBoard().getCell(xIndex, yIndex).shoot();
        if (asserted) {
            origin.increaseScore();
        }
        return asserted;
    }

    public Player getWinner() {
        for (Player player : playerList) {
            int currentScore = player.getScore();
            int expectedScore = player.getExpectedScore();
            if (expectedScore == currentScore) {
                return player;
            }
        }
        return null;
    }
}
