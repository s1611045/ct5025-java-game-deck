import uk.ac.glos.ct5025.games.*;
import java.io.*;

public class Main {
    private int gameSelection = 0;
    private int playerSelection = 0;
    private int computerWins = 0;
    private int humanWins = 0;

    public static void main(String[] args) {
        int selection = 0;
        while (!(selection == 5)) {
            Main game = new Main();
            game.gameMenu();

            //Dice game selected
            if (game.getGameSelection() == 1) {
                game.playerMenu();
                String[] names = game.getNames(game.playerSelection);
                //Computer vs. computer
                if (names[0].equals("")) {
                    DiceGame diceGame = new DiceGame();
                }
                //Human vs. computer
                else if ((names[1].equals(""))) {
                    DiceGame diceGame = new DiceGame(names[0]);
                }
                //Human vs. human
                else {
                    DiceGame diceGame = new DiceGame(names[0], names[1]);
                }
            }

            //Noughts and crosses selected
            else if (game.getGameSelection() == 2) {
                game.playerMenu();
                String[] names = game.getNames(game.playerSelection);
                //Computer vs. computer
                if (names[0].equals("")) {
                    NoughtsGame noughtsGame = new NoughtsGame();
                }
                //Human vs. computer
                else if ((names[1].equals(""))) {
                    NoughtsGame noughtsGame = new NoughtsGame(names[0]);
                }
                //Human vs. human
                else {
                    NoughtsGame noughtsGame = new NoughtsGame(names[0], names[1]);
                }
            }

            //Snakes and ladders selected
            else if (game.getGameSelection() == 3) {
                game.playerMenu();
                String[] names = game.getNames(game.playerSelection);
                //Computer vs. computer
                if (names[0].equals("")) {
                    SnakesGame SnakesGame = new SnakesGame();
                }
                //Human vs. computer
                else if ((names[1].equals(""))) {
                    SnakesGame SnakesGame = new SnakesGame(names[0]);
                }
                //Human vs. human
                else {
                    SnakesGame snakesGame = new SnakesGame(names[0], names[1]);
                }
            }

            //View game results elected
            else if (game.getGameSelection() == 4) {
                game.readScoreFile();
            }

            //Exit game selected
            else {
                selection = 5;
            }
        }
    }
    
    public String[] getNames(int players) {
        String input[] = new String[2];
        input[0] = "";
        boolean validName = false;

        //If human vs. human selected, ask for name only once
        if(players == 1) {
            while(!validName) {
                System.out.print("\nEnter the name of the human player: ");
                java.util.Scanner scanner = new java.util.Scanner(System.in);

                input[0] = scanner.next();
                input[1] = "";
                if (this.validateName(input)) {
                    validName = true;
                }
                else {
                    System.out.print("\nThat name is not allowed! Try again.\n");
                }
            }
            return input;
        }
        else if(players == 2) {
            System.out.print("\nEnter the name of the first human player: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);

            input[0] = scanner.next();

            System.out.print("\nEnter the name of the second human player: ");
            input[1] = scanner.next();

            return input;
        }
        else {
            return input;
        }
    }

    public void playerMenu() {
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

    public void gameMenu() {
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

    public void readScoreFile() {
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
                System.out.print("Humans have won " + this.humanWins + " games and computers have won " + this.computerWins
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

    private void printStatistic(String[] line, int game) {
        System.out.print("\n\nGame #" + game);
        for (int i=0;i<line.length;i++) {
            if (i == 0) {
                System.out.print("\n    Game name: " + line[i]);
            }
            else if (i == 1) {
                System.out.print("\n    Winner: " + line[i]);
            }
            else if (i == 2) {
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
            }
            else if (i == 3) {
                System.out.print("\n    Time taken (seconds): " + line[i]);
            }
            else if (i == 4) {
                System.out.print("\n    Number of dice/number of turns taken: " + line[i]);
            }
            else if (i == 5) {
                System.out.print("\n    Final score/winning symbol: " + line[i]);
            }
            else if (i == 6) {
                System.out.print("\n    Ladders climbed: " + line[i]);
            }
            else {
                System.out.print("\n    Snakes fallen: " + line[i]);
            }
        }
        System.out.print("\n");
    }

    private boolean checkFileExists() {
        File scoreFile = new File("scores.txt");
        if (scoreFile.exists()) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean validateName(String[] input) {
        if (!(input[0].equals("Draw")) && !(input[1].equals("Draw"))) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getGameSelection() {
        return gameSelection;
    }

    public void setGameSelection(int gameSelection) {
        this.gameSelection = gameSelection;
    }

    public int getPlayerSelection() {
        return playerSelection;
    }

    public void setPlayerSelection(int playerSelection) {
        this.playerSelection = playerSelection;
    }
}
