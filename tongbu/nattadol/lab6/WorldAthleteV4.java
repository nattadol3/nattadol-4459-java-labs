/**
 * This WorldAthleteV4 program will creates two objects from class BadmintonPlayerV3.  It will then use setWorldRanking() and setSpeed() method from the class
 * for both objects and display each object using overrided toString() on to the screen.
 */

package tongbu.nattadol.lab6;

import tongbu.nattadol.lab5.*;
import java.util.*;

public class WorldAthleteV4 {
    public static void main(String[] args) {

        // Creating objects from BadmintonPlayerV3.
        BadmintonPlayerV3 akane = 
            new BadmintonPlayerV3("Akane Yamaguchi", 55, 1.68, 
                Athlete.Gender.FEMALE, "Japan", "05/02/1997");
        BadmintonPlayerV3 ratchanok =
            new BadmintonPlayerV3("Ratchanok Intanon", 55, 1.68,
                 Athlete.Gender.FEMALE, "Thai", "05/02/1995");

        // Using method from the class to change object instance variables value.
        akane.setWorldRanking(1);
        ratchanok.setWorldRanking(6);
        akane.setSpeed(4);
        ratchanok.setSpeed(6);

        // Creating ArrayList and add both objects in.
        ArrayList<BadmintonPlayerV3> badmintonPlayers = new ArrayList<BadmintonPlayerV3>();
        badmintonPlayers.add(akane);
        badmintonPlayers.add(ratchanok);

        // Display both objects using overrided toString() method.
        for (BadmintonPlayerV3 badmintonPlayer : badmintonPlayers) {
            System.out.println(badmintonPlayer);
        }
    }
}
