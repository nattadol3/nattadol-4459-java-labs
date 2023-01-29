/**
 * This BadmintonPlayerV2 class is the subclass of AthleteV2.  It's use polymorphism for the practice() method from AthleteV2 class and will display the text in
 * this following format:
 * "<name_of_athlete> runs for 10 km and olays half court singles"
 */

package tongbu.nattadol.lab6;

public class BadmintonPlayerV2 extends AthleteV2 {

    // Class attribute that show the type of sport.
    protected static String sport = "Badminton";

    private double racketLength;
    private int worldRanking;

    // Constructor of BadmintonPlayer class.  Need racketLength and worldRanking to be pass in as an addition.
    public BadmintonPlayerV2(String name, double weight, double height, Gender gender, String nationality,
        String birthDate) {

            // Call the super class constructor using super.
            super(name, weight, height, gender, nationality, birthDate);
    }

    // These are the additional getter and setter methods of the BadmintonPlayerV2 class.
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

    // Polymorphism method of practice().
    public void practice() {
        super.practice();
        System.out.println(" and plays half court singles");
    }

}
