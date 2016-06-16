/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Editorial;
import clases.Empleado;
import controladores.ControladorPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author diego
 */
public class FormEditorial extends javax.swing.JPanel {
    private ControladorPrincipal controladorPrincipal;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel  pnl_Cuerpo;
    private Integer idEditorial;
    /**
     * Creates new form FormEditorial
     */
    public FormEditorial(ControladorPrincipal controladorPrincipal,javax.swing.JTable jTable1,javax.swing.JPanel  pnl_Cuerpo,Integer idEditorial) {
        this.controladorPrincipal = controladorPrincipal;
        this.jTable1 = jTable1;
        this.pnl_Cuerpo = pnl_Cuerpo;
        this.idEditorial = idEditorial;
        initComponents();
        if (this.idEditorial == null){
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
        }
        else{
             btnModificar.setEnabled(true);
             btnGuardar.setEnabled(false);
             this.cargarDatos(idEditorial);
        }
    }

    public void cargarDatos(Integer IdEditorial){
        Editorial unEditorial = this.controladorPrincipal.getControlEditorial().buscarEditorial(idEditorial);
        txtID.setText(unEditorial.getId().toString());
        txtNombre.setText(unEditorial.getNombre());

    }
    public  void limpiar_tabla(javax.swing.JTable  tabla) 
    {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    } 
   

    public javax.swing.JScrollPane  cargarTablaEditorial(JTable tabla, ArrayList lista){
      limpiar_tabla(tabla);
      
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();   
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Tahoma", Font.BOLD, 12); 
        th.setForeground(java.awt.Color.BLACK);
        th.setBackground(java.awt.Color.white);
        th.setFont(fuente);    

        Editorial aux = null;
        Iterator iter = lista.iterator();
        while (iter.hasNext()){
            aux = (Editorial)iter.next();
            Object [] fila = new Object[2];
            fila[0] = aux.getId();
            fila[1] = aux.getNombre();
            modelo.addRow(fila);
        }
        modelo.rowsRemoved(null);    
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        javax.swing.JScrollPane  jScrollPane1 = new javax.swing.JScrollPane(tabla);
        return jScrollPane1;
    }
    
    
    public void agregarEditorial(){
        Integer id = Integer.valueOf(txtID.getText());
        String nombre = txtNombre.getText();
        this.controladorPrincipal.getControlEditorial().agregarEditorial(id, nombre);
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEditorial(this.jTable1,this.controladorPrincipal.getControlEditorial().getEditoriales());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();    
    }
    
    public void modificarEditorial(){
        this.controladorPrincipal.getControlEditorial().modificarEditorial(Integer.valueOf(txtID.getText()), txtNombre.getText());
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEditorial(this.jTable1,this.controladorPrincipal.getControlEditorial().getEditoriales());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();   
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos de la editorial"));

        jLabel1.setText("ID");

        jLabel2.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID)
                    .addComponent(txtNombre))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Check.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Guardar_2.png"))); // NOI18N
        btnModificar.setText("Actualizar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.agregarEditorial();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        this.modificarEditorial();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEditorial(this.jTable1,this.controladorPrincipal.getControladorPersona().getLectores());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}