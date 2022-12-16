package tongbu.nattadol.lab3;

import java.util.Scanner;
public class SicBo {
    public static void main(String[] args) {
        int die1 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die2 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int die3 = 1 + (int)(Math.random() * ((6 - 1) + 1));
        int total = die1 + die2 + die3;
        System.out.println("Choose how do want to bet:");
        System.out.println("Type 1 for choosing high or low numbers.");
        System.out.println("Type 2 for choosing number between 1-6.");
        System.out.print("Enter yourchoice: ");
        Scanner reader = new Scanner(System.in);
        String input = reader.nextLine();

        if (input.equals("1")) {
            System.out.print("Type in h for high and l for low: ");
            String highLow = reader.nextLine();
            System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
            System.out.println("Total is " + total);
            if (highLow.equalsIgnoreCase("h")) {
                if (total >= 11) {
                    System.out.println("You win 20 Bath.");
                }
                else {
                    System.out.println("Total is " + total);
                    System.out.println("You lose 10 Bath.");
                }
            }
            else if (highLow.equalsIgnoreCase("l")) {
                if (total >= 11) {
                    System.out.println("You lose 10 Bath.");
                }
                else {
                    System.out.println("You win 20 Bath.");
                }
            }
            else {
                System.out.println("Incorrect input. Enter a number between 1-6 only.");
            }
        }
        else if (input.equalsIgnoreCase("2")) {
            System.out.print("Print in a number to bet on (1-6): ");
            String betting = reader.nextLine();
            int bettingNumber = Integer.parseInt(betting);
            System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
            if (bettingNumber <= 6) {
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
            }
            else {
                System.out.println("Incorrect Input. Enter a number between 1-6 only.");
            }
        }
        else {
            System.out.println("Incorrevt input. Enter 1 or 2 only.");
        }
        reader.close();
    }  
}
