/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Lector extends Persona{
    private ArrayList<Libro> libros;
    private Boolean estadoPrestamo;
    private Integer multa;
    private Boolean esMenor; 
    public Lector(Integer id,String nombre, String apellido, String telefono, Date fechaNacimiento, String email,String nacionalidad) {
        super(id,nombre, apellido, telefono, fechaNacimiento, email,nacionalidad);
        this.libros = new ArrayList<>();
        this.estadoPrestamo = true; // Si no supera los dos 30 dias del prestamo se mantiene en true
        this.multa = 0;
        this.esMenor = false;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public Boolean getEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(Boolean estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public Integer getMulta() {
        return multa;
    }

    public void setMulta(Integer multa) {
        this.multa = multa;
    }

    
    public Boolean agregarLibro(Libro unLibro){
        if (this.libros.size() < 3){
            
            this.libros.add(unLibro);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void quitarLibro(Libro unLibro){
        this.libros.remove(unLibro);
    }

    

    
}
