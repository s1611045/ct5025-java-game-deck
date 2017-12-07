package main.java.com.ct5025.games;
import main.java.com.ct5025.players.Computer;
import main.java.com.ct5025.players.Human;
import main.java.com.ct5025.scorecards.SnakesGameScorecard;

public class SnakesGame extends Game {
    private int[][] gameBoard = new int[10][10];
    private char player1Symbol = 'o';
    private int player1Position = 1;
    private char player2Symbol = 'x';
    private int player2Position = 1;
    private String currentPlayerTurn = "";
    private String winner = "";
    private int laddersClimbed = 0;
    private int snakesFallen = 0;
    private int winningScore;

    //Instantiate player instances polymorphously based on user input
    public SnakesGame(String playerName) {
        System.out.print("Starting new game with human vs. computer\n");
        this.player1 = new Human(playerName);
        this.player2 = new Computer();
        this.playGame();
    }

    public SnakesGame(String player1Name, String player2Name) {
        System.out.print("Starting new game with human vs. human\n");
        this.player1 = new Human(player1Name);
        this.player2 = new Human(player2Name);
        this.playGame();
    }

    public SnakesGame() {
        System.out.print("Starting new game with computer vs. computer\n");
        this.player1 = new Computer();
        this.player2 = new Computer();
        this.playGame();
    }
    /////////////////////////////////////////////////////////////////

