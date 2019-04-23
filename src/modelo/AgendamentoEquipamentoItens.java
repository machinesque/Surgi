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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author luizam
 */
@Entity
@Table(name = "agendamentoequipamentoitens", schema = "public")
public class AgendamentoEquipamentoItens implements java.io.Serializable{
    
    private int codigoAgendamentoEquipamentoItem;
    private Equipamento equipamento;
    private AgendamentoEquipamento agendamentoEquipamento;

    public AgendamentoEquipamentoItens() {
        
    }
    
    public AgendamentoEquipamentoItens(int codigoAgendamentoEquipamentoItem, Equipamento equipamento, AgendamentoEquipamento agendamentoEquipamento) {
        
        this.agendamentoEquipamento = agendamentoEquipamento;
        this.codigoAgendamentoEquipamentoItem = codigoAgendamentoEquipamentoItem;
        this.equipamento = equipamento;
        
    }
    
    @Id
    @SequenceGenerator(name = "SEQUENCE_AGENDAMENTOEQUIPAMENTOITENS", sequenceName = "agendamentoequipamentoitens_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_AGENDAMENTOEQUIPAMENTOITENS")
    @Column(name = "codigoagendamentoequipamentoitens", unique = true, nullable = true)
    public int getCodigoAgendamentoEquipamentoItem() {
        return codigoAgendamentoEquipamentoItem;
    }

    public void setCodigoAgendamentoEquipamentoItem(int codigoAgendamentoEquipamentoItem) {
        this.codigoAgendamentoEquipamentoItem = codigoAgendamentoEquipamentoItem;
    }

    @ManyToOne()
    @JoinColumn(name = "equipamento_codigoequipamento", insertable = true, updatable = true)
    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @ManyToOne()
    @JoinColumn(name = "agendamentoequipamento_codigoagendamentoequipamento", insertable = true, updatable = true)
    public AgendamentoEquipamento getAgendamentoEquipamento() {
        return agendamentoEquipamento;
    }

    public void setAgendamentoEquipamento(AgendamentoEquipamento agendamentoEquipamento) {
        this.agendamentoEquipamento = agendamentoEquipamento;
    }
    
}
