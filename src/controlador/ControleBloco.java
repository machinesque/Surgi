/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Bloco;

/**
 *
 * @author luizam
 */
public class ControleBloco {
    
    private DAO dao;
    private Bloco bloco;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaBloco() {
        
        if (bloco == null) {
            bloco = new Bloco();
        }
        
    }
    
    public String getNomeBloco(int codgioBloco) {
        
        iniciaDAO();
        iniciaBloco();
        
        bloco = (Bloco) dao.busca(bloco, codgioBloco);
       
        return bloco.getNomeBloco();
        
    }
    
    public String getNomeBloco(String numeroNomeBloco) {
        
        int contador = 0;
        String nomeBloco = numeroNomeBloco;
        
        for (int i = 0; i < numeroNomeBloco.length(); i++) {
            
            if (contador == 0) {
                
                if (nomeBloco.contains("-")) {
                    nomeBloco = numeroNomeBloco.substring(i);
                } else {
                    nomeBloco = numeroNomeBloco.substring(i);
                    contador =+ 1;
                }
            
            } 
            
        }
        
        return nomeBloco;
        
    }
    
    public int getCodigoBloco(String nomeBloco) {
        
        iniciaDAO();
        iniciaBloco();
        
        bloco = (Bloco) dao.buscaBloco(0, nomeBloco);
        
        return bloco.getCodigoBloco();
        
    }
    
}
