/**
 * This HeightComparator class implements Comparable<AthleteV2> interface.  It has the method called
 * compare that compare the height of the athletes passed in and return the value that represent
 * which athlete is taller or shorter.
 * 1 mean the first athlete is taller than the second athlete.
 * -1 mean the first athlete is shorter than the second athlete.
 * 0 mean both athlete have the same height.
 */

package tongbu.nattadol.lab10;

import tongbu.nattadol.lab6.AthleteV2;

public class HeightComparator implements Comparable<AthleteV2> {

    @Override
    public int compareTo(AthleteV2 o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    
    // Method to compare athletes height.
    public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
        int result;

        /** 
         * Compare the first athlete height to the second athlete height.
         * If the first athlete height is more than the second athlete height.  set the result to 1.
         * If it less.  set the result to -1.
         * Otherwise set the result to 0.
         */
        if (athlete1.getHeight() < athlete2.getHeight()) {
            result = -1;
        } else if (athlete1.getHeight() > athlete2.getHeight()) {
            result = 1;
        } else {
            result = 0;
        }
        
        // return the result.
        return result;
    }   
}
