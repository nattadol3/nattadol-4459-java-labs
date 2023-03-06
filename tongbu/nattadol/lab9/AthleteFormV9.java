/**
 * This AthleteFormV9 program is the subclass of AthleteFormV8.  This version added listener to all text fields, combobox,
 * checkboxes, radio buttons, and add shortcut ana mnemonic keys to menu itme in fileMenu.
 * 
 * When user pressed Enter in any text field.  It'll display the following message:
 * "<TextField_Name> is changeed to <TextField_Text>"  
 * 
 * When user selected any nationality in the combo box.  It'll display the following message:
 * "Nationality is changed to <Selected_Nationality]"
 * 
 * When user selected any gender in gender radio buttons.  It'll display the following message:
 * "<Selected_Gender> is selected"
 * 
 * When user selected any hobbies in hobbies checkboxes.  It'll display the following message:
 * "<Selected_Hobbies> is also your hobby"
 * 
 * when any hobbies is deselected.  It'll display the following message:
 * "<Deselected_Hobbies> is no longer your hobby."
 * 
 * When user choose any menu in file menu.  It'll display the following message:
 * "You clicked menu <Menu_Item_Name>"
 * 
 * The shortcut for New, Open, Save, and Exit menu is ctrl + n, ctrl + O, crtl + S,
 * and ctrl + Q respectively.
 * 
 * The mnemonic keys for New, Open, Save, and Exit menu is n, o, s, and x respectively.
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

public class AthleteFormV9 extends AthleteFormV8 {

    // Creating List and ArrayList that contain all hobbies checkboxes.
    protected ArrayList<JCheckBox> checkBoxesArrayList;
    protected java.util.List<JCheckBox> checkBoxesList;

    // ItemListener for gender radio buttons and hobbies checkboxes.
    protected ItemListener rButtonListener, checkboxesListener;

    // String array for changing text fields name.
    protected String[] tfNames = { "Name", "Weight", "Height", "Date of Birth" };

    // AthleteFormV9 class constructor.
    public AthleteFormV9(String title) {
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
        AthleteFormV9 msw = new AthleteFormV9("Athlete Form V9");
        msw.addComponents();
        msw.initValues();
        msw.addMenus();
        msw.addListener();
        msw.setAcceleratorKeys();
        msw.setMnemonicKeys();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {
        super.addComponents();

        // Adding hobbies checkboxes to checkBoxesList.  Then add it to checkBoxesArrayList.
        checkBoxesList = Arrays.asList(readingCheckBox, gardeningCheckBox,
                watchMoviesCheckBox, shoppingCheckBox, othersCheckBox);

        checkBoxesArrayList = new ArrayList<JCheckBox>(checkBoxesList);
    }

    @Override
    public void addListener() {
        super.addListener();

        // Added listener to the required components.
        nationBox.addActionListener(this);

        addTextFieldsListener();

        addRButtonsListener();

        addCheckboxesListener();

        newItem.addActionListener(this);
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        super.actionPerformed(event);

        Object src0bject = event.getSource();

        // Check if the action is perform on any text fields.
        for (JTextField tf : textFieldsArrayList) {
            if (src0bject == tf) {
                // The pop up message that will show up if user press enter in any text field.
                JOptionPane.showMessageDialog(null, tf.getName() + " is change to " + tf.getText());
            }
        }

        // Check if the action is perform on the combo box.
        if (src0bject == nationBox) {
            if (nationBox.getSelectedIndex() == -1) {
                // Do nothing if nothing is selected in the nationBox.
            } else {
                // The message that will show up if any of the nationlity in the combo box is selected
                JOptionPane.showMessageDialog(null, "Nationality is changed to " +
                        nationBox.getSelectedItem().toString());
            }

        // check if the action is perform on the menu items.
        } else if (src0bject == newItem) {
            // The message that will show up if user click on the new menu item.
            JOptionPane.showMessageDialog(null, "You click menu New");
        } else if (src0bject == openItem) {
            // The message that will show up if user click on the open menu item.
            JOptionPane.showMessageDialog(null, "You click menu Open");
        } else if (src0bject == saveItem) {
            // The message that will show up if user click on the menu menu item. 
            JOptionPane.showMessageDialog(null, "You click menu Save");
        } else if (src0bject == exitItem) {
            // If user click the exit menu item.  The program is closed.
            System.exit(0);
        }
    }

    protected void setTFsNames() {
        // Change the text fields name.
        nameField.setName("Name");
        weightField.setName("Weight");
        heightField.setName("Height");
        bodField.setName("Date of Birth");
    }

    protected void addTextFieldsListener() {
        setTFsNames();

        // Add ActionListerner to all text fields.
        for (JTextField tf : textFieldsArrayList) {
            tf.addActionListener(this);
        }
    }

    protected void addRButtonsListener() {
        // Create ItemListener for radiobuttons
        rButtonListener = new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                JRadioButton rb = (JRadioButton) e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // The message that will show if any radio button is selected.
                    JOptionPane.showMessageDialog(null, rb.getActionCommand()
                            + " is selected");
                }
            }
        };

        // Add ItemListener to both male and female Radio button.
        maleRButton.addItemListener(rButtonListener);
        femaleRButton.addItemListener(rButtonListener);
    }

    protected void addCheckboxesListener() {
        // Creating ItemListener for hobbies checkboxes.
        checkboxesListener = new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox cb = (JCheckBox) e.getItem();
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // The message that show if any checkboxes is selected.
                    JOptionPane.showMessageDialog(null, cb.getActionCommand()
                            + " is also your hobby");
                } else if (gotResetOrCancel == true) {
                    // Do nothing if the action is perfrom by the cancel or reset button.
                } else {
                    // The message that show if any checkboxes is deselected.
                    JOptionPane.showMessageDialog(null, cb.getActionCommand()
                            + " is no longer your hobby");
                }
            }
        };

        // Add checkboxesListener to all hobbies checkboxes.
        for (JCheckBox cb : checkBoxesArrayList) {
            cb.addItemListener(checkboxesListener);
            cb.setFocusable(false);
        }
    }

    protected void setAcceleratorKeys() {
        // Set the short cut keys for the menus in fileMenu.
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
    }

    protected void setMnemonicKeys() {
        // Set the mnemonic keys for the menus in fileMenu.
        newItem.setMnemonic(KeyEvent.VK_N);
        openItem.setMnemonic(KeyEvent.VK_O);
        saveItem.setMnemonic(KeyEvent.VK_S);
        exitItem.setMnemonic(KeyEvent.VK_X);
    }
}