package main.java.com.ct5025.scorecards;

import java.io.*;

abstract class Scorecard {
    /**
     * Scorecard is the abstract class containing attributes common to the scorecard objects used in the game deck.
     * @author Coskun Demir
     * @version 1.0
     * @see main.java.com.ct5025.scorecards.DiceGameScorecard
     * @see main.java.com.ct5025.scorecards.NoughtsGameScorecard
     * @see main.java.com.ct5025.scorecards.SnakesGameScorecard
     */
    private String winner;
    private String winnerType;
    private long timeTaken;

    void saveFile(String stringToSave) {
        if (checkFileExists()) {
                //Generate file writer
                File file = new File("scores.txt");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    //Save data to file
                    writer.write(stringToSave +"\n");
                    writer.close();
                }
                catch (java.io.IOException e) {
                    System.out.print("An error occurred. Error code: " + e.getMessage());
                }
        }
        else {
            //Create new file and save data to file
            try {
                PrintWriter writer = new PrintWriter("scores.txt");
                writer.println(stringToSave);
                writer.close();
            }
            catch (FileNotFoundException e) {
                System.out.print("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Checks whether 'scores.txt' is a file that exists
     * @return true if 'scores.txt' exists
     */
    boolean checkFileExists() {
        File scoreFile = new File("scores.txt");
        return scoreFile.exists();
    }

    String getWinner() {
        return winner;
    }

    void setWinner(String winner) {
        this.winner = winner;
    }

    long getTimeTaken() {
        return timeTaken;
    }

    void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    String getWinnerType() {
        return winnerType;
    }

    void setWinnerType(String winnerType) {
        this.winnerType = winnerType;
    }
}
