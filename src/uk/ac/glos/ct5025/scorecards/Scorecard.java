package uk.ac.glos.ct5025.scorecards;

import java.io.*;

public abstract class Scorecard {
    private String gameType;
    private String winner;
    private String winnerType;
    private long timeTaken;

    void saveFile(String stringToSave) {
        if (checkFileExists()) {
            try {
                //Generate file writer
                File file = new File("scores.txt");
                PrintStream printStream = new PrintStream(file);

                //Save data to file
                printStream.println(stringToSave);
                printStream.close();
            }
            catch (java.io.FileNotFoundException e) {
                System.out.print("The file does not exist. Check it has not been moved. Error code: " + e.getMessage());
            }
        }
    }

    boolean checkFileExists() {
        File scoreFile = new File("scores.txt");
        if (scoreFile.exists()) {
            return true;
        }
        else {
            return false;
        }
    }

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

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public String getWinnerType() {
        return winnerType;
    }

    public void setWinnerType(String winnerType) {
        this.winnerType = winnerType;
    }
}
