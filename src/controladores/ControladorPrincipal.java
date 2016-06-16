/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Autor;
import clases.Editorial;
import clases.Empleado;
import clases.EstadoLibro;
import clases.Lector;
import clases.Libro;
import clases.Prestamo;
import clases.TipoLibro;
import java.awt.Window;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import vistas.Acceso;

/**
 *
 * @author diego
 */
public class ControladorPrincipal {
    private ControladorEditorial controlEditorial;
    private ControladorPersona controladorPersona;
    private ControladorBiblioteca controladorLibro;
    public ControladorPrincipal() {
        this.controlEditorial = new ControladorEditorial();
        this.controladorPersona = new ControladorPersona();
        this.controladorLibro = new ControladorBiblioteca();
               
    }

    public ControladorEditorial getControlEditorial() {
        return controlEditorial;
    }



    public ControladorPersona getControladorPersona() {
        return controladorPersona;
    }


    public ControladorBiblioteca getControladorLibro() {
        return controladorLibro;
    }

    
    public void abrirVistaLogueo(){
                
            Acceso acceso = new Acceso(this);
            acceso.setLocationRelativeTo(null);
            acceso.setVisible(true);
    }



}
