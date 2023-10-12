public class Tester {
    public static void main(String[] args) {
        Intro welcome = new Intro();
        String mode = welcome.mode();
        if (mode.equals("fast")) {
            Board playerBoard = new Board(8);
            Board compBoard = new Board(8);
            playerBoard.printBoard();
        }
        else if (mode.equals("norm")) {
            Board playerBoard = new Board(10);
            Board compBoard = new Board(10);

            compBoard.compSetup();
            playerBoard.compSetup();
            playerBoard.printBoard();
            System.out.println("");
            compBoard.printBoard();
        }
    }
}



