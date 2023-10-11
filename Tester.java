public class Tester {
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.setup();
        b1.compSetup();
        System.out.println("Player setup: ");
        b1.printBoard();
        System.out.println("");
        System.out.println("Computer setup: ");
        b1.printCompBoard();

    }
}



