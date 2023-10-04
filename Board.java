import java.util.Scanner;

public class Board {
    Scanner scan = new Scanner(System.in);
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5};
    int[][] game = new int[numRows][numCols];
    int[][] compGame = new int[numRows][numCols];

    // Set up vars
    String coord1;
    int x1;
    int y1;
    String coord2;
    int x2;
    int y2;
    String direction;
    int compDirection;
    boolean overLap = true;
    boolean compatible = false;

    //Prints the board
    public void printBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //prints the cmputer's board
    public void printCompBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(compGame[i][j] + " ");
            }
            System.out.println("");
        }
    }

    // Sets up the player's ships based on their input
    public void setup() {
        //Iterates through all the ships for the player to place them
        for (int ship = 0; ship < ships.length; ship++) {
            overLap = true;
            compatible = false;
            //Checks if the input has valid coordinates for the size of the ships
            while (overLap == true) {
                System.out.println("What is the first coordinate where you want to place your " + ships[ship] + " peg ship (letter, number): ");
                coord1 = scan.nextLine().toUpperCase();
                y1 = (int) (coord1.charAt(0)) - 'A';
                x1 = (int) (coord1.charAt(3)) - '1';
                //game[y1][x1] = 1;

                System.out.println("What is the last coordinate where you want to place your " + ships[ship] + " peg ship (letter, number): ");
                coord2 = scan.nextLine().toUpperCase();
                y2 = (int) (coord2.charAt(0)) - 'A';
                x2 = (int) (coord2.charAt(3)) - '1';
                //game[y2][x2] = 1;

                //Determines the direction of the ships 
                if (y1 == y2) {
                    if (x2-x1 == (int)(ships[ship]) - 1) {
                        overLap = false;
                        for (int i = 0; i <= x2 - x1; i++) {
                            //Check to make sure ships do not overlap
                            if (game[y1][i+x1] == 0) {
                                compatible = true;
                            }
                            else {
                               System.out.println("Incompatible coordinate, please try again"); 
                               overLap = true;
                            }
                        }
                        if (compatible) {
                            for (int i = 0; i <= x2 - x1; i++) {
                                //Places the whole ship
                                game[y1][i+x1] = 1;
                            }
                        }
                    }
                    else {
                        System.out.println("Incompatible coordinate, enter the coordinates again");
                    }
                    
                }
                else if (x1 == x2) {
                    System.out.println("If statement: " + (y2-y1 == (int)(ships[ship]) - 1));
                    if (y2-y1 == (int)(ships[ship]) - 1) {
                        overLap = false;
                        for (int i = 0; i <= y2 - y1; i++) {
                            //Check to make sure ships do not overlap
                            if (game[i+y1][x1] == 0) {
                                compatible = true;
                            }
                            else {
                               System.out.println("Incompatible coordinate, please try again"); 
                               overLap = true;
                            }
                        }
                        if (compatible) {
                            for (int i = 0; i <= y2 - y1; i++) {
                                //Places the whole ship
                                game[i+y1][x1] = 1;
                            }
                        }
                    }
                    else {
                        System.out.println("Incompatible coordinate, enter the last coordinate again");
                    }
                }
                else {
                   System.out.println("Incompatible coordinate, please try again"); 
                }
            }
        }
    }
        
    public void compSetup() {
        for (int ship = 0; ship < ships.length; ship++) {
            overLap = true;
            while (overLap == true) {
                y1 = (int) (Math.random()*(10-ships[ship]));
                x1 = (int) (Math.random()*(10-ships[ship]));
                compGame[y1][x1] = 1;

                compDirection = (int) (Math.random()*2);
                if (compDirection == 1) {
                    y2 = y1;
                    x2 = x1+(int)(ships[ship]);
                    compGame[y2][x2] = 1;
                    System.out.println("(" + x1 + ", " + y1 + ")");
                    System.out.println("(" + x2 + ", " + y2 + ")");
                    for (int i = 0; i < x2 - x1; i++) {
                        //Check to make sure ships do not overlap
                        if (game[y1][i+x1] == 0) {
                            game[y1][i+x1] = 1;
                            overLap = false;
                        }
                        else {
                        overLap = true;
                        }
                    }
                }
                else if (compDirection == 0) {
                    x2 = x1;
                    y2 = y1+(int)(ships[ship]);
                    compGame[y2][x2] = 1;
                    System.out.println("(" + x1 + ", " + y1 + ")");
                    System.out.println("(" + x2 + ", " + y2 + ")");
                    for (int i = 0; i < y2 - y1; i++) {
                        //Check to make sure ships do not overlap
                        if (game[i+y1][x1] == 0) {
                            game[i+y1][x1] = 1;
                            overLap = false;
                        }
                        else {
                        overLap = true;
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void play() {

    }
}






