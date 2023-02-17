/**
 * This OlympicSymbol class extends from JPanel class.  It override the paintComponent method to draw an olypic symbol in
 * the white background.
 * 
 * Author: Nattadol Thongbu
 * Date: 2/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import java.awt.*;
import javax.swing.JPanel;

public class OlympicSymbol extends JPanel {

    // Declaring nessessary values and variables.
    private int width,  height;
    private Graphics2D olympicCircles;
    private Stroke circleStroke;

    @Override
    protected void paintComponent(Graphics graphics) {

        // Call the paintComponent class from super class.
        super.paintComponent(graphics);

        // Creating BasicStroke object.
        circleStroke = new BasicStroke(5);

        // Get the width and height of the window.  Store it in width and height variables.
        width = getWidth();
        height = getHeight();

        // cast the graphics value to Graphics2D and store it in olypicCircles variable.
        olympicCircles = (Graphics2D) graphics;

        // Set the stroke of the circle.
        olympicCircles.setStroke(circleStroke);

        // Set the background of the picture.
        olympicCircles.setBackground(Color.WHITE);

        // Clear the rectangle area for the background color to be filled.
        olympicCircles.clearRect(0, 0, width, height);

        // Drawing the olympic symbol.
        olympicCircles.setPaint(Color.blue);
        olympicCircles.drawOval(width * 5 / 100, height * 10 / 100, 50, 50);
        olympicCircles.setPaint(Color.RED);
        olympicCircles.drawOval(width * 5 / 100 + 50, height * 10 / 100, 50, 50);
        olympicCircles.setPaint(Color.YELLOW);
        olympicCircles.drawOval(width * 5 / 100 + 100, height * 10 / 100, 50, 50);
        olympicCircles.setPaint(Color.GREEN);
        olympicCircles.drawOval(width * 5 / 100 + 25, height * 10 / 100 + 25, 50, 50);
        olympicCircles.setPaint(Color.BLACK);
        olympicCircles.drawOval(width * 5 / 100 + 75, height * 10 / 100 + 25, 50, 50);
    }
}