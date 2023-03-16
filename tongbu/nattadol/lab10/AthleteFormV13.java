/**
 * This AthleteFormV13 program is the subclass of AthleteFormV12.  This version added the functionality to check that
 * if the weight or heigth in the weight or height text field is not a number.  It'll display the message:
 * "Please enter the valid number for <TextField_Name>"
 * 
 * If the weight or heigth in the weight or height text field is more than or equal to the predetermined max value.  
 * It'll display the message:
 * "<TextField_Name> should be less than <Max_Value>"
 * 
 * If the weight or heigth in the weight or height text field is more than or equal to 0.  
 * It'll display the message:
 * "<TextField_Name> should be greater than 0"
 * 
 * The predetermined value range for weight is (0, 200) and for height is (0, 300)
 */

package tongbu.nattadol.lab10;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class AthleteFormV13 extends AthleteFormV12 {

    // Declaring boolean value used for checking the validity of height and weight.
    // Set the value to false so it'll always check for the first time.
    protected boolean heightAndWeightIsValid = false;

    // Declaring max weight and max height.
    protected final double MAX_WEIGHT = 200;
    protected final double MAX_HEIGHT = 300;

    // Declaring weight and height value. Used for checking the validity.
    protected double weight, height;

    // AthleteFormV13 class constructor.
    public AthleteFormV13(String title) {
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
        AthleteFormV13 msw = new AthleteFormV13("Athlete Form V13");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object src0bject = event.getSource();

        // Check if the heightAndWeightIsValid is false. 
        // If yes, check the validity of the numbers.
        if (heightAndWeightIsValid == false) {
            if (src0bject == weightField) {

                // Check the validity of the weight enter.
                weight = checkValidNumber(weightField, "Weight", MAX_WEIGHT);

                // If the weight is not valid.  return so the program won't execute the next lines of code.
                if (weight == -1) {
                    
                    // Set the heightAndWeightIsValid to false so the program will check the validity
                    // of the number for the next time.
                    heightAndWeightIsValid = false;
                    return;
                }
            } else if (src0bject == heightField) {

                // Check the validity of the height enter.
                height = checkValidNumber(heightField, "Height", MAX_HEIGHT);

                // If the height is not valid.  return so the program won't execute the next lines of code.
                if (height == -1) {

                    // Set the heightAndWeightIsValid to false so the program will check the validity
                    // of the number for the next time.
                    heightAndWeightIsValid = false;
                    return;
                }
            }
        }

        super.actionPerformed(event);
    }

    @Override
    public void handleAddMI() {

        // Check if the heightAndWeightIsValid is false. 
        // If yes, check the validity of the numbers.
        if (heightAndWeightIsValid == false) {

            // Check the validity of weight added.
            weight = checkValidNumber(weightField, "Weight", MAX_WEIGHT);

            // If the weight added is not valid.  return so the program won't execute the next line of codes.
            if (weight == -1) {

                // Set the heightAndWeightIsValid to false so the program will check the validity
                // of number for the next time.
                heightAndWeightIsValid = false;
                return;
            }

            // Check the validity of height added.
            height = checkValidNumber(heightField, "Height", MAX_HEIGHT);

            // If the height added is not valid.  return so the program won't execute the next line of codes.
            if (height == -1) {

                // Set the heightAndWeightIsValid to false so the program will check the validity
                // of number for the next time.
                heightAndWeightIsValid = false;
                return;
            }
        }

        super.handleAddMI();

    }

    public double checkValidNumber(JTextField tf, String tfName, double maxValue) {
        
        // Defalue value to return.
        double tfValue = 0;

        // Use try catch to catch to catch the exception in case of the text in the weight and heigth text fields
        // is not a number.
        try {
            tfValue = Double.parseDouble(tf.getText());
        } catch (NumberFormatException e) {

            // Message in case if the program catch the exception.
            JOptionPane.showMessageDialog(null, "Please enter a valid number for " + tfName);

            // Change tfValue to -1 to represent that the number is not valid, then return it.
            tfValue = -1;
            return tfValue;
        }

        // Check if the number value is more than or equal to the max value or less than or equal to 0.
        if (tfValue > maxValue) {

            // Pop up message in case of if the tfValue is more than or equal to maxValue.
            JOptionPane.showMessageDialog(null, tfName + " should be less than " + maxValue);

            // Change tfValue to -1 to represent that the number is not valid, then return it.
            tfValue = -1;
        } else if (tfValue <= 0) {

            // Pop up message in case of if the tfValue is less than or equal to 0.
            JOptionPane.showMessageDialog(null, tfName + " should be greater than 0");

            // Change tfValue to -1 to represent that the number is not valid, then return it.
            tfValue = -1;
        }

        return tfValue;
    }
}
