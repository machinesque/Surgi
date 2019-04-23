/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Usuario;

/**
 *
 * @author luizam
 */
public class ControleUsuario {
    
    private DAO dao;
    private Usuario usuario;
            
    public void iniciaDao() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaUsuario() {
        
        if (usuario == null) {
            usuario = new Usuario();
        }
        
    }
    
    public String getNomeUsuario(int codgioUsuario) {
        
       iniciaDao();
       iniciaUsuario();
        
       usuario = (Usuario) dao.busca(usuario, codgioUsuario);
       
       return usuario.getNomeUsuario();
        
    }
    
    public int getCodigoUsuario(String nomeUsuario) {
        
        if (nomeUsuario.isEmpty()) {
            
            return 0;
            
        } else {
            
            iniciaDao();
            iniciaUsuario();
        
            usuario = (Usuario) dao.buscaUsuario(0, nomeUsuario, "");
        
            return usuario.getCodigoUsuario();
        
        }
        
    }
    
}
