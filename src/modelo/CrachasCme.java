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
@Table(name = "crachacme", schema = "public")
public class CrachasCme implements java.io.Serializable {
    
    private int codigoCrachaCme;
    private String cargoCracha1;
    private String cargoCracha2;
    private String cargoCracha3;
    private String cargoCracha4;
    private String departamentoCracha1;
    private String departamentoCracha2;
    private String departamentoCracha3;
    private String departamentoCracha4;
    private String nomeCracha1;
    private String nomeCracha2;
    private String nomeCracha3;
    private String nomeCracha4;
    private boolean impresso;
    private Date dataCracha;
    private Date dataEntrega;

    public CrachasCme() {
        
    }
    
    public CrachasCme(int codigoCrachaCme, String cargoCracha1, String cargoCracha2, String cargoCracha3, String cargoCracha4, String departamentoCracha1, String departamentoCracha2, 
            String departamentoCracha3, String departamentoCracha4, String nomeCracha1, String nomeCracha2, String nomeCracha3, String nomeCracha4, boolean impresso, Date dataCracha,
            Date dataEntrega) {
        
        this.cargoCracha1 = cargoCracha1;
        this.cargoCracha2 = cargoCracha2;
        this.cargoCracha3 = cargoCracha3;
        this.cargoCracha4 = cargoCracha4;
        this.codigoCrachaCme = codigoCrachaCme;
        this.dataCracha = dataCracha;
        this.dataEntrega = dataEntrega;
        this.departamentoCracha1 = departamentoCracha1;
        this.departamentoCracha2 = departamentoCracha2;
        this.departamentoCracha3 = departamentoCracha3;
        this.departamentoCracha4 = departamentoCracha4;
        this.impresso = impresso;
        this.nomeCracha1 = nomeCracha1;
        this.nomeCracha2 = nomeCracha2;
        this.nomeCracha3 = nomeCracha3;
        this.nomeCracha4 = nomeCracha4;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_CRACHACME", sequenceName = "crachacme_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_CRACHACME")
    @Column(name = "codigocrachacme", unique = true, nullable = false)
    public int getCodigoCrachaCme() {
        return codigoCrachaCme;
    }

    public void setCodigoCrachaCme(int codigoCrachaCme) {
        this.codigoCrachaCme = codigoCrachaCme;
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

    @Column(name = "departamentocracha1", nullable = false, length = 30)
    public String getDepartamentoCracha1() {
        return departamentoCracha1;
    }

    public void setDepartamentoCracha1(String departamentoCracha1) {
        this.departamentoCracha1 = departamentoCracha1;
    }

    @Column(name = "departamentocracha2", nullable = false, length = 30)
    public String getDepartamentoCracha2() {
        return departamentoCracha2;
    }

    public void setDepartamentoCracha2(String departamentoCracha2) {
        this.departamentoCracha2 = departamentoCracha2;
    }

    @Column(name = "departamentocracha3", nullable = false, length = 30)
    public String getDepartamentoCracha3() {
        return departamentoCracha3;
    }

    public void setDepartamentoCracha3(String departamentoCracha3) {
        this.departamentoCracha3 = departamentoCracha3;
    }

    @Column(name = "departamentocracha4", nullable = false, length = 30)
    public String getDepartamentoCracha4() {
        return departamentoCracha4;
    }

    public void setDepartamentoCracha4(String departamentoCracha4) {
        this.departamentoCracha4 = departamentoCracha4;
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
