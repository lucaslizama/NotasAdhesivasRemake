package cl.lucas.App;

import cl.lucas.util.DisplayTrayIcon;
import javax.swing.UIManager;

/**
 * 
 * @author Lucas Lizama
 */
public class Main {
    public static void main(String[] args) {
        setLookAndFeel();
        DisplayTrayIcon trayIcon = new DisplayTrayIcon();
        Controller controlador = new Controller();
    }
    
    public static void setLookAndFeel(){
        try {
            String laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(laf);
        } catch (Exception ex) {
        }
    }
}