    public void playGame() {
        //Create game board
        this.gameBoard = this.initialiseGameBoard(this.gameBoard);

        //Allocate snakes and ladders
        //If there is overlap, snake is the priority during gameplay
        int[] snakes = this.allocateSnakes();
        int[] ladders = this.allocateLadders();

        //Initialise local game variables
        long startTime = System.currentTimeMillis();
        int turnCounter = 1;

        //Play game
        this.currentPlayerTurn = player1.name;
        System.out.print("\n" + player1.name + "'s symbol is: " + this.player1Symbol + "\n");
        System.out.print(player2.name + "'s symbol is: " + this.player2Symbol + "\n");
        while(this.getWinner().equals("")) {
            //Print board
            this.printGameBoard();
            System.out.print("\nIt is " + this.currentPlayerTurn + "'s turn. It is turn: " + turnCounter);

            //Player 1
            if ((currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Human)) {
                System.out.print("\nPress ENTER twice to make your move. The die will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                this.player1Position = this.makeMove(this.player1Position, snakes, ladders);
                System.out.print("\nYour new position is: "+ this.player1Position);
                if (this.checkWinner(this.player1Position)) {
                    this.winningScore = player1Position;
                    this.setWinner(this.currentPlayerTurn);
                }
                else {
                    this.changeCurrentPlayerTurn();
                }
            }
            else if ((currentPlayerTurn.equals(this.player1.name)) && (player1 instanceof Computer)) {
                System.out.print("\n" + player1.name + " rolls the die...\n");

                this.player1Position = this.makeMove(this.player1Position, snakes, ladders);
                System.out.print("\n" + this.player1.name + "'s new position is: " + this.player1Position + "\n");
                if (this.checkWinner(this.player1Position)) {
                    this.winningScore = player1Position;
                    this.setWinner(this.currentPlayerTurn);
                }
                else{
                    this.changeCurrentPlayerTurn();
                }
            }
            //Player 2
            else if ((currentPlayerTurn.equals(this.player2.name)) && (player2 instanceof Human)) {
                System.out.print("\nPress ENTER twice to make your move. The die will be rolled for you: \n");
                java.util.Scanner scanner = new java.util.Scanner(System.in);
                String blank = scanner.nextLine();

                this.player2Position = this.makeMove(this.player2Position, snakes, ladders);
                System.out.print("\nYour new position is: "+ this.player2Position + "\n");
                if (this.checkWinner(this.player2Position)) {
                    this.winningScore = this.player2Position;
                    this.setWinner(this.currentPlayerTurn);
                }
                else {
                    this.changeCurrentPlayerTurn();
                }
            }
            else {
                System.out.print("\n" + player2.name + " rolls the die...\n");

                this.player2Position = this.makeMove(this.player2Position, snakes, ladders);
                System.out.print("\n" + this.player2.name + "'s new position is: " + this.player2Position + "\n");
                if (this.checkWinner(this.player2Position)) {
                    this.winningScore = player2Position;
                    this.setWinner(this.currentPlayerTurn);
                }
                else{
                    this.changeCurrentPlayerTurn();
                }
            }
            turnCounter++;
        }
        //Stop timer upon finding winner
        long timeTaken = ((System.currentTimeMillis() - startTime)/1000);

        //Print winner & time
        System.out.print("\n" + this.currentPlayerTurn + " wins!\n");
        System.out.print("\nThis game took " + timeTaken + " seconds.");

        //Generate scorecard and save file
        SnakesGameScorecard scorecard = new SnakesGameScorecard(this.getWinner(), this.getWinnerType(), timeTaken,
                turnCounter, this.winningScore, this.laddersClimbed, this.snakesFallen);
        scorecard.saveScorecard();
        System.out.print("\nScores saved to file.");

        //Return to menu
        System.out.print("\nPress ENTER to return to menu: ");
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        String blank = scanner.nextLine();
    }

    public int[] allocateLadders() {
        //Generate local variables used
        int[] array = new int[5];
        java.util.Random rnd = new java.util.Random();
        int number = 0;

        //Generate number
        for(int i=0;i<array.length;i++) {
                number = rnd.nextInt(89);
                array[i] = number;
        }
        //Return array when filled
        return array;
    }

    public int[] allocateSnakes() {
        //Generate local variables used
        int[] array = new int[5];
        java.util.Random rnd = new java.util.Random();
        boolean isValidNumber = false;
        int number = 0;

        //Generate number and check it is in valid position
        for(int i=0;i<array.length;i++) {
            while(!isValidNumber) {
                number = rnd.nextInt(99);
                if (number < 10) {
                    isValidNumber = false;
                }
                else {
                    isValidNumber = true;
                }
            }
            array[i] = number;
        }
        //Return array when filled
        return array;
    }

    protected boolean checkWinner(int position) {
        if (position >= 100) {
            return true;
        }
        else {
            return false;
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

    public void changeCurrentPlayerTurn() {
        if (this.currentPlayerTurn.equals(player1.name)) {
            this.currentPlayerTurn = player2.name;
        }
        else {
            this.currentPlayerTurn = player1.name;
        }
    }

    public int makeMove(int position, int[] snakes, int[] ladders) {
        int roll = dieRoll();
        position = position + roll;
        System.out.print("\nYou rolled a " + roll);

        //Check for snake
        if (this.checkSnakeOrLadder(position, snakes)) {
            System.out.print("\nYou landed on a snake! Your position decreases by 10.");
            position = position - 10;
            this.snakesFallen++;
        }
        //Check for ladder
        else if (this.checkSnakeOrLadder(position, ladders)) {
            System.out.print("\nYou landed on a ladder! Your position increases by 10.");
            position = position + 10;
            this.laddersClimbed++;
        }
        return position;
    }

    public boolean checkSnakeOrLadder(int position, int[] array) {
        for(int i=0;i<array.length;i++) {
            if (position == array[i]) {
                return true;
            }
        }
        return false;
    }

    public void printGameBoard() {
        System.out.print("\n");
        for (int i=9;i>=0;i--) {
            for (int e=9;e>=0;e--) {
                //If board value matches both player positions, print player symbols
                if ((this.gameBoard[i][e] == this.player1Position) && (this.gameBoard[i][e] == this.player2Position)) {
                    System.out.print("[" + this.player1Symbol + this.player2Symbol + "]");
                }
                //If board value matches player 1 position, print symbol + whitespace
                else if (this.gameBoard[i][e] == this.player1Position) {
                    System.out.print("[" + this.player1Symbol + " ]");
                }
                //If board value matches player 2 position, print symbol + whitespace
                else if (this.gameBoard[i][e] == this.player2Position) {
                    System.out.print("[" + this.player2Symbol + " ]");
                }
                //If board value is 10, print '10' normally
                else if((i==0) && !(this.gameBoard[i][e] == 10)) {
                    System.out.print("[" + this.gameBoard[i][e] + " ]");
                }
                //If board value is less than 10, print integer followed by whitespace
                else if ((i==0) && (this.gameBoard[i][e] == 10)) {
                    System.out.print("[" + this.gameBoard[i][e] + "]");
                }
                //If board value is greater than 10, print integer normally
                else {
                    System.out.print("[" + this.gameBoard[i][e] + "]");
                }
            }
            System.out.print("\n");
        }
    }

    public int dieRoll() {
        //Generate random number
        java.util.Random rnd = new java.util.Random();
        return rnd.nextInt(6);
    }

    public int[][] initialiseGameBoard(int[][] board) {
        int ten = 0;
        int unit = 1;
        //Add appropriate values to board
        for (int i=0;i<=9;i++) {
            for (int e=0;e<=9;e++) {
                if (ten == 0) {
                    board[i][e] = unit;
                    unit++;
                }
                else {
                    board[i][e] = (ten*10 + unit);
                    unit++;
                }

                if (unit == 10) {
                    unit = 0;
                    ten++;
                }
            }
        }

        return board;
    }

    //Encapsulate fields
    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
