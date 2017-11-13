package uk.ac.glos.ct5025.scorecards;

public abstract class Scorecard {
    private String gameType;
    private String winner;
    private float score;
    private char[] players;
    private int gameDuration;

    //Encapsulate fields
    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public char[] getPlayers() {
        return players;
    }

    public void setPlayers(char[] players) {
        this.players = players;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }

    //Define polymorphic score saving methods
    public void saveNewScore(String gameType, String winner, float score, char[] players, int numberOfRounds, int numberOfTies, char winningSymbol) {
        //
    }

    public void saveNewScore(String gameType, String winner, float score, char[] players, int numberTurns, int laddersClimbed, int snakesFallen) {
        //
    }

    public void saveNewScore(String gameType, String winner, float score, char[] players, int numberDice, int numberRounds) {
        //
    }
}
