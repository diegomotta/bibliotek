/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author diego
 */
public class Ejemplar extends Libro {
    
    private String idEjemplar;

    public Ejemplar(String idEjemplar, Integer identificador, String nombre, Integer año, Editorial unEditorial, Autor unAutor, String ISBN, Integer cantidadEjemplares) {
        super(identificador, nombre, año, unEditorial, unAutor, ISBN, cantidadEjemplares);
        this.idEjemplar = idEjemplar;
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(String idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

 

    @Override
    public String toString() {
        return "Ejemplar{" + "idEjemplar=" + idEjemplar + '}';
    }
   
    
}
