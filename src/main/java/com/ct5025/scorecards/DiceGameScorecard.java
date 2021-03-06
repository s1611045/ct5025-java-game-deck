package main.java.com.ct5025.scorecards;

public class DiceGameScorecard extends Scorecard {
    /**
     * The class that collects, contains, and saves the statistics generated by an instance of DiceGame being played.
     * @author Coskun Demir
     * @version 1.0
     */
    private int numberOfDice;
    private int winningScore;

    /**
     * Constructor that receives statistics from an instance of DiceGame being played
     * @param winner    winner of the game
     * @param winnerType    type of winner (human, computer, none)
     * @param timeTaken time taken during the game in seconds
     * @param dice  number of dice used in the game
     * @param score winning score
     */
    public DiceGameScorecard(String winner, String winnerType, long timeTaken, int dice, int score) {
        this.setWinner(winner);
        this.setWinnerType(winnerType);
        this.setTimeTaken(timeTaken);
        this.setNumberOfDice(dice);
        this.setWinningScore(score);
    }

    /**
     * Converts the statistics collected from the game into a concatenated string
     * and calls a function to save to 'scores.txt'
     */
    public void saveScorecard() {
        //Generate string of results
        String results = ("Dice Game" + "," + this.getWinner() + "," + this.getWinnerType() + "," + Long.toString(this.getTimeTaken())
        + "," + Integer.toString(this.getNumberOfDice()) + "," + Integer.toString(this.getWinningScore()));

        //Save file
        this.saveFile(results);
    }

    private int getNumberOfDice() {
        return numberOfDice;
    }

    private void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    private int getWinningScore() {
        return winningScore;
    }

    private void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }
}
