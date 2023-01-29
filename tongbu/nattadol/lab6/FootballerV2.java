/**
 * This FootballerV2 class is the subclass of AthleteV2.  It's use polymorphism for the practice() method from AthleteV2 class and will display the text in
 * this following format:
 * "<name_of_athlete> runs for 10 km and catches a football"
 */

package tongbu.nattadol.lab6;

public class FootballerV2 extends AthleteV2 {

    // Class attribute that show the type of sport.
    protected static String sport = "American Football";

    private String position;
    private String team;

     // Constructor of FootballerV2 class.  Need team and position to be pass in as an addition.
     public FootballerV2(String name, double weight, double height, Gender gender, String nationality,
         String birthDate) {
 
             // Call the super class constructor using super.
             super(name, weight, height, gender, nationality, birthDate);
     }
     
     // These are the additional getter and setter methods of the FootballerV2 class.
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

     // Polymorphism method of practice().
     public void practice() {
        super.practice();
        System.out.println(" and catches a football");
     }
}
