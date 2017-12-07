package main.java.com.ct5025.games;

import org.junit.Test;

import static org.junit.Assert.*;

public class SnakesGameTest {
    //Instantiate game object
    SnakesGame game = new SnakesGame();

    @Test
    public void checkWinner() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that if input is <100, false is returned
        assertFalse(game.checkWinner(99));
        //Test that if input is 100, true is returned
        assertTrue(game.checkWinner(100));
        //Test that if input is >100, true is returned
        assertTrue(game.checkWinner(101));
        /////////////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void checkSnakeOrLadder() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Create array with generic value as element 0
        int[] array = new int[1];
        array[0] = 25;
        //Test that if input position matches an element in array, true is returned
        assertTrue(game.checkSnakeOrLadder(25,array));
        //Test that if input position does not match an element in array, false is returned
        assertFalse(game.checkSnakeOrLadder(12,array));
        /////////////////////////////////////////////////////////////////////////////////
    }
}