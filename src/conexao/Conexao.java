/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import excecoes.ExcCadastro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Luiz
 */
public class Conexao {

    private static Connection con;

    /** Creates a new instance of Conexao */
    public Conexao() {
    }

    public static Connection retornaConexao(){

        String driver = "org.postgresql.Driver";
        //String url = "jdbc:postgresql://localhost:5432/semedinfoedu";
        String url = "jdbc:postgresql://semed-infosrv01:5432/semedinfoedu";
        String login = "postgres";
        String senha = "B5ld86bCsdvu718";

        try {
            if (con == null || con.isClosed()) {

                Class.forName(driver);
                con = DriverManager.getConnection(url, login, senha);
            }

        } catch (SQLException ex) {
            //ex.printStackTrace();
//            throw new ExcCadastro("Erro abrindo conexão: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
//            throw new ExcCadastro("Driver não encontrado: " + ex.getMessage());
        }
        return con;
    }
    
    public static Connection getConexao() throws ExcCadastro {

        //Banco PostgreSql
        String driver = "org.postgresql.Driver";
        //String url = "jdbc:postgresql://localhost:5432/semedinfoedu";
        String url = "jdbc:postgresql://semed-infosrv01:5432/semedinfoedu";
        String login = "postgres";
        String senha = "B5ld86bCsdvu718";

        try {
            if (con == null || con.isClosed()) {

                Class.forName(driver);
                con = DriverManager.getConnection(url, login, senha);
            }

        } catch (SQLException ex) {
            //ex.printStackTrace();
            throw new ExcCadastro("Erro abrindo conexão: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
            throw new ExcCadastro("Driver não encontrado: " + ex.getMessage());
        }
        return con;
    }
}
