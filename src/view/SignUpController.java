/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import exceptions.EmailExistenteException;
import exceptions.ErrorBDException;
import exceptions.ErrorServerException;
import exceptions.UsuarioExistenteException;
import java.io.IOException;
import java.util.logging.Level;
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
import javafx.scene.control.Alert;
import libreries.Signable;
import libreries.Usuario;
import libreries.SignableFactory;
import validar.Validar;

/**
 *
 * @author 2dam
 */
public class SignUpController {

    private static final Logger logger = Logger.getLogger("view.SignUpController");

    private final int treinta = 30;
    private final int cincuenta = 50;
    @FXML
    private TextField txtUsuario;
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
    private Label lblNocoinciden;
    @FXML
    private Label lblUsuarioError;
    @FXML
    private Label lblNombreError;

    private Stage stage = new Stage();
    private Usuario usuario;

    public SignUpController() {

    }

    public Stage getStage() {
        return this.stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void initStage(Parent root) {
        // Create a scene associated to the node graph root
        Scene scene = new Scene(root);
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

        // addTextLimiter(txtEmail, treinta);
        txtUsuario.textProperty().addListener(this::txtChanged);
        txtEmail.textProperty().addListener(this::txtChanged);
        txtNombre.textProperty().addListener(this::txtChanged);
        txtContrasena.textProperty().addListener(this::txtChanged);
        txtConfirmarContrasena.textProperty().addListener(this::txtChanged);

        // Show primary window
        stage.show();

    }

    private void handleWindowShowing(WindowEvent event) {

        btnRegistrar.setDisable(true);
        lblEmailIncorrecto.setVisible(false);
        lblNocoinciden.setVisible(false);
        lblUsuarioError.setVisible(false);
        lblNombreError.setVisible(false);
    }

    private void txtChanged(ObservableValue observable, String oldValue, String newValue) {

        Validar.addTextLimiter(txtUsuario, treinta);
        Validar.addTextLimiterPass(txtContrasena, treinta);
        Validar.addTextLimiterGrande(txtEmail, cincuenta);
        Validar.addTextLimiterGrande(txtNombre, cincuenta);
        Validar.addTextLimiterPass(txtConfirmarContrasena, treinta);

        if (!txtUsuario.getText().trim().equals("") && !txtContrasena.getText().trim().equals("") && !txtEmail.getText().trim().equals("") && !txtNombre.getText().trim().equals("") && !txtConfirmarContrasena.getText().trim().equals("")) {
            boolean isValidEmail = Validar.isValidEmail(txtEmail, lblEmailIncorrecto, "Email invalido!", "Email valido");
            lblEmailIncorrecto.setVisible(true);

            boolean isValidContrasena = Validar.isValidContrasena(txtContrasena, txtConfirmarContrasena, lblNocoinciden, "No coinciden", "Coinciden");
            lblNocoinciden.setVisible(true);

            boolean isValidUsuario = Validar.isValid(txtUsuario, lblUsuarioError, "Usuario invalido!", "Usuario valido");
            lblUsuarioError.setVisible(true);

            boolean isValidNombre = Validar.isValid(txtNombre, lblNombreError, "Nombre invalido!", "Nombre valido");
            lblNombreError.setVisible(true);

            if (isValidEmail && isValidContrasena && isValidUsuario && isValidNombre) {
                btnRegistrar.setDisable(false);
            } else {
                btnRegistrar.setDisable(true);
            }
        }
        if (txtUsuario.getText().trim().equals("") || txtContrasena.getText().trim().equals("") || txtEmail.getText().trim().equals("") || txtNombre.getText().trim().equals("") || txtConfirmarContrasena.getText().trim().equals("")) {
            btnRegistrar.setDisable(true);
        }
    }

    private void hlCancerClick(ActionEvent event) {
        logger.info("Ventana LogIn");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogIn.fxml"));

            Parent root = (Parent) loader.load();

            LogInController controller = ((LogInController) loader.getController());
            //controller.setUsuario(usuario);
            controller.initStage(root);
            stage.hide();
        } catch (IOException e) {
            logger.severe("Alerta");
        }
    }

    private void btnRegistrarClick(ActionEvent event) {
        logger.info("Ventana LogOut");
        usuario = new Usuario();
        usuario.setNombre(txtNombre.getText());
        usuario.setEmail(txtEmail.getText());
        usuario.setUsuario(txtUsuario.getText());
        usuario.setContrasena(txtContrasena.getText());
        usuario.setUltimaContrasenia(txtContrasena.getText());
        Signable signable = new SignableFactory().getSignableImplementation();
        Alert alert;
        try {
            if (signable.signUp(usuario) != null) {;

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogOut.fxml"));

                    Parent root;
                    root = (Parent) loader.load();
                    LogOutController controller = ((LogOutController) loader.getController());
                    controller.setUsuario(usuario);
                    controller.initStage(root);
                    stage.hide();
                } catch (IOException ex) {
                    Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informacion");
                alert.setHeaderText("En este momento no podemos atender tu solicitud. Por favor, inténtalo en unos instantes.");
                alert.showAndWait();
            }

        } catch (EmailExistenteException ex) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Email ya registrado");
            alert.showAndWait();
        } catch (ErrorBDException ex) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Imposible conectar con la base de datos");
            alert.showAndWait();
        } catch (ErrorServerException ex) {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("El servidor no responde");
            alert.showAndWait();
        } catch (UsuarioExistenteException ex) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Usuario ya registrado");
            alert.showAndWait();
        }
    }
}
