/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author diego
 */
public class Empleado extends Persona{
    private String contraseña;
    private String usuario;
    public Empleado(Integer id,String nombre, String apellido, String telefono, Date fechaNacimiento, String email,String nacionalidad,String contraseña,String usuario) {
        super(id,nombre, apellido, telefono, fechaNacimiento, email,nacionalidad);
        this.contraseña = contraseña;
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
