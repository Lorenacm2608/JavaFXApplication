/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import validar.Validar;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class LogInController  {
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
        private Hyperlink hlRegistrarse;
    @FXML
        private Label lblerrorusuario;
    
    
    private Stage stage=new Stage();
    private Usuario usuario;
    public LogInController(){
        
    }
    public Stage getStage(){
        return this.stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    
    public void initStage(Parent root){
        logger.severe("Entra aqui");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Inicio");
        stage.setResizable(false);
        stage.setOnShowing(this::handleWindowShowing);
        btnIniciar.setOnAction(this::btnIniciarClick);
        btnIniciar.setTooltip(new Tooltip("Pulse para iniciar sesion "));
        
        txtUsuario.textProperty().addListener(this::txtChanged);
        txtContrasena.textProperty().addListener(this::txtChanged);
        hlRegistrarse.setOnAction(this::hlRegistrarseClick);
        stage.show();
        
    }   
    /**
     * 
     * @param event 
     */
    private void handleWindowShowing(WindowEvent event){
       btnIniciar.setDisable(true);
       lblerrorusuario.setVisible(false);
       //txtUsuario.setPromptText("Introduzca el nombre de usuario... ");
       //txtContrasena.setPromptText("Introduzca la contraseña... ");
       logger.info("Beginning LoginController::handleWindowShowing");
    }
    //Importante Preguntar a Javi
    /**
     * 
     * @param observable
     * @param oldValue
     * @param newValue 
     */
    private void txtChanged(ObservableValue observable, String oldValue, String newValue){
         if(!txtUsuario.getText().trim().equals("") && !txtContrasena.getText().trim().equals("")){
            boolean isValidUsuario = Validar.isValid(txtUsuario,lblerrorusuario,"usuario invalido","usuario valido");
            lblerrorusuario.setVisible(true);
            Validar.addTextLimiter(txtUsuario, treinta);
            Validar.addTextLimiterPass(txtContrasena, treinta);
            if(isValidUsuario){
            btnIniciar.setDisable(false);
            }else{
            btnIniciar.setDisable(true);
            
            }
        }
        if (txtUsuario.getText().trim().equals("")|| txtContrasena.getText().trim().equals("")){
            
            btnIniciar.setDisable(true);
            
        }
    }
    /**
     * 
     * @param event 
     */
    private void btnIniciarClick(ActionEvent event){
        logger.info("Ventana LogOut");
        usuario= new Usuario();
        usuario.setNombre(txtUsuario.getText());
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));
            
            Parent root  = (Parent)loader.load();
            
             LogOutController controller= ((LogOutController)loader.getController());
            controller.setUsuario(usuario);
             controller.initStage(root);
            stage.hide();
             } catch (IOException e) {
                 logger.severe("Alerta");
    }
}
    private void hlRegistrarseClick(ActionEvent event){
          logger.info("Ventana LogOut");
        usuario= new Usuario();
        usuario.setNombre(txtUsuario.getText());
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));
            
            Parent root  = (Parent)loader.load();
            
             SignUpController controller= ((SignUpController)loader.getController());
            //controller.setUsuario(usuario);
             controller.initStage(root);
            stage.hide();
             } catch (IOException e) {
                 logger.severe("Alerta");
    }
    }
    
}
