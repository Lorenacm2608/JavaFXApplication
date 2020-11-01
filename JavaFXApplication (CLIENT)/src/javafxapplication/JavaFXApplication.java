/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication;

import java.io.IOException;
import java.util.logging.Logger;
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
import view.LogInController;

/**
 *
 * @author 2dam
 */
public class JavaFXApplication extends Application {

    private static final Logger logger = Logger.getLogger("javafxapplication.JavaFXApplication");

    @Override
    public void start(Stage primaryStage) {
        try {
            //  FXMLLoader loader = new FXMLLoader();
            // loader.setLocation(JavaFXApplication.class.getResource("/view/LogIn.fxml"));
            // Cargo la ventana
            //  Pane ventana = (Pane) loader.load();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));

            Parent root = (Parent) loader.load();

            // Cargo el scene
            // Scene scene = new Scene(root);
            LogInController controller = ((LogInController) loader.getController());
            controller.setStage(primaryStage);
            controller.initStage(root);

            // Establecer  la scene y la muestro
            // primaryStage.setScene(scene);
            //  primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Vantana no cargada");

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
