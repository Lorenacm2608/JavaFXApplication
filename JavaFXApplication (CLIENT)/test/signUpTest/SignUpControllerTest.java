package signUpTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.stage.Stage;
import javafxapplication.JavaFXApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.util.NodeQueryUtils.hasText;

/**
 *
 * @author Lorena
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SignUpControllerTest extends ApplicationTest {

    public String num = "123456789123456789123456789123456789123456789123456789123456789";

    /**
     * Inicia la aplicacion para testearla
     * 
     * @param stage, Objeto Stage
     * @throws Exception, si ocurre algun error
     */
    @Override
    public void start(Stage stage) throws Exception {
        new JavaFXApplication().start(stage);
        clickOn("#hlRegistrarse");
    }
    
    /**
     * Test que permite ver el estado inicial de la ventana
     */
    @Test
    public void testA_InitialState() {
        verifyThat("#txtUsuario", hasText(""));
        verifyThat("#txtEmail", hasText(""));
        verifyThat("#txtNombre", hasText(""));
        verifyThat("#txtContrasena", hasText(""));
        verifyThat("#txtConfirmarContrasena", hasText(""));
        verifyThat("#btnRegistrar", isDisabled());
        verifyThat("#btnCancelar", isEnabled());

    }
    
    /**
     *  Test que prueba que el boton Registrar esta habilitado cuando los campos estan rellenos
     */
    @Test
    public void testB_RegistrarIsEnabled() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtEmail");
        write("email@gmail.com");
        clickOn("#txtNombre");
        write("user");
        clickOn("#txtContrasena");
        write("password");
        clickOn("#txtConfirmarContrasena");
        write("password");
        verifyThat("#btnRegistrar", isEnabled());
    }
    
    /**
     * Test que prueba que el boton Registrar esta deshabilitado cuando uno de los campos estan vacios
     */
    @Test
    public void testC_RegistrarIsDisabled() {
        clickOn("#txtUsuario");
        write("username");
        verifyThat("#btnRegistrar", isDisabled());
        eraseText(8);
        clickOn("#txtEmail");
        write("email@gmail.com");
        verifyThat("#btnRegistrar", isDisabled());
        eraseText(15);
        clickOn("#txtNombre");
        write("user");
        verifyThat("#btnRegistrar", isDisabled());
        eraseText(4);
        clickOn("#txtContrasena");
        write("password");
        verifyThat("#btnRegistrar", isDisabled());
        eraseText(8);
        clickOn("#txtConfirmarContrasena");
        write("password");
        verifyThat("#btnRegistrar", isDisabled());
        eraseText(8);
        clickOn("#btnCancelar");

    }
    
    /**
     * Test que prueba la longitud maxima de los campos
     */
    @Test
    public void testD_maxLenght() {
        clickOn("#txtUsuario");
        write(num);
        eraseText(30);
        clickOn("#txtEmail");
        write(num);
        eraseText(50);
        clickOn("#txtNombre");
        write(num);
        eraseText(50);
        clickOn("#txtContrasena");
        write(num);
        eraseText(30);
        clickOn("#txtConfirmarContrasena");
        write(num);
        eraseText(30);
        verifyThat("#btnRegistrar", isDisabled());
    }

    /**
     * Test que comprueba que la vista del LogOut es visible cuando se hace click en el boton Registrar
     */
    @Test
    public void testE_SignUpToLogout() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtEmail");
        write("email@gmail.com");
        clickOn("#txtNombre");
        write("user");
        clickOn("#txtContrasena");
        write("password");
        clickOn("#txtConfirmarContrasena");
        write("password");
        clickOn("#btnRegistrar");
        verifyThat("#pnSalida", isVisible());
    }

}
