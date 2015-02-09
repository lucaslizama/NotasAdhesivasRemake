package cl.lucas.nota;

import cl.lucas.util.ImageDrawer;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class FondoNota extends JPanel {

    private Image fondo;

    public FondoNota() {
    }

    public FondoNota(Image fondo) {
        this.fondo = fondo;
    }

    @Override
    public void paintComponent(Graphics g) {
        ImageDrawer.drawStretchedImage(fondo, this, g);
    }

    //<editor-fold defaultstate="collapsed" desc="Accesadores y Mutadores">
    /**
     * @return the fondo
     */
    public Image getFondo() {
        return fondo;
    }

    /**
     * @param fondo the fondo to set
     */
    public void setFondo(Image fondo) {
        this.fondo = fondo;
    }
    //</editor-fold>
}
