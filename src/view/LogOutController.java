/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafxapplication.JavaFXApplication;
/**
 * FXML Controller class
 *
 * @author Lorena Cáceres Manuel
 */
public class LogOutController implements Initializable {
    
    private Stage stage;

    /**
     * Initializes the controller class.
     */
    
    @FXML
        private Button btnVolver;
    @FXML
        private Label lblSaludo;
    @FXML
    private void VolverVentanaLogin(ActionEvent event) throws IOException{
     Parent root = FXMLLoader.load(getClass().getResource("view.LogIn.fxml"));
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
}
    public void initStage(Parent ventana){
        Scene scene = new Scene (ventana);
        stage.setScene(scene);
        stage.setTitle("LogOut");
        stage.setResizable(false);
        stage.show();
    }
    public void setStage(Stage primaryStage){
        stage=primaryStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        
    }   
    public Stage getStage (){
        return stage;
    }
 
}
