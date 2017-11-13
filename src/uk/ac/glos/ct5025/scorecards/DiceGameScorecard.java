package uk.ac.glos.ct5025.scorecards;

public class DiceGameScorecard extends Scorecard {
    private int numberOfDice;
    private int numberOfRounds;

    //Encapsulate fields
    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }
}
