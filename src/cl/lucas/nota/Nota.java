package cl.lucas.nota;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;

/**
 *
 * @author Lucas Lizama
 */
public class Nota extends JFrame {

    private JLabel closeButton;
    private JLabel addButton;
    //private JLabel topBar;
    private JPanel rightResize;
    private BarraNota topbar;
    private JLabel noteBackground;
    private JTextArea txtNota;
    private FondoNota fondo;
    private Boolean closeButtonIsHovered;
    private Boolean addButtonIsHovered;
    private Point firstClick;

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Nota() {
        initComponents();
        addListeners();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos de la Clase">
    private void initComponents() {
        //Atributos del marco de la nota
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(300, 320);
        setMinimumSize(new Dimension(300, 320));
        setLocation(500, 500);

        fondo = new FondoNota(createIcon("/cl/lucas/images/nota_fondo.png").getImage());
        fondo.setLayout(null);
        fondo.setSize(300, 320);
        fondo.setLocation(0, 0);

        //Atributos de la barra superior
        //topBar = new JLabel(createIcon("/cl/lucas/images/nota_barra.png"));
        //topBar.setSize(300, 30);
        //topBar.setLocation(0, 0);
        topbar = new BarraNota(createIcon("/cl/lucas/images/nota_barra.png").getImage());
        topbar.setSize(300, 30);
        topbar.setLocation(0, 0);
        topbar.setLayout(null);

        //Atributos del boton que cierra la nota
        closeButton = new JLabel(createIcon("/cl/lucas/images/boton_cerrar.png"));
        closeButton.setSize(18, 18);
        closeButton.setLocation(279, 1);

        //Atributos del boton que crea nuevas notas
        addButton = new JLabel(createIcon("/cl/lucas/images/boton_mas.png"));
        addButton.setSize(18, 18);
        addButton.setLocation(1, 1);

        //Atributos del area de texto de la nota
        txtNota = new JTextArea(1, 0);
        txtNota.setSize(290, 300);
        txtNota.setMinimumSize(new Dimension(290, 300));
        txtNota.setLocation(5, 30);
        txtNota.setLineWrap(true);
        txtNota.setWrapStyleWord(true);
        txtNota.setOpaque(false);
        txtNota.setFont(new Font("Courier New", Font.PLAIN, 18));

        //Atributos del panel de redimensionamiento derecho
        rightResize = new JPanel(null);
        rightResize.setSize(7, getSize().height);
        rightResize.setLocation(fondo.getSize().width - 7, 0);
        rightResize.setBackground(Color.RED);
        rightResize.setOpaque(false);

        //Añadir elementos al marco
        add(fondo);
        fondo.add(rightResize);
        fondo.add(topbar);
        fondo.add(txtNota);
        topbar.add(closeButton);
        topbar.add(addButton);
        pack();
        setVisible(true);

        //Inicializar variables
        setCloseButtonHovered(false);
        setAddButtonIsHovered(false);
    }

    private void addListeners() {
        //Override de los metodos del Component Listener del JFrame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Integer x = getSize().width;
                Integer y = getSize().height;
                fondo.setSize(x, y);
                topbar.setSize(x, 30);
                closeButton.setLocation((x - 21), 1);
                System.out.println(getSize() + " // " + x + " " + y + " // " + fondo.getSize());
            }
        });
        //Override de los metodos del MouseListener del boton cerrar
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent me) {
                closeButtonIsHovered = true;
                closeButton.setIcon(createIcon("/cl/lucas/images/boton_cerrar_hover.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                closeButtonIsHovered = false;
                closeButton.setIcon(createIcon("/cl/lucas/images/boton_cerrar.png"));
            }
            @Override
            public void mousePressed(MouseEvent me) {
                closeButton.setIcon(createIcon("/cl/lucas/images/boton_cerrar_pressed.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                if (closeButtonIsHovered) {
                    System.exit(0);
                }
            }
        });
        //Override de los metodos del MouseListener del boton añadir
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                addButton.setIcon(createIcon("/cl/lucas/images/boton_mas_pressed.png"));
            }
            @Override
            public void mouseReleased(MouseEvent me) {
                addButton.setIcon(createIcon("/cl/lucas/images/boton_mas.png"));
            }
            @Override
            public void mouseEntered(MouseEvent me) {
                setAddButtonIsHovered(true);
                addButton.setIcon(createIcon("/cl/lucas/images/boton_mas_hover.png"));
            }
            @Override
            public void mouseExited(MouseEvent me) {
                setAddButtonIsHovered(false);
                addButton.setIcon(createIcon("/cl/lucas/images/boton_mas.png"));
            }
        });
        //Override de los metodos del MouseListener de la barra de menu
        topbar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                firstClick = me.getPoint();
            }
        });
        //Override de los metodos del MouseMotionListener de la barra de menu
        topbar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                // get location of window
                int thisX = getLocation().x;
                int thisY = getLocation().y;

                // Determine how much the mosue moved since the initial click
                int xMoved = me.getX() - firstClick.x;
                int yMoved = me.getY() - firstClick.y;

                // Move windows to this position
                int x = thisX + xMoved;
                int y = thisY + yMoved;
                setLocation(x, y);
            }
        });
        //Override de los Metodos del MouseListener del panel de redimensionamiento
        rightResize.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                firstClick = me.getPoint();
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                rightResize.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent me) {
               rightResize.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                rightResize.setLocation(getSize().width - 7, 0);
            }

        });
        //Override de los Metodos del MouseMotionListener del panel de redimensionamiento
        rightResize.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                //Calculo cuanto se movio el mouse
                int xMoved = me.getX() - firstClick.x;
                //Redimenciono la ventana
                int x = getSize().width + xMoved;
                setSize(x, getSize().height);
                //Actualizo la pocicion del mouse
                firstClick = me.getPoint();
            }
        });
    }

    private ImageIcon createIcon(String path) {
        URL imageURL = Nota.class.getResource(path);
        return new ImageIcon(imageURL);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Accesadores y Mutadores">
    /**
     * @return the closeButtonIsHovered
     */
    public Boolean getCloseButtonHovered() {
        return closeButtonIsHovered;
    }

    /**
     * @param closeButtonHovered the closeButtonIsHovered to set
     */
    public void setCloseButtonHovered(Boolean closeButtonHovered) {
        this.closeButtonIsHovered = closeButtonHovered;
    }

    /**
     * @return the closeButton
     */
    public JLabel getCloseButton() {
        return closeButton;
    }

    /**
     * @param closeButton the closeButton to set
     */
    public void setCloseButton(JLabel closeButton) {
        this.closeButton = closeButton;
    }

    /**
     * @return the addButton
     */
    public JLabel getAddButton() {
        return addButton;
    }

    /**
     * @param addButton the addButton to set
     */
    public void setAddButton(JLabel addButton) {
        this.addButton = addButton;
    }

    /**
     * @return the topBar
     */
    public BarraNota getTopBar() {
        return topbar;
    }

    /**
     * @param topBar the topBar to set
     */
    public void setTopBar(BarraNota topBar) {
        this.topbar = topBar;
    }

    /**
     * @return the noteBackground
     */
    public JLabel getNoteBackground() {
        return noteBackground;
    }

    /**
     * @param noteBackground the noteBackground to set
     */
    public void setNoteBackground(JLabel noteBackground) {
        this.noteBackground = noteBackground;
    }

    /**
     * @return the txtNota
     */
    public JTextArea getTxtNota() {
        return txtNota;
    }

    /**
     * @param txtNota the txtNota to set
     */
    public void setTxtNota(JTextArea txtNota) {
        this.txtNota = txtNota;
    }

    /**
     * @return the addButtonIsHovered
     */
    public Boolean getAddButtonIsHovered() {
        return addButtonIsHovered;
    }

    /**
     * @param addButtonIsHovered the addButtonIsHovered to set
     */
    public void setAddButtonIsHovered(Boolean addButtonIsHovered) {
        this.addButtonIsHovered = addButtonIsHovered;
    }
    //</editor-fold>   
}
