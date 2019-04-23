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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "contrasenha", schema = "public")
public class ContraSenha implements java.io.Serializable {

    private int codigoContraSenha;
    private String contraSenha;//120
    private String tipoContraSenha;//60

    public ContraSenha() {
        
    }
    
    public ContraSenha(int codigoContraSenha, String contraSenha, String tipoContraSenha) {
        
        this.codigoContraSenha = codigoContraSenha;
        this.contraSenha = contraSenha;
        this.tipoContraSenha = tipoContraSenha;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_CONTRASENHA", sequenceName = "contrasenha_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CONTRASENHA")
    @Column(name = "codigocontrasenha", unique = true, nullable = false)
    public int getCodigoContraSenha() {
        return codigoContraSenha;
    }

    public void setCodigoContraSenha(int codigoContraSenha) {
        this.codigoContraSenha = codigoContraSenha;
    }

    @Column(name = "contrasenha", nullable = false, length = 120)
    public String getContraSenha() {
        return contraSenha;
    }

    public void setContraSenha(String contraSenha) {
        this.contraSenha = contraSenha;
    }

    @Column(name = "tipocontrasenha", nullable = false, length = 60)
    public String getTipoContraSenha() {
        return tipoContraSenha;
    }

    public void setTipoContraSenha(String tipoContraSenha) {
        this.tipoContraSenha = tipoContraSenha;
    }



}
