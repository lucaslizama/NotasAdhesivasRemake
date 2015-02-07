package cl.lucas.App;

import cl.lucas.nota.Nota;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

/**
 * Clase encargada de gestionar y almacenar cada una de las
 * notas adhesivas creadas.
 * @author Lucas Lizama
 */
public class Controller {
    
    private final List<Nota> notas = new ArrayList<>();
    private Font fuenteActual;

    public Controller() {
        //Añadir metodo que compruebe si existen notas guardadas,
        //Si existen debe cargarlas desde el archvivo.
        //En caso contrario debera crear una nota, guardarla en la lista
        //y luego crear un archivo para almacenar notas.
    }
    
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
