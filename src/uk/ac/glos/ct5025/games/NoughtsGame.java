package uk.ac.glos.ct5025.games;

public class NoughtsGame {
    private int NUMBER_OF_ROWS;
    private int NUMBER_OF_COLUMNS;
    private char[][] gameBoard = new char[this.NUMBER_OF_ROWS][this.NUMBER_OF_COLUMNS];
    private String winner;
    private Object player1;
    private Object player2;

    private void addSymbolToBoard(int row, int column, char symbol) {
        this.gameBoard[row][column] = symbol;
    }

    private void checkWinner() {
        for (int i=0;i<NUMBER_OF_ROWS;i++) {
            for (int e=0;e<NUMBER_OF_COLUMNS;e++) {
                if (gameBoard[i][e] == 'x') {
                    //
                }
            }
        }
    }
}
