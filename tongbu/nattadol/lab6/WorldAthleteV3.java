/**
 * This WorldAthleteV3 program will create an ArrayList, three objects from class BadmintonPlayerV2, FootballerV2, and BoxerV2 respectively.
 * It will then add all three objects into the ArrayList and display them using for loop and overrided toString() method.
 */

package tongbu.nattadol.lab6;

import java.util.ArrayList;

public class WorldAthleteV3 {
    public static void main(String[] args) {

        // Creating ArrayList named athletes which accept AthleteV2 objects.
        ArrayList<AthleteV2> athletes = new ArrayList<AthleteV2>();

        // Creating objects from BadmintonPlayer, Footballer, and Boxer classes.
        BadmintonPlayerV2 ratchanok = new BadmintonPlayerV2("Ratchanok Intanon", 55, 1.68, AthleteV2.Gender.FEMALE, 
            "Thai", "05/02/1995");
        FootballerV2 tom = new FootballerV2("Tom Brady", 102, 1.93, AthleteV2.Gender.MALE, 
            "American", "03/08/1977");
        BoxerV2 wisaksil = new BoxerV2("Wisaksil Wangek", 51.5, 1.60, AthleteV2.Gender.MALE, 
            "Thai", "08/12/1986");
        
        // Adding all three objects into the ArrayList.
        athletes.add(ratchanok);
        athletes.add(wisaksil);
        athletes.add(tom);

        // Display all three objects using overrided toString() method.
        for (AthleteV2 athlete : athletes) {
            System.out.println(athlete);
            athlete.practice();
        }
    }
}
