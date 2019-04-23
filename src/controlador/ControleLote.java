/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Lote;

/**
 *
 * @author luizam
 */
public class ControleLote {
    
    private DAO dao;
    private Lote lote;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaLote() {
        
        if (lote == null) {
            lote = new Lote();
        }
        
    }
    
    public String getNomeLote(int codgioLote) {
        
        iniciaDAO();
        iniciaLote();
        
        lote = (Lote) dao.busca(lote, codgioLote);
       
        return lote.getNomeLote();
        
    }
    
    public String getNomeLote(String numeroNomeLote) {
        
        int contador = 0;
        String nomeLote = numeroNomeLote;
        
        for (int i = 0; i < numeroNomeLote.length(); i++) {
            
            if (contador == 0) {
                
                if (nomeLote.contains("-")) {
                    nomeLote = numeroNomeLote.substring(i);
                } else {
                    nomeLote = numeroNomeLote.substring(i);
                    contador =+ 1;
                }
            
            } 
            
        }
        
        return nomeLote;
        
    }
    
    public int getCodigoLote(String nomeLote) {
        
        iniciaDAO();
        iniciaLote();
        
        lote = (Lote) dao.buscaLote(0, nomeLote, "");
        
        return lote.getCodigoLote();
        
    }
    
}
