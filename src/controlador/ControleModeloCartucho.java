/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.ModeloCartucho;

/**
 *
 * @author luizam
 */
public class ControleModeloCartucho {
   
    private DAO dao;
    private ModeloCartucho modeloCartucho;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaModeloCartucho() {
        
        if (modeloCartucho == null) {
            modeloCartucho = new ModeloCartucho();
        }
        
    }
    
    public int getCodigoModeloCartucho(String nomeModeloCartucho) {
        
        
        iniciaDAO();
        iniciaModeloCartucho();
        
        modeloCartucho = (ModeloCartucho) dao.buscaModeloCartucho(0, nomeModeloCartucho);
        
        return modeloCartucho.getCodigoModeloCartucho();
        
    }
    
}
