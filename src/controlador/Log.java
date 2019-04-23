/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.DAO;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import modelo.Log2;
import modelo.Usuario;

/**
 *
 * @author luizam
 */
public class Log {

    private DAO dao;
    private Log2 log2;
    private Usuario usuario;
    
    //static Logger logger = Logger.getLogger(Log.class);

    public Log(){

    }

    public void criaLog(int codigoUsuario, String documentoAcao, String acao) throws IOException {

        //BasicConfigurator.configure();

        Calendar calendario = Calendar.getInstance();

        /* Cria um novo FileAppender baseado no layout padrão,
          * pré-definido na constante TTCC_CONVERSION_PATTERN
          * da classe PatternLayout. */
        /*Appender fileAppender = new FileAppender(
                new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN), "M://agendamentoLogFile.log");

        logger.addAppender(fileAppender);

        try {
            logger.debug(usuario+": Tela/Janela de "+documentoAcao+" - "+acao+" ("+ calendario.getTime()+");");
            logger.removeAllAppenders();
            //throw new Exception("Loga esse no arquivo, Log4J!");
        } catch (Exception e) {
            logger.error("Oops, deu erro: " + e.getMessage());
        }*/

        inserir(codigoUsuario, documentoAcao, acao, calendario.getTime());
        
    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaDao() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaLog() {
        
        if (log2 == null) {
            log2 = new Log2();
        }
        
    }
    
    public void iniciaUsuario() {
        
        if (usuario == null) {
            usuario = new Usuario();
        }
        
    }
    
//DAO=============================================================================================================================================
    public void inserir(int codigoUsuario, String telaJanelaAcao, String acao, Date dataAcao) {
        
        iniciaDao();
        iniciaLog();
        iniciaUsuario();
        
        log2.setAcao(acao);
        
        usuario = (Usuario) dao.busca(usuario, codigoUsuario);
        log2.setUsuario(usuario);
        
        log2.setTelaJanela(telaJanelaAcao);
        log2.setDataAcao(dataAcao);
        
        dao.inserir(log2, 0, codigoUsuario);
        log2 = null;
        usuario = null;
        
    }

}
