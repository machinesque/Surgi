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
@Table(name = "outro", schema = "public")
public class Outro implements java.io.Serializable {

    private int codigoOutro;
    private String nomeOutro;//120
    private String telefone;//13
    private String coordenadorAtual;//120
    private String coordenadorAnterior;//120
    private String emailOutro;//120

    public Outro() {
        
    }
    
    public Outro(int codigoOutro, String nomeOutro, String telefone, String coordenadorAtual, String coordenadorAnterior, String emailOutro) {
        
        this.codigoOutro = codigoOutro;
        this.coordenadorAnterior = coordenadorAnterior;
        this.coordenadorAtual = coordenadorAtual;
        this.emailOutro = emailOutro;
        this.nomeOutro = nomeOutro;
        this.telefone = telefone;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_OUTRO", sequenceName = "outro_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_OUTRO")
    @Column(name = "codigooutro", unique = true, nullable = false)
    public int getCodigoOutro() {
        return codigoOutro;
    }

    public void setCodigoOutro(int codigoOutro) {
        this.codigoOutro = codigoOutro;
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

    @Column(name = "nomeoutro", nullable = false, length = 120)
    public String getNomeOutro() {
        return nomeOutro;
    }

    public void setNomeOutro(String nomeOutro) {
        this.nomeOutro = nomeOutro;
    }

    @Column(name = "telefone", nullable = false, length = 13)
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "emailoutro", nullable = false, length = 120)
    public String getEmailOutro() {
        return emailOutro;
    }

    public void setEmailOutro(String emailOutro) {
        this.emailOutro = emailOutro;
    }
    
}
