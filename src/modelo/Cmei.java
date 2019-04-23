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
@Table(name = "cmei", schema = "public")
public class Cmei implements java.io.Serializable {

    private int codigoCmei;
    private int capacidadeAlunos;//10
    private String nomeCmei;//120
    private String telefone;//13
    private String coordenadorAtual;//120
    private String coordenadorAnterior;//120
    private String emailCmei;//120

    public Cmei() {
        
    }
    
    public Cmei(int codigoCmei, String nomeCmei, String telefone, String coordenadorAtual, String coordenadorAnterior, int capacidadeAlunos, String emailCmei) {
        
        this.codigoCmei = codigoCmei;
        this.capacidadeAlunos = capacidadeAlunos;
        this.coordenadorAnterior = coordenadorAnterior;
        this.coordenadorAtual = coordenadorAtual;
        this.emailCmei = emailCmei;
        this.nomeCmei = nomeCmei;
        this.telefone = telefone;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_CMEI", sequenceName = "cmei_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CMEI")
    @Column(name = "codigocmei", unique = true, nullable = false)
    public int getCodigoCmei() {
        return codigoCmei;
    }

    public void setCodigoCmei(int codigoCmei) {
        this.codigoCmei = codigoCmei;
    }
    
    @Column(name = "capacidadealunos")
    public int getCapacidadeAlunos() {
        return capacidadeAlunos;
    }

    public void setCapacidadeAlunos(int capacidadeAlunos) {
        this.capacidadeAlunos = capacidadeAlunos;
    }

    @Column(name = "coordenadoratual", nullable = false, length = 120)
    public String getCoordenadorAtual() {
        return coordenadorAtual;
    }

    public void setCoordenadorAtual(String coordenadorAtual) {
        this.coordenadorAtual = coordenadorAtual;
    }

    @Column(name = "coordenadoranterior", nullable = false, length = 120)
    public String getCoordenadorAnterior() {
        return coordenadorAnterior;
    }

    public void setCoordenadorAnterior(String coordenadorAnterior) {
        this.coordenadorAnterior = coordenadorAnterior;
    }

    @Column(name = "nomecmei", nullable = false, length = 120)
    public String getNomeCmei() {
        return nomeCmei;
    }

    public void setNomeCmei(String nomeCmei) {
        this.nomeCmei = nomeCmei;
    }

    @Column(name = "telefone", nullable = false, length = 13)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "emailcmei", nullable = false, length = 120)
    public String getEmailCmei() {
        return emailCmei;
    }

    public void setEmailCmei(String emailCmei) {
        this.emailCmei = emailCmei;
    }
    
}
