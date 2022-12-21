/**
* This BasicStat program is used to accept several number inputs from user.  The program will then sort the number in order
* from lowest to highest,  find the minimum and maximum value, find the average value and median value, and find standard deviation.
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


public class BasicStat{
    public static void main(String[] args) {
        // Create a Scanner and DecimalFormat to use in the program.
        Scanner reader = new Scanner(System.in);
        DecimalFormat decimalF = new DecimalFormat("0.00");

        // Accept inputs from user, then put it in a String array.
        System.out.print("Enter numbers (separated by space): ");
        String numInput = reader.nextLine();
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
        reader.close();
    }
}