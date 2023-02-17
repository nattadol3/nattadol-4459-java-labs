/**
 * This AthleteFormV7 class is the subclass of AthleteFormV6 class.  This version use the ReadImage class that extends from JPanel to
 * read and add the picture of olympic athletes above the cancel, reset, and submit button.  Below the experinence slider.  
 * 
 * Author: Nattadol Thongbu
 * Date: 2/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import javax.swing.*;
import java.awt.*;

public class AthleteFormV7 extends AthleteFormV6 {

    // Declaring nessessary containers and variables.
    protected ReadImage athleteImg;
    protected JPanel southPanel, experiencePanel;
    protected JScrollPane scrollBar;

    // AthleteFormV7 class constructor.
    public AthleteFormV7(String title) {

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
        AthleteFormV7 msw = new AthleteFormV7("Athlete Form V7");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {

        // Call the addComponents method from super class.
        super.addComponents();

        // Creating nessessary panel.
        southPanel = new JPanel(new BorderLayout()); 
        experiencePanel = new JPanel(new BorderLayout());

        // Creating new object from the ReadImage class.
        athleteImg = new ReadImage();

        // Set the preferred size of the image.
        athleteImg.setPreferredSize(new Dimension(400, 300));

        // Add the experienceLabel to the center panel and experienceSlider to the south panel to experiencePanel.
        experiencePanel.add(experienceLabel, BorderLayout.CENTER);
        experiencePanel.add(experienceSlider, BorderLayout.SOUTH);

        // Add experiencePanel to the north panel, athleteImg to the center panel, and buttonPanel to the south panel of the southPanel
        southPanel.add(experiencePanel, BorderLayout.NORTH);
        southPanel.add(athleteImg, BorderLayout.CENTER);
        southPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Creating an empty border for experiencePanel
        experiencePanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));

        // Creating an empty border for mainPanel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));

        // Add southPanel to the south panel of mainPanel
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // Creating new JScrollPane object that contain mainPanel inside.
        scrollBar = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add scrollBar into the frame/
        add(scrollBar);

        // Change the scrolling speed of the scrollBar.
        scrollBar.getVerticalScrollBar().setUnitIncrement(15);
    }

}
