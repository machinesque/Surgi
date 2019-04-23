/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Cmei;

/**
 *
 * @author luizam
 */
public class ControleCmei {
    
    private DAO dao;
    private Cmei cmei;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaCmei() {
        
        if (cmei == null) {
            cmei = new Cmei();
        }
        
    }
    
    public String getNomeCmei(int codgioCmei) {
        
        iniciaDAO();
        iniciaCmei();
        
        cmei = (Cmei) dao.busca(cmei, codgioCmei);
       
       return cmei.getNomeCmei();
        
    }
    
    public int getCodigoCmei(String nomeCmei) {
        
        iniciaDAO();
        iniciaCmei();
        
        cmei = (Cmei) dao.buscaCmei(0, nomeCmei, "");
        
        return cmei.getCodigoCmei();
        
    }
    
}
