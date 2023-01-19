/* This WorldAthleteV2 program is the continuation of the WorldAthlete program.  The program will create 4 objects from different classes
 * that belong to a different sports.  It's will display each objects attributes, using compareAge() to compare two athletes age,
 * and using ifTaller() to compare two athletes height.
 * 
 * Each classes used is the subclass of the Athlete class.
 * 
 **/

package tongbu.nattadol.lab5;

public class WorldAthleteV2 {
    public static void main(String[] args) {

    // Creating objects from BadmintonPlayer, Footballer, and Boxer classes.
    BadmintonPlayer ratchanok = new BadmintonPlayer("Ratchanok Intanon", 55, 1.68, Athlete.Gender.FEMALE, 
        "Thai", "05/02/1995", 66.5, 4);
    Footballer tom = new Footballer("Tom Brady", 102, 1.93, Athlete.Gender.MALE, 
        "American", "03/08/1977", "Quarterback", "New England Patriot");
    Boxer wisaksil = new Boxer("Wisaksil Wangek", 51.5, 1.60, Athlete.Gender.MALE, 
        "Thai", "08/12/1986", "Super Flyweight", "M");
    
    // Display each object attributes    
    System.out.println(ratchanok);
    System.out.println(wisaksil);
    System.out.println(tom);
    BadmintonPlayer nitchaon = new BadmintonPlayer("Nitchaon Jindapol", 52, 1.63, Athlete.Gender.FEMALE, 
        "Thailand", "31/03/1998", 67, 11);
    System.out.println("Both " + ratchanok.getName() + " and " + nitchaon.getName() +
        " play " + BadmintonPlayer.getSport());
    
    // compareAge() method from Athlete class to compare two athletes age.
    ratchanok.compareAge(tom);
    ratchanok.compareAge(nitchaon);

    // If the first athlete is taller than the second athlete.  Display "First athelte is taller than second athlete".
    // If not display "First athlete is not taller than second athlete"
    if(isTaller(wisaksil, tom)) {
        System.out.println(wisaksil.getName() + " is taller than " + tom.getName());
    }
    else {
        System.out.println(wisaksil.getName() + " is not taller than " + tom.getName());
    }
    }

    // isTaller() method need two Athlete or its subclasses to be pass in.  if the first athlete passed in is taller than the second
    // athlete.  Return true, if not return false.
    public static boolean isTaller(Athlete athlete1, Athlete athlete2) {
        boolean isTaller;
        if (athlete1.height > athlete2.height) {
            isTaller = true;
        }
        else {
            isTaller = false;
        }
        return isTaller;
        }   
    }
