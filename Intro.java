import java.util.Scanner;

/**
 * Intro.java
 * @author Jasper Burroughs
 * @since 10/11/23
 * This class contains 1 method that asks the user to decide between fast or normal mode
 * It then displays the corresponding directions for the game and returns either "fast" or "norm"
 */

public class Intro {
    Scanner scan = new Scanner(System.in);
    String optionRaw;
    char option;
    boolean compatible = false;
    
    //Asks the user which mode they want to play, then returns the mode and prints instructions
    public String mode() {
        while (!compatible) {
            System.out.println("Enter F for fast mode or N for normal mode: ");
            optionRaw = scan.nextLine();
            if (optionRaw != "") {
                option = optionRaw.toUpperCase().charAt(0);
            }
            if (option == 'F' || option == 'N') {
                compatible = true;
            }
        }
        if (option == 'F') {
            System.out.println("Welcome to battleship, fast game.");
            System.out.println("In this version the computer places your ships on an 8X8 grid for you. \nThe computer also places ships on it's own board. \nYour goal is to guess where all of the computer's ships are before they guess where all of your ships are.");
            System.out.println("In your board a 0 represents empty water, while a number from 2 to 5 represents a ship of 2 size, a ship of 3 size, etc. \nIf an X appears on your board that represents a part of a ship that has been hit. \nA # means that is a place in which the attacker has missed.");
            System.out.println("");
            return "fast";
        }
        else {
            System.out.println("Welcome to battleship, normal game.");
            System.out.println("In this version you place your ships on an 10X10 grid. \nThe computer also places ships on it's board. \nYour goal is to guess where all of the computer's ships are before they guess where all of your ships are.");
            System.out.println("In your board a 0 represents empty water, while a number from 2 to 5 represents a ship of 2 size, a ship of 3 size, etc. \nIf an X appears on your board that represents a part of a ship that has been hit. \nA # means that is a place in which the attacker has missed.");
            System.out.println("");
            return "norm";
        }
    }
}
