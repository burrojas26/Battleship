public class Board {
    int numRows = 10;
    int numCols = 10;
    int[] ships = {2, 3, 3, 4, 5};

    public void printBoard() {
        int[][] game = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println("");
        }
    
    }
}