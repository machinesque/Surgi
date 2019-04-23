/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DAO;
import modelo.Escola;

/**
 *
 * @author luizam
 */
public class ControleEscola {

    private DAO dao;
    private Escola escola;

    public void iniciaDAO() {

        if (dao == null) {
            dao = new DAO();
        }

    }

    public void iniciaEscola() {

        if (escola == null) {
            escola = new Escola();
        }

    }

    public String getNomeEscola(int codgioEscola) {

        iniciaDAO();
        iniciaEscola();

        escola = (Escola) dao.busca(escola, codgioEscola);

        return escola.getNomeEscola();

    }

    public int getCodigoEscola(String nomeEscola) {

        iniciaDAO();
        iniciaEscola();

        escola = (Escola) dao.buscaEscola(0, nomeEscola, "");

        return escola.getCodigoEscola();

    }
}
