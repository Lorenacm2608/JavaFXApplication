/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class SignUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
        private TextField txtUsername;
    @FXML
        private TextField txtEmail;
    @FXML
        private TextField txtNombre;
    @FXML
        private PasswordField txtContrasena;
    @FXML
        private Button btnRegistrar;
    @FXML
        private Button btnCancelar;
    @FXML
        private Label lblUsuario;
    @FXML
        private Label lblEmail;
    @FXML
        private Label lblNombre;
    @FXML
        private Label lblContrasena;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
