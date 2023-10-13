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
                System.out.println("This is the computer's board: ");
                compBoard.printBoard();

                playerGuess = gamePlay.getGuess("user", 8);
                while (guessWorks == false) {
                    
                    compGuess = gamePlay.getGuess("ai", 8);

                    System.out.println("Comp: " + compGuess);
                    System.out.println("Pl: " + playerGuess);

                    //checks if the guesses are valid
                    playerCheck = gamePlay.checkGuess(playerGuess, pPrevGuess);
                    compCheck = gamePlay.checkGuess(compGuess, cPrevGuess);
                    if (playerCheck && compCheck) {
                        guessWorks = true;
                    }
                }

                //Marks the shots if applicable & checks for end of game
                System.out.println("Player: ");
                compBoard = gamePlay.markShip(compBoard, playerGuess, 8);
                System.out.println("Computer: ");
                playerBoard = gamePlay.markShip(playerBoard, compGuess, 8);

                //Checks if game is over
                gameOver = true;
                compWin = true;
                playerWin = true;
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (playerBoard.checkCoord(i, j) != 0) {
                            gameOver = false;
                            playerWin = false;
                        }
                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (compBoard.checkCoord(i, j) != 0) {
                            if (gameOver) {
                                gameOver = false;
                            }
                            compWin = false;
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
            while (gameOver = false) {
                while (guessWorks == false) {
                    playerGuess = gamePlay.getGuess("user", 8);

                    //checks if the guesses are valid
                    if (gamePlay.checkGuess(playerGuess, pPrevGuess) == true) {
                        guessWorks = true;
                    }
                }

                //Marks the shots if applicable & checks for end of game
                playerBoard = gamePlay.markShip(playerBoard, playerGuess, 8);

                //Checks if game is over
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (playerBoard.checkCoord(i, j) != 0 && playerBoard.checkCoord(i, j) != 7) {
                            System.out.println("You Win!");
                            gameOver = true;
                        }
                    }
                }
            } //Closes while
        }
    }
}



