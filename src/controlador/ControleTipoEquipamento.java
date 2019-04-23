/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.TipoEquipamento;

/**
 *
 * @author luizam
 */
public class ControleTipoEquipamento {
   
    private DAO dao;
    private TipoEquipamento tipoEquipamento;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaTipoEquipamento() {
        
        if (tipoEquipamento == null) {
            tipoEquipamento = new TipoEquipamento();
        }
        
    }
    
    public int getCodigoEquipamento(String nomeTipoEquipamento) {
        
        iniciaDAO();
        iniciaTipoEquipamento();
        
        tipoEquipamento = (TipoEquipamento) dao.buscaTipoEquipamento(0, nomeTipoEquipamento);
        
        return tipoEquipamento.getCodigoTipoEquipamento();
        
    }
    
}
