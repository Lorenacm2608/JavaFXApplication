package libreries;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import static libreries.Estado.ENABLE;
import static libreries.Privilegio.USER;

/**
 *
 * @author Nadir Essadi
 */
public class Usuario implements Serializable{
    /** Aqui es donde creamos nuestros atributos de la clase usuario pero en este caso son "private"  ya que solo se usan en esta clase **/
    private Integer id;
    private String usuario;
    private String email;
    private String nombre;
    private Estado estado;
    private Privilegio privilegio;
    private String contrasena;
    private Date ultimoAcceso;
    private String UltimaContrasena;
    
    
    /** Constructor para crear un usuario vacio */ 
    public Usuario(String usuario){
        this.usuario=usuario;
        this.privilegio=privilegio.USER;
        this.estado=estado.ENABLE;
    }

    public Usuario(Integer id, String usuario, String email, String nombre, Estado estado, Privilegio privilegio, String contrasena, Date ultimoAcceso, String UltimaContrasenia) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.estado = estado;
        this.privilegio = privilegio;
        this.contrasena = contrasena;
        this.ultimoAcceso = ultimoAcceso;
        this.UltimaContrasena = UltimaContrasenia;
    }

    public Usuario() {
        privilegio = USER;
        estado = ENABLE;
        //LocalDate hora = LocalDate.now();
        //ultimoAcceso = Date.from(hora.atStartOfDay(ZoneId.systemDefault()).toInstant());
        ultimoAcceso = null;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(Date ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    public String getUltimaContrasenia() {
        return UltimaContrasena;
    }

    public void setUltimaContrasenia(String UltimaContrasena) {
        this.UltimaContrasena = UltimaContrasena;
    }
    
    
     
}