/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uy.bios.dgg.bibliotecamistica.excepciones.AutorException;
import uy.bios.dgg.bibliotecamistica.excepciones.CategoriaException;
import uy.bios.dgg.bibliotecamistica.excepciones.LibroException;
import uy.bios.dgg.bibliotecamistica.logica.Autor;
import uy.bios.dgg.bibliotecamistica.logica.Autores;
import uy.bios.dgg.bibliotecamistica.logica.Categoria;
import uy.bios.dgg.bibliotecamistica.logica.Categorias;
import uy.bios.dgg.bibliotecamistica.logica.FachadaLogica;
import uy.bios.dgg.bibliotecamistica.logica.Libro;
import uy.bios.dgg.bibliotecamistica.logica.Prestamo;

/**
 *
 * @author DGG
 */
public class VentanaPrestamos extends JFrame {

    private final int MAX_LARGO_TEXTO = 45;
    private final JFrame ventanaAnterior;
    private final FachadaLogica fachadaLogica = new FachadaLogica();
    private Prestamo prestamo;

    /**
     * Creates new form VentanaSocios
     *
     * @param ventana
     */
    public VentanaPrestamos(JFrame ventana) {
        ventanaAnterior = ventana;
        initComponents();
//        limpiarFormulario();
    }

//    private void cargarComboCategorias() {
//        Categorias categorias;
//        this.jCboBoxCategoria.removeAllItems();
//        try {
//            categorias = fachadaLogica.obtenerCategorias();
//            for (int i = 0; i < categorias.getCategorias().size(); i++) {
//                this.jCboBoxCategoria.addItem(categorias.getCategorias().get(i));
//            }
//        } catch (CategoriaException ex) {
//            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
//        }
//    }

//    private void cargarComboAutores() {
//        Autores autores;
//        this.jCboBoxAutor.removeAllItems();
//        try {
//            autores = fachadaLogica.obtenerAutores();
//            for (int i = 0; i < autores.getAutores().size(); i++) {
//                this.jCboBoxAutor.addItem(autores.getAutores().get(i));
//            }
//        } catch (AutorException ex) {
//            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
//        }
//    }

