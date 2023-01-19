/**
 * This Footballer class is the subclasses of the Athlete class.  It has all of the Athlete class Attributes with the addition of the 
 * Sport, position, and team attributes.
 */

package tongbu.nattadol.lab5;

public class Footballer extends Athlete {

    // Class attribute that show the type of sport.
    protected static String sport = "American Football";

    private String position;
    private String team;

    // Constructor of Footballer class.  Need team and position to be pass in as an addition.
    public Footballer(String name, double weight, double height, Gender gender, String nationality,
        String birthDate, String position, String team) {

            // Call the super class constructor using super.
            super(name, weight, height, gender, nationality, birthDate);

            this.position = position;
            this.team = team;
    }

    // These are the additional getter and setter methods of the Footbaler class.
    public String getSport() {
        return sport;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    // Overwriting toString() method.
    public String toString() {
        return name + ", " + weight + "kg, " + height + "m, " + gender + ", " + 
            nationality + ", " + birthDate + ", " + sport + ", " + position + ", " + team;
    }
}


