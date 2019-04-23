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
@Table(name = "aluno", schema = "public")
public class Aluno implements java.io.Serializable {

    private int codigoAluno;
    private String nomeAluno; //120
    private String sexo; //15
    private String filiacaoPai; //120
    private String filiacaoMae; //120
    private String serie; //15
    private String nivel; //30
    private String tipoEntidade; //10
    private String turno; //30
    private String informacoes; //400
    private Date dataCadastro; 
    private Date dataNascimento;
    private Bloco bloco;
    private Cmei cmei;
    private Escola escola;
    private Linha linha;
    private Lote lote;
    private Outro outro;

    public Aluno() {
        
    }
    
    public Aluno(int codigoAluno, String nomeAluno, String sexo, String filiacaoPai, String filiacaoMae, String serie, String nivel, String tipoEntidade, String turno,
            String informacoes, Date dataCadastro, Date dataNascimento, Date dataDesistencia, Date dataEgresso, Bloco bloco, Cmei cmei, Escola escola, Linha linha, Lote lote, Outro outro) {
        
        this.bloco = bloco;
        this.codigoAluno = codigoAluno;
        this.cmei = cmei;
        this.dataCadastro = dataCadastro;
        this.dataNascimento = dataNascimento;
        this.escola = escola;
        this.filiacaoMae = filiacaoMae;
        this.filiacaoPai = filiacaoPai;
        this.informacoes = informacoes;
        this.linha = linha;
        this.lote = lote;
        this.nivel = nivel;
        this.nomeAluno = nomeAluno;
        this.outro = outro;
        this.serie = serie;
        this.sexo = sexo;
        this.tipoEntidade = tipoEntidade;
        this.turno = turno;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_ALUNO", sequenceName = "aluno_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ALUNO")
    @Column(name = "codigoaluno", unique = true, nullable = false)
    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datanascimento", nullable = false, length = 13)
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Column(name = "nivel", nullable = false, length = 30)
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Column(name = "nomealuno", nullable = false, length = 120)
    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    @Column(name = "filiacaomae", nullable = false, length = 120)
    public String getFiliacaoMae() {
        return filiacaoMae;
    }

    public void setFiliacaoMae(String filiacaoMae) {
        this.filiacaoMae = filiacaoMae;
    }

    @Column(name = "filiacaopai", nullable = false, length = 120)
    public String getFiliacaoPai() {
        return filiacaoPai;
    }

    public void setFiliacaoPai(String filiacaoPai) {
        this.filiacaoPai = filiacaoPai;
    }

    @Column(name = "serie", nullable = false, length = 15)
    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Column(name = "sexo", nullable = false, length = 15)
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Column(name = "tipoentidade", nullable = false, length = 10)
    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }
    
    @Column(name = "turno", nullable = false, length = 30)
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datacadastro", nullable = false, length = 13)
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Column(name = "informacoes", nullable = false, length = 400)
    public String getInformacoes() {
        return informacoes;
    }

    public void setInformacoes(String informacoes) {
        this.informacoes = informacoes;
    }

    @OneToOne
    @JoinColumn(name = "bloco_codigobloco", insertable = true, updatable = true)
    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
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
    @JoinColumn(name = "linha_codigolinha", insertable = true, updatable = true)
    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    @OneToOne
    @JoinColumn(name = "lote_codigolote", insertable = true, updatable = true)
    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
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
