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
@Table(name = "solicitacaorecarga", schema = "public")
public class SolicitacaoRecarga implements java.io.Serializable {
    
    private int codigoSolicitacaoRecarga;
    private int numeroSolicitacao;
    private String ano;//4
    private String emissor;//120
    private String receptor;//120
    private String modeloToner01;//60
    private String codigoBarra01;//80
    private String modeloToner02;//60
    private String codigoBarra02;//80
    private String modeloToner03;//60
    private String codigoBarra03;//80
    private String modeloToner04;//60
    private String codigoBarra04;//80
    private String modeloToner05;//60
    private String codigoBarra05;//80
    private String modeloToner06;//60
    private String codigoBarra06;//80
    private String modeloToner07;//60
    private String codigoBarra07;//80
    private String modeloToner08;//60
    private String codigoBarra08;//80
    private String modeloToner09;//60
    private String codigoBarra09;//80
    private String modeloToner10;//60
    private String codigoBarra10;//80
    private String horaSolicitacao;//10
    private Date dataSolicitacao;
    private boolean solicitacaoFinalizada;
    private Usuario usuario;
    
    public SolicitacaoRecarga() {
        
    }
    
    public SolicitacaoRecarga(int codigoSolicitacaoRecarga, int numeroSolicitacao, String ano, String emissor, String receptor, String modeloToner01, String codigoBarra01, 
            String modeloToner02, String codigoBarra02, String modeloToner03, String codigoBarra03, String modeloToner04, String codigoBarra04, String modeloToner05, String codigoBarra05,
            String modeloToner06, String codigoBarra06, String modeloToner07, String codigoBarra07, String modeloToner08, String codigoBarra08, String modeloToner09, String codigoBarra09,
            String modeloToner10, String codigoBarra10, Date dataSolicitacao, boolean solicitacaoFinalizada, Usuario usuario) {
        
        this.codigoSolicitacaoRecarga = codigoSolicitacaoRecarga;
        this.ano = ano;
        this.dataSolicitacao = dataSolicitacao;
        this.emissor = emissor;
        this.horaSolicitacao = horaSolicitacao;
        this.usuario = usuario;
        this.numeroSolicitacao = numeroSolicitacao;
        this.receptor = receptor;
        this.solicitacaoFinalizada = solicitacaoFinalizada;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_SOLICITACAORECARGA", sequenceName = "solicitacaorecarga_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_SOLICITACAORECARGA")
    @Column(name = "codigosolicitacaorecarga", unique = true, nullable = false)
    public int getCodigoSolicitacaoRecarga() {
        return codigoSolicitacaoRecarga;
    }

    public void setCodigoSolicitacaoRecarga(int codigoSolicitacaoRecarga) {
        this.codigoSolicitacaoRecarga = codigoSolicitacaoRecarga;
    }
    
    @Column(name = "emissor", nullable = false, length = 120)
    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String Emissor) {
        this.emissor = Emissor;
    }

