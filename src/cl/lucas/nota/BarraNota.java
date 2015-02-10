package cl.lucas.nota;

import cl.lucas.util.ImageDrawer;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Lucas Lizama
 */
public class BarraNota extends JPanel{
    
    private Image barra;

    public BarraNota() {}

    public BarraNota(Image barra) {
        this.barra = barra;
    }
    
    //<editor-fold defaultstate="folded" desc="Metodos de la Clase">
    @Override
    protected void paintComponent(Graphics g) {
        ImageDrawer.drawStretchedImage(barra, this, g);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="folded" desc="Accesadores y Mutadores">
    /**
     * @return the barra
     */
    public Image getBarra() {
        return barra;
    }

    /**
     * @param barra the barra to set
     */
    public void setBarra(Image barra) {
        this.barra = barra;
    }
    //</editor-fold>
}
