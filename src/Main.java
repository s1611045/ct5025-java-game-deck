import uk.ac.glos.ct5025.games.*;

public class Main {
    private int gameSelection = 0;
    private int playerSelection = 0;

    public static void main(String[] args) {
        Main game = new Main();
        game.gameMenu();
        game.playerMenu();

        if(game.getGameSelection() == 1) {
            if(game.getPlayerSelection() == 1) {
                DiceGame diceGame = new DiceGame(1);
            }
            else if (game.getPlayerSelection() == 2) {
                DiceGame diceGame = new DiceGame(2);
            }
            else {
                DiceGame diceGame = new DiceGame(3);
            }
        }
        else if(game.getGameSelection() == 2) {
            if(game.getPlayerSelection() == 1) {
                NoughtsGame noughtsGame = new noughtsGame();
            }
            NoughtsGame noughtsGame = new NoughtsGame();
        }
        else if (game.getGameSelection() == 3) {
            //
        }
        else {
            //
        }
    }

    public void playerMenu() {
        while(this.getPlayerSelection()==0) {
            //Print menu
            System.out.print("\nSelect players:");
            System.out.print("\n1.  Human vs. Computer");
            System.out.print("\n2.  Human vs. Human");
            System.out.print("\n3.  Computer vs. Computer");
            System.out.print("\n\nMake selection:");

            //Instantiate scanner
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String selection = scanner.next();

            //Parse user input
            if(selection == "1" || selection == "2" || selection == "3") {
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
            if(selection == "1" || selection == "2" || selection == "3" ||
                    selection == "4") {
                this.setGameSelection(Integer.parseInt(selection));
            }
            else {
                System.out.print("Invalid selection! Try again.");
                System.out.print("\n\n\n");
            }
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
