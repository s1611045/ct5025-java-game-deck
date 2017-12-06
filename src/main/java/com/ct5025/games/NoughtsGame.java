package main.java.com.ct5025.games;
import main.java.com.ct5025.players.Computer;
import main.java.com.ct5025.players.Human;
import main.java.com.ct5025.players.Player;
import main.java.com.ct5025.scorecards.NoughtsGameScorecard;

public class NoughtsGame extends Game {
    private final int BOARD_DIMENSION = 3;
    private char[][] gameBoard = new char[BOARD_DIMENSION][BOARD_DIMENSION];
    private String winner = "";
    private Player player1;
    private Player player2;
    private char currentPlayerSymbol = 'o';
    private int gameCounter = 0;

    //Instantiate player instances polymorphously based on user input
    public NoughtsGame(String playerName) {
        System.out.print("Starting new game with human vs. computer\n");
        this.player1 = new Human(playerName);
        this.player2 = new Computer();
        this.playGame();
    }

    public NoughtsGame(String player1Name, String player2Name) {
        System.out.print("Starting new game with human vs. human\n");
        this.player1 = new Human(player1Name);
        this.player2 = new Human(player2Name);
        this.playGame();
    }

    public NoughtsGame() {
        System.out.print("Starting new game with computer vs. computer\n");
        this.player1 = new Computer();
        this.player2 = new Computer();
        this.playGame();
    }
    /////////////////////////////////////////////////////////////////

