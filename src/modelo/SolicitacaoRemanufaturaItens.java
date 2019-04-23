/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */
@Entity
@Table(name = "solicitacaoremanufaturaitens", schema = "public")
public class SolicitacaoRemanufaturaItens {
    
    private int codigoSolicitacaoRemanufaturaItens;
    private SolicitacaoRemanufatura solicitacaoRemanufatura;
    private Cartucho cartucho;
    
    public SolicitacaoRemanufaturaItens() {
        
    }
    
    public SolicitacaoRemanufaturaItens(int codigoSolicitacaoRemanufaturaItens, SolicitacaoRemanufatura solicitacaoRemanufatura, Cartucho cartucho) {
        
        this.codigoSolicitacaoRemanufaturaItens = codigoSolicitacaoRemanufaturaItens;
        this.solicitacaoRemanufatura = solicitacaoRemanufatura;
        this.cartucho = cartucho;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_SOLICITACAOREMANUFATURATENS", sequenceName = "solicitacaoremanufaturaitens_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SOLICITACAOREMANUFATURATENS")
    @Column(name = "codigosolicitacaoremanufaturaitens", unique = true, nullable = false)
    public int getCodigoSolicitacaoRemanufaturaItens() {
        return codigoSolicitacaoRemanufaturaItens;
    }

    public void setCodigoSolicitacaoRemanufaturaItens(int codigoSolicitacaoRemanufaturaItens) {
        this.codigoSolicitacaoRemanufaturaItens = codigoSolicitacaoRemanufaturaItens;
    }

    @ManyToOne()
    @JoinColumn(name = "solicitacaoremanufatura_codigosolicitacaoremanufatura", insertable = true, updatable = false)
    public SolicitacaoRemanufatura getSolicitacaoRemanufatura() {
        return solicitacaoRemanufatura;
    }

    public void setSolicitacaoRemanufatura(SolicitacaoRemanufatura solicitacaoRemanufatura) {
        this.solicitacaoRemanufatura = solicitacaoRemanufatura;
    }

    @ManyToOne()
    @JoinColumn(name = "cartucho_codigocartucho", insertable = true, updatable = false)
    public Cartucho getCartucho() {
        return cartucho;
    }

    public void setCartucho(Cartucho cartucho) {
        this.cartucho = cartucho;
    }
 
    
    
}
