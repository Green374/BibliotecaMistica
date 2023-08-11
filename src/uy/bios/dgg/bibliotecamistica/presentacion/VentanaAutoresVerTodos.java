/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uy.bios.dgg.bibliotecamistica.presentacion;

import javax.swing.DefaultListModel;
import uy.bios.dgg.bibliotecamistica.excepciones.AutorException;
import uy.bios.dgg.bibliotecamistica.logica.Autor;
import uy.bios.dgg.bibliotecamistica.logica.Autores;
import uy.bios.dgg.bibliotecamistica.logica.Categoria;
import uy.bios.dgg.bibliotecamistica.logica.FachadaLogica;

/**
 *
 * @author DGG
 */
public class VentanaAutoresVerTodos extends javax.swing.JFrame {

    private final VentanaAutores ventanaAnterior;
    private final DefaultListModel modelo = new DefaultListModel();
    /**
     * Creates new form VentanaAutoresVerTodas
     */
    public VentanaAutoresVerTodos(VentanaAutores ventana) {
        initComponents();
        this.ventanaAnterior = ventana;
        this.jLstAutores.setModel(modelo);
        cargarListaAutores();
    }

    private void volver() {
        ventanaAnterior.setVisible(true);
        this.dispose();
    }
    
    private void cargarListaAutores(){
        FachadaLogica fachadaLogica = new FachadaLogica();
        Autores autores;
        modelo.clear();
        try {
            autores = fachadaLogica.obtenerAutores();
            for(int i=0; i< autores.getAutores().size(); i++){
                modelo.addElement(autores.getAutores().get(i));
            }
            this.jLblRegistros.setText("Registros: " + this.modelo.getSize());
            
        } catch (AutorException ex) {
            System.out.println("error");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBtnVolver = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLstAutores = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLblRegistros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Autores");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jBtnVolver.setText("Volver");
        jBtnVolver.setToolTipText("Vuelve al menú principal");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        jLstAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLstAutoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jLstAutores);

        jLabel1.setText("Código, nombre, apellido y nacionalidad");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uy/bios/dgg/bibliotecamistica/imagenes/iconsUsuarioMaquina48.png"))); // NOI18N
        jLabel9.setText(" Listado de todos los autores.");

        jLblRegistros.setText("Registros: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLblRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnVolver))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnVolver)
                    .addComponent(jLblRegistros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVolverActionPerformed
        this.volver();
    }//GEN-LAST:event_jBtnVolverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.volver();
    }//GEN-LAST:event_formWindowClosing

    private void jLstAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLstAutoresMouseClicked
        if (evt.getClickCount() == 2 && evt.getButton()==1){
            if (modelo.getSize()>0){
                Autor autor;
                autor = (Autor) modelo.getElementAt(this.jLstAutores.getSelectedIndex());
                ventanaAnterior.setYmostrarAutor(autor);
                this.volver();
            }
        }
    }//GEN-LAST:event_jLstAutoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton jBtnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLblRegistros;
    private javax.swing.JList<Categoria> jLstAutores;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}