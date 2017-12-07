package main.java.com.ct5025.games;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoughtsGameTest {
    private final NoughtsGame noughtsGame = new NoughtsGame();

    @Test
    public void checkSquareContainsSymbol() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that board position row 0, column 0 does not contain a symbol
        assertFalse(noughtsGame.checkSquareContainsSymbol(0,0));
        //Add 'o' to board at row 0, column 0
        noughtsGame.addSymbolToBoard(0,0,'o');
        //Test that row 0, column 0 contains a symbol
        assertTrue(noughtsGame.checkSquareContainsSymbol(0,0));
        //Replace 'o' with 'x' at same position on board
        noughtsGame.addSymbolToBoard(0,0,'x');
        //Test that row 0, column 0 contains a symbol
        assertTrue(noughtsGame.checkSquareContainsSymbol(0,0));
        //Remove symbol
        noughtsGame.addSymbolToBoard(0,0,' ');
        /////////////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void checkWinner() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that there is no winner when the board is blank
        assertFalse(noughtsGame.checkWinner());
        //Adjust board to create a winner in columns
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(1,0,'o');
        noughtsGame.addSymbolToBoard(2,0,'o');
        //Test that check winner returns true
        assertTrue(noughtsGame.checkWinner());
        //Adjust board to remove symbols
        noughtsGame.addSymbolToBoard(0,0,' ');
        noughtsGame.addSymbolToBoard(1,0,' ');
        noughtsGame.addSymbolToBoard(2,0,' ');
        //Adjust board to create a winner in rows
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(0,1,'o');
        noughtsGame.addSymbolToBoard(0,2,'o');
        //Test that check winner returns true
        assertTrue(noughtsGame.checkWinner());
        //Adjust board to remove symbols
        noughtsGame.addSymbolToBoard(0,0,' ');
        noughtsGame.addSymbolToBoard(0,1,' ');
        noughtsGame.addSymbolToBoard(0,2,' ');
        //Adjust board to create a winner in diagonals
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(1,1,'o');
        noughtsGame.addSymbolToBoard(2,2,'o');
        //Test that check winner returns true
        assertTrue(noughtsGame.checkWinner());
        /////////////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void checkColumns() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that there are no win conditions in any column
        assertFalse(noughtsGame.checkColumns());
        //Add symbols to create a win condition in column 0
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(1,0,'o');
        noughtsGame.addSymbolToBoard(2,0,'o');
        //Test that there is a win condition in columns
        assertTrue(noughtsGame.checkColumns());
        //Add other symbols to create a win condition in column 0
        noughtsGame.addSymbolToBoard(0,0,'x');
        noughtsGame.addSymbolToBoard(1,0,'x');
        noughtsGame.addSymbolToBoard(2,0,'x');
        //Test that there is a win condition
        assertTrue(noughtsGame.checkColumns());
        //Remove symbols used
        noughtsGame.addSymbolToBoard(0,0,' ');
        noughtsGame.addSymbolToBoard(1,0, ' ');
        noughtsGame.addSymbolToBoard(2,0,' ');
        /////////////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void checkRows() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that there are no win conditions in any row
        assertFalse(noughtsGame.checkRows());
        //Add symbols to create a win condition in row 0
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(0,1,'o');
        noughtsGame.addSymbolToBoard(0,2,'o');
        //Test that there is a win condition in rows
        assertTrue(noughtsGame.checkRows());
        //Add other symbols to create a win condition in row 0
        noughtsGame.addSymbolToBoard(0,0,'x');
        noughtsGame.addSymbolToBoard(0,1,'x');
        noughtsGame.addSymbolToBoard(0,2,'x');
        //Test that there is a win condition
        assertTrue(noughtsGame.checkRows());
        //Remove symbols used
        noughtsGame.addSymbolToBoard(0,0,' ');
        noughtsGame.addSymbolToBoard(0,1, ' ');
        noughtsGame.addSymbolToBoard(0,2,' ');
        /////////////////////////////////////////////////////////////////////////////////
    }

    @Test
    public void checkDiags() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test that there are no win conditions in any column
        assertFalse(noughtsGame.checkDiags());
        //Add symbols to create a win condition in column 0
        noughtsGame.addSymbolToBoard(0,0,'o');
        noughtsGame.addSymbolToBoard(1,1,'o');
        noughtsGame.addSymbolToBoard(2,2,'o');
        //Test that there is a win condition in columns
        assertTrue(noughtsGame.checkDiags());
        //Add other symbols to create a win condition in column 0
        noughtsGame.addSymbolToBoard(0,0,'x');
        noughtsGame.addSymbolToBoard(1,1,'x');
        noughtsGame.addSymbolToBoard(2,2,'x');
        //Test that there is a win condition
        assertTrue(noughtsGame.checkDiags());
        //Remove symbols used
        noughtsGame.addSymbolToBoard(0,0,' ');
        noughtsGame.addSymbolToBoard(1,1, ' ');
        noughtsGame.addSymbolToBoard(2,2,' ');
        //Change symbols to create a win condition in other diagonal direction
        noughtsGame.addSymbolToBoard(0,2,'o');
        noughtsGame.addSymbolToBoard(1,1,'o');
        noughtsGame.addSymbolToBoard(2,0,'o');
        //Test that there is a win condition in columns
        assertTrue(noughtsGame.checkDiags());
        //Add other symbols to create a win condition in other diagonal direction
        noughtsGame.addSymbolToBoard(0,2,'x');
        noughtsGame.addSymbolToBoard(1,1,'x');
        noughtsGame.addSymbolToBoard(2,0,'x');
        //Test that there is a win condition
        assertTrue(noughtsGame.checkDiags());
        //Remove symbols used
        noughtsGame.addSymbolToBoard(0,2,' ');
        noughtsGame.addSymbolToBoard(1,1, ' ');
        noughtsGame.addSymbolToBoard(2,0,' ');
        /////////////////////////////////////////////////////////////////////////////////
    }
}