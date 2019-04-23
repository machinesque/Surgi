/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import modelo.Ata;
import modelo.Cmei;
import modelo.Escola;
import modelo.Outro;
import modelo.Usuario;

/**
 *
 * @author luizam
 */
public class EnviaEmail {

    private Ata ata;
    private Outro outro;
    private Cmei cmei;
    private Escola escola;
    private DAO dao;
    private Usuario usuario;
    
    private Properties props = new Properties();
    private Session session;
    private Message msg;
    
    private String emailDestinatario = "";
    private String emailRemetente;
    
    public void enviarEmail(String tipoEntidade, String nomeEntidade, Date dataEnvio, int codigoUsuario, String modelo, String codigoBarra) {

        iniciaDao();
        
        
        emailDestinatario = getEmailDestinatário(tipoEntidade, nomeEntidade);
        emailRemetente = getEmailRemetente(codigoUsuario);
        
        if (emailDestinatario.isEmpty() || emailDestinatario == null) {
            //não faz nada
        } else {
            
            props.put("mail.transport.protocol", "smtp");//protocolo usando smtp
            props.put("mail.smtp.auth", "true");//indica que necessita de autenticação para acessar ao servidor
            props.put("mail.smtp.host","smtp.cascavel.pr.gov.br");//set host de smtp
            //props.put("mail.smtp.host","192.168.0.11");//set host de smtp
            //props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            session = Session.getDefaultInstance(props, new EmailAutenticador());//objeto que realiza a conexão com o servidor
            session.setDebug(true);//habilita o log das ações durante o envio do email
            
            msg = new MimeMessage(session);
            
            try {
                
                //System.out.println(emailDestinatario);
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));//setando destinatario
                //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("informaticasemed@cascavel.pr.gov.br"));
                msg.setFrom(new InternetAddress("luizam@cascavel.pr.gov.br"));//setando remetente
                msg.setSubject("Recarga de Toners");
                msg.setText(tipoEntidade + " " + nomeEntidade + "\n\n" + "O " + modelo + " de código " + codigoBarra + " esta recarregado e disponivel no Setor de Informática Educacional!" + "\n" + dataEnvio.getDate() + "/" + 
                        (dataEnvio.getMonth() + 1) + "/" + (dataEnvio.getYear() + 1900) + "\n\n" + "Esta mensagem é gerada automaticamente, não é necessário respondê-la!" + 
                        "\n\n" + "Obrigado!" + "\n\n" + "Informática Educacional");
            
            } catch (MessagingException ex) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro antes do envio!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
            try {
                
                Transport.send(msg);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);
                
            } catch (MessagingException messagingException) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, messagingException);
                JOptionPane.showMessageDialog(null, "Email não pode ser enviado!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
        }
        
    }
    
    public void enviarEmailNaoDeuRecarga(String tipoEntidade, String nomeEntidade, Date dataEnvio, int codigoUsuario, String modelo, String codigoBarra) {

        iniciaDao();
        
        
        emailDestinatario = getEmailDestinatário(tipoEntidade, nomeEntidade);
        emailRemetente = getEmailRemetente(codigoUsuario);
        
        if (emailDestinatario.isEmpty() || emailDestinatario == null) {
            //não faz nada
        } else {
            
            props.put("mail.transport.protocol", "smtp");//protocolo usando smtp
            props.put("mail.smtp.auth", "true");//indica que necessita de autenticação para acessar ao servidor
            props.put("mail.smtp.host","smtp.cascavel.pr.gov.br");//set host de smtp
            //props.put("mail.smtp.host","192.168.0.11");//set host de smtp
            //props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            session = Session.getDefaultInstance(props, new EmailAutenticador());//objeto que realiza a conexão com o servidor
            session.setDebug(true);//habilita o log das ações durante o envio do email
            
            msg = new MimeMessage(session);
            
            try {
                
                //System.out.println(emailDestinatario);
                msg.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));//setando destinatario
                //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("informaticasemed@cascavel.pr.gov.br"));
                msg.setFrom(new InternetAddress("luizam@cascavel.pr.gov.br"));//setando remetente
                msg.setSubject("Toner não deu mais recarga");
                msg.setText(tipoEntidade + " " + nomeEntidade + "\n\n" + "Informamos que o " + modelo + " de código " + codigoBarra + " não deu mais recarga!" + "\n" + dataEnvio.getDate() + "/" + 
                        (dataEnvio.getMonth() + 1) + "/" + (dataEnvio.getYear() + 1900) + "\n\n" + "Esta mensagem é gerada automaticamente, não é necessário respondê-la!" + 
                        "\n" + "Obrigado!" + "\n\n" + "Informática Educacional");
            
            } catch (MessagingException ex) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro antes do envio!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
            try {
                
                Transport.send(msg);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);
                
            } catch (MessagingException messagingException) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, messagingException);
                JOptionPane.showMessageDialog(null, "Email não pode ser enviado!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
        }
        
    }
    
    public void enviarEmailVencimentoAta(int numeroAta, int numeroModalidade, int numeroProcesso, String objeto, Date dataAta, int codigoUsuario) {

        iniciaDao();
        
        //emailDestinatario = getEmailDestinatário(tipoEntidade, nomeEntidade);
        emailDestinatario = "deboral@cascavel.pr.gov.br; andressah@cascavel.pr.gov.br; marciap@cascavel.pr.gov.br";
        //emailRemetente = getEmailRemetente(codigoUsuario);
        emailRemetente = "luizam@cascavel.pr.gov.br";
        
        if (emailDestinatario.isEmpty() || emailDestinatario == null) {
            //não faz nada
        } else {
            
            props.put("mail.transport.protocol", "smtp");//protocolo usando smtp
            props.put("mail.smtp.auth", "true");//indica que necessita de autenticação para acessar ao servidor
            props.put("mail.smtp.host","smtp.cascavel.pr.gov.br");//set host de smtp
            //props.put("mail.smtp.host","192.168.0.11");//set host de smtp
            //props.put("mail.smtp.host","smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            
            session = Session.getDefaultInstance(props, new EmailAutenticador());//objeto que realiza a conexão com o servidor
            session.setDebug(true);//habilita o log das ações durante o envio do email
            
            msg = new MimeMessage(session);
            
            try {
                
                String[] destinatarios = {"deboral@cascavel.pr.gov.br", "andressah@cascavel.pr.gov.br", "marciap@cascavel.pr.gov.br"};
                //String[] destinatarios = {"luizam@cascavel.pr.gov.br"};
            
                InternetAddress[] enderecoEmail = new InternetAddress[destinatarios.length];
                
                for (int i = 0; i < destinatarios.length; i++) {
                    
                    enderecoEmail[i] = new InternetAddress(destinatarios[i]);
                
                }
                
                //System.out.println(emailDestinatario);
                msg.setRecipients(Message.RecipientType.TO, enderecoEmail);//setando destinatario
                //msg.setRecipient(Message.RecipientType.TO, new InternetAddress("luizam@cascavel.pr.gov.br"));
                msg.setFrom(new InternetAddress("luizam@cascavel.pr.gov.br"));//setando remetente
                msg.setSubject("Ata: Data de publicação está vencendo");
                msg.setText("A Ata nº: " + numeroAta + "\n" + "Modalidade n:" + numeroModalidade + "\n" + "Processo nº:" + numeroProcesso + "\n" + "Objeto:" + objeto + "\n" +                     
                        "tem vencimento em " + dataAta.getDate() + "/" + (dataAta.getMonth()+1) + "/" + (dataAta.getYear()+1900) + "." + "\n\n" +
                        "Esta mensagem é gerada automaticamente, não é necessário respondê-la!" + "\n" + "Obrigado!" + "\n\n" + "Informática Educacional");
            
                iniciaAta();
                iniciaDao();
                
                ata = (Ata) dao.busca(ata, numeroAta);
                
                ata.setEmailEnviado(true);
                
                dao.atualizar(ata, 0, codigoUsuario);
                
                
            } catch (MessagingException ex) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro antes do envio!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
            try {
                
                Transport.send(msg);
                JOptionPane.showMessageDialog(null, "Email enviado com sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);
                
            } catch (MessagingException messagingException) {
                Logger.getLogger(EnviaEmail.class.getName()).log(Level.SEVERE, null, messagingException);
                JOptionPane.showMessageDialog(null, "Email não pode ser enviado!", "Erro", JOptionPane.ERROR_MESSAGE, null);
            }
            
        }
        
    }
    
//Getters and Setters ====================================================================================================================================================
    public String getEmailDestinatário(String tipoEntid, String nomeEntid) {
        
        String destinatario = "";
        
        iniciaDao();
        
        switch (tipoEntid) {
            
            case "OUTROS":
                outro = (Outro) dao.buscaOutro(0, nomeEntid, "");
                destinatario = outro.getEmailOutro();
                break;
                
            case "CMEI":
                cmei = (Cmei) dao.buscaCmei(0, nomeEntid, "");
                destinatario = cmei.getEmailCmei();
                break;
                
            case "ESCOLA":
                escola = (Escola) dao.buscaEscola(0, nomeEntid, "");
                destinatario = escola.getEmailEscola();
                break;
            
        }
        
        return destinatario;
        
    }
    
    public String getEmailRemetente(int codigoUsuario) {
        
        iniciaUsuario();
        
        String remetente;
        
        iniciaDao();
        
        usuario = (Usuario) dao.busca(usuario, codigoUsuario);
        remetente = usuario.getEmailUsuario();
        
        return remetente;
        
    }
    
//Geradores, Validadores ===================================================================================================================================================================
    public void iniciaAta() {

        if (ata == null) {
            ata = new Ata();
        }
        
    }
    
    public void iniciaDao() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaUsuario() {
        
        if (usuario == null) {
            usuario = new Usuario();
        }
        
    }
    
}