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
@Table(name = "log", schema = "public")
public class Log2 implements java.io.Serializable {

    private int codigoLog2;
    private String acao;
    private Date dataAcao;
    private String telaJanela;
    private Usuario usuario;

    public Log2() {
    }

    public Log2(int codigoLog2, String acao, Date dataAcao, String telaJanela) {
        this.codigoLog2 = codigoLog2;
        this.acao = acao;
        this.dataAcao = dataAcao;
        this.telaJanela = telaJanela;
    }

    public Log2(int codigoLog2, String acao, Date dataAcao, String telaJanela, Usuario usuario) {
        this.codigoLog2 = codigoLog2;
        this.acao = acao;
        this.dataAcao = dataAcao;
        this.telaJanela = telaJanela;
        this.usuario = usuario;
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_LOG2", sequenceName = "log2_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_LOG2")
    @Column(name = "codigolog2", unique = true, nullable = false)
    public int getCodigoLog2() {
        return this.codigoLog2;
    }

    public void setCodigoLog2(int codigoLog2) {
        this.codigoLog2 = codigoLog2;
    }

    @Column(name = "acao", nullable = false, length = 500)
    public String getAcao() {
        return this.acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataacao", nullable = false, length = 13)
    public Date getDataAcao() {
        return this.dataAcao;
    }

    public void setDataAcao(Date dataAcao) {
        this.dataAcao = dataAcao;
    }

    @Column(name = "telajanela", nullable = false, length = 60)
    public String getTelaJanela() {
        return this.telaJanela;
    }

    public void setTelaJanela(String telaJanela) {
        this.telaJanela = telaJanela;
    }

    @OneToOne
    @JoinColumn(name = "usuario_codigousuario", insertable = false, updatable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
