package com.nice.naval_battle.models;
//celda
public class Cell {

    private int xAxis;
    private String yAxis;

    private CellState state;
    private Ship ship;
    private boolean hasShip;

    public Cell(int xAxis, String yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        state = CellState.EMPTY;
        hasShip = false;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getxAxis() {
        return xAxis;
    }

    public String getyAxis() {
        return yAxis;
    }
    public void addShip(Ship ship) {
        this.ship = ship;
        hasShip = ship != null;
    }

    public boolean hasShip() {
        return hasShip;
    }

    public Ship getShip() {
        return ship;
    }

    public boolean shoot() {
        if (state == CellState.EMPTY) {
            state = CellState.FIRED;
            return false;
        } else if (hasShip) {
            ship.setFired(true);
            return true;
        }
        return false;
    }
}
