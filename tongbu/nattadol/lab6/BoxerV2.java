/**
 * This BoxerV2 class is the subclass of AthleteV2.  It's use polymorphism for the practice() method from AthleteV2 class and will display the text in
 * this following format:
 * "<name_of_athlete> runs for 10 km and swings arms"
 */

package tongbu.nattadol.lab6;

public class BoxerV2 extends AthleteV2 {

    // Class attribute that show the type of sport.
    protected static String sport = "Boxing";

    private String division;
    private String golveSize;

    // Constructor of BoxerV2 class.  Need division and golveSize to be pass in as an addition.
    public BoxerV2(String name, double weight, double height, Gender gender, String nationality,
        String birthDate) {

            // Call the super class constructor using super.
            super(name, weight, height, gender, nationality, birthDate);
    }

    // These are the additional getter and setter methods of the BoxerV2 class.
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

    // Polymorphism method of practice().
    public void practice() {
        super.practice();
        System.out.println(" and swings arms");
    }
}
