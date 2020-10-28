/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validar;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;



/**
 *
 * @author essad
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
    public static boolean isValidEmail(TextField tf, Label lb, String errorMessage, String noError){
        boolean b=true;
        String msg = null;
        tf.getStyleClass().remove("error");
        if(!IsValidEmail (tf)){
            b=false;
            msg = errorMessage;
            tf.getStyleClass().add("error");
        }else{
            msg = noError;
        }
        lb.setText(msg);
        return b;
    }
    
    public static boolean isValidContrasena(PasswordField tf, PasswordField tff, Label lb, String errorMessage, String noError){
        boolean b=true;
        String msg = null;
        if(!(tf.getText().equals(tff.getText()))){
            b=false;
            msg = errorMessage;
        }else{
            msg = noError;
        }
        lb.setText(msg);
        return b;
    }

    
    
    public static void addTextLimiter( TextField tf,  int treinta){
        
        if (tf.getText().length() > treinta) {
                String s = tf.getText().substring(0, treinta);
                tf.setText(s);
            }
    }
    public static void addTextLimiterPass( PasswordField tf,  int treinta){
        
        if (tf.getText().length() > treinta) {
                String s = tf.getText().substring(0, treinta);
                tf.setText(s);
            }
    }
    public static void addTextLimiterGrande( TextField tf,  int cincuenta){
        
        if (tf.getText().length() > cincuenta) {
                String s = tf.getText().substring(0, cincuenta);
                tf.setText(s);
            }
    }
    
}
