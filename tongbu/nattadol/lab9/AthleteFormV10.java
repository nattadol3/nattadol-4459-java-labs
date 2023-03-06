/**
 * This AthleteFormV10 is the subclass of AthleteFormV9.  This version add ListSelectionListener to sportJList 
 * and add ChangeListener to the experienceSlider.
 * 
 * The sportJList selection mode is multiple interval selection.  Any time any sports in the list in change.
 * The following message is display:
 * "Selected sports are <Selected_Sports_in_sportJList>"
 * 
 * When the experienceSlider value is change.  The folloing message is display:
 * "# of experience years is <experienceSlider_Current_value>"  
 * 
 * Author: Nattadol Thongbu
 * Date: 3/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab9;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AthleteFormV10 extends AthleteFormV9 {
    protected ListSelectionModel sportsListSelectionModel;
    protected ListSelectionListener sportsListSelectionListener;
    protected ChangeListener expSliderChangeListener;
    protected String selectedSports;

    // AthleteFormV10 class constructor.
    public AthleteFormV10(String title) {
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
        AthleteFormV10 msw = new AthleteFormV10("Athlete Form V10");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void addListener() {
        super.addListener();

        // Add listerner to sportJList and experienceSlider.
        addSportsJListListerner();
        addExpSliderListener();
    }

    protected void addSportsJListListerner() {
        // Get the sportJList selection mode.
        sportsListSelectionModel = sportJList.getSelectionModel();

        // Creating new ListSelecionListener for sportJList
        sportsListSelectionListener = new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                // Check if the change is done.
                if (!e.getValueIsAdjusting()) {
                    if (sportsListSelectionModel.isSelectionEmpty()) {
                        // If nothing is selected.  Do nothing.
                    } else {
                        // Creating String for containing selected sport names.
                        selectedSports = "Selected sports are";
                        
                        // Get the selected sports value and save it into selectedSportsList.
                        selectedSportsList = sportJList.getSelectedValuesList();

                        // Add selected sport value to the selectedSports String.
                        for (int i = 0; i < selectedSportsList.size(); i++) {
                            selectedSports += " " + selectedSportsList.get(i);
                        }
                        
                        // Display message if any sports in sportJList is selected or deselected.
                        JOptionPane.showMessageDialog(null, selectedSports);
                    }
                }
            }

        };

        // Add ListSelectionListener to sportJListSelectionModel.
        sportsListSelectionModel.addListSelectionListener(sportsListSelectionListener);
    }

    protected void addExpSliderListener() {
        // Creating new ChangeListener for experinenceSlider.
        expSliderChangeListener = new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                
                // Check if the change is done.
                if (!source.getValueIsAdjusting()) {
                    if (gotResetOrCancel == true) {
                        // If the action is performed by the reset or the cancel button.  Do nothing.
                    } else {
                        // The message that will diplat if the action is performed on the experienceSlider by user.
                        JOptionPane.showMessageDialog(null, "# of experience years is " +
                                source.getValue());
                    }
                }
            }
        };

        // Add expSliderChangeListener to experienceSlider.
        experienceSlider.addChangeListener(expSliderChangeListener);
    }
}
