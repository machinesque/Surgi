/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "entregaremanufaturadositens", schema = "public")
public class EntregaRemanufaturadosItens {
    
    private int codigoEntregaRemanufaturadosItens;
    private EntregaRemanufaturados entregaRemanufaturados;
    private Cartucho cartucho;
    
    public EntregaRemanufaturadosItens() {
        
    }
    
    public EntregaRemanufaturadosItens(int codigoEntregaRemanufaturadosItens, EntregaRemanufaturados entregaRemanufaturados, Cartucho cartucho) {
        
        this.codigoEntregaRemanufaturadosItens = codigoEntregaRemanufaturadosItens;
        this.entregaRemanufaturados = entregaRemanufaturados;
        this.cartucho = cartucho;
        
    }

    @Id
    @SequenceGenerator(name = "SEQUENCE_ENTREGAREMANUFATURADOSITENS", sequenceName = "entregaremanufaturadositens_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ENTREGAREMANUFATURADOSITENS")
    @Column(name = "codigoentregaremanufaturadositens", unique = true, nullable = false)
    public int getCodigoEntregaRemanufaturadosItens() {
        return codigoEntregaRemanufaturadosItens;
    }

    public void setCodigoEntregaRemanufaturadosItens(int codigoEntregaRemanufaturadosItens) {
        this.codigoEntregaRemanufaturadosItens = codigoEntregaRemanufaturadosItens;
    }

    @ManyToOne()
    @JoinColumn(name = "entregaremanufaturados_codigoentregaremanufaturados", insertable = true, updatable = false)
    public EntregaRemanufaturados getEntregaRemanufaturados() {
        return entregaRemanufaturados;
    }

    public void setEntregaRemanufaturados(EntregaRemanufaturados entregaRemanufaturados) {
        this.entregaRemanufaturados = entregaRemanufaturados;
    }

    @ManyToOne()
    @JoinColumn(name = "cartucho_codigocartucho", insertable = true, updatable = false)
    public Cartucho getCartucho() {
        return cartucho;
    }

    public void setCartucho(Cartucho cartucho) {
        this.cartucho = cartucho;
    }
 
    
    
}
