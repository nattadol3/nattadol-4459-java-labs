/**
 * This WorldAthlete program is to show how to create a new objects from class with different attributes,
 * How to use getter and setter method of the class and how to overwrite toString() method.
 * 
 * Author: Nattadol Thongbu
 * Date: 1/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab5;

import tongbu.nattadol.lab5.Athlete.Gender;

public class WorldAthlete {

    /**
     * This is the main method.  It'll create 3 objects from class Athlete, use getter and setter method, and display the object
     * using system.out.println
     **/
    public static void main(String[] args) {

        // Creating new objects
        Athlete ratchanok = new Athlete("Ratchanok Intanon", 55, 1.68, Gender.FEMALE, "Thai", "05/12/1995");
        Athlete wisaksil = new Athlete("Wisaksil Wangek", 51.5, 1.60, Gender.MALE, "Thai", "03/08/1986");
        Athlete tom = new Athlete("Tom Brady", 102, 1.93, Gender.MALE, "American", "03/08/1977");

        // Use getter to get the protected value of the class, setter to change to value of that protected value, and
        // if the class toString() method is overwrited.  We can use system.out.println to print out the object.
        System.out.println(ratchanok.getName() + "'s height is " + ratchanok.getHeight());
        ratchanok.setHeight(1.70);
        System.out.println(ratchanok.getName() + "'s height has increaded to " + ratchanok.getHeight());

        // The toString() method is already overwrited.  So we can use print out the objects to the screen
        System.out.println(ratchanok);
        System.out.println(wisaksil);
        System.out.println(tom);
    }
}