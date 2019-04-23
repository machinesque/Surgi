/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;

/**
 *
 * @author luizam
 */
public class VerificadorDataPeriodo {
    
    public boolean verificaDatas(Date dataInicio, Date dataTermino) {
        
        int ano;
        int mes;
        int dia;

        //Date dataAtual = getDateHoje();
        
        int anoInicio = dataInicio.getYear() + 1900;
        int mesInicio = dataInicio.getMonth() + 1;
        int diaInicio = dataInicio.getDate();
        
        int anoTermino = dataTermino.getYear() + 1900;
        int mesTermino = dataTermino.getMonth() + 1;
        int diaTermino = dataTermino.getDate();
        
        if (diaTermino < diaInicio) {
            mesTermino -= 1;
            diaTermino += 30;
            dia = diaTermino - diaInicio;
        } else {
            dia = diaTermino - diaInicio;
        }
        
        if (mesTermino < mesInicio) {
            anoTermino -= 1;
            mesTermino += 12;
            mes = mesTermino - mesInicio;
        } else {
            mes = mesTermino - mesInicio;
        }
        
        ano = anoTermino - anoInicio;
        
        if (ano < 0) {
            return true;
        } else {
            return false;
        } 
        
    }
    
}
