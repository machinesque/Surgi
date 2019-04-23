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
@Table(name = "equipamentoentidade", schema = "public")
public class EquipamentoEntidades implements java.io.Serializable {

    private int codigoEquipamentoEntidade;
    private String marcaEquipamentoEntidade;//120
    private String modeloEquipamentoEntidade;//120
    private String patrimonioEquipamentoEntidade;//10
    private String corEquipamentoEntidade;//60
    private String tipoEntidadeEquipamentoEntidade;//10
    private String setorEquipamentoEntidade;//120
    private String cartuchoPretoEquipamentoEntidade;//60
    private String cartuchoColoridoEquipamentoEntidade;//60
    private Cmei cmei;
    private Escola escola;
    private Outro outro;
    private TipoEquipamento tipoEquipamento;

    public EquipamentoEntidades() {
        
    }
    
    public EquipamentoEntidades(int codigoEquipamentoEntidade, String marcaEquipamentoEntidade, String modeloEquipamentoEntidade, String patrimonioEquipamentoEntidade, 
            String corEquipamentoEntidade, String tipoEntidadeEquipamentoEntidade, String setorEquipamentoentidade, String cartuchoPretoEquipamentoEntidade, 
            String cartuchoColoridoEquipamentoEntidade, Cmei cmei, Escola escola, Outro outro, TipoEquipamento tipoEquipamento) {
        
        this.codigoEquipamentoEntidade = codigoEquipamentoEntidade;
        this.cartuchoColoridoEquipamentoEntidade = cartuchoColoridoEquipamentoEntidade;
        this.cartuchoPretoEquipamentoEntidade = cartuchoPretoEquipamentoEntidade;
        this.cmei = cmei;
        this.corEquipamentoEntidade = corEquipamentoEntidade;
        this.escola = escola;
        this.marcaEquipamentoEntidade = marcaEquipamentoEntidade;
        this.modeloEquipamentoEntidade = modeloEquipamentoEntidade;
        this.outro = outro;
        this.patrimonioEquipamentoEntidade = patrimonioEquipamentoEntidade;
        this.setorEquipamentoEntidade = setorEquipamentoentidade;
        this.tipoEntidadeEquipamentoEntidade = tipoEntidadeEquipamentoEntidade;
        this.tipoEquipamento = tipoEquipamento;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_EQUIPAMENTOENTIDADE", sequenceName = "equipamentoentidade_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EQUIPAMENTOENTIDADE")
    @Column(name = "codigoequipamentoentidade", unique = true, nullable = false)
    public int getCodigoEquipamentoEntidade() {
        return codigoEquipamentoEntidade;
    }

    public void setCodigoEquipamentoEntidade(int codigoEquipamentoEntidade) {
        this.codigoEquipamentoEntidade = codigoEquipamentoEntidade;
    }

    @Column(name = "corequipamentoentidade", nullable = false, length = 60)
    public String getCorEquipamentoEntidade() {
        return corEquipamentoEntidade;
    }
    
   public void setCorEquipamentoEntidade(String corEquipamentoEntidade) {
        this.corEquipamentoEntidade = corEquipamentoEntidade;
    }
    
    @Column(name = "cartuchocoloridoequipamentoentidade", nullable = false, length = 60)
    public String getCartuchoColoridoEquipamentoEntidade() {
        return cartuchoColoridoEquipamentoEntidade;
    }
    
    public void setCartuchoColoridoEquipamentoEntidade(String cartuchoColoridoEquipamentoEntidade) {
        this.cartuchoColoridoEquipamentoEntidade = cartuchoColoridoEquipamentoEntidade;
    }

    @Column(name = "cartuchopretoequipamentoentidade", nullable = false, length = 60)
    public String getCartuchoPretoEquipamentoEntidade() {
        return cartuchoPretoEquipamentoEntidade;
    }
    
    public void setCartuchoPretoEquipamentoEntidade(String cartuchoPretoEquipamentoEntidade) {
        this.cartuchoPretoEquipamentoEntidade = cartuchoPretoEquipamentoEntidade;
    }

    @Column(name = "marcaequipamentoentidade", nullable = false, length = 120)
    public String getMarcaEquipamentoEntidade() {
        return marcaEquipamentoEntidade;
    }

    public void setMarcaEquipamentoEntidade(String marcaEquipamentoEntidade) {
        this.marcaEquipamentoEntidade = marcaEquipamentoEntidade;
    }

    @Column(name = "modeloequipamentoentidade", nullable = false, length = 120)
    public String getModeloEquipamentoEntidade() {
        return modeloEquipamentoEntidade;
    }

    public void setModeloEquipamentoEntidade(String modeloEquipamentoEntidade) {
        this.modeloEquipamentoEntidade = modeloEquipamentoEntidade;
    }

    @Column(name = "patrimonioequipamentoentidade", nullable = false, length = 10)
    public String getPatrimonioEquipamentoEntidade() {
        return patrimonioEquipamentoEntidade;
    }

    public void setPatrimonioEquipamentoEntidade(String patrimonioEquipamentoEntidade) {
        this.patrimonioEquipamentoEntidade = patrimonioEquipamentoEntidade;
    }

    @Column(name = "setorequipamentoentidade", nullable = false, length = 120)
    public String getSetorEquipamentoEntidade() {
        return setorEquipamentoEntidade;
    }

    public void setSetorEquipamentoEntidade(String setorEquipamentoEntidade) {
        this.setorEquipamentoEntidade = setorEquipamentoEntidade;
    }

    @Column(name = "tipoentidadeequipamentoentidade", nullable = false, length = 10)
    public String getTipoEntidadeEquipamentoEntidade() {
        return tipoEntidadeEquipamentoEntidade;
    }

    public void setTipoEntidadeEquipamentoEntidade(String tipoEntidadeEquipamentoEntidade) {
        this.tipoEntidadeEquipamentoEntidade = tipoEntidadeEquipamentoEntidade;
    }

    @OneToOne
    @JoinColumn(name = "cmei_codigocmei", insertable = true, updatable = false)
    public Cmei getCmei() {
        return cmei;
    }

    public void setCmei(Cmei cmei) {
        this.cmei = cmei;
    }

    @OneToOne
    @JoinColumn(name = "escola_codigoescola", insertable = true, updatable = false)
    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @OneToOne
    @JoinColumn(name = "outro_codigooutro", insertable = true, updatable = false)
    public Outro getOutro() {
        return outro;
    }

    public void setOutro(Outro outro) {
        this.outro = outro;
    }

    @OneToOne
    @JoinColumn(name = "tipoequipamento_codigotipoequipamento", insertable = true, updatable = false)
    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }
    
}
