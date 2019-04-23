/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.DepartamentoDivisaoSetor;

/**
 *
 * @author luizam
 */
public class ControleDepartamentoDivisaoSetor {
    
    private DAO dao;
    private DepartamentoDivisaoSetor departamentoDivisaoSetor;
    
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaDepartamentoDivisaoSetor() {
        
        if (departamentoDivisaoSetor == null) {
            departamentoDivisaoSetor = new DepartamentoDivisaoSetor();
        }
        
    }
    
    public int getCodigoDepartamentoDivisaoSetor(String nomeDepartamentoDivisaoSetor) {
        
        iniciaDAO();
        iniciaDepartamentoDivisaoSetor();
        
        departamentoDivisaoSetor = (DepartamentoDivisaoSetor) dao.buscaDepartamentoDivisaoSetor(0, nomeDepartamentoDivisaoSetor);
        
        return departamentoDivisaoSetor.getCodigoDepartamentoDivisaoSetor();
        
    }
    
}
