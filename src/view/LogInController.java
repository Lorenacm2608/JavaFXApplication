/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import validar.Validar;

/**
 * FXML Controller class
 *
 * @author Moroni
 */
public class LogInController implements Initializable {

    private Stage stage;
    private static final Logger logger = Logger.getLogger("view.LogInController");
    private final int  treinta = 30;
    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Button btnIniciar;
    @FXML
    private Label lblerrorusuario;
    @FXML
    private Hyperlink hlRegistrarse;

    /**
     *
     * @param root
     */
    public void initStage(Parent root) {
        logger.info("Initializing Login stage");
        
        // Create a scene associated to the node graph root
        Scene scene = new Scene(root);
        
        // Asociate scene to primaryStage(Window)
        stage.setScene(scene);
        
        // Set window properties
        stage.setTitle("Login");
        stage.setResizable(false);
        
        // Set window's events handlers
        stage.setOnShowing(this::handleWindowShowing);
        btnIniciar.setOnAction(this::btnIniciarClick);
        hlRegistrarse.setOnAction(this::hlRegistrarseClick);
        // txtContrasena.addEvenHandler(InputMethodEvent.INPUT_METHOD_TEXT
        // txtContrasena.setOnKeyTyped(this::handleTextChanged);
        // Set control events handlers (if not set by FXML)
        txtUsuario.textProperty().addListener(this::txtChanged);
        txtContrasena.textProperty().addListener(this::txtChanged);

        // Show primary window
        stage.show();

    }

    private void handleWindowShowing(WindowEvent event) {
        logger.info("Beginning LoginController::handleWindowShowing");
        
        // El boton Aceptar se desabilita
        btnIniciar.setDisable(true);
        
        lblerrorusuario.setVisible(false);
        //txtUsuario.setPromptText("Introduzca el nombre de usuario... ");
        //txtContrasena.setPromptText("Introduzca la contraseña... ");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 

    public Stage getStage(Stage primaryStage) {
        return this.stage;
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    private void txtChanged(ObservableValue observable, String oldValue, String newValue){
        
        
        if(!txtUsuario.getText().trim().equals("") && !txtContrasena.getText().trim().equals("")){
            boolean isValidUsuario = Validar.isValidUsuario(txtUsuario,lblerrorusuario,"usuario invalido","usuario valido");
            lblerrorusuario.setVisible(true);
            Validar.addTextLimiter(txtUsuario, treinta);
            Validar.addTextLimiterPass(txtContrasena, treinta);
            if(isValidUsuario)
            btnIniciar.setDisable(false);
            else
            btnIniciar.setDisable(true);
        }
        if (txtUsuario.getText().trim().equals("")|| txtContrasena.getText().trim().equals("")){
            
            btnIniciar.setDisable(true);
            
        }

    }
    
    private void btnIniciarClick(ActionEvent event) {
        logger.info("Ventana LogOut");
        Usuario usuario = new Usuario();
        usuario.setNombre(txtUsuario.getText());
        try {
            // Cargo la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));

            Parent root = (Parent) loader.load();
            
            // Cargo el controller
            LogOutController controller = ((LogOutController) loader.getController());
            
            // Establecer  el controller y la muestro
            controller.setUsuario(usuario);
            controller.initStage(root);
            stage.hide();
            
        } catch (IOException e) {
            logger.severe("Alerta");
        }
    }

    private void hlRegistrarseClick(ActionEvent event) {
        logger.info("Ventana SignUp");
        //Usuario usuario= new Usuario();
        //usuario.setNombre(txtUsuario.getText());
        try {
            // Cargo la ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));

            Parent root = (Parent) loader.load();

            // Cargo el controller
            SignUpController controller = ((SignUpController) loader.getController());
            
            // Establecer  el controller y la muestro
            //controller.setUsuario(usuario);
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            logger.severe("Alerta");
        }
    }

    
}
