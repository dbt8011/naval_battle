package com.nice.naval_battle;

import com.nice.naval_battle.models.*;

import static com.nice.naval_battle.models.Ship.Model.*;

public class Main {

    public static void main(String[] args) {
        Player daniel = new Player("danielbas");
        Player arnold = new Player("arnoldo");
        daniel.addBoard(new Board(10));
        arnold.addBoard(new Board(10));

        daniel.addShip(new Ship(SHIP_3, 3), "E", 4, Direction.VERTICAL);
        daniel.addShip(new Ship(SHIP_2, 2), "C", 2, Direction.HORIZONTAL);
        daniel.addShip(new Ship(SHIP_3_1, 3), "I", 3, Direction.HORIZONTAL);
        daniel.addShip(new Ship(SHIP_5, 5), "C", 9, Direction.VERTICAL);
        daniel.addShip(new Ship(SHIP_4, 4), "A", 7, Direction.HORIZONTAL);
        System.out.println("Board of Daniel");
        daniel.getBoard().print();

        arnold.addShip(new Ship(SHIP_2, 2), "C", 6, Direction.VERTICAL);
        arnold.addShip(new Ship(SHIP_3, 3), "E", 2, Direction.VERTICAL);
        arnold.addShip(new Ship(SHIP_3_1, 3), "I", 8, Direction.HORIZONTAL);
        arnold.addShip(new Ship(SHIP_4, 4), "I", 3, Direction.HORIZONTAL);
        arnold.addShip(new Ship(SHIP_5, 5), "C", 9, Direction.VERTICAL);
        System.out.println("Board of Arnold");
        arnold.getBoard().print();

        Game game = new Game();
        game.addPlayer(daniel);
        game.addPlayer(arnold);
        boolean asserted1 = game.shoot(daniel, arnold, "E", 2);
        boolean asserted2 = game.shoot(daniel, arnold, "F", 2);
        boolean asserted3 = game.shoot(daniel, arnold, "G", 2);
        boolean asserted4 = game.shoot(daniel, arnold, "I", 3);
        boolean asserted5 = game.shoot(daniel, arnold, "I", 4);
        boolean asserted6 = game.shoot(daniel, arnold, "I", 5);
        boolean asserted7 = game.shoot(daniel, arnold, "I", 6);
        boolean asserted8 = game.shoot(daniel, arnold, "C", 9);
        boolean asserted9 = game.shoot(daniel, arnold, "D", 9);
        boolean asserted10 = game.shoot(daniel, arnold, "E", 9);
        boolean asserted11 = game.shoot(daniel, arnold, "F", 9);
        boolean asserted12 = game.shoot(daniel, arnold, "G", 9);
        boolean asserted13 = game.shoot(daniel, arnold, "I", 8);
        boolean asserted14 = game.shoot(daniel, arnold, "I", 9);
        boolean asserted15 = game.shoot(daniel, arnold, "I", 10);
        boolean asserted16 = game.shoot(daniel, arnold, "C", 6);
        boolean asserted17 = game.shoot(daniel, arnold, "D", 6);

        Player winner = game.getWinner();
    }
}
