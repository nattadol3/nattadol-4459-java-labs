/**
 * This MySimpleWindow program will create GUI title "My Simple Window".  The GUI has 3 buttons inside which labeled
 * (from left to right) Cancel, Reset, Submit.
 * 
 * Author: Nattadol Thongbu
 * Date: 2/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab7;

import javax.swing.*;
import java.awt.FlowLayout;

public class MySimpleWindow extends JFrame {

    // Creating nessessary components and containers.
    protected JButton cancelButton, submitButton, resetButton;
    protected JPanel mainPanel, buttonPanel;

    // MySimpleWindow class constructor to set the title of the program.
    public MySimpleWindow(String title) {
        super(title);
    }

    public static void main(String[] aStrings) {
        SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
    }

    public static void createAndShowGUI() {

        // Creating object called msw from MySimpleWIndow class.
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");

        msw.addComponents();
        msw.setFrameFeatures();
    }

    public void setFrameFeatures() {
        // Set the default close operetion to exit.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to be visible
        setVisible(true);

        // Set the frame size to fit the components.
        pack();

        // Set the position of the frame to the center of the screen.
        setLocationRelativeTo(null);
    }

    public void addComponents() {

        // Creating JPanel objects for the components.  Set the Layout for buttonPanel to be a FlowLayout
        // and set the horizontal and vertical gap.
        mainPanel = new JPanel();
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        // Creating 3 buttons labeled "Cancel", "Reset", "Submit" respectively.
        cancelButton = new JButton("Cancel");
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        // Add all of the buttons to buttonPanel.
        buttonPanel.add(cancelButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        // Add buttonPanel to the mainPanel.
        mainPanel.add(buttonPanel);

        // Add mainPanel to the frame.
        add(mainPanel);
    }
}