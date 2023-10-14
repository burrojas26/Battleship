import java.util.Scanner;

public class Play {
    
    //Declaring variables
    boolean compatible = false;
    String input;
    int y;
    int x;
    boolean allDead = false;
    /* 
    Gets a guess from either the computer or the player
    Format to a string and check the input format
    Return the string
    */
    public String getGuess(String inputType, int boardLen) {
        Scanner scan = new Scanner(System.in);
        compatible = false;
        if (inputType.equals("user")) {
            while (compatible == false) {
                System.out.print("Enter your guess. (Letter, Number): ");
                input = scan.nextLine().toUpperCase();
                System.out.println("");
                if (input.length() < 4 || input.length() > 5) {
                    System.out.println("Incompatible coordinates. Please try again.");
                    continue;
                }
                else {
                    compatible = true;
                }
            }
        }
        else if (inputType.equals("ai")) {
            //creates a random starting coordinate that will not exceed the board
            y = (int) (Math.random()*boardLen) + 'A';
            y = (char)y;
            x = (int) (Math.random()*boardLen) + 1;
            input = (char)y + ", " + x;

        }
        return input;
    }


    //Error checking the coordinate 
    //Returns a boolean wether the coord is compatible
    public boolean checkGuess(String guess, String[] prevGuess, int boardLen) {
        //Checking to see if the guess has already been guessed
        for (int i = 0; i < prevGuess.length; i++) {
            if (prevGuess[i] == guess) {
                return false;
            }
        }
        y = (int) (guess.charAt(0));
        //A = 65
        //J = 74
        //Checks to make sure the coordinate is in the range
        if (y >= 65 && y <= 65 + (boardLen-1)) {
            y -= 'A';
        }
        else {
            return false;
        }
        //Gets first int in guess
        int midpt = guess.indexOf(",");
        x = Integer.parseInt(guess.substring(midpt+2)) - 1;
        if (x < 0 || x > boardLen) {
            return false;
        }

        //returns true if the coord passes all of the above
        return true;
    }

    //Marks the hit on the board if a ship is hit and documents the shot
    //returns a boolean whether the ship is hit or not
    public Board markShip(Board board, String guess, int boardLen) {

        //Translating guess to integers
        y = (int) (guess.charAt(0)) - 'A';
        int midpt = guess.indexOf(",");
        x = Integer.parseInt(guess.substring(midpt+2)) - 1;

        //Checks if there is a ship and marks if so
        if (board.checkCoord(y, x) != 0 && board.checkCoord(y, x) != 7 && board.checkCoord(y, x) != 6) {
            System.out.println("Ship Hit");
            board.changeCoord(y, x, 7);
        }
        else if (board.checkCoord(y, x) == 0) {
            System.out.println("Miss");
            board.changeCoord(y, x, 6);
        }
        //Checks if all ships are dead
        allDead = true;
        for (int i = 0; i < boardLen; i++) {
            for (int j = 0; j < boardLen; j++) {
                if (board.checkCoord(i, j) != 0 && board.checkCoord(i, j) != 7) {
                    allDead = false;
                }
            }
        }
        if (allDead == true) {
            Board end = new Board(boardLen);
            return end;
        }
        return board;
    }

}
