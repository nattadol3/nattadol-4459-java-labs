/**
 * This AhtleteFormV15 program is the subclass of AthleteFormV14 class.  This version add the funtion to save the
 * years of experience to a binary file and the funtion to open it.  When user select "Save" menu and save the hobbies file. 
 * Another save window will pop up, then user can select where the file is going to be saved.  
 * 
 * When press "save" in the save window.
 * It'll display the message:
 * "Saving experinces year in file <File_Path>"
 * to show where the file is saved.
 * 
 * When user select "Open" menu.  After user selected the hobbies file to open.  Another open window will appear.
 * Then user can select the year of experience file to open.  When user select the file and press "open".
 * It'll set the bio text area message to:
 * "<Athlete_Name> has a hobby/hobbies as <Hobbies>]
 * <Athlete_Name> has <experience_years> years of experiences"
 * 
 * the file content consist of the athlete's years of experince and athlete's name.
 * 
 * Author: Nattadol Thongbu
 * Date: 24/3/2023
 * ID: 653040445-9
 * Sec: 2
 */

package tongbu.nattadol.lab11;

import java.io.*;
import javax.swing.*;

public class AthleteFormV15 extends AthleteFormV14 {

    // Declaring file/data output/input stream.
    protected FileOutputStream fileOS;
    protected DataOutputStream dataOS;
    protected FileInputStream fileIS;
    protected DataInputStream dataIS;

    // Int variable to store the value of the year of experience slider.
    protected int expYears;

    // String variable to store the file content when read.
    protected String expYearsFileContent;

    // Boolean variable to check if the file content is all read.
    protected boolean isReadingFinished = false;

    // AthleteFormV15 class constructor.
    public AthleteFormV15(String title) {
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
        AthleteFormV15 msw = new AthleteFormV15("Athlete Form V15");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    // Override the handleSaveMI() from AthleteFormV14.
    @Override
    public void handleSaveMI() {
        super.handleSaveMI();

        // Show the file chooser window for saving file.
        int response = fileChooser.showSaveDialog(null);
        file = fileChooser.getSelectedFile();

        // Check if user selected "Save" in the file chooser menu.
        // If yes, save the file in the selected path.
        if (response == JFileChooser.APPROVE_OPTION) {
            writeExpYearsFile();
        }
    }

    // Override handleOpenMI() form AthleteFormV14.
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

        // Read the file using FileInputStream and DataInputStream.
        try {

            // Creating FileInputStream object using file.
            fileIS = new FileInputStream(file);

            // Creatung FileInputStream object using fileIS created.
            dataIS = new DataInputStream(fileIS);

            // Read the file while there're content in it.
            try {
                while (!isReadingFinished) {

                    // Read the athlete name and year of experience.
                    athName = dataIS.readUTF();
                    expYears = dataIS.readInt();

                    // Save the content read into the expYearsFileContent String.
                    expYearsFileContent = athName + " has " + expYears + " years of experiennes";
                }
            } catch (EOFException e) {

                // If there are no more content in the file, set the isReadingFinised to false
                // so it'll stop reading the file.
                // Then close fileIS and dataIS.
                isReadingFinished = false;
                fileIS.close();
                dataIS.close();
            }
        } catch (IOException e) {

            // Error message in case of if an error happened.
            JOptionPane.showMessageDialog(null, "An error has occurred");
            e.printStackTrace(System.err);
        }

        // If failed to read file. expYearsFileContent will equal to null.
        // Then set expYearsFileContent to show the error message.
        if (expYearsFileContent == null) {
            expYearsFileContent = "An error has occurred";
        }

        // Return the contents.
        return hobbiesFileContent + "\n" + expYearsFileContent;
    }

    // Method for saving the years of experience file.
    public void writeExpYearsFile() {
        try {

            // Creating FileOutputStream object using file object from file class.
            fileOS = new FileOutputStream(file);

            // Creating DataOutputStream object using fileOS created.
            dataOS = new DataOutputStream(fileOS);

            // Get the athlete name form the nameField.
            String name = nameField.getText();

            // Write the ahtlete name follow by years of experience into the file.
            dataOS.writeUTF(name);
            dataOS.writeInt(experienceSlider.getValue());

            // Flush the fileOS and dataOS.
            fileOS.flush();
            dataOS.flush();

            // Close the fileOS and dataOS.
            fileOS.close();
            dataOS.close();

            // Get the file path and store it in path String.
            path = file.getAbsolutePath();

            // Message telling user where the file is saved
            JOptionPane.showMessageDialog(null, "Saving experiences year in file " + path);
        } catch (IOException e) {

            // Error message in case of if an error happened.
            JOptionPane.showMessageDialog(null, "An error has occurred");
            e.printStackTrace(System.err);
        }
    }

    // Override the clearFileContent() from AthleteFormV14.
    @Override
    public void clearFileContent() {
        super.clearFileContent();

        // set the expYearsFileContent to null.
        expYearsFileContent = null;
    }

}
