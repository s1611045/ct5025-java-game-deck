package uk.ac.glos.ct5025.games;

import uk.ac.glos.ct5025.scorecards.DiceGameScorecard;

public class DiceGame {
    private int NUMBER_OF_DICE;
    private int NUMBER_OF_ROUNDS;
    private int dieRollResult;
    private int highScore;
    private DiceGameScorecard scorecard = new DiceGameScorecard();
    private int gameDuration;

    public int dieRoll() {
        //Generate and return random number from 0-5
        java.util.Random rnd = new java.util.Random();
        return rnd.nextInt(5);
    }

    //Encapsulate appropriate fields
    public int getDieRollResult() {
        return dieRollResult;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getGameDuration() {
        return gameDuration;
    }
}
