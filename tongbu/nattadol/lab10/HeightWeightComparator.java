/**
 * This HeightWeightComparator class implements  Comparable<AthleteV2> interface.  It has the method called compare
 * that first compare the height of the athletes passed in and return the value that represent 
 * which athlete is taller or shorter.
 * 1 mean the first athlete is taller than the second athlete.
 * -1 mean the first athlete is shorter than the second athlete.
 * 
 * If both athlete have the same height.  The method will then compare both athlete weight and return the value
 * that represent which athlete weight more.
 * 1 mean the first athlete weight more than the second athlete.
 * -1 mean the first athlete weight less than the second athlete.
 * 0 mean they both weight the same. 
 */

package tongbu.nattadol.lab10;

import tongbu.nattadol.lab6.AthleteV2;

public class HeightWeightComparator implements Comparable<AthleteV2> {

    @Override
    public int compareTo(AthleteV2 o) {
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public int compare(AthleteV2 athlete1, AthleteV2 athlete2) {
        int result;

        /**
         * Compare the first athlete height to the second athlete height.
         * If the first athlete height is more than the second athlete height.  set the result to 1.
         * If it less.  set the result to -1.
         * Otherwise compare both athletes weight.
         * if the first athlete weight more than the second athlete set the result to 1.
         * if they weight less set the result to -1.
         * if both weight the same set the result to 0.  
         */
        if (athlete1.getHeight() == athlete2.getHeight()) {
            if (athlete1.getWeight() < athlete2.getWeight()) {
                result = -1;
            } else if (athlete1.getWeight() > athlete2.getWeight()) {
                result = 1;
            } else {
                result = 0;
            }
        } else if (athlete1.getHeight() > athlete2.getHeight()) {
            result = 1;
        } else {
            result = 0;
        }
        
        // return the result.
        return result;
    } 
}
