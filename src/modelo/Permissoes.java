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
@Table(name = "permissoes", schema = "public")
public class Permissoes implements java.io.Serializable {

    private int codigoPermissoes; //OK
    private boolean agendarAgendamento; //OK
    private boolean agendarAgendamentoPontoDigital; //OK
    private boolean agendarAgendamentoBuscar; //OK
    private boolean agendarAgendamentoOficio; //OK
    private boolean agendarEquipamento; //OK
    private boolean cadastrarAluno; //OK
    private boolean cadastrarBloco; //OK
    private boolean cadastrarCartucho; //OK
    private boolean cadastrarCmei; //OK
    private boolean cadastrarDepartamentoDivisaoSetor; //OK
    private boolean cadastrarEndereco; //OK
    private boolean cadastrarEquipamento; //OK
    private boolean cadastrarEquipamentoUnidade; //OK
    private boolean cadastrarEscola; //OK
    private boolean cadastrarLinha; //OK
    private boolean cadastrarLote; //OK
    private boolean cadastrarModeloCartucho; //OK
    private boolean cadastrarOutros; //OK
    private boolean cadastrarTipoEquipamento; //OK
    private boolean cadastrarUsuario; //OK
    private boolean colocarEmAtendimentoAgendamento; //OK
    private boolean colocarEmAtendimentoAgendamentoPontoDigital; //OK
    private boolean colocarEmAtendimentoAgendamentoOficio; //OK
    private boolean entregarProtocoloRemanufaturados; //OK
    private boolean impressosAgendamento; //OK
    private boolean impressosEquipamento; //OK
    private boolean impressosEscola; //OK
    private boolean impressosCmei; //OK
    private boolean impressosLog; //OK
    private boolean impressosOutros; //OK
    private boolean impressosRecarga; //OK
    private boolean impressosPontoDigital; //OK
    private boolean gerarNumeracaoAtas; //OK
    private boolean gerarNumeracaoEditais; //OK
    private boolean gerarNumeracaoInstrucaoNormativa; //OK
    private boolean gerarNumeracaoOficiosGeral; //OK
    private boolean gerarNumeracaoPortarias; //OK
    private boolean gerarNumeracaoResolucoes; //OK
    private boolean permitirRecarga; //OK
    private boolean solicitarRecarga; //OK
    private boolean solicitarRemanufatura; //OK
    private boolean visualizarLog; //OK
    private boolean visualizarTodosAgendamentosOficio; //OK
    private boolean visualizarTodosAtas; //OK
    private boolean visualizarTodosEditais; //OK
    private boolean visualizarTodosInstrucoesNormativas; //OK
    private boolean visualizarTodosOficiosGeral; //OK
    private boolean visualizarTodosPortarias; //OK
    private boolean visualizarTodosResolucoes; //OK
    private Usuario usuario;

    @Id
    @SequenceGenerator(name = "SEQUENCE_PERMISSOES", sequenceName = "permissoes_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_PERMISSOES")
    @Column(name = "codigopermissoes", unique = true, nullable = false)
    public int getCodigoPermissoes() {
        return codigoPermissoes;
    }

    public void setCodigoPermissoes(int codigoPermissoes) {
        this.codigoPermissoes = codigoPermissoes;
    }
    
    @Column(name = "agendaragendamento", nullable = false)
    public boolean isAgendarAgendamento() {
        return agendarAgendamento;
    }

    public void setAgendarAgendamento(boolean agendarAgendamento) {
        this.agendarAgendamento = agendarAgendamento;
    }

    @Column(name = "agendarmultimidia", nullable = false)
    public boolean isAgendarEquipamento() {
        return agendarEquipamento;
    }

    public void setAgendarEquipamento(boolean agendarEquipamento) {
        this.agendarEquipamento = agendarEquipamento;
    }

    @Column(name = "cadastraraluno", nullable = false)
    public boolean isCadastrarAluno() {
        return cadastrarAluno;
    }

    public void setCadastrarAluno(boolean cadastrarAluno) {
        this.cadastrarAluno = cadastrarAluno;
    }

