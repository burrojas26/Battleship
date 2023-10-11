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
    int midpt;

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
                //Gets the index of the comma so it can split the number off from the str
                midpt = coord1.indexOf(",");
                if (coord1.length() < 4) {
                    System.out.println("Incompatible coordinates. Please try again.");
                    continue;
                }
                y1 = (int) (coord1.charAt(0));
                //Checking to see if the input was a number and then converting it back to a number
                //A = 65
                //J = 74
                //Checks to make sure the coordinate is in the range
                if (y1 >= 65 && y1 <= 74) {
                    y1 -= 'A';
                }
                else {
                    System.out.println("Incompatible coordinates. Please try again.");
                    continue;
                }
                
                //Uses substring method because I could nt get the parseInt method to work with other chars in the string
                x1 = Integer.parseInt(coord1.substring(midpt+2)) - 1;

                System.out.println("What is the last coordinate where you want to place your " + ships[ship] + " peg ship (letter, number): ");
                coord2 = scan.nextLine().toUpperCase();
                //Gets the index of the comma so it can split the number off from the str
                midpt = coord2.indexOf(",");
                if (coord2.equals("")) {
                    System.out.println("Incompatible coordinates. Please try again.");
                    continue;
                }
                y2 = (int) (coord2.charAt(0));
                //Checks to make sure the coordinate is in the range
                if (y2 >= 65 && y2 <= 74) {
                    y2 -= 'A';
                }
                else if (y2 < 31 || (y2 > 39 && y2 < 41)) {
                    continue;
                }
                //Uses substring method because I could nt get the parseInt method to work with other chars in the string
                x2 = Integer.parseInt(coord2.substring(midpt+2)) - 1;

                //Determines the direction of the ships and fills in all pegs occupied by the ship
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
                                //Places the whole ship as the number of pegs it takes up
                                game[y1][i+x1] = ships[ship];
                            }
                        }
                    }
                    else {
                        System.out.println("Incompatible coordinate, enter the coordinates again");
                    }
                    
                }
                else if (x1 == x2) {
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
                                //Places the whole ship as number of pegs it takes up
                                game[i+y1][x1] = ships[ship];
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
        
    //Sets up the ai's ships on its grid
    public void compSetup() {
        for (int ship = 0; ship < ships.length; ship++) {
            overLap = true;
            while (overLap) {
                compatible = true;
                //creates a random starting coordinate that will not exceed the board
                y1 = (int) (Math.random()*(10-ships[ship]));
                x1 = (int) (Math.random()*(10-ships[ship]));

                compDirection = (int) (Math.random()*2);
                //After creating random direction, checks which direction and then fills in the correct amount of pegs
                //Fills in pegs if the ship is horizontal
                if (compDirection == 1) {
                    y2 = y1;
                    x2 = x1+((int)(ships[ship]));
                    for (int i = 0; i < x2 - x1; i++) {
                        //Check to make sure ships do not overlap
                        if (compGame[y1][i+x1] != 0) {
                            compatible = false;
                        }
                    }
                    if (compatible) {
                        overLap = false;
                        for (int i = 0; i < x2 - x1; i++) {
                            //Places the whole ship
                            compGame[y1][i+x1] = ships[ship];
                        }
                    }
                }
                //Fills in the pegs if the ship is vertical
                else if (compDirection == 0) {
                    x2 = x1;
                    y2 = y1+((int)(ships[ship]));
                    for (int i = 0; i < y2 - y1; i++) {
                        //Check to make sure ships do not overlap
                        if (compGame[i+y1][x1] != 0) {
                            overLap = true;
                            compatible = false;
                        }
                        else {
                            overLap = false;
                        }//closes else loop
                    } //closes for loop
                    if (compatible) {
                        for (int i = 0; i < y2 - y1; i++) {
                            //Places the whole ship
                            compGame[i+y1][x1] = ships[ship];
                        } // closes for loop
                    } //closes compatible if statement
                } //closes else if
            } //Closes while loop
        } //Closes for loop
    } //Closes the computer setup method
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void play() {

    }
}






