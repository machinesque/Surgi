/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author luizam
 */
public class AtualizaSurgi implements Runnable {

    public void run() {
        atualizarSoftware();
    }

    public void atualizarSoftware() {

        try {
            Process processo2 = Runtime.getRuntime().exec("M:\\AtualizacaoSURGI.exe");
        } catch (IOException ex) {
            //Logger.getLogger(jfSobre.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar, ou é necessário Mapear a Rede!", "Erro", JOptionPane.ERROR_MESSAGE, null);
        }

    }

}