    @Column(name = "cadastrarbloco", nullable = false)
    public boolean isCadastrarBloco() {
        return cadastrarBloco;
    }

    public void setCadastrarBloco(boolean cadastrarBloco) {
        this.cadastrarBloco = cadastrarBloco;
    }

    @Column(name = "cadastrarlinha", nullable = false)
    public boolean isCadastrarLinha() {
        return cadastrarLinha;
    }

    public void setCadastrarLinha(boolean cadastrarLinha) {
        this.cadastrarLinha = cadastrarLinha;
    }

    @Column(name = "cadastrarlote", nullable = false)
    public boolean isCadastrarLote() {
        return cadastrarLote;
    }

    public void setCadastrarLote(boolean cadastrarLote) {
        this.cadastrarLote = cadastrarLote;
    }

    @Column(name = "cadastrarcartucho", nullable = false)
    public boolean isCadastrarCartucho() {
        return cadastrarCartucho;
    }

    public void setCadastrarCartucho(boolean cadastrarCartucho) {
        this.cadastrarCartucho = cadastrarCartucho;
    }

    @Column(name = "cadastrarcmei", nullable = false)
    public boolean isCadastrarCmei() {
        return cadastrarCmei;
    }

    public void setCadastrarCmei(boolean cadastrarCmei) {
        this.cadastrarCmei = cadastrarCmei;
    }

    @Column(name = "cadastrarequipamentounidade", nullable = false)
    public boolean isCadastrarEquipamentoUnidade() {
        return cadastrarEquipamentoUnidade;
    }

    public void setCadastrarEquipamentoUnidade(boolean cadastrarEquipamentoUnidade) {
        this.cadastrarEquipamentoUnidade = cadastrarEquipamentoUnidade;
    }

    @Column(name = "cadastrarescola", nullable = false)
    public boolean isCadastrarEscola() {
        return cadastrarEscola;
    }

    public void setCadastrarEscola(boolean cadastrarEscola) {
        this.cadastrarEscola = cadastrarEscola;
    }

    @Column(name = "cadastrarendereco", nullable = false)
    public boolean isCadastrarEndereco() {
        return cadastrarEndereco;
    }

    public void setCadastrarEndereco(boolean cadastrarEndereco) {
        this.cadastrarEndereco = cadastrarEndereco;
    }

    @Column(name = "cadastrarmultimidia", nullable = false)
    public boolean isCadastrarEquipamento() {
        return cadastrarEquipamento;
    }

    public void setCadastrarEquipamento(boolean cadastrarEquipamento) {
        this.cadastrarEquipamento = cadastrarEquipamento;
    }

    @Column(name = "cadastraroutros", nullable = false)
    public boolean isCadastrarOutros() {
        return cadastrarOutros;
    }

    public void setCadastrarOutros(boolean cadastrarOutros) {
        this.cadastrarOutros = cadastrarOutros;
    }

    @Column(name = "cadastrartipoequipamento", nullable = false)
    public boolean isCadastrarTipoEquipamento() {
        return cadastrarTipoEquipamento;
    }

    public void setCadastrarTipoEquipamento(boolean cadastrarTipoEquipamento) {
        this.cadastrarTipoEquipamento = cadastrarTipoEquipamento;
    }

    @Column(name = "cadastrarusuario", nullable = false)
    public boolean isCadastrarUsuario() {
        return cadastrarUsuario;
    }

    public void setCadastrarUsuario(boolean cadastrarUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
    }

    @Column(name = "entregarprotocoloremanufaturados", nullable = false)
    public boolean isEntregarProtocoloRemanufaturados() {
        return entregarProtocoloRemanufaturados;
    }

    public void setEntregarProtocoloRemanufaturados(boolean entregarProtocoloRemanufaturados) {
        this.entregarProtocoloRemanufaturados = entregarProtocoloRemanufaturados;
    }

    @Column(name = "gerarnumeracaoatas", nullable = false)
    public boolean isGerarNumeracaoAtas() {
        return gerarNumeracaoAtas;
    }

