package uk.ac.glos.ct5025.scorecards;

public class NoughtsGameScorecard extends Scorecard {
    private int numberOfTurns;
    private char winningSymbol;

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
