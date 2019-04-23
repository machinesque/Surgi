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
@Table(name = "endereco", schema = "public")
public class Endereco implements java.io.Serializable {

    private int codigoEndereco;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String endereco;
    private String numeroEndereco;
    private String tipoCadastro; // Aluno, Cmei, Escola ou Outro
    private String tipoEndereco;
    private String uf;
    private Aluno aluno;
    private Cmei cmei;
    private Escola escola;
    private Outro outro;

    public Endereco() {
    }

    public Endereco(int codigoEndereco, String bairro, String cep, String cidade, String complemento, String endereco, String numeroEndereco, String uf) {
        
        this.codigoEndereco = codigoEndereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.uf = uf;
        
    }

    public Endereco(int codigoEndereco, String bairro, String cep, String cidade, String complemento, String endereco, String numeroEndereco, String tipoEndereco, 
            String uf, Aluno aluno, Cmei cmei, Escola escola, Outro outro) {
        
        this.codigoEndereco = codigoEndereco;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.complemento = complemento;
        this.endereco = endereco;
        this.numeroEndereco = numeroEndereco;
        this.tipoEndereco = tipoEndereco;
        this.uf = uf;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_ENDERECO", sequenceName = "endereco_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ENDERECO")
    @Column(name = "codigoendereco", unique = true, nullable = false)
    public int getCodigoEndereco() {
        return this.codigoEndereco;
    }

    public void setCodigoEndereco(int codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    @Column(name = "bairro", nullable = false, length = 120)
    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Column(name = "cep", nullable = false, length = 10)
    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Column(name = "cidade", nullable = false, length = 240)
    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Column(name = "complemento", nullable = false, length = 60)
    public String getComplemento() {
        return this.complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Column(name = "endereco", nullable = false, length = 240)
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "numeroendereco", nullable = false, length = 10)
    public String getNumeroEndereco() {
        return this.numeroEndereco;
    }

    public void setNumeroEndereco(String numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    @Column(name = "tipocadastro", nullable = false, length = 10)
     public String getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(String tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }
    
    @Column(name = "tipoendereco", nullable = false, length = 15)
    public String getTipoEndereco() {
        return this.tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    @Column(name = "uf", nullable = false, length = 2)
    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @OneToOne
    @JoinColumn(name = "aluno_codigoaluno", insertable = true, updatable = false)
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @OneToOne
    @JoinColumn(name = "cmei_codigocmei", insertable = true, updatable = false)
    public Cmei getCmei() {
        return cmei;
    }

    public void setCmei(Cmei cmei) {
        this.cmei = cmei;
    }

    @OneToOne
    @JoinColumn(name = "escola_codigoescola", insertable = true, updatable = false)
    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @OneToOne
    @JoinColumn(name = "outro_codigooutro", insertable = true, updatable = false)
    public Outro getOutro() {
        return outro;
    }

    public void setOutro(Outro outro) {
        this.outro = outro;
    }
    
}
