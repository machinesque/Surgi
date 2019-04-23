/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import visual.JfPrincipal;

/**
 *
 * @author luizam
 */
public class TraySurgi {

    private String nomeMusica;
    private TrayIcon trayIcon;
    private TraySurgi traySurgi;

    public TraySurgi() {
        // controla o nr de vezes que o TrayPlayer e instanciado
        //Verifica se o S.O. suporta TrayPlayer icon
        if (SystemTray.isSupported()) {
            
            //Obtem a bandeja do S.O.
            SystemTray tray = SystemTray.getSystemTray();
            
            //Carregando a imagem TrayPlayer.gif
            ImageIcon icone = new javax.swing.ImageIcon(getClass().getResource("/imagens/SURGI32x32.png"));
            Image image = icone.getImage();

            //ação de executar
            ActionListener actionListener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    mostraEsconde();
                }
            };

            //ação de sair
            ActionListener sairListener = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            
            ActionListener MiniMaxi = new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    mostraEsconde();
                }
            };
            
            /*ActionListener Proxima = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    proximaMusica();
                }
            };

            ActionListener Anterior = new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    musicaAnterior();
                }
            };*/

            PopupMenu popup = new PopupMenu();

            MenuItem restauraItem = new MenuItem("Aparece/Desaparece");
            restauraItem.addActionListener(MiniMaxi);
            popup.add(restauraItem);
            popup.addSeparator();

            /*MenuItem proxima = new MenuItem("Próxima");
            proxima.addActionListener(Proxima);
            popup.add(proxima);
            popup.addSeparator();

            MenuItem anterior = new MenuItem("Anterior");
            anterior.addActionListener(Anterior);
            popup.add(anterior);
            popup.addSeparator();*/

            MenuItem sairItem = new MenuItem("Sair");
            sairItem.addActionListener(sairListener);
            popup.add(sairItem);
            popup.addSeparator();

            // Criando o TrayPlayer icon e colocando o popup para o
            // clique com o botão direito
            trayIcon = new TrayIcon(image, "Felippsen Player", popup);

            //Auto-ajuste do tamanho
            trayIcon.setImageAutoSize(true);
            
            //Registrando o escutador para evento de clique com
            // botao esquerdo
            trayIcon.addActionListener(actionListener);

            try {
                tray.add(trayIcon);
            //balão de aviso

            } catch (AWTException e) {
                System.err.println("TrayIcon não pode ser adicionado no sistema.");
            }
        } else {
            System.err.println("Bandeja do sistema não é suportado.");
        }
    }
    
    public void setTrayIcon() {
        this.trayIcon = null;
    }

    public void setNomeMusica(String nome) {
        this.nomeMusica = nome;
        trayIcon.displayMessage("Surgi ", nome, TrayIcon.MessageType.INFO);
    }

    public TraySurgi getTraySurgi() {
        return traySurgi;
    }

    public void mostraEsconde() {
        Frame[] frame = JfPrincipal.getFrames();
        if (frame[0].isVisible()) {
            frame[0].setVisible(!(frame[0].isVisible()));
            setNomeMusica("Ainda estou executando aqui.");
        } else {
            frame[0].setVisible(!(frame[0].isVisible()));
            setNomeMusica("Você restaurou o player");
        }
        //JfPrincipal.class.getsetSelected(false);

    }
    
}
