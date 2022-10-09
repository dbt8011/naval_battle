package com.nice.naval_battle.models;

import java.util.List;

public class Player {
    private String username;
    private List<Ship> ships;
    private Board board;
    private int score;
    public Player(String username) {
        this.username = username;
        score = 0;
    }

    public void addBoard(Board board) {
        this.board = board;
    }

    public void addShip(Ship ship, String y, int x, Direction direction) {
        if (direction == Direction.VERTICAL) {
            //Cell cell = board.getNextHorCell(cell);
            Cell[] cells = board.getNextHorCells(board.getCell(y, x), ship.getSize());
            if (cells != null) {
                board.addShip(cells, ship);
                ships.add(ship);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public void increaseScore() {
        this.score = score++;
    }

    public int getScore() {
        return score;
    }
    public int getExpectedScore() {
        int count = 0;
        for (Ship ship : ships) {
            count = count + ship.getSize();
        }
        return count;
    }

}
