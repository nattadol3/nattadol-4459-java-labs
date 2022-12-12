/**
* This program declare several variables with different datatypes.  Then output
* those variables to the screen to help understanding how each of the datatypes
* work. 
* 
* Author : Nattadol Tongbu
* ID : 653040445-9
* sec : 2
* Date : December 10, 2022
*/

package tongbu.nattadol.lab2;

public class DataTypes {
    public static void main(String[] args) {
        String your_name = "Nattadol Tongbu";
        String studentID = "6530404459";
        char theFirstLetterOfYourFirstName = your_name.charAt(0);
        boolean value = true;
        String myIdInOctal = "73";
        int theLastTwoDigitsOfMyIDNumberFromOctal = Integer.parseInt(myIdInOctal,8);
        String myIdInHexa = "3b";
        int theLastTwoDigitsOfMyIDNumberFromHexa = Integer.parseInt(myIdInHexa,16);
        long myIdInLong = 59;
        float lastTwoDigitsWithFirstTwoDigits = 59.65F;
        double lastTwoDigitsWithCurrentYear = 59.22;

        System.out.println("My name is " + your_name);
        System.out.println("My student ID was " + studentID);
        System.out.println(theFirstLetterOfYourFirstName + " " + value + " " + theLastTwoDigitsOfMyIDNumberFromOctal + " " + theLastTwoDigitsOfMyIDNumberFromHexa);
        System.out.println(myIdInLong + " " + lastTwoDigitsWithFirstTwoDigits + " " + lastTwoDigitsWithCurrentYear);
    }
}