    private void volver() {
        ventanaAnterior.setVisible(true);
        this.dispose();
    }

//    private void limpiarFormulario() {
//        this.jTxtCodigo.setText("");
//        this.jTxtTitulo.setText("");
//        this.jTxtAnio.setText("");
//        this.jTxtDisponible.setText("");
//        this.libro = new Libro();
//        this.cargarComboAutores();
//        this.cargarComboCategorias();
//    }

//    private void mostrarLibro() {
//        this.jTxtCodigo.setText(libro.getCodigo());
//        this.jTxtTitulo.setText(libro.getTitulo());
//        this.jTxtAnio.setText(libro.getAnioEdicion().toString());
//
//        if (libro.getDisponible()) {
//            this.jTxtDisponible.setText("Disponible");
//        } else {
//            this.jTxtDisponible.setText("No disponible");
//        }
//        seleccionarAutorEnCombo(libro.getAutor());
//        seleccinarCategoriaEnCombo(libro.getCategoria());
//
//    }

//    public void setYmostrarLibro(Libro libro) {
//        this.libro = libro;
//        mostrarLibro();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTxtDocumento = new javax.swing.JTextField();
        jBtnBuscar1 = new javax.swing.JButton();
        jPnlSocio = new javax.swing.JPanel();
        jTxtSocio = new javax.swing.JTextField();
        jBtnPrestar = new javax.swing.JButton();
        jBtnListPrestamos = new javax.swing.JButton();
        jBtnRetrasos = new javax.swing.JButton();
        jPnlLibro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtAnio = new javax.swing.JTextField();
        jTxtDisponible = new javax.swing.JTextField();
        jTxtAutor = new javax.swing.JTextField();
        jTxtCategoria = new javax.swing.JTextField();
        jTxtAnio3 = new javax.swing.JTextField();
        jBtnRenovar = new javax.swing.JButton();
        jBtnDevolver = new javax.swing.JButton();
        jBtnVolver = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListapretamos = new javax.swing.JList<>();
        jBtnVerTodos = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Libros");
        setName("frameLibros"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar préstamo"));

        jLabel10.setText("Documento de Identidad:");

        jTxtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtDocumentoKeyTyped(evt);
            }
        });

        jBtnBuscar1.setText("Buscar");
        jBtnBuscar1.setToolTipText("Busca el socio por el documento ingresado");
        jBtnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jTxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBtnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap())
        );

        jPnlSocio.setBorder(javax.swing.BorderFactory.createTitledBorder("Socio"));

        jTxtSocio.setEditable(false);
        jTxtSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtSocioKeyTyped(evt);
            }
        });

        jBtnPrestar.setText("Prestar");
        jBtnPrestar.setToolTipText("Borra el socio.");
        jBtnPrestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrestarActionPerformed(evt);
            }
        });

        jBtnListPrestamos.setText("Prestamos otorgados");
        jBtnListPrestamos.setToolTipText("Borra el socio.");
        jBtnListPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnListPrestamosActionPerformed(evt);
            }
        });

        jBtnRetrasos.setText("Dev. Retrasos");
        jBtnRetrasos.setToolTipText("Borra el socio.");
        jBtnRetrasos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRetrasosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnlSocioLayout = new javax.swing.GroupLayout(jPnlSocio);
        jPnlSocio.setLayout(jPnlSocioLayout);
        jPnlSocioLayout.setHorizontalGroup(
            jPnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSocioLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(jPnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPnlSocioLayout.createSequentialGroup()
                        .addComponent(jBtnPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnListPrestamos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnRetrasos))
                    .addComponent(jTxtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
        jPnlSocioLayout.setVerticalGroup(
            jPnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlSocioLayout.createSequentialGroup()
                .addComponent(jTxtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnPrestar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnListPrestamos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnRetrasos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPnlLibro.setBorder(javax.swing.BorderFactory.createTitledBorder("Libro"));
        jPnlLibro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPnlLibroAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel3.setText("Título:");

        jLabel5.setText("Año de edición:");

        jLabel6.setText("Disponibilidad:");

        jLabel7.setText("Autor:");

        jLabel8.setText("Categoría:");

        jTxtAnio.setEditable(false);
        jTxtAnio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtAnioKeyTyped(evt);
            }
        });

        jTxtDisponible.setEditable(false);
        jTxtDisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtDisponibleKeyTyped(evt);
            }
        });

        jTxtAutor.setEditable(false);
        jTxtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtAutorKeyTyped(evt);
            }
        });

        jTxtCategoria.setEditable(false);
        jTxtCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCategoriaKeyTyped(evt);
            }
        });

        jTxtAnio3.setEditable(false);
        jTxtAnio3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtAnio3KeyTyped(evt);
            }
        });

        jBtnRenovar.setText("Renovar");
        jBtnRenovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRenovarActionPerformed(evt);
            }
        });

        jBtnDevolver.setText("Devolver");

        javax.swing.GroupLayout jPnlLibroLayout = new javax.swing.GroupLayout(jPnlLibro);
        jPnlLibro.setLayout(jPnlLibroLayout);
        jPnlLibroLayout.setHorizontalGroup(
            jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlLibroLayout.createSequentialGroup()
                        .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPnlLibroLayout.createSequentialGroup()
                                    .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(jPnlLibroLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(53, 53, 53)))
                            .addGroup(jPnlLibroLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(53, 53, 53)))
                        .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCategoria)
                            .addComponent(jTxtAutor)
                            .addComponent(jTxtAnio)
                            .addComponent(jTxtAnio3)
                            .addComponent(jTxtDisponible)))
                    .addGroup(jPnlLibroLayout.createSequentialGroup()
                        .addGap(0, 240, Short.MAX_VALUE)
                        .addComponent(jBtnRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPnlLibroLayout.setVerticalGroup(
            jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtAnio3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(12, 12, 12)
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPnlLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnRenovar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jBtnVolver.setText("Volver");
        jBtnVolver.setToolTipText("Vuelve al menú principal");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Préstamos"));

        jListapretamos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jListapretamos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jListapretamos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Titulo libro-Fecha de prestamo- Estado de prestamo(en curso o atrasado)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListapretamos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListapretamosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListapretamos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jBtnVerTodos.setText("Ver todos");
        jBtnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerTodosActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uy/bios/dgg/bibliotecamistica/imagenes/iconsPedirPrestado64.png"))); // NOI18N
        jLabel9.setText("Préstamos y devoluciones");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPnlLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(269, 269, 269)
                                .addComponent(jBtnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPnlSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPnlSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPnlLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVerTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtSocioKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtSocio.getText().length() == MAX_LARGO_TEXTO)
            evt.consume();
    }//GEN-LAST:event_jTxtSocioKeyTyped

    private void jTxtAnioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAnioKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtAnio.getText().length() == 4)
            evt.consume();
    }//GEN-LAST:event_jTxtAnioKeyTyped

    private void jTxtDisponibleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtDisponibleKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtDisponible.getText().length() == MAX_LARGO_TEXTO)
            evt.consume();
    }//GEN-LAST:event_jTxtDisponibleKeyTyped

    private void jBtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVolverActionPerformed
        this.volver();
    }//GEN-LAST:event_jBtnVolverActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //this.volver();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.volver();
    }//GEN-LAST:event_formWindowClosing

    private void jBtnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerTodosActionPerformed
