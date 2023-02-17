/**
 * This AthleteFormV5 program is the subclass of AthleteFormV4 class.  This version change the font of all lables to Bold Serif size 14
 * change the cancel, reset, and submit button's font to Bold + Italic Serif size 16, change the color of all itmes in sportJList to Blue (R: 35, G: 45, B: 222),
 * change the color of bioTextArea to Grey (R: 200, G: 200, B: 200), and set the tooltip for cancel, reset, and submit button.  If user's mouse is hover over 
 * the cancel button, it'll show the tooltip "Press the cancel button to cancel this form".  If hover over the reset button, 
 * it'll show "Press the reset button to reset this form".  If hover over submit button, it'll show "Press the submit button to submit this form"
 * 
 * In the menu bar.  It change the font of all menus to Bold SanSerif size 14, change the color of all menus to
 * Dark blue (R: 6, G: 57, B: 112), and set the tooltip for both fileMenu and configMenu, for fileMenu it'll show "To create new, open, save form or exit".
 * for configMenu it'll show "To configure size and color of a component.
 * 
 * 
 * Author: Nattadol Thongbu
 * Date: 2/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class AthleteFormV5 extends AthleteFormV4 {

    // Declaring nessassary fonts and color.
    protected Color kkuColor, jlistBlueColor, bioTextAreaGreyColor, menuDarkblueColor;
    protected Font labelSerifFont, buttonSerifFont, menuSanSerifFont;

    // AthleteFormV5 class constructor.
    public AthleteFormV5(String title) {

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
        AthleteFormV5 msw = 
            new AthleteFormV5("Athlete Form V5");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }

    @Override
    public void addComponents() {

        // Call the addComponents method from the super class.
        super.addComponents();

        // Creating nessessary Color objects.
        kkuColor = new Color(167,59,36);
        jlistBlueColor = new Color(35, 45, 222);
        bioTextAreaGreyColor = new Color(200,200,200);

        // Creating nessessary Font objects.
        labelSerifFont = new Font("Serif", Font.BOLD, 14);
        buttonSerifFont = new Font("Serif", Font.BOLD + Font.ITALIC, 16);

        // Change the background color of all text fields.
        nameField.setBackground(kkuColor);
        weightField.setBackground(kkuColor);
        heightField.setBackground(kkuColor);
        bodField.setBackground(kkuColor);

        // Change the font of all labels.
        nameLabel.setFont(labelSerifFont);
        weightLabel.setFont(labelSerifFont);
        heightLabel.setFont(labelSerifFont);
        birthDateLabel.setFont(labelSerifFont);
        genderLabel.setFont(labelSerifFont);
        hobbiesLabel.setFont(labelSerifFont);
        nationnalityLabel.setFont(labelSerifFont);
        sportLabel.setFont(labelSerifFont);
        bioLabel.setFont(labelSerifFont);
        experienceLabel.setFont(labelSerifFont);

        // Change the color of items's font in sportJList.
        sportJList.setForeground(jlistBlueColor);

        // Change the font of all buttons.
        cancelButton.setFont(buttonSerifFont);
        resetButton.setFont(buttonSerifFont);
        submitButton.setFont(buttonSerifFont);

        // Change the background color of bioTextArea.
        bioTextArea.setBackground(bioTextAreaGreyColor);

        // Set the tooltips for cancel, reset, and submit button.
        cancelButton.setToolTipText("Press the cancel button to cancel this form");
        resetButton.setToolTipText("Press the reset button to reset this form");
        submitButton.setToolTipText("Press the submit button to submit this form");
    }

    @Override
    public void addMenus() {

        // Call the addMenus() method from the super.
        super.addMenus();

        // Creating SanSerif font object for menus and menu items.
        menuSanSerifFont = new Font("SanSerif", Font.BOLD, 14);

        // Creating Color object for the menus and menu items.
        menuDarkblueColor = new Color(6,57,112);

        // Change the font of all menus and menu items.
        fileMenu.setFont(menuSanSerifFont);
        configMenu.setFont(menuSanSerifFont);
        colorMenu.setFont(menuSanSerifFont);
        sizeMenu.setFont(menuSanSerifFont);
        newItem.setFont(menuSanSerifFont);
        openItem.setFont(menuSanSerifFont);
        saveItem.setFont(menuSanSerifFont);
        exitItem.setFont(menuSanSerifFont);
        redItem.setFont(menuSanSerifFont);
        greenItem.setFont(menuSanSerifFont);
        blueItem.setFont(menuSanSerifFont);
        sixtSize.setFont(menuSanSerifFont);
        twentSize.setFont(menuSanSerifFont);
        twenTFourSize.setFont(menuSanSerifFont);

        // Change the color of all menu's and menuItem's font.
        fileMenu.setForeground(menuDarkblueColor);
        configMenu.setForeground(menuDarkblueColor);
        colorMenu.setForeground(menuDarkblueColor);
        sizeMenu.setForeground(menuDarkblueColor);
        newItem.setForeground(menuDarkblueColor);
        openItem.setForeground(menuDarkblueColor);
        saveItem.setForeground(menuDarkblueColor);
        exitItem.setForeground(menuDarkblueColor);
        redItem.setForeground(menuDarkblueColor);
        greenItem.setForeground(menuDarkblueColor);
        blueItem.setForeground(menuDarkblueColor);
        sixtSize.setForeground(menuDarkblueColor);
        twentSize.setForeground(menuDarkblueColor);
        twenTFourSize.setForeground(menuDarkblueColor);       
        
        // Set tooltips for fileMenu and configMenu.
        fileMenu.setToolTipText("To create new, open, save form or exit");
        configMenu.setToolTipText("To configure size and color of a component");
    }    
}
