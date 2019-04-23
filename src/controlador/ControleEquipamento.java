/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Equipamento;

/**
 *
 * @author luizam
 */
public class ControleEquipamento {
   
    private DAO dao;
    private Equipamento equipamento;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaEquipamento() {
        
        if (equipamento == null) {
            equipamento = new Equipamento();
        }
        
    }
    
    public int getCodigoEquipamento(String patrimonioEquipamento) {
        
        iniciaDAO();
        iniciaEquipamento();
        
        equipamento = (Equipamento) dao.buscaEquipamento(0, "", "", patrimonioEquipamento);
        
        return equipamento.getCodigoEquipamento();
        
    }
    
}
