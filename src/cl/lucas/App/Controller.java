package cl.lucas.App;

import java.util.ArrayList;
import java.util.List;
import cl.lucas.nota.Nota;

/**
 * Clase encargada de gestionar y almacenar cada una de las
 * notas adhesivas creadas.
 * @author Lucas Lizama
 */
public class Controller {
    
    private static final List<Nota> notas = new ArrayList<>();

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
    public static List<Nota> getNotas() {
        return notas;
    }
    //</editor-fold>
}
