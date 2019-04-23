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
@Table(name = "edital", schema = "public")
public class Edital implements java.io.Serializable {
    
    private int codigoEdital;
    private int numero;
    private String ano;//4
    private String tipoEdital;//20
    private String modeloEdital;//20
    private String departamentoDestinatario; //120
    private String destinatarioEdital; //120
    private String assuntoEdital; //240
    private Date dataSolicitacao;
    private Usuario usuario;

    public Edital() {
        
    }
    
    public Edital(int codigoEdital, int numero, String ano, String tipoEdital, String modeloEdital, String departamentoDestinatario, String destinatarioEdital, 
            String assuntoEdital, Date dataSolicitacao, Usuario usuario) {
        
        this.codigoEdital = codigoEdital;
        this.ano = ano;
        this.assuntoEdital = assuntoEdital;
        this.dataSolicitacao = dataSolicitacao;
        this.departamentoDestinatario = departamentoDestinatario;
        this.destinatarioEdital = destinatarioEdital;
        this.modeloEdital = modeloEdital;
        this.usuario = usuario;
        this.numero = numero;
        this.tipoEdital = tipoEdital;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_EDITAL", sequenceName = "edital_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EDITAL")
    @Column(name = "codigoedital", unique = true, nullable = false)
    public int getCodigoEdital() {
        return codigoEdital;
    }

    public void setCodigoEdital(int codigoEdital) {
        this.codigoEdital = codigoEdital;
    }
    
    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "assuntoedital", nullable = true, length = 240)
    public String getAssuntoEdital() {
        return assuntoEdital;
    }

    public void setAssuntoEdital(String assuntoEdital) {
        this.assuntoEdital = assuntoEdital;
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

    @Column(name = "destinatarioedital", nullable = true, length = 120)
    public String getDestinatarioEdital() {
        return destinatarioEdital;
    }

    public void setDestinatarioEdital(String destinatarioEdital) {
        this.destinatarioEdital = destinatarioEdital;
    }

    @Column(name = "modeloedital", nullable = false, length = 20)
    public String getModeloEdital() {
        return modeloEdital;
    }

    public void setModeloEdital(String modeloEdital) {
        this.modeloEdital = modeloEdital;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "tipoedital", nullable = false, length = 20)
    public String getTipoEdital() {
        return tipoEdital;
    }

    public void setTipoEdital(String tipoEdital) {
        this.tipoEdital = tipoEdital;
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
