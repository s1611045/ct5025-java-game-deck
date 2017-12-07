package main.java.com.ct5025.scorecards;

import java.io.*;

public abstract class Scorecard {
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

    protected boolean checkFileExists() {
        File scoreFile = new File("scores.txt");
        if (scoreFile.exists()) {
            return true;
        }
        else {
            return false;
        }
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
