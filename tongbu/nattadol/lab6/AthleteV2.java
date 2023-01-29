/**
 * This AthleteV2 class is the subclass of Athlete.  it add one additional method which is practice that will display text in the following format:
 * "<name_of_athlete> runs for 10 km"
 */

package tongbu.nattadol.lab6;

// Import the Athlete class.
import tongbu.nattadol.lab5.Athlete;

public class AthleteV2 extends Athlete{

    // Constructor of AthleteV2 class.
    public AthleteV2(String name, double weight, double height, Gender gender, String nationality, String birthDate) {
        super(name, weight, height, gender, nationality, birthDate);
    }
    
    public void practice() {
        System.out.print(name + " runs for 10 km");
    }
}
