package main.java.com.ct5025;

import main.java.com.ct5025.games.DiceGame;
import main.java.com.ct5025.games.NoughtsGame;
import main.java.com.ct5025.games.SnakesGame;
import java.lang.*;

import java.io.*;

public class Main {
    /**
     * Main defines the first function and class instantiated by the JVM.
     * It contains the static function that is first executed, as well as code to instantiate and play the games in the deck.
     * The program closes upon static function code completion, i.e. when the user first inputs '5' in order to exit.
     *
     * @author Coskun Demir
     * @version 1.0
     */
    private int gameSelection = 0;
    private int playerSelection = 0;
    private int computerWins = 0;
    private int humanWins = 0;

    /**
     * main is the static function that the JVM runs automatically on program run.
     * @param args generic arguments
     */
    public static void main(String[] args) {
        int selection = 0;
        while (!(selection == 5)) {
            Main game = new Main();
            game.gameMenu();

            //Dice game selected
            switch (game.getGameSelection()) {
                case 1: {
                    game.playerMenu();
                    String[] names = game.getNames(game.playerSelection);
                    //Computer vs. computer
                    if (names[0].equals("")) {
                        DiceGame diceGame = new DiceGame();
                        diceGame.playGame();
                    }
                    //Human vs. computer
                    else if ((names[1].equals(""))) {
                        DiceGame diceGame = new DiceGame(names[0]);
                        diceGame.playGame();
                    }
                    //Human vs. human
                    else {
                        DiceGame diceGame = new DiceGame(names[0], names[1]);
                        diceGame.playGame();
                    }
                    break;
                }

                //Noughts and crosses selected
                case 2: {
                    game.playerMenu();
                    String[] names = game.getNames(game.playerSelection);
                    //Computer vs. computer
                    if (names[0].equals("")) {
                        NoughtsGame noughtsGame = new NoughtsGame();
                        noughtsGame.playGame();
                    }
                    //Human vs. computer
                    else if ((names[1].equals(""))) {
                        NoughtsGame noughtsGame = new NoughtsGame(names[0]);
                        noughtsGame.playGame();
                    }
                    //Human vs. human
                    else {
                        NoughtsGame noughtsGame = new NoughtsGame(names[0], names[1]);
                        noughtsGame.playGame();
                    }
                    break;
                }

                //Snakes and ladders selected
                case 3: {
                    game.playerMenu();
                    String[] names = game.getNames(game.playerSelection);
                    //Computer vs. computer
                    if (names[0].equals("")) {
                        SnakesGame snakesGame = new SnakesGame();
                        snakesGame.playGame();
                    }
                    //Human vs. computer
                    else if ((names[1].equals(""))) {
                        SnakesGame snakesGame = new SnakesGame(names[0]);
                        snakesGame.playGame();
                    }
                    //Human vs. human
                    else {
                        SnakesGame snakesGame = new SnakesGame(names[0], names[1]);
                        snakesGame.playGame();
                    }
                    break;
                }

                //View game results elected
                case 4:
                    game.readScoreFile();
                    break;

                //Exit game selected
                default:
                    selection = 5;
                    break;
            }
        }
    }

    /**
     * getNames checks its input, recognising whether there are 1, 2, or 0 human players.
     * <p>
     * It then asks the user for the names of the respective human players.
     * @param players selection that determines how many human players there will be
     * @return  a string array containing the names of the human players
     */
    private String[] getNames(int players) {
        String input[] = new String[2];
        input[0] = "";
        boolean validName = false;

        //If human vs. human selected, ask for name only once
        switch (players) {
            case 1:
                while (!validName) {
                    System.out.print("\nEnter the name of the human player: ");
                    java.util.Scanner scanner = new java.util.Scanner(System.in);

                    input[0] = scanner.next();
                    input[1] = "";
                    if (this.validateName(input)) {
                        validName = true;
                    } else {
                        System.out.print("\nThat name is not allowed! Try again.\n");
                    }
                }
                return input;
            case 2:
                System.out.print("\nEnter the name of the first human player: ");
                java.util.Scanner scanner = new java.util.Scanner(System.in);

                input[0] = scanner.next();

                System.out.print("\nEnter the name of the second human player: ");
                input[1] = scanner.next();

                return input;
            default:
                return input;
        }
    }

    /**
     * playerMenu prints a menu screen to the user asking them whether they would like to play with
     * one human player, two human players, or no human players.
     * <p>
     * The users' selection, upon being validated, is then assigned to main.playerSelection.
     */
    private void playerMenu() {
        while(this.getPlayerSelection()==0) {
            //Print menu
            System.out.print("\n\nSelect players:");
            System.out.print("\n1.  Human vs. Computer");
            System.out.print("\n2.  Human vs. Human");
            System.out.print("\n3.  Computer vs. Computer");
            System.out.print("\n\nMake selection: ");

            //Instantiate scanner
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String selection = scanner.next();

            //Parse user input
            if(selection.equals("1") || selection.equals("2") || selection.equals("3")) {
                this.setPlayerSelection(Integer.parseInt(selection));
            }
            else {
                System.out.print("Invalid selection! Please try again.");
                System.out.print("\n\n\n");
            }
        }
    }

