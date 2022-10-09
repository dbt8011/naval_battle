package com.nice.naval_battle.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Axis {

    private static final String[] ALPHABET = {"A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"
            , "U", "V", "W", "X", "Y", "Z"}; // final q no es modificable

    private Direction direction;
    private List<Integer> horizontalAxis;
    private List<String> verticalAxis;

    public Axis(Direction direction, int size) {
        if (direction == Direction.VERTICAL) {
            verticalAxis = generateVerticalAxis(size);
        } else if (direction == Direction.HORIZONTAL) {
            horizontalAxis = generateHorizontalAxis(size);
        }
    }

    private List<String> generateVerticalAxis(int size) {
        final List<String> axis = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            axis.add(ALPHABET[index]);
        }
        return axis;
    }

    private List<Integer> generateHorizontalAxis(int size) {
        final List<Integer> axis = new ArrayList<>(size);
        for (int index = 1; index <= size; index++) {
            axis.add(index);
        }
        return axis;
    }

    public Integer getByHorAxis(int index) {
        return horizontalAxis.get(index);
    }

    public String getByVerAxis(int index) {
        return verticalAxis.get(index);
    }

    public int getHorIndex(String y) {
        return Arrays.asList(ALPHABET).indexOf(y);
    }
}
