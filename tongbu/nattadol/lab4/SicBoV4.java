package tongbu.nattadol.lab4;

import java.util.Scanner;

/**
* <p>This SicBoV4 program is the continuation of the SicBoV3 program.  The program ask which game user want to play.</p>
* <p>How do they want to bet, then how much do they win.  When this process end, SicBoV2 will ask the user if they want to keep playing.</p>
* <p>If a user input "a" or "A" the game will start again.  If user input anything else, the game will stop.  While choosing the game to play</p>
* <p>or betting, if user enter the incorrect input.  The game will continue to ask user to enter input until they enter the right input.</p>
*
* <p>SicBoV4 two arrays that will contains user choice of betting and result of each games.  When user decided to quit.  The program will</p>
* <p>Show the summary of all the games user have play.  The summary output format is:</p>
* <p>"### Game Play Summary ###</p>
* <p>Game (Order_of_games) : </p>
* <p>You have bet on (user_choice_of_betting)</p>
* <p>You (win_or_lose) (money) Bath."</p>
*
* @author Nattadol Tongbu
* @version 1.0, 1/12/2023
* ID: 653040445-9
* Sec: 2
*
**/

public class SicBoV4 {
    static int choice; // Declare variable choice with static so its can be used across the program.
    static Scanner reader = new Scanner(System.in); // Create new Scanner with static so its can be use across the program.
    final static int max_Input = 100; // The maximum number of games.
    static String[] gamePlay = new String[max_Input]; // gamePlay keep track of what player has played in the game.
    static String[] gameResult = new String[max_Input]; // gameResult keeps track of what the result of the game.
    static int currentInput = 0; // The current number of games that have been played.

    /**
     * <p>This is the main method.  It will run the getchoice() and playgame() methods first, then ask a user if they want to continue playing or not.</p>
     * <p>If a user input "a" or "A" the game will start again.  If user input anything else, the game will stop.</p> 
     * <p>When user finished playing.  The program will display all of user choices of betting and results.  The maximum number of games is 100</p>
     * @param args is the program arguments.
     * @param answer is to accept user choice of continuing or quiting the game.
     * @param currentInput is to keep track of the number of games user have played.
     * @param max_Input is the maximum number of games that user can play.
     * @param gamePlay is an array that store the user choice of betting.
     * @param gameResult is an array that store the results of the game user have played.
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
        currentInput++;
        } while (answer.equalsIgnoreCase("A"));
        if (currentInput < max_Input) {
            System.out.println("### Game Play Summary ###");
            for (int i = 0; i < currentInput; i++) {
                System.out.println("Game " + (i + 1) + " :\nYou have bet on " + gamePlay[i] + "\nYou " + gameResult[i] + " Baht.");
                System.out.println("Good Bye!");
            }
        }
        else {
            System.out.println("### Game Play Summary ###");
            for (int i = 0; i < max_Input; i++) {
                System.out.println("Game " + (i + 1) + " :\nYou have bet on " + gamePlay[i] + "\nYou " + gameResult[i] + " Baht.");
                System.out.println("You have reached the maximum game you can play. \nGood Bye!");
            }
        }
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
        int die3 = 1 + (int)(Math.random() * ((6 - 1) + 1)); // This 3 three lines is to mimic the random dices roll.
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

            // If user choose to play game 1, add user choice of betting into gamePlay[].
            gamePlay[currentInput] = highLow;

            // Check if user guess correct or not and how much do they win or lose.
            // After the user guess and know the result.  Add the result to gameResult.
            if (highLow.equalsIgnoreCase("h")) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                System.out.println("Total is " + total);
                if (total >= 11) {
                    System.out.println("You win 20 Bath.");
                    gameResult[currentInput] = "win 20";
                }
                else {
                    System.out.println("You lose 10 Bath.");
                    gameResult[currentInput] = "lose 10";
                }
            }
            else if (highLow.equalsIgnoreCase("l")) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                System.out.println("Total is " + total);
                if (total >= 11) {
                    System.out.println("You lose 10 Bath.");
                    gameResult[currentInput] = "lose 10";
                }
                else {
                    System.out.println("You win 20 Bath.");
                    gameResult[currentInput] = "win 10";
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

            // Add number that user guesses to gamePlay[].
            gamePlay[currentInput] = betting;

            // Include lines of code that add the result to gameResult[] after user guessed.
            if (bettingNumber <= 6 && bettingNumber >= 1) {
                System.out.println("Dice 1 : " + die1 + ", Dice 2 : " + die2 + ", Dice 3 : " + die3);
                
                // These conditions is to check that, if user guess correctly.  How many dices they guess correctly and how much 
                // they'll win.
                if (bettingNumber == die1 && bettingNumber == die2 && bettingNumber == die3) {
                    System.out.println("You win " + (10*3*((9%6) + 1)) + " Bath.");
                    gameResult[currentInput] = "win " + (10*3*((9%6) + 1));

                }
                else if ((bettingNumber == die1 && bettingNumber == die2) || (bettingNumber == die1 && bettingNumber == die3) 
                || (bettingNumber == die2 && bettingNumber == die3)) {
                    System.out.println("You win " + (10*2*((9%6) + 1)) + " Bath.");
                    gameResult[currentInput] = "win " + (10*2*((9%6) + 1));
                }
                else if ((bettingNumber == die1) || (bettingNumber == die2) || (bettingNumber == die2)) {
                    System.out.println("You win " + (10*1*((9%6) + 1)) + " Bath.");
                    gameResult[currentInput] = "win " + (10*1*((9%6) + 1));
                }
                else {
                    System.out.println("You lose 10 Bath");
                    gameResult[currentInput] = "lose 10 ";

                }
            }
        }
    }
}