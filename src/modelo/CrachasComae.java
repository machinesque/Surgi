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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luizam
 */
@Entity
@Table(name = "crachacomae", schema = "public")
public class CrachasComae implements java.io.Serializable {
    
    private int codigoCrachaComae;
    private String cargoCracha1;
    private String cargoCracha2;
    private String cargoCracha3;
    private String cargoCracha4;
    private String representacao1;
    private String representacao2;
    private String representacao3;
    private String representacao4;
    private String nomeCracha1;
    private String nomeCracha2;
    private String nomeCracha3;
    private String nomeCracha4;
    private boolean impresso;
    private Date dataCracha;
    private Date dataEntrega;

    public CrachasComae() {
        
    }
    
    public CrachasComae(int codigoCrachaComae, String cargoCracha1, String cargoCracha2, String cargoCracha3, String cargoCracha4, String representacao1, String representacao2, 
            String representacao3, String representacao4, String nomeCracha1, String nomeCracha2, String nomeCracha3, String nomeCracha4, boolean impresso, Date dataCracha, Date dataEntrega) {
        
        this.cargoCracha1 = cargoCracha1;
        this.cargoCracha2 = cargoCracha2;
        this.cargoCracha3 = cargoCracha3;
        this.cargoCracha4 = cargoCracha4;
        this.codigoCrachaComae = codigoCrachaComae;
        this.dataCracha = dataCracha;
        this.dataEntrega = dataEntrega;
        this.representacao1 = representacao1;
        this.representacao2 = representacao2;
        this.representacao3 = representacao3;
        this.representacao4 = representacao4;
        this.impresso = impresso;
        this.nomeCracha1 = nomeCracha1;
        this.nomeCracha2 = nomeCracha2;
        this.nomeCracha3 = nomeCracha3;
        this.nomeCracha4 = nomeCracha4;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_CRACHACOMAE", sequenceName = "crachacomae_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CRACHACOMAE")
    @Column(name = "codigocrachacomae", unique = true, nullable = false)
    public int getCodigoCrachaComae() {
        return codigoCrachaComae;
    }

    public void setCodigoCrachaComae(int codigoCrachas) {
        this.codigoCrachaComae = codigoCrachas;
    }

    @Column(name = "cargocracha1", nullable = false, length = 30)
    public String getCargoCracha1() {
        return cargoCracha1;
    }

    public void setCargoCracha1(String cargoCracha1) {
        this.cargoCracha1 = cargoCracha1;
    }

    @Column(name = "cargocracha2", nullable = false, length = 30)
    public String getCargoCracha2() {
        return cargoCracha2;
    }

    public void setCargoCracha2(String cargoCracha2) {
        this.cargoCracha2 = cargoCracha2;
    }

    @Column(name = "cargocracha3", nullable = false, length = 30)
    public String getCargoCracha3() {
        return cargoCracha3;
    }

    public void setCargoCracha3(String cargoCracha3) {
        this.cargoCracha3 = cargoCracha3;
    }

    @Column(name = "cargocracha4", nullable = false, length = 30)
    public String getCargoCracha4() {
        return cargoCracha4;
    }

    public void setCargoCracha4(String cargoCracha4) {
        this.cargoCracha4 = cargoCracha4;
    }

    @Column(name = "representacao1", nullable = false, length = 30)
    public String getRepresentacao1() {
        return representacao1;
    }

    public void setRepresentacao1(String representacao1) {
        this.representacao1 = representacao1;
    }

    @Column(name = "representacao2", nullable = false, length = 30)
    public String getRepresentacao2() {
        return representacao2;
    }

    public void setRepresentacao2(String representacao2) {
        this.representacao2 = representacao2;
    }

    @Column(name = "representacao3", nullable = false, length = 30)
    public String getRepresentacao3() {
        return representacao3;
    }

    public void setRepresentacao3(String representacao3) {
        this.representacao3 = representacao3;
    }

    @Column(name = "representacao4", nullable = false, length = 30)
    public String getRepresentacao4() {
        return representacao4;
    }

    public void setRepresentacao4(String representacao4) {
        this.representacao4 = representacao4;
    }

    @Column(name = "nomecracha1", nullable = false, length = 18)
    public String getNomeCracha1() {
        return nomeCracha1;
    }

    public void setNomeCracha1(String nomeCracha1) {
        this.nomeCracha1 = nomeCracha1;
    }

    @Column(name = "nomecracha2", nullable = false, length = 18)
    public String getNomeCracha2() {
        return nomeCracha2;
    }

    public void setNomeCracha2(String nomeCracha2) {
        this.nomeCracha2 = nomeCracha2;
    }

    @Column(name = "nomecracha3", nullable = false, length = 18)
    public String getNomeCracha3() {
        return nomeCracha3;
    }

    public void setNomeCracha3(String nomeCracha3) {
        this.nomeCracha3 = nomeCracha3;
    }

    @Column(name = "nomecracha4", nullable = false, length = 18)
    public String getNomeCracha4() {
        return nomeCracha4;
    }

    public void setNomeCracha4(String nomeCracha4) {
        this.nomeCracha4 = nomeCracha4;
    }

    @Column(name = "impresso", nullable = false)
    public boolean isImpresso() {
        return impresso;
    }

    public void setImpresso(boolean impresso) {
        this.impresso = impresso;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datacracha", nullable = true, length = 13)
    public Date getDataCracha() {
        return dataCracha;
    }

    public void setDataCracha(Date dataCracha) {
        this.dataCracha = dataCracha;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "dataentrega", nullable = true, length = 13)
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
}
