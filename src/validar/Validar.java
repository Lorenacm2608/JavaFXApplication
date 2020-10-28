/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validar;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author pocoy
 */
public class Validar {
    public static boolean IsValidEmail(TextField tf){
        boolean b=false;
        String pattern = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        if(tf.getText().matches(pattern)){
            b=true;
        }
        return b;
    }
    public static boolean isValidEmail(TextField tf, Label lb, String errorMessage){
        boolean b=true;
        String msg = null;
        tf.getStyleClass().remove("error");
        if(!IsValidEmail (tf)){
            b=false;
            msg = errorMessage;
            tf.getStyleClass().add("error");
        }
        lb.setText(msg);
        return b;
    }  
    public static boolean isValidTamano(TextField txtUsuario, Label lb,String errorMessage){
        boolean b = true;
        int tamano = 30;
        String msg = null;
        String usuario = txtUsuario.getText().trim();
        int usu = usuario.length();
        if(usu>tamano && usu>0){
            b = false;
            msg = errorMessage;
        }
        lb.setText(msg);
        return b;
    }
}