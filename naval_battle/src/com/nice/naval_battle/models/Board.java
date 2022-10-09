package com.nice.naval_battle.models;

/**
 * This board stores cells based on rows and columns.
 */
public class Board {

    private final int size;
    private final Cell[][] board;
    private Axis horizontalAxis;
    private Axis verticalAxis;

    public Cell getCell(String y, int x) {
        return board[horizontalAxis.getHorIndex(y)][x - 1];
    }

    public Board(int size) {
        this.size = size;
        board = initBoard();
    }

    /**
     * Initializes {@link Board} based on its horizontal axis and vertical axis.
     *
     * @return return a matrix which contains cells
     */
    private Cell[][] initBoard() {
        horizontalAxis = new Axis(Direction.HORIZONTAL, size);
        verticalAxis = new Axis(Direction.VERTICAL, size);

        Cell[][] newBoard = new Cell[size][size];
        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                newBoard[column][row] = new Cell(horizontalAxis.getByHorAxis(row),
                        verticalAxis.getByVerAxis(column));
            }
        }
        return newBoard;
    }

    public void print() {
        for (int column = 0; column < size; column++) {
            for (int row = 0; row < size; row++) {
                Cell cell = board[column][row];
                String value = "E";
                if (cell.getShip() != null && cell.getShip().isFired()) {
                    value = "X";
                } else if (cell.hasShip()) {
                    value = "S";
                } else if (cell.getState() == CellState.FIRED) {
                    value = "W";
                }
                System.out.print("[" + cell.getyAxis() + ":" + cell.getxAxis() + ":" + value + "] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Cell[] getNextHorCells(Cell cell, int size) {
        Cell[] cells = new Cell[size];
        boolean isValid = true;
        int horIndex = horizontalAxis.getHorIndex(cell.getyAxis());
        for (int index = 0; index < size; index++) {
            int yIndex = horIndex;
            int xIndex = cell.getxAxis() - 1 + index;
            if (xIndex >= board.length || yIndex >= board.length/* || board[yIndex][xIndex].hasShip()*/) {
                isValid = false;
            } else {
                cells[index] = board[yIndex][xIndex];
            }
        }
        if (!isValid) {
            return null;
        }
        return cells;
    }

    public Cell[] getNextVerCells(Cell cell, int size) {
        Cell[] cells = new Cell[size];
        boolean isValid = true;
        int horIndex = horizontalAxis.getHorIndex(cell.getyAxis());
        for (int index = 0; index < size; index++) {
            int yIndex = horIndex + index;
            int xIndex = cell.getxAxis() - 1;
            if (xIndex >= board.length || yIndex >= board.length /* || board[yIndex][xIndex].hasShip()*/) {
                isValid = false;
            } else {
                cells[index] = board[yIndex][xIndex];
            }
        }
        if (!isValid) {
            return null;
        }
        return cells;
    }

    public void addShip(Cell[] cells, Ship ship) {
        for (int index = 0; index < cells.length; index++) {
            int xIndex = cells[index].getxAxis() - 1;
            int yIndex = horizontalAxis.getHorIndex(cells[index].getyAxis());
            board[yIndex][xIndex].addShip(ship);
        }
    }

    //         1               2              3              4             5
    // A [new Cell/a/1] [new Cell/a/2] [new Cell/a/3] [new Cell/a/4] [new Cell/a/5]
    // B [new Cell/b/1] [new Cell/a/2] [new Cell/a/3] [new Cell/a/4] [new Cell/a/5]
    // C [new Cell/c/1] [new Cell/a/2] [new Cell/a/3] [new Cell/a/4] [new Cell/a/5]
    // D [new Cell/d/1] [new Cell/a/2] [new Cell/a/3] [new Cell/a/4] [new Cell/a/5]
    // E [new Cell/e/1] [new Cell/a/2] [new Cell/a/3] [new Cell/a/4] [new Cell/a/5]
}
