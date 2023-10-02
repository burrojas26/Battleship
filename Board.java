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

    public void printBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void printCompBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(compGame[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void setup() {
        for (int ship = 0; ship < ships.length; ship++) {
            System.out.println("What is the first coordinate where you want to place your " + ships[ship] + " peg ship (_, _): ");
            coord1 = scan.nextLine();
            y1 = (int) (coord1.charAt(0)) - '1';
            x1 = (int) (coord1.charAt(3)) - '1';
            game[y1][x1] = 1;

            System.out.println("What is the last coordinate where you want to place your " + ships[ship] + " peg ship (_, _): ");
            coord2 = scan.nextLine();
            y2 = (int) (coord2.charAt(0)) - '1';
            x2 = (int) (coord2.charAt(3)) - '1';
            game[y2][x2] = 1;

            if (y1 == y2) {
                if (x2-x1 != (int)(ships[ship])) {
                    for (int i = 0; i < x2 - x1; i++) {
                    game[y1][i] = 1;
                    }
                }
                
            }
            else if (x1 == x2) {
                if (x2-x1 != (int)(ships[ship])) {
                    for (int i = 0; i < y2 - y1; i++) {
                    game[i][x1] = 1;
                    }
                }
                
            }
        }

        /* 
        for (int ship = 0; ship < ships.length; ship++) {
            y1 = (int) (Math.random()*10);
            x1 = (int) (Math.random()*10);
            compGame[y1][x1] = 1;

            compDirection = (int) (Math.random());
            if (compDirection == 1) {
                y2 = y1;
                x2 = x1+(int)(ships[ship]);
                compGame[y2][x2] = 1;
                for (int i = 0; i < x2 - x1; i++) {
                    compGame[y1][i] = 1;
                }
            }
            else if (compDirection == 0) {
                x2 = x1;
                y2 = y1+(int)(ships[ship]);
                compGame[y2][x2] = 1;
                for (int i = 0; i < y2 - y1; i++) {
                    compGame[i][x1] = 1;
                }
            }
        }
        */
    }
        

    public void play() {

    }
}