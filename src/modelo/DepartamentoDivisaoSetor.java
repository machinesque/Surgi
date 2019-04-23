/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "departamentodivisaosetor", schema = "public")
public class DepartamentoDivisaoSetor implements java.io.Serializable {
    
    private int codigoDepartamentoDivisaoSetor;
    private String nomeDepartamentoDivisaoSetor;//120

    public DepartamentoDivisaoSetor() {
        
    }
    
     public DepartamentoDivisaoSetor(int codigoDepartamentoDivisaoSetor, String nomeDepartamentoDivisaoSetor) {
        
         this.codigoDepartamentoDivisaoSetor = codigoDepartamentoDivisaoSetor;
         this.nomeDepartamentoDivisaoSetor = nomeDepartamentoDivisaoSetor;
         
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_DEPARTAMENTODIVISAOSETOR", sequenceName = "departamentodivisaosetor_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_DEPARTAMENTODIVISAOSETOR")
    @Column(name = "codigodepartamentodivisaosetor", unique = true, nullable = false)
    public int getCodigoDepartamentoDivisaoSetor() {
        return codigoDepartamentoDivisaoSetor;
    }

    public void setCodigoDepartamentoDivisaoSetor(int codigoDepartamentoDivisaoSetor) {
        this.codigoDepartamentoDivisaoSetor = codigoDepartamentoDivisaoSetor;
    }

    @Column(name = "nomedepartamentodivisaosetor", nullable = false, length = 120)
    public String getNomeDepartamentoDivisaoSetor() {
        return nomeDepartamentoDivisaoSetor;
    }

    public void setNomeDepartamentoDivisaoSetor(String nomeDepartamentoDivisaoSetor) {
        this.nomeDepartamentoDivisaoSetor = nomeDepartamentoDivisaoSetor;
    }
    
}
