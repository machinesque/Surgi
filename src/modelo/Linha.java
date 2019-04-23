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
@Table(name = "linha", schema = "public")
public class Linha {
    
    private int codigoLinha;
    private int numeroLinha;
    private double km;
    private double km10;
    private String carro;
    private String itinerario;
    private Bloco bloco;
    
    public Linha() {
    
    }
    
    public Linha(int codigoLinha, int numeroLinha, double km, double km10, String carro, String itinerario, Bloco bloco) {
    
        this.bloco = bloco;
        this.carro = carro;
        this.codigoLinha = codigoLinha;
        this.itinerario = itinerario;
        this.km = km;
        this.km10 = km10;
        this.numeroLinha = numeroLinha;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_LINHA", sequenceName = "linha_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LINHA")
    @Column(name = "codigolinha", unique = true, nullable = false)
    public int getCodigoLinha() {
        return codigoLinha;
    }

    public void setCodigoLinha(int codigoLinha) {
        this.codigoLinha = codigoLinha;
    }

    @Column(name = "numerolinha", nullable = false)
    public int getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(int numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    @Column(name = "km")
    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    @Column(name = "km10")
    public double getKm10() {
        return km10;
    }

    public void setKm10(double km10) {
        this.km10 = km10;
    }

    @Column(name = "carro", nullable = false, length = 240)
    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    @Column(name = "itinerario", nullable = false, length = 1000)
    public String getItinerario() {
        return itinerario;
    }

    public void setItinerario(String itinerario) {
        this.itinerario = itinerario;
    }

    @OneToOne
    @JoinColumn(name = "bloco_codigobloco", insertable = true, updatable = true)
    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }
    
}
