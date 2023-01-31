package ru.netology;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    //private String player1;
    //private String player2;

    public void register(Player player) {
        players.add(player);

    }

    /*public Player round(String playerName1, String playerName2) {

        for (Player player1 : players) {
            if (player1.getName().equals(playerName1)) {
                return player1;
            }
        }
        return null;

        for (Player player2 : players) {
            if (player2.getName().equals(playerName2)) {
                return player2;
            }
        }
        return null;

        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }*/


    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }

    }
}
