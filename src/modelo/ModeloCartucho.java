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
@Table(name = "modelocartucho", schema = "public")
public class ModeloCartucho implements java.io.Serializable {
    
    private int codigoModeloCartucho;
    private String nomeModeloCartucho;//60
    
    public ModeloCartucho() {
        
    }
    
    public ModeloCartucho(int codigoModeloCartucho, String nomeModeloCartucho) {
        
        this.codigoModeloCartucho = codigoModeloCartucho;
        this.nomeModeloCartucho = nomeModeloCartucho;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_MODELOCARTUCHO", sequenceName = "modelocartucho_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE_MODELOCARTUCHO")
    @Column(name = "codigomodelocartucho", unique = true, nullable = false)
    public int getCodigoModeloCartucho() {
        return codigoModeloCartucho;
    }

    public void setCodigoModeloCartucho(int codigoModeloCartucho) {
        this.codigoModeloCartucho = codigoModeloCartucho;
    }

    @Column(name = "nomemodelocartucho", nullable = false, length = 60)
    public String getNomeModeloCartucho() {
        return nomeModeloCartucho;
    }

    public void setNomeModeloCartucho(String nomeModeloCartucho) {
        this.nomeModeloCartucho = nomeModeloCartucho;
    }
    
}