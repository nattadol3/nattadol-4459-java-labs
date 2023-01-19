/**
 * This BadmintonPlayer class is the subclasses of the Athlete class.  It has all of the Athlete class Attributes with the addition of the 
 * racketLength, worldRanking, and sport attributes.
 */

package tongbu.nattadol.lab5;

public class BadmintonPlayer extends Athlete {

    // Class attribute that show the type of sport.
    protected static String sport = "Badminton";

    private double racketLength;
    private int worldRanking;

    // Constructor of BadmintonPlayer class.  Need racketLength and worldRanking to be pass in as an addition.
    public BadmintonPlayer(String name, double weight, double height, Gender gender, String nationality,
        String birthDate, double racketLength, int worldRanking) {

            // Call the super class constructor using super.
            super(name, weight, height, gender, nationality, birthDate);

            this.racketLength = racketLength;
            this.worldRanking = worldRanking;
    }
    
    // These are the additional getter and setter methods of the BadmintonPlayer class.
    public static String getSport() {
        return sport;
    }

    public double getRacketLength() {
        return racketLength;
    }

    public void setRacketLength(double racketLength) {
        this.racketLength = racketLength;
    }

    public int getWorldRanking() {
        return worldRanking;
    }

    public void setWorldRanking(int worldRanking) {
        this.worldRanking = worldRanking;
    }

    // Overwritng toString() method.
    public String toString() {
        return name + ", " + weight + "kg, " + height + "m, " + gender + ", " + 
            nationality + ", " + birthDate + ", " + sport + ", " + racketLength + ", rank:" + worldRanking;
    }
}