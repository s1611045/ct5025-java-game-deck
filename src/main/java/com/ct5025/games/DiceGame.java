package main.java.com.ct5025.games;

import main.java.com.ct5025.players.Computer;
import main.java.com.ct5025.players.Human;
import main.java.com.ct5025.scorecards.DiceGameScorecard;
import java.lang.reflect.Array;

public class DiceGame extends Game{
    /**
     * DiceGame is an extension of Game, and represents the functional code that plays the Dice Game in the game deck.
     * @author Coskun Demir
     * @version 1.0
     */
    private int NUMBER_OF_DICE = 0;
    private String winner = "";
    private int winningScore;

    //Instantiate player instances polymorphously based on user input

    /**
     * A constructor method creating a new human player object and a new computer player object
     * @param playerName    the name of the human player passed from Main when instantiated
     */
    public DiceGame(String playerName) {
        System.out.print("Starting new game with human vs. computer\n");
        this.player1 = new Human(playerName);
        this.player2 = new Computer();
    }

    /**
     * A constructor method creating two new human player objects
     * @param player1Name   the name of one human player passed from Main when instantiated
     * @param player2Name   the name of the second human player passed from Main when instantiated
     */
    public DiceGame(String player1Name, String player2Name) {
        System.out.print("Starting new game with human vs. human\n");
        this.player1 = new Human(player1Name);
        this.player2 = new Human(player2Name);
    }

    /**
     * A constructor method creating two computer player objects
     */
    public DiceGame() {
        System.out.print("Starting new game with computer vs. computer\n");
        this.player1 = new Computer();
        this.player2 = new Computer();
    }
    /////////////////////////////////////////////////////////////////

    /**
     * playGame is the functional code that plays the dice game.
     */
    @SuppressWarnings("unused")
    public void playGame() {
        //Get and set number of dice
        this.setNUMBER_OF_DICE(askForDice());

        //Initialise values used in method
        long startTime = System.currentTimeMillis();
        this.currentPlayerTurn = this.player1.name;
        int player1Total = 0;
        int player2Total = 0;

        //Initialise dice roll result arrays
        int[] player1Array = new int[this.getNUMBER_OF_DICE()];
        int[] player2Array = new int[this.getNUMBER_OF_DICE()];

        while(this.getWinner().equals("")) {
            this.printCurrentTurn();
            //Roll dice
            //Player 1
            if ((this.currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Human)) {
                System.out.print("\nPress ENTER to make your move. The dice will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                player1Array = dieRoll(player1Array);
                this.printRollResult(player1Array);
                this.currentPlayerTurn = player2.name;
            }
            else if ((this.currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Computer)) {
                player1Array = dieRoll(player1Array);
                this.printRollResult(player1Array);
                this.currentPlayerTurn = player2.name;
            }
            //Player 2
            this.printCurrentTurn();
            if ((this.currentPlayerTurn.equals(this.player2.name)) && (player2 instanceof Human)) {
                System.out.print("\nPress ENTER to make your move. The dice will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                player2Array = dieRoll(player2Array);
                this.printRollResult(player2Array);
            }
            else {
                player2Array = dieRoll(player2Array);
                this.printRollResult(player2Array);
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
                this.setWinningScore(player1Total);
            }
            else if (player1Total < player2Total) {
                this.setWinner(player2.name);
                this.setWinningScore(player2Total);
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

        //Generate scorecard and save to file
        DiceGameScorecard scorecard = this.generateScorecard();
        scorecard.saveScorecard();
        System.out.print("\nScores saved to file.");

        //Return to menu
        System.out.print("\nPress ENTER to return to menu: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String blank = scanner.nextLine();
    }

    /**
     * generateScorecard creates a new DiceGameScorecard object and passes the statistics from the duration of the game.
     * @return  a new DiceGameScorecard object with appropriate game statistics
     */
    private DiceGameScorecard generateScorecard() {
        String winnerType = this.getWinnerType();

        return new DiceGameScorecard(this.getWinner(), winnerType, this.timeTaken, this.getNUMBER_OF_DICE(),
                this.getWinningScore());
    }

    /**
     * getWinnerType checks the winner and object type of the winner to determine if the winner was a human, computer, or netiher.
     * @return  a string containing the type of winner of the game
     */
    public String getWinnerType() {
        if (this.getWinner().equals("Draw")) {
            return "None";
        }
        else if (this.getWinner().equals(this.player1.name) && player1 instanceof Human) {
            return "Human";
        }
        else if (this.getWinner().equals(this.player1.name) && player1 instanceof Computer) {
            return "Computer";
        }
        else if (this.getWinner().equals(this.player2.name) && player2 instanceof Human) {
            return "Human";
        }
        else {
            return "Computer";
        }
    }

    /**
     * printCurrentTurn checks the currentPlayerTurn attribute and prints to the user who's turn it is.
     */
    private void printCurrentTurn() {
        System.out.print("\nIt is " + this.currentPlayerTurn + "'s turn.\n");
    }

    /**
     * printRollResult checks the values of each die roll passed to the function and prints it to the user, alongside the player that rolled the dice.
     * @param playerArray   an array containing each die roll result from a player
     *
     */
    private void printRollResult(int[] playerArray) {
        System.out.print("\n");
        for (int aPlayerArray : playerArray) {
            System.out.print("[" + aPlayerArray + "]");
        }
        System.out.print("\n");
    }

    /**
     * printTotals prints the total combined value of each die roll of each player.
     * @param player1Total  the total value of the dice roll result scored by player 1
     * @param player2Total  the total value of the dice roll result scored by player 2
     */
    private void printTotals(int player1Total, int player2Total) {
        System.out.print("\n");
        System.out.print(this.player1.name + " scored " + player1Total + " overall.\n");
        System.out.print(this.player2.name + " scored " + player2Total + " overall.\n");
    }

    /**
     * askForDice asks the user how many dice they wish to use in the game instance.
     * @return  integer containing the number of dice the players wish to use in the game
     */
    private int askForDice() {
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

    /**
     * dieRoll generates a random number between 0 and 6 for the number of dice the user has selected.
     * @param playerArray   the array of die roll values corresponding to the player
     * @return  the array with newly written-to values
     */
    private int[] dieRoll(int[] playerArray) {
        //Generate and return random number from 1-6
        java.util.Random rnd = new java.util.Random();
        for (int i=0;i<Array.getLength(playerArray);i++) {
            playerArray[i] = rnd.nextInt(6);
        }
        return playerArray;
    }

    private String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    private int getWinningScore() {
        return winningScore;
    }

    private void setWinningScore(int winningScore) {
        this.winningScore = winningScore;
    }

    private int getNUMBER_OF_DICE() {
        return NUMBER_OF_DICE;
    }

    public void setNUMBER_OF_DICE(int NUMBER_OF_DICE) {
        this.NUMBER_OF_DICE = NUMBER_OF_DICE;
    }
}