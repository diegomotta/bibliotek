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
public class Autor extends Persona{

    public Autor(Integer id,String nombre, String apellido, String telefono, Date fechaNacimiento, String email, String nacionalidad) {
        super(id,nombre, apellido, telefono, fechaNacimiento, email, nacionalidad);
    }


    
}
