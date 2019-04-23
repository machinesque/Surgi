/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luizam
 * Solicitação de Remanufatura que vai para empresa.
 */
@Entity
@Table(name = "entregaremanufaturados", schema = "public")
public class EntregaRemanufaturados {
    
    private int codigoEntregaRemanufaturados;
    private int numeroEntregaRemanufaturados;
    private String ano;
    private Date dataRetorno;
    private Boolean protocoloFinalizado;
    private List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens;
    private Usuario usuario;
    
    public EntregaRemanufaturados() {
        
    }
    
    public EntregaRemanufaturados(int codigoEntregaRemanufaturados, int numeroEntregaRemanufaturados, String ano, Date dataRetorno, boolean protocoloFinalizado,
            List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens, Usuario usuario) {
        
        this.ano = ano;
        this.codigoEntregaRemanufaturados = codigoEntregaRemanufaturados;
        this.dataRetorno = dataRetorno;
        this.listaEntregaRemanufaturadosItens = listaEntregaRemanufaturadosItens;
        this.numeroEntregaRemanufaturados = numeroEntregaRemanufaturados;
        this.usuario = usuario;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_ENTREGAREMANUFATURADOS", sequenceName = "entregaremanufaturados_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ENTREGAREMANUFATURADOS")
    @Column(name = "codigoentregaremanufaturados", unique = true, nullable = false)
    public int getCodigoEntregaRemanufaturados() {
        return codigoEntregaRemanufaturados;
    }

    public void setCodigoEntregaRemanufaturados(int codigoEntregaRemanufaturados) {
        this.codigoEntregaRemanufaturados = codigoEntregaRemanufaturados;
    }

    @Column(name = "numeroentregaremanufaturados", nullable = false)
    public int getNumeroEntregaRemanufaturados() {
        return numeroEntregaRemanufaturados;
    }

    public void setNumeroEntregaRemanufaturados(int numeroEntregaRemanufaturados) {
        this.numeroEntregaRemanufaturados = numeroEntregaRemanufaturados;
    }

    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataretorno", length = 13)
    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    @Column(name = "protocolofinalizado", nullable = false)
    public Boolean isProtocoloFinalizado() {
        return protocoloFinalizado;
    }

    public void setProtocoloFinalizado(Boolean protocoloFinalizado) {
        this.protocoloFinalizado = protocoloFinalizado;
    }

    @OneToMany(mappedBy = "entregaRemanufaturados", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<EntregaRemanufaturadosItens> getListaEntregaRemanufaturadosItens() {
        return listaEntregaRemanufaturadosItens;
    }

    public void setListaEntregaRemanufaturadosItens(List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens) {
        this.listaEntregaRemanufaturadosItens = listaEntregaRemanufaturadosItens;
    }

    @OneToOne
    @JoinColumn(name = "usuario_codigousuario", insertable = true, updatable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

}
