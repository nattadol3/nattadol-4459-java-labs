/**
 * This ReadImage class entends from the JPanel class.  It read the photo from the internal file and override the paintComponent method
 * to draw it.  
 * 
 * Author: Nattadol Thongbu
 * Date: 2/17/2023
 * ID: 653040445-9
 * Sec: 2
 **/

package tongbu.nattadol.lab8;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadImage extends JPanel {

    // Creating nessassry variables from BufferedImage and Graphics2D.
    private BufferedImage athleteImg;
    private Graphics2D imageDraw;

    public ReadImage() {

        // Use try and catch to catch if there is an error when try to read the file.
        try {
            // Read the image file from internale file.
            athleteImg = ImageIO.read(new File("tongbu/nattadol/lab8/Image/Athlete.png"));
        } catch (IOException e) {
            // Error message.
            e.printStackTrace(System.err);
        }
    }



    @Override
    protected void paintComponent(Graphics graphics) {

        // Called the paintComponent method from the super class.
        super.paintComponent(graphics);

        // Cast the value of graphics to graphic2D and store it in imageDraw variable.
        imageDraw = (Graphics2D) graphics;

        // Draw the image.
        imageDraw.drawImage(athleteImg, 0, 0, null);
    }
    
}
