/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Date;
import validar.Estado;
import validar.Privilegio;

/**
 *
 * @author pocoy
 */
public class Usuario {
    /** Aqui es donde creamos nuestros atributos de la clase usuario pero en este caso son "private"  ya que solo se usan en esta clase **/
    private int id;
    private String usuario;
    private String email;
    private String nombre;
    private  Estado estado;
    private Privilegio privilegio;
    private String contrasenia;
    private Date ultimoAcceso;
    private Date UltimaContrasena;
    
    
    /** Constructor para crear un usuario vacio */ 
    public Usuario(){
        this.privilegio=privilegio.USER;
        this.estado=estado.ENABLE;
    }

    public Usuario(int id, String usuario, String email, String nombre, Estado estado, Privilegio privilegio, String contrasenia, Date ultimoAcceso, Date UltimaContrasenia) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.estado = estado;
        this.privilegio = privilegio;
        this.contrasenia = contrasenia;
        this.ultimoAcceso = ultimoAcceso;
        this.UltimaContrasena = UltimaContrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Privilegio getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Privilegio privilegio) {
        this.privilegio = privilegio;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public Date getUltimaContrasenia() {
        return UltimaContrasena;
    }

    public void setUltimaContrasenia(Date UltimaContrasena) {
        this.UltimaContrasena = UltimaContrasena;
    }
    
   
/** Creamos el setDatos donde vamos a meter los datos del usuario que hay que meter manualmente **/
   
    /** Creamos el setDatos donde vamos a observar los datos del usuario  **/
    public void getDatos(){
        System.out.println("El id "+id);
        System.out.println("El usuario "+usuario);
        System.out.println("El email "+email);
        System.out.println("El nombre "+nombre);
        
        
        
        System.out.println("La contraseña es "+contrasenia);
        System.out.println("El ultimo acceso ha sido el "+ultimoAcceso);
        System.out.println("La ultima contraseña ha sido "+UltimaContrasena);
    }
     
}