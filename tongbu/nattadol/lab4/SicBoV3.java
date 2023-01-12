package tongbu.nattadol.lab4;

import java.util.Scanner;

/**
* <p>This SicBoV3 program is the continuation of the SicBoV2 program.  The program ask which game user want to play.</p>
* <p>How do they want to bet, then how much do they win.  When this process end, SicBoV2 will ask the user if they want to keep playing.</p>
* <p>If a user input "a" or "A" the game will start again.  If user input anything else, the game will stop.</p>
* <p>SicBoV3 add the conditions if user input anything else other than "1" and "2" when choosing game, "h", "H", "l", "L" in game 1</p>
* <p>and 1 - 6 in game 2.  The program will continue asking user to input until user input the correct input.</p>
*
* @author Nattadol Tongbu
* @version 1.0, 1/12/2023
* ID: 653040445-9
* Sec: 2
*
*/

public class SicBoV3 {
    static int choice; // Declare variable choice with static so its can be used across the program.
    static Scanner reader = new Scanner(System.in); // Create new Scanner with static so its can be use across the program.

    /**
     * <p>This is the main method.  It will run the getchoice() and playgame() methods first, then ask a user if they want to continue playing or not.</p>
     * <p>If a user input "a" or "A" the game will start again.  If user input anything else, the game will stop.</p> 
     * @param args is the program arguments.
     * @param answer is to accept user choice of continuing or quiting the game.
     */

    public static void main(String[] args) {
        String answer;

        // Use do_while to run all the methods and code first, at the end ask user to input.  If user input "a" or "A"
        // the game will start again.  If user input anything else, the game will stop.
        do {
        getChoice();
        playGame();
        System.out.println("Press A to play again.  Press the other keys to exit.");
        answer = reader.next();
        } while (answer.equalsIgnoreCase("A"));
        System.out.println("Good Bye!");
    }
    
    /**
     * <p>getChoice() method to ask the user for which game they want to play, read the input.  If the input is not correct, keep asking user to input again until user enter</p>
     * <p>a correct input (1 or 2), convert the gameChecker String variable to integer, and pass the value to the variable choice.</p>
     * @param gameChecker is to accept user choice of game in a string format. 
     * @param choice is an interger variable equal to gamechecker after formatting.
     */

    public static void getChoice() {
        String gameChecker;

        //do_while loop to continue asking user if they enter incorrect input.
        do {
            System.out.println("Welcome to  (653040445-9) Game:");
            System.out.println("Type 1 for choosing high or low numbers.");
            System.out.println("Type 2 for choosing number between 1-6.");
            System.out.print("Enter yourchoice: ");
            gameChecker = reader.next(); // Read the input to see which game user want to play.
    
                if (!(gameChecker.equals("1")) && !(gameChecker.equals("2"))) {
                System.out.println("Incorrect input. Enter 1 or 2 only."); 
                // Error message in case of if user input something other than "1" or "2".
                } 
            }while (!(gameChecker.equals("1")) && !(gameChecker.equals("2")));
            choice = Integer.parseInt(gameChecker);
        }

    /**
     * <p>playGame() method contains both games.  The game that will be played depend on what the input user type in.</p>
     * <p>If 1 then the Sic Bo game is played.  If 2 then the guess the dices number is played.</p>
     * <p>If user doesn't input the correct betting choice (In high-low game is "h", "H", "l", and "L".  In guess the dice value game is 1-6)</p>
     * <p>The method will keep asking user to input again until the correct input is entered.</p>
     * @param die1 is dice 1.  Its mimic the random dice roll.
     * @param die2 is dice 2.  Its mimic the random dice roll.
     * @param die3 is dice 3.  Its mimic the random dice roll.
     * @param total is the total value of 3 dices roll combined.
     * @param highLow is to accept user guess of high or low in high-low game.
     * @param betting is to accept user guess of number in guess the dices number game in a String format.
     * @param bettingNumber is an interger variable equal to betting after formatting.
     */
      
    public static void playGame() {
        int die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die3 = 1 + (int)(Math.random() * ((6 - 1) + 1)); // These 3 three lines is to mimic the random dices roll.
        int total = die1 + die2 + die3; // Calculate the total value of three random dices roll.
        if (choice == 1) {
            String highLow;

            // do_whlie loop to continue asking user if they enter incorrect input.
            do {
                System.out.print("Type in h for high and l for low: ");
                highLow = reader.next(); // Read if user guess high or low.

                if (!(highLow.equalsIgnoreCase("h")) && !(highLow.equalsIgnoreCase("l"))) {
                    // Error messege in case of if user in put something other than h, H, l, and L.
                    System.out.println("Incorrect input. Enter h for high or l for low only."); 
                }

            } while (!(highLow.equalsIgnoreCase("h")) && !(highLow.equalsIgnoreCase("l")));
            
            // Check if user guess correct or not and how much do they win or lose.
            if (highLow.equalsIgnoreCase("h")) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                System.out.println("Total is " + total);
                if (total >= 11) {
                    System.out.println("You win 20 Bath.");
                }
                else {
                    System.out.println("Total is " + total);
                    System.out.println("You lose 10 Bath.");
                }
            }
            else if (highLow.equalsIgnoreCase("l")) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                System.out.println("Total is " + total);
                if (total >= 11) {
                    System.out.println("You lose 10 Bath.");
                }
                else {
                    System.out.println("You win 20 Bath.");
                }
            }
        }
        else if (choice == 2) {
            int bettingNumber;
            String betting;

            // do_while loop to continue asking user if they enter an incorrect input.
            do {
                System.out.print("Type in a number to bet on (1-6): ");
                betting = reader.next(); // Read which number the user guess.
                
                if (!(betting.equals("1")) && !(betting.equals("2")) && !(betting.equals("3")) && 
                !(betting.equals("4")) && !(betting.equals("5")) && !(betting.equals("6"))) {
                    // Error message in case of if user input something other than a number 1-6
                    System.out.println("Incorrect Input. Enter a number between 1-6 only.");
                }

            } while (!(betting.equals("1")) && !(betting.equals("2")) && !(betting.equals("3")) && 
            !(betting.equals("4")) && !(betting.equals("5")) && !(betting.equals("6"))); 
            
            bettingNumber = Integer.parseInt(betting);
            if (bettingNumber <= 6 && bettingNumber >= 1) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                
                // These conditions is to check that, if user guess correctly.  How many dices they guess correctly and how much 
                // they'll win.
                if (bettingNumber == die1 && bettingNumber == die2 && bettingNumber == die3) {
                    System.out.println("You win " + (10*3*((9%6) + 1)) + " Bath.");
                }
                else if ((bettingNumber == die1 && bettingNumber == die2) || (bettingNumber == die1 && bettingNumber == die3) 
                || (bettingNumber == die2 && bettingNumber == die3)) {
                    System.out.println("You win " + (10*2*((9%6) + 1)) + " Bath.");
                }
                else if ((bettingNumber == die1) || (bettingNumber == die2) || (bettingNumber == die2)) {
                    System.out.println("You win " + (10*1*((9%6) + 1)) + " Bath.");
                }
                else {
                    System.out.println("You lose 10 Bath");
                }
            }
        }
    }
}