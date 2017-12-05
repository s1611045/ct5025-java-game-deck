package uk.ac.glos.ct5025.scorecards;

public class DiceGameScorecard extends Scorecard {
    private int numberOfDice;
    private int winningScore;


    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getWinningScore() {
        return winningScore;
    }

    public void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }
}
