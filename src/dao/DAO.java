/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import controlador.Log;
import excecoes.ExcCadastro;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import visual.JfPrincipal;

/**
 *
 * @author Administrador
 */
public class DAO {

    private static SessionFactory factory;
    private HibernateUtil hibernateUtil = new HibernateUtil();
    private Agendamento agendamento;
    private AgendamentoEquipamento agendamentoEquipamento;
    private AgendamentoEquipamentoItens agendamentoEquipamentoItens;
    private AgendamentoOficio agendamentoOficio;
    private Aluno aluno;
    private Ata ata;
    private Bloco bloco;
    private Cartucho cartucho;
    private Cmei cmei;
    private ContraSenha contraSenha;
    private Crachas crachas;
    private DepartamentoDivisaoSetor departamentoDivisaoSetor;
    private Edital edital;
    private Endereco endereco;
    private EntregaRemanufaturados entregaRemanufaturados;
    private EntregaRemanufaturadosItens entregaRemanufaturadosItens;
    private Equipamento equipamento;
    private EquipamentoEntidades equipamentoEntidades;
    private Escola escola;
    private InstrucaoNormativa instrucaoNormativa;
    private Justificativa justificativa;
    private Linha linha;
    private Lote lote;
    private Log2 log2;
    private ModeloCartucho modeloCartucho;
    private Oficio oficio;
    private Outro outro;
    private Permissoes permissoes;
    private PontoDigital pontoDigital;
    private Portaria portaria;
    private Recarga recarga;
    private Resolucao resolucao;
    private SolicitacaoRecarga solicitacaoRecarga;
    private SolicitacaoRemanufatura solicitacaoRemanufatura;
    private SolicitacaoRemanufaturaItens solicitacaoRemanufaturaItens;
    private TipoEquipamento tipoEquipamento;
    private Usuario usuario;
    private VersaoAtual versaoAtual;
    private VersaoUsuario versaoUsuario;
    
    private Log geraLog = new Log(); //controle log
    private Session session;

    public DAO() {
        factory = hibernateUtil.getSessionFactory();
    }

//Metodos Dao========================================================================================================================================
    public void inserir(Object obj, int valorMensagem, int codigoUsuario) {
        try {
            iniciaSessao();
            Transaction trx = session.beginTransaction();
            session.save(obj);
            session.flush();
            trx.commit();
            encerraSessao();
            
            if (valorMensagem == 7) {

                try {
                    geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Salvo com Sucesso!");
                } catch (IOException ex) {
                    Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Salvo com Sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);

            }
            
        } catch (HibernateException ex) {

            try {
                geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Não foi possivel Salvar!");
                System.out.println(ex.getMessage());
            } catch (IOException e) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

            if (valorMensagem == 7) {
                JOptionPane.showMessageDialog(null, "Não foi possivel Salvar!", "Erro", 0, null);
            }

        }
    }

    public void atualizar(Object obj, int valorMensagem, int codigoUsuario) {
        try {
            iniciaSessao();
            Transaction trx = session.beginTransaction();
            session.update(obj);
            session.flush();
            trx.commit();
            encerraSessao();
            
            if (valorMensagem == 7) {

                try {
                    geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Atualizado com Sucesso!");
                } catch (IOException ex) {
                    Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }

                JOptionPane.showMessageDialog(null, "Atualizado com Sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);
            }
        } catch (HibernateException ex) {

            try {
                geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Não foi possivel Atualizar!");
            } catch (IOException e) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

            if (valorMensagem == 7) {
                JOptionPane.showMessageDialog(null, "Não foi possivel Atualizar!", "Erro", 0, null);
            }
        }
    }

    public void excluir(Object obj, int codigoUsuario) {
        try {
            iniciaSessao();
            Transaction trx = session.beginTransaction();
            session.delete(obj);
            session.flush();
            trx.commit();
            encerraSessao();

            try {
                geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Excluido com Sucesso!");
            } catch (IOException e) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!", "OK", JOptionPane.INFORMATION_MESSAGE, null);
        } catch (HibernateException ex) {

            try {
                geraLog.criaLog(codigoUsuario, obj.getClass().getName().substring(7), "Não foi possivel Excluir!");
                System.out.println(ex.getMessage());
                
            } catch (IOException e) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, e);
            }

            JOptionPane.showMessageDialog(null, "Não foi possivel Excluir!", "Erro", 0, null);
        }
    }

    public Object busca(Object obj, int id) {
        iniciaSessao();
        Transaction trx = session.beginTransaction();
        Object obj2 = session.get(obj.getClass(), id);
        session.flush();
        trx.commit();
        //encerraSessao();
        return obj2;
    }

    public Object busca(Object obj, String id) {
        iniciaSessao();
        Transaction trx = session.beginTransaction();
        Object obj2 = session.get(obj.getClass(), id);
        session.flush();
        trx.commit();
        encerraSessao();
        return obj2;
    }

    /*
     * public Object busca(Object obj, Integer id) { try { Session session =
     * factory.openSession(); Transaction trx = session.beginTransaction();
     * Object obj2 = session.get(obj.getClass(), id); session.flush();
     * trx.commit(); session.close(); return obj2; } catch (HibernateException
     * ex) { return null; } }
     */
//Getters and Setters========================================================================================================================================
    public int getNumeroUsuarios() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from usuario");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroUsuarios2() {
        
        iniciaUsuario();
        String selecao = "SELECT count(u) FROM Usuario u";
        int contador = 0;
        int numeroUsuarios;
        List listaNumeroUsuarios;

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        usuario = (Usuario) query.uniqueResult();
        listaNumeroUsuarios = query.list();
        numeroUsuarios = listaNumeroUsuarios.size();

        encerraSessao();

        return numeroUsuarios;
        
    }
    
    public int getNumeroUsuariosAtivos() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from usuario where usuarioinativo = false");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroUsuariosInativos() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from usuario where usuarioinativo = true");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                
                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroAgendamentos(String ano, String tipoAgendamento) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where tipoagendamento like '%" + tipoAgendamento + "%' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroAgendamentosOficio(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamentooficio where anoagendamento = ?");
            psmt.setString(1, ano);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosAgendados(String ano, String tipoAgendamento) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'AGENDADO' and tipoagendamento like '%" + tipoAgendamento + "%' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosOficioAgendados(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamentooficio where status = 'AGENDADO' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroAgendamentosAtendidos(String ano, String tipoAgendamento) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'ATENDIDO' and tipoagendamento like '%" + tipoAgendamento + "%' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroAgendamentosOficioAtendidos(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamentooficio where status = 'ATENDIDO' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosEmAtendimento(String ano, String tipoAgendamento) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'EM ATENDIMENTO' and tipoagendamento like '%" + tipoAgendamento + "%' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroAgendamentosOficioEmAtendimento(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamentooficio where status = 'EM ATENDIMENTO' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosEquipamentoPorStatus(String status, String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamentoequipamento where status like '%" + status + "%' and anoagendamento = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosPontoDigital(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where anoagendamento = ? and tipoagendamento = 'AGENDAMENTO PONTO DIGITAL'");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosPontoDigitalAgendados(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'AGENDADO' and anoagendamento = ? and tipoagendamento = 'AGENDAMENTO PONTO DIGITAL'");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosPontoDigitalAtendidos(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'ATENDIDO' and anoagendamento = ? and tipoagendamento = 'AGENDAMENTO PONTO DIGITAL'");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroAgendamentosPontoDigitalEmAtendimento(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from agendamento where status = 'EM ATENDIMENTO' and anoagendamento = ? and tipoagendamento = 'AGENDAMENTO PONTO DIGITAL'");
            psmt.setString(1, ano);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroCartuchos() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from cartucho");
            //psmt.setString(1, nomeCmei);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroModeloCartuchos() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from modelocartucho");
            //psmt.setString(1, nomeCmei);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroRecargas() {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select count(*) as linhas from recargacartucho");
            //psmt.setString(1, nomeCmei);
            //psmt.setString(2, bairro);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public String getVersaoAtual() {

        String versao = "";

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(codigoversaoatual), numeroversao as linhas from versaoatual group by codigoversaoatual, numeroversao order by codigoversaoatual");

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                versao = rs.getString("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return versao;

    }
    
    public String getVersaoUsuario(int codigoUsuario_Usuario) {
 
        String versao = "";
        PreparedStatement psmt = null;
        String selecao = "select MAX(codigoversaousuario), versaoatual as linhas from versaousuario";
        int contaSelecao = 0;

        try {

           if (codigoUsuario_Usuario != 0) {
                if (contaSelecao == 0) {
                    selecao = selecao + " where " + "usuario_codigousuario = " + codigoUsuario_Usuario;
                    contaSelecao++;
                } else {
                    selecao = selecao + " and " + "usuario_codigousuario = " + codigoUsuario_Usuario;
                }
            }

            psmt = Conexao.getConexao().prepareStatement(selecao + " group by versaoatual, codigoversaousuario");

            ResultSet rs = psmt.executeQuery();
        
            while (rs.next()) {

                versao = rs.getString("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return versao;

    }
    
    public int getNumeroAta(String ano) {
        
        int linhas = 0;
        
        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numeroata) as linhas from ata where ano = ?");
            psmt.setString(1, ano);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return linhas + 1;
        
    }
    
    public int getNumeroOficio(String modeloOficio, String ano, String tipoOficio) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from oficio where modelooficio = ? and ano = ? and tipooficio = ?");
            psmt.setString(1, modeloOficio);
            psmt.setString(2, ano);
            psmt.setString(3, tipoOficio);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;

    }

    

    public int getNumeroInstrucao(String modeloInstrucao, String ano, String tipoInstrucao) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from instrucaonormativa where modeloinstrucao = ? and ano = ? and tipoinstrucao = ?");
            psmt.setString(1, modeloInstrucao);
            psmt.setString(2, ano);
            psmt.setString(3, tipoInstrucao);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;

    }
    
    public int getNumeroPortaria(String modeloPortaria, String ano, String tipoPortaria) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from portaria where modeloportaria = ? and ano = ? and tipoportaria = ?");
            psmt.setString(1, modeloPortaria);
            psmt.setString(2, ano);
            psmt.setString(3, tipoPortaria);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;

    }

    

    public int getNumeroResolucao(String modeloResolucao, String ano, String tipoResolucao) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from resolucao where modeloresolucao = ? and ano = ? and tiporesolucao = ?");
            psmt.setString(1, modeloResolucao);
            psmt.setString(2, ano);
            psmt.setString(3, tipoResolucao);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;

    }

    public int getNumeroEdital(String modeloEdital, String ano, String tipoEdital) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from edital where modeloedital = ? and ano = ? and tipoedital = ?");
            psmt.setString(1, modeloEdital);
            psmt.setString(2, ano);
            psmt.setString(3, tipoEdital);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;

    }
    
    public int getNumeroEntregaRemanufaturados(String ano) {
        
        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numeroentregaremanufaturados) as linhas from entregaremanufaturados where ano = ?");
            psmt.setString(1, ano);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;
        
    }

    public int getNumeroSolicitacaoRecarga(String ano) {
        
        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numerosolicitacao) as linhas from solicitacaorecarga where ano = ?");
            psmt.setString(1, ano);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;
        
    }
    
    public int getNumeroSolicitacaoRemanufatura(String ano) {
        
        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numerosolicitacao) as linhas from solicitacaoremanufatura where ano = ?");
            psmt.setString(1, ano);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas + 1;
        
    }
    
    public int getNumeroGeradoAta(String ano) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numeroata) as linhas from ata where ano = ?");
            psmt.setString(1, ano);
            //psmt.setString(2, tipoResolucao);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoCi(String ano, String tipoOficio) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from oficio where modelooficio = 'CI' and ano = ? and tipooficio = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoOficio);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoEdital(String ano, String tipoEdital) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from edital where modeloedital = 'EDITAL' and ano = ? and tipoedital = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoEdital);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoInstrucao(String ano, String tipoInstrucao) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from instrucaonormativa where modeloinstrucao = 'INSTRUÇÃO NORMATIVA' and ano = ? and tipoinstrucao = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoInstrucao);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoOficio(String ano, String tipoOficio) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from oficio where modelooficio = 'OFICIO' and ano = ? and tipooficio = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoOficio);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

    public int getNumeroGeradoOficioCircular(String ano, String tipoOficio) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from oficio where modelooficio = 'OFICIO CIRCULAR' and ano = ? and tipooficio = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoOficio);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoPortaria(String ano, String tipoPortaria) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from portaria where modeloportaria = 'PORTARIA' and ano = ? and tipoportaria = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoPortaria);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }
    
    public int getNumeroGeradoResolucao(String ano, String tipoResolucao) {

        int linhas = 0;

        try {

            PreparedStatement psmt = Conexao.getConexao().prepareStatement("select MAX(numero) as linhas from resolucao where modeloresolucao = 'RESOLUCAO' and ano = ? and tiporesolucao = ?");
            psmt.setString(1, ano);
            psmt.setString(2, tipoResolucao);
            //psmt.setString(3, coordenadorAtual);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {

                linhas = rs.getInt("linhas");

            }

            rs.close();
            psmt.close();

        } catch (ExcCadastro ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return linhas;

    }

