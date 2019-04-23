/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Linha;

/**
 *
 * @author luizam
 */
public class ControleLinha {
    
    private DAO dao;
    private Linha linha;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaLinha() {
        
        if (linha == null) {
            linha = new Linha();
        }
        
    }
    
    public int getNumeroLinha(int codgioLinha) {
        
        iniciaDAO();
        iniciaLinha();
        
        linha = (Linha) dao.busca(linha, codgioLinha);
       
        return linha.getNumeroLinha();
        
    }
    
    public int getCodigoLinha(int numeroLinha, int codigoBloco) {
        
        iniciaDAO();
        iniciaLinha();
        
        linha = (Linha) dao.buscaLinha(0, numeroLinha, codigoBloco);
        
        return linha.getCodigoLinha();
        
    }
    
}
