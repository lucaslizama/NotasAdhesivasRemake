package cl.lucas.util;

import cl.lucas.nota.Nota;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
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
    private PopupMenu popUp;
    private SystemTray tray;
    private MenuItem aboutItem;
    private MenuItem exitItem;
    private MenuItem changeFontItem;
                 
    public DisplayTrayIcon() {
        showTrayIcon();
    }
    
    private void showTrayIcon() {
        if(!SystemTray.isSupported()){
            System.out.println("System is not supported");
            System.exit(0);
        }else{
            initComponents();
            addListeners();
            
            try{
                tray.add(trayIcon);
            }catch(AWTException e){  
            }
        }
    }
    
    private void initComponents() {
        //Inicializamos los objetos SystemTray y PopupMenu
        tray = SystemTray.getSystemTray();
        popUp = new PopupMenu();
        
        //Inicializamos los elementos del PopUp Menu
        aboutItem = new MenuItem("About");
        exitItem = new MenuItem("Exit");
        changeFontItem = new MenuItem("Change Font");
        
        //Añadimos los elemntos del menu al PopupMenu
        popUp.add(changeFontItem);
        popUp.add(aboutItem);
        popUp.addSeparator();
        popUp.add(exitItem);
        
        //Inicializamos el TrayIcon
        trayIcon = new TrayIcon(createIcon("/cl/lucas/images/tray_icon.png"),"Tray Icon");
        trayIcon.setToolTip("Notas Adhesivas");
        trayIcon.setPopupMenu(popUp);
    }
    
    private void addListeners() {
        
    }
    
    private Image createIcon(String path){
        URL imageURL = Nota.class.getResource(path);
        return new ImageIcon(imageURL).getImage();
    }
}
