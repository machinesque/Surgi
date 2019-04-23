/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author luizam
 */

@Entity
@Table(name = "justificativa", schema = "public")
public class Justificativa implements java.io.Serializable {
    
    private int codigoJustificativa;
    private String textoJustificativa;
    private Date dataJustificativa;
    private Aluno aluno;
    
    public Justificativa() {
        
    }
    
    public Justificativa(int codigoJustificativa, String textoJustificativa, Date dataJustificativa, Aluno aluno) {
        
        this.aluno = aluno;
        this.codigoJustificativa = codigoJustificativa;
        this.dataJustificativa = dataJustificativa;
        this.textoJustificativa = textoJustificativa;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_JUSTIFICATIVA", sequenceName = "justificativa_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_JUSTIFICATIVA")
    @Column(name = "codigojustificativa", unique = true, nullable = false)
    public int getCodigoJustificativa() {
        return codigoJustificativa;
    }

    public void setCodigoJustificativa(int codigoJustificativa) {
        this.codigoJustificativa = codigoJustificativa;
    }

    @Column(name = "textojustificativa", nullable = false, length = 400)
    public String getTextoJustificativa() {
        return textoJustificativa;
    }

    public void setTextoJustificativa(String textoJustificativa) {
        this.textoJustificativa = textoJustificativa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "datajustificativa", nullable = false, length = 13)
    public Date getDataJustificativa() {
        return dataJustificativa;
    }

    public void setDataJustificativa(Date dataJustificativa) {
        this.dataJustificativa = dataJustificativa;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoaluno")
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
}
