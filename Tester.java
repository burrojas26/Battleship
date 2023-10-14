public class Tester {
    public static void main(String[] args) {
        //initiates intro and finds game mode
        Intro welcome = new Intro();
        String mode = welcome.mode();
        Play gamePlay = new Play();

        String playerGuess = "";
        String compGuess = "";
        boolean guessWorks = false;
        String [] pPrevGuess = {};
        String [] cPrevGuess = {};
        boolean gameOver = false;
        boolean playerWin = false;
        boolean compWin = false;
        boolean playerCheck;
        boolean compCheck;

        if (mode.equals("fast")) {
            //Creates boards and sets them up
            Board playerBoard = new Board(8);
            Board compBoard = new Board(8);
            compBoard.compSetup();
            playerBoard.compSetup();
            
            //gets guesses
            while (gameOver == false) {
                System.out.println("This is your board: ");
                playerBoard.printBoard();
                System.out.println("");

                playerGuess = gamePlay.getGuess("user", 8);
                while (guessWorks == false) {
                    
                    compGuess = gamePlay.getGuess("ai", 8);

                    System.out.println("Computer guess: " + compGuess);
                    System.out.println("Player guess: " + playerGuess);
                    System.out.println("");

                    //checks if the guesses are valid
                    playerCheck = gamePlay.checkGuess(playerGuess, pPrevGuess);
                    compCheck = gamePlay.checkGuess(compGuess, cPrevGuess);
                    if (playerCheck && compCheck) {
                        guessWorks = true;
                    }
                }

                //Marks the shots if applicable & checks for end of game
                System.out.print("Player: ");
                compBoard = gamePlay.markShip(compBoard, playerGuess, 8);
                System.out.print("Computer: ");
                playerBoard = gamePlay.markShip(playerBoard, compGuess, 8);

                //Checks if game is over
                gameOver = true;
                compWin = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (playerBoard.checkCoord(i, j) != 0) {
                            gameOver = false;
                            compWin = false;
                        }
                    }
                }
                if (gameOver) {
                    continue;
                }
                gameOver = true;
                playerWin = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (compBoard.checkCoord(i, j) != 0) {
                            gameOver = false;
                            playerWin = false;
                        }
                    }
                }
            } //Closes while
            if (playerWin) {
                System.out.println("YOU WIN!");
            }
            else if (compWin) {
                System.out.println("COMPUTER WINS!");
            }
        } //Closes if
        else if (mode.equals("norm")) {
            //Creates board and sets it up
            Board playerBoard = new Board(10);
            playerBoard.setup();
            System.out.println("This is your board: ");
            playerBoard.printBoard();

            //gets guesses
            gameOver = false;
            while (gameOver == false) {
                guessWorks = false;
                while (guessWorks == false) {
                    playerGuess = gamePlay.getGuess("user", 10);

                    //checks if the guesses are valid
                    if (gamePlay.checkGuess(playerGuess, pPrevGuess) == true) {
                        guessWorks = true;
                    }
                }

                //Marks the shots if applicable & checks for end of game
                playerBoard = gamePlay.markShip(playerBoard, playerGuess, 10);

                //Checks if game is over
                gameOver = true;
                //System.out.println("Hi");
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (playerBoard.checkCoord(i, j) != 0 && playerBoard.checkCoord(i, j) != 7) {
                            gameOver = false;
                        }
                    }
                }
            } //Closes while
            System.out.println("YOU WIN!");
        }
    }
}