    @Column(name = "receptor", nullable = false, length = 120)
    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String Receptor) {
        this.receptor = Receptor;
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

    @Column(name = "numerosolicitacao", nullable = false)
    public int getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(int numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    @Column(name = "solicitacaofinalizada", nullable = false)
    public boolean isSolicitacaoFinalizada() {
        return solicitacaoFinalizada;
    }

    public void setSolicitacaoFinalizada(boolean solicitacaoFinalizada) {
        this.solicitacaoFinalizada = solicitacaoFinalizada;
    }

    @Column(name = "horasolicitacao", nullable = false, length = 5)
    public String getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(String horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    @Column(name = "modelotoner01", nullable = false, length = 60)
    public String getModeloToner01() {
        return modeloToner01;
    }

    public void setModeloToner01(String modeloToner01) {
        this.modeloToner01 = modeloToner01;
    }

    @Column(name = "codigobarra01", nullable = false, length = 80)
    public String getCodigoBarra01() {
        return codigoBarra01;
    }

    public void setCodigoBarra01(String codigoBarra01) {
        this.codigoBarra01 = codigoBarra01;
    }

    @Column(name = "modelotoner02", nullable = true, length = 60)
    public String getModeloToner02() {
        return modeloToner02;
    }

    public void setModeloToner02(String modeloToner02) {
        this.modeloToner02 = modeloToner02;
    }

    @Column(name = "codigobarra02", nullable = true, length = 80)
    public String getCodigoBarra02() {
        return codigoBarra02;
    }

    public void setCodigoBarra02(String codigoBarra02) {
        this.codigoBarra02 = codigoBarra02;
    }

    @Column(name = "modelotoner03", nullable = true, length = 60)
    public String getModeloToner03() {
        return modeloToner03;
    }

    public void setModeloToner03(String modeloToner03) {
        this.modeloToner03 = modeloToner03;
    }

    @Column(name = "codigobarra03", nullable = true, length = 80)
    public String getCodigoBarra03() {
        return codigoBarra03;
    }

    public void setCodigoBarra03(String codigoBarra03) {
        this.codigoBarra03 = codigoBarra03;
    }

    @Column(name = "modelotoner04", nullable = true, length = 60)
    public String getModeloToner04() {
        return modeloToner04;
    }

    public void setModeloToner04(String modeloToner04) {
        this.modeloToner04 = modeloToner04;
    }

    @Column(name = "codigobarra04", nullable = true, length = 80)
    public String getCodigoBarra04() {
        return codigoBarra04;
    }

    public void setCodigoBarra04(String codigoBarra04) {
        this.codigoBarra04 = codigoBarra04;
    }

    @Column(name = "modelotoner05", nullable = true, length = 60)
    public String getModeloToner05() {
        return modeloToner05;
    }

    public void setModeloToner05(String modeloToner05) {
        this.modeloToner05 = modeloToner05;
    }

    @Column(name = "codigobarra05", nullable = true, length = 80)
    public String getCodigoBarra05() {
        return codigoBarra05;
    }

    public void setCodigoBarra05(String codigoBarra05) {
        this.codigoBarra05 = codigoBarra05;
    }

    @Column(name = "modelotoner06", nullable = true, length = 60)
    public String getModeloToner06() {
        return modeloToner06;
    }

    public void setModeloToner06(String modeloToner06) {
        this.modeloToner06 = modeloToner06;
    }

    @Column(name = "codigobarra06", nullable = true, length = 80)
    public String getCodigoBarra06() {
        return codigoBarra06;
    }

    public void setCodigoBarra06(String codigoBarra06) {
        this.codigoBarra06 = codigoBarra06;
    }

    @Column(name = "modelotoner07", nullable = true, length = 60)
    public String getModeloToner07() {
        return modeloToner07;
    }

    public void setModeloToner07(String modeloToner07) {
        this.modeloToner07 = modeloToner07;
    }

    @Column(name = "codigobarra07", nullable = true, length = 80)
    public String getCodigoBarra07() {
        return codigoBarra07;
    }

    public void setCodigoBarra07(String codigoBarra07) {
        this.codigoBarra07 = codigoBarra07;
    }

    @Column(name = "modelotoner08", nullable = true, length = 60)
    public String getModeloToner08() {
        return modeloToner08;
    }

    public void setModeloToner08(String modeloToner08) {
        this.modeloToner08 = modeloToner08;
    }

    @Column(name = "codigobarra08", nullable = true, length = 80)
    public String getCodigoBarra08() {
        return codigoBarra08;
    }

    public void setCodigoBarra08(String codigoBarra08) {
        this.codigoBarra08 = codigoBarra08;
    }

    @Column(name = "modelotoner09", nullable = true, length = 60)
    public String getModeloToner09() {
        return modeloToner09;
    }

    public void setModeloToner09(String modeloToner09) {
        this.modeloToner09 = modeloToner09;
    }

    @Column(name = "codigobarra09", nullable = true, length = 80)
    public String getCodigoBarra09() {
        return codigoBarra09;
    }

    public void setCodigoBarra09(String codigoBarra09) {
        this.codigoBarra09 = codigoBarra09;
    }

    @Column(name = "modelotoner10", nullable = true, length = 60)
    public String getModeloToner10() {
        return modeloToner10;
    }

    public void setModeloToner10(String modeloToner10) {
        this.modeloToner10 = modeloToner10;
    }

    @Column(name = "codigobarra10", nullable = true, length = 80)
    public String getCodigoBarra10() {
        return codigoBarra10;
    }

    public void setCodigoBarra10(String codigoBarra10) {
        this.codigoBarra10 = codigoBarra10;
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