    private void playGame() {
        long startTime = System.currentTimeMillis();
        while(this.getWinner() == "") {
            //Print board
            if (this.currentPlayerSymbol == 'o') {
                System.out.print("\nIt is currently " + this.player1.name + "'s turn.\n" + "It is turn: " + (this.gameCounter+1) + "\n\n");
            }
            else {
                System.out.print("\nIt is currently " + this.player2.name + "'s turn.\n" + "It is turn: " + (this.gameCounter+1) + "\n\n");
            }
            this.printGameBoard();

            //Get current player type and ask them for move
            if(currentPlayerSymbol == 'o') {
                //'If player1 is human, ask them for move'
                if(player1 instanceof Human) {
                    this.humanMove();
                    this.gameCounter++;
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else if (this.gameCounter == 9) {
                        this.setWinner("Draw");
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
                else {
                    this.computerMove();
                    this.gameCounter++;
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else if (this.gameCounter == 9) {
                        this.setWinner("Draw");
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
            }
            else {
                if (player2 instanceof Human) {
                    this.humanMove();
                    this.gameCounter++;
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else if (this.gameCounter == 9) {
                        this.setWinner("Draw");
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
                else {
                    this.computerMove();
                    this.gameCounter++;
                    if (this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else if (this.gameCounter == 9) {
                        this.setWinner("Draw");
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
            }
        }

        //Record time taken in game
        this.timeTaken = ((System.currentTimeMillis() - startTime)/1000);

        this.printGameBoard();
        if (this.getWinner().equals("Draw")) {
            System.out.print("It's a tie!");
            System.out.print("\nThis game took " + this.timeTaken + " seconds.");
        }
        else {
            if (this.currentPlayerSymbol == 'o') {
                System.out.print(this.player1.name + " wins!");
            }
            else {
                System.out.print(this.player2.name + " wins!");
            }
            System.out.print("\nThis game took " + this.timeTaken + " seconds.");
        }

        //Generate scorecard and save to file
        NoughtsGameScorecard scorecard = new NoughtsGameScorecard(this.getWinner(), this.getWinnerType(), timeTaken,
                this.gameCounter, this.currentPlayerSymbol);
        scorecard.saveScorecard();
        System.out.print("\nScores saved to file.");

        //Return to menu
        System.out.print("\nPress ENTER to return to menu: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String blank = scanner.nextLine();
    }

    private void humanMove() {
        boolean moveMade = false;
        int[] move;

        while(!moveMade) {
            move = getCoordinates();
            if(checkSquareContainsSymbol(move[0], move[1])) {
                moveMade = false;
            }
            else {
                addSymbolToBoard(move[0], move[1], this.currentPlayerSymbol);
                moveMade = true;
            }
        }
    }

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

    private int[] getCoordinates() {
        boolean isValidInput = false;
        int row = 0;
        String inputString = "";

        while (!isValidInput) {
            //Get user input
            System.out.print("Enter the row and column you want to place your symbol in, separated by a comma: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            inputString = scanner.next();

            //Check input is valid
            try {
                if (!((Character.isDigit(inputString.charAt(0))) && (Character.isDigit(inputString.charAt(2))))) {
                    System.out.print("Invalid input! Try again. Error 1: One of your inputs are not a digit.\n");
                    isValidInput = false;
                    //Use regex to check numbers are between 1 and 3
                } else if (!(inputString.matches("^[1-3](.*[1-3])?$"))) {
                    System.out.print("Invalid input! Try again. Error 2: One of your inputs are not between 1 and 3.\n");
                    isValidInput = false;
                } else {
                    isValidInput = true;
                }
            }
            //Catch exception if user makes input string unexpected size
            catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.print("Invalid input! Try again. Error 3: Bad separator character raising StringIndexOutOfBoundsException\n");
                isValidInput = false;
            }
        }

        //Generate input array to return
        int[] input = new int[2];
        input[0] = Character.getNumericValue(inputString.charAt(0));
        input[0]--;
        input[1] = Character.getNumericValue(inputString.charAt(2));
        input[1]--;

        return input;
    }


    private void addSymbolToBoard(int row, int column, char symbol) {
        this.gameBoard[row][column] = symbol;
    }

    private boolean checkSquareContainsSymbol(int row, int column) {
        if ((this.gameBoard[row][column] == 'o') || (this.gameBoard[row][column] == 'x')) {
            return true;
        }
        else {
            return false;
        }
    }

    private void changeCurrentPlayer() {
        if (this.currentPlayerSymbol == 'o') {
            this.currentPlayerSymbol = 'x';
        }
        else {
            this.currentPlayerSymbol = 'o';
        }
    }

    private void printGameBoard() {
        //Print numbers identifying board columns
        System.out.print("  1  2  3\n");
        int rowNumber = 1;
        //Traverse board
        for (int i=0;i<BOARD_DIMENSION;i++) {
            //Print and increment row number
            System.out.print(rowNumber);
            rowNumber++;
            for (int e=0;e<BOARD_DIMENSION;e++) {
                //If board square is empty, print empty character
                //If not, print symbol
                if (this.gameBoard[i][e] == ' ') {
                    System.out.print("[ ]");
                }
                else {
                    System.out.print("[" + this.gameBoard[i][e] + "]");
                }
            }
            //New line after row is printed
            System.out.print("\n");
        }
    }

    private void computerMove() {
        boolean moveMade = false;
        java.util.Random rand = new java.util.Random();
        while (!moveMade) {
            int row = (rand.nextInt(3));
            int column = (rand.nextInt(3));
            if (!checkSquareContainsSymbol(row, column)) {
                addSymbolToBoard(row, column, this.currentPlayerSymbol);
                moveMade = true;
            }
        }
    }

    private boolean checkColumns() {
        //Check columns of board for winner
        for (int i=0;i<BOARD_DIMENSION;i++) {
            if (((this.gameBoard[0][i] == 'o') && (this.gameBoard[1][i] == 'o') && (this.gameBoard[2][i] == 'o')) ||
                    ((this.gameBoard[0][i] == 'x') && (this.gameBoard[1][i] == 'x') && (this.gameBoard[2][i] == 'x'))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRows() {
        //Check rows of the board for winner
        for (int i=0;i<BOARD_DIMENSION;i++) {
            if (((this.gameBoard[i][0] == 'o') && (this.gameBoard[i][1] == 'o') && (this.gameBoard[i][2] == 'o')) ||
                    ((this.gameBoard[i][0] == 'x') && (this.gameBoard[i][1] == 'x') && (this.gameBoard[i][2] == 'x'))) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiags() {
        //Check diagonals of board for winner
        if (((this.gameBoard[0][0] == 'o') && (this.gameBoard[1][1] == 'o') && (this.gameBoard[2][2] == 'o')) ||
                ((this.gameBoard[0][2] == 'o') && (this.gameBoard[1][1] == 'o') && (this.gameBoard[2][0] == 'o'))) {
            return true;
        }
        else return ((this.gameBoard[0][0] == 'x') && (this.gameBoard[1][1] == 'x') && (this.gameBoard[2][2] == 'x')) ||
                ((this.gameBoard[0][2] == 'x') && (this.gameBoard[1][1] == 'x') && (this.gameBoard[2][0] == 'x'));
    }

    private boolean checkWinner() {
        return (this.checkRows() || this.checkColumns() || this.checkDiags());
    }


    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }
}
