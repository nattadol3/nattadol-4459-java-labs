/**
 * This AthleteForm program is the subclass to MysimpleWindow Class.  It add the form for accepting athlete information which is
 * name, weight, height, Date of Birth, and gender.
 * 
 * Author: Nattadol Thongbu
 * Date: 2/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab7;

import javax.swing.*;
import java.awt.*;

public class AthleteForm extends MySimpleWindow {

    // Creating nessessary components and containers.
    protected JPanel formPanel, rButtonPanel;
    protected JLabel nameLabel, weightLabel, heightLabel, birthDateLabel, genderLabel;
    protected JTextField nameField, weightField, heightField, bodField;
    protected ButtonGroup genderBGroup;
    protected JRadioButton maleRButton, femaleRButton;

    // AthleteForm class constructor.
    public AthleteForm(String title) {

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

        // Creating object called msw from AthleteForm class.
        AthleteForm msw = 
            new AthleteForm("Athlete Form");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {

        // Call the superclass addComponent().
        super.addComponents();

        // Change mainPanel layout to BorderLayout and add the buttonPanel to the south panel.
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Creating nessessary JLabels for the information.
        nameLabel = new JLabel("Name :");
        weightLabel = new JLabel("Weight :");
        heightLabel = new JLabel("Height :");
        birthDateLabel = new JLabel("Date of Birth (dd-mm-yyyy) :");
        genderLabel = new JLabel("Gender :");

        // Creating nessessary JTextField for each Labels.
        nameField = new JTextField(15);
        weightField = new JTextField(15);
        heightField = new JTextField(15);
        bodField = new JTextField(15);

        // Creating ButtonGroup and two RadioButton labeled "Male" and "Female".
        genderBGroup = new ButtonGroup();
        maleRButton = new JRadioButton("Male");
        femaleRButton = new JRadioButton("Female");

        // Add both radio buttons to the genderBGroup.
        genderBGroup.add(maleRButton);
        genderBGroup.add(femaleRButton);
        
        // Creating rButtonPanel for the radio buttons.
        rButtonPanel = new JPanel(new FlowLayout(0, 10, 0));

        // Add both radio button to the rButtonPanel.
        rButtonPanel.add(maleRButton);
        rButtonPanel.add(femaleRButton);

        // Creating formPanel for all of the labels, text fields, and radio buttons.
        formPanel = new JPanel(new GridLayout(6, 2, 15 ,5)); // 15 - 5

        // Add empty border to formPanel.
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10)); // -30 to 0

        // Add each components into formPanel.
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(weightLabel);
        formPanel.add(weightField);
        formPanel.add(heightLabel);
        formPanel.add(heightField);
        formPanel.add(birthDateLabel);
        formPanel.add(bodField);
        formPanel.add(genderLabel);
        formPanel.add(rButtonPanel);

        // Add formPanel to the north panel of mainPanel.
        mainPanel.add(formPanel, BorderLayout.NORTH);
    }
}
    
