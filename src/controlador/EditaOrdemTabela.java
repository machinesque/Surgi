/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luizam
 */
public class EditaOrdemTabela {

    public String editaOrdem(int ordem) {

        String ordemEditada = "";

        if (ordem < 10) {
            ordemEditada = "0000" + ordem;
        } else if (ordem < 100) {
            ordemEditada = "000" + ordem;
        } else if (ordem < 1000) {
            ordemEditada = "00" + ordem;
        } else if (ordem < 10000) {
            ordemEditada = "0" + ordem;
        } else {
            ordemEditada = "" + ordem;
        }

        return ordemEditada;

    }

    public void sortAllRowsBy(DefaultTableModel model, int colIndex, boolean ascending) {
        Vector data = model.getDataVector();
        Collections.sort(data, new ColumnSorter(colIndex, ascending));
        model.fireTableStructureChanged();
    }        // Este comparador é usado classificar vetores dos dados

    public class ColumnSorter implements Comparator {

        int colIndex;
        boolean ascending;

        ColumnSorter(int colIndex, boolean ascending) {
            this.colIndex = colIndex;
            this.ascending = ascending;
        }

        public int compare(Object a, Object b) {
            Vector v1 = (Vector) a;
            Vector v2 = (Vector) b;
            Object o1 = v1.get(colIndex);
            Object o2 = v2.get(colIndex);
            if (o1 instanceof String && ((String) o1).length() == 0) {
                o1 = null;
            }
            if (o2 instanceof String && ((String) o2).length() == 0) {
                o2 = null;
            }
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            } else if (o1 instanceof Comparable) {
                if (ascending) {
                    return ((Comparable) o1).compareTo(o2);
                } else {
                    return ((Comparable) o2).compareTo(o1);
                }
            } else {
                if (ascending) {
                    return o1.toString().compareTo(o2.toString());
                } else {
                    return o2.toString().compareTo(o1.toString());
                }
            }
        }
    }

}
