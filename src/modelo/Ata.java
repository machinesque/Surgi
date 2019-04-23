/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "ata", schema = "public")
public class Ata {
    
    private int codigoAta;
    private int numeroAta;
    private int numeroModalidade;
    private int numeroProcesso;
    private String ano;
    private String objeto;
    private boolean emailEnviado;
    private boolean finalizado;
    private Date dataPublicacaoVencimento;
    private Usuario usuario;
    
    public Ata() {
        
    }
    
    public Ata(int codigoAta, int numeroAta, int numeroModalidade, int numeroProcesso, String ano, String objeto, boolean finalizado, Date dataPublicacaoVencimento, Usuario usuario) {
        
        this.ano = ano;
        this.codigoAta = codigoAta;
        this.dataPublicacaoVencimento = dataPublicacaoVencimento;
        this.finalizado = finalizado;
        this.numeroAta = numeroAta;
        this.numeroModalidade = numeroModalidade;
        this.numeroProcesso = numeroProcesso;
        this.objeto = objeto;
        this.usuario = usuario;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_ATA", sequenceName = "ata_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ATA")
    @Column(name = "codigoata", unique = true, nullable = false)
    public int getCodigoAta() {
        return codigoAta;
    }

    public void setCodigoAta(int codigoAta) {
        this.codigoAta = codigoAta;
    }

    @Column(name = "numeroata", nullable = false)
    public int getNumeroAta() {
        return numeroAta;
    }

    public void setNumeroAta(int numeroAta) {
        this.numeroAta = numeroAta;
    }

    @Column(name = "numeromodalidade", nullable = false)
    public int getNumeroModalidade() {
        return numeroModalidade;
    }

    public void setNumeroModalidade(int numeroModalidade) {
        this.numeroModalidade = numeroModalidade;
    }

    @Column(name = "numeroprocesso", nullable = false)
    public int getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(int numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    @Column(name = "ano", nullable = false, length = 4)
    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    @Column(name = "objeto", nullable = false, length = 240)
    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    @Column(name = "emailenviado")
    public boolean isEmailEnviado() {
        return emailEnviado;
    }

    public void setEmailEnviado(boolean emailEnviado) {
        this.emailEnviado = emailEnviado;
    }

    @Column(name = "finalizado", nullable = false)
    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datapublicacaovencimento", nullable = false, length = 13)
    public Date getDataPublicacaoVencimento() {
        return dataPublicacaoVencimento;
    }

    public void setDataPublicacaoVencimento(Date dataPublicacaoVencimento) {
        this.dataPublicacaoVencimento = dataPublicacaoVencimento;
    }

    @OneToOne
    @JoinColumn(name = "usuario_codigousuario", insertable = true, updatable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
