/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Outro;

/**
 *
 * @author luizam
 */
public class ControleOutro {
    
    private DAO dao;
    private Outro outro;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaOutro() {
        
        if (outro == null) {
            outro = new Outro();
        }
        
    }
    
    public String getNomeOutro(int codgioOutro) {
        
        iniciaDAO();
        iniciaOutro();
        
        outro = (Outro) dao.busca(outro, codgioOutro);
       
        return outro.getNomeOutro();
        
    }
    
    public int getCodigoOutro(String nomeOutro) {
        
        iniciaDAO();
        iniciaOutro();
        
        outro = (Outro) dao.buscaOutro(0, nomeOutro, "");
        
        return outro.getCodigoOutro();
        
    }
    
}
