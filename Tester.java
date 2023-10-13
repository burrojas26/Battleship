public class Tester {
    public static void main(String[] args) {
        //initiates intro and finds game mode
        Intro welcome = new Intro();
        String mode = welcome.mode();
        Play gamePlay = new Play();

        String playerGuess;
        String compGuess;
        boolean guessWorks = false;
        String [] pPrevGuess;
        String [] cPrevGuess;
        boolean gameOver = false;

        if (mode.equals("fast")) {
            //Creates boards and sets them up
            Board playerBoard = new Board(8);
            Board compBoard = new Board(8);
            compBoard.compSetup();
            playerBoard.compSetup();
            
            //gets guesses
            while (gameOver = false) {
                System.out.println("This is your board: ");
                playerBoard.printBoard();

                while (guessWorks == false) {
                    playerGuess = gamePlay.getGuess("user", 8);
                    compGuess = gamePlay.getGuess("ai", 8);

                    //checks if the guesses are valid
                    if (gamePlay.checkGuess(playerGuess, pPrevGuess) == true && gamePlay.checkGuess(compGuess, cPrevGuess) == true) {
                        guessWorks = true;
                    }
                }

                //Marks the shots if applicable & checks for end of game
                playerBoard = gamePlay.markShip(playerBoard, playerGuess, 8);
                compBoard = gamePlay.markShip(compBoard, compGuess, 8);

                //Checks if game is over
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (playerBoard[i][j] != 0 && playerBoard[i][j] != 7) {
                            System.out.println("Computer Wins!");
                            gameOver = true;
                        }
                    }
                }
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        if (compBoard[i][j] != 0 && compBoard[i][j] != 7) {
                            System.out.println("You Win!");
                            gameOver = true;
                        }
                    }
                }
            } //Closes while
        } //Closes if
        else if (mode.equals("norm")) {
            //Creates boards and sets them up
            Board playerBoard = new Board(10);
            Board compBoard = new Board(10);
            compBoard.compSetup();
            playerBoard.setup();
            System.out.println("This is your board: ");
            playerBoard.printBoard();

            

        }
    }
}



