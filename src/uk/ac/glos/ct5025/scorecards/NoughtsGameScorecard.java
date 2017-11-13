package uk.ac.glos.ct5025.scorecards;

public class NoughtsGameScorecard extends Scorecard {
    private int numberOfRounds;
    private int numberOfTies;
    private char winningSymbol;

    //Encapsulate fields
    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfTies() {
        return numberOfTies;
    }

    public void setNumberOfTies(int numberOfTies) {
        this.numberOfTies = numberOfTies;
    }

    public char getWinningSymbol() {
        return winningSymbol;
    }

    public void setWinningSymbol(char winningSymbol) {
        this.winningSymbol = winningSymbol;
    }
}
