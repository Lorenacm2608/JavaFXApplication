package controlDB;

import libreries.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import libreries.Signable;
import exceptions.AutenticacionFallidaException;
import exceptions.EmailNoExisteException;
import exceptions.ErrorBDException;
import exceptions.ErrorServerException;
import exceptions.UsuarioExistenteException;
import exceptions.UsuarioNoEncontradoException;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *
 * @author 2dam
 */
public class DaoImplementation implements Signable {

    private Connection con;
    private PreparedStatement stmt;
    private PoolConnection pool;
    //SELECTS 
    final String selectUsuario = "select * from usuario where usuario = ?";
    final String selectContrasena = "select * from usuario where usuario = ? and contrasena=?";
    final String selectEmail = "select * from usuario where email = ?";
    final String insertUsuario = "insert into usuario(usuario,email,nombre,estado,privilegio,contrasena,ultimoAcceso,ultimaContrasena)values(?,?,?,?,?,?,?,?)";

    public DaoImplementation() {
    }

    @Override
    public Usuario signUp(Usuario u) throws UsuarioExistenteException, ErrorBDException, ErrorServerException {
        try {
            System.out.println("HOLA0");
            boolean estaUsuario = estaUsuario(u.getUsuario());
            boolean estaEmail = estaEmail(u.getEmail());
            if (!estaUsuario && !estaEmail) {
                try {
                    System.out.println("HOLA NUEVO USUARIO");
                    PreparedStatement ps;
                    String query;
                    query = insertUsuario;
                    pool = new PoolConnection();
                    con = pool.getInstance();
                    ps = con.prepareStatement(query);
                    System.out.println("1");
                    ps.setString(1, u.getUsuario());
                     System.out.println("2");
                    ps.setString(2, u.getEmail());
                     System.out.println("3");
                    ps.setString(3, u.getNombre());
                     System.out.println("4");
                    ps.setString(4, u.getEstado().toString());
                     System.out.println("5");
                    ps.setString(5, u.getPrivilegio().toString());
                    System.out.println("6");
                    ps.setString(6, u.getContrasena());
                    System.out.println("7");
                    ps.setDate(7,(Date) u.getUltimoAcceso());
                    System.out.println("8");
                    ps.setString(8, u.getUltimaContrasenia());
                    System.out.println("9");
                    return u;
                } catch (SQLException ex) {
                    Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (con != null) {
                        pool.devolverConexion(con);
                    } else {
                        pool.closeConnection(con);
                    }
                }

            }

        } catch (UsuarioNoEncontradoException ex) {
            Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EmailNoExisteException ex) {
            Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean estaUsuario(String username) throws UsuarioNoEncontradoException {
        try {
            System.out.println("estaUsuario1");
            pool = new PoolConnection();
            con = pool.getInstance();
            stmt = con.prepareStatement(selectUsuario);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("usuarioExiste");
                return true;
            }
        } catch (SQLException ex) {
            //logger
        } finally {
            if (con != null) {
                pool.devolverConexion(con);
            } else {
                pool.closeConnection(con);
            }
        }
        return false;
    }

    public boolean estaEmail(String email) throws EmailNoExisteException {
        try {
            System.out.println("estaemail1");
            pool = new PoolConnection();
            pool.getInstance();
            stmt = con.prepareStatement(selectEmail);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                 System.out.println("emailExiste");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                pool.devolverConexion(con);
            } else {
                this.pool.closeConnection(con);
            }
        }
        return false;

    }

    @Override
    public Usuario logIn(Usuario usuario) throws AutenticacionFallidaException, ErrorBDException, ErrorServerException, UsuarioNoEncontradoException {
        System.out.println("login dao he llegado");
        if (estaUsuario(usuario.getUsuario())) {
            System.out.println("1");
            try {
                pool = new PoolConnection();
                con = pool.getInstance();
                stmt = con.prepareStatement(selectContrasena);
                stmt.setString(1, usuario.getUsuario());
                stmt.setString(2, usuario.getContrasena());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    System.out.println("2");
                    return usuario;
                } else {
                    throw new AutenticacionFallidaException();
                }
            } catch (SQLException ex) {
                throw new ErrorBDException();
            } finally {
                if (con != null) {
                    pool.devolverConexion(con);
                } else {
                    this.pool.closeConnection(con);
                }
            }
        } else {
            System.out.println("Usuario Existente");
            throw new AutenticacionFallidaException();
        }
    }
}
