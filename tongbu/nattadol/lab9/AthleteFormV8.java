/**
 * This AthleteFormV8 program is the subclass of AthleteFormV6 class.  This version
 * of the AtheleteForm implements ActionListener and add it to the cancel, reset, and submit button.
 * 
 * When cancel button is pressed.  It's clear all the text fields text and change it background color back to kkucolor (167,59,36).
 * Clear all selection from Gender Radio buttons and set the year of experience slider value to 0.
 * 
 * When reset button is pressed.  All texts in text fields is clear, text fields background is changed to white, Gender selection is cleard,
 * Hobbies selections is cleared, nationality selection is cleared, sport selection is cleared, text in bioTextArea is cleard, 
 * and year of experience slider value is set to 0.
 * 
 * When submit button is pressed.  It'll get all of the information that user fill in and select.  Then it'll display it in the
 * text area in the following format:
 * 
 * "
 * Name: <nameField_input_text>
 * Weight: <weightField_input_text>
 * Height: <heightField_input_text>
 * Date of Birth: <bodField_input_text>
 * Gender: <genderBGroup_Selection>
 * Hobbies: <hobbies_Checkboxes_selection>
 * Nationality: <nationBox_selection>
 * Sports: [<sportJList_selection>]
 * Experience years: <experienceSlider_value>
 * "
 * 
 * If all the fields is not filled or selected.  It'll display:
 * 
 * "Error: All fields need to be filled and selected."
 * 
 * in the bioTextArea instead.
 * 
 * Author: Nattadol Thongbu
 * Date: 3/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab9;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import tongbu.nattadol.lab8.AthleteFormV6;

public class AthleteFormV8 extends AthleteFormV6 implements ActionListener {

    // Create an ArrayList and List for text fields.
    protected ArrayList<JTextField> textFieldsArrayList;
    protected List<JTextField> textFieldsList;

    // Boolean value to check if the form value is change by the cancle or reset button.
    protected boolean gotResetOrCancel = false;

    // List for containing selected sports from sportJList.
    // This is for future version of AtheletForm
    protected List<String> selectedSportsList;

    // String variables to contains the value of all information in the submitted form.
    protected String submittedName, submittedWeight, submittedHeight,
            submittedDoB, submittedGender,
            submittedHobbies, submittedNationality,
            submittedSport, submittedExpYears;

    // Text that will be shown in the bioTextArea.
    protected String resultText;

    // AthleteFormV8 class constructor
    public AthleteFormV8(String title) {
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
        AthleteFormV8 msw = new AthleteFormV8("Athlete Form V8");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {
        super.addComponents();

        // Adding value to textFields List and textFieldArrayList
        textFieldsList = Arrays.asList(nameField, weightField,
                heightField, bodField);

        textFieldsArrayList = new ArrayList<JTextField>(textFieldsList);

        // Set the actioncommand for both gender radio buttons.
        femaleRButton.setActionCommand("Female");
        maleRButton.setActionCommand("Male");
    }

    public void initValues() {

        // Change text fields background.
        setTextFieldsColor(Color.PINK);

        // Set the inital value of the form.
        setInitFormValues();
    }

    public void addListener() {

        // Add listener to cancel, reset, and submit button.
        cancelButton.addActionListener(this);
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // Creating Object to check the source of action.
        Object src0bject = event.getSource();

        if (src0bject == submitButton) {
            // Method for handle the submit button pressed.
            handleSubmitButton();
        } else if (src0bject == cancelButton) {
            // Method for handle the cancel button pressed.
            handleCancelButton();
        } else if (src0bject == resetButton) {
            // Method for handle the reset button pressed.
            handleResetButton();
        }
    }

    protected void handleResetButton() {

        // Change the gotResetOrCancel to check that the reset button is pressed.
        gotResetOrCancel = true;

        // Clear the form value using clearForm method.
        clearForm();

        // Change text fields background to White
        setTextFieldsColor(Color.WHITE);

        // Change the gotResetOrCancel back to check that the action is done.
        gotResetOrCancel = false;
    }

    protected void handleCancelButton() {

        // Change the gotResetOrCancel to check that the cancel button is pressed.
        gotResetOrCancel = true;

        // Change some of the form value cancelFormValues method.
        cancelFormValues();

        // Set the text fields background color to kkuColor.
        setTextFieldsColor(kkuColor);

        // Change the gotResetOrCancel back to check that the action is done.
        gotResetOrCancel = false;
    }

    protected void handleSubmitButton() {
        try {
            // Set the bioTextArea text if all fields are fiiled and selected.
            bioTextArea.setText(getBioTextAreaValues());
        } catch (Exception e) {
            // If some of the fields aren't filled and selected. Set the bioTextArea
            // messages to an error message.
            bioTextArea.setText("Error: All fields need to be filled and selected.");
        }
    }

    // Method for changing text fields background.
    protected void setTextFieldsColor(Color color) {
        for (JTextField tf : textFieldsArrayList) {
            // Change text fields backgroun to the color that is passed into the method.
            tf.setBackground(color);
        }
    }

    // Method to set the initial form values.
    protected void setInitFormValues() {
        nameField.setText("Manee");
        weightField.setText("50");
        heightField.setText("170");
        bodField.setText("01/01/2000");

        femaleRButton.setSelected(true);

        experienceSlider.setValue(10);
    }

    protected String getBioTextAreaValues() {

        // Accept each summited values.
        submittedName = nameField.getText();
        submittedWeight = weightField.getText();
        submittedHeight = heightField.getText();
        submittedDoB = bodField.getText();

        submittedGender = genderBGroup.getSelection().getActionCommand();

        submittedNationality = (String) nationBox.getSelectedItem();

        submittedExpYears = Integer.toString(experienceSlider.getValue());

        // Set the result text value to the desired format and return it.
        resultText = "Name: " + submittedName + "\nWeight: " + submittedWeight + "\nHeight: " + submittedHeight
                + "\nDate of Birth: " + submittedDoB + "\nGender: " + submittedGender
                + "\nHobbies: " + getSelectedHobbiesCheckBoxes() + "\nNationality: " + submittedNationality
                + "\nSport: " + "[" + getSelectedSportsList() + "]" + "\nExperience years: " + submittedExpYears;

        return resultText;
    }

    protected String getSelectedSportsList() {

        // Add the selected sports into selectedSportsList.
        selectedSportsList = sportJList.getSelectedValuesList();
        submittedSport = "";

        // Add each selected sport to submitted sport String.
        // This version sportJList is on the single selection mode.  So the selectedSportsList
        // will only have one sport in it. It'll have more sports in it after we changed the sportJList selection mode to
        // multiple interval selection in the future version of AthleteForm.
        for (int i = 0; i < selectedSportsList.size(); i++) {
            submittedSport += selectedSportsList.get(i) + ", ";
        }

        // Delete the ", " at the end of the text in submittedSport.
        if (!submittedSport.isEmpty()) {
            submittedSport = submittedSport.substring(0, submittedSport.length() - 2);
        }

        return submittedSport;
    }

    protected String getSelectedHobbiesCheckBoxes() {
        submittedHobbies = "";

        // Check for the selected hobbies checkboxes and get the text to add to
        // submittedHobbies.
        for (Component c : hobbiesCheckBoxPanel.getComponents()) {
            if (c instanceof JCheckBox) {
                if (((JCheckBox) c).isSelected()) {
                    submittedHobbies += ((JCheckBox) c).getText() + ", ";
                }
            }
        }

        // Delete the ", " at the end of submittedHobbies text.
        if (!submittedHobbies.isEmpty()) {
            submittedHobbies = submittedHobbies.substring(0, submittedHobbies.length() - 2);
        }

        return submittedHobbies;
    }

    protected void cancelFormValues() {

        // Revert the form value back to the initial AthleteFormV6 state.
        // Clear all the text fields text.
        for (JTextField tf : textFieldsArrayList) {
            tf.setText("");
        }

        for (Component c : hobbiesCheckBoxPanel.getComponents()) {
            if (c instanceof JCheckBox) {

                // Clear selection of each selected hobbies checkboxes.
                ((JCheckBox) c).setSelected(false);
            }
        }

        // Check the watching movies checkbox
        watchMoviesCheckBox.setSelected(true);

        
        // Clear the selection in gender radio button.
        genderBGroup.clearSelection();

        // Clear the bioTextArea text.
        bioTextArea.setText("");

        // Set the nationality to Thai
        nationBox.setSelectedItem("Thai");

        // Set the sport selection to football.
        sportJList.setSelectedIndex(2);

        // Set the experienceSlider value to 0.
        experienceSlider.setValue(0);
    }

    protected void clearForm() {

        // Call the cancleFormValues method.
        cancelFormValues();

        // Clear all selections in nationality combobox
        nationBox.setSelectedItem(null);

        // Clear all selection in sport list.
        sportJList.clearSelection();

        for (Component c : hobbiesCheckBoxPanel.getComponents()) {
            if (c instanceof JCheckBox) {

                // Clear selection of each selected hobbies checkboxes.
                ((JCheckBox) c).setSelected(false);
            }
        }
    }
}