/**
 * This NameComparater class implements the Comparable<AthleteV2> interface.  It has the method
 * called compare that compare the name of the athletes passed in and return the value
 * that represent the alphabetical order of the athlete names.  
 * 1 mean the first athlete name come after the the second athlete name.
 * -1 mean the first athlete name come before the athlete second name.
 * 0 mean the first athlete name is the same as the second athlete name.
 */

package tongbu.nattadol.lab10;

import tongbu.nattadol.lab6.AthleteV2;

public class NameComparator implements Comparable<AthleteV2> {

    @Override
    public int compareTo(AthleteV2 o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
        int result;

        // Check the alphabetical order of the first athlete name compare to the second athlete name.
        // If the first athlete name come after second athlete, set the result to 1.
        // If it come before, set the result to -1.
        // Otherwise set the result to 0.
        if (athlete1.getName().compareTo(athlete2.getName()) > 0) {
            result = 1;
        } else if (athlete1.getName().compareTo(athlete2.getName()) < 0) {
            result = -1;
        } else {
            result = 0;
        }
        
        // return the result.
        return result;
    }   
}
