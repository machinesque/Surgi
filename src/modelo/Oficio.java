/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name = "oficio", schema = "public")
public class Oficio implements java.io.Serializable {

    private int codigoOficio;
    private int numero;
    private String ano;//4
    private String tipoOficio;//30
    private String modeloOficio;//30
    private String departamentoDestinatario; //120
    private String destinatarioOficio; //120
    private String assuntoOficio; //240
    private String textoOficio; //40000
    private boolean manutencaoInformaticaEducacional;
    private Date dataSolicitacao;
    private Usuario usuario;
    
    public Oficio() {
        
    }
    
    public Oficio(int codigoOficio, int numero, String ano, String tipoOficio, String modeloOficio, String departamentoDestinatario, String destinatarioOficio, 
            String assuntoOficio, String textoOficio, boolean manutencaoInformaticaEducacional, Date dataSolicitacao, Usuario usuario) {
        
        this.ano = ano;
        this.assuntoOficio = assuntoOficio;
        this.codigoOficio = codigoOficio;
        this.dataSolicitacao = dataSolicitacao;
        this.departamentoDestinatario = departamentoDestinatario;
        this.destinatarioOficio = destinatarioOficio;
        this.manutencaoInformaticaEducacional = manutencaoInformaticaEducacional;
        this.modeloOficio = modeloOficio;
        this.numero = numero;
        this.textoOficio = textoOficio;
        this.tipoOficio = tipoOficio;
        this.usuario = usuario;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_OFICIO", sequenceName = "oficio_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_OFICIO")
    @Column(name = "codigooficio", unique = true, nullable = false)
    public int getCodigoOficio() {
        return codigoOficio;
    }

    public void setCodigoOficio(int codigoOficio) {
        this.codigoOficio = codigoOficio;
    }
    
    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datasolicitacao", nullable = false, length = 13)
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    @Column(name = "numero", nullable = false)
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Column(name = "modelooficio", nullable = false, length = 30)
    public String getModeloOficio() {
        return modeloOficio;
    }

    public void setModeloOficio(String modeloOficio) {
        this.modeloOficio = modeloOficio;
    }

    @Column(name = "tipooficio", nullable = false, length = 30)
    public String getTipoOficio() {
        return tipoOficio;
    }

    public void setTipoOficio(String tipoOficio) {
        this.tipoOficio = tipoOficio;
    }

    @Column(name = "assuntooficio", nullable = true, length = 240)
    public String getAssuntoOficio() {
        return assuntoOficio;
    }

    public void setAssuntoOficio(String assuntoOficio) {
        this.assuntoOficio = assuntoOficio;
    }

    @Column(name = "departamentodestinatario", nullable = true, length = 120)
    public String getDepartamentoDestinatario() {
        return departamentoDestinatario;
    }

    public void setDepartamentoDestinatario(String departamentoDestinatario) {
        this.departamentoDestinatario = departamentoDestinatario;
    }

    @Column(name = "destinatariooficio", nullable = true, length = 240)
    public String getDestinatarioOficio() {
        return destinatarioOficio;
    }

    public void setDestinatarioOficio(String destinatarioOficio) {
        this.destinatarioOficio = destinatarioOficio;
    }

    @Column(name = "manutencaoinformaticaeducacional", nullable = true)
    public boolean isManutencaoInformaticaEducacional() {
        return manutencaoInformaticaEducacional;
    }

    public void setManutencaoInformaticaEducacional(boolean manutencaoInformaticaEducacional) {
        this.manutencaoInformaticaEducacional = manutencaoInformaticaEducacional;
    }

    @Column(name = "textooficio", nullable = true, length = 40000)
    public String getTextoOficio() {
        return textoOficio;
    }

    public void setTextoOficio(String textoOficio) {
        this.textoOficio = textoOficio;
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
