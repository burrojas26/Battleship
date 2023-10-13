import java.util.Scanner;

public class Intro {
    Scanner scan = new Scanner(System.in);
    char option;
    boolean compatible = false;
    
    //Asks the user which mode they want to play, then returns the mode and prints instructions
    public String mode() {
        while (!compatible) {
            System.out.println("Enter F for fast mode or N for normal mode: ");
            option = (scan.nextLine().toUpperCase()).charAt(0);
            if (option == 'F' || option == 'N') {
                compatible = true;
            }
        }
        if (option == 'F') {
            System.out.println("Welcome to battleship, fast game.");
            System.out.println("In this version the computer places your ships on an 8X8 grid for you. The computer also places ships on it's board. Your goal is to guess where all of the computer's ships are before they guess where all of your ships are");
            System.out.println("In your board a 0 represents empty water, while a number from 2 to 5 represents a ship of 2 size, a ship of 3 size, etc. If a 7 appears on your board that represents a part of a ship that has been hit");
            return "fast";
        }
        else {
            System.out.println("Welcome to battleship, normal game.");
            System.out.println("In this version you place your ships on an 10X10 grid. The computer also places ships on it's board. Your goal is to guess where all of the computer's ships are before they guess where all of your ships are");
            System.out.println("In your board a 0 represents empty water, while a number from 2 to 5 represents a ship of 2 size, a ship of 3 size, etc. If a 7 appears on your board that represents a part of a ship that has been hit");
            return "norm";
        }
    }
}
