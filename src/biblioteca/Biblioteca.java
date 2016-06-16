/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import controladores.ControladorPrincipal;
import java.util.Calendar;
import java.util.Date;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author diego
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static ControladorPrincipal unControladorPrincipal;
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        // TODO code application logic here
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); 
        ControladorPrincipal sistema = new ControladorPrincipal();
        Biblioteca.unControladorPrincipal = sistema;
        sistema.getControladorPersona().agregarEmpleado(35456351, "Diego", "Motta", "454638",  new Date(2014, 02, 11),"diegomotta18@gmail.com", "Argentina","metallica","diegomotta");
        //sistema.abrirVistaPrincipal();
        
       
        sistema.abrirVistaLogueo();
    }
    
    public static ControladorPrincipal getControladorPrincipal() {
        return unControladorPrincipal;
    }

    
}
