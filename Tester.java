import java.util.Scanner;


/**
 * Tester.java
 * @author Jasper Burroughs
 * @since 9/28/23
 * This class contains the main method to run the program
 * it loops through asking for a guess until you enter a valid guess and then it loops through asking for guesses until you hit of all the ships
 */

public class Tester {
    public static void main(String[] args) {
        //initiates intro and finds game mode
        Intro welcome = new Intro();
        String mode = welcome.mode();
        Play gamePlay = new Play();
        Scanner scan = new Scanner(System.in);

        String playerGuess = "";
        String compGuess = "";
        boolean guessWorks = false;
        String [] pPrevGuess = {};
        String [] cPrevGuess = {};
        boolean gameOver = false;
        boolean playerWin = false;
        boolean compWin = false;
        boolean playerCheck = false;;
        boolean compCheck = false;

        if (mode.equals("fast")) {
            //Creates boards and sets them up
            Board playerBoard = new Board(8);
            Board compBoard = new Board(8);
            compBoard.compSetup();
            playerBoard.compSetup();
            
            //gets guesses
            while (gameOver == false) {
                System.out.println("Press enter to contiue. ");
                scan.nextLine();
                System.out.println("\033[H\033[2J"); //Clears console
                if (guessWorks) {
                    guessWorks = false;
                    System.out.println("");
                }
                System.out.println("This is your board: ");
                playerBoard.printBoard();
                System.out.println("");
                System.out.println("This is the computer's board: ");
                compBoard.printHidden();
                //compBoard.printRawBoard(); - used when testing
                System.out.println("");

                playerCheck = false;
                compCheck = false;
                while (guessWorks == false) {
                    
                    if (playerCheck == false) {
                        playerGuess = gamePlay.getGuess("user", 8);
                    }
                    if (compCheck == false) {
                        compGuess = gamePlay.getGuess("ai", 8);
                    }

                    System.out.println("Computer guess: " + compGuess);
                    System.out.println("Player guess: " + playerGuess);
                    System.out.println("");

                    //checks if the guesses are valid
                    playerCheck = gamePlay.checkGuess(playerGuess, pPrevGuess, 8);
                    compCheck = gamePlay.checkGuess(compGuess, cPrevGuess, 8);
                    if (playerCheck && compCheck) {
                        guessWorks = true;
                    }
                    else {
                        System.out.println("Incompatible coordinate, please try again");
                    }
                }
                
                //Marks the shots if applicable & checks for end of game
                System.out.print("Player: ");
                compBoard = gamePlay.markShip(compBoard, playerGuess, 8);
                System.out.print("Computer: ");
                playerBoard = gamePlay.markShip(playerBoard, compGuess, 8);
                System.out.println("");

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
            System.out.println("Board complete, now let the other player guess");
            System.out.println("Press enter to continue.");
            scan.nextLine();
            System.out.println("\033[H\033[2J"); //Clears console

            //gets guesses
            gameOver = false;
            while (gameOver == false) {
                guessWorks = false;
                System.out.println("This is the other player's board: ");
                playerBoard.printHidden();
                System.out.println("");
                while (guessWorks == false) {
                    playerGuess = gamePlay.getGuess("user", 10);

                    //checks if the guesses are valid
                    if (gamePlay.checkGuess(playerGuess, pPrevGuess, 10) == true) {
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



