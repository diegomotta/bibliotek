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
public class Libro {
    private Integer identificador;
    private String nombre;
    private Integer año;
    private Editorial unEditorial;
    private Autor unAutor;
    private String estado;
    private ArrayList<HistorialReparacion> historialReparacion;
    private Integer diasPrestado;
    private Date fechaPrestado;
    private String ISBN;
    private Integer cantidadEjemplares;
    private ArrayList<Ejemplar> ejemplares;
    
    public Libro(Integer identificador, String nombre,Integer año, Editorial unEditorial, Autor unAutor, String ISBN,Integer cantidadEjemplares){
        this.identificador= identificador;
        this.nombre = nombre;
        this.año =año;
        this.unAutor = unAutor;
        this.unEditorial = unEditorial;
        this.estado = estado; // se modifica con el set de manera interna
        this.historialReparacion = new ArrayList<>();
        this.diasPrestado = diasPrestado;
        this.fechaPrestado = fechaPrestado;
        this.ISBN = ISBN;
        this.cantidadEjemplares = cantidadEjemplares;
        this.ejemplares = new ArrayList<>();
    }

    public Integer getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(Integer cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public ArrayList<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(ArrayList<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }

    
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
   
    public Integer getDiasPrestado() {
        return diasPrestado;
    }

    public void setDiasPrestado(Integer diasPrestado) {
        this.diasPrestado = diasPrestado;
    }

    public Date getFechaPrestado() {
        return fechaPrestado;
    }

    public void setFechaPrestado(Date fechaPrestado) {
        this.fechaPrestado = fechaPrestado;
    }

       
    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Editorial getUnEditorial() {
        return unEditorial;
    }

    public void setUnEditorial(Editorial unEditorial) {
        this.unEditorial = unEditorial;
    }

    public Autor getUnAutor() {
        return unAutor;
    }

    public void setUnAutor(Autor unAutor) {
        this.unAutor = unAutor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<HistorialReparacion> getHistorialReparacion() {
        return historialReparacion;
    }

    public void setHistorialReparacion(ArrayList<HistorialReparacion> historialReparacion) {
        this.historialReparacion = historialReparacion;
    }
    
    public Ejemplar buscarEjemplar(String idEjemplar){
        for (Ejemplar ejemplar : this.ejemplares){
            if(ejemplar.getIdEjemplar().equals(idEjemplar)){
                return ejemplar;
            }
        }
        return null;
    }
    
    public void agregarEjemplar(Integer idEjemplar,Integer identificador, String nombre,Integer año, Editorial unEditorial, Autor unAutor,String ISBN){
         Ejemplar ejemplar = new Ejemplar(String.valueOf(identificador)+String.valueOf(idEjemplar),identificador,nombre,año,unEditorial,unAutor,ISBN,0);
         this.ejemplares.add(ejemplar);
    }

    public void quitarEjemplar(String idEjemplar){
        Ejemplar ejemplar = this.buscarEjemplar(idEjemplar);
        this.ejemplares.remove(ejemplar);
    }
    
    @Override
    public String toString() {
        return "Libro{" + "identificador=" + identificador + ", nombre=" + nombre + ", a\u00f1o=" + año + ", unEditorial=" + unEditorial + ", unAutor=" + unAutor + ", estado=" + estado + '}';
    }
    
    
}
