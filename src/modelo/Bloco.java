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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "bloco", schema = "public")
public class Bloco {
    
    private int codigoBloco;
    private double totalKm;
    private String nomeBloco;
    private String numeroBloco;
    private Lote lote;
    
    public Bloco() {
        
    }
    
    public Bloco(int codigoBloco, double totalKm, String nomeBloco, String numeroBloco, Lote lote) {
        
        this.codigoBloco = codigoBloco;
        this.lote = lote;
        this.nomeBloco = nomeBloco;
        this.numeroBloco = numeroBloco;
        this.totalKm = totalKm;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_BLOCO", sequenceName = "bloco_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_BLOCO")
    @Column(name = "codigobloco", unique = true, nullable = false)
    public int getCodigoBloco() {
        return codigoBloco;
    }

    public void setCodigoBloco(int codigoBloco) {
        this.codigoBloco = codigoBloco;
    }

    @Column(name = "totalkm")
    public double getTotalKm() {
        return totalKm;
    }

    public void setTotalKm(double totalKm) {
        this.totalKm = totalKm;
    }

    @Column(name = "nomebloco", nullable = false, length = 240)
    public String getNomeBloco() {
        return nomeBloco;
    }

    public void setNomeBloco(String nomeBloco) {
        this.nomeBloco = nomeBloco;
    }

    @Column(name = "numerobloco", nullable = false, length = 10)
    public String getNumeroBloco() {
        return numeroBloco;
    }

    public void setNumeroBloco(String numeroBloco) {
        this.numeroBloco = numeroBloco;
    }

    @OneToOne
    @JoinColumn(name = "lote_codigolote", insertable = true, updatable = true)
    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
}
