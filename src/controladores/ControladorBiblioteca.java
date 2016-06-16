/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Autor;
import clases.Editorial;
import clases.Ejemplar;
import clases.EstadoLibro;
import clases.Lector;
import clases.Libro;
import clases.Prestamo;
import clases.TipoLibro;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author diego
 */
public class ControladorBiblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<TipoLibro> tiposLibros;
    private Prestamo unPrestamo;
    private ArrayList<EstadoLibro> estadoslibros; 
    private String nombre;
    public ControladorBiblioteca(){
        this.nombre = "Bibliteca";
        this.libros = new ArrayList<>();
        this.tiposLibros = new ArrayList<>();
        this.estadoslibros = new ArrayList<>();
        this.unPrestamo = new Prestamo(30,2);
        this.cargarEstadoLibros();
    }
    
    public void cargarEstadoLibros(){
        this.estadoslibros.add(new EstadoLibro("Biblioteca"));
        this.estadoslibros.add(new EstadoLibro("Domicilio"));
        this.estadoslibros.add(new EstadoLibro("Reparación"));
        
    }

    public ArrayList<TipoLibro> getTiposLibros() {
        return tiposLibros;
    }

    public void setTiposLibros(ArrayList<TipoLibro> tiposLibros) {
        this.tiposLibros = tiposLibros;
    }
       

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    
    public Prestamo getUnPrestamo() {
        return unPrestamo;
    }

    public void setUnPrestamo(Prestamo unPrestamo) {
        this.unPrestamo = unPrestamo;
    }
    
    
    public TipoLibro buscarTipoLibro(String nombre){
        for (TipoLibro unTipoLibro: this.getTiposLibros()){
            if(unTipoLibro.getNombre().equals(nombre)){
                return unTipoLibro;
            }
        }
        return null;
    }
    
    public void agregarTipoLibro(String nombre){
        TipoLibro unTipoLibro = new TipoLibro(nombre);
        this.tiposLibros.add(unTipoLibro);
    }
     
   public void quitarTipoLibro(String nombre){
       TipoLibro unTipoLibro = this.buscarTipoLibro(nombre);
       this.tiposLibros.remove(unTipoLibro);
   }
    
   
  
   
    public void agregarLibro(Integer identificador, String nombre,Integer año, Editorial unEditorial, Autor unAutor,String ISBN, Integer cantidadEjemplares){
        Libro unLibro = new Libro(identificador,nombre,año,unEditorial,unAutor,ISBN,cantidadEjemplares);
        this.libros.add(unLibro);
        Integer i = 1;
        while (i <= cantidadEjemplares){
            unLibro.agregarEjemplar(i, identificador, nombre, año, unEditorial, unAutor, ISBN);
            i++;
        }
        
    }
    
    
    
    public void modificarLibro(Integer identificador, String nombre,Integer año, Editorial unEditorial, Autor unAutor,String ISBN, Integer cantidadEjemplares){
       Libro unLibro = this.buscarLibro(identificador);
       unLibro.setIdentificador(identificador);
       unLibro.setAño(año);
       unLibro.setNombre(nombre);
       unLibro.setUnEditorial(unEditorial);
       unLibro.setUnEditorial(unEditorial);
       unLibro.setISBN(ISBN);
       unLibro.setCantidadEjemplares(cantidadEjemplares);
    }
    public Libro buscarLibro(Integer identificador){
        for (Libro unLibro: this.getLibros()){
            if(unLibro.getIdentificador().equals(identificador)){
                return unLibro;
            }
        }
        return null;
    }
    
    public void quitarLibro(Integer identificador){
        Libro unLibro = this.buscarLibro(identificador);
        this.libros.remove(unLibro);
    }
    
    
    public void controlLibrosLector(Lector unLector, Libro unLibro){
        int cantdias = this.getDiasPrestadoLibro(unLibro);
        if (this.unPrestamo.getCantMaxDias() >= cantdias){
            unLector.setEstadoPrestamo(false);
            int diasRetrasado = cantdias -  this.unPrestamo.getCantMaxDias();
            unLector.setMulta(diasRetrasado * this.unPrestamo.getRetraso() );
        }  
    }
    
    public int getDiasPrestadoLibro(Libro unLibro){
        int cantDiasPrestado = this.diferenciaEnDias(new Date(), unLibro.getFechaPrestado());
        return cantDiasPrestado;
    }
    
    public int diferenciaEnDias(Date fechaActual, Date fechaPrestado) {
        long diferenciaActual = fechaActual.getTime();
        long difrenciaPrestado = fechaPrestado.getTime();     
        long dias = (diferenciaActual -difrenciaPrestado ) / (1000 * 60 * 60 * 24);
        return (int) dias;
    }
    
    
    public Boolean prestarLibroALectorEdad(Lector unLector){
       int edad =  ControladorPersona.calcularEdad(unLector.getFechaNacimiento());
       if (edad <=18){
           return true;
       }
       else
           return false;
    }
       


}
