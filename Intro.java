import java.util.Scanner;

public class Intro {
    Scanner scan = new Scanner(System.in);
    char option;
    
    public String mode() {
        while (true) {
            System.out.println("Enter F for fast mode or N for normal mode: ");
            option = (scan.nextLine().toUpperCase()).charAt(0);
            if (option == 'F' && option == 'N') {
                break;
            }
        }
        if (option == 'F') {
            return "fast";
            System.out.println("Welcome to battleship, fast game. "); 
            System.out.println("In this version the computer places your ships on an 8X8 grid for you. The computer also places ships on it's board. Your goal is to guess where all of the computer's ships are before they guess where all of your ships are");
        }
        else {
            return "norm";
        }
    }
    
    public void fastDirects() {
        System.out.println
    }

}