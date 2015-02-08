package cl.lucas.App;

import cl.lucas.nota.Nota;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Clase encargada de gestionar y almacenar cada una de las notas adhesivas
 * creadas.
 *
 * @author Lucas Lizama
 */
public class Controller {

    private final List<Nota> notas = new ArrayList<>();
    private Font fuenteActual;

    public Controller() {
        if(buscarArchivo())
            System.out.println("El archivo existe");
        else
            System.out.println("El archivo no existe");
        //Añadir metodo que compruebe si existen notas guardadas,
        //Si existen debe cargarlas desde el archvivo.
        //En caso contrario debera crear una nota, guardarla en la lista
        //y luego crear un archivo para almacenar notas.
    }

    
    //<editor-fold defaultstate="collapsed" desc="Metodos de la Clase">
    /**
     * Comprueba la existencia del archivo Notes.sav, donde se guardara
     * la informacion binaria de las notas creadas.
     * @return Retorna true si existe el archivo, false en caso contrario.
     */
    private Boolean buscarArchivo(){
        //Implementar luego para otrosOS ademas de windows
        File save = new File("C:\\Users\\Lucas\\Documents\\Lucas Sticky Notes\\Notes.sav");
        return save.exists();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Accesadores y Mutadores">
    /**
     * @return Retorna la lista con las notas almacenadas.
     */
    public List<Nota> getNotas() {
        return notas;
    }

    /**
     * @return the fuenteActual
     */
    public Font getFuenteActual() {
        return fuenteActual;
    }

    /**
     * @param fuenteActual the fuenteActual to set
     */
    public void setFuenteActual(Font fuenteActual) {
        this.fuenteActual = fuenteActual;
    }
    //</editor-fold>
}
