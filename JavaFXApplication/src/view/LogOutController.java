package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Lorena Cáceres Manuel
 */
public class LogOutController implements Initializable {

    private Stage stage = new Stage();
    private Usuario u;
    private static final Logger logger = Logger.getLogger("view.LogOutController");

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btnVolver;
    @FXML
    private Label lblSaludo;

    @FXML
    private void VolverVentanaLogin(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));
            Parent root = (Parent) loader.load();

            LogInController controller = (LogInController) loader.getController();
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            logger.severe("Error al desconectarse");
            //alert();
        }

    }

    public void initStage(Parent ventana) {
        Scene scene = new Scene(ventana);
        stage.setScene(scene);
        stage.setTitle("LogOut");
        stage.setResizable(false);
        stage.setOnShowing(this::handleWindowShowing);
        stage.show();
    }

    private void handleWindowShowing(WindowEvent event) {
        lblSaludo.setText("Hola " + u.getNombre());
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO

    }

    public Stage getStage() {
        return stage;
    }

    public void setUsuario(Usuario u) {
        this.u = u;
    }

    public void getUsuario() {

    }
/*
    private void alert() {
        Alert alert = new Alert (AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText("error al desconectar");
        alert.setContentText("error al desconectar");
        alert.showAndWait();
    }
*/
}
