/**
 * This AthleteFormV14 program is the subclass of AthleteFormV13 class.  This version add the function to save the hobbies
 * that user selected to a text file and the function to open it.  When user select the menu "Save", the program will show the 
 * save window for user to select where will the file be saved.  
 * 
 * When press "save" in the save window, if only 1 hobby is selected.  It'll display
 * "Saving hobby in file <File_Path>"
 * 
 * if more than 1 hobby is selected.  It'll display the message
 * "Saving hobbies in file <File_Path>"
 * to show where the file is saved.
 * 
 * When user select the "Open" menu.  It'll show the open window for user to selected the hobbies file to open.  
 * When user select the file and press "open".
 * 
 * If there is only 1 hobby in the file.  It'll set the bioTextArea text to:
 * "<Athlete_Name> has a hobby as <Hobby>"
 * if there're more than 1 hobby in the file.  It'll set the bioTextArea text to:
 * "<Athlete_Name> has a hobbies as <Hobbies>"
 * 
 * The file content consist of the athlete's name in the first line and the hobbies selected in the second line.
 * 
 * Author: Nattadol Thongbu
 * Date: 24/3/2023
 * ID: 653040445-9
 * Sec: 2
 */

package tongbu.nattadol.lab11;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import tongbu.nattadol.lab10.AthleteFormV13;

public class AthleteFormV14 extends AthleteFormV13 {

    // String value of the selected hobbies store in list.
    protected ArrayList<String> hobbiesSelected;

    // Declaring buffered writer/reader.
    protected BufferedWriter bw;
    protected BufferedReader br;

    // Declaring FileReader and FIleWriter.
    protected FileReader fileReader;
    protected FileWriter fileWriter;

    // Declaring variable from File class.
    protected File file;

    // Declaring fileChooser.
    protected JFileChooser fileChooser;

    // String value to store the info when the file is read.
    protected String athName, hobbies, hobbiesFileContent, path;

