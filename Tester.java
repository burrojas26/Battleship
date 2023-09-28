public class Tester {
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.printBoard();
        b1.game[4][4] = 1;
        b1.game[4][5] = 1;
        System.out.println("");
        b1.printBoard();
    }
}
