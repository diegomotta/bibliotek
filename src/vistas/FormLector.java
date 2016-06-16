/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Lector;
import controladores.ControladorPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author diego
 */
public class FormLector  extends javax.swing.JPanel {
    private ControladorPrincipal controladorPrincipal;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel  pnl_Cuerpo;
    private Integer Idlector;
    /**
     * Creates new form CRUDLector
     * @param controladorPrincipal
     * @param jTable1
     * @param JPanel
     */
    public FormLector(ControladorPrincipal controladorPrincipal,javax.swing.JTable jTable1, javax.swing.JPanel  pnl_Cuerpo, Integer Idlector) {
        this.controladorPrincipal = controladorPrincipal;
        this.jTable1 = jTable1;
        this.pnl_Cuerpo = pnl_Cuerpo;
        this.Idlector = Idlector;

        initComponents();
        if (this.Idlector == null){
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
        }
        else{
             btnModificar.setEnabled(true);
             btnGuardar.setEnabled(false);
             this.cargarDatos(Idlector);
        }
    }


    
    public  void limpiar_tabla(javax.swing.JTable  tabla) 
    {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    } 
   

    public javax.swing.JScrollPane  cargarTablaLector(JTable tabla, ArrayList lista){
      limpiar_tabla(tabla);
      
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();   
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Tahoma", Font.BOLD, 12); 
        th.setForeground(java.awt.Color.BLACK);
        th.setBackground(java.awt.Color.white);
        th.setFont(fuente);    

        Lector aux = null;
        Iterator iter = lista.iterator();
        while (iter.hasNext()){
            aux = (Lector)iter.next();
            Object [] fila = new Object[5];
            fila[0] = aux.getId();
            fila[1] = aux.getNombre()+ " " + aux.getApellido();
            fila[2] = aux.getEmail();
            fila[3] = aux.getFechaNacimiento();
            fila[4] = aux.getNacionalidad();
            modelo.addRow(fila);
        }
        modelo.rowsRemoved(null);    
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        javax.swing.JScrollPane  jScrollPane1 = new javax.swing.JScrollPane(tabla);
        return jScrollPane1;
    }
    
    public ControladorPrincipal getControladorPrincipal() {
        return controladorPrincipal;
    }

    public void setControladorPrincipal(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
    }

    
    public void agregarLector(){
        Integer id = Integer.valueOf(txtDni.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        Date fechaNacimiento = dateFechaNacimiento.getDate();
        String email = txtEmail.getText(); 
        String nacionalidad =cmbNacionalidad.getSelectedItem().toString() ;
        this.controladorPrincipal.getControladorPersona().agregarLector(id, nombre, apellido, apellido, fechaNacimiento, email, nacionalidad);
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLector(this.jTable1,this.controladorPrincipal.getControladorPersona().getLectores());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();
    }
    
    public void modificarLector(){
        this.controladorPrincipal.getControladorPersona().modificarLector(this.Idlector, Integer.valueOf(txtDni.getText()),txtNombre.getText(),txtApellido.getText(),dateFechaNacimiento.getDate(),txtEmail.getText(),cmbNacionalidad.getSelectedItem().toString());
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLector(this.jTable1,this.controladorPrincipal.getControladorPersona().getLectores());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();    
    }
    
    public void cargarDatos(Integer Idlector){
        Lector unLector = this.controladorPrincipal.getControladorPersona().buscarLector(Idlector);
        txtDni.setText(unLector.getId().toString());
        txtNombre.setText(unLector.getNombre());
        txtApellido.setText(unLector.getApellido());
        dateFechaNacimiento.setDate(unLector.getFechaNacimiento());
        txtEmail.setText(unLector.getEmail()); 
        cmbNacionalidad.setSelectedItem(unLector.getNacionalidad());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbNacionalidad = new javax.swing.JComboBox<>();

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Check.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Guardar_2.png"))); // NOI18N
        btnModificar.setText("Actualizar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos del Lector"));

        jLabel2.setText("Apellido");

        jLabel1.setText("Nombre");

        jLabel6.setText("DNI N°");

        jLabel3.setText("Fecha de nacimiento");

        jLabel4.setText("Email");

        jLabel5.setText("Nacionalidad");

        cmbNacionalidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Argentino", "Brasilero", "Chileno", "Mexicano" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(cmbNacionalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDni, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtApellido)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.agregarLector();

         
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLector(this.jTable1,this.controladorPrincipal.getControladorPersona().getLectores());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        
       this.modificarLector();
        
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbNacionalidad;
    private com.toedter.calendar.JDateChooser dateFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
