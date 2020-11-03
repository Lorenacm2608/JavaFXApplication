/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logOutTest;

import javafx.stage.Stage;
import javafxapplication.JavaFXApplication;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 *
 * @author Lorena
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogOutControllerTest extends ApplicationTest {

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
     * Test que inicia la ventana LogOut
     */
    @Test
    public void testA_iniciarBoton() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtContrasena");
        write("password");
        clickOn("#btnIniciar");
        verifyThat("#pnSalida", isVisible());

    }
    /**
     * Test que permite ver el estado inicial de la ventana
     */
    @Test
    public void testB_InitialState() {
        verifyThat("#btnVolver", isEnabled());
    }

    /**
     * Test que comprueba que la vista del LogIn es visible cuando se hace click en el boton Volver
     */
    @Test
    public void testC_LogoutToLogin() {
        clickOn("#txtUsuario");
        write("username");
        clickOn("#txtContrasena");
        write("password");
        clickOn("#btnIniciar");
        verifyThat("#pnSalida", isVisible());
        
        clickOn("#btnVolver");
        verifyThat("#pnPrincipal", isVisible());
    }

}
