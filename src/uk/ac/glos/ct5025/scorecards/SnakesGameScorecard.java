package uk.ac.glos.ct5025.scorecards;

public class SnakesGameScorecard extends Scorecard {
    private int numberOfTurns;
    private int laddersClimbed;
    private int snakesFallen;
    private int finalScore;

    public SnakesGameScorecard(String winner, String winnerType, long timeTaken, int turns,
                               int score, int ladders, int snakes) {
        this.setWinner(winner);
        this.setWinnerType(winnerType);
        this.setTimeTaken(timeTaken);
        this.setNumberOfTurns(turns);
        this.setFinalScore(score);
        this.setLaddersClimbed(ladders);
        this.setSnakesFallen(snakes);
    }

    public void saveScorecard() {
        //Generate string of results
        String results = ("Snakes & Ladders" + "," + this.getWinner() + "," + this.getWinnerType() + "," + Long.toString(this.getTimeTaken())
                + "," + Integer.toString(this.getNumberOfTurns()) + "," + Integer.toString(this.getFinalScore()) + ","
                + Integer.toString(this.getLaddersClimbed()) + "," + Integer.toString(this.getSnakesFallen()));

        //Save file
        this.saveFile(results);
    }

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