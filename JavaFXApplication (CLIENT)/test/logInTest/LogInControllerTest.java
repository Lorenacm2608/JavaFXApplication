/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logInTest;

import javafx.stage.Stage;
import javafxapplication.JavaFXApplication;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isFocused;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.util.NodeQueryUtils.hasText;

/**
 *
 * @author Lorena
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogInControllerTest extends ApplicationTest {

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

    }

    /**
     * Test que permite ver el estado inicial de la ventana
     */
    @Test
    public void testA_InitialState() {
        verifyThat("#txtUsuario", hasText(""));
        verifyThat("#txtUsuario", isFocused());
        verifyThat("#txtContrasena", hasText(""));
        verifyThat("#btnIniciar", isDisabled());
        verifyThat("#hlRegistrarse", isEnabled());
    }

    /**
     * Test que prueba que el boton Iniciar esta habilitado cuando los campos esten rellenos
     */
    @Test
    public void testB_IniciarIsEnabled() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtContrasena");
        write("password");
        verifyThat("#btnIniciar", isEnabled());
    }

    /**
     * Test que prueba que el boton Iniciar esta deshabilitado cuando uno de los campos estan vacios
     */
    @Test
    public void testC_IniciarIsDisabled() {
        clickOn("#txtUsuario");
        write("username");
        verifyThat("#btnIniciar", isDisabled());
        eraseText(8);
        clickOn("#txtContrasena");
        write("password");
        eraseText(8);
        verifyThat("#btnIniciar", isDisabled());
    }

    /**
     * Test que prueba la longitud maxima de los campos
     */
    @Test
    public void testD_maxLenght() {
        clickOn("#txtUsuario");
        write(num);
        eraseText(30);
        clickOn("#txtContrasena");
        write(num);
        eraseText(50);
        verifyThat("#btnRegistrar", isDisabled());
    }

    /**
     * Test que comprueba que la vista de LogOut es visible cuando se hace click en el boton Iniciar
     */
    @Test
    public void testE_LoginToLogOut() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtContrasena");
        write("password");
        clickOn("#btnIniciar");
        verifyThat("#pnSalida", isVisible());
    }

    /**
     * Test que comprueba que la vista de SignUp es visible cuando se hace click en el boton Registrar
     */
    @Test
    public void testF_LoginToSignUp() {
        clickOn("#btnVolver");
        clickOn("#hlRegistrarse");
        verifyThat("#pnRegistrar", isVisible());
    }

}
