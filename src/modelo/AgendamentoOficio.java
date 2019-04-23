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
@Table(name = "agendamentooficio", schema = "public")
public class AgendamentoOficio implements java.io.Serializable {
    
    private int codigoAgendamentoOficio;
    private String anoAgendamento;
    private String horaSolicitacao;//10
    private String numeroOficio; //60
    private String problemaInformado;
    private String problemaConstatado;
    private String status;
    private String tipoEntidade;
    private Date dataResolucao;
    private Date dataSolicitacao;
    private Date dataRecolhimento;
    private Cmei cmei;
    private DepartamentoDivisaoSetor departamentoDivisaoSetor;
    private Escola escola;
    private Outro outro;
    private Usuario usuario;

    public AgendamentoOficio() {
        
    }
    
    public AgendamentoOficio(int codigoAgendamentoOficio, String anoAgendamento, String horaSolicitacao, String numeroOficio, String problemaInformado, String problemaConstatado, String status, 
            String tipoEntidade, Date dataResolucao, Date dataSolicitacao, Date dataRecolhimento, Cmei cmei, DepartamentoDivisaoSetor departamentoDivisaoSetor, Escola escola, Outro outro, 
            Usuario usuario) {
        
        this.anoAgendamento = anoAgendamento;
        this.cmei = cmei;
        this.codigoAgendamentoOficio = codigoAgendamentoOficio;
        this.departamentoDivisaoSetor = departamentoDivisaoSetor;
        this.dataRecolhimento = dataRecolhimento;
        this.dataResolucao = dataResolucao;
        this.dataSolicitacao = dataSolicitacao;
        this.escola = escola;
        this.horaSolicitacao = horaSolicitacao;
        this.numeroOficio = numeroOficio;
        this.outro = outro;
        this.problemaConstatado = problemaConstatado;
        this.problemaInformado = problemaInformado;
        this.status = status;
        this.tipoEntidade = tipoEntidade;
        this.usuario = usuario;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_AGENDAMENTOOFICIO", sequenceName = "agendamentooficio_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_AGENDAMENTOOFICIO")
    @Column(name = "codigoagendamentooficio", unique = true, nullable = false)
    public int getCodigoAgendamentoOficio() {
        return codigoAgendamentoOficio;
    }

    public void setCodigoAgendamentoOficio(int codigoAgendamentoOficio) {
        this.codigoAgendamentoOficio = codigoAgendamentoOficio;
    }
    
    @Column(name = "anoagendamento", nullable = false, length = 5)
    public String getAnoAgendamento() {
        return anoAgendamento;
    }

    public void setAnoAgendamento(String anoAgendamento) {
        this.anoAgendamento = anoAgendamento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datarecolhimento", nullable = true, length = 13)
    public Date getDataRecolhimento() {
        return dataRecolhimento;
    }

    public void setDataRecolhimento(Date dataRecolhimento) {
        this.dataRecolhimento = dataRecolhimento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataresolucao", nullable = true, length = 13)
    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datasolicitacao", nullable = false, length = 13)
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    @Column(name = "horasolicitacao", nullable = false, length = 10)
    public String getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(String horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    @Column(name = "numerooficio", nullable = false, length = 60)
    public String getNumeroOficio() {
        return numeroOficio;
    }

    public void setNumeroOficio(String numeroOficio) {
        this.numeroOficio = numeroOficio;
    }

    @Column(name = "problemaconstatado", nullable = true, length = 400)
    public String getProblemaConstatado() {
        return problemaConstatado;
    }

    public void setProblemaConstatado(String problemaConstatado) {
        this.problemaConstatado = problemaConstatado;
    }

    @Column(name = "problemainformado", nullable = false, length = 400)
    public String getProblemaInformado() {
        return problemaInformado;
    }

    public void setProblemaInformado(String problemaInformado) {
        this.problemaInformado = problemaInformado;
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

    @OneToOne
    @JoinColumn(name = "cmei_codigocmei", insertable = true, updatable = true)
    public Cmei getCmei() {
        return cmei;
    }

    public void setCmei(Cmei cmei) {
        this.cmei = cmei;
    }

    @OneToOne
    @JoinColumn(name = "departamentodivisaosetor_codigodepartamentodivisaosetor", insertable = true, updatable = true)
    public DepartamentoDivisaoSetor getDepartamentoDivisaoSetor() {
        return departamentoDivisaoSetor;
    }

    public void setDepartamentoDivisaoSetor(DepartamentoDivisaoSetor departamentoDivisaoSetor) {
        this.departamentoDivisaoSetor = departamentoDivisaoSetor;
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