//        try {
//            VentanaLibrosVerTodos ventana = new VentanaLibrosVerTodos(this);
//            ventana.setVisible(true);
//            this.setVisible(false);
//        } catch (LibroException | AutorException ex) {
//            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_jBtnVerTodosActionPerformed

    private void jBtnRetrasosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRetrasosActionPerformed
//        if (checkAptoBorrar()) {
//            try {
//                if (JOptionPane.showConfirmDialog(null, "¿Confirma el borrado del libro " + libro + "?", "Atención", JOptionPane.YES_NO_OPTION) == 0) {
//                    fachadaLogica.borrarLibro(libro);
//                    this.limpiarFormulario();
//                    JOptionPane.showMessageDialog(null, "El libro " + libro + " se borró correctamente.", "Baja de libro", JOptionPane.INFORMATION_MESSAGE);
//                }
//            } catch (LibroException ex) {
//                JOptionPane.showMessageDialog(null, ex, "Atención", JOptionPane.WARNING_MESSAGE);
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo borrar ningún libro. \n Por favor seleccione uno y vuelva a intentarlo.", "Baja de libro", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_jBtnRetrasosActionPerformed

    private void jBtnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnBuscar1ActionPerformed

    private void jTxtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtDocumentoKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtDocumento.getText().length() == MAX_LARGO_TEXTO)
        evt.consume();
    }//GEN-LAST:event_jTxtDocumentoKeyTyped

    private void jTxtAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAutorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAutorKeyTyped

    private void jTxtCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCategoriaKeyTyped

    private void jTxtAnio3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtAnio3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtAnio3KeyTyped

    private void jPnlLibroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jPnlLibroAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPnlLibroAncestorAdded

    private void jBtnListPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnListPrestamosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnListPrestamosActionPerformed

    private void jBtnPrestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrestarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnPrestarActionPerformed

    private void jBtnRenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRenovarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnRenovarActionPerformed

    private void jListapretamosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListapretamosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jListapretamosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBuscar1;
    private javax.swing.JButton jBtnDevolver;
    private javax.swing.JButton jBtnListPrestamos;
    private javax.swing.JButton jBtnPrestar;
    private javax.swing.JButton jBtnRenovar;
    private javax.swing.JButton jBtnRetrasos;
    private javax.swing.JButton jBtnVerTodos;
    private javax.swing.JToggleButton jBtnVolver;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListapretamos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPnlLibro;
    private javax.swing.JPanel jPnlSocio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtAnio;
    private javax.swing.JTextField jTxtAnio3;
    private javax.swing.JTextField jTxtAutor;
    private javax.swing.JTextField jTxtCategoria;
    private javax.swing.JTextField jTxtDisponible;
    private javax.swing.JTextField jTxtDocumento;
    private javax.swing.JTextField jTxtSocio;
    // End of variables declaration//GEN-END:variables