//Buscadores========================================================================================================================================
    public Object buscaAluno(int codigo, String nomeAluno) {

        iniciaAluno();
        String selecao = "SELECT a FROM Aluno a";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.codigoAluno = :codigoaluno";
                contador = 1;
            } else {
                selecao = selecao + " AND e.codigoAluno = :codigoaluno";
            }
        }
        
        if (!nomeAluno.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.nomeAluno = :nomealuno";
                contador = 1;
            } else {
                selecao = selecao + " AND e.nomeAluno = :nomealuno";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigoaluno", codigo);
        }
        
        if (!nomeAluno.isEmpty()) {
            query.setParameter("nomealuno", nomeAluno);
        }
        
        aluno = (Aluno) query.uniqueResult();
        
        encerraSessao();
        
        return aluno;

    }
    
    public Object buscaBloco(int codigo, String nomeBloco) {

        iniciaBloco();
        String selecao = "SELECT b FROM Bloco b";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE b.codigoBloco = :codigobloco";
                contador = 1;
            } else {
                selecao = selecao + " AND b.codigoBloco = :codigobloco";
            }
        }
        
        if (!nomeBloco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE b.nomeBloco = :nomebloco";
                contador = 1;
            } else {
                selecao = selecao + " AND b.nomeBloco = :nomebloco";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigobloco", codigo);
        }
        
        if (!nomeBloco.isEmpty()) {
            query.setParameter("nomebloco", nomeBloco);
        }
        
        bloco = (Bloco) query.uniqueResult();
        
        encerraSessao();
        
        if (bloco == null) {
            return null;
        } else {
            return bloco;
        }

    }
    
    public Object buscaCartucho(int codigoCmei, int codigoEscola, int codigoOutro, String nomeModeloCartucho, String codigoBarras, String tipoEntidade, boolean cartuchoQueimado) {

        iniciaCartucho();
        
        String selecao = "select c from Cartucho c";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and c.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and c.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and c.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.modeloCartucho.nomeModeloCartucho = :nomemodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND c.modeloCartucho.nomeModeloCartucho = :nomemodelocartucho";
            }
        }
        
        if (!codigoBarras.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.codigoBarra = :codigobarras";
                contador = 1;
            } else {
                selecao = selecao + " and c.codigoBarra = :codigobarras";
            }

        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.tipoEntidade = :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and c.tipoEntidade = :tipoentidade";
            }

        }
        
        if (cartuchoQueimado || cartuchoQueimado == false) {
            if (contador == 0) {
                selecao = selecao + " where c.cartuchoQueimado is :cartuchoqueimado";
                contador = 1;
            } else {
                selecao = selecao + " and c.cartuchoQueimado is :cartuchoqueimado";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY c.tipoEntidade");

        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            query.setParameter("nomemodelocartucho", nomeModeloCartucho);
        }
        
        if (!codigoBarras.isEmpty()) {
            query.setParameter("codigobarras", codigoBarras);
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", tipoEntidade);
        }
        
        if (cartuchoQueimado || cartuchoQueimado == false) {
            query.setParameter("cartuchoqueimado", cartuchoQueimado);
        }
        
        cartucho = (Cartucho) query.uniqueResult();

        encerraSessao();

        return cartucho;

    }
    
    public Object buscaCmei(int codigo, String nomeCmei, String coordenadorAtual) {

        iniciaCmei();
        String selecao = "SELECT c FROM Cmei c";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND c.codigoCmei = :codigocmei";
            }
        }
        
        if (!coordenadorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.coordenadorAtual = :coordenadoratual";
                contador = 1;
            } else {
                selecao = selecao + " AND c.coordenadorAtual = :coordenadoratual";
            }
        }
        
        if (!nomeCmei.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.nomeCmei = :nomecmei";
                contador = 1;
            } else {
                selecao = selecao + " AND c.nomeCmei = :nomecmei";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigoescola", codigo);
        }
        
        if (!coordenadorAtual.isEmpty()) {
            query.setParameter("coordenadoratual", coordenadorAtual);
        }
        
        if (!nomeCmei.isEmpty()) {
            query.setParameter("nomecmei", nomeCmei);
        }
        
        cmei = (Cmei) query.uniqueResult();
        
        encerraSessao();
        
        return cmei;

    }
    
    public Object buscaContraSenha(String contraSenha) {

        iniciaContraSenha();
        String selecao = "SELECT cs FROM ContraSenha cs";
        int contador = 0;

        if (!contraSenha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE cs.contraSenha = :contrasenha";
                contador = 1;
            } else {
                selecao = selecao + " AND cs.contraSenha = :contrasenha";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!contraSenha.isEmpty()) {
            query.setParameter("contrasenha", contraSenha);
        }

        this.contraSenha = (ContraSenha) query.uniqueResult();

        encerraSessao();

        return this.contraSenha;

    }
    
    public Object buscaDepartamentoDivisaoSetor(int codigo, String nomeDepartamentoDivisaoSetor) {
        
        iniciaDepartamentoDivisaoSetor();
        String selecao = "SELECT dds FROM DepartamentoDivisaoSetor dds";
        int contador = 0;
        
        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE dds.codigoDepartamentoDivisaoSetor = :codigo";
                contador = 1;
            } else {
                selecao = selecao + " AND dds.codigoDepartamentoDivisaoSetor = :codigo";
            }
        }
        
        if (!nomeDepartamentoDivisaoSetor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE dds.nomeDepartamentoDivisaoSetor = :nomedepartamentodivisaosetor";
                contador = 1;
            } else {
                selecao = selecao + " AND dds.nomeDepartamentoDivisaoSetor = :nomedepartamentodivisaosetor";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        if (codigo != 0) {
            query.setParameter("codigo", codigo);
        }
        
        if (!nomeDepartamentoDivisaoSetor.isEmpty()) {
            query.setParameter("nomedepartamentodivisaosetor", nomeDepartamentoDivisaoSetor);
        }
        
        departamentoDivisaoSetor = (DepartamentoDivisaoSetor) query.uniqueResult();

        encerraSessao();

        return departamentoDivisaoSetor;
        
    }
    
    public Object buscaEntregaRemanufaturados(int codigo, int numeroEntrega, boolean protocoloFinalizado, String ano) {
        
        iniciaEntregaRemanufaturados();
        String selecao = "SELECT er FROM EntregaRemanufaturados er";
        int contador = 0;
        
        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE er.codigoEntregaRemanufaturados = :codigoentregaremanufaturados";
                contador = 1;
            } else {
                selecao = selecao + " AND er.codigoEntregaRemanufaturados = :codigoentregaremanufaturados";
            }
        }
        
        if (numeroEntrega != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE er.numeroEntregaRemanufaturados = :numeroentregaremanufaturados";
                contador = 1;
            } else {
                selecao = selecao + " AND er.numeroEntregaRemanufaturados = :numeroentregaremanufaturados";
            }
        }
        
        if (protocoloFinalizado || protocoloFinalizado == false) {
            if (contador == 0) {
                selecao = selecao + " where er.protocoloFinalizado is :protocolofinalizado";
                contador = 1;
            } else {
                selecao = selecao + " and er.protocoloFinalizado is :protocolofinalizado";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where er.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and er.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigoentregaremanufaturados", codigo);
        }
        
        if (numeroEntrega != 0) {
            query.setParameter("numeroentregaremanufaturados", numeroEntrega);
        }
        
        if (protocoloFinalizado || protocoloFinalizado == false) {
            query.setParameter("protocolofinalizado", protocoloFinalizado);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        entregaRemanufaturados = (EntregaRemanufaturados) query.uniqueResult();
        
        encerraSessao();
        
        return entregaRemanufaturados;
        
    }
    
    public Object buscaEquipamento(int codigo, String marca, String modelo, String patrimonio) {

        iniciaEquipamento();
        String selecao = "SELECT e FROM Equipamento e";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.codigoEquipamento = :codigoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND e.codigoEquipamento = :codigoequipamento";
            }
        }
        
        if (!marca.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.marca = :marca";
                contador = 1;
            } else {
                selecao = selecao + " AND e.marca = :marca";
            }
        }
        
        if (!modelo.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.modelo = :modelo";
                contador = 1;
            } else {
                selecao = selecao + " AND e.modelo = :modelo";
            }
        }
        
        if (!patrimonio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.patrimonioEquipamento = :patrimonio";
                contador = 1;
            } else {
                selecao = selecao + " AND e.patrimonioEquipamento = :patrimonio";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        if (codigo != 0) {
            query.setParameter("codigoequipamento", codigo);
        }
        
        if (!marca.isEmpty()) {
            query.setParameter("marca", marca);
        }
        
        if (!modelo.isEmpty()) {
            query.setParameter("modelo", modelo);
        }
        
        if (!patrimonio.isEmpty()) {
            query.setParameter("patrimonio", patrimonio);
        }

        equipamento = (Equipamento) query.uniqueResult();

        encerraSessao();

        return equipamento;

    }

    public Object buscaEscola(int codigo, String nomeEscola, String diretorAtual) {

        iniciaEscola();
        String selecao = "SELECT e FROM Escola e";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND e.codigoEscola = :codigoescola";
            }
        }
        
        if (!diretorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.diretorAtual = :diretoratual";
                contador = 1;
            } else {
                selecao = selecao + " AND e.diretorAtual = :diretoratual";
            }
        }
        
        if (!nomeEscola.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.nomeEscola = :nomeescola";
                contador = 1;
            } else {
                selecao = selecao + " AND e.nomeEscola = :nomeescola";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigoescola", codigo);
        }
        
        if (!diretorAtual.isEmpty()) {
            query.setParameter("diretoratual", diretorAtual);
        }
        
        if (!nomeEscola.isEmpty()) {
            query.setParameter("nomeescola", nomeEscola);
        }
        
        escola = (Escola) query.uniqueResult();
        
        encerraSessao();
        
        return escola;

    }
    
    public Object buscaLinha(int codigo, int numeroLinha, int codigoBloco) {

        iniciaLinha();
        String selecao = "SELECT l FROM Linha l";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.codigoLinha = :codigolinha";
                contador = 1;
            } else {
                selecao = selecao + " AND l.codigoLinha = :codigolinha";
            }
        }
        
        if (numeroLinha != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.numeroLinha = :numerolinha";
                contador = 1;
            } else {
                selecao = selecao + " AND l.numeroLinha = :numerolinha";
            }
        }
        
        if (codigoBloco != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.bloco.codigoBloco = :codigobloco";
                contador = 1;
            } else {
                selecao = selecao + " AND l.bloco.codigoBloco = :codigobloco";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigolinha", codigo);
        }
        
        if (numeroLinha != 0) {
            query.setParameter("numerolinha", numeroLinha);
        }
        
        if (codigoBloco != 0) {
            query.setParameter("codigobloco", codigoBloco);
        }
        
        linha = (Linha) query.uniqueResult();
        
        encerraSessao();
        
        if (linha == null) {
            return null;
        } else {
            return linha;
        }

    }

    public Object buscaLote(int codigo, String nomeLote, String numeroLote) {

        iniciaLote();
        String selecao = "SELECT l FROM Lote l";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.codigoLote = :codigolote";
                contador = 1;
            } else {
                selecao = selecao + " AND l.codigoLote = :codigolote";
            }
        }
        
        if (!nomeLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.nomeLote = :nomelote";
                contador = 1;
            } else {
                selecao = selecao + " AND l.nomeLote = :nomelote";
            }
        }
        
        if (!numeroLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE l.numeroLote = :numerolote";
                contador = 1;
            } else {
                selecao = selecao + " AND l.numeroLote = :numerolote";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigolote", codigo);
        }
        
        if (!nomeLote.isEmpty()) {
            query.setParameter("nomelote", nomeLote);
        }
        
        if (!numeroLote.isEmpty()) {
            query.setParameter("numerolote", numeroLote);
        }
        
        lote = (Lote) query.uniqueResult();
        
        encerraSessao();
        
        if (lote == null) {
            return null;
        } else {
            return lote;
        }

    }
    
    public Object buscaModeloCartucho(int codigo, String nomeModeloCartucho) {

        iniciaModeloCartucho();
        String selecao = "SELECT m FROM ModeloCartucho m";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE m.codigoModeloCartucho = :codigomodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND m.codigoModeloCartucho = :codigomodelocartucho";
            }
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE m.nomeModeloCartucho = :nomemodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND m.nomeModeloCartucho = :nomemodelocartucho";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        if (codigo != 0) {
            query.setParameter("codigomodelocartucho", codigo);
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            query.setParameter("nomemodelocartucho", nomeModeloCartucho);
        }
        
        modeloCartucho = (ModeloCartucho) query.uniqueResult();

        encerraSessao();

        return modeloCartucho;

    }
    
    public Object buscaOutro(int codigo, String nomeOutro, String coordenadorAtual) {

        iniciaOutro();
        String selecao = "SELECT o FROM Outro o";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE o.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND o.codigoOutro = :codigooutro";
            }
        }
        
        if (!coordenadorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE o.coordenadorAtual = :coordenadoratual";
                contador = 1;
            } else {
                selecao = selecao + " AND o.coordenadorAtual = :coordenadoratual";
            }
        }
        
        if (!nomeOutro.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE o.nomeOutro = :nomeoutro";
                contador = 1;
            } else {
                selecao = selecao + " AND o.nomeOutro = :nomeoutro";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigooutro", codigo);
        }
        
        if (!coordenadorAtual.isEmpty()) {
            query.setParameter("coordenadoratual",coordenadorAtual);
        }
        
        if (!nomeOutro.isEmpty()) {
            query.setParameter("nomeoutro", nomeOutro);
        }
        
        outro = (Outro) query.uniqueResult();
        
        encerraSessao();
        
        return outro;

    }
    
    public Object buscaPermissoes(int codigoUsuario) {

        iniciaPermissoes();
        
        String selecao = "SELECT p FROM Permissoes p";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND p.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }

        permissoes = (Permissoes) query.uniqueResult();

        encerraSessao();

        return permissoes;

    }
    
    public Object buscaRecarga(int codigo, int codigoCmei, int codigoEscola, int codigoOutro, int codigoCartucho, String tipoEntidade, Date dataEntrega, String modeloCartucho) {

        iniciaRecarga();
        
        List lista = new ArrayList();
        String selecao = "SELECT r FROM Recarga r";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.codigoRecarga = :codigorecarga";
                contador = 1;
            } else {
                selecao = selecao + " AND r.codigoRecarga = :codigorecarga";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.cartucho.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and r.cartucho.cmei.codigoCmei = :codigocmei";
            }

        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.cartucho.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and r.cartucho.escola.codigoEscola = :codigoescola";
            }

        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.cartucho.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and r.cartucho.outro.codigoOutro = :codigooutro";
            }

        }
        
        if (codigoCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.cartucho.codigoCartucho = :codigocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and r.cartucho.codigoCartucho = :codigocartucho";
            }

        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.tipoEntidade = :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " AND r.tipoEntidade = :tipoentidade";
            }
        }
        
        if (dataEntrega != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataEntrega = :dataentrega";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataEntrega = :dataentrega";
            }
        }
        
        if (!modeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.modeloCartucho = :modelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND r.modeloCartucho = :modelocartucho";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY r.codigoRecarga");

        if (codigo != 0) {
            query.setParameter("codigocartucho", codigo);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (codigoCartucho != 0) {
            query.setParameter("codigocartucho", codigoCartucho);
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", tipoEntidade);
        }
        
        if (dataEntrega != null) {
            query.setParameter("dataentrega", dataEntrega);
        }
        
        if (!modeloCartucho.isEmpty()) {
            query.setParameter("modelocartucho", modeloCartucho);
        }
        
        lista = query.list();
        
        if (lista.size() == 0) {
            encerraSessao();
            return null;
        } else {
            
            for (int i = 0; i < lista.size(); i++) {
                
                if ((i + 1) == lista.size()) {
                    recarga = (Recarga) lista.get(i);
                }
                
            }
        
            encerraSessao();

            return recarga;
        }

    }

    public Object buscaSolicitacaoRecarga(int numeroSolicitacao, String anoSolicitacao) {
        
        iniciaSolicitacaoRecarga();
        
        String selecao = "SELECT sr FROM SolicitacaoRecarga sr";
        int contador = 0;

        if (numeroSolicitacao != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE sr.numeroSolicitacao = :numerosolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND sr.numeroSolicitacao = :numerosolicitacao";
            }
        }
        
        if (!anoSolicitacao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE sr.ano = :anosolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND sr.ano = :anosolicitacao";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (numeroSolicitacao != 0) {
            query.setParameter("numerosolicitacao", numeroSolicitacao);
        }
        
        if (!anoSolicitacao.isEmpty()) {
            query.setParameter("anosolicitacao", anoSolicitacao);
        }

        solicitacaoRecarga = (SolicitacaoRecarga) query.uniqueResult();

        encerraSessao();

        return solicitacaoRecarga;
        
    }
    
    public Object buscaSolicitacaoRemanufatura(int codigo, int numeroSolicitacao, boolean solicitacaoEnviada, String ano) {
        
        iniciaSolicitacaoRemanufatura();
        String selecao = "SELECT sr FROM SolicitacaoRemanufatura sr";
        int contador = 0;
        
        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE sr.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
                contador = 1;
            } else {
                selecao = selecao + " AND sr.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
            }
        }
        
        if (numeroSolicitacao != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE sr.numeroSolicitacao = :numerosolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND sr.numeroSolicitacao = :numerosolicitacao";
            }
        }
        
        if (solicitacaoEnviada || solicitacaoEnviada == false) {
            if (contador == 0) {
                selecao = selecao + " where sr.solicitacaoEnviada is :solicitacaoenviada";
                contador = 1;
            } else {
                selecao = selecao + " and sr.solicitacaoEnviada is :solicitacaoenviada";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and sr.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigo != 0) {
            query.setParameter("codigosolicitacaoremanufatura", codigo);
        }
        
        if (numeroSolicitacao != 0) {
            query.setParameter("numerosolicitacao", numeroSolicitacao);
        }
        
        if (solicitacaoEnviada || solicitacaoEnviada == false) {
            query.setParameter("solicitacaoenviada", solicitacaoEnviada);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        solicitacaoRemanufatura = (SolicitacaoRemanufatura) query.uniqueResult();
        
        encerraSessao();
        
        return solicitacaoRemanufatura;
        
    }
    
    public Object buscaTipoEquipamento(int codigo, String nomeTipoEquipamento) {

        iniciaTipoEquipamento();
        String selecao = "SELECT te FROM TipoEquipamento te";
        int contador = 0;

        if (codigo != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE te.codigoTipoEquipamento = :codigotipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND te.codigoTipoEquipamento = :codigotipoequipamento";
            }
        }
        
        if (!nomeTipoEquipamento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE te.nomeTipoEquipamento = :nometipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND te.nomeTipoEquipamento = :nometipoequipamento";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        if (codigo != 0) {
            query.setParameter("codigotipoequipamento", codigo);
        }
        
        if (!nomeTipoEquipamento.isEmpty()) {
            query.setParameter("nometipoequipamento", nomeTipoEquipamento);
        }
        
        tipoEquipamento = (TipoEquipamento) query.uniqueResult();

        encerraSessao();

        return tipoEquipamento;

    }
    
    public Object buscaUsuario(int codigoUsuario, String nomeUsuario, String matricula) {

        iniciaUsuario();
        String selecao = "SELECT u FROM Usuario u";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE u.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND u.codigoUsuario = :codigousuario";
            }
        }
        
        if (!nomeUsuario.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE u.nomeUsuario = :nomeusuario";
                contador = 1;
            } else {
                selecao = selecao + " AND u.nomeUsuario = :nomeusuario";
            }
        }
        
        if (!matricula.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE u.matricula = :matricula";
                contador = 1;
            } else {
                selecao = selecao + " AND u.matricula = :matricula";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (!nomeUsuario.isEmpty()) {
            query.setParameter("nomeusuario", nomeUsuario);
        }
        
        if (!matricula.isEmpty()) {
            query.setParameter("matricula", matricula);
        }

        usuario = (Usuario) query.uniqueResult();

        encerraSessao();

        return usuario;

    }

