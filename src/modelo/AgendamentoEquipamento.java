/*
 * To change this template, choose Tools | Templates
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
 */

@Entity
@Table(name = "agendamentoequipamento", schema = "public")
public class AgendamentoEquipamento implements java.io.Serializable {
    
    private int codigoAgendamentoEquipamento;
    private String anoAgendamento;//4
    private String nomeSolicitante;//120
    private String status;//30
    private String tipoEntidade;//10
    private String observacao;//400
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataDevolucaoReal;
    private Cmei cmei;
    private Escola escola;
    private List<AgendamentoEquipamentoItens> listaAgendamentoEquipamentoItens;
    //private Equipamento equipamento2;
    private Outro outro;
    //private TipoEquipamento tipoEquipamento;
    //private TipoEquipamento tipoEquipamento2;
    private Usuario usuario;

    public AgendamentoEquipamento() {
        
    }
    
    public AgendamentoEquipamento(int codigoAgendamentoEquipamento, String anoAgendamento, String nomeSolicitante, String status, String tipoEntidade, String observacao,
            Date dataEmprestimo, Date dataDevolucao, Date dataDevolucaoReal, Cmei cmei, Escola escola, List<AgendamentoEquipamentoItens> listaAgendamentoEquipamentoItens, Outro outro, Usuario usuario) {
        
        this.anoAgendamento = anoAgendamento;
        this.cmei = cmei;
        this.codigoAgendamentoEquipamento = codigoAgendamentoEquipamento;
        this.dataDevolucao = dataDevolucao;
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.dataEmprestimo = dataEmprestimo;
        this.listaAgendamentoEquipamentoItens = listaAgendamentoEquipamentoItens;
        this.escola = escola;
        this.nomeSolicitante = nomeSolicitante;
        this.observacao = observacao;
        this.outro = outro;
        this.status = status;
        this.tipoEntidade = tipoEntidade;
        this.usuario = usuario;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_AGENDAMENTOEQUIPAMENTO", sequenceName = "agendamentoequipamento_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_AGENDAMENTOEQUIPAMENTO")
    @Column(name = "codigoagendamentoequipamento", unique = true, nullable = false)
    public int getCodigoAgendamentoEquipamento() {
        return codigoAgendamentoEquipamento;
    }

    public void setCodigoAgendamentoEquipamento(int codigoAgendamentoEquipamento) {
        this.codigoAgendamentoEquipamento = codigoAgendamentoEquipamento;
    }
    
    @Column(name = "anoagendamento", nullable = false, length = 4)
    public String getAnoAgendamento() {
        return anoAgendamento;
    }

    public void setAnoAgendamento(String anoAgendamento) {
        this.anoAgendamento = anoAgendamento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datadevolucao", nullable = false, length = 13)
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datadevolucaoreal", nullable = true, length = 13)
    public Date getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(Date dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataemprestimo", nullable = false, length = 13)
    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    @Column(name = "nomesolicitante", nullable = true, length = 120)
    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    @Column(name = "status", nullable = false, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "tipoentidade", nullable = false, length = 10)
    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Column(name = "observacao", nullable = true, length = 400)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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

    @OneToMany(mappedBy = "agendamentoEquipamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "equipamento_codigoequipamento", insertable = true, updatable = false)
    public List<AgendamentoEquipamentoItens> getListaAgendamentoEquipamentoItens() {
        return listaAgendamentoEquipamentoItens;
    }

    public void setListaAgendamentoEquipamentoItens(List<AgendamentoEquipamentoItens> listaEquipamento) {
        this.listaAgendamentoEquipamentoItens = listaAgendamentoEquipamentoItens;
    }

    @OneToOne
    @JoinColumn(name = "outro_codigooutro", insertable = true, updatable = true)
    public Outro getOutro() {
        return outro;
    }

    public void setOutro(Outro outro) {
        this.outro = outro;
    }

    @OneToOne
    @JoinColumn(name = "usuario_codigousuario", insertable = true, updatable = true)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
