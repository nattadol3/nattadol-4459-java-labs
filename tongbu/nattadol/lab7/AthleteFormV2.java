/**
 * This AthleteFormV2 program is the subclass to AthleteForm class.  It add three new label which is nationality, sport, and, bio.
 * It add a combobox for choosing nationality, JList for choosing sport, and text area to enter bio.
 * 
 * Author: Nattadol Thongbu
 * Date: 2/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab7;

import javax.swing.*;
import java.awt.*;

public class AthleteFormV2 extends AthleteForm {

    // Creating nessessary component, containers, and array.
    protected JPanel centerPanel, bioPanel, sportsPanel;
    protected JLabel nationnalityLabel, sportLabel, bioLabel;
    protected JComboBox<String> nationBox;
    protected JList<String> sportJList;
    protected JTextArea bioTextArea;
    protected JScrollPane bioTextScrollPane;
    protected String[] sportsList = {"Badminton", "Boxing", "Football", "Running"};

    // AthleteFormV2 class constructor.
    public AthleteFormV2(String title) {

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
        AthleteFormV2 msw = 
            new AthleteFormV2("Athlete Form V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public void addComponents() {

        // Call the super class addComponent().
        super.addComponents();

        // Set layout for formPanel to GridLayout.
        formPanel.setLayout(new GridLayout(7, 2, 15, 15));

        // Creating nessessary labels.
        nationnalityLabel = new JLabel("Nationality : ");
        sportLabel = new JLabel("Sport : ");
        bioLabel = new JLabel("Bio : ");

        // Creating combobox.
        nationBox = new JComboBox<>();

        // Add items to nationBox.
        nationBox.addItem("Thai");
        nationBox.addItem("American");
        nationBox.addItem("Chinese");
        nationBox.addItem("Indonesian");
        nationBox.addItem("japanese");
        nationBox.addItem("Vietnamese");

        // Set "Thai" to be the default selected object.
        nationBox.setSelectedItem("Thai");

        // Creating centerPanel which has GridLayout.
        centerPanel = new JPanel(new GridLayout(2, 1, 15, 15));

        // Add empty border to centerPanel.
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Creating bioPanel which has BorderLayout.
        bioPanel = new JPanel(new BorderLayout());

        // Creating sportsPanel which has GridLayout.
        sportsPanel = new JPanel(new GridLayout(1, 2, 15, 15));

        // Creating JList and add the sportsList String arrays to the list.
        sportJList = new JList<>(sportsList);

        // Set the default selected item to be the item in the index 2.
        sportJList.setSelectedIndex(2);

        // Add sportLabel and sportJList to sportsPanel.
        sportsPanel.add(sportLabel);
        sportsPanel.add(sportJList);

        // Creating TextArea for bio.
        bioTextArea = new JTextArea();

        // Set that if the sentences is longer than the text area.  The text is automatically put on the new line.
        bioTextArea.setLineWrap(true);
        bioTextArea.setWrapStyleWord(true);

        // Creating scroll pane and add bioTextArea into it.
        bioTextScrollPane = new JScrollPane(bioTextArea);

        // Add bioLabel to the north panel and bioTextScrollPane panel to the center of bioPanel.
        bioPanel.add(bioLabel, BorderLayout.NORTH);
        bioPanel.add(bioTextScrollPane, BorderLayout.CENTER);

        // Add sportsPanel and bioPanel into centerPanel.
        centerPanel.add(sportsPanel);
        centerPanel.add(bioPanel);

        // Add nationalityLabel and nationBox to formPanel.
        formPanel.add(nationnalityLabel);
        formPanel.add(nationBox);
        
        // Add formPanel to the north panel of mainPanel.
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
    }
    
}
