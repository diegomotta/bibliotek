/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Editorial;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ControladorEditorial {
    private ArrayList<Editorial> editoriales;
    
    public ControladorEditorial(){
        this.editoriales = new ArrayList<>();
    }

    public ArrayList<Editorial> getEditoriales() {
        return editoriales;
    }

    public void setEditoriales(ArrayList<Editorial> editoriales) {
        this.editoriales = editoriales;
    }
    
    public Editorial buscarEditorial (Integer id){
        for(Editorial unEditorial: this.getEditoriales()){
            if(unEditorial.getId().equals(id)){
                return unEditorial;
            }
        }
        return null;
    }
    
    public Editorial buscarEditorial (String nombre){
        for(Editorial unEditorial: this.getEditoriales()){
            if(unEditorial.getNombre().equals(nombre)){
                return unEditorial;
            }
        }
        return null;
    }
    
    public void quitarEditorial(Integer id){
        Editorial unEditorial = this.buscarEditorial(id);
        this.editoriales.remove(unEditorial);
    }
    
    public void agregarEditorial(Integer id, String nombre){
        Editorial unEditorial = new Editorial(id,nombre);
        this.editoriales.add(unEditorial);
    }
    
    public void modificarEditorial(Integer id, String nombre){
        Editorial unEditorial = this.buscarEditorial(id);
        unEditorial.setId(id);
        unEditorial.setNombre(nombre);
    }
}