//Listadores========================================================================================================================================
    public List listarAgendamento(int codigoCmei, int codigoEscola, int codigoOutro, Date dataSolicitacaoInicio, Date dataSolicitacaoTermino, Date dataResolucaoInicio, Date dataResolucaoTermino, String tipoEntidade, String status, String localEntidade, String usuarioAtendimento, String tipoAgendamento, String ano) {
        //public List listarAgendamento(String nomeEntidade, java.sql.Date dataSolicitacao, String tipoEntidade) {Usando jFormatedTextField
        
        iniciaAgendamento();
        
        List lista = new ArrayList();
        String selecao = "SELECT a FROM Agendamento a";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND a.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND a.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND a.outro.codigoOutro = :codigooutro";
            }
        }

        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
            }
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao = :datasolicitacaoinicio";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao = :datasolicitacaoinicio";
            }
        }
        
        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao = :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao = :datasolicitacaotermino";
            }
        }
        
        if (dataResolucaoInicio != null && dataResolucaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao between :datareolucaoinicio and dataresolucaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao between :datareolucaoinicio and dataresolucaotermino";
            }
        }

        if (dataResolucaoInicio != null && dataResolucaoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao = :datareolucaoinicio";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao = :datareolucaoinicio";
            }
        }

        if (dataResolucaoInicio == null && dataResolucaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao = :datareolucaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao = :datareolucaotermino";
            }
        }
            
        if (!tipoEntidade.equals("TODOS")) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoEntidade like :tipoentidade";
            }
        }
        
        if (!status.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.status like :status";
                contador = 1;
            } else {
                selecao = selecao + " and a.status like :status";
            }
        }
        
        if (!localEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.localEntidade like :localentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.localEntidade like :localentidade";
            }
        }
        
        if (!usuarioAtendimento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.usuarioAtendimento like :usuarioatendimento";
                contador = 1;
            } else {
                selecao = selecao + " and a.usuarioAtendimento like :usuarioatendimento";
            }
        }
        
        if (!tipoAgendamento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoAgendamento like :tipoagendamento";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoAgendamento like :tipoagendamento";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.anoAgendamento like :ano";
                contador = 1;
            } else {
                selecao = selecao + " and a.anoAgendamento like :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY a.codigoAgendamento");
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }

        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
        }
        
        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }
        
        if (dataResolucaoInicio != null && dataResolucaoTermino != null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoInicio.getTime()));
            query.setParameter("dataresolucaotermino", new java.sql.Date(dataResolucaoTermino.getTime()));
        }

        if (dataResolucaoInicio != null && dataResolucaoTermino == null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoInicio.getTime()));
        }

        if (dataResolucaoInicio == null && dataResolucaoTermino != null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoTermino.getTime()));
        }
            
        if (!tipoEntidade.equals("TODOS")) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (!status.isEmpty()) {
            query.setParameter("status", "%" + status + "%");
        }
        
        if (!localEntidade.isEmpty()) {
            query.setParameter("localentidade", "%" + localEntidade + "%");
        }
        
        if (!usuarioAtendimento.isEmpty()) {
            query.setParameter("usuarioatendimento", "%" + usuarioAtendimento + "%");
        }
        
        if (!tipoAgendamento.isEmpty()) {
            query.setParameter("tipoagendamento", "%" + tipoAgendamento + "%");
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", "%" + ano + "%");
        }
            
        lista = query.list();

        encerraSessao();

        return lista;
        
    }

    public List listarAgendamentoEquipamento(int codigoCmei, int codigoEscola, int codigoOutro, Date dataEmprestimo, String tipoEntidade, String status, String ano) {

        iniciaAgendamentoEquipamento();
        
        List lista = new ArrayList();
        String selecao = "select ae from AgendamentoEquipamento ae";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " where ae.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and ae.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " where ae.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and ae.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " where ae.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and ae.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (dataEmprestimo != null) {
            if (contador == 0) {
                selecao = selecao + " where ae.dataEmprestimo = :dataemprestimo";
                contador = 1;
            } else {
                selecao = selecao + " and ae.dataEmprestimo = :dataemprestimo";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ae.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and ae.tipoEntidade like :tipoentidade";
            }
        }
        
        if (!status.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ae.status like :status";
                contador = 1;
            } else {
                selecao = selecao + " and ae.status like :status";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ae.anoAgendamento = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and ae.anoAgendamento = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY ae.dataEmprestimo, ae.codigoAgendamentoEquipamento");

        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (dataEmprestimo != null) {
            query.setParameter("dataemprestimo", dataEmprestimo);
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (!status.isEmpty()) {
            query.setParameter("status", "%" + status + "%");
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        return lista;
        
    }
    
    public List listarAgendamentoEquipamentoItens(int agendamentoEquipamento_codigoAgendamentoEquipamento) {
        
        iniciaAgendamentoEquipamentoItens();
        
        List lista = new ArrayList();
        String selecao = "select aei from AgendamentoEquipamentoItens aei";
        int contador = 0;
        
        if (agendamentoEquipamento_codigoAgendamentoEquipamento != 0) {
            if (contador == 0) {
                selecao = selecao + " where aei.agendamentoEquipamento.codigoAgendamentoEquipamento = :codigoagendamentoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " and aei.agendamentoEquipamento.codigoAgendamentoEquipamento = :codigoagendamentoequipamento";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY aei.codigoAgendamentoEquipamentoItem");
        
        if (agendamentoEquipamento_codigoAgendamentoEquipamento != 0) {
            query.setParameter("codigoagendamentoequipamento", agendamentoEquipamento_codigoAgendamentoEquipamento);
        }
        
        lista = query.list();
        
        return lista;
        
    }
    
    public List listarAgendamentoOficio(int codigoCmei, int codigoEscola, int codigoOutro, Date dataSolicitacaoInicio, Date dataSolicitacaoTermino, Date dataResolucaoInicio,  
            Date dataResolucaoTermino, String tipoEntidade, String status, String ano, int codigoDepartamentoDivisaoSetor) {
        
        iniciaAgendamentoOficio();
        
        List lista = new ArrayList();
        String selecao = "select a from AgendamentoOficio a";
        int contador = 0;

        if (codigoDepartamentoDivisaoSetor != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.departamentoDivisaoSetor.codigoDepartamentoDivisaoSetor = :codigodepartamentodivisaosetor";
                contador = 1;
            } else {
                selecao = selecao + " AND a.departamentoDivisaoSetor.codigoDepartamentoDivisaoSetor = :codigodepartamentodivisaosetor";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND a.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND a.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND a.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
            }
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao = :datasolicitacaoinicio";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao = :datasolicitacaoinicio";
            }
        }
        
        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataSolicitacao = :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataSolicitacao = :datasolicitacaotermino";
            }
        }
        
        if (dataResolucaoInicio != null && dataResolucaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao between :datareolucaoinicio and dataresolucaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao between :datareolucaoinicio and dataresolucaotermino";
            }
        }

        if (dataResolucaoInicio != null && dataResolucaoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao = :datareolucaoinicio";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao = :datareolucaoinicio";
            }
        }

        if (dataResolucaoInicio == null && dataResolucaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where a.dataResolucao = :datareolucaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and a.dataResolucao = :datareolucaotermino";
            }
        }
            
        if (!tipoEntidade.equals("TODOS")) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoEntidade like :tipoentidade";
            }
        }
        
        if (!status.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.status like :status";
                contador = 1;
            } else {
                selecao = selecao + " and a.status like :status";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.anoAgendamento like :ano";
                contador = 1;
            } else {
                selecao = selecao + " and a.anoAgendamento like :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY a.codigoAgendamentoOficio");
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }

        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
        }
        
        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }
        
        if (dataResolucaoInicio != null && dataResolucaoTermino != null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoInicio.getTime()));
            query.setParameter("dataresolucaotermino", new java.sql.Date(dataResolucaoTermino.getTime()));
        }

        if (dataResolucaoInicio != null && dataResolucaoTermino == null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoInicio.getTime()));
        }

        if (dataResolucaoInicio == null && dataResolucaoTermino != null) {
            query.setParameter("dataresolucaoinicio", new java.sql.Date(dataResolucaoTermino.getTime()));
        }
            
        if (!tipoEntidade.equals("TODOS")) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (!status.isEmpty()) {
            query.setParameter("status", "%" + status + "%");
        }
        
        if (codigoDepartamentoDivisaoSetor != 0) {
            query.setParameter("codigodepartamentodivisaosetor", codigoDepartamentoDivisaoSetor);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", "%" + ano + "%");
        }
            
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarAlunos(int codigoAluno, int codigoBloco, int codigoLinha, int codigoLote, int codigoEscola, int codigoCmei, int codigoOutro, String nomeAluno,
            String tipoEntidade, String nivel, String serieAno, String turno) {
        
        iniciaAluno();
        
        List lista = new ArrayList();
        String selecao = "select a from Aluno a";
        int contador = 0;
        
        if (codigoAluno != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.codigoAluno = :codigoaluno";
                contador = 1;
            } else {
                selecao = selecao + " and a.codigoAluno = :codigoaluno";
            }
        }
        
        if (codigoBloco != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.bloco.codigoBloco = :codigobloco";
                contador = 1;
            } else {
                selecao = selecao + " and a.bloco.codigoBloco = :codigobloco";
            }
        }
        
        if (codigoLinha != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.linha.codigoLinha = :codigolinha";
                contador = 1;
            } else {
                selecao = selecao + " and a.linha.codigoLinha = :codigolinha";
            }
        }
        
        if (codigoLote != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.lote.codigoLote = :codigolote";
                contador = 1;
            } else {
                selecao = selecao + " and a.lote.codigoLote = :codigolote";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and a.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and a.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and a.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!nomeAluno.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.nomeAluno like :nomealuno";
                contador = 1;
            } else {
                selecao = selecao + " and a.nomeAluno like :nomealuno";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoEntidade like :tipoentidade";
            }
        }
        
        if (!nivel.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.nivel like :nivel";
                contador = 1;
            } else {
                selecao = selecao + " and a.nivel like :nivel";
            }
        }
        
        if (!serieAno.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.serie like :serie";
                contador = 1;
            } else {
                selecao = selecao + " and a.serie like :serie";
            }
        }
        
        if (!turno.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.turno like :turno";
                contador = 1;
            } else {
                selecao = selecao + " and a.turno like :turno";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY a.nomeAluno");
        
        if (codigoAluno != 0) {
            query.setParameter("codigoaluno", codigoAluno);
        }
        
        if (codigoBloco != 0) {
            query.setParameter("codigobloco", codigoBloco);
        }
        
        if (codigoLinha != 0) {
            query.setParameter("codigolinha", codigoLinha);
        }
        
        if (codigoLote != 0) {
            query.setParameter("codigolote", codigoLote);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!nomeAluno.isEmpty()) {
            query.setParameter("nomealuno", "%" + nomeAluno + "%");
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (!nivel.isEmpty()) {
            query.setParameter("nivel", "%" + nivel + "%");
        }
        
        if (!serieAno.isEmpty()) {
            query.setParameter("serie", "%" + serieAno + "%");
        }
        
        if (!turno.isEmpty()) {
            query.setParameter("turno", "%" + turno + "%");
        }
        
        lista = query.list();

        encerraSessao();
        
        return lista;
        
    }
    
    public List listarAta(int codigoUsuario, int numeroAta, int numeroModalidade, int numeroProcesso, Date dataPublicacaoVencimentoInicio, Date dataPublicacaoVencimentoTermino, String ano) {

        iniciaAta();
        
        List lista = new ArrayList();
        String selecao = "SELECT a FROM Ata a";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND a.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (numeroAta != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroAta = :numeroata";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroAta = :numeroata";
            }
        }
        
        if (numeroModalidade != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroModalidade = :numeromodalidade";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroModalidade = :numeromodalidade";
            }
        }
        
        if (numeroProcesso != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroProcesso = :numeroprocesso";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroProcesso = :numeroprocesso";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND a.ano = :ano";
            }
        }

        if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.dataPublicacaoVencimento = :datapublicacaovencimentoinicio";
                contador = 1;
            } else {
                selecao = selecao + " AND a.dataPublicacaoVencimento = :datapublicacaovencimentoinicio";
            }
        } else if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.dataPublicacaoVencimento between :datapublicacaovencimentoinicio and :datapublicacaovencimentotermino";
                contador = 1;
            } else {
                selecao = selecao + " AND a.dataPublicacaoVencimento between :datapublicacaovencimentoinicio and :datapublicacaovencimentotermino";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY a.codigoAta");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (numeroAta != 0) {
            query.setParameter("numeroata", numeroAta);
        }
        
        if (numeroModalidade != 0) {
            query.setParameter("numeromodalidade", numeroModalidade);
        }
        
        if (numeroProcesso != 0) {
            query.setParameter("numeroprocesso", numeroProcesso);
        }
        
        if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino == null) {
            query.setParameter("datapublicacaovencimentoinicio", new java.sql.Date(dataPublicacaoVencimentoInicio.getTime()));
        } else if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino != null) {
            query.setParameter("datapublicacaovencimentoinicio", new java.sql.Date(dataPublicacaoVencimentoInicio.getTime()));
            query.setParameter("datapublicacaovencimentotermino", new java.sql.Date(dataPublicacaoVencimentoTermino.getTime()));
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarAta(int codigoUsuario, int numeroAta, int numeroModalidade, int numeroProcesso, Date dataPublicacaoVencimentoInicio, Date dataPublicacaoVencimentoTermino, String ano, 
            boolean finalizado) {

        iniciaAta();
        
        List lista = new ArrayList();
        String selecao = "SELECT a FROM Ata a";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND a.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (numeroAta != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroAta = :numeroata";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroAta = :numeroata";
            }
        }
        
        if (numeroModalidade != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroModalidade = :numeromodalidade";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroModalidade = :numeromodalidade";
            }
        }
        
        if (numeroProcesso != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.numeroProcesso = :numeroprocesso";
                contador = 1;
            } else {
                selecao = selecao + " AND a.numeroProcesso = :numeroprocesso";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND a.ano = :ano";
            }
        }

        if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.dataPublicacaoVencimento = :datapublicacaovencimentoinicio";
                contador = 1;
            } else {
                selecao = selecao + " AND a.dataPublicacaoVencimento = :datapublicacaovencimentoinicio";
            }
        } else if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.dataPublicacaoVencimento between :datapublicacaovencimentoinicio and :datapublicacaovencimentotermino";
                contador = 1;
            } else {
                selecao = selecao + " AND a.dataPublicacaoVencimento between :datapublicacaovencimentoinicio and :datapublicacaovencimentotermino";
            }
        }
        
        if (finalizado || finalizado == false) {
            if (contador == 0) {
                selecao = selecao + " where a.finalizado is :finalizado";
                contador = 1;
            } else {
                selecao = selecao + " and a.finalizado is :finalizado";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY a.codigoAta");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (numeroAta != 0) {
            query.setParameter("numeroata", numeroAta);
        }
        
        if (numeroModalidade != 0) {
            query.setParameter("numeromodalidade", numeroModalidade);
        }
        
        if (numeroProcesso != 0) {
            query.setParameter("numeroprocesso", numeroProcesso);
        }
        
        if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino == null) {
            query.setParameter("datapublicacaovencimentoinicio", new java.sql.Date(dataPublicacaoVencimentoInicio.getTime()));
        } else if (dataPublicacaoVencimentoInicio != null && dataPublicacaoVencimentoTermino != null) {
            query.setParameter("datapublicacaovencimentoinicio", new java.sql.Date(dataPublicacaoVencimentoInicio.getTime()));
            query.setParameter("datapublicacaovencimentotermino", new java.sql.Date(dataPublicacaoVencimentoTermino.getTime()));
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        if (finalizado || finalizado == false) {
            query.setParameter("finalizado", finalizado);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarBlocos(String nomeBloco, int lote_codigoLote) {
        
        iniciaBloco();
        
        List lista = new ArrayList();
        String selecao = "select b from Bloco b";
        int contador = 0;

        if (!nomeBloco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where b.nomeBloco like :nomebloco";
                contador = 1;
            } else {
                selecao = selecao + " and b.nomeBloco like :nomebloco";
            }
        }

        if (lote_codigoLote != 0) {
            if (contador == 0) {
                selecao = selecao + " where b.lote.codigoLote = :codigolote";
                contador = 1;
            } else {
                selecao = selecao + " and b.lote.codigoLote = :codigolote";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY b.nomeBloco");

        if (!nomeBloco.isEmpty()) {
            query.setParameter("nomebloco", "%" + nomeBloco + "%");
        }
        
        if (lote_codigoLote != 0) {
            query.setParameter("codigolote", lote_codigoLote);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarCartuchos(int codigoCmei, int codigoEscola, int codigoOutro, String nomeModeloCartucho, String codigoBarras, String tipoEntidade, boolean cartuchoQueimado) {

        iniciaCartucho();
        
        List lista = new ArrayList();
        String selecao = "select c from Cartucho c";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and c.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and c.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and c.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.modeloCartucho.nomeModeloCartucho like :nomemodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND c.modeloCartucho.nomeModeloCartucho like :nomemodelocartucho";
            }
        }
        
        if (!codigoBarras.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.codigoBarra like :codigobarras";
                contador = 1;
            } else {
                selecao = selecao + " and c.codigoBarra like :codigobarras";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and c.tipoEntidade like :tipoentidade";
            }
        }
        
        if (cartuchoQueimado || cartuchoQueimado == false) {
            if (contador == 0) {
                selecao = selecao + " where c.cartuchoQueimado is :cartuchoqueimado";
                contador = 1;
            } else {
                selecao = selecao + " and c.cartuchoQueimado is :cartuchoqueimado";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY c.tipoEntidade");

        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!nomeModeloCartucho.isEmpty()) {
            query.setParameter("nomemodelocartucho", "%" + nomeModeloCartucho + "%");
        }
        
        if (!codigoBarras.isEmpty()) {
            query.setParameter("codigobarras", "%" + codigoBarras + "%");
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (cartuchoQueimado || cartuchoQueimado == false) {
            query.setParameter("cartuchoqueimado", cartuchoQueimado);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarCmeis(int codigoCmei, String nomeCmei, String coordenadorAtual) {

        iniciaCmei();
        
        List lista = new ArrayList();
        String selecao = "select c from Cmei c";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " where c.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and c.codigoCmei = :codigocmei";
            }
        }
        
        if (!nomeCmei.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.nomeCmei like :nomecmei";
                contador = 1;
            } else {
                selecao = selecao + " and c.nomeCmei like :nomecmei";
            }
        }

        if (!coordenadorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.coordenadorAtual like :coordenadoratual";
                contador = 1;
            } else {
                selecao = selecao + " and c.coordenadorAtual like :coordenadoratual";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY c.nomeCmei");
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (!nomeCmei.isEmpty()) {
            query.setParameter("nomecmei", nomeCmei);
        }

        if (!coordenadorAtual.isEmpty()) {
            query.setParameter("coordenadoratual", coordenadorAtual);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarCrachas(String nomeCracha, String departamentoCracha, String cargoCracha, Date dataCracha) {
        
        iniciaCrachas();
        
        List lista = new ArrayList();
        String selecao = "SELECT c FROM Crachas as c";
        int contador = 0;
        
        if (!nomeCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (c.nomeCracha1 like :nomecracha1 or c.nomeCracha2 like :nomecracha2 or c.nomeCracha3 like :nomecracha3 or c.nomeCracha4 like :nomecracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (c.nomeCracha1 like :nomecracha1 or c.nomeCracha2 like :nomecracha2 or c.nomeCracha3 like :nomecracha3 or c.nomeCracha4 like :nomecracha4)";
            }
        }
        
        if (!departamentoCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (c.departamentoCracha1 like :departamentocracha1 or c.departamentoCracha2 like :departamentocracha2 or c.departamentoCracha3 like :departamentocracha3 or c.departamentoCracha4 like :departamentocracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (c.departamentoCracha1 like :departamentocracha1 or c.departamentoCracha2 like :departamentocracha2 or c.departamentoCracha3 like :departamentocracha3 or c.departamentoCracha4 like :departamentocracha4)";
            }
        }
        
        if (!cargoCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (c.cargoCracha1 like :cargocracha1 or c.cargoCracha2 like :cargocracha2 or c.cargoCracha3 like :cargocracha3 or c.cargoCracha4 like :cargocracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (c.cargoCracha1 like :cargocracha1 or c.cargoCracha2 like :cargocracha2 or c.cargoCracha3 like :cargocracha3 or c.cargoCracha4 like :cargocracha4)";
            }
        }
        
        if (dataCracha != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.dataCracha = :datacracha";
                contador = 1;
            } else {
                selecao = selecao + " AND c.dataCracha = :datacracha";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY c.codigoCrachas");
        
        if (!nomeCracha.isEmpty()) {
            query.setParameter("nomecracha1", "%" + nomeCracha + "%");
            query.setParameter("nomecracha2", "%" + nomeCracha + "%");
            query.setParameter("nomecracha3", "%" + nomeCracha + "%");
            query.setParameter("nomecracha4", "%" + nomeCracha + "%");
        }
        
        if (!departamentoCracha.isEmpty()) {
            query.setParameter("departamentocracha1", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha2", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha3", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha4", "%" + departamentoCracha + "%");
        }
        
        if (!cargoCracha.isEmpty()) {
            query.setParameter("cargocracha1", "%" + cargoCracha + "%");
            query.setParameter("cargocracha2", "%" + cargoCracha + "%");
            query.setParameter("cargocracha3", "%" + cargoCracha + "%");
            query.setParameter("cargocracha4", "%" + cargoCracha + "%");
        }
        
        if (dataCracha != null) {
            query.setParameter("datacracha", new java.sql.Date(dataCracha.getTime()));
        }
        
        lista = query.list();

        encerraSessao();
        
        return lista;
        
    }
    
    public List listarCrachasCme(String nomeCracha, String departamentoCracha, String cargoCracha, Date dataCracha) {
        
        iniciaCrachas();
        
        List lista = new ArrayList();
        String selecao = "SELECT cc FROM CrachasCme as cc";
        int contador = 0;
        
        if (!nomeCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.nomeCracha1 like :nomecracha1 or cc.nomeCracha2 like :nomecracha2 or cc.nomeCracha3 like :nomecracha3 or cc.nomeCracha4 like :nomecracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.nomeCracha1 like :nomecracha1 or cc.nomeCracha2 like :nomecracha2 or cc.nomeCracha3 like :nomecracha3 or cc.nomeCracha4 like :nomecracha4)";
            }
        }
        
        if (!departamentoCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.departamentoCracha1 like :departamentocracha1 or cc.departamentoCracha2 like :departamentocracha2 or cc.departamentoCracha3 like :departamentocracha3 or cc.departamentoCracha4 like :departamentocracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.departamentoCracha1 like :departamentocracha1 or cc.departamentoCracha2 like :departamentocracha2 or cc.departamentoCracha3 like :departamentocracha3 or cc.departamentoCracha4 like :departamentocracha4)";
            }
        }
        
        if (!cargoCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.cargoCracha1 like :cargocracha1 or cc.cargoCracha2 like :cargocracha2 or cc.cargoCracha3 like :cargocracha3 or cc.cargoCracha4 like :cargocracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.cargoCracha1 like :cargocracha1 or cc.cargoCracha2 like :cargocracha2 or cc.cargoCracha3 like :cargocracha3 or cc.cargoCracha4 like :cargocracha4)";
            }
        }
        
        if (dataCracha != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE c.dataCracha = :datacracha";
                contador = 1;
            } else {
                selecao = selecao + " AND c.dataCracha = :datacracha";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY cc.codigoCrachaCme");
        
        if (!nomeCracha.isEmpty()) {
            query.setParameter("nomecracha1", "%" + nomeCracha + "%");
            query.setParameter("nomecracha2", "%" + nomeCracha + "%");
            query.setParameter("nomecracha3", "%" + nomeCracha + "%");
            query.setParameter("nomecracha4", "%" + nomeCracha + "%");
        }
        
        if (!departamentoCracha.isEmpty()) {
            query.setParameter("departamentocracha1", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha2", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha3", "%" + departamentoCracha + "%");
            query.setParameter("departamentocracha4", "%" + departamentoCracha + "%");
        }
        
        if (!cargoCracha.isEmpty()) {
            query.setParameter("cargocracha1", "%" + cargoCracha + "%");
            query.setParameter("cargocracha2", "%" + cargoCracha + "%");
            query.setParameter("cargocracha3", "%" + cargoCracha + "%");
            query.setParameter("cargocracha4", "%" + cargoCracha + "%");
        }
        
        if (dataCracha != null) {
            query.setParameter("datacracha", new java.sql.Date(dataCracha.getTime()));
        }
        
        lista = query.list();

        encerraSessao();
        
        return lista;
        
    }
    
    public List listarCrachasComae(String nomeCracha, String representacao, String cargoCracha, Date dataCracha) {
        
        iniciaCrachas();
        
        List lista = new ArrayList();
        String selecao = "SELECT cc FROM CrachasComae as cc";
        int contador = 0;
        
        if (!nomeCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.nomeCracha1 like :nomecracha1 or cc.nomeCracha2 like :nomecracha2 or cc.nomeCracha3 like :nomecracha3 or cc.nomeCracha4 like :nomecracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.nomeCracha1 like :nomecracha1 or cc.nomeCracha2 like :nomecracha2 or cc.nomeCracha3 like :nomecracha3 or cc.nomeCracha4 like :nomecracha4)";
            }
        }
        
        if (!representacao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.representacao1 like :representacao1 or cc.representacao2 like :representacao2 or cc.representacao3 like :representacao3 or cc.representacao4 like :representacao4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.representacao1 like :representacao1 or cc.representacao2 like :representacao2 or cc.representacao3 like :representacao3 or cc.representacao4 like :representacao4)";
            }
        }
        
        if (!cargoCracha.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE (cc.cargoCracha1 like :cargocracha1 or cc.cargoCracha2 like :cargocracha2 or cc.cargoCracha3 like :cargocracha3 or cc.cargoCracha4 like :cargocracha4)";
                contador = 1;
            } else {
                selecao = selecao + " AND (cc.cargoCracha1 like :cargocracha1 or cc.cargoCracha2 like :cargocracha2 or cc.cargoCracha3 like :cargocracha3 or cc.cargoCracha4 like :cargocracha4)";
            }
        }
        
        if (dataCracha != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE cc.dataCracha = :datacracha";
                contador = 1;
            } else {
                selecao = selecao + " AND cc.dataCracha = :datacracha";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY cc.codigoCrachaComae");
        
        if (!nomeCracha.isEmpty()) {
            query.setParameter("nomecracha1", "%" + nomeCracha + "%");
            query.setParameter("nomecracha2", "%" + nomeCracha + "%");
            query.setParameter("nomecracha3", "%" + nomeCracha + "%");
            query.setParameter("nomecracha4", "%" + nomeCracha + "%");
        }
        
        if (!representacao.isEmpty()) {
            query.setParameter("representacao1", "%" + representacao + "%");
            query.setParameter("representacao2", "%" + representacao + "%");
            query.setParameter("representacao3", "%" + representacao + "%");
            query.setParameter("representacao4", "%" + representacao + "%");
        }
        
        if (!cargoCracha.isEmpty()) {
            query.setParameter("cargocracha1", "%" + cargoCracha + "%");
            query.setParameter("cargocracha2", "%" + cargoCracha + "%");
            query.setParameter("cargocracha3", "%" + cargoCracha + "%");
            query.setParameter("cargocracha4", "%" + cargoCracha + "%");
        }
        
        if (dataCracha != null) {
            query.setParameter("datacracha", new java.sql.Date(dataCracha.getTime()));
        }
        
        lista = query.list();

        encerraSessao();
        
        return lista;
        
    }
    
    public List listarDepartamentoDivisaoSetor(int codigoDepartamentoDivisaoSetor, String nomeDepartamentoDivisaoSetor) {

        iniciaDepartamentoDivisaoSetor();
        
        List lista = new ArrayList();
        String selecao = "select dds from DepartamentoDivisaoSetor dds";
        int contador = 0;

        if (codigoDepartamentoDivisaoSetor != 0) {
            if (contador == 0) {
                selecao = selecao + " where dds.codigoDepartamentoDivisaoSetor = :codigodepartamentodivisaosetor";
                contador = 1;
            } else {
                selecao = selecao + " and dds.codigoDepartamentoDivisaoSetor = :codigodepartamentodivisaosetor";
            }
        }
        
        if (!nomeDepartamentoDivisaoSetor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where dds.nomeDepartamentoDivisaoSetor like :nomedepartamentodivisaosetor";
                contador = 1;
            } else {
                selecao = selecao + " and dds.nomeDepartamentoDivisaoSetor like :nomedepartamentodivisaosetor";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY dds.nomeDepartamentoDivisaoSetor");
        
        if (codigoDepartamentoDivisaoSetor != 0) {
            query.setParameter("codigodepartamentodivisaosetor", codigoDepartamentoDivisaoSetor);
        }
        
        if (!nomeDepartamentoDivisaoSetor.isEmpty()) {
            query.setParameter("nomedepartamentodivisaosetor", "%" + nomeDepartamentoDivisaoSetor + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarEdital(int codigoUsuario, Date dataSolicitacao, String modeloEdital, String tipoEdital, String ano) {

        iniciaEdital();
        
        List lista = new ArrayList();
        String selecao = "SELECT e FROM Edital e";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND e.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (dataSolicitacao != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.dataSolicitacao = :datasolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND e.dataSolicitacao = :datasolicitacao";
            }
        }

        if (!modeloEdital.equals("PORTARIA")) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.modeloEdital like :modeloedital";
                contador = 1;
            } else {
                selecao = selecao + " AND e.modeloEdital like :modeloedital";
            }
        }
        
        if (!tipoEdital.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.tipoEdital like :tipoedital";
                contador = 1;
            } else {
                selecao = selecao + " AND e.tipoEdital like :tipoedital";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.ano like :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND e.ano like :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY e.dataSolicitacao");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (dataSolicitacao != null) {
            query.setParameter("datasolicitacao", new java.sql.Date(dataSolicitacao.getTime()));
        }

        if (!modeloEdital.equals("PORTARIA")) {
            query.setParameter("modeloedital", modeloEdital);
        }
        
        if (!tipoEdital.isEmpty()) {
            query.setParameter("tipoedital", tipoEdital);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarEnderecos(String tipoEndereco, String endereco, String numeroEndereco, String cidade, String uf, String cep, int codigoAluno, int codigoCmei, 
            int codigoEscola, int codigoOutro) {
        
        iniciaEndereco();
        
        List lista = new ArrayList();
        String selecao = "SELECT e FROM Endereco as e";
        int contador = 0;
        
        if (codigoAluno != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.aluno.codigoAluno = :codigoaluno";
                contador = 1;
            } else {
                selecao = selecao + " AND e.aluno.codigoAluno = :codigoaluno";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND e.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND e.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.outro as o WHERE o.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND e.outro = :codigooutro";
            }
        }
        
        if (!tipoEndereco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.tipoEndereco LIKE :tipoendereco";
                contador = 1;
            } else {
                selecao = selecao + " AND e.tipoEndereco LIKE :tipoendereco";
            }
        }
        
        if (!endereco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.endereco LIKE :endereco";
                contador = 1;
            } else {
                selecao = selecao + " AND e.endereco LIKE :endereco";
            }
        }
        
        if (!numeroEndereco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.numeroEndereco LIKE :numeroendereco";
                contador = 1;
            } else {
                selecao = selecao + " AND e.numeroEndereco LIKE :numeroendereco";
            }
        }
        
        if (!cidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.cidade LIKE :cidade";
                contador = 1;
            } else {
                selecao = selecao + " AND e.cidade LIKE :cidade";
            }
        }
        
        if (!uf.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.uf LIKE :uf";
                contador = 1;
            } else {
                selecao = selecao + " AND e.uf LIKE :uf";
            }
        }
        
        if (!cep.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.cep LIKE :cep";
                contador = 1;
            } else {
                selecao = selecao + " AND e.cep LIKE :cep";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY e.tipoEndereco");
        
        if (!tipoEndereco.isEmpty()) {
            query.setParameter("tipoendereco", "%" + tipoEndereco + "%");
        }
        
        if (!endereco.isEmpty()) {
            query.setParameter("endereco", "%" + endereco + "%");
        }
        
        if (!numeroEndereco.isEmpty()) {
            query.setParameter("numeroendereco", "%" + numeroEndereco + "%");
        }
        
        if (!cidade.isEmpty()) {
            query.setParameter("cidade", "%" + cidade + "%");
        }
        
        if (!uf.isEmpty()) {
            query.setParameter("uf", "%" + uf + "%");
        }
        
        if (!cep.isEmpty()) {
            query.setParameter("cep", "%" + cep + "%");
        }
        
        if (codigoAluno != 0) {
            query.setParameter("codigoaluno", codigoAluno);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        lista = query.list();

        return lista;
        
    }

    public List listarEntregaRemanufaturados(Date dataInicio, Date dataTermino, int numeroProtocolo, String ano) {
        
        iniciaSolicitacaoRemanufatura();
        
        List lista = new ArrayList();
        String selecao = "select er from EntregaRemanufaturados er";
        int contador = 0;
        
        if (dataInicio != null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where er.dataRetorno between :datainicio and :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and er.dataRetorno between :datainicio and :datatermino";
            }
        }

        if (dataInicio != null && dataTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where er.dataRetorno = :datainicio";
                contador = 1;
            } else {
                selecao = selecao + " and er.dataRetorno = :datainicio";
            }
        }
        
        if (dataInicio == null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where er.dataRetorno = :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and er.dataRetorno = :datatermino";
            }
        }

        if (numeroProtocolo != 0) {
            if (contador == 0) {
                selecao = selecao + " where er.numeroEntregaRemanufaturados = :numeroprotocolo";
                contador = 1;
            } else {
                selecao = selecao + " and er.numeroEntregaRemanufaturados = :numeroprotocolo";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where er.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and er.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY er.numeroEntregaRemanufaturados, er.codigoEntregaRemanufaturados");
        
        if (dataInicio != null && dataTermino != null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (dataInicio != null && dataTermino == null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
        }
        
        if (dataInicio == null && dataTermino != null) {
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (numeroProtocolo != 0) {
            query.setParameter("numeroprotocolo", numeroProtocolo);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarEntregaRemanufaturadosItens(int codigoEntrega, int codigoCartucho) {
        
        iniciaEntregaRemanufaturadosItens();
        
        List lista = new ArrayList();
        String selecao = "select eri from EntregaRemanufaturadosItens eri";
        int contador = 0;
        
        if (codigoEntrega != 0) {
            if (contador == 0) {
                selecao = selecao + " where eri.entregaRemanufaturados.codigoEntregaRemanufaturados = :codigoentrega";
                contador = 1;
            } else {
                selecao = selecao + " and eri.entregaRemanufaturados.codigoEntregaRemanufaturados = :codigoentrega";
            }
        }
        
        if (codigoCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " where eri.cartucho.codigoCartucho = :codigocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and eri.cartucho.codigoCartucho = :codigocartucho";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY eri.codigoEntregaRemanufaturadosItens");
        
        if (codigoEntrega != 0) {
            query.setParameter("codigoentrega", codigoEntrega);
        }
        
        if (codigoCartucho != 0) {
            query.setParameter("codigocartucho", codigoCartucho);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarEquipamento(int codigoEquipamento, int codigoTipoEquipamento, String marca, String modelo, String patrimonio) {

        iniciaEquipamento();
        
        List lista = new ArrayList();
        String selecao = "SELECT e FROM Equipamento e";
        int contador = 0;

        if (codigoEquipamento != 0) {
            
            if (contador == 0) {
                selecao = selecao + " WHERE e.codigoEquipamento = :codigoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND e.codigoEquipamento = :codigoequipamento";
            }
        }
        
        if (codigoTipoEquipamento != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.tipoEquipamento.codigoTipoEquipamento = :codigotipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND e.tipoEquipamento.codigoTipoEquipamento = :codigotipoequipamento";
            }
        }
        
        if (!marca.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.marca like :marca";
                contador = 1;
            } else {
                selecao = selecao + " AND e.marca like :marca";
            }
        }

        if (!modelo.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.modelo like :modelo";
                contador = 1;
            } else {
                selecao = selecao + " AND e.modelo like :modelo";
            }
        }
        
        if (!patrimonio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.patrimonio like :patrimonio";
                contador = 1;
            } else {
                selecao = selecao + " AND e.patrimonio like :patrimonio";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY e.tipoEquipamento");
        
        if (codigoEquipamento != 0) {
            query.setParameter("codigoequipamento", codigoEquipamento);
        }
        
        if (codigoTipoEquipamento != 0) {
            query.setParameter("codigotipoequipamento", codigoTipoEquipamento);
        }
        
        if (!marca.isEmpty()) {
            query.setParameter("marca", "%" + marca + "%");
        }

        if (!modelo.isEmpty()) {
            query.setParameter("modelo", "%" + modelo + "%");
        }
        
        if (!patrimonio.isEmpty()) {
            query.setParameter("patrimonio", "%" + patrimonio + "%");
        }
        
        lista = query.list();

        return lista;
        
    }

    public List listarEquipamentoEntidades(int codigoCmei, int codigoEscola, int codigoOutro, String marca, String modelo, String patrimonio, String setor, String tipoEntidade) {

        iniciaEquipamentoEntidades();
        
        List lista = new ArrayList();
        String selecao = "select ee from EquipamentoEntidades ee";
        int contador = 0;

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE ee.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and ee.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE ee.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and ee.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE ee.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and ee.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!marca.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ee.marca like :marca";
                contador = 1;
            } else {
                selecao = selecao + " and ee.marca like :marca";
            }
        }
        
        if (!modelo.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ee.modelo like :modelo";
                contador = 1;
            } else {
                selecao = selecao + " and ee.modelo like :modelo";
            }
        }
        
        if (!patrimonio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ee.patrimonio like :patrimonio";
                contador = 1;
            } else {
                selecao = selecao + " and ee.patrimonio like :patrimonio";
            }
        }
        
        if (!setor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ee.setor like :setor";
                contador = 1;
            } else {
                selecao = selecao + " and ee.setor like :setor";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ee.tipoEntidade like :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and ee.tipoEntidade like :tipoentidade";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY ee.setorEquipamentoEntidade");
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
                
        if (!marca.isEmpty()) {
            query.setParameter("marca", "%" + marca + "%");
        }
        
        if (!modelo.isEmpty()) {
            query.setParameter("modelo", "%" + modelo + "%");
        }
        
        if (!patrimonio.isEmpty()) {
            query.setParameter("patrimonio", "%" + patrimonio + "%");
        }
        
        if (!setor.isEmpty()) {
            query.setParameter("setor", "%" + setor + "%");
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarEscolas(int codigoEscola, String nomeEscola, String diretorAtual) {

        iniciaEscola();
        
        List lista = new ArrayList();
        String selecao = "select e from Escola e";
        int contador = 0;

        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " where e.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and e.codigoEscola = :codigoescola";
            }
        }
        
        if (!nomeEscola.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.nomeEscola like :nomeescola";
                contador = 1;
            } else {
                selecao = selecao + " and e.nomeEscola like :nomeescola";
            }
        }

        if (!diretorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.diretorAtual like :diretoratual";
                contador = 1;
            } else {
                selecao = selecao + " and e.diretorAtual like :diretoratual";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY e.nomeEscola");
            
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (!nomeEscola.isEmpty()) {
            query.setParameter("nomeescola", nomeEscola);
        }

        if (!diretorAtual.isEmpty()) {
            query.setParameter("diretoratual", diretorAtual);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarInstrucoesNormativas(int codigoUsuario, Date dataSolicitacao, String modeloInstrucao, String tipoInstrucao, String ano) {

        iniciaPortaria();
        
        List lista = new ArrayList();
        String selecao = "SELECT inst FROM InstrucaoNormativa inst";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE inst.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND inst.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (dataSolicitacao != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE inst.dataSolicitacao = :datasolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND inst.dataSolicitacao = :datasolicitacao";
            }
        }
        
        if (!modeloInstrucao.equals("INSTRUÇÃO NORMATIVA")) {
            if (contador == 0) {
                selecao = selecao + " WHERE inst.modeloInstrucao = :modeloinstrucao";
                contador = 1;
            } else {
                selecao = selecao + " AND inst.modeloInstrucao = :modeloinstrucao";
            }
        }
            
        if (!tipoInstrucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE inst.tipoInstrucao = :tipoinstrucao";
                contador = 1;
            } else {
                selecao = selecao + " AND inst.tipoInstrucao = :tipoinstrucao";
            }
        }

        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE inst.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND inst.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY inst.codigoInstrucao");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (dataSolicitacao != null) {
            query.setParameter("datasolicitacao", new java.sql.Date(dataSolicitacao.getTime()));
        }
        
        if (!modeloInstrucao.equals("INSTRUÇÃO NORMATIVA")) {
            query.setParameter("modeloinstrucao", modeloInstrucao);
        }
            
        if (!tipoInstrucao.isEmpty()) {
            query.setParameter("tipoinstrucao", tipoInstrucao);
        }

        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarLinhas(int numeroLinha, int bloco_codigoBloco, String carro) {
        
        iniciaLinha();
        
        List lista = new ArrayList();
        String selecao = "select l from Linha l";
        int contador = 0;

        if (numeroLinha != 0) {
            if (contador == 0) {
                selecao = selecao + " where l.numeroLinha = :numerolinha";
                contador = 1;
            } else {
                selecao = selecao + " and l.numeroLinha = :numerolinha";
            }
        }
        
        if (bloco_codigoBloco != 0) {
            if (contador == 0) {
                selecao = selecao + " where l.bloco.codigoBloco = :bloco_codigobloco";
                contador = 1;
            } else {
                selecao = selecao + " and l.bloco.codigoBloco = :bloco_codigobloco";
            }
        }
        
        if (!carro.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where l.carro = :carro";
                contador = 1;
            } else {
                selecao = selecao + " and l.carro = :carro";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY l.numeroLinha");

        if (numeroLinha != 0) {
            query.setParameter("numerolinha", numeroLinha);
        }
        
        if (bloco_codigoBloco != 0) {
            query.setParameter("bloco_codigobloco", bloco_codigoBloco);
        }
        
        if (!carro.isEmpty()) {
            query.setParameter("carro", carro);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarLogs(int codigoUsuario, Date dataAcao) {

        iniciaLog2();
        
        List lista = new ArrayList();
        String selecao = "select l from Log2 l";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " where l.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " and l.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (dataAcao != null) {
            if (contador == 0) {
                selecao = selecao + " where l.dataAcao = :dataacao";
                contador = 1;
            } else {
                selecao = selecao + " and l.dataAcao = :dataacao";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY l.dataAcao");
        
        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (dataAcao != null) {
            query.setParameter("dataacao", new java.sql.Date(dataAcao.getTime()));
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarLotes(String numeroLote, String nomeLote) {
        
        iniciaLote();
        
        List lista = new ArrayList();
        String selecao = "select l from Lote l";
        int contador = 0;

        if (!numeroLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where l.numeroLote = :numerolote";
                contador = 1;
            } else {
                selecao = selecao + " and l.numeroLote = :numerolote";
            }

        }
        
        if (!nomeLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where l.nomeLote like :nomelote";
                contador = 1;
            } else {
                selecao = selecao + " and l.nomeLote like :nomelote";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY l.numeroLote");

        if (!numeroLote.isEmpty()) {
            query.setParameter("numerolote", numeroLote);
        }
        
        if (!nomeLote.isEmpty()) {
            query.setParameter("nomelote", "%" + nomeLote + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
//    public List listarModelosCartuchos() {
//
//        iniciaModeloCartucho();
//        
//        List lista = new ArrayList();
//        String selecao = "select mc from ModeloCartucho mc";
//        int contador = 0;
//
//        iniciaSessao();
//        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY mc.nomeModeloCartucho");
//        
//        lista = query.list();
//
//        encerraSessao();
//
//        return lista;
//
//    }
    
    public List listarModelosCartuchos(String nomeModeloCartucho, String marca) {

        iniciaModeloCartucho();
        
        List lista = new ArrayList();
        String selecao = "select mc from ModeloCartucho mc";
        int contador = 0;

        if (!nomeModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where mc.nomeModeloCartucho like :nomemodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and mc.nomeModeloCartucho like :nomemodelocartucho";
            }

        }
        
        if (!marca.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where mc.marca like :marca";
                contador = 1;
            } else {
                selecao = selecao + " and mc.marca like :marca";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY mc.nomeModeloCartucho");

        if (!nomeModeloCartucho.isEmpty()) {
            query.setParameter("nomemodelocartucho", "%" + nomeModeloCartucho + "%");
        }
        
        if (!marca.isEmpty()) {
            query.setParameter("marca", "%" + marca + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }

    public List listarOficio(int codigoUsuario, Date dataSolicitacaoInicio, Date dataSolicitacaoTermino, String modeloOficio, String tipoOficio, String ano) {

        iniciaOutro();
        
        List lista = new ArrayList();
        String selecao = "SELECT o FROM Oficio o";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE o.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND o.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where o.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and o.dataSolicitacao between :datasolicitacaoinicio and :datasolicitacaotermino";
            }
        }

        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where o.dataSolicitacao = :datasolicitacaoinicio";
                contador = 1;
            } else {
                selecao = selecao + " and o.dataSolicitacao = :datasolicitacaoinicio";
            }
        }

        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where o.dataSolicitacao = :datasolicitacaotermino";
                contador = 1;
            } else {
                selecao = selecao + " and o.dataSolicitacao = :datasolicitacaotermino";
            }
        }
        
        if (!modeloOficio.equals("TODOS")) {
            if (contador == 0) {
                selecao = selecao + " where o.modeloOficio = :modelooficio";
                contador = 1;
            } else {
                selecao = selecao + " and o.modeloOficio = :modelooficio";
            }
        }

        if (!tipoOficio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.tipoOficio = :tipooficio";
                contador = 1;
            } else {
                selecao = selecao + " and o.tipoOficio = :tipooficio";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and o.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY o.codigoOficio");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }

        if (dataSolicitacaoInicio != null && dataSolicitacaoTermino == null) {
            query.setParameter("datasolicitacaoinicio", new java.sql.Date(dataSolicitacaoInicio.getTime()));
        }

        if (dataSolicitacaoInicio == null && dataSolicitacaoTermino != null) {
            query.setParameter("datasolicitacaotermino", new java.sql.Date(dataSolicitacaoTermino.getTime()));
        }
        
        if (!modeloOficio.equals("TODOS")) {
            query.setParameter("modelooficio", modeloOficio);
        }

        if (!tipoOficio.isEmpty()) {
            query.setParameter("tipooficio", tipoOficio);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarOutros(int codigoOutro, String nomeOutro, String coordenadorAtual) {

        iniciaOutro();
        
        List lista = new ArrayList();
        String selecao = "select o from Outro o";
        int contador = 0;

        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " where o.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and o.codigoOutro = :codigooutro";
            }
        }
        
        if (!nomeOutro.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.nomeOutro like :nomeoutro";
                contador = 1;
            } else {
                selecao = selecao + " and o.nomeOutro like :nomeoutro";
            }
        }
        
        if (!coordenadorAtual.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.coordenadorAtual like :coordenadoratual";
                contador = 1;
            } else {
                selecao = selecao + " and o.coordenadorAtual like :coordenadoratual";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY o.nomeOutro");

        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!nomeOutro.isEmpty()) {
            query.setParameter("nomeoutro", nomeOutro);
        }

        if (!coordenadorAtual.isEmpty()) {
            query.setParameter("coordenadoratual", coordenadorAtual);
        }

        lista = query.list();

        encerraSessao();

        return lista;
        
    }

    public List listarPermissoes(String nomeUsuario) {

        iniciaPermissoes();
        
        List lista = new ArrayList();
        String selecao = "select p from Permissoes p";
        int contador = 0;

        if (!nomeUsuario.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.nomeUsuario like :nomeusuario";
                contador = 1;
            } else {
                selecao = selecao + " and p.nomeUsuario like :nomeusuario";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY te.nomeUsuario");
        
        if (!nomeUsuario.isEmpty()) {
            query.setParameter("nomeusuario", "%" + nomeUsuario + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarPortaria(int codigoUsuario, Date dataSolicitacao, String modeloPortaria, String tipoPortaria, String ano) {

        iniciaPortaria();
        
        List lista = new ArrayList();
        String selecao = "SELECT p FROM Portaria p";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " AND p.usuario.codigoUsuario = :codigousuario";
            }
        }
        
        if (dataSolicitacao != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.dataSolicitacao = :datasolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " AND p.dataSolicitacao = :datasolicitacao";
            }
        }
        
        if (!modeloPortaria.equals("PORTARIA")) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.modeloPortaria = :modeloportaria";
                contador = 1;
            } else {
                selecao = selecao + " AND p.modeloPortaria = :modeloportaria";
            }
        }
            
        if (!tipoPortaria.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.tipoPortaria = :tipoportaria";
                contador = 1;
            } else {
                selecao = selecao + " AND p.tipoPortaria = :tipoportaria";
            }
        }

        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE p.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND p.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY p.codigoPortaria");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (dataSolicitacao != null) {
            query.setParameter("datasolicitacao", new java.sql.Date(dataSolicitacao.getTime()));
        }
        
        if (!modeloPortaria.equals("PORTARIA")) {
            query.setParameter("modeloportaria", modeloPortaria);
        }
            
        if (!tipoPortaria.isEmpty()) {
            query.setParameter("tipoportaria", tipoPortaria);
        }

        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarRecarga(int codigoEscola, int codigoCmei, int codigoModeloCartucho, int codigoOutro, String codigoBarras, String tipoEntidade, /*String condicaoDataRecarga, String condicaoDataDevolucao,*/
             String condicaoModeloCartucho, String tipoStatus, String cartuchoQueimado, Date dataEntregaInicio, Date dataEntregaTermino, Date dataRecargaInicio, Date dataRecargaTermino) {

        iniciaRecarga();
        
        List lista = new ArrayList();
        String selecao = "SELECT r FROM Recarga r";
        int contador = 0;
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (codigoModeloCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.modeloCartucho.codigoModeloCartucho = :codigomodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.modeloCartucho.codigoModeloCartucho = :codigomodelocartucho";
            }
        }
        
        if (!codigoBarras.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.codigoBarra LIKE :codigobarras";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.codigoBarra LIKE :codigobarras";
            }
        }

        if (dataEntregaInicio != null && dataEntregaTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataEntrega between :dataentregainicio AND :dataentregatermino";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataEntrega between :dataentregainicio AND :dataentregatermino";
            }
        }
        
        if (dataEntregaInicio != null && dataEntregaTermino == null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataEntrega = :dataentregainicio";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataEntrega = :dataentregainicio";
            }
        }
        
        if (dataEntregaInicio == null && dataEntregaTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataEntrega = :dataentregatermino";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataEntrega = :dataentregatermino";
            }
        }
        
        if (dataRecargaInicio != null && dataRecargaTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataRecarga between :datarecargainicio AND :datarecargatermino";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataRecarga between :datarecargainicio AND :datarecargatermino";
            }
        }
        
        if (dataRecargaInicio != null && dataRecargaTermino == null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataRecarga = :datarecargainicio";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataRecarga = :datarecargainicio";
            }
        }
        
        if (dataRecargaInicio == null && dataRecargaTermino != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataRecarga = :datarecargatermino";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataRecarga = :datarecargatermino";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.tipoEntidade LIKE :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " AND r.tipoEntidade LIKE :tipoentidade";
            }
        }
        
        /*if (!condicaoModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.modeloCartucho " + condicaoModeloCartucho + " :modelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " AND r.modeloCartucho " + condicaoModeloCartucho + " :modelocartucho";
            }

        }*/
        
        if (!condicaoModeloCartucho.isEmpty()) {
            
            switch(condicaoModeloCartucho) {
                
                case "like":
                    if (contador == 0) {
                        selecao = selecao + " WHERE r.cartucho.modeloCartucho.nomeModeloCartucho LIKE :modelocartucho";
                        contador = 1;
                    } else {
                        selecao = selecao + " AND r.cartucho.modeloCartucho.nomeModeloCartucho LIKE :modelocartucho";
                    }
                    break;
                    
                case "not like":
                    if (contador == 0) {
                        selecao = selecao + " WHERE r.cartucho.modeloCartucho.nomeModeloCartucho NOT LIKE :modelocartucho";
                        contador = 1;
                    } else {
                        selecao = selecao + " AND r.cartucho.modeloCartucho.nomeModeloCartucho NOT LIKE :modelocartucho";
                    }
                    break;
                        
            }
            
        }
        
        /*if (!tipoStatus.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.dataRecarga is :condicaodatarecarga AND datadevolucao is :condicaodatadevolucao";
                contador = 1;
            } else {
                selecao = selecao + " AND r.dataRecarga is :condicaodatarecarga AND datadevolucao is :condicaodatadevolucao";
            }

        }*/
        
        if (!tipoStatus.isEmpty()) {
            
            switch(tipoStatus) {
                
                case "CARREGAR":
                    if (contador == 0) {
                        selecao = selecao + " WHERE r.dataRecarga is null AND datadevolucao is null";
                        contador = 1;
                    } else {
                        selecao = selecao + " AND r.dataRecarga is null AND datadevolucao is null";
                    }
                    break;
                    
                case "CARREGADO":
                    if (contador == 0) {
                        selecao = selecao + " WHERE r.dataRecarga is not null AND datadevolucao is null";
                        contador = 1;
                    } else {
                        selecao = selecao + " AND r.dataRecarga is not null AND datadevolucao is null";
                    }
                    break;
                    
                case "DEVOLVIDO":
                    if (contador == 0) {
                        selecao = selecao + " WHERE r.dataRecarga is not null AND datadevolucao is not null";
                        contador = 1;
                    } else {
                        selecao = selecao + " AND r.dataRecarga is not null AND datadevolucao is not null";
                    }
                    break;
                
            }

        }

        if (!cartuchoQueimado.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE r.cartucho.cartuchoQueimado = :cartuchoqueimado";
                contador = 1;
            } else {
                selecao = selecao + " AND r.cartucho.cartuchoQueimado = :cartuchoqueimado";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY r.tipoEntidade");

        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoModeloCartucho != 0) {
            query.setParameter("codigomodelocartucho", codigoModeloCartucho);
        }        
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!codigoBarras.isEmpty()) {
            query.setParameter("codigobarras", "%" + codigoBarras + "%");
        }

        if (dataEntregaInicio != null && dataEntregaTermino != null) {
            query.setParameter("dataentregainicio", new java.sql.Date(dataEntregaInicio.getTime()));
            query.setParameter("dataentregatermino", new java.sql.Date(dataEntregaTermino.getTime()));
        }
        
        if (dataEntregaInicio != null && dataEntregaTermino == null) {
            query.setParameter("dataentregainicio", new java.sql.Date(dataEntregaInicio.getTime()));
        }
        
        if (dataEntregaInicio == null && dataEntregaTermino != null) {
            query.setParameter("dataentregatermino", new java.sql.Date(dataEntregaTermino.getTime()));
        }
        
        if (dataRecargaInicio != null && dataRecargaTermino != null) {
            query.setParameter("datarecargainicio", new java.sql.Date(dataRecargaInicio.getTime()));
            query.setParameter("datarecargatermino", new java.sql.Date(dataRecargaTermino.getTime()));
        }
        
        if (dataRecargaInicio != null && dataRecargaTermino == null) {
            query.setParameter("datarecargainicio", new java.sql.Date(dataRecargaInicio.getTime()));
        }
        
        if (dataRecargaInicio == null && dataRecargaTermino != null) {
            query.setParameter("datarecargatermino", new java.sql.Date(dataRecargaTermino.getTime()));
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", "%" + tipoEntidade + "%");
        }
        
        if (!condicaoModeloCartucho.isEmpty()) {
            query.setParameter("modelocartucho", "'%TONER%'");
        }
        
        /*if (!tipoStatus.isEmpty()) {
            query.setParameter("condicaodatarecarga", condicaoDataRecarga);
            query.setParameter("condicaodatadevolucao", condicaoDataDevolucao);
        }*/

        if (!cartuchoQueimado.isEmpty()) {
            query.setParameter("cartuchoqueimado", Boolean.valueOf(cartuchoQueimado));
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarResolucao(int codigoUsuario, Date dataSolicitacao, String modeloResolucao, String tipoResolucao, String ano) {

        iniciaResolucao();
        
        List lista = new ArrayList();
        String selecao = "select r from Resolucao r";
        int contador = 0;

        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.usuario.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " and r.usuario.codigoUsuario = :codigousuario";
            }
        }

        if (dataSolicitacao != null) {
            if (contador == 0) {
                selecao = selecao + " where r.dataSolicitacao = :datasolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " and r.dataSolicitacao = :datasolicitacao";
            }
        }
        
        if (!modeloResolucao.equals("PORTARIA")) {
            if (contador == 0) {
                selecao = selecao + " where r.modeloResolucao like :modeloresolucao";
                contador = 1;
            } else {
                selecao = selecao + " and r.modeloResolucao like :modeloresolucao";
            }
        }
        
        if (!tipoResolucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where r.tipoResolucao = :tiporesolucao";
                contador = 1;
            } else {
                selecao = selecao + " and r.tipoResolucao = :tiporesolucao";
            }
        }

        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where r.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and r.ano = :ano";
            }
        }
            
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY r.codigoResolucao");
        
        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }

        if (dataSolicitacao != null) {
            query.setParameter("datasolicitacao", new java.sql.Date(dataSolicitacao.getTime()));
        }
        
        if (!modeloResolucao.equals("PORTARIA")) {
            query.setParameter("modeloresolucao", modeloResolucao);
        }
        
        if (!tipoResolucao.isEmpty()) {
            query.setParameter("tiporesolucao", tipoResolucao);
        }

        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;

    }
    
    public List listarSolicitacaoRecarga(String emissor, String receptor, Date dataInicio, Date dataTermino, int numeroSolicitacao, String ano) {
        
        iniciaSolicitacaoRecarga();
        
        List lista = new ArrayList();
        String selecao = "select sr from SolicitacaoRecarga sr";
        int contador = 0;
        
        if (!emissor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.emissor like :emissor";
                contador = 1;
            } else {
                selecao = selecao + " and sr.emissor like :emissor";
            }

        }
        
        if (!receptor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.receptor like :receptor";
                contador = 1;
            } else {
                selecao = selecao + " and sr.receptor like :receptor";
            }

        }
        
        if (dataInicio != null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataSolicitacao between :datainicio and :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataSolicitacao between :datainicio and :datatermino";
            }

        }

        if (dataInicio != null && dataTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataSolicitacao = :datainicio";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataSolicitacao = :datainicio";
            }

        }
        
        if (dataInicio == null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataSolicitacao = :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataSolicitacao = :datatermino";
            }

        }

        if (numeroSolicitacao != 0) {
            if (contador == 0) {
                selecao = selecao + " where sr.numeroSolicitacao = :numerosolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " and sr.numeroSolicitacao = :numerosolicitacao";
            }

        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and sr.ano = :ano";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY sr.numeroSolicitacao, sr.codigoSolicitacaoRecarga");
        
        if (!emissor.isEmpty()) {
            query.setParameter("emissor", "%" + emissor + "%");
        }
        
        if (!receptor.isEmpty()) {
            query.setParameter("receptor", "%" + receptor + "%");
        }
        
        if (dataInicio != null && dataTermino != null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (dataInicio != null && dataTermino == null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
        }
        
        if (dataInicio == null && dataTermino != null) {
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (numeroSolicitacao != 0) {
            query.setParameter("numerosolicitacao", numeroSolicitacao);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarSolicitacaoRemanufatura(String emissor, String receptor, Date dataInicio, Date dataTermino, int numeroSolicitacao, String ano) {
        
        iniciaSolicitacaoRemanufatura();
        
        List lista = new ArrayList();
        String selecao = "select sr from SolicitacaoRemanufatura sr";
        int contador = 0;
        
        if (!emissor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.emissorSecretaria like :emissor";
                contador = 1;
            } else {
                selecao = selecao + " and sr.emissorSecretaria like :emissor";
            }

        }
        
        if (!receptor.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.receptorEmpresa like :receptor";
                contador = 1;
            } else {
                selecao = selecao + " and sr.receptorEmpresa like :receptor";
            }

        }
        
        if (dataInicio != null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataEnvio between :datainicio and :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataEnvio between :datainicio and :datatermino";
            }

        }

        if (dataInicio != null && dataTermino == null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataEnvio = :datainicio";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataEnvio = :datainicio";
            }

        }
        
        if (dataInicio == null && dataTermino != null) {
            if (contador == 0) {
                selecao = selecao + " where sr.dataEnvio = :datatermino";
                contador = 1;
            } else {
                selecao = selecao + " and sr.dataEnvio = :datatermino";
            }

        }

        if (numeroSolicitacao != 0) {
            if (contador == 0) {
                selecao = selecao + " where sr.numeroSolicitacao = :numerosolicitacao";
                contador = 1;
            } else {
                selecao = selecao + " and sr.numeroSolicitacao = :numerosolicitacao";
            }

        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and sr.ano = :ano";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY sr.numeroSolicitacao, sr.codigoSolicitacaoRemanufatura");
        
        if (!emissor.isEmpty()) {
            query.setParameter("emissor", "%" + emissor + "%");
        }
        
        if (!receptor.isEmpty()) {
            query.setParameter("receptor", "%" + receptor + "%");
        }
        
        if (dataInicio != null && dataTermino != null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (dataInicio != null && dataTermino == null) {
            query.setParameter("datainicio", new java.sql.Date(dataInicio.getTime()));
        }
        
        if (dataInicio == null && dataTermino != null) {
            query.setParameter("datatermino", new java.sql.Date(dataTermino.getTime()));
        }

        if (numeroSolicitacao != 0) {
            query.setParameter("numerosolicitacao", numeroSolicitacao);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarSolicitacaoRemanufaturaItens(int codigoSolicitacaoRemanufatura, int codigoCartucho) {
        
        iniciaSolicitacaoRemanufaturaItens();
        
        List lista = new ArrayList();
        String selecao = "select sr from SolicitacaoRemanufaturaItens sr";
        int contador = 0;
        
        if (codigoSolicitacaoRemanufatura != 0) {
            if (contador == 0) {
                selecao = selecao + " where sr.solicitacaoRemanufatura.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
                contador = 1;
            } else {
                selecao = selecao + " and sr.solicitacaoRemanufatura.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
            }

        }
        
        if (codigoCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " where sr.cartucho.codigoCartucho = :codigocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and sr.cartucho.codigoCartucho = :codigocartucho";
            }

        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY sr.codigoSolicitacaoRemanufaturaItens");
        
        if (codigoSolicitacaoRemanufatura != 0) {
            query.setParameter("codigosolicitacaoremanufatura", codigoSolicitacaoRemanufatura);
        }
        
        if (codigoCartucho != 0) {
            query.setParameter("codigocartucho", codigoCartucho);
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }

    public List listarTipoEquipamentos(int codigoTipoEquipamento, String nomeTipoEquipamento) {

        iniciaTipoEquipamento();
        
        List lista = new ArrayList();
        String selecao = "select te from TipoEquipamento te";
        int contador = 0;
        
        if (codigoTipoEquipamento != 0) {
            if (contador == 0) {
                selecao = selecao + " where te.codigoTipoEquipamento = :codigotipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " and te.codigoTipoEquipamento = :codigotipoequipamento";
            }
        }
        
        if (!nomeTipoEquipamento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where te.nomeTipoEquipamento like :nometipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " and te.nomeTipoEquipamento like :nometipoequipamento";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY te.nomeTipoEquipamento");
        
        if (codigoTipoEquipamento != 0) {
            query.setParameter("codigotipoequipamento", codigoTipoEquipamento);
        }
        
        if (!nomeTipoEquipamento.isEmpty()) {
            query.setParameter("nometipoequipamento", "%" + nomeTipoEquipamento + "%");
        }
        
        lista = query.list();

        encerraSessao();

        return lista;
        
    }
    
    public List listarUsuarios(int codigoUsuario, String nomeUsuario, String matricula, boolean usuarioInativo) {

        iniciaUsuario();
        
        List lista = new ArrayList();
        String selecao = "select u from Usuario u";
        int contador = 0;
        
        if (codigoUsuario != 0) {
            if (contador == 0) {
                selecao = selecao + " where u.codigoUsuario = :codigousuario";
                contador = 1;
            } else {
                selecao = selecao + " and u.codigoUsuario = :codigousuario";
            }
        }
        
        if (!nomeUsuario.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where u.nomeUsuario like :nomeusuario";
                contador = 1;
            } else {
                selecao = selecao + " and u.nomeUsuario like :nomeusuario";
            }
        }
        
        if (!matricula.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where u.matricula = :matricula";
                contador = 1;
            } else {
                selecao = selecao + " and u.matricula = :matricula";
            }
        }
        
        if (contador == 0) {
            selecao = selecao + " where u.usuarioInativo = :usuarioinativo";
            contador = 1;
        } else {
            selecao = selecao + " and u.usuarioInativo = :usuarioinativo";
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY u.nomeUsuario");

        if (codigoUsuario != 0) {
            query.setParameter("codigousuario", codigoUsuario);
        }
        
        if (!nomeUsuario.isEmpty()) {
            query.setParameter("nomeusuario", "%'" + nomeUsuario + "'%");
        }
        
        if (!matricula.isEmpty()) {
            query.setParameter("matricula", matricula);
        }
        
        query.setParameter("usuarioinativo", usuarioInativo);
        
        lista = query.list();

        encerraSessao();

        return lista;

    }

    public List listarUsuariosPermissoes(String nomeUsuario, String matricula) {

        iniciaPermissoes();
        
        List lista = new ArrayList();
        String selecao = "select p from Permissoes p";
        int contador = 0;

        if (!nomeUsuario.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.nomeUsuario.getNomeUsuario() like :nomeusuario";
                contador = 1;
            } else {
                selecao = selecao + " and p.nomeUsuario.getNomeUsuario() like :nomeusuario";
            }
        }
        
        if (!matricula.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.nomeUsuario.getMatricula() like :matricula";
                contador = 1;
            } else {
                selecao = selecao + " and p.nomeUsuario.getMatricula() like :matricula";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao + " ORDER BY p.nomeUsuario.getNomeUsuario()");
        
        if (!nomeUsuario.isEmpty()) {
            query.setParameter("nomeusuario", nomeUsuario);
        }
        
        if (!matricula.isEmpty()) {
            query.setParameter("matricula", matricula);
        }

        lista = query.list();

        encerraSessao();

        return lista;
        
    }

//Verificadores========================================================================================================================================
    /*public List verificarDisponibilidadeEquipamentoCriteria(Date dataEmprestimo) {
        
        iniciaSessao();
        
        Criteria criteria = session.createCriteria(AgendamentoEquipamento.class);
        
        criteria.add(Restrictions.);
        
        
    }*/
    public String verificarAgendamentoExistente(int codigoCmei, int codigoEscola, int codigoOutro, String tipoEntidade, String status, String tipoAgendamento) {

        iniciaAgendamento();
        
        String selecao = "SELECT a FROM Agendamento a";
        int contador = 0;
        List lista = new ArrayList();

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND a.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND a.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND a.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoEntidade = :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoEntidade = :tipoentidade";
            }
        }
        
        if (!status.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.status = :status";
                contador = 1;
            } else {
                selecao = selecao + " and a.status = :status";
            }
        }
        
        if (!tipoAgendamento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoAgendamento like :tipoagendamento";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoAgendamento like :tipoagendamento";
            }
        }
        
        if (contador == 0) {
            selecao = selecao + " where a.status like :status2";
            contador = 1;
        } else {
            selecao = selecao + " and a.status like :status2";
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", tipoEntidade);
        }
        
        if (!status.isEmpty()) {
            query.setParameter("status", status);
        }
        
        if (!tipoAgendamento.isEmpty()) {
            query.setParameter("tipoagendamento", "%" + tipoAgendamento + "%");
        }
        
        query.setParameter("status2", "AGENDADO");
        
        lista = query.list();
        
        if (lista.size() == 0) {
            encerraSessao();
            return "";
        } else {
            agendamento = (Agendamento) lista.get(1);
        
            encerraSessao();

            return agendamento.getTipoEntidade();
        }

    }
    
    public String verificarAgendamentoOficioExistente(int codigoCmei, int codigoEscola, int codigoOutro, String tipoEntidade, String status) {

        iniciaAgendamentoOficio();
        
        String selecao = "SELECT a FROM AgendamentoOficio a";
        int contador = 0;
        List lista = new ArrayList();

        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " AND a.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " AND a.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE a.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " AND a.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!tipoEntidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.tipoEntidade = :tipoentidade";
                contador = 1;
            } else {
                selecao = selecao + " and a.tipoEntidade = :tipoentidade";
            }
        }
        
        if (!status.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.status = :status";
                contador = 1;
            } else {
                selecao = selecao + " and a.status = :status";
            }
        }
        
        if (contador == 0) {
            selecao = selecao + " where a.status like :status2";
            contador = 1;
        } else {
            selecao = selecao + " and a.status like :status2";
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!tipoEntidade.isEmpty()) {
            query.setParameter("tipoentidade", tipoEntidade);
        }
        
        if (!status.isEmpty()) {
            query.setParameter("status", status);
        }
        
        query.setParameter("status2", "AGENDADO");
        
        lista = query.list();
        
        if (lista.size() == 0) {
            encerraSessao();
            return "";
        } else {
            agendamentoOficio = (AgendamentoOficio) lista.get(1);
        
            encerraSessao();

            return agendamentoOficio.getTipoEntidade();
        }

    }
    
    public String verificarAta(int numeroAta, String ano) {

        iniciaAta();
        
        String selecao = "select a from Ata a";
        int contador = 0;
        
        if (numeroAta != 0) {
            if (contador == 0) {
                selecao = selecao + " where a.numeroAta = :numeroata";
                contador = 1;
            } else {
                selecao = selecao + " and a.numeroAta = :numeroata";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where a.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and a.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (numeroAta != 0) {
            query.setParameter("numeroata", numeroAta);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        ata = (Ata) query.uniqueResult();
        
        encerraSessao();

        if (ata == null) {
            return "";
        } else {
            return ata.getNumeroAta()+ "";
        }

    }
    
    public Object verificarCadastroBloco(String nomeBloco) {
        
        iniciaBloco();
         
        String selecao = "select b from Bloco b";
        int contador = 0;
     
        if (!nomeBloco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where b.nomeBloco = :nomebloco";
                contador = 1;
            } else {
                selecao = selecao + " and b.nomeBloco = :nomebloco";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!nomeBloco.isEmpty()) {
            query.setParameter("nomebloco", nomeBloco);
        }
        
        bloco = (Bloco) query.uniqueResult();
        
        if (bloco == null) {
            return null;
        } else {
            return bloco;
        }
        
    }
    
    public String verificarCadastroEndereco(int codigoAluno, int codigoCmei, int codigoEscola, int codigoOutro, String tipoEndereco, String endereco, String numero, String cep, String cidade, 
            String uf, String bairro) {
        
        iniciaEndereco();
        
        String selecao = "select e from Endereco e";
        int contador = 0;
        
        if (codigoAluno != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.aluno.codigoAluno = :codigoaluno";
                contador = 1;
            } else {
                selecao = selecao + " and e.aluno.codigoAluno = :codigoaluno";
            }
        }
        
        if (codigoCmei != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.cmei.codigoCmei = :codigocmei";
                contador = 1;
            } else {
                selecao = selecao + " and e.cmei.codigoCmei = :codigocmei";
            }
        }
        
        if (codigoEscola != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.escola.codigoEscola = :codigoescola";
                contador = 1;
            } else {
                selecao = selecao + " and e.escola.codigoEscola = :codigoescola";
            }
        }
        
        if (codigoOutro != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.outro.codigoOutro = :codigooutro";
                contador = 1;
            } else {
                selecao = selecao + " and e.outro.codigoOutro = :codigooutro";
            }
        }
        
        if (!tipoEndereco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.tipoEndereco = :tipoendereco";
                contador = 1;
            } else {
                selecao = selecao + " and e.tipoEndereco = :tipoendereco";
            }
        }
        
        if (!endereco.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.endereco = :endereco";
                contador = 1;
            } else {
                selecao = selecao + " and e.endereco = :endereco";
            }
        }
        
        if (!numero.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.numeroEndereco = :numeroendereco";
                contador = 1;
            } else {
                selecao = selecao + " and e.numeroEndereco = :numeroendereco";
            }
        }
        
        if (!cep.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.cep = :cep";
                contador = 1;
            } else {
                selecao = selecao + " and e.cep = :cep";
            }
        }
        
        if (!cidade.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.cidade = :cidade";
                contador = 1;
            } else {
                selecao = selecao + " and e.cidade = :cidade";
            }
        }
        
        if (!uf.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.uf = :uf";
                contador = 1;
            } else {
                selecao = selecao + " and e.uf = :uf";
            }
        }
        
        if (!bairro.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where e.bairro = :bairro";
                contador = 1;
            } else {
                selecao = selecao + " and e.bairro = :bairro";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoAluno != 0) {
            query.setParameter("codigoaluno", codigoAluno);
        }
        
        if (codigoCmei != 0) {
            query.setParameter("codigocmei", codigoCmei);
        }
        
        if (codigoEscola != 0) {
            query.setParameter("codigoescola", codigoEscola);
        }
        
        if (codigoOutro != 0) {
            query.setParameter("codigooutro", codigoOutro);
        }
        
        if (!tipoEndereco.isEmpty()) {
            query.setParameter("tipoendereco", tipoEndereco);
        }
        
        if (!endereco.isEmpty()) {
            query.setParameter("endereco", endereco);
        }
        
        if (!numero.isEmpty()) {
            query.setParameter("numeroendereco", numero);
        }
        
        if (!cep.isEmpty()) {
            query.setParameter("cep", cep);
        }
        
        if (!cidade.isEmpty()) {
            query.setParameter("cidade", cidade);
        }
        
        if (!uf.isEmpty()) {
            query.setParameter("uf", uf);
        }
        
        if (!bairro.isEmpty()) {
            query.setParameter("bairro", bairro);
        }
        
        this.endereco = (Endereco) query.uniqueResult();
        
        encerraSessao();

        if (this.endereco == null) {
            return "";
        } else {
            return this.endereco.getEndereco();
        }
        
    }
    
    public Object verificarCadastroLinha(int numeroLinha) {
        
        iniciaLinha();
         
        String selecao = "select l from Linha l";
        int contador = 0;
     
        if (numeroLinha != 0) {
            if (contador == 0) {
                selecao = selecao + " where l.numeroLinha = :numerolinha";
                contador = 1;
            } else {
                selecao = selecao + " and l.numeroLinha = :numerolinha";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (numeroLinha != 0) {
            query.setParameter("numerolinha", numeroLinha);
        }
        
        linha = (Linha) query.uniqueResult();
        
        if (linha == null) {
            return null;
        } else {
            return linha;
        }
        
    }
    
    public Object verificarCadastroLote(String nomeLote, String numeroLote) {
        
        iniciaLote();
         
        String selecao = "select l from Lote l";
        int contador = 0;
     
        if (!nomeLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where l.nomeLote = :nomelote";
                contador = 1;
            } else {
                selecao = selecao + " and l.nomeLote = :nomelote";
            }
        }
        
        if (!numeroLote.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where l.numeroLote = :numerolote";
                contador = 1;
            } else {
                selecao = selecao + " and l.numeroLote = :numerolote";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!nomeLote.isEmpty()) {
            query.setParameter("nomelote", nomeLote);
        }
        
        if (!numeroLote.isEmpty()) {
            query.setParameter("numerolote", numeroLote);
        }
        
        lote = (Lote) query.uniqueResult();
        
        if (lote == null) {
            return null;
        } else {
            return lote;
        }
        
    }
    
    public String verificarCodigoBarras(String codigoBarras) {

        iniciaCartucho();
        
        String selecao = "select c from Cartucho c";
        int contador = 0;

        if (!codigoBarras.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where c.codigoBarra = :codigobarras";
                contador = 1;
            } else {
                selecao = selecao + " and c.codigoBarra = :codigobarras";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!codigoBarras.isEmpty()) {
            query.setParameter("codigobarras", codigoBarras);
        }
        
        cartucho = (Cartucho) query.uniqueResult();
        
        encerraSessao();

        if (cartucho == null) {
            return "";
        } else {
            return cartucho.getCodigoBarra();
        }
        
    }
    
    public List verificarDisponibilidadeEquipamento(Date dataEmprestimo) {
        
        iniciaAgendamentoEquipamento();
        
        List lista = new ArrayList();
        String selecao = "SELECT aei FROM AgendamentoEquipamentoItens aei";
        int contador = 0;
        
        /*if (codigoAgendamentoEquipamento != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE aei.agendamentoEquipamento.codigoAgendamenotEquipamento = :codigoagendamentoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " AND aei.agendamentoEquipamento.codigoAgendamenotEquipamento = :codigoagendamentoequipamento";
            }
        }*/
        
        if (dataEmprestimo != null) {
            if (contador == 0) {
                selecao = selecao + " WHERE aei.agendamentoEquipamento.dataEmprestimo < :dataemprestimo and aei.agendamentoEquipamento.dataDevolucao > :datadevolucao";
                contador = 1;
            } else {
                selecao = selecao + " AND aei.agendamentoEquipamento.dataEmprestimo < :dataemprestimo and aei.agendamentoEquipamento.dataDevolucao > :datadevolucao";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        /*if (!patrimonio.isEmpty()) {
            query.setParameter("patrimonio", patrimonio);
            query.setParameter("status1", "AGENDADO");
            query.setParameter("status2", "EMPRESTADO");
        }*/
        
        if (dataEmprestimo != null) {
            query.setParameter("dataemprestimo", new java.sql.Date(dataEmprestimo.getTime()));
            query.setParameter("datadevolucao", new java.sql.Date(dataEmprestimo.getTime()));
        }

        lista = query.list();
        
        //encerraSessao();

        return lista;
        
    }
    
    public String verificarDisponibilidadeEquipamento2(Date dataEmprestimo, Date dataDevolucao, String patrimonio) {

        iniciaAgendamentoEquipamento();
        
        String selecao = "select ae from AgendamentoEquipamento ae";
        int contador = 0;
        
        if (!patrimonio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where ae.equipamento2 = :patrimonio and status = :status1 or status = :status2";
                contador = 1;
            } else {
                selecao = selecao + " and ae.equipamento2 = :patrimonio and status = :status1 or status = :status2";
            }
        }
        
        if (dataEmprestimo != null) {
            if (contador == 0) {
                selecao = selecao + " where ae.dataEmprestimo between :dataemprestimo and :datadevolucao";
                contador = 1;
            } else {
                selecao = selecao + " and ae.dataEmprestimo between :dataemprestimo and :datadevolucao";
            }
        }
        
        if (dataDevolucao != null) {
            if (contador == 0) {
                selecao = selecao + " where ae.dataDevolucao between :dataemprestimo and :datadevolucao";
                contador = 1;
            } else {
                selecao = selecao + " and ae.dataDevolucao between :dataemprestimo and :datadevolucao";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!patrimonio.isEmpty()) {
            query.setParameter("patrimonio", patrimonio);
            query.setParameter("status1", "AGENDADO");
            query.setParameter("status2", "EMPRESTADO");
        }
        
        if (dataEmprestimo != null) {
            query.setParameter("dataemprestimo", new java.sql.Date(dataEmprestimo.getTime()));
            query.setParameter("datadevolucao", new java.sql.Date(dataDevolucao.getTime()));
        }
        
        if (dataDevolucao != null) {
            query.setParameter("dataemprestimo", new java.sql.Date(dataEmprestimo.getTime()));
            query.setParameter("datadevolucao", new java.sql.Date(dataDevolucao.getTime()));
        }
        
        agendamentoEquipamento = (AgendamentoEquipamento) query.uniqueResult();
        
        encerraSessao();

        return agendamentoEquipamento.getStatus();
        
    }

    public String verificarEdital(String modeloEdital, int numeroEdital, String tipoEdital, String ano) {

        iniciaEdital();
        
        String selecao = "SELECT e FROM Edital e";
        int contador = 0;

        if (!modeloEdital.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.modeloEdital = :modeloedital";
                contador = 1;
            } else {
                selecao = selecao + " AND e.modeloEdital = :modeloedital";
            }
        }
        
        if (numeroEdital != 0) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.numero = :numeroedital";
                contador = 1;
            } else {
                selecao = selecao + " AND e.numero = :numeroedital";
            }
        }
        
        if (!tipoEdital.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.tipoEdital = :tipoedital";
                contador = 1;
            } else {
                selecao = selecao + " AND e.tipoEdital = :tipoedital";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " WHERE e.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " AND e.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!modeloEdital.isEmpty()) {
            query.setParameter("modeloedital", modeloEdital);
        }
        
        if (numeroEdital != 0) {
            query.setParameter("numeroedital", numeroEdital);
        }
        
        if (!tipoEdital.isEmpty()) {
            query.setParameter("tipoedital", tipoEdital);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        edital = (Edital) query.uniqueResult();
        
        encerraSessao();

        if (edital == null) {
            return "";
        } else {
            return edital.getNumero() + "";
        }
        
    }
    
    public String verificarEntregaRemanufaturados(String numeroEntregaRemanufaturado, String ano) {
        
        iniciaSolicitacaoRecarga();
        
        String selecao = "select er from EntregaRemanufaturados er";
        int contador = 0;

        if (!numeroEntregaRemanufaturado.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where er.numeroEntregaRemanufaturados = :numeroentregaremanufaturados";
                contador = 1;
            } else {
                selecao = selecao + " and er.numeroEntregaRemanufaturados = :numeroentregaremanufaturados";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where er.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and er.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!numeroEntregaRemanufaturado.isEmpty()) {
            query.setParameter("numeroentregaremanufaturados", numeroEntregaRemanufaturado);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        solicitacaoRecarga = (SolicitacaoRecarga) query.uniqueResult();
        
        encerraSessao();

        return solicitacaoRecarga.getNumeroSolicitacao() + "";
        
    }
    
    public Object verificarEntregaRemanufaturadosItens(int codigoEntregaRemanufaturados, int codigoCartucho) {
        
        iniciaEntregaRemanufaturadosItens();
        
        String selecao = "select eri from EntregaRemanufaturadosItens eri";
        int contador = 0;

        if (codigoEntregaRemanufaturados != 0) {
            if (contador == 0) {
                selecao = selecao + " where eri.entregaRemanufaturados.codigoEntregaRemanufaturados = :codigoentregaremanufaturados";
                contador = 1;
            } else {
                selecao = selecao + " and eri.entregaRemanufaturados.codigoEntregaRemanufaturados = :codigoentregaremanufaturados";
            }
        }
        
        if (codigoCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " where eri.cartucho.codigoCartucho = :codigocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and eri.cartucho.codigoCartucho = :codigocartucho";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoEntregaRemanufaturados != 0) {
            query.setParameter("codigoentregaremanufaturados", codigoEntregaRemanufaturados);
        }
        
        if (codigoCartucho != 0) {
            query.setParameter("codigocartucho", codigoCartucho);
        }
        
        entregaRemanufaturadosItens = (EntregaRemanufaturadosItens) query.uniqueResult();
        
        encerraSessao();

        return entregaRemanufaturadosItens;
        
    }
    
    public String verificarInstrucaoNormativa(String modeloInstrucao, int numeroInstrucao, String tipoInstrucao, String ano) {

        iniciaInstrucaoNormativa();
        
        String selecao = "select inst from InstrucaoNormativa inst";
        int contador = 0;
        
        if (!modeloInstrucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where inst.modeloInstrucao = :modeloinstrucao";
                contador = 1;
            } else {
                selecao = selecao + " and inst.modeloInstrucao = :modeloinstrucao";
            }
        }
        
        if (numeroInstrucao != 0) {
            if (contador == 0) {
                selecao = selecao + " where inst.numero = :numero";
                contador = 1;
            } else {
                selecao = selecao + " and inst.numero = :numero";
            }
        }
        
        if (!tipoInstrucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where inst.tipoInstrucao = :tipoinstrucao";
                contador = 1;
            } else {
                selecao = selecao + " and inst.tipoInstrucao = :tipoinstrucao";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where inst.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and inst.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!modeloInstrucao.isEmpty()) {
            query.setParameter("modeloinstrucao", modeloInstrucao);
        }
        
        if (numeroInstrucao != 0) {
            query.setParameter("numero", numeroInstrucao);
        }
        
        if (!tipoInstrucao.isEmpty()) {
            query.setParameter("tipoinstrucao", tipoInstrucao);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        instrucaoNormativa = (InstrucaoNormativa) query.uniqueResult();
        
        encerraSessao();

        if (instrucaoNormativa == null) {
            return "";
        } else {
            return instrucaoNormativa.getNumero() + "";
        }

    }
    
    public String verificarModeloCartuchoExistente(String nomeModeloCartucho) {
        
        iniciaModeloCartucho();
        
        String selecao = "select mc from ModeloCartucho mc";
        int contador = 0;
        
        if (!nomeModeloCartucho.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where mc.nomeModeloCartucho = :nomemodelocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and mc.nomeModeloCartucho = :nomemodelocartucho";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!nomeModeloCartucho.isEmpty()) {
            query.setParameter("nomemodelocartucho", nomeModeloCartucho);
        }
        
        modeloCartucho = (ModeloCartucho) query.uniqueResult();
        
        encerraSessao();

        if (modeloCartucho == null) {
            return "";
        } else {
            return modeloCartucho.getNomeModeloCartucho();
        }
        
    }
    
    public String verificarNomeUsuario(String usuarioVerificado) {

        iniciaUsuario();
        
        String selecao = "select u from Usuario u";
        int contador = 0;
        
        if (!usuarioVerificado.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where u.nomeUsuario = :nomeusuario";
                contador = 1;
            } else {
                selecao = selecao + " and u.nomeUsuario = :nomeusuario";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!usuarioVerificado.isEmpty()) {
            query.setParameter("nomeusuario", usuarioVerificado);
        }

        usuario = (Usuario) query.uniqueResult();

        encerraSessao();

        if (usuario == null) {
            return "";
        } else {
            return usuario.getNomeUsuario();
        }
        
    }

    public String verificarOficio(String modeloOficio, int numeroOficio, String tipoOficio, String ano) {

        iniciaOficio();
        
        String selecao = "select o from Oficio o";
        int contador = 0;
        
        if (!modeloOficio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.modeloOficio = :modelooficio";
                contador = 1;
            } else {
                selecao = selecao + " and o.modeloOficio = :modelooficio";
            }
        }
        
        if (numeroOficio != 0) {
            if (contador == 0) {
                selecao = selecao + " where o.numero = :numerooficio";
                contador = 1;
            } else {
                selecao = selecao + " and o.numero = :numerooficio";
            }
        }
        
        if (!tipoOficio.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.tipoOficio = :tipooficio";
                contador = 1;
            } else {
                selecao = selecao + " and o.tipoOficio = :tipooficio";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where o.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and o.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!modeloOficio.isEmpty()) {
            query.setParameter("modelooficio", modeloOficio);
        }
        
        if (numeroOficio != 0) {
            query.setParameter("numerooficio", numeroOficio);
        }
        
        if (!tipoOficio.isEmpty()) {
            query.setParameter("tipooficio", tipoOficio);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        oficio = (Oficio) query.uniqueResult();
        
        encerraSessao();

        if (oficio == null) {
            return "";
        } else {
            return oficio.getNumero() + "";
        }

    }

    public String verificarPortaria(String modeloPortaria, int numeroPortaria, String tipoPortaria, String ano) {

        iniciaPortaria();
        
        String selecao = "select p from Portaria p";
        int contador = 0;
        
        if (!modeloPortaria.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.modeloPortaria = :modeloportaria";
                contador = 1;
            } else {
                selecao = selecao + " and p.modeloPortaria = :modeloportaria";
            }
        }
        
        if (numeroPortaria != 0) {
            if (contador == 0) {
                selecao = selecao + " where p.numero = :numeroportaria";
                contador = 1;
            } else {
                selecao = selecao + " and p.numero = :numeroportaria";
            }
        }
        
        if (!tipoPortaria.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.tipoPortaria = :tipoportaria";
                contador = 1;
            } else {
                selecao = selecao + " and p.tipoPortaria = :tipoportaria";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where p.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and p.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!modeloPortaria.isEmpty()) {
            query.setParameter("modeloportaria", modeloPortaria);
        }
        
        if (numeroPortaria != 0) {
            query.setParameter("numeroportaria", numeroPortaria);
        }
        
        if (!tipoPortaria.isEmpty()) {
            query.setParameter("tipoportaria", tipoPortaria);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        portaria = (Portaria) query.uniqueResult();
        
        encerraSessao();

        if (portaria == null) {
            return "";
        } else {
            return portaria.getNumero() + "";
        }

    }

    public String verificarResolucao(String modeloResolucao, int numeroResolucao, String tipoResolucao, String ano) {

        iniciaResolucao();
        
        String selecao = "select r from Resolucao r";
        int contador = 0;
        
        if (!modeloResolucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where r.modeloResolucao = :modeloresolucao";
                contador = 1;
            } else {
                selecao = selecao + " and r.modeloResolucao = :modeloresolucao";
            }
        }
        
        if (numeroResolucao != 0) {
            if (contador == 0) {
                selecao = selecao + " where r.numero = :numeroresolucao";
                contador = 1;
            } else {
                selecao = selecao + " and r.numero = :numeroresolucao";
            }
        }
        
        if (!tipoResolucao.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where r.tipoResolucao = :tiporesolucao";
                contador = 1;
            } else {
                selecao = selecao + " and r.tipoResolucao = :tiporesolucao";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where r.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and r.ano = :ano";
            }
        }

        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!modeloResolucao.isEmpty()) {
            query.setParameter("modeloresolucao", modeloResolucao);
        }
        
        if (numeroResolucao != 0) {
            query.setParameter("numeroresolucao", numeroResolucao);
        }
        
        if (!tipoResolucao.isEmpty()) {
            query.setParameter("tiporesolucao", tipoResolucao);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        resolucao = (Resolucao) query.uniqueResult();
        
        encerraSessao();

        if (resolucao == null) {
            return "";
        } else {
            return resolucao.getNumero() + "";
        }

    }
    
    public String verificarSolicitacaoRecarga(String numeroSolicitacaoRecarga, String ano) {
        
        iniciaSolicitacaoRecarga();
        
        String selecao = "select sr from SolicitacaoRecarga sr";
        int contador = 0;

        if (!numeroSolicitacaoRecarga.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.numeroSolicitacao = :numerosolicitacaorecarga";
                contador = 1;
            } else {
                selecao = selecao + " and sr.numeroSolicitacao = :numerosolicitacaorecarga";
            }
        }
        
        if (!ano.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where sr.ano = :ano";
                contador = 1;
            } else {
                selecao = selecao + " and sr.ano = :ano";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!numeroSolicitacaoRecarga.isEmpty()) {
            query.setParameter("numerosolicitacaorecarga", numeroSolicitacaoRecarga);
        }
        
        if (!ano.isEmpty()) {
            query.setParameter("ano", ano);
        }
        
        solicitacaoRecarga = (SolicitacaoRecarga) query.uniqueResult();
        
        encerraSessao();

        return solicitacaoRecarga.getNumeroSolicitacao() + "";
        
    }
    
    public Object verificarSolicitacaoRemanufaturaItens(int codigoSolicitacaoRemanufatura, int codigoCartucho) {
        
        iniciaSolicitacaoRemanufaturaItens();
        
        String selecao = "select sri from SolicitacaoRemanufaturaItens sri";
        int contador = 0;

        if (codigoSolicitacaoRemanufatura != 0) {
            if (contador == 0) {
                selecao = selecao + " where sri.solicitacaoRemanufatura.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
                contador = 1;
            } else {
                selecao = selecao + " and sri.solicitacaoRemanufatura.codigoSolicitacaoRemanufatura = :codigosolicitacaoremanufatura";
            }
        }
        
        if (codigoCartucho != 0) {
            if (contador == 0) {
                selecao = selecao + " where sri.cartucho.codigoCartucho = :codigocartucho";
                contador = 1;
            } else {
                selecao = selecao + " and sri.cartucho.codigoCartucho = :codigocartucho";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (codigoSolicitacaoRemanufatura != 0) {
            query.setParameter("codigosolicitacaoremanufatura", codigoSolicitacaoRemanufatura);
        }
        
        if (codigoCartucho != 0) {
            query.setParameter("codigocartucho", codigoCartucho);
        }
        
        solicitacaoRemanufaturaItens = (SolicitacaoRemanufaturaItens) query.uniqueResult();
        
        encerraSessao();

        return solicitacaoRemanufaturaItens;
        
    }
    
    public String verificarTipoEquipamentoExistente(String nomeTipoEquipamento) {
        
        iniciaTipoEquipamento();
        
        String selecao = "select te from TipoEquipamento te";
        int contador = 0;

        if (!nomeTipoEquipamento.isEmpty()) {
            if (contador == 0) {
                selecao = selecao + " where te.nomeTipoEquipamento = :nometipoequipamento";
                contador = 1;
            } else {
                selecao = selecao + " and te.nomeTipoEquipamento = :nometipoequipamento";
            }
        }
        
        iniciaSessao();
        org.hibernate.Query query = session.createQuery(selecao);
        
        if (!nomeTipoEquipamento.isEmpty()) {
            query.setParameter("nometipoequipamento", nomeTipoEquipamento);
        }
        
        tipoEquipamento = (TipoEquipamento) query.uniqueResult();
        
        encerraSessao();

        if (tipoEquipamento == null) {
            return "";
        } else {
            return tipoEquipamento.getNomeTipoEquipamento();
        }
        
    }
    
//Gerenciadores========================================================================================================================================
    public void iniciaAgendamento() {
        if (agendamento == null) {
            agendamento = new Agendamento();
        }
    }
    
    public void iniciaAgendamentoEquipamento() {
        if (agendamentoEquipamento == null) {
            agendamentoEquipamento = new AgendamentoEquipamento();
        }
    }
    
    public void iniciaAgendamentoEquipamentoItens() {
        if (agendamentoEquipamentoItens == null) {
            agendamentoEquipamentoItens = new AgendamentoEquipamentoItens();
        }
    }
    
    public void iniciaAgendamentoOficio() {
        if (agendamentoOficio == null) {
            agendamentoOficio = new AgendamentoOficio();
        }
    }
    
    public void iniciaAluno() {
        if (aluno == null) {
            aluno = new Aluno();
        }
    }
    
    public void iniciaAta() {
        if (ata == null) {
            ata = new Ata();
        }
    }
    
    public void iniciaBloco() {
        if (bloco == null) {
            bloco = new Bloco();
        }
    }
    
    public void iniciaCartucho() {
        if (cartucho == null) {
            cartucho = new Cartucho();
        }
    }
    
    public void iniciaCmei() {
        if (cmei == null) {
            cmei = new Cmei();
        }
    }
    
    public void iniciaContraSenha() {
        if (contraSenha == null) {
            contraSenha = new ContraSenha();
        }
    }
    
    public void iniciaCrachas() {
        if (crachas == null) {
            crachas = new Crachas();
        }
    }
    
    public void iniciaDepartamentoDivisaoSetor() {
        if (departamentoDivisaoSetor == null) {
            departamentoDivisaoSetor = new DepartamentoDivisaoSetor();
        }
    }
    
    public void iniciaEdital() {
        if (edital == null) {
            edital = new Edital();
        }
    }
    
    public void iniciaEndereco() {
        if (endereco == null) {
            endereco = new Endereco();
        }
    }
    
    public void iniciaEntregaRemanufaturados() {
        if (entregaRemanufaturados == null) {
            entregaRemanufaturados = new EntregaRemanufaturados();
        }
    }
 
    public void iniciaEntregaRemanufaturadosItens() {
        if (entregaRemanufaturadosItens == null) {
            entregaRemanufaturadosItens = new EntregaRemanufaturadosItens();
        }
    }
    
    public void iniciaEquipamento() {
        if (equipamento == null) {
            equipamento = new Equipamento();
        }
    }
    
    public void iniciaEquipamentoEntidades() {
        if (equipamentoEntidades == null) {
            equipamentoEntidades = new EquipamentoEntidades();
        }
    }
    
    public void iniciaEscola() {
        if (escola == null) {
            escola = new Escola();
        }
    }

    public void iniciaInstrucaoNormativa() {
        if (instrucaoNormativa == null) {
            instrucaoNormativa = new InstrucaoNormativa();
        }
    }
    
    public void iniciaJustificativa() {
        if (justificativa == null) {
            justificativa = new Justificativa();
        }
    }
    
    public void iniciaLinha() {
        if (linha == null) {
            linha = new Linha();
        }
    }
    
    public void iniciaLog2() {
        if (log2 == null) {
            log2 = new Log2();
        }
    }

    public void iniciaLote() {
        if (lote == null) {
            lote = new Lote();
        }
    }
    
    public void iniciaModeloCartucho() {
        if (modeloCartucho == null) {
            modeloCartucho = new ModeloCartucho();
        }
    }
    
    public void iniciaOficio() {
        if (oficio == null) {
            oficio = new Oficio();
        }
    }
    
    public void iniciaOutro() {
        if (outro == null) {
            outro = new Outro();
        }
    }
    
    public void iniciaPermissoes() {
        if (permissoes == null) {
            permissoes = new Permissoes();
        }
    }
    
    public void iniciaPontoDigital() {
        if (pontoDigital == null) {
            pontoDigital = new PontoDigital();
        }
    }
    
    public void iniciaPortaria() {
        if (portaria == null) {
            portaria = new Portaria();
        }
    }
    
    public void iniciaRecarga() {
        if (recarga == null) {
            recarga = new Recarga();
        }
    }
    
    public void iniciaResolucao() {
        if (resolucao == null) {
            resolucao = new Resolucao();
        }
    }
    
    public void encerraSessao() {
        session.close();
    }
    
    public void iniciaSessao() {
        session = factory.openSession();
    }
    
    public void iniciaSolicitacaoRecarga() {
        if (solicitacaoRecarga == null) {
            solicitacaoRecarga = new SolicitacaoRecarga();
        }
    }
    
    public void iniciaSolicitacaoRemanufatura() {
        if (solicitacaoRemanufatura == null) {
            solicitacaoRemanufatura = new SolicitacaoRemanufatura();
        }
    }
    
    public void iniciaSolicitacaoRemanufaturaItens() {
        if (solicitacaoRemanufaturaItens == null) {
            solicitacaoRemanufaturaItens = new SolicitacaoRemanufaturaItens();
        }
    }
    
    public void iniciaTipoEquipamento() {
        if (tipoEquipamento == null) {
            tipoEquipamento = new TipoEquipamento();
        }
    }
    
    public void iniciaUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
    }
    
    public void iniciaVersaoAtual() {
        if (versaoAtual == null) {
            versaoAtual = new VersaoAtual();
        }
    }
    
    public void iniciaVersaoUsuario() {
        if (versaoUsuario == null) {
            versaoUsuario = new VersaoUsuario();
        }
    }
    
}