    public void setGerarNumeracaoAtas(boolean gerarNumeracaoAtas) {
        this.gerarNumeracaoAtas = gerarNumeracaoAtas;
    }
    
    @Column(name = "gerarnumeracaoinstrucaonormativa", nullable = false)
    public boolean isGerarNumeracaoInstrucaoNormativa() {
        return gerarNumeracaoInstrucaoNormativa;
    }

    public void setGerarNumeracaoInstrucaoNormativa(boolean gerarNumeracaoInstrucaoNormativa) {
        this.gerarNumeracaoInstrucaoNormativa = gerarNumeracaoInstrucaoNormativa;
    }
    
    @Column(name = "gerarnumeracaooficiosgeral", nullable = false)
    public boolean isGerarNumeracaoOficiosGeral() {
        return gerarNumeracaoOficiosGeral;
    }

    public void setGerarNumeracaoOficiosGeral(boolean gerarNumeracaoOficiosGeral) {
        this.gerarNumeracaoOficiosGeral = gerarNumeracaoOficiosGeral;
    }

    @Column(name = "gerarnumeracaoportarias", nullable = false)
    public boolean isGerarNumeracaoPortarias() {
        return gerarNumeracaoPortarias;
    }

    public void setGerarNumeracaoPortarias(boolean gerarNumeracaoPortarias) {
        this.gerarNumeracaoPortarias = gerarNumeracaoPortarias;
    }

    @Column(name = "impressosagendamento", nullable = false)
    public boolean isImpressosAgendamento() {
        return impressosAgendamento;
    }

    public void setImpressosAgendamento(boolean impressosAgendamento) {
        this.impressosAgendamento = impressosAgendamento;
    }

    @Column(name = "impressoscmei", nullable = false)
    public boolean isImpressosCmei() {
        return impressosCmei;
    }

    public void setImpressosCmei(boolean impressosCmei) {
        this.impressosCmei = impressosCmei;
    }

    @Column(name = "impressosescola", nullable = false)
    public boolean isImpressosEscola() {
        return impressosEscola;
    }

    public void setImpressosEscola(boolean impressosEscola) {
        this.impressosEscola = impressosEscola;
    }

    @Column(name = "impressosmultimidia", nullable = false)
    public boolean isImpressosEquipamento() {
        return impressosEquipamento;
    }

    public void setImpressosEquipamento(boolean impressosEquipamento) {
        this.impressosEquipamento = impressosEquipamento;
    }

    @Column(name = "impressosoutros", nullable = false)
    public boolean isImpressosOutros() {
        return impressosOutros;
    }

    public void setImpressosOutros(boolean impressosOutros) {
        this.impressosOutros = impressosOutros;
    }

    @Column(name = "impressospontodigital", nullable = false)
    public boolean isImpressosPontoDigital() {
        return impressosPontoDigital;
    }

    public void setImpressosPontoDigital(boolean impressosPontoDigital) {
        this.impressosPontoDigital = impressosPontoDigital;
    }

    @Column(name = "impressosrecarga", nullable = false)
    public boolean isImpressosRecarga() {
        return impressosRecarga;
    }

    public void setImpressosRecarga(boolean impressosRecarga) {
        this.impressosRecarga = impressosRecarga;
    }

    @Column(name = "permitirrecarga", nullable = false)
    public boolean isPermitirRecarga() {
        return permitirRecarga;
    }

    public void setPermitirRecarga(boolean permitirRecarga) {
        this.permitirRecarga = permitirRecarga;
    }

    @Column(name = "visualizartodosatas", nullable = false)
    public boolean isVisualizarTodosAtas() {
        return visualizarTodosAtas;
    }

    public void setVisualizarTodosAtas(boolean visualizarTodosAtas) {
        this.visualizarTodosAtas = visualizarTodosAtas;
    }

