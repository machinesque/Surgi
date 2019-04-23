/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import excecoes.MensagensExcessao;
import java.util.logging.Level;
import java.util.logging.Logger;
import visual.JfOficio;

/**
 *
 * @author luizam
 */
public class AtualizaNumeroOficios implements Runnable {

    private DAO dao;
    private JfOficio oficioGeral;
    private MensagensExcessao except;
    private Thread threadAtualizaNumeroOficios = new Thread(this);

    private String nomeClasse;
    private String modeloOficio = "OFICIO";
    private String tipoOficio = "GERAL";
    private String ano;
    private int numeroOficio;

//Outros Metodos ===========================================================================================================================================
    public void atualizaNumeroOficio() {

        iniciaDao();
        //DAO dao = new DAO();

        numeroOficio = dao.getNumeroOficio(modeloOficio, ano, tipoOficio);

    }

    public void iniciaThread() {

        threadAtualizaNumeroOficios.start();

    }

    public void iniciaOficioGeral() {

        if (oficioGeral == null) {
            oficioGeral = new JfOficio();
        }

    }

    public void run() {

        for (int i = 0; i == 0; i = 0) {
            try {
                atualizaNumeroOficio();
                if (nomeClasse.equals("jfOficio")) {
                    iniciaOficioGeral();
                    oficioGeral.setNumeroOficio(numeroOficio);
                }
                threadAtualizaNumeroOficios.sleep(3000);
                //this.finalize();
            } catch (Throwable ex) {
                Logger.getLogger(AtualizaNumeroOficios.class.getName()).log(Level.SEVERE, null, ex);
                except.setMensagemErro("Não foi possivel atualizar o numero de Oficio/ Oficio Circular ou CI");
            }
        }

    }

//Geradores, Validadores===========================================================================================================================================
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModeloOficio() {
        return modeloOficio;
    }

    public void setModeloOficio(String modeloOficio) {
        this.modeloOficio = modeloOficio;
    }

    public String getTipoOficio() {
        return tipoOficio;
    }

    public void setTipoOficio(String tipoOficio) {
        this.tipoOficio = tipoOficio;
    }

    public int getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(int numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

//Metodos DAO===========================================================================================================================================
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
}
