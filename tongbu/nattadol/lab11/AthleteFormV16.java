/**
 * This AthleteFormV16 program is the subclass of AthleteFormV15.  This version add the funtion to save the athlete info
 * using AthleteV2 class to a binary file and the funtion to open it.  By creating the object from AthleteV2 using the info from the form.
 * When user select "Save" menu and finish saving hobbies and years of experience file.  Another save window will appear,
 * then user can select where the file is going to be saved.  When press "save" in the save window, 
 * 
 * it'll display the message
 * "Athlete [<Name>, <Weight>, <Height>, <Gender>, <Nationality>, <Date_of_Birth>]"
 * first to show the info of the athlete that is being saved. 
 * 
 * Then it'll display:
 * "Saving the athlete in file <File_Path>"
 * to show where the file is saved.
 * 
 * When user select "Open" menu.  After user selected the hobbies and experiences file to open.  
 * Another open window will appear.
 * Then user can select the athlete file to open.  When user select the file and press "open".
 * It'll set the bioTextArea text to:
 * "<Athlete_Name> has a hobby/hobbies as <Hobbies>]
 * <Athlete_Name> has <experience_years> years of experiences
 * Athlete [<Name>, <Weight>, <Height>, <Gender>, <Nationality>, <Date_of_Birth>]"
 * 
 * The file content will consist of all the attributes of AthleteV2 that is used to created the object.
 * 
 * Author: Nattadol Thongbu
 * Date: 24/3/2023
 * ID: 653040445-9
 * Sec: 2
 */

package tongbu.nattadol.lab11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;
import tongbu.nattadol.lab5.Athlete.Gender;
import tongbu.nattadol.lab6.AthleteV2;

public class AthleteFormV16 extends AthleteFormV15 {

    // Declaring Object Output/Input Stream.
    protected ObjectOutputStream objectOS;
    protected ObjectInputStream objectIS;

    // String variavle to store the file content when read.
    protected String athFileContent;

    // AthleteFormV16 class constructor.
    public AthleteFormV16(String title) {
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
        AthleteFormV16 msw = new AthleteFormV16("Athlete Form V16");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    // Override handleSaveMI() form AthleteFormV15
    @Override
    public void handleSaveMI() {
        super.handleSaveMI();

        // Show the file chooser window for saving file.
        int response = fileChooser.showSaveDialog(null);
        file = fileChooser.getSelectedFile();

        // Check if user selected "Save" in the file chooser menu.
        // If yes, save the file in the selected path.
        if (response == JFileChooser.APPROVE_OPTION) {
            writeAthleteFile();
        }
    }

    // Override handleOpenMI() from AthleteFormV15.
    @Override
    public String handleOpenMI() {
        super.handleOpenMI();

        // Show the file chooser window for opening file.
        int response = fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();

        // Check if user seleted "Open" in the file chooser menu.
        // If yes, get the file path and store it in the path string.
        if (response == JFileChooser.APPROVE_OPTION) {
            path = file.getAbsolutePath();
        }

        // Read the file using FileInputStream and ObjectInputStream.
        try {

            // Creating FileInputStream object using file object.
            fileIS = new FileInputStream(file);

            // Creating ObjectInputStream object using fileIS created.
            objectIS = new ObjectInputStream(fileIS);

            // Read the object from the file.
            AthleteV2 athlete = (AthleteV2) objectIS.readObject();

            // Convert the object read from file to String using toString()
            // Then store it in athFileContent.
            athFileContent = athlete.toString();

            // Close the fileIS and objectIS.
            fileIS.close();
            objectIS.close();
        } catch (IOException e) {

            // Error message in case of if an IOException happened.
            JOptionPane.showMessageDialog(null, "An error has occurred");
            e.printStackTrace(System.err);
        } catch (ClassNotFoundException e) {

            // Error message in case of if an ClassNotFoundException happened.
            JOptionPane.showMessageDialog(null, "An error has occurred");
            e.printStackTrace(System.err);
        }

        // If failed to read file. athFileContent will equal to null.
        // Then set athFileContent to show the error message.
        if (athFileContent == null) {
            athFileContent = "An error has occurred";
        }

        // Return the file content.
        return hobbiesFileContent + "\n" + expYearsFileContent + "\n" + athFileContent;
    }

    // Method for saving the athlete object file.
    public void writeAthleteFile() {
        try {

            // Creating FileOutputStream object using file object from file class.
            fileOS = new FileOutputStream(file);

            // Creating ObjectOutputStream object using fileOS created.
            objectOS = new ObjectOutputStream(fileOS);

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

            // Saving athlete object.
            objectOS.writeObject(athlete);

            // Flush the fileOS and objectOS.
            fileOS.flush();
            objectOS.flush();

            // Close the fileOS and objectOS.
            fileOS.close();
            objectOS.close();

            // Get the file path.
            path = file.getAbsolutePath();

            // Message to show the info of the athlete object that is saved.
            JOptionPane.showMessageDialog(null, athlete.toString());

            // Message telling user where the file is saved.
            JOptionPane.showMessageDialog(null, "Saving the athlete in the file " + path);

        } catch (IOException e) {

            // Error message in case of if an error happened.
            JOptionPane.showMessageDialog(null, "An error has occurred");
            e.printStackTrace(System.err);
        }
    }

    // Override clearFileContent() from AthleteFormV15.
    @Override
    public void clearFileContent() {
        super.clearFileContent();

        // Set the athFileContent to null.
        athFileContent = null;
    }
}