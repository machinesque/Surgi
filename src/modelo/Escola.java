/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luiz
 */

@Entity
@Table(name = "escola", schema = "public")
public class Escola implements java.io.Serializable {

    private int codigoEscola;
    private int capacidadeAlunos;
    private String nomeEscola;//120
    private String telefone;//13
    private String diretorAtual;//120
    private String diretorAnterior;//120
    private String emailEscola;//120

    public Escola() {
        
    }
    
    public Escola(int codigoEscola, int capacidadeAlunos, String nomeEscola, String telefone, String diretorAtual, String diretorAnterior, String emailEscola) {
        
        this.codigoEscola = codigoEscola;
        this.capacidadeAlunos = capacidadeAlunos;
        this.diretorAnterior = diretorAnterior;
        this.diretorAtual = diretorAtual;
        this.emailEscola = emailEscola;
        this.nomeEscola = nomeEscola;
        this.telefone = telefone;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_ESCOLA", sequenceName = "escola_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ESCOLA")
    @Column(name = "codigoescola", unique = true, nullable = false)
    public int getCodigoEscola() {
        return codigoEscola;
    }

    public void setCodigoEscola(int codigoEscola) {
        this.codigoEscola = codigoEscola;
    }
    
    @Column(name = "capacidadealunos", nullable = false)
    public int getCapacidadeAlunos() {
        return capacidadeAlunos;
    }

    public void setCapacidadeAlunos(int capacidadeAlunos) {
        this.capacidadeAlunos = capacidadeAlunos;
    }

    @Column(name = "diretoratual", nullable = false, length = 120)
    public String getDiretorAtual() {
        return diretorAtual;
    }

    public void setDiretorAtual(String diretorAtual) {
        this.diretorAtual = diretorAtual;
    }

    @Column(name = "diretoranterior", nullable = false, length = 120)
    public String getDiretorAnterior() {
        return diretorAnterior;
    }

    public void setDiretorAnterior(String diretorAnterior) {
        this.diretorAnterior = diretorAnterior;
    }

    @Column(name = "nomeescola", nullable = false, length = 120)
    public String getNomeEscola() {
        return nomeEscola;
    }

    public void setNomeEscola(String nomeEscola) {
        this.nomeEscola = nomeEscola;
    }

    @Column(name = "telefone", nullable = false, length = 13)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "emailescola", nullable = false, length = 120)
    public String getEmailEscola() {
        return emailEscola;
    }

    public void setEmailEscola(String emailEscola) {
        this.emailEscola = emailEscola;
    }

}
