/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class SignUpController {
    
    @FXML
        private TextField txtUsername;
    @FXML
        private TextField txtEmail;
    @FXML
        private TextField txtNombre;
    
    @FXML
        private PasswordField txtContrasena;
    @FXML
        private PasswordField txtConfirmarContrasena;
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
    
    private Stage stage = new Stage();
    private Usuario usuario;
    public SignUpController(){
        
    }
    public Stage getStage(){
        return this.stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    /*
    public void initStage(Parent root){
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Registrarse");
        stage.setResizable(false);
      //  stage.setOnShowing(this::handleWindowShowing);
        stage.show();
        
    }*/
    public void initStage(Parent root){
        // Create a scene associated to the node graph root
        Scene scene =new Scene(root);
        // Asociate scene to primaryStage(Window)
        stage.setScene(scene);
        // Set window properties
        stage.setTitle("SignUp");
        stage.setResizable(false);
        // Set window's events handlers

        stage.setOnShowing(this::handleWindowShowing);
        // txtContrasena.addEvenHandler(InputMethodEvent.INPUT_METHOD_TEXT
        // txtContrasena.setOnKeyTyped(this::handleTextChanged);
        // Set control events handlers (if not set by FXML)

       txtContrasena.textProperty().addListener(this::txtChanged);
        // Show primary window
        stage.show();

    }
       private void handleWindowShowing(WindowEvent event){

        btnRegistrar.setDisable(true);
        //logger.info("Beginning LoginController::handleWindowShowing");
        // El boton Aceptar se desabilita
        //txtUsername.setPromptText("Introduzca el nombre de usuario... ");
        //txtContrasena.setPromptText("Introduzca la contraseña... ");

    }

    private void txtChanged(ObservableValue observable, String oldValue, String newValue){

        if(!newValue.trim().equals("")){
            btnRegistrar.setDisable(false);
        }
        if (!oldValue.trim().equals("") ){
            btnRegistrar.setDisable(true);
        }

    }
    
}