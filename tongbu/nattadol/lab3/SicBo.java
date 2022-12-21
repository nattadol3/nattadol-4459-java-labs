/**
* This SicBo program is a gamble game and it's to accept 3 arguments:  The first arguments is the game that user want to play
* The first game is to guess the total value of 3 dices.  if total value is between 3-10 its count as low
* if the total value is between 11-18 its count as high.  User will need to input h or H to guess high or l or L
* to guess low.  If user guess correctly, they'll win 20 Bath.  If they guess incorrectly, they'll lose 10 Bath.
* 
* The seccond game is to guess a number and see if that number will match one, two, all dices.  
* User will need to in put a number betteen 1-6 to guess.  if user guess one of the dices value correctly, they'll win 30 Bath.
* If user guess two of the dices value correctly, they'll win 60 Bath.  If user guess all of the dice value correctly, they'll
* win 90 Bath.  If user guess none of the dices value correctly, they'll lose 10 Bath.
* The bet to play each round of both game is 10 Bath.
*
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 16, 2022
*
**/

package tongbu.nattadol.lab3;

import java.util.Scanner; // To import Scanner.  It's used to read the arguments that user input.
import java.util.Random;

public class SicBo {
    public static void main(String[] args) {
        int die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die3 = 1 + (int)(Math.random() * ((6 - 1) + 1)); // This 3 three lines is to mimic the random dices roll.
        int total = die1 + die2 + die3; // Calculate the total value of three random dices roll.
        System.out.println("Choose how do want to bet:");
        System.out.println("Type 1 for choosing high or low numbers.");
        System.out.println("Type 2 for choosing number between 1-6.");
        System.out.print("Enter yourchoice: ");
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine(); // Read the input to see which game user want to play.

        if (input.equals("1")) {
            System.out.print("Type in h for high and l for low: ");
            String highLow = reader.nextLine(); // Read if user guess high or low.
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
            else {
                System.out.println("Incorrect input. Enter h for high or l for low only."); 
                // Error messege in case of if user in put something other than h, H, l, and L.
            }
        }
        else if (input.equalsIgnoreCase("2")) {
            System.out.print("Type in a number to bet on (1-6): ");
            String betting = reader.nextLine(); // Read which number the user guess.
            int bettingNumber = Integer.parseInt(betting);
            if (bettingNumber <= 6 && bettingNumber >= 1) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                if (bettingNumber == die1 && bettingNumber == die2 && bettingNumber == die3) {
                    System.out.println("You win 90 Bath.");
                }
                else if (bettingNumber == die1 && bettingNumber == die2) {
                    System.out.println("You win 60 Bath.");
                }
                else if (bettingNumber == die1 && bettingNumber == die3) {
                    System.out.println("You win 60 Bath.");
                }
                else if (bettingNumber == die2 && bettingNumber == die3) {
                    System.out.println("You win 60 Bath.");
                }
                else if (bettingNumber == die1) {
                    System.out.println("You win 30 Bath.");
                }
                else if (bettingNumber == die2) {
                    System.out.println("You win 30 Bath.");
                }
                else if (bettingNumber == die2) {
                    System.out.println("You win 30 Bath.");
                }
                else {
                    System.out.println("You lose 10 Bath");
                }
                // These conditions is to check that, if user guess correctly.  How many dices they guess correctly and how much 
                // they'll win.
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
        reader.close(); // Close the Scanner.
    }  
}
