/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Empleado;
import clases.Lector;
import controladores.ControladorPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author diego
 */
public class FormEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form FormEmpleado
     */
    
    private ControladorPrincipal controladorPrincipal;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel  pnl_Cuerpo;
    private Integer idEmpleado;
    public FormEmpleado(ControladorPrincipal controladorPrincipal,javax.swing.JTable jTable1, javax.swing.JPanel  pnl_Cuerpo, Integer idEmpleado) {
        this.controladorPrincipal = controladorPrincipal;
        this.jTable1 = jTable1;
        this.pnl_Cuerpo = pnl_Cuerpo;
        this.idEmpleado = idEmpleado;
        initComponents();
        if (this.idEmpleado == null){
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
        }
        else{
             btnModificar.setEnabled(true);
             btnGuardar.setEnabled(false);
             this.cargarDatos(idEmpleado);
        }
    }

    
    public  void limpiar_tabla(javax.swing.JTable  tabla) 
    {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    } 
   

    public javax.swing.JScrollPane  cargarTablaEmpleado(JTable tabla, ArrayList lista){
      limpiar_tabla(tabla);
      
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();   
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Tahoma", Font.BOLD, 12); 
        th.setForeground(java.awt.Color.BLACK);
        th.setBackground(java.awt.Color.white);
        th.setFont(fuente);    

        Empleado aux = null;
        Iterator iter = lista.iterator();
        while (iter.hasNext()){
            aux = (Empleado)iter.next();
            Object [] fila = new Object[6];
            fila[0] = aux.getId();
            fila[1] = aux.getNombre()+ " " + aux.getApellido();
            fila[2] = aux.getEmail();
            fila[3] = aux.getFechaNacimiento();
            fila[4] = aux.getNacionalidad();
            fila[5] = aux.getUsuario();
            modelo.addRow(fila);
        }
        modelo.rowsRemoved(null);    
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        javax.swing.JScrollPane  jScrollPane1 = new javax.swing.JScrollPane(tabla);
        return jScrollPane1;
    }
    
    
    public void cargarDatos(Integer Idlector){
        Empleado unEmpleado = this.controladorPrincipal.getControladorPersona().buscarEmpleado(idEmpleado);
        txtDni.setText(unEmpleado.getId().toString());
        txtNombre.setText(unEmpleado.getNombre());
        txtApellido.setText(unEmpleado.getApellido());
        dateFechaNacimiento.setDate(unEmpleado.getFechaNacimiento());
        txtEmail.setText(unEmpleado.getEmail()); 
        cmbNacionalidad.setSelectedItem(unEmpleado.getNacionalidad());
        txtUsuario.setText(unEmpleado.getUsuario());
        txtContrasenia.setText(unEmpleado.getContraseña());
    }
    
    public void agregarEmpleado(){
        Integer id = Integer.valueOf(txtDni.getText());
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        Date fechaNacimiento = dateFechaNacimiento.getDate();
        String email = txtEmail.getText(); 
        String nacionalidad =cmbNacionalidad.getSelectedItem().toString() ;
        String usuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        this.controladorPrincipal.getControladorPersona().agregarEmpleado(id, nombre, apellido, apellido, fechaNacimiento, email, nacionalidad,contrasenia,usuario);
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEmpleado(this.jTable1,this.controladorPrincipal.getControladorPersona().getEmpleados());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();    
    }
    public void modificarEmpleado(){
        this.controladorPrincipal.getControladorPersona().modificarEmpleado(this.idEmpleado, Integer.valueOf(txtDni.getText()),txtNombre.getText(),txtApellido.getText(),dateFechaNacimiento.getDate(),txtEmail.getText(),cmbNacionalidad.getSelectedItem().toString(),txtContrasenia.getText(),txtUsuario.getText());
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEmpleado(this.jTable1,this.controladorPrincipal.getControladorPersona().getEmpleados());
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

        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbNacionalidad = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        txtContrasenia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Check.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Guardar_2.png"))); // NOI18N
        btnModificar.setText("Actualizar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, 40));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Close.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Legajo del empleado"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Apellido");

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
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtNombre))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDni, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtApellido)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbNacionalidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 450, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Usuario"));

        label1.setText("Usuario");

        jLabel7.setText("Contreseña");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                    .addComponent(txtUsuario))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 225, 450, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.agregarEmpleado();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        this.modificarEmpleado();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaEmpleado(this.jTable1,this.controladorPrincipal.getControladorPersona().getEmpleados());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();
    }//GEN-LAST:event_btnCancelarActionPerformed


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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