    /*@Column(name = "visualizartodosoficiosadministrativo", nullable = false)
    public boolean isVisualizarTodosOficiosAdministrativo() {
        return visualizarTodosOficiosAdministrativo;
    }

    public void setVisualizarTodosOficiosAdministrativo(boolean visualizarTodosOficiosAdministrativo) {
        this.visualizarTodosOficiosAdministrativo = visualizarTodosOficiosAdministrativo;
    }*/

    @Column(name = "visualizartodosoficiosgeral", nullable = false)
    public boolean isVisualizarTodosOficiosGeral() {
        return visualizarTodosOficiosGeral;
    }

    public void setVisualizarTodosOficiosGeral(boolean visualizarTodosOficiosGeral) {
        this.visualizarTodosOficiosGeral = visualizarTodosOficiosGeral;
    }

    /*@Column(name = "visualizartodosoficiosinformatica", nullable = false)
    public boolean isVisualizarTodosOficiosInformatica() {
        return visualizarTodosOficiosInformatica;
    }

    public void setVisualizarTodosOficiosInformatica(boolean visualizarTodosOficiosInformatica) {
        this.visualizarTodosOficiosInformatica = visualizarTodosOficiosInformatica;
    }*/

    @Column(name = "visualizartodosportarias", nullable = false)
    public boolean isVisualizarTodosPortarias() {
        return visualizarTodosPortarias;
    }

    public void setVisualizarTodosPortarias(boolean visualizarTodosPortarias) {
        this.visualizarTodosPortarias = visualizarTodosPortarias;
    }

    @Column(name = "agendaragendamentobuscar", nullable = false)
    public boolean isAgendarAgendamentoBuscar() {
        return agendarAgendamentoBuscar;
    }

    public void setAgendarAgendamentoBuscar(boolean agendarAgendamentoBuscar) {
        this.agendarAgendamentoBuscar = agendarAgendamentoBuscar;
    }

    @Column(name = "agendaragendamentopontodigital", nullable = false)
    public boolean isAgendarAgendamentoPontoDigital() {
        return agendarAgendamentoPontoDigital;
    }

    public void setAgendarAgendamentoPontoDigital(boolean agendarAgendamentoPontoDigital) {
        this.agendarAgendamentoPontoDigital = agendarAgendamentoPontoDigital;
    }

    @Column(name = "gerarnumeracaoresolucoes", nullable = false)
    public boolean isGerarNumeracaoResolucoes() {
        return gerarNumeracaoResolucoes;
    }

    public void setGerarNumeracaoResolucoes(boolean gerarNumeracaoResolucoes) {
        this.gerarNumeracaoResolucoes = gerarNumeracaoResolucoes;
    }

    @Column(name = "visualizartodosresolucoes", nullable = false)
    public boolean isVisualizarTodosResolucoes() {
        return visualizarTodosResolucoes;
    }

    public void setVisualizarTodosResolucoes(boolean visualizarTodosResolucoes) {
        this.visualizarTodosResolucoes = visualizarTodosResolucoes;
    }

    @Column(name = "cadastrardepartamentodivisaosetor", nullable = false)
    public boolean isCadastrarDepartamentoDivisaoSetor() {
        return cadastrarDepartamentoDivisaoSetor;
    }

    public void setCadastrarDepartamentoDivisaoSetor(boolean cadastrarDepartamentoDivisaoSetor) {
        this.cadastrarDepartamentoDivisaoSetor = cadastrarDepartamentoDivisaoSetor;
    }

    @Column(name = "gerarnumeracaoeditais", nullable = false)
    public boolean isGerarNumeracaoEditais() {
        return gerarNumeracaoEditais;
    }

    public void setGerarNumeracaoEditais(boolean gerarNumeracaoEditais) {
        this.gerarNumeracaoEditais = gerarNumeracaoEditais;
    }

    @Column(name = "visualizartodoseditais", nullable = false)
    public boolean isVisualizarTodosEditais() {
        return visualizarTodosEditais;
    }

    public void setVisualizarTodosEditais(boolean visualizarTodosEditais) {
        this.visualizarTodosEditais = visualizarTodosEditais;
    }

