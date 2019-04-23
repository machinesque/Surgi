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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "recargacartucho", schema = "public")
public class Recarga implements java.io.Serializable {

    private int codigoRecarga;
    private int numeroRecargas;
    private String tipoEntidade;//10
    private String observacao;//200
    private String horaEntrega;
    private Date dataEntrega;
    private Date dataRecarga;
    private Date dataDevolucao;
    private boolean cartuchoQueimado;
    private Cartucho cartucho;

    public Recarga() {
        
    }
    
    public Recarga(int codigoRecarga, int numeroRecargas, String tipoEntidade, String observacao, String horaEntrega, Date dataEntrega, Date dataRecarga, Date dataDevolucao, 
            boolean cartuchoQueimado, Cartucho cartucho) {
        
        this.codigoRecarga = codigoRecarga;
        this.cartucho = cartucho;
        this.cartuchoQueimado = cartuchoQueimado;
        this.dataDevolucao = dataDevolucao;
        this.dataEntrega = dataEntrega;
        this.dataRecarga = dataRecarga;
        this.horaEntrega = horaEntrega;
        this.numeroRecargas = numeroRecargas;
        this.observacao = observacao;
        this.tipoEntidade = tipoEntidade;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_RECARGA", sequenceName = "recarga_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_RECARGA")
    @Column(name = "codigorecarga", unique = true, nullable = false)
    public int getCodigoRecarga() {
        return codigoRecarga;
    }

    public void setCodigoRecarga(int codigoRecarga) {
        this.codigoRecarga = codigoRecarga;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "datadevolucao", nullable = true, length = 13)
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataentrega", nullable = false, length = 13)
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Column(name = "numerorecargas", nullable = false)
    public int getNumeroRecargas() {
        return numeroRecargas;
    }

    public void setNumeroRecargas(int numeroRecargas) {
        this.numeroRecargas = numeroRecargas;
    }

    @Column(name = "tipoentidade", nullable = false, length = 10)
    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Column(name = "observacao", nullable = true, length = 200)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datarecarga", nullable = true, length = 13)
    public Date getDataRecarga() {
        return dataRecarga;
    }

    public void setDataRecarga(Date dataRecarga) {
        this.dataRecarga = dataRecarga;
    }

    @Column(name = "cartuchoqueimado", nullable = false)
    public boolean isCartuchoQueimado() {
        return cartuchoQueimado;
    }

    public void setCartuchoQueimado(boolean cartuchoQueimado) {
        this.cartuchoQueimado = cartuchoQueimado;
    }

    @Column(name = "horaentrega", nullable = false, length = 5)
    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    @OneToOne
    @JoinColumn(name = "cartucho_codigocartucho", insertable = true, updatable = false)
    public Cartucho getCartucho() {
        return cartucho;
    }

    public void setCartucho(Cartucho cartucho) {
        this.cartucho = cartucho;
    }

}