//    private void seleccionarAutorEnCombo(Autor autor) {
//        for (int i = 0; i < this.jCboBoxAutor.getItemCount(); i++) {
//            Autor tmpAutor = (Autor) this.jCboBoxAutor.getItemAt(i);
//            if (tmpAutor.getIdautor().equals(autor.getIdautor())) {
//                this.jCboBoxAutor.setSelectedIndex(i);
//            }
//        }
//    }

//    private void seleccinarCategoriaEnCombo(Categoria categoria) {
//        for (int i = 0; i < this.jCboBoxCategoria.getItemCount(); i++) {
//            Categoria tmpCategoria = (Categoria) this.jCboBoxCategoria.getItemAt(i);
//            if (tmpCategoria.getIdcategoria().equals(categoria.getIdcategoria())) {
//                this.jCboBoxCategoria.setSelectedIndex(i);
//            }
//        }
//    }

//    private boolean checkAptoBorrar() {
//        //chequeo para asegurarnos que la categoria en memoria sea igual a la que se visualiza en pantalla
//        if (libro.getIdlibro() != null) {
//            if (this.jTxtCodigo.getText().trim().equals(libro.getCodigo())) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private boolean checkAptoModificar() {
//        //chequeo para saber si es apto para realizar una modificación
//        if (libro.getIdlibro() != null) {
//            Autor autor = (Autor) this.jCboBoxAutor.getSelectedItem();
//            Categoria categoria = (Categoria) this.jCboBoxCategoria.getSelectedItem();
//
//            if (!this.jTxtCodigo.getText().trim().equals(libro.getCodigo()) || !this.jTxtTitulo.getText().trim().equals(libro.getTitulo()) || !this.jTxtAnio.getText().trim().equals(libro.getAnioEdicion().toString()) || !autor.getIdautor().equals(libro.getAutor().getIdautor()) || !categoria.getIdcategoria().equals(libro.getCategoria().getIdcategoria())) {
//                if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtTitulo.getText().trim().equals("") && !this.jTxtAnio.getText().trim().equals("")) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    private boolean checkAptoIngresar() {
//        //chequeo para saber si es apto para realizar un nuevo ingreso
//        if (libro.getIdlibro() == null) {
//            if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtTitulo.getText().trim().equals("") && !this.jTxtAnio.getText().trim().equals("")) {
//                return true;
//            }
//        }
//        return false;
//    }

//    private void cargaDatosDesdeFormulario() {
//        libro.setCodigo(this.jTxtCodigo.getText());
//        libro.setTitulo(this.jTxtTitulo.getText());
//        libro.setAnioEdicion(Integer.valueOf(this.jTxtAnio.getText()));
//        if (this.jTxtDisponible.getText().equals("Disponible") || this.jTxtDisponible.getText().equals("")) {
//            libro.setDisponible(Boolean.TRUE);
//        } else {
//            libro.setDisponible(Boolean.FALSE);
//        }
//        Autor autor = (Autor) this.jCboBoxAutor.getSelectedItem();
//        Categoria categoria = (Categoria) this.jCboBoxCategoria.getSelectedItem();
//        libro.setAutor(autor);
//        libro.setCategoria(categoria);
//    }
}