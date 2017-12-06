package main.java.com.ct5025.scorecards;

public class NoughtsGameScorecard extends Scorecard {
    private int numberOfTurns;
    private char winningSymbol;

    public NoughtsGameScorecard(String winner, String winnerType, long timeTaken, int numberOfTurns, char winningSymbol) {
        this.setWinner(winner);
        this.setWinnerType(winnerType);
        this.setTimeTaken(timeTaken);
        this.setNumberOfTurns(numberOfTurns);
        this.setWinningSymbol(winningSymbol);
    }
    public void saveScorecard() {
        //Generate string of results
        String results = ("Noughts & Crosses" + "," + this.getWinner() + "," + this.getWinnerType() + "," + Long.toString(this.getTimeTaken())
                + "," + Integer.toString(this.getNumberOfTurns()) + "," + Character.toString(this.getWinningSymbol()));

        //Save file
        this.saveFile(results);
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public char getWinningSymbol() {
        return winningSymbol;
    }

    public void setWinningSymbol(char winningSymbol) {
        this.winningSymbol = winningSymbol;
    }
}
