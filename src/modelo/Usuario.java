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
 * @author luiz
 */

@Entity
@Table(name = "usuario", schema = "public")
public class Usuario implements java.io.Serializable {

    private int codigoUsuario;
    private String nomeUsuario;//240
    private String matricula;//10
    private String senha;//200
    private String contraSenha;//120
    private String celular;//13
    private String temaEscolhido;//30
    private String emailUsuario;//240
    private boolean usuarioInativo;
    private DepartamentoDivisaoSetor departamentoDivisaoSetor;
    
    public Usuario() {
        
    }
    
    public Usuario(int codigoUsuario, String nomeUsuario, String matricula, String senha, String contraSenha, String celular, String temaEscolhido, String emailUsuario,
            boolean usuarioInativo, DepartamentoDivisaoSetor departamentoDivisaoSetor) {
        
        this.codigoUsuario = codigoUsuario;
        this.celular = celular;
        this.contraSenha = contraSenha;
        this.departamentoDivisaoSetor = departamentoDivisaoSetor;
        this.emailUsuario = emailUsuario;
        this.matricula = matricula;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.temaEscolhido = temaEscolhido;
        this.usuarioInativo = usuarioInativo;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_USUARIO", sequenceName = "usuario_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_USUARIO")
    @Column(name = "codigousuario", unique = true, nullable = false)
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
    @Column(name = "matricula", nullable = false, length = 10)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Column(name = "nomeusuario", nullable = false, length = 240)
    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    @Column(name = "senha", nullable = false, length = 200)
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Column(name = "celular", nullable = false, length = 13)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Column(name = "contrasenha", nullable = false, length = 120)
    public String getContraSenha() {
        return contraSenha;
    }

    public void setContraSenha(String contraSenha) {
        this.contraSenha = contraSenha;
    }

    @Column(name = "temaescolhido", nullable = false, length = 30)
    public String getTemaEscolhido() {
        return temaEscolhido;
    }

    public void setTemaEscolhido(String temaEscolhido) {
        this.temaEscolhido = temaEscolhido;
    }

    @Column(name = "usuarioinativo", nullable = false)
    public boolean isUsuarioInativo() {
        return usuarioInativo;
    }

    public void setUsuarioInativo(boolean usuarioInativo) {
        this.usuarioInativo = usuarioInativo;
    }

    @Column(name = "emailusuario", nullable = false, length = 240)
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    @OneToOne
    @JoinColumn(name = "departamentodivisaosetor_codigodepartamentodivisaosetor", insertable = true, updatable = false)
    public DepartamentoDivisaoSetor getDepartamentoDivisaoSetor() {
        return departamentoDivisaoSetor;
    }

    public void setDepartamentoDivisaoSetor(DepartamentoDivisaoSetor departamentoDivisaoSetor) {
        this.departamentoDivisaoSetor = departamentoDivisaoSetor;
    }

}
