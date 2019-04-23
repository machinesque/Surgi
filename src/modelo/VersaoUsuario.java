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
@Table(name = "versaousuario", schema = "public")
public class VersaoUsuario implements java.io.Serializable {
    
    private int codigoVersaoUsuario;
    private String versaoAtual;//10
    private Date dataAtualizacao;
    private Usuario usuario;

    @Id
    @SequenceGenerator(name = "SEQUENCE_VERSAOUSUARIO", sequenceName = "versaousuario_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_VERSAOUSUARIO")
    @Column(name = "codigoversaousuario", unique = true, nullable = false)
    public int getCodigoVersaoUsuario() {
        return codigoVersaoUsuario;
    }

    public void setCodigoVersaoUsuario(int codigoVersaoUsuario) {
        this.codigoVersaoUsuario = codigoVersaoUsuario;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "dataatualizacao", nullable = false, length = 13)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Column(name = "versaoatual", nullable = false, length = 10)
    public String getVersaoAtual() {
        return versaoAtual;
    }

    public void setVersaoAtual(String versaoAtual) {
        this.versaoAtual = versaoAtual;
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
