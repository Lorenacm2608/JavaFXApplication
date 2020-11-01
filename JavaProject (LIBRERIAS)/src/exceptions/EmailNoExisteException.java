/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Lorena
 */
public class EmailNoExisteException extends Exception{

    public EmailNoExisteException() {
        super("Email no encontrado");
    }
    
 
}
