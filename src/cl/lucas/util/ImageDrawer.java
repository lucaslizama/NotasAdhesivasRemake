package cl.lucas.util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Lucas Lizama
 */
public class ImageDrawer {   
    public static void drawStretchedImage(Image image, Component canvas, Graphics g) {
        
        Integer imgWidth = image.getWidth(null);
        Integer imgHeigth = image.getHeight(null);

        Integer canvasWidth = canvas.getWidth();
        Integer canvasHeight = canvas.getHeight();

        Integer x1 = 0; 
        Integer y1 = 0;
        Integer x2 = canvasWidth;
        Integer y2 = canvasHeight;
        
        g.drawImage(image, x1, y1, x2, y2, 0, 0, imgWidth, imgHeigth, null);
    }
}
