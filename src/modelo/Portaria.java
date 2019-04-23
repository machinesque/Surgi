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
@Table(name = "portaria", schema = "public")
public class Portaria implements java.io.Serializable {

    private int codigoPortaria;
    private int numero;
    private String ano;//4
    private String tipoPortaria;//30
    private String modeloPortaria;//30
    private String departamentoDestinatario; //120
    private String destinatarioPortaria; //120
    private String assuntoPortaria; //240
    private String textoPortaria;//40000
    private Date dataSolicitacao;
    private Usuario usuario;

    public Portaria() {
        
    }
    
    public Portaria(int codigoPortaria, int numero, String ano, String tipoPortaria, String modeloPortaria, String departamentoDestinatario,
            String destinatarioPortaria, String assuntoPortaria, String textoPortaria, Date dataSolicitacao, Usuario usuario) {
        
        this.codigoPortaria = codigoPortaria;
        this.ano = ano;
        this.assuntoPortaria = assuntoPortaria;
        this.dataSolicitacao = dataSolicitacao;
        this.departamentoDestinatario = departamentoDestinatario;
        this.destinatarioPortaria = destinatarioPortaria;
        this.modeloPortaria = modeloPortaria;
        this.usuario = usuario;
        this.numero = numero;
        this.textoPortaria = textoPortaria;
        this.tipoPortaria = tipoPortaria;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_PORTARIA", sequenceName = "portaria_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_PORTARIA")
    @Column(name = "codigoportaria", unique = true, nullable = false)
    public int getCodigoPortaria() {
        return codigoPortaria;
    }

    public void setCodigoPortaria(int codigoPortaria) {
        this.codigoPortaria = codigoPortaria;
    }
    
    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Column(name = "assuntoportaria", nullable = true, length = 240)
    public String getAssuntoPortaria() {
        return assuntoPortaria;
    }

    public void setAssuntoPortaria(String assuntoPortaria) {
        this.assuntoPortaria = assuntoPortaria;
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

    @Column(name = "destinatarioportaria", nullable = true, length = 120)
    public String getDestinatarioPortaria() {
        return destinatarioPortaria;
    }

    public void setDestinatarioPortaria(String destinatarioPortaria) {
        this.destinatarioPortaria = destinatarioPortaria;
    }

    @Column(name = "modeloportaria", nullable = false, length = 30)
    public String getModeloPortaria() {
        return modeloPortaria;
    }

    public void setModeloPortaria(String modeloPortaria) {
        this.modeloPortaria = modeloPortaria;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "textoportaria", nullable = true, length = 40000)
    public String getTextoPortaria() {
        return textoPortaria;
    }

    public void setTextoPortaria(String textoPortaria) {
        this.textoPortaria = textoPortaria;
    }

    @Column(name = "tipoportaria", nullable = false, length = 30)
    public String getTipoPortaria() {
        return tipoPortaria;
    }

    public void setTipoPortaria(String tipoPortaria) {
        this.tipoPortaria = tipoPortaria;
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
