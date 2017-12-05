import uk.ac.glos.ct5025.games.*;

public class Main {
    private int gameSelection = 0;
    private int playerSelection = 0;
    private String player1Name;
    private String player2Name;

    public static void main(String[] args) {
        Main game = new Main();
        game.gameMenu();
        game.playerMenu();

        //Dice game selected
        if(game.getGameSelection() == 1) {
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
        else if(game.getGameSelection() == 2) {
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
        else {
            //
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
            System.out.print("Welcome to CT5025 Java Game Deck.");
            System.out.print("\nPlease select an option:\n");
            System.out.print("\n1.  Play Dice Game");
            System.out.print("\n2.  Play Noughts & Crosses");
            System.out.print("\n3.  Play Snakes & Ladders");
            System.out.print("\n4.  View Game Results");
            System.out.print("\n\nMake selection: ");

            //Instantiate scanner
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String selection = scanner.next();

            //Parse user input
            if(selection.equals("1") || selection.equals("2") || selection.equals("3") ||
                    selection.equals("4")) {
                this.setGameSelection(Integer.parseInt(selection));
            }
            else {
                System.out.print("Invalid selection! Try again.");
                System.out.print("\n\n\n");
            }
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
