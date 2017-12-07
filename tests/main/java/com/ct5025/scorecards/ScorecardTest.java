package main.java.com.ct5025.scorecards;

import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

public class ScorecardTest {
    //Instantiate a non-abstract scorecard object that is a subclass of 'Scorecard'
    //It is not important which class it is, as the method that is being tested is
    //contained within 'Scorecard'.
    private DiceGameScorecard scorecard = new DiceGameScorecard("genericWinner", "genericWinnerType", 0, 0, 0);

    @Test
    public void checkFileExists() {
        /////////////////////////////////////////////////////////////////////////////////
        //TEST SUITES:
        //
        //
        //Test false is returned if 'scores.txt' does not exist
        //  ->Ensuring it is deleted from project directory before executing test
        assertFalse(scorecard.checkFileExists());
        //Create file 'scores.txt' by creating arbitrary file & writer object and closing connection
        //  ->Note that if this test hangs, it is because an IOException has been caught
        try {
            File file = new File("scores.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("genericString");
            writer.close();
        }
        catch (IOException e) {
            //Exception caught
        }
        //Test true is returned now that 'scores.txt' exists
        assertTrue(scorecard.checkFileExists());
        /////////////////////////////////////////////////////////////////////////////////
    }
}