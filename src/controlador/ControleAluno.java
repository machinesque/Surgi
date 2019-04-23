/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Aluno;

/**
 *
 * @author luizam
 */
public class ControleAluno {
    
    private DAO dao;
    private Aluno aluno;
            
    public void iniciaDAO() {
        
        if (dao == null) {
            dao = new DAO();
        }
        
    }
    
    public void iniciaAluno() {
        
        if (aluno == null) {
            aluno = new Aluno();
        }
        
    }
    
    public String getNomeAluno(int codgioAluno) {
        
       iniciaAluno();
        
       aluno = (Aluno) dao.busca(aluno, codgioAluno);
       
       return aluno.getNomeAluno();
        
    }
    
    public int getCodigoAluno(String nomeAluno) {
        
        iniciaAluno();
        
        aluno = (Aluno) dao.buscaAluno(0, nomeAluno);
        
        return aluno.getCodigoAluno();
        
    }
    
}
