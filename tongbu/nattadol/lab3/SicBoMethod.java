/**
* This SicBoMethods program is the same as SicBo program but now we create 2 methods.  The first method getChoice() is use to 
* get the choice of the game that user want to play.  When user input which game they want.  The seccond method playGame is called.
* playGame() is the method contains both the same game as in SicBo program.  The first game required user to guess the total 
* value of three dices.  3-10 is low and 11-18 is high.  If user guess correctly they'll win 20 Bath.  If not they'll 10 Bath.
* The seccond game required user to pick a number 1-6, then the dice is rolled.  If one of the dices roll the same number as user
* have picked.  They'll win 30 Bath.  If two of the dices roll the same number as user have picked.  They'll 60 Bath.  
* If all of the dices roll the same number as user have picked.  They'll win 90 Bath.  
* If none of the dices roll the same number as user have picked.  They'll lose 10 Bath.
* Each round of both game required 10 Bath to play.
*
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 17, 2022
*
**/

package tongbu.nattadol.lab3;

import java.util.Scanner; // Import Scanner to read the user input.

public class SicBoMethod {
    static int choice; // Declare variable choice with static so its can be used across the program.
    static Scanner reader = new Scanner(System.in); // Create new Scanner with static so its can be use across the program.
    public static void main(String[] args) {
        getChoice();
        playGame();
    }
    
    public static void getChoice() {
        System.out.println("Choose how do want to bet:");
        System.out.println("Type 1 for choosing high or low numbers.");
        System.out.println("Type 2 for choosing number between 1-6.");
        System.out.print("Enter yourchoice: ");
        choice = reader.nextInt(); // Read the input to see which game user want to play.
    }
        // getChoice() method to ask the user for which game they want to play, read the input, and pass the value to variable choice.

    public static void playGame() {
        int die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die3 = 1 + (int)(Math.random() * ((6 - 1) + 1)); // This 3 three lines is to mimic the random dices roll.
        int total = die1 + die2 + die3; // Calculate the total value of three random dices roll.
        if (choice == 1) {
            System.out.print("Type in h for high and l for low: ");
            String highLow = reader.next(); // Read if user guess high or low.
            if (highLow.equalsIgnoreCase("h")) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                System.out.println("Total is " + total);
                if (total >= 11) {
                    System.out.println("You win 20 Bath.");
                }
                else {
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
            else {
                System.out.println("Incorrect input. Enter h for high or l for low only."); 
                // Error messege in case of if user in put something other than h, H, l, and L.
            }
        }
        else if (choice == 2) { 
            System.out.print("Type in a number to bet on (1-6): ");
            String betting = reader.next(); // Read which number the user guess.
            int bettingNumber = Integer.parseInt(betting);
            if (bettingNumber <= 6 && bettingNumber >= 1) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                
                // These conditions is to check that, if user guess correctly.  How many dices they guess correctly and how much 
                // they'll win.
                if (bettingNumber == die1 && bettingNumber == die2 && bettingNumber == die3) {
                    System.out.println("You win 90 Bath.");
                }
                else if ((bettingNumber == die1 && bettingNumber == die2) || (bettingNumber == die1 && bettingNumber == die3) 
                || (bettingNumber == die2 && bettingNumber == die3)) {
                    System.out.println("You win 60 Bath.");
                }
                else if ((bettingNumber == die1) || (bettingNumber == die2) || (bettingNumber == die2)) {
                    System.out.println("You win 30 Bath.");
                }
                else {
                    System.out.println("You lose 10 Bath");
                }
            }
            else {
                System.out.println("Incorrect Input. Enter a number between 1-6 only.");
                // Error message in case of if user input something other than a number 1-6
            }
        }
        else {
            System.out.println("Incorrect input. Enter 1 or 2 only."); 
            // Error message in case of if user input something other than "1" or "2".
        } 
        // playGame() method contains both games.  The game that will be played depend on what the input user type in.
        // If 1 then the Sic Bo game is played.  If 2 then the guess the dices number is played.
        reader.close(); // Close the Scanner
    }
}