    /**
     * gameMenu prints a menu screen to the user asking them which game they would like to play,
     * or if they would like to exit the program.
     */
    private void gameMenu() {
        while(this.getGameSelection()==0) {
            //Print game menu
            System.out.print("\nWelcome to CT5025 Java Game Deck.");
            System.out.print("\nPlease select an option:\n");
            System.out.print("\n1.  Play Dice Game");
            System.out.print("\n2.  Play Noughts & Crosses");
            System.out.print("\n3.  Play Snakes & Ladders");
            System.out.print("\n4.  View Game Results");
            System.out.print("\n5.  Exit");
            System.out.print("\n\nMake selection: ");

            //Instantiate scanner
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String selection = scanner.next();

            //Parse user input
            if(selection.equals("1") || selection.equals("2") || selection.equals("3") ||
                    selection.equals("4") || selection.equals("5")) {
                this.setGameSelection(Integer.parseInt(selection));
            }
            else {
                System.out.print("Invalid selection! Try again.");
                System.out.print("\n\n\n");
            }
        }
    }

    /**
     * readScoreFile opens the 'scores.txt' file, navigates to the final 10 entries of the file, parses the
     * received string, and runs printStatistic to display them to the user.
     * <p>
     * If there are 10 or less entries in the file, all lines are received and displayed to the user.
     * <p>
     * Finally, the function outputs a statistic stating how many of those 10 games humans had won,
     * and how many games computers had won.
     */
    private void readScoreFile() {
        if(checkFileExists()) {
            File file = new File("scores.txt");
            int fileLength = 0;
            try {
                FileReader lengthFileReader = new FileReader(file);
                FileReader fileReader = new FileReader(file);
                BufferedReader lengthReader = new BufferedReader(lengthFileReader);
                BufferedReader reader = new BufferedReader(fileReader);

                while(lengthReader.readLine() != null) {
                    fileLength++;
                }
                //Close to reset reader after use
                lengthReader.close();

                if (fileLength <= 10) {
                    int game = 1;
                    for (int i=0;i<=fileLength-1;i++) {
                        String[] lineContents;
                        lineContents = reader.readLine().split(",");
                        this.printStatistic(lineContents, game);
                        game++;
                    }
                }
                else {
                    int lineCounter = 0;
                    int game = 1;
                    while (lineCounter < fileLength-10) {
                        reader.readLine();
                        lineCounter++;
                    }
                    for (int i=fileLength-10;i<fileLength;i++) {
                        String[] lineContents;
                        lineContents = reader.readLine().split(",");
                        this.printStatistic(lineContents, game);
                        game++;
                    }
                    reader.close();
                }
                System.out.print("\nHumans have won " + this.humanWins + " games and computers have won " + this.computerWins
                + " games.\n\n");
            }
            catch (FileNotFoundException e) {
                System.out.print("The scores file could not be found! Error code: " + e.getMessage());
            }
            catch (IOException e) {
                System.out.print("There is a problem with the scores file. Error code: " + e.getMessage());
            }
        }
        else {
            System.out.print("The scores file does not exist. Either you have not played a game yet, or the" +
                    " file has been deleted.");
        }

        //Return to menu
        System.out.print("Press ENTER to return to menu: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String blank = scanner.nextLine();
    }

    /**
     * printStatistic parses elements of the input string array, and prints the respective values to the user,
     * with their names and meanings.
     * @param line  the array containing the elements to parse
     * @param game  the game number (out of 10) to display to the user
     */
    private void printStatistic(String[] line, int game) {
        System.out.print("\n\nGame #" + game);
        for (int i=0;i<line.length;i++) {
            switch (i) {
                case 0:
                    System.out.print("\n    Game name: " + line[i]);
                    break;
                case 1:
                    System.out.print("\n    Winner: " + line[i]);
                    break;
                case 2:
                    //Add human win to counter if human was the winner
                    if (line[i].equals("Human")) {
                        this.humanWins++;
                    }
                    //Otherwise add computer win to counter
                    else {
                        this.computerWins++;
                    }
                    //Print winner type regardless
                    System.out.print("\n    Winner type: " + line[i]);
                    break;
                case 3:
                    System.out.print("\n    Time taken (seconds): " + line[i]);
                    break;
                case 4:
                    System.out.print("\n    Number of dice/number of turns taken: " + line[i]);
                    break;
                case 5:
                    System.out.print("\n    Final score/winning symbol: " + line[i]);
                    break;
                case 6:
                    System.out.print("\n    Ladders climbed: " + line[i]);
                    break;
                default:
                    System.out.print("\n    Snakes fallen: " + line[i]);
                    break;
            }
        }
        System.out.print("\n");
    }

    /**
     * checkFileExists checks whether the 'scores.txt' file exists.
     * @return  true if 'scores.txt' exists
     */
    private boolean checkFileExists() {
        File scoreFile = new File("scores.txt");
        return scoreFile.exists();
    }

    /**
     * validateName ensures that the human names input by the user are  not "Draw".
     * @param input string array containing human names input by the user
     * @return  true if neither element in the input array are not "Draw"
     */
    public boolean validateName(String[] input) {
        return !(input[0].equals("Draw")) && !(input[1].equals("Draw"));
    }

    private int getGameSelection() {
        return gameSelection;
    }

    private void setGameSelection(int gameSelection) {
        this.gameSelection = gameSelection;
    }

    private int getPlayerSelection() {
        return playerSelection;
    }

    private void setPlayerSelection(int playerSelection) {
        this.playerSelection = playerSelection;
    }
}
