/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package excecoes;

import javax.swing.JOptionPane;

/**
 *
 * @author luizam
 */
public class MensagensExcessao {

    public void setMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE, null);
    }

    public void setMensagemAtencao(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Atenção", JOptionPane.WARNING_MESSAGE, null);
    }

}
