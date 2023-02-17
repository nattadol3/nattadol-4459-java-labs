/**s
 * This AthleteFormV4 program is the subclass of AthleteFormV3 class.  this version add the Hobbies label and five hobbies check boxes underneath Gender.
 * User can check one or more boxes to specify their hobbies.
 * It also add slider for user to specify their experience in the selected sport.  The slider is positioned above the Cancel Reset Submit buttons.
 * 
 * Author: Nattadol Thongbu
 * Date: 2/10/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import tongbu.nattadol.lab7.*;
import javax.swing.*;
import java.awt.*;

public class AthleteFormV4 extends AthleteFormV3 {

    // Declaring nessesary components and containers.
    protected JSlider experienceSlider;
    protected JLabel experienceLabel, hobbiesLabel;
    protected JPanel buttonAndExpPanel, hobbiesPanel, hobbiesCheckBoxPanel, formPanelExtender, nationalityPanel;
    protected JCheckBox readingCheckBox, gardeningCheckBox, watchMoviesCheckBox, shoppingCheckBox, othersCheckBox;

    // AthleteFormV4 class constructor.
    public AthleteFormV4(String title) {

        // Call the super class constructor to set the frame title.
        super(title);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        AthleteFormV4 msw = 
            new AthleteFormV4("Athlete Form V4");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {

        // Call addComponets method fromt the super class.
        super.addComponents();
        
        // Remove nationnalityLabel and nationBox from formPanel.
        formPanel.remove(nationnalityLabel);
        formPanel.remove(nationBox);

        // Set new layout for formPanel.
        formPanel.setLayout(new GridLayout(5, 2, 15, 5)); 

        // Creating nessessary JPanel.
        buttonAndExpPanel = new JPanel(new BorderLayout());
        hobbiesPanel = new JPanel(new BorderLayout());
        hobbiesCheckBoxPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5)); 
        formPanelExtender = new JPanel(new BorderLayout(0, 10));
        nationalityPanel = new JPanel(new GridLayout(1, 2 , 15,5)); 

        // Creating 2 JLabel which labels "Year of experince in this sport:" and "Hobbies:".
        experienceLabel = new JLabel("Year of experince in this sport:");
        hobbiesLabel = new JLabel("Hobbies:");

        // Creating JSlider which have the minimum value of 0, maximum value of 20, and starting value of 0.
        experienceSlider = new JSlider(0, 20, 0);

        // Creating Check boxes for all the hobbies.
        readingCheckBox = new JCheckBox("Reading");
        gardeningCheckBox = new JCheckBox("Gardening");
        watchMoviesCheckBox = new JCheckBox("Watching movies", true);
        shoppingCheckBox = new JCheckBox("Shopping");
        othersCheckBox = new JCheckBox("Others");

        // Add all check boxes to hobbiesCheckBoxPanel.
        hobbiesCheckBoxPanel.add(readingCheckBox);
        hobbiesCheckBoxPanel.add(gardeningCheckBox);
        hobbiesCheckBoxPanel.add(watchMoviesCheckBox);
        hobbiesCheckBoxPanel.add(shoppingCheckBox);
        hobbiesCheckBoxPanel.add(othersCheckBox);

        // Add hobbiesLabel to the north panel and hobbiesCheckBoxPanel to the center panel of hobbiesPanel.
        hobbiesPanel.add(hobbiesLabel, BorderLayout.NORTH);
        hobbiesPanel.add(hobbiesCheckBoxPanel, BorderLayout.CENTER);

        // Add nationnalityLabel and nationBox to nationalityPanel.
        nationalityPanel.add(nationnalityLabel);
        nationalityPanel.add(nationBox);

        // Add formPanel, hobbiesPanel, and nationalityPanel to the north, center, and south panel of formPanelExtender respectively.
        formPanelExtender.add(formPanel, BorderLayout.NORTH);
        formPanelExtender.add(hobbiesPanel, BorderLayout.CENTER);
        formPanelExtender.add(nationalityPanel, BorderLayout.SOUTH);

        // Remove the border from formPanel.
        formPanel.setBorder(null);

        // Set the border to formPanelExtender.
        formPanelExtender.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); 

        // Add formPanelExtender to the north panel of mainPanel
        mainPanel.add(formPanelExtender, BorderLayout.NORTH);

        // Set spacing between major ticks to 5.
        experienceSlider.setMajorTickSpacing(5);

        // Set spacing between minor ticks to 1.
        experienceSlider.setMinorTickSpacing(1);

        // Display the ticks of experienceSlider.
        experienceSlider.setPaintTicks(true);

        // Display the label of ticks for every 5 ticks for experienceSlider.
        experienceSlider.setPaintLabels(true);

        // Make the slider snap to the closest tick when user release the slider.
        experienceSlider.setSnapToTicks(true);

        // Add experienceLabel, experienceSlider, and buttonPanel to the north, center, and south panel of buttonAndExpPanel respectively.
        buttonAndExpPanel.add(experienceLabel, BorderLayout.NORTH);
        buttonAndExpPanel.add(experienceSlider, BorderLayout.CENTER);
        buttonAndExpPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set the border for buttonAndExpPanel.
        buttonAndExpPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); 

        // Add buttonAndExpPanel to the south panel of mainPanel.
        mainPanel.add(buttonAndExpPanel, BorderLayout.SOUTH);
    }
}
