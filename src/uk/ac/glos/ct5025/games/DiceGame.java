package uk.ac.glos.ct5025.games;

import uk.ac.glos.ct5025.scorecards.DiceGameScorecard;

public class DiceGame {
    private int NUMBER_OF_DICE;
    private int[] player1RollResult = new int[this.NUMBER_OF_DICE];
    private int[] player2RollResult = new int[this.NUMBER_OF_DICE];
    private int highScore;
    private DiceGameScorecard scorecard = new DiceGameScorecard();
    private int gameDuration;

    public int dieRoll() {
        //Generate and return random number from 1-6
        java.util.Random rnd = new java.util.Random();
        return rnd.nextInt(6);
    }

    //Encapsulate appropriate fields
    public int getHighScore() {
        return highScore;
    }

    public int getGameDuration() {
        return gameDuration;
    }
}