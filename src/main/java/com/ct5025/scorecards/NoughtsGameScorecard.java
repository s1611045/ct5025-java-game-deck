package main.java.com.ct5025.scorecards;

public class NoughtsGameScorecard extends Scorecard {
    /**
     * The class that collects, contains, and saves the statistics generated by an instance of NoughtsGame being played.
     * @author Coskun Demir
     * @version 1.0
     */
    private int numberOfTurns;
    private char winningSymbol;

    /**
     * Constructor that receives statistics from an instance of NoughtsGame being played
     * @param winner    winner of the game
     * @param winnerType    type of winner (human, computer, none)
     * @param timeTaken time taken during the game in seconds
     * @param numberOfTurns number of turns taken in the game until winner was found
     * @param winningSymbol the symbol that won the game
     */
    public NoughtsGameScorecard(String winner, String winnerType, long timeTaken, int numberOfTurns, char winningSymbol) {
        this.setWinner(winner);
        this.setWinnerType(winnerType);
        this.setTimeTaken(timeTaken);
        this.setNumberOfTurns(numberOfTurns);
        this.setWinningSymbol(winningSymbol);
    }

    /**
     * Converts the statistics collected from the game into a concatenated string
     * and calls a function to save to 'scores.txt'
     */
    public void saveScorecard() {
        //Generate string of results
        String results = ("Noughts & Crosses" + "," + this.getWinner() + "," + this.getWinnerType() + "," + Long.toString(this.getTimeTaken())
                + "," + Integer.toString(this.getNumberOfTurns()) + "," + Character.toString(this.getWinningSymbol()));

        //Save file
        this.saveFile(results);
    }

    private int getNumberOfTurns() {
        return numberOfTurns;
    }

    private void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    private char getWinningSymbol() {
        return winningSymbol;
    }

    private void setWinningSymbol(char winningSymbol) {
        this.winningSymbol = winningSymbol;
    }
}
