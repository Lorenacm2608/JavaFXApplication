/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exceptions.AutenticacionFallidaException;
import exceptions.ErrorBDException;
import exceptions.ErrorServerException;
import exceptions.UsuarioNoEncontradoException;
import java.io.IOException;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import libreries.Signable;
import libreries.SignableFactory;
import libreries.Usuario;
import validar.Validar;

/**
 * FXML Controller class
 *
 * @author 2dam
 */
public class LogInController {

    private static final Logger logger = Logger.getLogger("view.LogInController");
    private final int treinta = 30;
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

    private Stage stage = new Stage();
    private Usuario usuario;

    public LogInController() {

    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
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
    private void handleWindowShowing(WindowEvent event) {
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
    private void txtChanged(ObservableValue observable, String oldValue, String newValue) {
        Validar.addTextLimiter(txtUsuario, treinta);
        Validar.addTextLimiterPass(txtContrasena, treinta);
        if (!txtUsuario.getText().trim().equals("") && !txtContrasena.getText().trim().equals("")) {
            boolean isValidUsuario = Validar.isValid(txtUsuario, lblerrorusuario, "usuario invalido", "usuario valido");
            lblerrorusuario.setVisible(true);
            if (isValidUsuario) {
                btnIniciar.setDisable(false);
            } else {
                btnIniciar.setDisable(true);

            }
        }
        if (txtUsuario.getText().trim().equals("") || txtContrasena.getText().trim().equals("")) {

            btnIniciar.setDisable(true);
        }
    }
    /**
     *
     * @param event
     */

 private void btnIniciarClick(ActionEvent event) {
        logger.info("Ventana LogOut");
        usuario = new Usuario();
        usuario.setUsuario(txtUsuario.getText());
        usuario.setContrasena(txtContrasena.getText());
        Signable signable = new SignableFactory().getSignableImplementation();
        Alert alert;
        try {
            if(signable.logIn(usuario)!=null){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));

                    Parent root = (Parent) loader.load();

                    LogOutController controller = ((LogOutController) loader.getController());
                    controller.setUsuario(usuario);
                    controller.initStage(root);
                    stage.hide();
                } catch (IOException e) {
                    logger.severe("Alerta");
                }
            } else {
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("En este momento no podemos atender tu solicitud. Por favor, inténtalo en unos instantes.");
                alert.showAndWait();
            }
        } catch (AutenticacionFallidaException ex) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Contraseña Incorrecta");
            alert.showAndWait();
        } catch (ErrorBDException ex) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Imposible conectar con la base de datos");
            alert.showAndWait();
        } catch (ErrorServerException ex) {
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("El servidor no responde");
            alert.showAndWait();
        } catch (UsuarioNoEncontradoException ex) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No se ha encontrado el usuario introducido");
            alert.showAndWait();
        }

    }

    private void hlRegistrarseClick(ActionEvent event) {
        logger.info("Ventana LogOut");
        usuario = new Usuario();
        usuario.setNombre(txtUsuario.getText());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/SignUp.fxml"));

            Parent root = (Parent) loader.load();

            SignUpController controller = ((SignUpController) loader.getController());
            //controller.setUsuario(usuario);
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            logger.severe("Alerta");
        }
    }

}
