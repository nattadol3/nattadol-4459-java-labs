/**
 * This AthleteFormV6 program is the subclass of AthleteFormV5 class.  this version use OlympicSymbol class that extends 
 * from JPanel to draw 5 circles that resemble olypic iconic symbol in a white background.  
 * The picture is drawn about the nameLable and nameField and Below the menuBar.
 * 
 * 
 * Author: Nattadol Thongbu
 * Date: 2/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import javax.swing.*;
import java.awt.*;

public class AthleteFormV6 extends AthleteFormV5 {

    // Declaring nessessary container and variable.
    protected OlympicSymbol olympicCircles;
    protected JPanel circlesAndFormPanel;
    
    // AthleteFormV6 class constructor.
    public AthleteFormV6(String title) {

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
        AthleteFormV6 msw = 
            new AthleteFormV6("Athlete Form V6");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {

        // Call the addComponets method from super class.
        super.addComponents();

        // Creating an object from OlympicSymbol class.
        olympicCircles = new OlympicSymbol();

        // Set the preferredSize for the picture to be drawn.
        olympicCircles.setPreferredSize(new Dimension(200, 100));

        // Creating new JPanel for the picuture and formPanel.
        circlesAndFormPanel = new JPanel(new BorderLayout()); 

        // Remove the border previouly set in AthleteFormV4 from formPanelExtender. 
        formPanelExtender.setBorder(null);
        
        // Creating empty border for formPanel, hobbiesPanel, and nationalityPanel.
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        hobbiesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        nationalityPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); 

        // Add the symbol picture to the north panel of circlesAndFormPanel.
        // Add formPanel to the South panel of circlesAndFormPanel.
        circlesAndFormPanel.add(olympicCircles, BorderLayout.NORTH);
        circlesAndFormPanel.add(formPanel, BorderLayout.SOUTH);

        // Add circlesAndFormPanel to the north layout of formPanelExtender.
        formPanelExtender.add(circlesAndFormPanel, BorderLayout.NORTH);

    }

    

}
