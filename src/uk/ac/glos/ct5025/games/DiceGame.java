package uk.ac.glos.ct5025.games;
import uk.ac.glos.ct5025.players.*;
import uk.ac.glos.ct5025.scorecards.DiceGameScorecard;
import java.lang.reflect.Array;

//TODO: assign players correctly based on input from main menu
//      currently, if option 1 in player selection (human vs. computer)
//      is chosen, the game starts with computer vs. computer

public class DiceGame extends Game{
    private int NUMBER_OF_DICE;
    private String currentPlayerTurn;
    private int[] player1Array;
    private int[] player2Array;
    private String winner = "";
    private DiceGameScorecard scorecard = new DiceGameScorecard();

    //Instantiate player instances polymorphously based on user input
    public DiceGame(String playerName) {
        System.out.print("Starting new game with human vs. computer\n");
        this.player1 = new Human(playerName);
        this.player2 = new Computer();
        this.NUMBER_OF_DICE = askForDice();
        this.playGame();
    }

    public DiceGame(String player1Name, String player2Name) {
        System.out.print("Starting new game with human vs. human\n");
        this.player1 = new Human(player1Name);
        this.player2 = new Human(player2Name);
        this.NUMBER_OF_DICE = askForDice();
        this.playGame();
    }

    public DiceGame() {
        System.out.print("Starting new game with computer vs. computer\n");
        this.player1 = new Computer();
        this.player2 = new Computer();
        this.NUMBER_OF_DICE = askForDice();
        this.playGame();
    }
    /////////////////////////////////////////////////////////////////

    public void playGame() {
        //Initialise values used in method
        long startTime = System.currentTimeMillis();
        this.currentPlayerTurn = this.player1.name;
        int player1Total = 0;
        int player2Total = 0;

        //Initialise dice roll result arrays
        this.player1Array = new int[this.NUMBER_OF_DICE];
        this.player2Array = new int[this.NUMBER_OF_DICE];

        while(this.getWinner().equals("")) {
            this.printCurrentTurn();
            //Roll dice
            //Player 1
            if ((this.currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Human)) {
                System.out.print("\nPress ENTER to make your move. The dice will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                this.player1Array = dieRoll(this.player1Array);
                this.printRollResult(this.player1Array, this.currentPlayerTurn);
                this.currentPlayerTurn = player2.name;
            }
            else if ((this.currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Computer)) {
                this.player1Array = dieRoll(this.player1Array);
                this.printRollResult(this.player1Array, this.currentPlayerTurn);
                this.currentPlayerTurn = player2.name;
            }
            //Player 2
            this.printCurrentTurn();
            if ((this.currentPlayerTurn.equals(this.player2.name)) && (player2 instanceof Human)) {
                System.out.print("\nPress ENTER to make your move. The dice will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                this.player2Array = dieRoll(this.player2Array);
                this.printRollResult(this.player2Array, this.currentPlayerTurn);
            }
            else {
                this.player2Array = dieRoll(this.player2Array);
                this.printRollResult(this.player2Array, this.currentPlayerTurn);
            }

            //Parse arrays to create totals
            for (int aPlayer1Array : player1Array) {
                player1Total = player1Total + aPlayer1Array;
            }
            for (int aPlayer2Array : player2Array) {
                player2Total = player2Total + aPlayer2Array;
            }
            this.printTotals(player1Total, player2Total);

            //Compare results and set winner accordingly
            if (player1Total > player2Total) {
                this.setWinner(player1.name);
            }
            else if (player1Total < player2Total) {
                this.setWinner(player2.name);
            }
            else {
                this.setWinner("Draw");
            }
        }

        if (this.getWinner().equals("Draw")) {
            System.out.print("\nIt's a tie!\n");
        }
        else {
            System.out.print("\n" + this.currentPlayerTurn + " wins!\n");
        }

        this.timeTaken = ((System.currentTimeMillis() - startTime)/1000);
        System.out.print("\nThis game took " + this.timeTaken + " seconds.");
    }

    public void printCurrentTurn() {
        System.out.print("\nIt is " + this.currentPlayerTurn + "'s turn.\n");
    }

    public void printRollResult(int[] playerArray, String player) {
        System.out.print("\n");
        for (int aPlayerArray : playerArray) {
            System.out.print("[" + aPlayerArray + "]");
        }
        System.out.print("\n");
    }

    public void printTotals(int player1Total, int player2Total) {
        System.out.print("\n");
        System.out.print(this.player1.name + " scored " + player1Total + " overall.\n");
        System.out.print(this.player2.name + " scored " + player2Total + " overall.\n");
    }

    public int askForDice() {
        boolean validInput = false;
        String inputString = "";

        while(!validInput) {
            System.out.print("\nPlease enter the number of dice you wish to use, between 1 and 5: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            inputString = scanner.next();

            if (!Character.isDigit(inputString.charAt(0))) {
                System.out.print("\nInvalid input! Try again. Error 1: You have not entered a number.\n");
                validInput = false;
            }
            else if (!inputString.matches("^[1-5]")) {
                System.out.print("\nInvalid input! Try again. Error 2: Your number is not between 1 and 5.\n");
                validInput = false;
            }
            else {
                validInput = true;
            }
        }
        return Character.getNumericValue(inputString.charAt(0));
    }

    public int[] dieRoll(int[] playerArray) {
        //Generate and return random number from 1-6
        java.util.Random rnd = new java.util.Random();
        for (int i=0;i<Array.getLength(playerArray);i++) {
            playerArray[i] = rnd.nextInt(6);
        }
        return playerArray;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}