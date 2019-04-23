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
@Table(name = "resolucao", schema = "public")
public class Resolucao implements java.io.Serializable {
    
    private int codigoResolucao;
    private int numero;
    private String ano;//4
    private String tipoResolucao;//30
    private String modeloResolucao;//30
    private String departamentoDestinatario; //120
    private String destinatarioResolucao; //120
    private String assuntoResolucao; //240
    private Date dataSolicitacao;
    private Usuario usuario;
    
    public Resolucao() {
        
    }
    
    public Resolucao(int codigoResolucao, int numero, String ano, String tipoResolucao, String modeloResolucao, String departamentoDestinatario, String destinatarioResolucao, 
            String assuntoResolucao, Date dataSolicitacao, Usuario usuario) {
        
        this.codigoResolucao = codigoResolucao;
        this.ano = ano;
        this.assuntoResolucao = assuntoResolucao;
        this.dataSolicitacao = dataSolicitacao;
        this.departamentoDestinatario = departamentoDestinatario;
        this.destinatarioResolucao = destinatarioResolucao;
        this.modeloResolucao = modeloResolucao;
        this.usuario = usuario;
        this.numero = numero;
        this.tipoResolucao = tipoResolucao;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_RESOLUCAO", sequenceName = "resolucao_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_RESOLUCAO")
    @Column(name = "codigoresolucao", unique = true, nullable = false)
    public int getCodigoResolucao() {
        return codigoResolucao;
    }

    public void setCodigoResolucao(int codigoResolucao) {
        this.codigoResolucao = codigoResolucao;
    }
    
    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "assuntoresolucao", nullable = true, length = 240)
    public String getAssuntoResolucao() {
        return assuntoResolucao;
    }

    public void setAssuntoResolucao(String assuntoResolucao) {
        this.assuntoResolucao = assuntoResolucao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datasolicitacao", nullable = false, length = 13)
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    @Column(name = "departamentodestinatario", nullable = true, length = 120)
    public String getDepartamentoDestinatario() {
        return departamentoDestinatario;
    }

    public void setDepartamentoDestinatario(String departamentoDestinatario) {
        this.departamentoDestinatario = departamentoDestinatario;
    }

    @Column(name = "destinatarioresolucao", nullable = true, length = 120)
    public String getDestinatarioResolucao() {
        return destinatarioResolucao;
    }

    public void setDestinatarioResolucao(String destinatarioResolucao) {
        this.destinatarioResolucao = destinatarioResolucao;
    }

    @Column(name = "modeloresolucao", nullable = false, length = 30)
    public String getModeloResolucao() {
        return modeloResolucao;
    }

    public void setModeloResolucao(String modeloResolucao) {
        this.modeloResolucao = modeloResolucao;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "tiporesolucao", nullable = false, length = 30)
    public String getTipoResolucao() {
        return tipoResolucao;
    }

    public void setTipoResolucao(String tipoResolucao) {
        this.tipoResolucao = tipoResolucao;
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
