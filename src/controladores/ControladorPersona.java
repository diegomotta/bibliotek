/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import clases.Autor;
import clases.Empleado;
import clases.Lector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author diego
 */
public class ControladorPersona {
    public static String usuario;
    public static Object logueado;
    private ArrayList<Autor> autores;
    private ArrayList<Empleado> empleados;
    private ArrayList<Lector> lectores;
    
    public ControladorPersona(){
        this.autores = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.lectores = new ArrayList<>();
    }
    public ArrayList<Lector> getLectores() {
        return lectores;
    }

    public void setLectores(ArrayList<Lector> lectores) {
        this.lectores = lectores;
    }
    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    
    
    public void agregarEmpleado(Integer id,String nombre, String apellido, String telefono, Date fechaNacimiento, String email,String nacionalidad,String contraseña,String usuario){
        this.empleados.add(new Empleado(id,nombre,apellido,telefono,fechaNacimiento,email,nacionalidad,contraseña,usuario));
    }
    
   
    public void agregarAutor(Integer id,String nombre, String apellido, String telefono, Date fechaNacimiento, String email,String nacionalidad){
        this.autores.add(new Autor(id,nombre,apellido,telefono,fechaNacimiento,email,nacionalidad));
    }
    
    public void modificarLector(Integer idLector, Integer id,String nombre, String apellido, Date fechaNacimiento, String email,String nacionalidad){
       Lector unLector = this.buscarLector(idLector);
       unLector.setId(id);
       unLector.setNombre(nombre);
       unLector.setApellido(apellido);
       unLector.setFechaNacimiento(fechaNacimiento);
       unLector.setEmail(email);
       unLector.setNacionalidad(nacionalidad);
    }
    
    public void modificarAutor(Integer idAutor, Integer id,String nombre, String apellido, Date fechaNacimiento, String email,String nacionalidad){
       Autor unAutor = this.buscarAutor(idAutor);
       unAutor.setId(id);
       unAutor.setNombre(nombre);
       unAutor.setApellido(apellido);
       unAutor.setFechaNacimiento(fechaNacimiento);
       unAutor.setEmail(email);
       unAutor.setNacionalidad(nacionalidad);

    }
    
    public void modificarEmpleado(Integer idEmpleado, Integer id,String nombre, String apellido, Date fechaNacimiento, String email,String nacionalidad, String contrasenia,String usuario){
       Empleado unEmpleado = this.buscarEmpleado(idEmpleado);
       unEmpleado.setId(id);
       unEmpleado.setNombre(nombre);
       unEmpleado.setApellido(apellido);
       unEmpleado.setFechaNacimiento(fechaNacimiento);
       unEmpleado.setEmail(email);
       unEmpleado.setNacionalidad(nacionalidad);
       unEmpleado.setUsuario(usuario);
       unEmpleado.setContraseña(contrasenia);
    }
    
    public Empleado buscarEmpleado(Integer id){
        for (Empleado unEmpleado : this.getEmpleados()){
            if(unEmpleado.getId().equals(id)){
                return unEmpleado;
            }
        }
        return null;
    }
    
    public Empleado esUsuario(String usuario){
        for (Empleado unEmpleado : this.getEmpleados()){
            if(unEmpleado.getUsuario().equals(usuario)){
                return unEmpleado;
            }
        }
        return null;
    }
    
    public boolean controlar(Empleado unEmpleado, String contraseña) {
        boolean control = false;
        if (unEmpleado.getContraseña().toUpperCase().equals(contraseña.toUpperCase())) {
            control = true;
            ControladorPersona.setLogueado(unEmpleado);
            ControladorPersona.setUsuario(unEmpleado.getUsuario());
        }
        return control;
    }    
    
    public static Object getLogueado() {
        return logueado;
    }

    public static void setLogueado(Object logueado) {
        ControladorPersona.logueado = logueado;
    }
    
    public static String getUsuario() {
        return usuario;
    }

    public static void setUsuario(String usuario) {
        ControladorPersona.usuario = usuario;
    }
    public Lector buscarLector(Integer id){
        for (Lector unLector : this.getLectores()){
            if(unLector.getId().equals(id)){
                return unLector;
            }
        }
        return null;
    }
    
    public Autor buscarAutor(Integer id){
        for (Autor unAutor : this.getAutores()){
            if(unAutor.getId().equals(id)){
                return unAutor;
            }
        }
        return null;
    }

    public Autor buscarAutor(String nombre){
        for (Autor unAutor : this.getAutores()){
            if(unAutor.getNombre().equals(nombre)){
                return unAutor;
            }
        }
        return null;
    }
    
    public void quitarEmpleado(Integer id){
        Empleado unEmpleado = this.buscarEmpleado(id);
        this.empleados.remove(unEmpleado);
    }
    
    public void quitarLector(Integer id){
        Lector unLector = this.buscarLector(id);
        this.lectores.remove(unLector);
    }
    
    public void quitarAutor(Integer id){
        Autor unAutor = this.buscarAutor(id);
        this.autores.remove(unAutor);
    }
    
    
    public static Integer calcularEdad(Date fecha){

        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fecha);
        //Se restan la fecha actual y la fecha de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        //Se ajusta el año dependiendo el mes y el día
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        //Regresa la edad en base a la fecha de nacimiento
        return año;
    }

    public void agregarLector(Integer id, String nombre, String apellido, String apellido0, Date fechaNacimiento, String email, String nacionalidad) {
        this.lectores.add(new Lector(id,nombre,apellido,"",fechaNacimiento,email,nacionalidad));
    }
}

