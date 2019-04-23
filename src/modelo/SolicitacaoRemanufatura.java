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
@Table(name = "solicitacaoremanufatura", schema = "public")
public class SolicitacaoRemanufatura {
    
    private int codigoSolicitacaoRemanufatura;
    private int numeroSolicitacao;
    private String ano;
    private String emissorSecretaria;
    private String receptorEmpresa;
    private Date dataEnvio;
    private Boolean solicitacaoEnviada;
    private List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens;
    private Usuario usuario;
    
    public SolicitacaoRemanufatura() {
        
    }
    
    public SolicitacaoRemanufatura(int codigoSolicitacaoRemanufatura, int numeroSolicitacao, String ano, String emissorSecretaria, String receptorEmpresa, Date dataEnvio, 
            List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens, Usuario usuario) {
        
        this.ano = ano;
        this.codigoSolicitacaoRemanufatura = codigoSolicitacaoRemanufatura;
        this.dataEnvio = dataEnvio;
        this.emissorSecretaria = emissorSecretaria;
        this.listaSolicitacaoRemanufaturaItens = listaSolicitacaoRemanufaturaItens;
        this.numeroSolicitacao = numeroSolicitacao;
        this.receptorEmpresa = receptorEmpresa;
        this.usuario = usuario;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_SOLICITACAOREMANUFATURA", sequenceName = "solicitacaoremanufatura_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SOLICITACAOREMANUFATURA")
    @Column(name = "codigosolicitacaoremanufatura", unique = true, nullable = false)
    public int getCodigoSolicitacaoRemanufatura() {
        return codigoSolicitacaoRemanufatura;
    }

    public void setCodigoSolicitacaoRemanufatura(int codigoSolicitacaoRemanufatura) {
        this.codigoSolicitacaoRemanufatura = codigoSolicitacaoRemanufatura;
    }

    @Column(name = "numerosolicitacao", nullable = false)
    public int getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(int numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "emissorsecretaria", nullable = false, length = 240)
    public String getEmissorSecretaria() {
        return emissorSecretaria;
    }

    public void setEmissorSecretaria(String emissorSecretaria) {
        this.emissorSecretaria = emissorSecretaria;
    }

    @Column(name = "receptorempresa", nullable = false, length = 240)
    public String getReceptorEmpresa() {
        return receptorEmpresa;
    }

    public void setReceptorEmpresa(String receptorEmpresa) {
        this.receptorEmpresa = receptorEmpresa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataenvio", length = 13)
    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    @Column(name = "solicitacaoenviada", nullable = false)
    public Boolean isSolicitacaoEnviada() {
        return solicitacaoEnviada;
    }

    public void setSolicitacaoEnviada(Boolean solicitacaoEnviada) {
        this.solicitacaoEnviada = solicitacaoEnviada;
    }

    @OneToMany(mappedBy = "solicitacaoRemanufatura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<SolicitacaoRemanufaturaItens> getListaSolicitacaoRemanufaturaItens() {
        return listaSolicitacaoRemanufaturaItens;
    }

    public void setListaSolicitacaoRemanufaturaItens(List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens) {
        this.listaSolicitacaoRemanufaturaItens = listaSolicitacaoRemanufaturaItens;
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
