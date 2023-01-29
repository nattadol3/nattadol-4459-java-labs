/**
 * This InterestoingCompetitions program will create two objects from the AFFChampionship class.
 * Create two String Arraylist call sponsors and places.  Then it'll use the method from the AFFChampionship class 
 * to set the place of the stadium, sponsors of the competition and It'll display the finalist of the tournament,
 * the place of the stadium, and the sponsors to the screen.
 */

package tongbu.nattadol.lab6;

import java.util.ArrayList;

public class InterestingCompetitions {
    public static void main(String[] args) {
    
    // Creating objects from AFFChampionship class.
    AFFChampionship aff2022 = new AFFChampionship("AFF 2022", "Thailand", "Vietnam");
    AFFChampionship aff2020 = new AFFChampionship("AFF 2020", "Thailand", "Indonesia");
    System.out.println(aff2020);
    System.out.println(aff2022);

    // Create two Arraylists that contain the place of the stadium and the sponsors of the tournament.
    // Then use setPlace() and setSponsorship() to set the value of the place of the stadium and sponsors of the tournament to the aff2022 object.
    ArrayList<String> places = new ArrayList<String>();
    places.add("Hanoi");
    places.add("Bangkok");
    aff2022.setPlace(places);
    ArrayList<String> sponsors = new ArrayList<String>();
    sponsors.add("Mitsubishi Electronics");
    aff2022.setSponsorship(sponsors);

    // Remove and add some of the places and sponsor and set place and set sponsor of the aff2020 object.
    places.remove("Hanoi");
    places.add("Kallang");
    aff2020.setPlace(places);
    sponsors.remove("Mitsubishi Electronics");
    sponsors.add("Suzuki");
    sponsors.add("Yanmar");
    aff2020.setSponsorship(sponsors);
    }
}
