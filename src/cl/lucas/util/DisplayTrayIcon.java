package cl.lucas.util;

import cl.lucas.nota.Nota;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Lucas
 */
public class DisplayTrayIcon {
    
    private TrayIcon trayIcon;
    
    public DisplayTrayIcon() {
        showTrayIcon();
    }
    
    private void showTrayIcon() {
        
        if(!SystemTray.isSupported()){
            System.out.println("System is not supported");
            System.exit(0);
        }else{
            final PopupMenu popUp = new PopupMenu();
            final SystemTray tray = SystemTray.getSystemTray();
            trayIcon = new TrayIcon(createIcon("/cl/lucas/images/tray_icon.png"),"Tray Icon");
            trayIcon.setToolTip("Notas Adhesivas");
            trayIcon.setPopupMenu(popUp);
            
            
            try{
                tray.add(trayIcon);
            }catch(AWTException e){
                
            }
        }
    }
    
    private Image createIcon(String path){
        URL imageURL = Nota.class.getResource(path);
        return new ImageIcon(imageURL).getImage();
    }
}