    // AthleteFormV14 class constructor.
    public AthleteFormV14(String title) {
        super(title);

        // Creating hobbies list and fileChooser.
        hobbiesSelected = new ArrayList<>();
        fileChooser = new JFileChooser();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() {
        AthleteFormV14 msw = new AthleteFormV14("Athlete Form V14");
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

        // Check the source of action and handle it accordingly.
        if (src0bject == saveItem) {
            handleSaveMI();
        } else if (src0bject == openItem) {

            // Clear the file content and clear the text area text first.
            // Then set the bioTextArea text to show the selected file content.
            bioTextArea.setText("");
            bioTextArea.setText(handleOpenMI());
            clearFileContent();
        } else {
            super.actionPerformed(event);
        }
    }

    // Method to handle the action performed on "Open" menu.
    // This method return hobbiesFileContent which contain the content
    // of the selected file.
    public String handleOpenMI() {

        // Show the file chooser window for opening file.
        int response = fileChooser.showOpenDialog(null);
        file = fileChooser.getSelectedFile();

        /**
         * Check if user selected "Open" in the file chooser menu.
         * if yes and the file doesn't end with .txt, add .txt suffix to it.
         * Then get the file path and store it in the path string.
         */
        if (response == JFileChooser.APPROVE_OPTION) {
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            path = file.getAbsolutePath();
        }

        // Read the file using FileReader and BufferedReader.
        try {

            // Creating FileReader object using the file path, then
            fileReader = new FileReader(path);

            // Creating BufferedReader object using fileReader created.
            br = new BufferedReader(fileReader);

            // Read the athlete name and hobbies from the file.
            athName = br.readLine();
            hobbies = br.readLine();

            // Close the fileReader and BufferedReader.
            fileReader.close();
            br.close();
        } catch (IOException e) {

            // Error message in case of if an error happened.
            JOptionPane.showMessageDialog(null, "An error has occured");
            e.printStackTrace(System.err);
        }

        // Check how many hobbies is selected *. Then add it to the hobbiesFileContent
        // String.
        // * The longest hobby string is "Watching movies" which is 15 in length so, if
        // the hobbies String
        // has the length of less than or eqult to 15. That there's only 1 hobby saved
        // in the file.
        if (hobbies == null) {

            // If there are no hobby selected. The message say the athlete have no hobbies.
            hobbiesFileContent = athName + " does not have any hobby";
        } else if (hobbies.length() <= 15) {

            // If more than one hobbies is selected. The message use "hobbies".
            hobbiesFileContent = athName + " has hobbies as " + hobbies;
        } else if (hobbies.length() > 15) {

            // If only one hobby is selected. The message use "hobby".
            hobbiesFileContent = athName + " has a hobby as " + hobbies;
        } else {

            // If failed to read file. hobbiesFileContent will equal to null.
            // Then show the error message.
            hobbiesFileContent = "An error has occurred";
        }

        // Return the hobbiesFileContent.
        return hobbiesFileContent;
    }

    // Method to handle the action performed on "Save" menu.
    public void handleSaveMI() {

        // Show the file chooser window for saving file.
        int response = fileChooser.showSaveDialog(null);
        file = fileChooser.getSelectedFile();

        /**
         * Check if user selected "Save" in the file chooser menu.
         * if yes and the file doesn't end with .txt, add .txt suffix to it.
         * Then save the file in the selected path.
         */
        if (response == JFileChooser.APPROVE_OPTION) {
            if (!file.getName().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            writeHobbyFile();
        }
    }

    // Method for saving the hobby file.
    public void writeHobbyFile() {
        try {

            // Creating FileWriter object using file object from File class.
            fileWriter = new FileWriter(file);

            // Creating BufferedWrite object using fileWriter created.
            bw = new BufferedWriter(fileWriter);

            // Get the athlete name from the nameField.
            String athleteName = nameField.getText();

            // Check for the selected hobbies, then store it the hobbiesSelected list.
            for (JCheckBox cb : checkBoxesArrayList) {
                if (cb.isSelected()) {
                    hobbiesSelected.add(cb.getActionCommand());
                }
            }

            // Check for the number of hobbies that are selected.
            if (hobbiesSelected.size() == 0) {

                // If no hobby is seleceted. Run the code below.
                // Create the file. Write only the athlete's name in the file.
                bw.write(athleteName);

                // Flush fileWriter and bw (BufferedWriter.
                fileWriter.flush();
                bw.flush();

                // close bw (BufferedWriter).
                fileWriter.close();
                bw.close();

                // Get the file path.
                path = file.getAbsolutePath();

                // Message telling user where the file is save.
                JOptionPane.showMessageDialog(null, "Saving hobby in file " + path);
            } else if (hobbiesSelected.size() == 1) {

                // If only 1 hobby is selected. Run the code below.
                // Get the hobby from the list.
                String hobby = hobbiesSelected.get(0);

                // Create the file. Write the athlete's name on the first line and
                // write the athlete's hobby in the second line.
                bw.write(athleteName + "\n" + hobby);

                // Flush fileWriter and bw (BufferedWriter.
                fileWriter.flush();
                bw.flush();

                // close bw (BufferedWriter).
                fileWriter.close();
                bw.close();

                // Get the file path.
                path = file.getAbsolutePath();

                // Message telling user where the file is save.
                JOptionPane.showMessageDialog(null, "Saving hobby in file " + path);
            } else {

                // If more than 1 hobbies is selected. Run the code below.
                // Creating an empty String to store the hobbies.
                String hobbies = "";

                // Add the hobby string from the list to the hobbies string.
                // Each hobby is seperated with ", ".
                for (String hbs : hobbiesSelected) {
                    hobbies += hbs + ", ";
                }

                // Delete the ", " at the end of the hobbies String.
                if (!hobbies.isEmpty()) {
                    hobbies = hobbies.substring(0, hobbies.length() - 2);
                }

                // Create a file. Write the athlete's name on the first line and
                // write the athlete's hobbies on the second line.
                bw.write(athleteName + "\n" + hobbies);

                // Flush fileWriter and bw (BufferedWriter).
                fileWriter.flush();
                bw.flush();

                // close fileWriter and bw (BufferedWriter).
                fileWriter.close();
                bw.close();

                // Get the file path.
                path = file.getAbsolutePath();

                // Message telling user where the file is save.
                JOptionPane.showMessageDialog(null, "Saving hobbies in file " + path);
            }

            // Clear the hobbiesSelected list.
            hobbiesSelected.clear();
        } catch (IOException e) {

            // Error message in case of if an error happened.
            JOptionPane.showMessageDialog(null, "An error has occured");
            e.printStackTrace(System.err);
        }
    }

    // Method for clearing the file content.
    public void clearFileContent() {
        hobbiesFileContent = null;
    }
}
