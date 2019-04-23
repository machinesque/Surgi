/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "versaoatual", schema = "public")
public class VersaoAtual implements java.io.Serializable {
    
    private int codigoVersaoAtual;
    private String numeroVersao;//10
    private Date dataVersao;

    public VersaoAtual() {
        
    }
    
    public VersaoAtual(int codigoVersaoAtual, String numeroVersao, Date dataVersao) {
        
        this.codigoVersaoAtual = codigoVersaoAtual;
        this.dataVersao = dataVersao;
        this.numeroVersao = numeroVersao;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_VERSAOATUAL", sequenceName = "versaoatual_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_VERSAOATUAL")
    @Column(name = "codigoversaoatual", unique = true, nullable = false)
    public int getCodigoVersaoAtual() {
        return codigoVersaoAtual;
    }

    public void setCodigoVersaoAtual(int codigoVersaoAtual) {
        this.codigoVersaoAtual = codigoVersaoAtual;
    }

    @Column(name = "numeroversao", nullable = false, length = 10)
    public String getNumeroVersao() {
        return numeroVersao;
    }

    public void setNumeroVersao(String numeroVersao) {
        this.numeroVersao = numeroVersao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataversao", nullable = false, length = 13)
    public Date getDataVersao() {
        return dataVersao;
    }

    public void setDataVersao(Date dataVersao) {
        this.dataVersao = dataVersao;
    }
    
}
