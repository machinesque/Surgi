/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author luizam
 */
public class EmailAutenticador extends Authenticator {

    public synchronized PasswordAuthentication getPasswordAuthentication() {
        String usuario = null, senha = null;
//É criada um JPanel e inserido no ConfirmDialog

        //usuario = "machinesque@gmail.com";
        //senha = "B5ld86bCsdvu718*";
        usuario = "luizam";
        senha = "B5ld86b";
        /*
         * PasswordAuthentication é o objeto responsável por transportar as
         * informações de autenticação
         */
        return new PasswordAuthentication(usuario, senha);
    }
}
