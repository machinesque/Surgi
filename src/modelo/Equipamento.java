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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "equipamento", schema = "public")
public class Equipamento implements java.io.Serializable {

    private int codigoEquipamento;
    private String marcaEquipamento;//120
    private String modeloEquipamento;//120
    private String patrimonioEquipamento;//10
    private String corEquipamento;//60
    private boolean diponibilidadeEmprestimo;
    private List<AgendamentoEquipamentoItens> listaAgendamentoEquipamentoItens;
    private TipoEquipamento tipoEquipamento;
    
    public Equipamento() {
        
    }
    
    public Equipamento(int codigoEquipamento, String marcaEquipamento, String modeloEquipamento, String patrimonioEquipamento, String corEquipamento, boolean disponibilidadeEquipamento,
            List<AgendamentoEquipamentoItens> listaAgendamentoEquipamentoItens, TipoEquipamento tipoEquipamento) {
        
        this.codigoEquipamento = codigoEquipamento;
        this.corEquipamento = corEquipamento;
        this.diponibilidadeEmprestimo = disponibilidadeEquipamento;
        this.listaAgendamentoEquipamentoItens = listaAgendamentoEquipamentoItens;
        this.marcaEquipamento = marcaEquipamento;
        this.modeloEquipamento = modeloEquipamento;
        this.patrimonioEquipamento = patrimonioEquipamento;
        this.tipoEquipamento = tipoEquipamento;

    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_EQUIPAMENTO", sequenceName = "equipamento_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EQUIPAMENTO")
    @Column(name = "codigoequipamento", unique = true, nullable = false)
    public int getCodigoEquipamento() {
        return codigoEquipamento;
    }

    public void setCodigoEquipamento(int codigoEquipamento) {
        this.codigoEquipamento = codigoEquipamento;
    }

    @Column(name = "corequipamento", nullable = false, length = 60)
    public String getCorEquipamento() {
        return corEquipamento;
    }

    public void setCorEquipamento(String corEquipamento) {
        this.corEquipamento = corEquipamento;
    }

    @Column(name = "marcaequipamento", nullable = false, length = 120)
    public String getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(String marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    @Column(name = "modeloequipamento", nullable = false, length = 120)
    public String getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(String modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    @Column(name = "patrimonioequipamento", nullable = false, length = 10)
    public String getPatrimonioEquipamento() {
        return patrimonioEquipamento;
    }

    public void setPatrimonioEquipamento(String patrimonioEquipamento) {
        this.patrimonioEquipamento = patrimonioEquipamento;
    }

    @Column(name = "disponibilidadeemprestimo", nullable = false)
    public boolean isDiponibilidadeEmprestimo() {
        return diponibilidadeEmprestimo;
    }

    public void setDiponibilidadeEmprestimo(boolean diponibilidadeEmprestimo) {
        this.diponibilidadeEmprestimo = diponibilidadeEmprestimo;
    }

    @OneToMany(mappedBy = "equipamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "agendamentoEquipamento")
    public List<AgendamentoEquipamentoItens> getListaAgendamentoEquipamentoItens() {
        return listaAgendamentoEquipamentoItens;
    }

    public void setListaAgendamentoEquipamentoItens(List<AgendamentoEquipamentoItens> listaAgendamentoEquipamentoItens) {
        this.listaAgendamentoEquipamentoItens = listaAgendamentoEquipamentoItens;
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
