/**
 * This AthleteFormV12 progame is the subclass of AthleteFormV11.  This version add the functionality to the three sorting buttons
 * previously added in AthleteFormV11.
 * 
 * If the By Name menu is clicked.  The program will sort the list in alphabetical order using the athletes name.  
 * Then it'll display the sorted list.
 * 
 * If the By Height menu is clicked.  The program will use the athletes height to sort the list in order from the shortest to
 * the tallest.  Then it'll display the sorted list.
 * 
 * If the By Height and Weight is clicked.  The program will first sort the athletes by height.  Then if there're athletes
 * that have the same height.  It'll sort those athletes in order form the least weight to the most weight.
 */

package tongbu.nattadol.lab10;

import java.awt.event.ActionEvent;
import javax.swing.*;
import tongbu.nattadol.lab6.AthleteV2;

public class AthleteFormV12 extends AthleteFormV11 {
    
    // Declaring variables from all the Comparators.
    protected NameComparator nameComparator;
    protected HeightComparator heightComparator;
    protected HeightWeightComparator heightWeightComparator;

    // Blank template for the program to use when sorting the athleteArrList.
    protected AthleteV2 tmpAth;

    // AthleteFormV12 class constructor.
    public AthleteFormV12(String title) {
        super(title);

        // Creating object from the Comparators.
        nameComparator = new NameComparator();
        heightComparator = new HeightComparator();
        heightWeightComparator = new HeightWeightComparator();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        AthleteFormV12 msw = new AthleteFormV12("Athlete Form V12");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener();

        // Add listener to the sorting menus.
        byNameMI.addActionListener(this);
        byHeightMI.addActionListener(this);
        byHeightAndWeightMI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);

        Object src0bject = event.getSource();

        // Check the menu that the action occured and handle it accordingly.
        if (src0bject == byNameMI) {
            handleSortingByName();
        } else if (src0bject == byHeightMI) {
            handleSortingByHeight();
        } else if (src0bject == byHeightAndWeightMI) {
            handleSortingByHeightAndWeight();
        }
    }

    // Method for handling sorting by name in alphabetical order.
    public void handleSortingByName() {

        // Using for loop for sorting
        for (int i = 0; i < athleteArrList.size(); i++) {
            for (int j = 1; j < athleteArrList.size() - i; j++) {

                /** 
                 * Check the alphabetical order of the names.
                 * if the current athlete's name come after the next athlete's name on the list. 
                 * swap their position.
                */ 
                if (nameComparator.compare(athleteArrList.get(j - 1), athleteArrList.get(j)) == 1) {

                    // Swapping athletes position in the ArrayList.
                    tmpAth = athleteArrList.get(j - 1);
                    athleteArrList.set(j - 1, athleteArrList.get(j));
                    athleteArrList.set(j, tmpAth);
                }
            }
        }

        // Display the sorted list.
        handleDisplayMI();
    }

    // Method for sorting by height.
    public void handleSortingByHeight() {

        // Using for loop for sorting.
        for (int i = 0; i < athleteArrList.size(); i++) {
            for (int j = 1; j < athleteArrList.size() - i; j++) {

                // Check if the current athlete height is more than the next athlete height on the list.
                // If yes, swap their position.
                if (heightComparator.compare(athleteArrList.get(j - 1), athleteArrList.get(j)) == 1) {

                    // Swapping athletes position in the ArrayList.
                    tmpAth = athleteArrList.get(j - 1);
                    athleteArrList.set(j - 1, athleteArrList.get(j));
                    athleteArrList.set(j, tmpAth);
                }
            }
        }

        // Display the sorted list.
        handleDisplayMI();
    }

    // Method for sorting height and weight.
    public void handleSortingByHeightAndWeight() {

        // Using for loop for sorting.
        for (int i = 0; i < athleteArrList.size(); i++) {
            for (int j = 1; j < athleteArrList.size() - i; j++) {

                /** 
                 * Check if the current athlete height is more than the next athlete height on the list.
                 * If yes, swap its position. If they have the same height. Check the weight.
                 * If current athlete weight more than the next athlete is more than.
                 * Swap their position.
                */ 
                if (heightWeightComparator.compare(athleteArrList.get(j - 1), athleteArrList.get(j)) == 1) {
                    // Swapping athletes position in the ArrayList.
                    tmpAth = athleteArrList.get(j - 1);
                    athleteArrList.set(j - 1, athleteArrList.get(j));
                    athleteArrList.set(j, tmpAth);
                }
            }
        }

        // Display the sorted list.
        handleDisplayMI();
    }
}
