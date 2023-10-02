public class Tester {
    public static void main(String[] args) {
        Board b1 = new Board();
        b1.compSetup();
        b1.printCompBoard();

    }
}







for (int ship = 0; ship < ships.length; ship++) {
            overLap = true;
            System.out.println("What is the first coordinate where you want to place your " + ships[ship] + " peg ship (_, _): ");
            coord1 = scan.nextLine();
            y1 = (int) (coord1.charAt(0)) - '1';
            x1 = (int) (coord1.charAt(3)) - '1';
            game[y1][x1] = 1;

            //Checks if the input has valid coordinates for the size of the ships
            while (overLap == true) {
                System.out.println("What is the last coordinate where you want to place your " + ships[ship] + " peg ship (_, _): ");
                coord2 = scan.nextLine();
                y2 = (int) (coord2.charAt(0)) - '1';
                x2 = (int) (coord2.charAt(3)) - '1';
                game[y2][x2] = 1;

                //Determines the direction of the ships 
                if (y1 == y2) {
                    if (x2-x1 == (int)(ships[ship]) - 1) {
                        overLap = false;
                        for (int i = 0; i < x2 - x1; i++) {
                            //Check to make sure ships do not overlap
                            if (game[y1][i] == 0) {
                                game[y1][i] = 1;
                            }
                            else {
                               System.out.println("Incompatible coordinate, please try again"); 
                               overLap = true;
                            }
                        }
                    }
                    else {
                        System.out.println("Incompatible coordinate, enter the last coordinate again");
                    }
                    
                }
                else if (x1 == x2) {
                    if (y2-y1 == (int)(ships[ship]) - 1) {
                        overLap = false;
                        for (int i = 0; i < y2 - y1; i++) {
                            //Check to make sure ships do not overlap
                            if (game[i][x1] == 0) {
                                game[i][x1] = 1;
                            }
                            else {
                               System.out.println("Incompatible coordinate, please try again"); 
                               overLap = true;
                            }
                        }
                    }
                    else {
                        System.out.println("Incompatible coordinate, enter the last coordinate again");
                    }
                }
            }
        }