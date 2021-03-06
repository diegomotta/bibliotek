/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.Autor;
import clases.Libro;
import controladores.ControladorPrincipal;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author diego
 */
public class CRUDAutor extends javax.swing.JPanel {
    private ControladorPrincipal controladorPrincipal;
    /**
     * Creates new form CRUDAutor
     */
    public CRUDAutor(ControladorPrincipal controladorPrincipal,javax.swing.JPanel pnl_Cuerpo ) {
        this.controladorPrincipal = controladorPrincipal;
        this.pnl_Cuerpo = pnl_Cuerpo;
        initComponents();
        this.cargarTablaAutor(jTable1,this.controladorPrincipal.getControladorPersona().getAutores());
    }
    public  void limpiar_tabla(javax.swing.JTable  tabla) 
    {
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            ((DefaultTableModel) tabla.getModel()).removeRow(0);
        }
    } 
   

    public void cargarTablaAutor(JTable tabla, ArrayList lista){
        limpiar_tabla(tabla);
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();   
        JTableHeader th; 
        th = tabla.getTableHeader(); 
        Font fuente = new Font("Tahoma", Font.BOLD, 12); 
        th.setForeground(java.awt.Color.BLACK);
        th.setBackground(java.awt.Color.white);
        th.setFont(fuente);    

        Autor aux = null;
        Iterator iter = lista.iterator();
        while (iter.hasNext()){
            aux = (Autor)iter.next();
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
        pnl_Cuerpo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_opcionesHabitacion = new javax.swing.JButton();
        btn_opcionesPileta = new javax.swing.JButton();
        btn_opcionesSalon = new javax.swing.JButton();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_Cuerpo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnl_Cuerpo.setLayout(new javax.swing.BoxLayout(pnl_Cuerpo, javax.swing.BoxLayout.LINE_AXIS));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre y Apellido", "Email", "Fecha de Nacimiento", "Nacionalidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pnl_Cuerpo.add(jScrollPane1);

        jPanel1.add(pnl_Cuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 481, 400));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel2.setLayout(new java.awt.GridLayout(6, 1));

        btn_opcionesHabitacion.setText("<html><p>Nuevo</p></html>");
        btn_opcionesHabitacion.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_opcionesHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opcionesHabitacionActionPerformed(evt);
            }
        });
        jPanel2.add(btn_opcionesHabitacion);

        btn_opcionesPileta.setText("<html><p>Modificar</p></html>");
        btn_opcionesPileta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_opcionesPileta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opcionesPiletaActionPerformed(evt);
            }
        });
        jPanel2.add(btn_opcionesPileta);

        btn_opcionesSalon.setText("Eliminar");
        btn_opcionesSalon.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_opcionesSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opcionesSalonActionPerformed(evt);
            }
        });
        jPanel2.add(btn_opcionesSalon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_opcionesHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opcionesHabitacionActionPerformed
        FormAutor formAutor = new FormAutor(controladorPrincipal, jTable1,pnl_Cuerpo, null);
        pnl_Cuerpo.removeAll();
        pnl_Cuerpo.add(formAutor);
        pnl_Cuerpo.updateUI();
    }//GEN-LAST:event_btn_opcionesHabitacionActionPerformed

    private void btn_opcionesPiletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opcionesPiletaActionPerformed
        //        Parametros_Pileta losParametros = new Parametros_Pileta(unaHosteria.getPileta());
        if(this.jTable1.getSelectedRow()!=-1)
        {
            int fila = this.jTable1.getSelectedRow();
            Integer unAutorSeleccionado = (Integer) this.jTable1.getValueAt(fila, 0);
            Autor unAutor =  this.controladorPrincipal.getControladorPersona().buscarAutor(unAutorSeleccionado);
            FormLector lectorForm = new FormLector(controladorPrincipal, jTable1,pnl_Cuerpo, unAutorSeleccionado);
            pnl_Cuerpo.removeAll();
            pnl_Cuerpo.add(lectorForm);
            pnl_Cuerpo.updateUI();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No ha seleccionado un Lector"," ",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_opcionesPiletaActionPerformed

    private void btn_opcionesSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opcionesSalonActionPerformed
        //      Parametros_Salon parSal = new Parametros_Salon(unaHosteria);
    }//GEN-LAST:event_btn_opcionesSalonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_opcionesHabitacion;
    private javax.swing.JButton btn_opcionesPileta;
    private javax.swing.JButton btn_opcionesSalon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnl_Cuerpo;
    // End of variables declaration//GEN-END:variables
}
