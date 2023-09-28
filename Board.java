import java.util.Scanner;

public class Board {
    Scanner scan = new Scanner(System.in);
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5};
    int[][] game = new int[numRows][numCols];

    // Set up vars
    String coord1;
    int x1;
    int y1;
    String coord2;
    int x2;
    int y2;
    String direction;

    public void printBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(game[i][j] + " ");
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
                for (int i = 0; i < x2 - x1; i++) {
                    game[y1][i] = 1;
                }
            }
            else if (x1 == x2) {
                direction = "col";
                for (int i = 0; i < y2 - y1; i++) {
                    game[i][x1] = 1;
                }
            }
    }
        }
        

    public void play() {

    }
}