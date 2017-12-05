package uk.ac.glos.ct5025.scorecards;

public class DiceGameScorecard extends Scorecard {
    private int numberOfDice;
    private int winningScore;

    public DiceGameScorecard(String winner, String winnerType, long timeTaken, int dice, int score) {
        this.setWinner(winner);
        this.setWinnerType(winnerType);
        this.setTimeTaken(timeTaken);
        this.setNumberOfDice(dice);
        this.setWinningScore(score);
    }
    public void saveScorecard() {
        //Generate string of results
        String results = ("Dice Game" + "," + this.getWinner() + "," + this.getWinnerType() + "," + Long.toString(this.getTimeTaken())
        + "," + Integer.toString(this.getNumberOfDice()) + "," + Integer.toString(this.getWinningScore()));

        //Save file
        this.saveFile(results);
    }

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
