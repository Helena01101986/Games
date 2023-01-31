package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();

    @Test
    public void testWhenFirstPlayerIsMoreStrength() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 5);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Sasha", "Lyosha");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenSecondPlayerIsMoreStrength() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 15);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Sasha", "Lyosha");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenStrengthsOfPlayersAreEqual() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 10);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Sasha", "Lyosha");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenFirstPlayerIsNotRegistered() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 10);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void testWhenSecondPlayerIsNotRegistered() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 10);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }

    @Test
    public void testWhenPlayersAreNotRegistered() {

        Player player1 = new Player(1, "Sasha", 10);
        Player player2 = new Player(2, "Lyosha", 10);



        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player2.getName());
        });
    }
}

