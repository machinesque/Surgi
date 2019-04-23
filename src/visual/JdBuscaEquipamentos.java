/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jdBuscaAgendamento.java
 *
 * Created on 02/02/2010, 09:10:34
 */
package visual;

import controlador.*;
import dao.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Equipamento;
import modelo.TipoEquipamento;

/**
 *
 * @author luizam
 */
public class JdBuscaEquipamentos extends javax.swing.JDialog {
    
    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private EditaOrdemTabela editaOrdemTabela;
    private Equipamento equipamento;
    private TipoEquipamento tipoEquipamento;

    /** Creates new form jdBuscaAgendamento */
    public JdBuscaEquipamentos(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Equipamentos - " + versao.getVersao() + " - " + versao.getAno(), modal);
        initComponents();

        //Altera icone na barra de titulo
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("C:/SURGI/imagens/SURGI32x32.png");
        this.setIconImage(img);

        //maximiza tela
        //this.setExtendedState(MAXIMIZED_BOTH);

        //centraliza tela
        setSize(getWidth(), getHeight());
        setLocationRelativeTo(null);

        setNumeroCaracteres();

        preencheComboMultimidia();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaMultimidia = new javax.swing.JTable();
        jcbBuscaMarcaMultimidia = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtfBuscaModelo = new javax.swing.JTextField();
        jtfBuscaPatrimonio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jbBuscaFechar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscaFechar.setMnemonic('f');
        jbBuscaFechar.setText("Fechar");
        jbBuscaFechar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscaFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaFecharActionPerformed(evt);
            }
        });

        jbBuscaEnviarDados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscaEnviarDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Enviar.png"))); // NOI18N
        jbBuscaEnviarDados.setMnemonic('d');
        jbBuscaEnviarDados.setText("Enviar Dados");
        jbBuscaEnviarDados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscaEnviarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaEnviarDadosActionPerformed(evt);
            }
        });

        jbBuscaCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscaCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jbBuscaCancelar.setMnemonic('z');
        jbBuscaCancelar.setText("Cancelar");
        jbBuscaCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscaCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaCancelarActionPerformed(evt);
            }
        });

        jbBuscaPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscaPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jbBuscaPesquisar.setMnemonic('p');
        jbBuscaPesquisar.setText("Pesquisar");
        jbBuscaPesquisar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscaPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(592, Short.MAX_VALUE)
                .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Modelo: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Marca: ");

        jtbBuscaMultimidia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtbBuscaMultimidia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbBuscaMultimidia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Tipo Equipamento", "Marca", "Modelo", "Patrimonio", "Empréstimo", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbBuscaMultimidia.setGridColor(new java.awt.Color(204, 204, 204));
        jtbBuscaMultimidia.setRowHeight(19);
        jtbBuscaMultimidia.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbBuscaMultimidia.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbBuscaMultimidia);

        jcbBuscaMarcaMultimidia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbBuscaMarcaMultimidia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbBuscaMarcaMultimidia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Patrimonio: ");

        jtfBuscaModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaModelo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaModelo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaModeloFocusLost(evt);
            }
        });

        jtfBuscaPatrimonio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaPatrimonio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaPatrimonio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaPatrimonioFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbBuscaMarcaMultimidia, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfBuscaPatrimonio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfBuscaModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbBuscaMarcaMultimidia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfBuscaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfBuscaPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jbBuscaFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaFecharActionPerformed
        fechar();
    }//GEN-LAST:event_jbBuscaFecharActionPerformed

    private void jbBuscaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_jbBuscaPesquisarActionPerformed

    private void jbBuscaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbBuscaCancelarActionPerformed

    private void jbBuscaEnviarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaEnviarDadosActionPerformed
        buscaDados();
        fechar();
    }//GEN-LAST:event_jbBuscaEnviarDadosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        preencheComboMultimidia();
    }//GEN-LAST:event_formWindowOpened

    private void jtfBuscaModeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaModeloFocusLost
        jtfBuscaModelo.setText(jtfBuscaModelo.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaModeloFocusLost

    private void jtfBuscaPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaPatrimonioFocusLost
        jtfBuscaPatrimonio.setText(jtfBuscaPatrimonio.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaPatrimonioFocusLost
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    jdBuscaAgendamento dialog = new jdBuscaAgendamento(new javax.swing.JFrame(), true);
    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    public void windowClosing(java.awt.event.WindowEvent e) {
    System.exit(0);
    }
    });
    dialog.setVisible(true);
    }
    });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JComboBox jcbBuscaMarcaMultimidia;
    private javax.swing.JTable jtbBuscaMultimidia;
    private javax.swing.JTextField jtfBuscaModelo;
    private javax.swing.JTextField jtfBuscaPatrimonio;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        cancelar();
        dao = null;
        this.dispose();

    }

    public void cancelar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaMultimidia.getModel();

        jcbBuscaMarcaMultimidia.setSelectedIndex(0);
        jtfBuscaModelo.setText("");
        jtfBuscaPatrimonio.setText("");

        modelo.setRowCount(0);

        preencheComboMultimidia();

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaMultimidia.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbBuscaMultimidia.setRowSorter(tabelaSorter);
        String emprestavel;
        
        iniciaDao();

        Equipamento equip;
        List listaEquip = new ArrayList();
        String marcaMulti;

        if (jcbBuscaMarcaMultimidia.getSelectedIndex() == 0) {
            marcaMulti = "";
        } else {
            marcaMulti = (String) jcbBuscaMarcaMultimidia.getSelectedItem();
        }

        listaEquip = (List) dao.listarEquipamento(0, 0, marcaMulti, jtfBuscaModelo.getText(), jtfBuscaPatrimonio.getText());

        modelo.setRowCount(0);
        iniciaEditaOrdemTabela();

        for (int i = 0; i < listaEquip.size(); i++) {

            equip = (Equipamento) listaEquip.get(i);

            if (equip.isDiponibilidadeEmprestimo()) {
                emprestavel = "SIM";
            } else {
                emprestavel = "NÃO";
            }
            
            modelo.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), equip.getTipoEquipamento().getNomeTipoEquipamento(), equip.getMarcaEquipamento(), equip.getModeloEquipamento(), equip.getPatrimonioEquipamento(), emprestavel, String.valueOf(equip.getCodigoEquipamento())});

        }

        if (jtbBuscaMultimidia.getRowCount() > 0) {
            jtbBuscaMultimidia.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há equipamentos cadastrados com estes dados!");
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaEquipamento();
        //DAO dao = new DAO();

        int codigo;

        codigo = Integer.valueOf((String) jtbBuscaMultimidia.getValueAt(jtbBuscaMultimidia.getSelectedRow(), 6));

        equipamento = (Equipamento) dao.busca(equipamento, codigo);
        dao.encerraSessao();

    }

    public void preencheComboMultimidia() {

        iniciaDao();
        
        Equipamento equip = new Equipamento();
        List listaMultimidias = new ArrayList();

        jcbBuscaMarcaMultimidia.removeAllItems();
        jcbBuscaMarcaMultimidia.addItem("");

        listaMultimidias = dao.listarEquipamento(0, 0, "", "", "");

        for (int i = 0; i < listaMultimidias.size(); i++) {
            equip = (Equipamento) listaMultimidias.get(i);
            jcbBuscaMarcaMultimidia.addItem(equip.getMarcaEquipamento());
        }

    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
    
    public void iniciaEquipamento() {
        
        if (equipamento == null) {
            equipamento = new Equipamento();
        }
        
    }
    
    public void iniciaEditaOrdemTabela() {
        
        if (editaOrdemTabela == null) {
            editaOrdemTabela = new EditaOrdemTabela();
        }
        
    }
    
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres() {

        jtfBuscaModelo.setDocument(new FixedLengthDocument(120));
        jtfBuscaPatrimonio.setDocument(new FixedLengthDocument(10));

    }

    public Equipamento getEquipamento() {

        return equipamento;

    }

    public void setEquipamento() {
        equipamento = null;
    }

//Metodos DAO===========================================================================================================================================
    

}
