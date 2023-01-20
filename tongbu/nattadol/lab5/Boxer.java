/**
 * This Boxer class is the subclasses of the Athlete class.  It has all of the Athlete class Attributes with the addition of the 
 * Sport, division, and golveSize attributes
 */

package tongbu.nattadol.lab5;

public class Boxer extends Athlete {

    // Class attribute that show the type of sport.
    protected static String sport = "Boxing";

    private String division;
    private String golveSize;

    // Constructor of Boxer class.  Need division and golveSize to be pass in as an addition.
    public Boxer(String name, double weight, double height, Gender gender, String nationality,
        String birthDate, String division, String golveSize) {

            // Call the super class constructor using super.
            super(name, weight, height, gender, nationality, birthDate);

            this.division = division;
            this.golveSize = golveSize;
    }

    // These are the additional getter and setter methods of the Boxer class.
    public String getSport() {
        return sport;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getGolveSize() {
        return golveSize;
    }

    public void setGolveSize(String golveSize) {
        this.golveSize = golveSize;
    }
    
    // Overwriting toString() method.
    public String toString() {
        return name + ", " + weight + "kg, " + height + "m, " + gender + ", " + 
            nationality + ", " + birthDate + ", " + sport + ", " + division + ", " + golveSize;
    }
}

