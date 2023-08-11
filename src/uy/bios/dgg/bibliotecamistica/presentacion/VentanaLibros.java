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

/**
 *
 * @author DGG
 */
public class VentanaLibros extends JFrame {

    private final int MAX_LARGO_TEXTO = 45;
    private final JFrame ventanaAnterior;
    private final FachadaLogica fachadaLogica = new FachadaLogica();
    private Libro libro;// = new Libro();

    /**
     * Creates new form VentanaSocios
     *
     * @param ventana
     */
    public VentanaLibros(JFrame ventana) {
        ventanaAnterior = ventana;
        initComponents();
        limpiarFormulario();
    }

    private void cargarComboCategorias() {
        Categorias categorias;
        this.jCboBoxCategoria.removeAllItems();
        try {
            categorias = fachadaLogica.obtenerCategorias();
            for (int i = 0; i < categorias.getCategorias().size(); i++) {
                this.jCboBoxCategoria.addItem(categorias.getCategorias().get(i));
            }
        } catch (CategoriaException ex) {
            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void cargarComboAutores() {
        Autores autores;
        this.jCboBoxAutor.removeAllItems();
        try {
            autores = fachadaLogica.obtenerAutores();
            for (int i = 0; i < autores.getAutores().size(); i++) {
                this.jCboBoxAutor.addItem(autores.getAutores().get(i));
            }
        } catch (AutorException ex) {
            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void volver() {
        ventanaAnterior.setVisible(true);
        this.dispose();
    }

    private void limpiarFormulario() {
        this.jTxtCodigo.setText("");
        this.jTxtTitulo.setText("");
        this.jTxtAnio.setText("");
        this.jTxtDisponible.setText("");
        this.libro = new Libro();
        this.cargarComboAutores();
        this.cargarComboCategorias();
    }

    private void mostrarLibro() {
        this.jTxtCodigo.setText(libro.getCodigo());
        this.jTxtTitulo.setText(libro.getTitulo());
        this.jTxtAnio.setText(libro.getAnioEdicion().toString());

        if (libro.getDisponible()) {
            this.jTxtDisponible.setText("Disponible");
        } else {
            this.jTxtDisponible.setText("No disponible");
        }
        seleccionarAutorEnCombo(libro.getAutor());
        seleccinarCategoriaEnCombo(libro.getCategoria());

    }

    public void setYmostrarLibro(Libro libro) {
        this.libro = libro;
        mostrarLibro();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jTxtTitulo = new javax.swing.JTextField();
        jTxtAnio = new javax.swing.JTextField();
        jTxtDisponible = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jCboBoxAutor = new javax.swing.JComboBox<>();
        jCboBoxCategoria = new javax.swing.JComboBox<>();
        jBtnAgregaAutor = new javax.swing.JButton();
        jBtnAgregaCategoria = new javax.swing.JButton();
        jBtnVolver = new javax.swing.JToggleButton();
        jBtnNuevo = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();
        jBtnBorrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jBtnVerTodos = new javax.swing.JButton();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Código:");

        jLabel3.setText("Título:");

        jLabel5.setText("Año de edición:");

        jLabel6.setText("Estado de disponibilidad:");

        jLabel7.setText("Autor:");

        jLabel8.setText("Categoría:");

        jTxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCodigoKeyTyped(evt);
            }
        });

        jTxtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtTituloKeyTyped(evt);
            }
        });

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

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.setToolTipText("Busca el socio por el documento ingresado");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
            }
        });

        jBtnAgregaAutor.setText("Agregar");
        jBtnAgregaAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregaAutorActionPerformed(evt);
            }
        });

        jBtnAgregaCategoria.setText("Agregar");
        jBtnAgregaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregaCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addComponent(jTxtTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtAnio, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCboBoxAutor, 0, 202, Short.MAX_VALUE)
                            .addComponent(jCboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnAgregaAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBtnAgregaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTxtDisponible))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTxtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jCboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregaAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jCboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregaCategoria))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnVolver.setText("Volver");
        jBtnVolver.setToolTipText("Vuelve al menú principal");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        jBtnNuevo.setText("Nuevo");
        jBtnNuevo.setToolTipText("Limpia la panatalla para un nuevo socio.");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.setToolTipText("Actualiza el socio actual o inserta uno nuevo.");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jBtnBorrar.setText("Borrar");
        jBtnBorrar.setToolTipText("Borra el socio.");
        jBtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uy/bios/dgg/bibliotecamistica/imagenes/iconsLibro40.png"))); // NOI18N
        jLabel9.setText(" Altas, bajas y modificaciones de libros.");

        jBtnVerTodos.setText("Ver todos");
        jBtnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVerTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnVerTodos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBtnVerTodos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnNuevo)
                    .addComponent(jBtnAceptar)
                    .addComponent(jBtnBorrar)
                    .addComponent(jBtnVolver))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCodigoKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtCodigo.getText().length() == MAX_LARGO_TEXTO)
            evt.consume();
    }//GEN-LAST:event_jTxtCodigoKeyTyped

    private void jTxtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtTituloKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtTitulo.getText().length() == MAX_LARGO_TEXTO)
            evt.consume();
    }//GEN-LAST:event_jTxtTituloKeyTyped

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

    private void jBtnAgregaAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregaAutorActionPerformed
        VentanaAutores ventana = new VentanaAutores(this, this.jCboBoxAutor); //Creo ventanaAutores y le paso el menu como parametro para poder volver al menu
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnAgregaAutorActionPerformed

    private void jBtnAgregaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregaCategoriaActionPerformed
        VentanaCategorias ventana = new VentanaCategorias(this, this.jCboBoxCategoria); //Creo ventanaCategorias y le paso el menu como parametro para poder volver al menu
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnAgregaCategoriaActionPerformed

    private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_jBtnNuevoActionPerformed

    private void jBtnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVerTodosActionPerformed
        try {
            VentanaLibrosVerTodos ventana = new VentanaLibrosVerTodos(this);
            ventana.setVisible(true);
            this.setVisible(false);
        } catch (LibroException | AutorException ex) {
            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnVerTodosActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        if (!this.jTxtCodigo.getText().trim().equals("")) {
            try {
                String codigo = this.jTxtCodigo.getText().trim();
                libro = fachadaLogica.obtenerLibro(codigo);
                if (libro.getIdlibro() == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró el libro con el código ingresado.", "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    mostrarLibro();
                }
            } catch (LibroException | AutorException | CategoriaException ex) {
                JOptionPane.showMessageDialog(null, ex, "Atención", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarActionPerformed
        if (checkAptoBorrar()) {
            try {
                if (JOptionPane.showConfirmDialog(null, "¿Confirma el borrado del libro " + libro + "?", "Atención", JOptionPane.YES_NO_OPTION) == 0) {
                    fachadaLogica.borrarLibro(libro);
                    this.limpiarFormulario();
                    JOptionPane.showMessageDialog(null, "El libro " + libro + " se borró correctamente.", "Baja de libro", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (LibroException ex) {
                JOptionPane.showMessageDialog(null, ex, "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo borrar ningún libro. \n Por favor seleccione uno y vuelva a intentarlo.", "Baja de libro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnBorrarActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        if (checkAptoModificar()) {
            cargaDatosDesdeFormulario();
            try {
                if (JOptionPane.showConfirmDialog(null, "¿Confirma la modificación del libro " + libro + "?", "Atención", JOptionPane.YES_NO_OPTION) == 0) {
                    fachadaLogica.modificarLibro(libro);
                    JOptionPane.showMessageDialog(null, "La modificación se realizó correctamente.", "Libros", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (LibroException ex) {
                JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
            }
        } else if (checkAptoIngresar()) {
            cargaDatosDesdeFormulario();
            try {
                fachadaLogica.ingresarLibro(libro);
                JOptionPane.showMessageDialog(null, "El alta se realizó correctamente.", "Categorías", JOptionPane.INFORMATION_MESSAGE);
            } catch (LibroException ex) {
                JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar ninguna tarea con libros. \n Por favor seleccione una para su modificación o clic en nueva para ingresar uno nuevo.", "Libros", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnAgregaAutor;
    private javax.swing.JButton jBtnAgregaCategoria;
    private javax.swing.JButton jBtnBorrar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnVerTodos;
    private javax.swing.JToggleButton jBtnVolver;
    private javax.swing.JComboBox<Autor> jCboBoxAutor;
    private javax.swing.JComboBox<Categoria> jCboBoxCategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtAnio;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtDisponible;
    private javax.swing.JTextField jTxtTitulo;
    // End of variables declaration//GEN-END:variables

    private void seleccionarAutorEnCombo(Autor autor) {
        for (int i = 0; i < this.jCboBoxAutor.getItemCount(); i++) {
            Autor tmpAutor = (Autor) this.jCboBoxAutor.getItemAt(i);
            if (tmpAutor.getIdautor().equals(autor.getIdautor())) {
                this.jCboBoxAutor.setSelectedIndex(i);
            }
        }
    }

    private void seleccinarCategoriaEnCombo(Categoria categoria) {
        for (int i = 0; i < this.jCboBoxCategoria.getItemCount(); i++) {
            Categoria tmpCategoria = (Categoria) this.jCboBoxCategoria.getItemAt(i);
            if (tmpCategoria.getIdcategoria().equals(categoria.getIdcategoria())) {
                this.jCboBoxCategoria.setSelectedIndex(i);
            }
        }
    }

    private boolean checkAptoBorrar() {
        //chequeo para asegurarnos que la categoria en memoria sea igual a la que se visualiza en pantalla
        if (libro.getIdlibro() != null) {
            if (this.jTxtCodigo.getText().trim().equals(libro.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAptoModificar() {
        //chequeo para saber si es apto para realizar una modificación
        if (libro.getIdlibro() != null) {
            Autor autor = (Autor) this.jCboBoxAutor.getSelectedItem();
            Categoria categoria = (Categoria) this.jCboBoxCategoria.getSelectedItem();

            if (!this.jTxtCodigo.getText().trim().equals(libro.getCodigo()) || !this.jTxtTitulo.getText().trim().equals(libro.getTitulo()) || !this.jTxtAnio.getText().trim().equals(libro.getAnioEdicion().toString()) || !autor.getIdautor().equals(libro.getAutor().getIdautor()) || !categoria.getIdcategoria().equals(libro.getCategoria().getIdcategoria())) {
                if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtTitulo.getText().trim().equals("") && !this.jTxtAnio.getText().trim().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkAptoIngresar() {
        //chequeo para saber si es apto para realizar un nuevo ingreso
        if (libro.getIdlibro() == null) {
            if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtTitulo.getText().trim().equals("") && !this.jTxtAnio.getText().trim().equals("")) {
                return true;
            }
        }
        return false;
    }

    private void cargaDatosDesdeFormulario() {
        libro.setCodigo(this.jTxtCodigo.getText());
        libro.setTitulo(this.jTxtTitulo.getText());
        libro.setAnioEdicion(Integer.valueOf(this.jTxtAnio.getText()));
        if (this.jTxtDisponible.getText().equals("Disponible") || this.jTxtDisponible.getText().equals("")) {
            libro.setDisponible(Boolean.TRUE);
        } else {
            libro.setDisponible(Boolean.FALSE);
        }
        Autor autor = (Autor) this.jCboBoxAutor.getSelectedItem();
        Categoria categoria = (Categoria) this.jCboBoxCategoria.getSelectedItem();
        libro.setAutor(autor);
        libro.setCategoria(categoria);
    }
}