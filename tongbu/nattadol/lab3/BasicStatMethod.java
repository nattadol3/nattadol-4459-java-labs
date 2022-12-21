/**
* This BasicStatMethod program work the same as BasicStat program.  It accept number inputs from user, then it will sort the numbers
* from lowest to highest, find the minimum and maximum value, find the average value and median value, and find standard deviation.
* This program has two methods to do it.  The first method is getInput() method.  This method will get the number inputs from user
* and then return it as a String value store in variable named "input".
* The second method is calculateStat() method.  This method will take the values from the "input" variable, store it in a String array
* seperated by space.  Then it will change each String to double type and stores it in a double array.  The method will then sort the
* number, calulate all the minimum, maximum, average, median, and standard deviation value, then it will display it on the screen.
* the output format is:
* "Enter numbers (separated by space): <user_input>
* Sorted numbers are <sorted_number>
* Minimum: <minimum_value>
* Maximum: <maximum_value>
* Average: <average_value>
* Median: <median_value>
* Standard deviation: <standard_deviation_value>"
*
* Author: Nattadol Tongbu
* ID: 653040445-9
* Sec: 2
* Date: December 21, 2022
*
**/

package tongbu.nattadol.lab3;

import java.text.DecimalFormat;
import java.util.*;
import java.util.Arrays;
import java.lang.Math;

public class BasicStatMethod {
    public static void main(String[] args) {
        String input = getInput();
        calculateStat(input);
    }
    
    public static String getInput() {
        // Create a Scanner.
        Scanner reader = new Scanner(System.in);
        
        // Accept inputs from user, then return the value in String.
        System.out.print("Enter numbers (separated by space): ");
        String numInput = reader.nextLine();
        reader.close();
        return numInput;
    }

    public static void calculateStat(String numInput) {
        // Create a DecimalFormat class.  Used to make the output be in two decimals.
        DecimalFormat decimalF = new DecimalFormat("0.00");
        
        // Crete a String and Double arrays.  String array is used to store user input in arrays.
        // Double array is used to store the input after its get change to double type.  
        String[] numInputToStringArray = numInput.split(" ");
        double[] numDoubleArray = new double[numInputToStringArray.length];
        
        // Check if there're no input from user, then display the error message.
        if (numInput.isEmpty()) {
            System.out.println("Please input at least one number.");
        }
        else {
            // Convert each of the String input in numInputToStringArray to Double type and
            // save it in Double type array numDoubleArray
            for(int i = 0; i < numInputToStringArray.length; i++) {
            numDoubleArray[i] = Double.parseDouble(numInputToStringArray[i]);
            }
            // Sorted the numbers in numDoubleArray.
            System.out.print("Sorted numbers are ");
            Arrays.sort(numDoubleArray);
            for (int i = 0; i < numDoubleArray.length; i++) {
                System.out.print(numDoubleArray[i] + " ");
            }

            // Find the minimal value in the numDoubleArray.
            double min = numDoubleArray[0];
            for (int i = 0; i < numDoubleArray.length; i++) {
                if (numDoubleArray[i] < min) {
                    min = numDoubleArray[i];
                }
            }
            System.out.println("\nMinimum: " + decimalF.format(min));

            // Find the maximum value in the numDoubleArray.
            double max = numDoubleArray[0];
            for (int i = 0; i < numDoubleArray.length; i++) {
                if (numDoubleArray[i] > max) {
                    max = numDoubleArray[i];
                }
            }
            System.out.println("Maximum: " + decimalF.format(max));

            // Find the average value of the values in numDoubleArray.
            Double sum = (double) 0;
            for (int i = 0; i < numDoubleArray.length; i++) {
                sum += numDoubleArray[i];
            }
            Double avg = (sum/numDoubleArray.length);
            System.out.println("Average: " + decimalF.format(avg));

            // Find median of the values in numDoubleArray.
            double median = 0;
            if (numDoubleArray.length % 2 == 0) {
                median = ((numDoubleArray[numDoubleArray.length/2]+numDoubleArray[numDoubleArray.length/2 - 1])/2);
            }
            else {
                median = numDoubleArray[numDoubleArray.length/2];
            }
            System.out.println("Median: " + decimalF.format(median));

            // Find a standard deviation of values in numDuobleArray.
            double sigmaValue = 0;
            double stdDeviation = 0;
            for (int i =0; i < numDoubleArray.length; i++) {
                sigmaValue += Math.pow((numDoubleArray[i] - avg), 2);
            }
            stdDeviation = Math.sqrt((sigmaValue/numDoubleArray.length));
            System.out.println("Standard deviation: " + decimalF.format(stdDeviation));
        }    
    }
}
