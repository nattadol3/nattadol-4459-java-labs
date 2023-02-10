/**
 * This AthleteFormV3 program is the subclass to AthleteFormV2 class.  It add two menus on top of the GUI labeled "File" and "Config".
 * In File menu it has 4 option which is New, Open, Save, and Exit.  In Config menu it has two more menus.
 * The first menu is labeled "Color" which has 3 menu items (Red, Green, Blue).  The second menu is labeled "Size" which also has three menu items (16, 20, 24).
 * 
 * Author: Nattadol Thongbu
 * Date: 2/3/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab7;

import javax.swing.*;

public class AthleteFormV3 extends AthleteFormV2 {

    // Creating nessessary components and container.
    protected JMenuBar menuBar;
    protected JMenu fileMenu, configMenu, colorMenu, sizeMenu;
    protected JMenuItem newItem, openItem, saveItem, exitItem, redItem, greenItem, blueItem, sixtSize, twentSize, twenTFourSize;
    protected ImageIcon newIcon, openIcon, saveIcon;

    // AthleteFormV3 class constructor.
    public AthleteFormV3(String title) {

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
        AthleteFormV3 msw = 
            new AthleteFormV3("Athlete Form V3");
        msw.addComponents();
        msw.addMenus();
        msw.setFrameFeatures();
    }

    public void addMenus() {
        // Creating JMenuBar to add the menus.
        menuBar = new JMenuBar();

        // Creating all menu needed.
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        sizeMenu = new JMenu("Size");
        fileMenu = new JMenu("File");

        // Creating icon for the New, Open, and Save menu.
        newIcon = new ImageIcon(getClass().getResource("icons/New-icon.png"));
        openIcon = new ImageIcon(getClass().getResource("icons/Open-icon.png"));
        saveIcon = new ImageIcon(getClass().getResource("icons/Save-icon.png"));

        // Creating JMenuitems to be add into fileMenu.  New, Open, and Save menu have icon while Exit does not.
        newItem = new JMenuItem("New", newIcon);
        openItem = new JMenuItem("Open", openIcon);
        saveItem = new JMenuItem("Save", saveIcon);
        exitItem = new JMenuItem("Exit");

        // Add newItem, openItem, saveItem, and exitItem into fileMenu.
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Creating Red, Green, and Blue menu items for the Color menu.
        redItem = new JMenuItem("Red");
        greenItem = new JMenuItem("Green");
        blueItem = new JMenuItem("Blue");

        // Add redItem, greenItem, and blueItem into colorMenu.
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        // Creating 16, 20, and 24 menu items for the Size menu.
        sixtSize = new JMenuItem("16");
        twentSize = new JMenuItem("20");
        twenTFourSize = new JMenuItem("24");

        // Add sixtSize, twentSize, and twenTFourSize into the sizeMenu.
        sizeMenu.add(sixtSize);
        sizeMenu.add(twentSize);
        sizeMenu.add(twenTFourSize);

        // Add colorMenu and sizeMenu into config menu.
        configMenu.add(colorMenu);
        configMenu.add(sizeMenu);

        // Add fileMenu and configMenu into the menuBar.
        menuBar.add(fileMenu);
        menuBar.add(configMenu);

        // Set the menuBar at the top of the frame.
        setJMenuBar(menuBar);
    }
}
