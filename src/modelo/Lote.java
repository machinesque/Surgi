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
 * @author luizam
 */

@Entity
@Table(name = "lote", schema = "public")
public class Lote {
    
    private int codigoLote;
    private double kmDia;
    private String nomeLote;
    private String numeroLote;

    public Lote() {
        
    }
    
    public Lote(int codigoLote, String numeroLote, String nomeLote, double kmDia) {
        
        this.codigoLote = codigoLote;
        this.kmDia = kmDia;
        this.nomeLote = nomeLote;
        this.numeroLote = numeroLote;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_LOTE", sequenceName = "lote_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LOTE")
    @Column(name = "codigolote", unique = true, nullable = false)
    public int getCodigoLote() {
        return codigoLote;
    }

    public void setCodigoLote(int codigoLote) {
        this.codigoLote = codigoLote;
    }

    @Column(name = "numerolote", nullable = false,  length = 10)
    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    @Column(name = "nomelote", nullable = false, length = 240)
    public String getNomeLote() {
        return nomeLote;
    }

    public void setNomeLote(String nomeLote) {
        this.nomeLote = nomeLote;
    }

    @Column(name = "kmdia")
    public double getKmDia() {
        return kmDia;
    }

    public void setKmDia(double kmDia) {
        this.kmDia = kmDia;
    }
    
}
