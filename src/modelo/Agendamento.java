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
 * @author luiz
 */

@Entity
@Table(name = "agendamento", schema = "public")
public class Agendamento implements java.io.Serializable {

    private int codigoAgendamento;
    private String anoAgendamento;//4
    private String tipoAgendamento;//30
    private String problemaInformado;//400
    private String problemaConstatado;//400
    private String localEntidade;//60
    private String status;//30
    private String tipoEntidade;//10
    private String horaSolicitacao;//10
    private boolean recolheuMaquina;
    private Date dataSolicitacao;
    private Date dataResolucao;
    private Date dataRecolhimento;
    private Cmei cmei;
    private Escola escola;
    private Outro outro;
    private Usuario usuario;
    private Usuario usuarioAtendimento;

    public Agendamento() {
        
    }
    
    public Agendamento(int codigoAgendamento, String anoAgendamento, String tipoAgendamento, String problemaInformado, String problemaConstatado, String localEntidade, String status,
            String tipoEntidade, boolean recolheuMaquina, Date dataSolicitacao, Date dataResolucao, Date dataRecolhimento, Cmei cmei, Escola escola, Outro outro, Usuario usuario, 
            Usuario usuarioAtendimento) {
        
        this.codigoAgendamento = codigoAgendamento;
        this.anoAgendamento = anoAgendamento;
        this.cmei = cmei;
        this.dataRecolhimento = dataRecolhimento;
        this.dataResolucao = dataResolucao;
        this.dataSolicitacao = dataSolicitacao;
        this.escola = escola;
        this.horaSolicitacao = horaSolicitacao;
        this.localEntidade = localEntidade;
        this.outro = outro;
        this.problemaConstatado = problemaConstatado;
        this.problemaInformado = problemaInformado;
        this.recolheuMaquina = recolheuMaquina;
        this.status = status;
        this.tipoAgendamento = tipoAgendamento;
        this.tipoEntidade = tipoEntidade;
        this.usuario = usuario;
        this.usuarioAtendimento = usuarioAtendimento;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_AGENDAMENTO", sequenceName = "agendamento_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_AGENDAMENTO")
    @Column(name = "codigoagendamento", unique = true, nullable = false)
    public int getCodigoAgendamento() {
        return codigoAgendamento;
    }

    public void setCodigoAgendamento(int codigoAgendamento) {
        this.codigoAgendamento = codigoAgendamento;
    }
    
    @Column(name = "anoagendamento", nullable = false, length = 4)
    public String getAnoAgendamento() {
        return anoAgendamento;
    }

    public void setAnoAgendamento(String anoAgendamento) {
        this.anoAgendamento = anoAgendamento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datasolicitacao", nullable = false, length = 13)
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    @Column(name = "localentidade", nullable = false, length = 60)
    public String getLocalEntidade() {
        return localEntidade;
    }

    public void setLocalEntidade(String localEntidade) {
        this.localEntidade = localEntidade;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "dataresolucao", nullable = true, length = 13)
    public Date getDataResolucao() {
        return dataResolucao;
    }

    public void setDataResolucao(Date dataResolucao) {
        this.dataResolucao = dataResolucao;
    }

    @Column(name = "tipoentidade", nullable = false, length = 10)
    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datarecolhimento", nullable = true, length = 13)
    public Date getDataRecolhimento() {
        return dataRecolhimento;
    }

    public void setDataRecolhimento(Date dataRecolhimento) {
        this.dataRecolhimento = dataRecolhimento;
    }

    @Column(name = "tipoagendamento", nullable = false, length = 30)
    public String getTipoAgendamento() {
        return tipoAgendamento;
    }

    public void setTipoAgendamento(String tipoAgendamento) {
        this.tipoAgendamento = tipoAgendamento;
    }

    @Column(name = "horasolicitacao", nullable = false, length = 10)
    public String getHoraSolicitacao() {
        return horaSolicitacao;
    }

    public void setHoraSolicitacao(String horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    @Column(name = "recolheumaquina", nullable = false)
    public boolean isRecolheuMaquina() {
        return recolheuMaquina;
    }

    public void setRecolheuMaquina(boolean recolheuMaquina) {
        this.recolheuMaquina = recolheuMaquina;
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

    @OneToOne
    @JoinColumn(name = "usuarioatendimento_codigousuario", insertable = true, updatable = true)
    public Usuario getUsuarioAtendimento() {
        return usuarioAtendimento;
    }

    public void setUsuarioAtendimento(Usuario usuarioAtendimento) {
        this.usuarioAtendimento = usuarioAtendimento;
    }

}
