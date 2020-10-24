/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import com.sun.javaws.Main;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.LogOutController;

/**
 *
 * @author 2dam
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try {
             
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFXApplication.class.getResource("/view/LogOut.fxml"));
            // Cargo la ventana
            Parent ventana = (Parent) loader.load();
            // Cargo el scene        
            LogOutController controller = (LogOutController)loader.getController();
                        
            controller.setStage(primaryStage);
            controller.initStage(ventana);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
