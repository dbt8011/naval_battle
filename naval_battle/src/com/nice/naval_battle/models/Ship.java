package com.nice.naval_battle.models;

import java.util.List;

// nave
public class Ship {

    private Model model;
    private int size;
    private List<Cell> cells;
    private boolean isFired;

    public Ship(Model model, int size) {
        this.model = model;
        this.size = size;
        isFired = false;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }

    public enum Model {
        SHIP_2,
        SHIP_3,
        SHIP_3_1,
        SHIP_4,
        SHIP_5;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
