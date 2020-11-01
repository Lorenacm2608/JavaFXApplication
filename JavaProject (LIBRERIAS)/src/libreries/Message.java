package libreries;

import java.io.Serializable;

/**
 *
 * @author Moroni Collazos Fiestas
 *
 */
public class Message implements Serializable{
    
    private Usuario usuario;
    private Tipo tipoMensaje;

    public Message(Usuario usuario, Tipo tipoMensaje) {
        this.usuario = usuario;
        this.tipoMensaje = tipoMensaje;
    }

    public Message() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(Tipo tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }
   
}