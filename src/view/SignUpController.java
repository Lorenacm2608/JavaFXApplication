/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import validar.Validar;


/**
 *
 * @author 2dam
 */
public class SignUpController {
    private static final Logger logger = Logger.getLogger("view.SignUpController");
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
    @FXML
        private Label lblEmailIncorrecto;
    @FXML
        private Label lblContrasenaIncorrecta;
    @FXML
        private Label lblNocoinciden;
    @FXML
        private Label lblUCaracter;
    @FXML
        private Label lblECaracter;
    @FXML
        private Label lblNCaracter;
    @FXML
        private Label lblCCaracter;
    @FXML
        private Label lblCCCaracter;
    @FXML
        private Label lblUsuarioIncorrecto;
    @FXML
        private Label lblNombreIncorrecto;
    
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
        btnRegistrar.setOnAction(this::btnRegistrarClick);
        btnCancelar.setOnAction(this::hlCancerClick);
       txtContrasena.textProperty().addListener(this::txtChanged);
       txtConfirmarContrasena.textProperty().addListener(this::txtChanged);
      
        // Show primary window
        stage.show();

    }
       private void handleWindowShowing(WindowEvent event){

        btnRegistrar.setDisable(true);
        lblEmailIncorrecto.setVisible(false);
        lblContrasenaIncorrecta.setVisible(false);
        lblNombreIncorrecto.setVisible(false);
        lblNocoinciden.setVisible(false);
        lblUsuarioIncorrecto.setVisible(false);
        //logger.info("Beginning LoginController::handleWindowShowing");
        // El boton Aceptar se desabilita
        //txtUsername.setPromptText("Introduzca el nombre de usuario... ");
        //txtContrasena.setPromptText("Introduzca la contraseña... ");
        
    }

    private void txtChanged(ObservableValue observable, String oldValue, String newValue){

        if(/*!newValue.trim().equals("")*/!txtUsername.getText().trim().equals("") && !txtContrasena.getText().trim().equals("")&& !txtEmail.getText().trim().equals("")&& !txtNombre.getText().trim().equals("")&& !txtConfirmarContrasena.getText().trim().equals("") ){
            btnRegistrar.setDisable(false);
        }
        if (/*newValue.trim().equals("")*/ txtUsername.getText().trim().equals("")&& txtContrasena.getText().trim().equals("")&& txtEmail.getText().trim().equals("")&& txtNombre.getText().trim().equals("")&& txtConfirmarContrasena.getText().trim().equals("") ){
            btnRegistrar.setDisable(true);
        }

    }
    private void hlCancerClick(ActionEvent event){
          logger.info("Ventana LogIn");
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
            
            Parent root  = (Parent)loader.load();
            
             LogInController controller= ((LogInController)loader.getController());
            //controller.setUsuario(usuario);
             controller.initStage(root);
            stage.hide();
             } catch (IOException e) {
                 logger.severe("Alerta");
    }
    }
      private void btnRegistrarClick(ActionEvent event){
        logger.info("Ventana LogOut");
        boolean isValidEmail = Validar.isValidEmail(txtEmail, lblEmailIncorrecto, "Email invalido!");
        if(isValidEmail){
            lblEmailIncorrecto.setText("Email valido");
        }else{
            lblEmailIncorrecto.setVisible(true);
        }
        boolean isValidContrasena = Validar.isValidContrasena(txtContrasena, txtConfirmarContrasena, lblNocoinciden, "No coinciden");
        if(isValidContrasena){
            lblNocoinciden.setText("Contraseña valida");
        }
        try{
            
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));
            
            Parent root  = (Parent)loader.load();
            
             LogOutController controller= ((LogOutController)loader.getController());
             controller.initStage(root);
            stage.hide();
             } catch (IOException e) {
                 logger.severe("Alerta");
    }
}
}
