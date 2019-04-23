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

/**.
 *
 * @author luizam
 */

@Entity
@Table(name = "tipoequipamento", schema = "public")
public class TipoEquipamento implements java.io.Serializable {

    private int codigoTipoEquipamento;
    private String nomeTipoEquipamento;//120

    public TipoEquipamento() {
        
    }
    
    public TipoEquipamento(int codigoTipoEquipamento, String nomeTipoEquipamento) {
        
        this.codigoTipoEquipamento = codigoTipoEquipamento;
        this.nomeTipoEquipamento = nomeTipoEquipamento;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_TIPOEQUIPAMENTO", sequenceName = "tipoequipamento_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TIPOEQUIPAMENTO")
    @Column(name = "codigotipoequipamento", unique = true, nullable = false)
    public int getCodigoTipoEquipamento() {
        return codigoTipoEquipamento;
    }

    public void setCodigoTipoEquipamento(int codigoTipoEquipamento) {
        this.codigoTipoEquipamento = codigoTipoEquipamento;
    }

    @Column(name = "nometipoequipamento", nullable = false, length = 120)
    public String getNomeTipoEquipamento() {
        return nomeTipoEquipamento;
    }

    public void setNomeTipoEquipamento(String nomeTipoEquipamento) {
        this.nomeTipoEquipamento = nomeTipoEquipamento;
    }
    
}
