/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Moroni
 */
public class LogInController implements Initializable {

    private Stage stage;
    private Object logger;
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
        private Hyperlink hlRegistrarse;
    
    /**
     *
     * @param ventana
     */
    public void initStage(Parent ventana){
        //logger.info("Initializing Login stage");
        // Create a scene associated to the node graph root
        Scene scene =new Scene(ventana);
        // Asociate scene to primaryStage(Window)
        stage.setScene(scene);
        // Set window properties
        stage.setTitle("Login");
        stage.setResizable(false);
        // Set window's events handlers
        stage.setOnShowing(this::handleWindowShowing);
        // txtPassword.addEvenHandler(InputMethodEvent.INPUT_METHOD_TEXT
        // txtPassword.setOnKeyTyped(this::handleTextChanged);
        // Set control events handlers (if not set by FXML)
       txtUsuario.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {

        btnIniciar.setDisable(false);
    }

        });
       
        // Show primary window
        stage.show();
        
    }
    private void handleWindowShowing(WindowEvent event){
        //logger.info("Beginning LoginController::handleWindowShowing");
        // El boton Aceptar se desabilita
        btnIniciar.setDisable(true);
    }
    
    private void textChanged(WindowEvent event){
        //logger.info("Beginning LoginController::handleWindowShowing");
        // El boton Aceptar se habilita
        btnIniciar.setDisable(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    

    public void setStage(Stage primaryStage) {
        stage=primaryStage;
    }
    
}
