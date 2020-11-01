package libreries;

import libreries.Signable;
import libreries.Message;
import libreries.Tipo;
import libreries.Usuario;
import exceptions.AutenticacionFallidaException;
import exceptions.ErrorBDException;
import exceptions.ErrorServerException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioNoEncontradoException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Fredy Vargas Flores
 * @author Lorena Cáceres Manuel
 */
public class SignableImplementation implements Signable {

    // private ResourceBundle rb = ResourceBundle.getBundle("controlDB.Configuration");
    private Socket socket;
    private Message message;
    //  int port = Integer.parseInt(rb.getString("port"));

    @Override
    public Usuario signUp(Usuario u) throws UsuarioExistenteException, ErrorBDException, ErrorServerException {
        try {
            // socket = new Socket(rb.getString("host"), port);
            socket = new Socket("127.0.0.1", 3338);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            message = new Message(u, Tipo.SIGNUP);
            oos.writeObject(message);
            System.out.println("MENSAJE ESCRITO");
            try {
                message = (Message) ois.readObject();
                System.out.println(message.getUsuario().getUsuario() + " Este usuarios a vuelto");
                return message.getUsuario();
            } catch (ClassNotFoundException ex) {
                // Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ois.close();
                oos.close();
                socket.close();
            }
        } catch (IOException ex) {
            //Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex); //!--LOGGER
            // } catch (InterruptedException ex) {
            //Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public Usuario logIn(Usuario u) throws AutenticacionFallidaException, ErrorBDException, ErrorServerException, UsuarioNoEncontradoException {
        try {
            //socket = new Socket(rb.getString("host"), port);
            socket = new Socket("127.0.0.1", 3338);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            message = new Message(u, Tipo.LOGIN);
            oos.writeObject(message);
            System.out.println(" hasta");
            try {
                // Message  sms = (Message) ois.readObject();
                message = (Message) ois.readObject();
                System.out.println(message.getUsuario().getUsuario() + " Este usuarios a vuelto");
                return message.getUsuario();
            } catch (ClassNotFoundException ex) {
                // Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ois.close();
                oos.close();
                socket.close();
            }
        } catch (IOException ex) {
            //Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex); //!--LOGGER
            // } catch (InterruptedException ex) {
            //Logger.getLogger(Libreries.SignableImplementationCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
