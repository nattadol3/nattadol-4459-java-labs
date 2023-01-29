/**
 * This AFFChampionship class is the subclass of Competition class.  It has two additional variables in teamA and teamB.
 * It overwrite the abstract methods (setDescription, setSponsorship) from the superclass, it has one additional method in
 * setPlace() that show the place that the match will be played, and it overwrite the toString() method.
 */

package tongbu.nattadol.lab6;

import java.util.ArrayList;

public class AFFChampionship extends Competition {
    protected String teamA;
    protected String teamB;

    // Constructors of the AFFChampionship
    public AFFChampionship(String name, String region, String teamA, String teamB) {
        this.name = name;
        this.region = region;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public AFFChampionship(String name, String teamA, String teamB) {
        this.name = name;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    // Getter and Setter methods of teamA and teamB.
    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }
    
    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    // setPlace() to show where the match will be played.
    public void setPlace(ArrayList<String> places) {
        System.out.println(name + " plays at these stadiums " + "\n" + places);
    }


    // Overwriting the abstract methods from the super class.
    @Override
    public void setSponsorship(ArrayList<String> sponsors) {
        if (sponsors.size() == 1) {
            System.out.println(sponsors.toString().replace("[", "").replace("]", "") + " is a sponsor of " + name);
        }
        else {
            System.out.println("Sponsors of " + name + " are " + sponsors);
        }
    }
    
    public void setDescription() {
        
    }

    // Overwriting toString() method
    public String toString() {
        return name + " in the final round was the game between " + teamA + " vs. " + teamB + ".";
    }
}
