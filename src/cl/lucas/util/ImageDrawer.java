package cl.lucas.util;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Lucas Lizama
 */
public class ImageDrawer {

    public static void drawScaledImage(Image image, Component canvas, Graphics g) {

        Integer imgWidth = image.getWidth(null);
        Integer imgHeigth = image.getHeight(null);

        Double imageAspect = (double) (imgWidth / imgHeigth);

        Integer canvasWidth = canvas.getWidth();
        Integer canvasHeight = canvas.getWidth();

        Double canvasAspect = (double) (canvasWidth / canvasHeight);
        
        Integer x1 = 0; 
        Integer y1 = 0;
        Integer x2 = 0;
        Integer y2 = 0;
        
        if(imgWidth < canvasWidth && imgHeigth < canvasHeight) {
            //Cuando la imagen sea mas pequeña que el Canvas
            x1 = (canvasWidth - imgWidth) / 2;
            y1 = (canvasHeight - imgHeigth) / 2;
            x2 = imgWidth + x1;
            y2 = imgHeigth + y1;
        } else {
            if(canvasAspect < imageAspect) {
                y1 = canvasHeight;
                //Se mantiene el aspect ratio
                canvasHeight = (int) (canvasWidth * imageAspect);
                y1 = (y1 - canvasHeight) / 2;
            } else {
                x1 = canvasWidth;
                //Se mantiene el aspect ratio
                canvasWidth = (int) (canvasWidth / imageAspect);
                x1 = (x1 - canvasWidth) / 2;
            }
            x2 = canvasWidth + x1;
            y2 = canvasHeight + y1;
        }
        
        g.drawImage(image, x1, y1, x2, y2, imgWidth, imgHeigth, 0, 0, null);
    }
    
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
