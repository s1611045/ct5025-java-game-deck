package uk.ac.glos.ct5025.games;

public class NoughtsGame {
    private final int BOARD_DIMENSION = 2;
    private char[][] gameBoard = new char[BOARD_DIMENSION][BOARD_DIMENSION];
    private String winner = "";
    private Object player1;
    private Object player2;
    private char player1Symbol = 'o';
    private char player2Symbol = 'x';
    private char currentPlayerSymbol = 'o';
    private long startTime = System.currentTimeMillis();

    private void NoughtsGame(int players) {

    }

    private void playGame() {
        while(this.getWinner() == "") {
            this.instantiatePlayers();

        }
    }

    private int[] askHumanForMove() {
        getRow();
        //return statement
    }

    private int getRow() {
        boolean isValidInput = false;
        char input;
        int row = 0;

        while (!isValidInput) {
            System.out.print("Enter the row: ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String inputString = scanner.next();
            input = inputString.charAt(0);
            if (!Character.isDigit(input)) {
                System.out.print("Invalid input! Try again.\n");
                isValidInput = false;
            }
            else if (!(input == '1') || !(input == '2') || !(input == '3')) {
                System.out.print("Invalid input! Try again.\n");
                isValidInput = false;
            }
            else {
                row = Integer.parseInt(Character.toString(input));
                row--;
                isValidInput = true;
            }
        }
        return row;
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
        System.out.print("  1  2  3");
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

    private void computerMakeMove() {
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
