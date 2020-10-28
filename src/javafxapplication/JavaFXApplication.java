/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import view.LogInController;

/**
 *
 * @author Moroni
 */
public class JavaFXApplication extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try {
            // Cargo la ventana
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(JavaFXApplication.class.getResource("/view/LogIn.fxml"));
            Parent ventana = (Parent) loader.load();
 
            // Cargo el controller
            LogInController controller = ((LogInController)loader.getController());
            
            // Establecer  el controller y la muestro
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
