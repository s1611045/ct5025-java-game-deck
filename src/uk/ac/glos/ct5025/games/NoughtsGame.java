package uk.ac.glos.ct5025.games;

public class NoughtsGame {
    private final int BOARD_DIMENSION = 2;
    private char[][] gameBoard = new char[BOARD_DIMENSION][BOARD_DIMENSION];
    private String winner;
    private Object player1;
    private Object player2;
    private char player1Symbol = 'o';
    private char player2Symbol = 'x';

    private void addSymbolToBoard(int row, int column, char symbol) {
        this.gameBoard[row][column] = symbol;
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
        return this.checkRows() || this.checkColumns() || this.checkDiags();
    }


    public void setWinner(String winner) {
        this.winner = winner;
    }
}
