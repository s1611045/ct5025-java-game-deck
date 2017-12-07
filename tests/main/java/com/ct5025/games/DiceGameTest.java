package main.java.com.ct5025.games;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceGameTest {
    @Test
    public void getWinnerType() {
        DiceGame computerVsComputerGame = new DiceGame();
        DiceGame humanVsComputerGame = new DiceGame("humanPlayer");
        DiceGame humanVsHumanGame = new DiceGame("humanPlayer1", "humanPlayer2");

        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //The code being tested is written VERBATIM in the other game classes, with the same inputs,
        //therefore this specific test is only being tested in this class, and not the others.
        //
        //Set winner to 'draw'
        computerVsComputerGame.setWinner("Draw");
        //Test that if the winner is 'draw', 'Draw' is returned as the winnerType
        assertEquals("Draw",computerVsComputerGame.getWinnerType());
        //No need to test other objects for this as they are the same class with same methods
        //
        //
        //Set winner to computer name
        computerVsComputerGame.setWinner(computerVsComputerGame.player1.name);
        //Test that if a computer wins the game, 'Computer' is returned as the winnerType
        assertEquals("Computer",computerVsComputerGame.getWinnerType());
        //Set winner to player 2 (computer name)
        computerVsComputerGame.setWinner(computerVsComputerGame.player2.name);
        //Test that if a computer (player 2) wins the game, 'Computer' is returned as the winnerType
        assertEquals("Computer",computerVsComputerGame.getWinnerType());
        //
        //
        //Set winner to human name
        humanVsComputerGame.setWinner(humanVsComputerGame.player1.name);
        //Test that if a human wins a human v. computer game, 'Human' is returned as the winnerType
        assertEquals("Human",humanVsComputerGame.getWinnerType());
        //Set winner to computer name
        humanVsComputerGame.setWinner(humanVsComputerGame.player2.name);
        //Test that if a computer wins a human v. computer game, 'Computer' is returned as the winnerType
        assertEquals("Computer", humanVsComputerGame.getWinnerType());
        //
        //
        //Set winner to human name
        humanVsHumanGame.setWinner(humanVsHumanGame.player1.name);
        //Test that if a human wins a human vs. human game, 'Human' is returned as the winnerType
        assertEquals("Human",humanVsHumanGame.getWinnerType());
        //Set winner to next human name
        humanVsHumanGame.setWinner(humanVsHumanGame.player2.name);
        //Test that if a player 2 human wins a human vs. human game, 'Human' is returned as the winnerType
        assertEquals("Human",humanVsHumanGame.getWinnerType());
        /////////////////////////////////////////////////////////////////////////////////

    }
}