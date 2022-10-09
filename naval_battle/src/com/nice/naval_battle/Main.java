package com.nice.naval_battle;

import com.nice.naval_battle.models.*;

import static com.nice.naval_battle.models.Ship.Model.*;

public class Main {

    public static void main(String[] args) {
        Player daniel = new Player("danielbas");
        Player arnold = new Player("arnoldo");
        daniel.addBoard(new Board(10));
        arnold.addBoard(new Board(10));

        daniel.addShip(new Ship(SHIP_2, 2), "C", 2, Direction.HORIZONTAL);
        daniel.addShip(new Ship(SHIP_3, 3), "E", 4, Direction.VERTICAL);
        daniel.addShip(new Ship(SHIP_3_1, 3), "I", 3, Direction.HORIZONTAL);
        daniel.addShip(new Ship(SHIP_4, 4), "C", 9, Direction.VERTICAL);
        daniel.addShip(new Ship(SHIP_5, 5), "A", 7, Direction.HORIZONTAL);
        daniel.getBoard().print();

        arnold.addShip(new Ship(SHIP_2, 2), "C", 6, Direction.VERTICAL);
        arnold.addShip(new Ship(SHIP_3, 3), "E", 2, Direction.VERTICAL);
        arnold.addShip(new Ship(SHIP_3_1, 3), "I", 8, Direction.HORIZONTAL);
        arnold.addShip(new Ship(SHIP_4, 4), "I", 3, Direction.HORIZONTAL);
        arnold.addShip(new Ship(SHIP_5, 5), "C", 9, Direction.VERTICAL);
        arnold.getBoard().print();

        Game game = new Game();
        game.addPlayer(daniel);
        game.addPlayer(arnold);
        boolean asserted1 = game.shoot(daniel, "C", 2);
        boolean asserted2 = game.shoot(arnold, "C", 2);
        boolean asserted3 = game.shoot(daniel, "C", 2);
        boolean asserted4 = game.shoot(arnold, "C", 2);
        boolean asserted5 = game.shoot(daniel, "C", 2);
        boolean asserted6 = game.shoot(arnold, "C", 2);
        boolean asserted7 = game.shoot(daniel, "C", 2);

        Player winner = game.getWinner();
        daniel.getBoard().print();

    }
}
