package main.java.com.ct5025.games;

import main.java.com.ct5025.players.Player;

abstract class Game {
    protected Player player1;
    protected Player player2;
    protected long timeTaken;
    protected String currentPlayerTurn;
}