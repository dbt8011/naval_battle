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

    public boolean shoot(Player player, String xIndex, int yIndex) {
        boolean asserted = player.getBoard().getCell(xIndex, yIndex).shoot();
        if (asserted) {
            player.increaseScore();
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
