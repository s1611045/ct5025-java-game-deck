package uk.ac.glos.ct5025.games;
import uk.ac.glos.ct5025.players.*;

public class NoughtsGame {
    private final int BOARD_DIMENSION = 3;
    private char[][] gameBoard = new char[BOARD_DIMENSION][BOARD_DIMENSION];
    private String winner = "";
    private Object player1;
    private Object player2;
    private char player1Symbol = 'o';
    private char player2Symbol = 'x';
    private char currentPlayerSymbol = 'o';
    private int gameCounter = 1;
    private long startTime = System.currentTimeMillis();
    private long timeTaken;


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
        while(this.getWinner() == "") {
            //Print board
            System.out.print("\nIt is currently " + this.currentPlayerSymbol + "'s turn.\n");
            this.printGameBoard();

            //Get current player type and ask them for move
            if(currentPlayerSymbol == 'o') {
                //'If player1 is human, ask them for move'
                if(player1 instanceof Human) {
                    this.humanMove();
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
                else {
                    this.computerMove();
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
            }
            else {
                if (player2 instanceof Human) {
                    this.humanMove();
                    if(this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
                else {
                    this.computerMove();
                    if (this.checkWinner()) {
                        this.setWinner(String.valueOf(this.currentPlayerSymbol));
                    }
                    else {
                        this.changeCurrentPlayer();
                    }
                }
            }
        }

        //Record time taken in game
        this.timeTaken = ((System.currentTimeMillis() - this.startTime)/1000);

        this.printGameBoard();
        System.out.print(this.currentPlayerSymbol + " wins!");
        System.out.print("\nThis game took " + this.timeTaken + " seconds.");
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

    private int[] getCoordinates() {
        boolean isValidInput = false;
        int row = 0;
        String inputString = "";

        while (!isValidInput) {
            //Get user input
            System.out.print("Enter the row and column you want to place your symbol in, separated by a comma or space: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            inputString = scanner.next();

            //Check input is valid
            if (!((Character.isDigit(inputString.charAt(0))) && (Character.isDigit(inputString.charAt(2))))) {
                System.out.print("Invalid input! Try again. Error 1\n");
                isValidInput = false;
                //Use regex to check numbers are between 1 and 3
            } else if (!(inputString.matches("^[1-3](.*[1-3])?$"))) {
                System.out.print("Invalid input! Try again. Error 2\n");
                isValidInput = false;
            } else {
                isValidInput = true;
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
        this.gameCounter++;
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
