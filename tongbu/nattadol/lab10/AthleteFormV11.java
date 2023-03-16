/**
 * This AthleteFormV11 program is the subclass of AthleteFormV12 progame.  This version add a new menu labeled "Data".  When clicked,
 * there'll be 5 menus labeled "Add", "Display", "Clear", "Search", and "Sort" respectively.
 * 
 * When the Add menu is clicked.  The program will create an object from AthleteV2 class using information from the form, then
 * it'll add that object into an ArrayList.  It'll then display the athlete infomation in the following format:
 * "Athlete [<Name>, <Weight>, <Height>, <Gender>, <Nationality>, <Date_of_Birth>]"
 * 
 * When the Display menu is clicked.  The program will display all the athletes that had been added to the list 
 * strating from the first athlete that was added.  The format is:
 * "There are <Number_of_Athletes_Added> as follows: 
 * 1. Athlete [<Name>, <Weight>, <Height>, <Gender>, <Nationality>, <Date_of_Birth>]
 * 2. Athlete <Name2>, <Weight2>, <Height2>, <Gender2>, <Nationality2>, <Date_of_Birth2>]
 * .
 * .
 * .
 * "
 * 
 * When the Clear menu is clicked.  The program will clear all the objects in the ArrayList then it'll display the message:
 * "All athletes are cleared!"
 * 
 * When the Search menu is clicked.  The program will display the input window for user to input the name of the athlete they want
 * to search for.  If that athlete is in the ArrayList, it'll display the athlete information in the following format:
 * "Athlete [<Name>, <Weight>, <Height>, <Gender>, <Nationality>, <Date_of_Birth>]"
 * 
 * If the athlete that user search for is not in the list.  It'll display the following message:
 * "Athlete <Input_Name> is NOT found"
 * 
 * When the Sort menu is clicked.  It'll display three more menus labeled "By Name", "By Height", and "By Height and Weight".
 * These three menus don't do anything yet.
 */

package tongbu.nattadol.lab10;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.Color;
import javax.swing.*;
import tongbu.nattadol.lab9.AthleteFormV10;
import tongbu.nattadol.lab5.Athlete.Gender;
import tongbu.nattadol.lab6.AthleteV2;

public class AthleteFormV11 extends AthleteFormV10 {

    // Declaring JMenu, JMenuItem, and ArrayList.
    protected JMenu dataMenu, sortMenu;
    protected JMenuItem addMI, displayMI, clearMI,
            searchMI, byNameMI,
            byHeightMI, byHeightAndWeightMI;
    protected ArrayList<AthleteV2> athleteArrList;

    // Declare Lists and ArrayLists for JMenus and JMenuItems.
    protected List<JMenu> menusList;
    protected List<JMenuItem> menuItemsList;
    protected ArrayList<JMenu> menusArrList;
    protected ArrayList<JMenuItem> menuItemsArrList;

    // AthleteFormV11 class constructor.
    public AthleteFormV11(String title) {
        super(title);

        // Creating athleteArrList.
        athleteArrList = new ArrayList<>();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        AthleteFormV11 msw = new AthleteFormV11("Athlete Form V11");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void addMenus() {
        super.addMenus();

        // Creating JMenu.
        dataMenu = new JMenu("Data");
        sortMenu = new JMenu("Sort");

        // Creating JMenuItem.
        addMI = new JMenuItem("Add");
        displayMI = new JMenuItem("Display");
        clearMI = new JMenuItem("Clear");
        searchMI = new JMenuItem("Search");
        byNameMI = new JMenuItem("By Name");
        byHeightMI = new JMenuItem("By Height");
        byHeightAndWeightMI = new JMenuItem("By Height and Weight");

        // Add menus and menuItems into dataMenu.
        dataMenu.add(addMI);
        dataMenu.add(displayMI);
        dataMenu.add(clearMI);
        dataMenu.add(searchMI);
        dataMenu.add(sortMenu);

        // Add the sorting menuItems into sortMenu.
        sortMenu.add(byNameMI);
        sortMenu.add(byHeightMI);
        sortMenu.add(byHeightAndWeightMI);

        // Creating Lists and ArrayLists for JMenus and JMenuItems.
        menusList = Arrays.asList(fileMenu, configMenu, dataMenu,
                colorMenu, sizeMenu, sortMenu);
        menusArrList = new ArrayList<JMenu>(menusList);

        menuItemsList = Arrays.asList(newItem, saveItem, openItem, exitItem,
                redItem, greenItem, blueItem, sixtSize,
                twentSize, twenTFourSize, addMI, displayMI,
                clearMI, searchMI, byNameMI, byHeightMI,
                byHeightAndWeightMI);
        menuItemsArrList = new ArrayList<JMenuItem>(menuItemsList);

        // Set the font for the menus.
        setMenusFont(menuSanSerifFont);

        // Set the font for the menuItems.
        setMIsFont(menuSanSerifFont);

        // Set the color for the menus.
        setMenusBGColor(menuDarkblueColor);

        // Set the color for the menuItems.
        setMIsBGColor(menuDarkblueColor);

        // Add dataMenu into menuBar.
        menuBar.add(dataMenu);
    }

    // Method for setting menus font.
    public void setMenusFont(Font font) {
        for (JMenu menu : menusArrList) {

            // Change the menus font to the font that is passed into the method.
            menu.setFont(font);
        }
    }

    // Method for setting menus font color.
    public void setMenusBGColor(Color color) {
        for (JMenu menu : menusArrList) {

            // Change the menus font color to the color that is passed into the method.
            menu.setForeground(color);
        }
    }

    // Method for setting menu items font.
    public void setMIsFont(Font font) {
        for (JMenuItem mi : menuItemsArrList) {

            // Change the menu items font to the font passed into the method.
            mi.setFont(font);
        }
    }

    // Method for setting menu items font color.
    public void setMIsBGColor(Color color) {
        for (JMenuItem mi : menuItemsArrList) {

            // Change menu items font color to the color passed into the method.
            mi.setForeground(color);
        }
    }

    @Override
    public void addListener() {
        super.addListener();

        // Add ActionListener into the menu and menuItems.
        addMI.addActionListener(this);
        displayMI.addActionListener(this);
        clearMI.addActionListener(this);
        searchMI.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);

        Object sr0bject = event.getSource();

        // Checking the source of action and handle accordingly.
        if (sr0bject == addMI) {
            handleAddMI();
        } else if (sr0bject == displayMI) {
            handleDisplayMI();
        } else if (sr0bject == clearMI) {
            handleClearMI();
        } else if (sr0bject == searchMI) {
            handleSearchMI();
        }
    }

