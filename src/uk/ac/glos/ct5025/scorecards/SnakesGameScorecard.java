package uk.ac.glos.ct5025.scorecards;

public class SnakesGameScorecard extends Scorecard {
    private int numberOfTurns;
    private int laddersClimbed;
    private int snakesFallen;
    private int finalScore;


    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getLaddersClimbed() {
        return laddersClimbed;
    }

    public void setLaddersClimbed(int laddersClimbed) {
        this.laddersClimbed = laddersClimbed;
    }

    public int getSnakesFallen() {
        return snakesFallen;
    }

    public void setSnakesFallen(int snakesFallen) {
        this.snakesFallen = snakesFallen;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }
}