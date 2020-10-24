/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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
public class LogOutController  {

    /**
     * Initializes the controller class.
     */
    
    @FXML
        private Button btnVolver;
    @FXML
        private Label lblSaludo;
    
    private Stage stage= new Stage();
    private Usuario usuario;
     private static final Logger logger = Logger.getLogger("view.LogOutController"); 
    
    public Stage getStage(){
        return this.stage;
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }
    
    public void initStage(Parent root){
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        logger.info("1");
        stage.setTitle("LogOut");
        logger.info("2");
        stage.setResizable(false);
        logger.info("3");
        stage.setOnShowing(this::handleWindowShowing);
        stage.show();
        logger.info("4");
        
    }    
     private void handleWindowShowing(WindowEvent event){
      /* btnIniciar.setDisable(true);
       txtUsuario.setPromptText("Introduzca el nombre de usuario... ");
       txtContrasena.setPromptText("Introduzca la contraseña... ");*/
         lblSaludo.setText("Usuario: "+usuario.getNombre());
    }
}
