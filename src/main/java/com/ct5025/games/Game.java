/**
 * Game is the abstract class containing attributes common to the game objects used in the game deck.
 * @author Coskun Demir
 * @version 1.0
 * @see main.java.com.ct5025.games.DiceGame
 * @see main.java.com.ct5025.games.NoughtsGame
 * @see main.java.com.ct5025.games.SnakesGame
 */
package main.java.com.ct5025.games;

import main.java.com.ct5025.players.Player;

abstract class Game {
    protected Player player1;
    protected Player player2;
    protected long timeTaken;
    protected String currentPlayerTurn;
}