/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import java.util.Date;
import java.util.GregorianCalendar;
import modelo.Usuario;
import modelo.VersaoUsuario;

/**
 *
 * @author luiz
 */
public class ControleVersao {

    private DAO dao;
    private VersaoUsuario versaoUsuario = new VersaoUsuario();
    private GregorianCalendar calendar;
    private Usuario usuario;
    
    private String versaoAtual;
    private String versaoSistema = "4.2";
    private String ano;
    private int codigoUsuario;

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getVersao() {
        iniciaDao();
        return versaoSistema;
    }
    
    public void setCodigoUsuario(int codigoUsuario) {
      
        iniciaDao();
        iniciaUsuario();
        iniciaVersaoUsuario();
        
        usuario = (Usuario) dao.busca(usuario, codigoUsuario);
        
        versaoUsuario.setUsuario(usuario);
        this.codigoUsuario = codigoUsuario;
        System.out.println("Codigo de Usuario = " + codigoUsuario);
        versaoUsuario.setVersaoAtual(dao.getVersaoUsuario(codigoUsuario));
        versaoAtual = dao.getVersaoAtual();
        
    }
    
//Geradores, Validadores===========================================================================================================================================
    public Date getDateHoje() {

        iniciaCalendar();
        Date data = calendar.getTime();

        return data;

    }
    
    public String getAno() {
        
        iniciaCalendar();
        Date data = calendar.getTime();

        String ano2 = (data.getYear() + 1900 + "");

        return ano2;
    }
    
    public boolean comparaVersao() {
        
        boolean avancar;
        
        iniciaDao();
        
        if (versaoSistema.equals(versaoAtual)) {
            avancar = true;
            salvar();
        } else {
            avancar = false;
        }
        
        return avancar;
        
    }
    
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
    
    public void iniciaVersaoUsuario() {
        
        if  (versaoUsuario == null) {
            versaoUsuario = new VersaoUsuario();
        }
        
    }
    
    public void iniciaCalendar() {
        
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        
    }

//Metodos DAO===============================================================================================================================================================
    public void salvar() {
        
        iniciaDao();
        iniciaUsuario();
        iniciaVersaoUsuario();
        String versaoAtualUsuario = versaoUsuario.getVersaoAtual();
        
        if (versaoAtualUsuario.equals(versaoSistema)) {
            System.out.println("Versão OK!");
        } else {
            
            System.out.println("Codigo de Usuario = " + codigoUsuario);
            
            usuario = (Usuario) dao.busca(usuario, this.codigoUsuario);
            
            versaoUsuario.setUsuario(usuario);
            versaoUsuario.setDataAtualizacao(getDateHoje());
            versaoUsuario.setVersaoAtual(versaoAtual);
            
            dao.inserir(versaoUsuario, 0, codigoUsuario);
            
        }
        
    }
    
}
