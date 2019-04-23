/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author luizam
 */
public class Formatos {

    public DefaultFormatterFactory getFormatoCpf() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("###.###.###-##");
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public DefaultFormatterFactory getFormatoTelefone() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("(##)####-####"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public DefaultFormatterFactory getFormatoRg() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("##.###.###-#"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public DefaultFormatterFactory getFormatoNumeroIdentificadorCopel() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("##.###.###-#"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public DefaultFormatterFactory getFormatoHora() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("##:##"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public DefaultFormatterFactory getFormatoCep() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("#####-###"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }
}
