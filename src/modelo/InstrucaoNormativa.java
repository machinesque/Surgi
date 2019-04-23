/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "instrucaonormativa", schema = "public")
public class InstrucaoNormativa {
    
    private int codigoInstrucao;
    private int numero;
    private String ano;//4
    private String assuntoInstrucao; //240
    private String departamentoDestinatario; //120
    private String destinatarioInstrucao; //120
    private String modeloInstrucao;//30
    private String textoInstrucao;//40000
    private String tipoInstrucao;//30
    private Date dataSolicitacao;
    private Usuario usuario;
    
    public InstrucaoNormativa() {
        
    }
    
    public InstrucaoNormativa(int codigoInstrucao, int numero, String ano, String assuntoInstrucao, String departamentoDestinatario, String destinatarioInstrucao,
        String modeloInstrucao, String textoInstrucao, String tipoInstrucao, Date dataSolicitacao, Usuario usuario) {
        
        this.ano = ano;
        this.assuntoInstrucao = assuntoInstrucao;
        this.codigoInstrucao = codigoInstrucao;
        this.dataSolicitacao = dataSolicitacao;
        this.departamentoDestinatario = departamentoDestinatario;
        this.destinatarioInstrucao = destinatarioInstrucao;
        this.modeloInstrucao = modeloInstrucao;
        this.numero = numero;
        this.textoInstrucao = textoInstrucao;
        this.tipoInstrucao = tipoInstrucao;
        this.usuario = usuario;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_INSTRUCAONORMATIVA", sequenceName = "instrucaonormativa_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_INSTRUCAONORMATIVA")
    @Column(name = "codigoinstrucao", unique = true, nullable = false)
    public int getCodigoInstrucao() {
        return codigoInstrucao;
    }

    public void setCodigoInstrucao(int codigoInstrucao) {
        this.codigoInstrucao = codigoInstrucao;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "assuntoinstrucao", nullable = true, length = 240)
    public String getAssuntoInstrucao() {
        return assuntoInstrucao;
    }

    public void setAssuntoInstrucao(String assuntoInstrucao) {
        this.assuntoInstrucao = assuntoInstrucao;
    }

    @Column(name = "departamentodestinatario", nullable = true, length = 120)
    public String getDepartamentoDestinatario() {
        return departamentoDestinatario;
    }

    public void setDepartamentoDestinatario(String departamentoDestinatario) {
        this.departamentoDestinatario = departamentoDestinatario;
    }

    @Column(name = "destinatarioinstrucao", nullable = true, length = 120)
    public String getDestinatarioInstrucao() {
        return destinatarioInstrucao;
    }

    public void setDestinatarioInstrucao(String destinatarioInstrucao) {
        this.destinatarioInstrucao = destinatarioInstrucao;
    }

    @Column(name = "modeloinstrucao", nullable = false, length = 30)
    public String getModeloInstrucao() {
        return modeloInstrucao;
    }

    public void setModeloInstrucao(String modeloInstrucao) {
        this.modeloInstrucao = modeloInstrucao;
    }

    @Column(name = "textoinstrucao", nullable = true, length = 40000)
    public String getTextoInstrucao() {
        return textoInstrucao;
    }

    public void setTextoInstrucao(String textoInstrucao) {
        this.textoInstrucao = textoInstrucao;
    }

    @Column(name = "tipoinstrucao", nullable = false, length = 30)
    public String getTipoInstrucao() {
        return tipoInstrucao;
    }

    public void setTipoInstrucao(String tipoInstrucao) {
        this.tipoInstrucao = tipoInstrucao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datasolicitacao", nullable = false, length = 13)
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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