    // Method for handling addMI action.
    public void handleAddMI() {

        // Get the weight and height string form the textfields and
        // convert it into double type value.
        String weightString = weightField.getText();
        String heightString = heightField.getText();
        double weight = Double.parseDouble(weightString);
        double height = Double.parseDouble(heightString);

        // Declaring Gender enum type variable to store the gender value.
        Gender gender;

        // Check the gender radio button that is selected and change the
        // gender value accordingly.
        if (maleRButton.isSelected()) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }

        // Creating new AthleteV2 object using the value from the form.
        AthleteV2 athlete = new AthleteV2(nameField.getText(), weight, height, gender,
                nationBox.getSelectedItem().toString(), bodField.getText());

        // Using toString method from AthleteV2 to show the pop up message.
        JOptionPane.showMessageDialog(null, athlete.toString());

        // Add the athlete object into athleteArrList.
        athleteArrList.add(athlete);
    }

    public void handleDisplayMI() {

        // Blank template for the athlete name list and number of athlete.
        String athletes = "";
        int numAthletes = 0;

        // Check if the athleteArrList is empty or not.
        if (athleteArrList.size() == 0) {

            // Pop up message if there are no athlete in the athleteArrList.
            JOptionPane.showMessageDialog(null, "There is no athlete in the list");
        } else {

            // Extend the athletes string with toString for every athlete
            // in the athleteArrList.
            for (int i = 0; i < athleteArrList.size(); i++) {
                athletes += (i + 1) + ". " + athleteArrList.get(i).toString() + "\n";
                numAthletes++;
            }

            // Pop up message to show the athlete that has been added.
            JOptionPane.showMessageDialog(null, "There are " + numAthletes + " athletes as follows:\n" +
                    athletes);
        }
    }

    public void handleClearMI() {

        // Clear the athleteArrList.
        athleteArrList.clear();

        // Pop up message if the Clear menu is clicked.
        JOptionPane.showMessageDialog(null, "All athletes are cleared!");
    }

    public void handleSearchMI() {

        // String to accept input from the input dialog
        String atheleteName = JOptionPane.showInputDialog(null, "Please enter athlete name:");

        // Check if athleteArrList is empty or not.
        if (athleteArrList.isEmpty()) {

            // Pop up message if there are no athlete in the athleteArrList
            JOptionPane.showMessageDialog(null, "Athlete " + atheleteName + " is NOT found");
        } else {

            // Check for every athlete in the athleteArrList if the
            // input name is matched with any athlete.
            for (AthleteV2 ath : athleteArrList) {
                if (atheleteName.equalsIgnoreCase(ath.getName())) {

                    // Pop up message if the input name is match.
                    JOptionPane.showMessageDialog(null, ath.toString());
                } else {
                    
                    // Pop up message if input name is not match with any names in
                    // the athleteArrList.
                    JOptionPane.showMessageDialog(null, "Athlete " + atheleteName + " is NOT found");
                }
            }
        }
    }
}