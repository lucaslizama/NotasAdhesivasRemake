package cl.lucas.nota;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Lucas
 */
public class FondoNota extends JPanel{
    
    private Image fondo;

    public FondoNota(){}

    public FondoNota(Image fondo) {
        this.fondo = fondo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, null);
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
