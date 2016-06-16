/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Autor;
import clases.Editorial;
import clases.Lector;
import clases.Libro;
import controladores.ControladorPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author diego
 */
public class FormLibro extends javax.swing.JPanel {
    private ControladorPrincipal controladorPrincipal;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel  pnl_Cuerpo;
    private Integer idLibro;
    private javax.swing.JPanel subPanelPrincipal;
    /**
     * Creates new form FormLibro
     */
    public FormLibro(ControladorPrincipal controladorPrincipal,javax.swing.JTable jTable1,javax.swing.JPanel  pnl_Cuerpo,Integer idLibro,javax.swing.JPanel subPanelPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        this.jTable1 = jTable1;
        this.pnl_Cuerpo = pnl_Cuerpo;
        this.idLibro = idLibro;
        this.subPanelPrincipal = subPanelPrincipal; 
        initComponents();
        this.cargarComboEditorial();
        this.cargarComboAutor();
        if (this.idLibro == null){
            btnModificar.setEnabled(false);
            btnGuardar.setEnabled(true);
        }
        else{
             btnModificar.setEnabled(true);
             btnGuardar.setEnabled(false);
             this.cargarDatos(this.idLibro);
        }
    }
    
    public void cargarComboEditorial(){
        cmbEditorial.removeAllItems();
        ArrayList editoriales = this.controladorPrincipal.getControlEditorial().getEditoriales();
        if(editoriales != null)
        {
            Editorial aux = null;
            Iterator iter = editoriales.iterator();
            while (iter.hasNext())
            {
                aux = (Editorial) iter.next();
                cmbEditorial.addItem(aux.getNombre());
            }
        }
    }
    
    public void cargarComboAutor(){
        cmbAutor.removeAllItems();
        ArrayList autores = this.controladorPrincipal.getControladorPersona().getAutores();
        if(autores != null)
        {
            Autor aux = null;
            Iterator iter = autores.iterator();
            while (iter.hasNext())
            {
                aux = (Autor) iter.next();
                cmbAutor.addItem(aux.getNombre());
            }
        }        
    }
    
    public void cargarDatos(Integer idLibro){
        Libro unLibro = this.controladorPrincipal.getControladorLibro().buscarLibro(idLibro);
        txtIdentificador.setText(String.valueOf(unLibro.getIdentificador()));
        txtNombre.setText(unLibro.getNombre());
        txtAño.setText(String.valueOf(unLibro.getAño()));
        cmbEditorial.setSelectedItem(unLibro.getUnEditorial().getNombre());
        cmbAutor.setSelectedItem(unLibro.getUnAutor().getNombre());
        txtCantEjemplares.setText(String.valueOf(unLibro.getCantidadEjemplares()));
        txtISBN.setText(unLibro.getISBN());
    }
    
        public  void limpiar_tabla(javax.swing.JTable  tabla) 
    {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    } 
   

    public javax.swing.JScrollPane  cargarTablaLibro(JTable tabla, ArrayList lista){
      limpiar_tabla(tabla);
      
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();   
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Tahoma", Font.BOLD, 12); 
        th.setForeground(java.awt.Color.BLACK);
        th.setBackground(java.awt.Color.white);
        th.setFont(fuente);    

        Libro aux = null;
        Iterator iter = lista.iterator();
        while (iter.hasNext()){
            aux = (Libro)iter.next();
            Object [] fila = new Object[6];
            fila[0] = aux.getIdentificador();
            fila[1] = aux.getNombre();
            fila[2] = aux.getISBN();
            fila[3] = aux.getAño();
            fila[4] = aux.getUnEditorial().getNombre();
            fila[5] = aux.getUnAutor().getNombre();
            modelo.addRow(fila);
        }
        modelo.rowsRemoved(null);    
        tabla.setModel(modelo);
        modelo.fireTableDataChanged();
        javax.swing.JScrollPane  jScrollPane1 = new javax.swing.JScrollPane(tabla);
        return jScrollPane1;
    }
    
    public void agregarLibro(){
        Integer identificador = Integer.valueOf(txtIdentificador.getText());
        String nombre = txtNombre.getText();
        String ISBN = txtISBN.getText();
        Integer año = Integer.valueOf(txtAño.getText());
        Editorial unEditorial =(Editorial) this.controladorPrincipal.getControlEditorial().buscarEditorial(cmbEditorial.getSelectedItem().toString()); 
        Autor unAutor = (Autor) this.controladorPrincipal.getControladorPersona().buscarAutor(cmbAutor.getSelectedItem().toString());
        Integer cantidadEjemplares = Integer.valueOf(txtCantEjemplares.getText());
        this.controladorPrincipal.getControladorLibro().agregarLibro(identificador, nombre, año, unEditorial, unAutor, ISBN,cantidadEjemplares); 
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLibro(this.jTable1,this.controladorPrincipal.getControladorLibro().getLibros());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();            
    }
    
    public void modificarLibro(){
        this.controladorPrincipal.getControladorLibro().modificarLibro(this.idLibro, txtNombre.getText(),Integer.valueOf(txtAño.getText()),this.controladorPrincipal.getControlEditorial().buscarEditorial(cmbEditorial.getSelectedItem().toString()),this.controladorPrincipal.getControladorPersona().buscarAutor(cmbAutor.getSelectedItem().toString()),txtISBN.getText(),Integer.valueOf(txtCantEjemplares.getText()));
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLibro(this.jTable1,this.controladorPrincipal.getControladorLibro().getLibros());
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
        jLabel6 = new javax.swing.JLabel();
        txtCantEjemplares = new javax.swing.JTextField();
        cmbAutor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAutor = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbEditorial = new javax.swing.JComboBox<>();
        btnEditorial = new javax.swing.JButton();
        txtAño = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "Datos del Libro"));

        jLabel6.setText("Cantidad ejemplares");

        cmbAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Autor");

        btnAutor.setText("...");

        jLabel5.setText("Editorial");

        cmbEditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEditorial.setText("...");
        btnEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditorialActionPerformed(evt);
            }
        });

        jLabel3.setText("Año");

        jLabel2.setText("ISBN");

        jLabel7.setText("Nombre");

        jLabel1.setText("Identificador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantEjemplares))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAño)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbAutor, 0, 278, Short.MAX_VALUE)
                                    .addComponent(cmbEditorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtISBN)
                            .addComponent(txtNombre)
                            .addComponent(txtIdentificador))))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtCantEjemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnModificar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
         this.agregarLibro();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        this.modificarLibro();

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        javax.swing.JScrollPane   jScrollPane1 = cargarTablaLibro(this.jTable1,this.controladorPrincipal.getControladorPersona().getLectores());
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(jScrollPane1);
        pnl_Cuerpo.updateUI();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditorialActionPerformed
        // TODO add your handling code here:
        CRUDEditorial editorial = new CRUDEditorial(this.controladorPrincipal,this.subPanelPrincipal);
        subPanelPrincipal.removeAll();
        subPanelPrincipal.add(editorial);
        subPanelPrincipal.updateUI();        
    }//GEN-LAST:event_btnEditorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditorial;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbAutor;
    private javax.swing.JComboBox<String> cmbEditorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtCantEjemplares;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
