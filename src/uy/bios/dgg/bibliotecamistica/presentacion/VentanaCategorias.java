/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.presentacion;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import uy.bios.dgg.bibliotecamistica.excepciones.CategoriaException;
import uy.bios.dgg.bibliotecamistica.logica.Categoria;
import uy.bios.dgg.bibliotecamistica.logica.Categorias;
import uy.bios.dgg.bibliotecamistica.logica.FachadaLogica;

/**
 *
 * @author DGG
 */
public class VentanaCategorias extends JFrame {

    private final int MAX_LARGO_TEXTO = 45;
    private final JFrame ventanaAnterior;
    private JComboBox combo;
    private final FachadaLogica fachadaLogica = new FachadaLogica();
    private Categoria categoria = new Categoria();

    /**
     * Creates new form VentanaSocios
     *
     * @param ventana
     */
    public VentanaCategorias(JFrame ventana) {
        initComponents();
        ventanaAnterior = ventana;
        limpiarFormulario();
    }

    public VentanaCategorias(JFrame ventana, JComboBox combo) {
        initComponents();
        ventanaAnterior = ventana;
        this.combo = combo;
        limpiarFormulario();
    }

    private void volver() {
        if (this.ventanaAnterior.getName().equals("frameLibros")) {
            refrescaCombo();
        }
        ventanaAnterior.setVisible(true);
        this.dispose();
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
        jTxtCodigo = new javax.swing.JTextField();
        jTxtDescripcion = new javax.swing.JTextField();
        jBtnBuscar = new javax.swing.JButton();
        jBtnVolver = new javax.swing.JToggleButton();
        jBtnNueva = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();
        jBtnBorrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jBtnVerTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Categorias");
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

        jLabel3.setText("Descripción:");

        jTxtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCodigoKeyTyped(evt);
            }
        });

        jTxtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtDescripcionKeyTyped(evt);
            }
        });

        jBtnBuscar.setText("Buscar");
        jBtnBuscar.setToolTipText("Busca una categoría por el código ingresado");
        jBtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBuscarActionPerformed(evt);
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
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTxtCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTxtDescripcion))
                .addContainerGap())
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
                    .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnVolver.setText("Volver");
        jBtnVolver.setToolTipText("Vuelve al menú principal");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        jBtnNueva.setText("Nueva");
        jBtnNueva.setToolTipText("Limpia la panatalla para una nueva categoría.");
        jBtnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevaActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.setToolTipText("Actualiza la categoría actual o inserta una nueva.");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jBtnBorrar.setText("Borrar");
        jBtnBorrar.setToolTipText("Borra la categoría actual.");
        jBtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBorrarActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uy/bios/dgg/bibliotecamistica/imagenes/iconsCategorizar48.png"))); // NOI18N
        jLabel9.setText(" Altas, bajas y modificaciones de categorías.");

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
                        .addComponent(jBtnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnVerTodos))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jBtnNueva)
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

    private void jTxtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtDescripcionKeyTyped
        //Controlamos que no supere el largo del campo de la BD
        if (jTxtDescripcion.getText().length() == MAX_LARGO_TEXTO)
            evt.consume();
    }//GEN-LAST:event_jTxtDescripcionKeyTyped

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
        VentanaCategoriasVerTodas ventana = new VentanaCategoriasVerTodas(this); //Creo ventanaCategorias y le paso el menu como parametro para poder volver al menu
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBtnVerTodosActionPerformed

    private void jBtnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevaActionPerformed
        limpiarFormulario();
        this.categoria = new Categoria();
    }//GEN-LAST:event_jBtnNuevaActionPerformed

    private void jBtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarActionPerformed
        if (!this.jTxtCodigo.getText().trim().equals("")) {
            try {
                String codigo = this.jTxtCodigo.getText().trim();
                categoria = fachadaLogica.obtenerCategoria(codigo);
                if (categoria.getIdcategoria() == null) {
                    JOptionPane.showMessageDialog(null, "No se encontró una categoría con el código ingresado.", "Resultado de la búsqueda", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    mostrarCategoria();
                }
            } catch (CategoriaException ex) {
                JOptionPane.showMessageDialog(null, ex, "Atención", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBtnBuscarActionPerformed

    private void jBtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBorrarActionPerformed
        if (checkAptoBorrar()) {
            try {
                if (JOptionPane.showConfirmDialog(null, "¿Confirma el borrado de la categoria " + categoria + "?", "Atención", JOptionPane.YES_NO_OPTION) == 0) {
                    fachadaLogica.borrarCategoria(categoria);
                    this.limpiarFormulario();
                    JOptionPane.showMessageDialog(null, "La categoría " + categoria + " se borró correctamente.", "Baja de categoría", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (CategoriaException ex) {
                JOptionPane.showMessageDialog(null, ex, "Atención", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo borrar ninguna categoría. \n Por favor seleccione una y vuelva a intentarlo.", "Baja de categoría", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnBorrarActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        if (checkAptoModificar()) {
            cargaDatosDesdeFormulario();
            try {
                if (JOptionPane.showConfirmDialog(null, "¿Confirma la modificación de la categoria " + categoria + "?", "Atención", JOptionPane.YES_NO_OPTION) == 0) {
                    fachadaLogica.modificarCategoria(categoria);
                    JOptionPane.showMessageDialog(null, "La modificación se realizó correctamente.", "Categorías", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (CategoriaException ex) {
                JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Categorías", JOptionPane.WARNING_MESSAGE);
            }
        } else if (checkAptoIngresar()) {
            cargaDatosDesdeFormulario();
            try {
                fachadaLogica.ingresarCategoria(categoria);
                JOptionPane.showMessageDialog(null, "El alta se realizó correctamente.", "Categorías", JOptionPane.INFORMATION_MESSAGE);
            } catch (CategoriaException ex) {
                JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Categorías", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo realizar ninguna tarea con categorías. \n Por favor seleccione una para su modificación o clic en nueva para ingresar una nueva.", "Categorías", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnBorrar;
    private javax.swing.JButton jBtnBuscar;
    private javax.swing.JButton jBtnNueva;
    private javax.swing.JButton jBtnVerTodos;
    private javax.swing.JToggleButton jBtnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtDescripcion;
    // End of variables declaration//GEN-END:variables

    private void limpiarFormulario() {
        this.jTxtCodigo.setText("");
        this.jTxtDescripcion.setText("");
    }

    private void mostrarCategoria() {
        this.jTxtCodigo.setText(categoria.getCodigo());
        this.jTxtDescripcion.setText(categoria.getDescripcion());
    }

    public void setYmostrarCategoria(Categoria categoria) {
        this.categoria = categoria;
        mostrarCategoria();
    }

    private boolean checkAptoBorrar() {
        //chequeo para asegurarnos que la categoria en memoria sea igual a la que se visualiza en pantalla
        if (categoria.getIdcategoria() != null) {
            if (this.jTxtCodigo.getText().trim().equals(categoria.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAptoModificar() {
        //chequeo para saber si es apto para realizar una modificación
        if (categoria.getIdcategoria() != null) {
            if (!this.jTxtCodigo.getText().trim().equals(categoria.getCodigo()) || !this.jTxtDescripcion.getText().trim().equals(categoria.getDescripcion())) {
                if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtDescripcion.getText().trim().equals("")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkAptoIngresar() {
        //chequeo para saber si es apto para realizar un nuevo ingreso
        if (categoria.getIdcategoria() == null) {
            if (!this.jTxtCodigo.getText().trim().equals("") && !this.jTxtDescripcion.getText().trim().equals("")) {
                return true;
            }
        }
        return false;
    }

    private void cargaDatosDesdeFormulario() {
        categoria.setCodigo(this.jTxtCodigo.getText());
        categoria.setDescripcion(this.jTxtDescripcion.getText());
    }

    private void refrescaCombo() {
        Categorias categorias;
        this.combo.removeAllItems();
        try {
            categorias = fachadaLogica.obtenerCategorias();
            for (int i = 0; i < categorias.getCategorias().size(); i++) {
                this.combo.addItem(categorias.getCategorias().get(i));
                if (categorias.getCategorias().get(i).getIdcategoria().equals(this.categoria.getIdcategoria())){ //si es el autor actual lo selecciono
                    this.combo.setSelectedIndex(i);
                }
            }
        } catch (CategoriaException ex) {
            JOptionPane.showMessageDialog(null, "Atención: \n" + ex, "Libros", JOptionPane.WARNING_MESSAGE);
        }
    }
}
