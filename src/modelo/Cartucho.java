/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

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

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "cartucho", schema = "public")
public class Cartucho implements java.io.Serializable {

    private int codigoCartucho;
    private String codigoBarra;//80
    private String tipoEntidade;//10
    private boolean cartuchoQueimado;
    private List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens;
    private List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens;
    private Cmei cmei;
    private Escola escola;
    private ModeloCartucho modeloCartucho;
    private Outro outro;

    public Cartucho() {
        
    }
    
    public Cartucho(int codigoCartucho, String codigoBarra, String tipoEntidade, boolean cartuchoQueimado, List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens, 
            List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens, Cmei cmei, Escola escola, ModeloCartucho modeloCartucho, Outro outro) {
        
        this.cartuchoQueimado = cartuchoQueimado;
        this.cmei = cmei;
        this.codigoBarra = codigoBarra;
        this.codigoCartucho = codigoCartucho;
        this.escola = escola;
        this.listaSolicitacaoRemanufaturaItens = listaSolicitacaoRemanufaturaItens;
        this.listaEntregaRemanufaturadosItens = listaEntregaRemanufaturadosItens;
        this.modeloCartucho = modeloCartucho;
        this.outro = outro;
        this.tipoEntidade = tipoEntidade;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_CARTUCHO", sequenceName = "cartucho_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CARTUCHO")
    @Column(name = "codigocartucho", unique = true, nullable = false)
    public int getCodigoCartucho() {
        return codigoCartucho;
    }

    public void setCodigoCartucho(int codigoCartucho) {
        this.codigoCartucho = codigoCartucho;
    }
    
    @Column(name = "codigobarra", nullable = false, length = 80)
    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    @Column(name = "tipoentidade", nullable = false, length = 10)
    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Column(name = "cartuchoqueimado", nullable = false)
    public boolean isCartuchoQueimado() {
        return cartuchoQueimado;
    }

    public void setCartuchoQueimado(boolean cartuchoQueimado) {
        this.cartuchoQueimado = cartuchoQueimado;
    }

    @OneToMany(mappedBy = "cartucho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<EntregaRemanufaturadosItens> getListaEntregaRemanufaturadosItens() {
        return listaEntregaRemanufaturadosItens;
    }

    public void setListaEntregaRemanufaturadosItens(List<EntregaRemanufaturadosItens> listaEntregaRemanufaturadosItens) {
        this.listaEntregaRemanufaturadosItens = listaEntregaRemanufaturadosItens;
    }

    @OneToMany(mappedBy = "cartucho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<SolicitacaoRemanufaturaItens> getListaSolicitacaoRemanufaturaItens() {
        return listaSolicitacaoRemanufaturaItens;
    }

    public void setListaSolicitacaoRemanufaturaItens(List<SolicitacaoRemanufaturaItens> listaSolicitacaoRemanufaturaItens) {
        this.listaSolicitacaoRemanufaturaItens = listaSolicitacaoRemanufaturaItens;
    }
    
    @OneToOne
    @JoinColumn(name = "cmei_codigocmei", insertable = true, updatable = true)
    public Cmei getCmei() {
        return cmei;
    }

    public void setCmei(Cmei cmei) {
        this.cmei = cmei;
    }

    @OneToOne
    @JoinColumn(name = "escola_codigoescola", insertable = true, updatable = true)
    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @OneToOne
    @JoinColumn(name = "modelocartucho_codigomodelocartucho", insertable = true, updatable = true)
    public ModeloCartucho getModeloCartucho() {
        return modeloCartucho;
    }

    public void setModeloCartucho(ModeloCartucho modeloCartucho) {
        this.modeloCartucho = modeloCartucho;
    }

    @OneToOne
    @JoinColumn(name = "outro_codigooutro", insertable = true, updatable = true)
    public Outro getOutro() {
        return outro;
    }

    public void setOutro(Outro outro) {
        this.outro = outro;
    }

}
