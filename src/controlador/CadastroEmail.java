/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author luizam
 */
public class CadastroEmail {

    public String verificaArroba(String email) {

        if (email.contains("@")) {

            String caracterVerificado;
            int posicaoArroba = 0;

            for (int i = 0; i < email.length(); i++) {

                caracterVerificado = String.valueOf(email.charAt(i));

                if (caracterVerificado.equals("@")) {
                    posicaoArroba = i;
                }

            }

            return email.substring(0, posicaoArroba);

        } else {
            
            return email;
            
        }

    }
}
