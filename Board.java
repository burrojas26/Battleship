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

    public void printBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println("");
        }
    
    }

    public void setup() {
        for (int ship = 0; ship < ships.length; ship++) {
            System.out.println("What is the first coordinate where you want to place your " + ships[ship] + " peg ship ([_], [_]): ");
            coord1 = scan.nextLine();
            x1 = (int) (coord1.charAt(1)) - '1';
            y1 = (int) (coord1.charAt(6)) - '1';
            game[x1][y1] = ship;
            System.out.println("What is the last coordinate where you want to place your " + ships[ship] + " peg ship ([_], [_]): ");
            coord2 = scan.nextLine();
            x2 = (int) (coord1.charAt(1)) - '1';
            y2 = (int) (coord1.charAt(6)) - '1';
            game[x2][y2] = ship;
    }
        }
        

    public void play() {

    }
}