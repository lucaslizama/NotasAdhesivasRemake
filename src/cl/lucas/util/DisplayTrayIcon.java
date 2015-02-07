package cl.lucas.util;

import cl.lucas.nota.Nota;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import ZoeloeSoft.projects.JFontChooser.JFontChooser;

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
        if (!SystemTray.isSupported()) {
            System.out.println("System is not supported");
            System.exit(0);
        } else {
            initComponents();
            addListeners();
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Metodos de la Clase">
    /**
     * Metodo que inicializa las variables de la clase
     */
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
        trayIcon = new TrayIcon(createIcon("/cl/lucas/images/tray_icon.png"), "Tray Icon");
        trayIcon.setToolTip("Notas Adhesivas");
        trayIcon.setPopupMenu(popUp);
    }

    /**
     * Metodo que añade y configura los Listeners para los elementos del
     * PopupMenu del TrayIcon.
     */
    private void addListeners() {
        changeFontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                System.exit(0);
            }
        });
    }

    /**
     * Metodo que devuelve la imagen del URL ingresado por parametro.
     *
     * @param path Directorio de la imagen a cargar.
     * @return Devuelve la imagen cargada en forma de un objeto Image.
     */
    private Image createIcon(String path) {
        URL imageURL = Nota.class.getResource(path);
        return new ImageIcon(imageURL).getImage();
    }
    //</editor-fold>
}