    @Column(name = "visualizartodosinstrucoesnormativas", nullable = false)
    public boolean isVisualizarTodosInstrucoesNormativas() {
        return visualizarTodosInstrucoesNormativas;
    }

    public void setVisualizarTodosInstrucoesNormativas(boolean visualizarTodosInstrucoesNormativas) {
        this.visualizarTodosInstrucoesNormativas = visualizarTodosInstrucoesNormativas;
    }
    
    @Column(name = "visualizarlog", nullable = false)
    public boolean isVisualizarLog() {
        return visualizarLog;
    }

    public void setVisualizarLog(boolean visualizarLog) {
        this.visualizarLog = visualizarLog;
    }

    @Column(name = "impressoslog", nullable = false)
    public boolean isImpressosLog() {
        return impressosLog;
    }

    public void setImpressosLog(boolean impressosLog) {
        this.impressosLog = impressosLog;
    }

    @Column(name = "solicitarrecarga", nullable = false)
    public boolean isSolicitarRecarga() {
        return solicitarRecarga;
    }

    public void setSolicitarRecarga(boolean solicitarRecarga) {
        this.solicitarRecarga = solicitarRecarga;
    }

    @Column(name = "solicitarremanufatura", nullable = false)
    public boolean isSolicitarRemanufatura() {
        return solicitarRemanufatura;
    }

    public void setSolicitarRemanufatura(boolean solicitarRemanufatura) {
        this.solicitarRemanufatura = solicitarRemanufatura;
    }

    @Column(name = "agendaragendamentooficio", nullable = false)
    public boolean isAgendarAgendamentoOficio() {
        return agendarAgendamentoOficio;
    }

    public void setAgendarAgendamentoOficio(boolean agendarAgendamentoOficio) {
        this.agendarAgendamentoOficio = agendarAgendamentoOficio;
    }

    @Column(name = "visualizartodosagendamentosoficio", nullable = false)
    public boolean isVisualizarTodosAgendamentosOficio() {
        return visualizarTodosAgendamentosOficio;
    }

    public void setVisualizarTodosAgendamentosOficio(boolean visualizarTodosAgendamentosOficio) {
        this.visualizarTodosAgendamentosOficio = visualizarTodosAgendamentosOficio;
    }

    @Column(name = "cadastrarmodelocartucho", nullable = false)
    public boolean isCadastrarModeloCartucho() {
        return cadastrarModeloCartucho;
    }

    public void setCadastrarModeloCartucho(boolean cadastrarModeloCartucho) {
        this.cadastrarModeloCartucho = cadastrarModeloCartucho;
    }

    @Column(name = "colocarematendimentoagendamento", nullable = false)
    public boolean isColocarEmAtendimentoAgendamento() {
        return colocarEmAtendimentoAgendamento;
    }

    public void setColocarEmAtendimentoAgendamento(boolean colocarEmAtendimentoAgendamento) {
        this.colocarEmAtendimentoAgendamento = colocarEmAtendimentoAgendamento;
    }

    @Column(name = "colocarematendimentoagendamentooficio", nullable = false)
    public boolean isColocarEmAtendimentoAgendamentoOficio() {
        return colocarEmAtendimentoAgendamentoOficio;
    }

    public void setColocarEmAtendimentoAgendamentoOficio(boolean colocarEmAtendimentoAgendamentoOficio) {
        this.colocarEmAtendimentoAgendamentoOficio = colocarEmAtendimentoAgendamentoOficio;
    }

    @Column(name = "colocarematendimentoagendamentopontodigital", nullable = false)
    public boolean isColocarEmAtendimentoAgendamentoPontoDigital() {
        return colocarEmAtendimentoAgendamentoPontoDigital;
    }

    public void setColocarEmAtendimentoAgendamentoPontoDigital(boolean colocarEmAtendimentoAgendamentoPontoDigital) {
        this.colocarEmAtendimentoAgendamentoPontoDigital = colocarEmAtendimentoAgendamentoPontoDigital;
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
