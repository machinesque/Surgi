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
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.TipoEquipamento;

/**
 *
 * @author luizam
 */
public class JdBuscaTipoEquipamento extends javax.swing.JDialog {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private TipoEquipamento tipoEquipamento;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private EditaOrdemTabela editaOrdemTabela;

    /** Creates new form jdBuscaAgendamento */
    public JdBuscaTipoEquipamento(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Tipo Equipamento - " + versao.getVersao() + " - " + versao.getAno(), modal);
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

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBotoes = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jbBuscaImprimirTabela = new javax.swing.JButton();
        jpTipoEquipamento = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaTipoEquipamento = new javax.swing.JTable();
        jtfBuscaNomeTipoEquipamento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

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

        jbBuscaImprimirTabela.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscaImprimirTabela.setMnemonic('t');
        jbBuscaImprimirTabela.setText("Imprimir Tabela");
        jbBuscaImprimirTabela.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscaImprimirTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscaImprimirTabelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscaImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpTipoEquipamento.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome Tipo Equipamento: ");

        jtbBuscaTipoEquipamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtbBuscaTipoEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbBuscaTipoEquipamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Nome Tipo Equipamento", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbBuscaTipoEquipamento.setGridColor(new java.awt.Color(204, 204, 204));
        jtbBuscaTipoEquipamento.setRowHeight(19);
        jtbBuscaTipoEquipamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbBuscaTipoEquipamento.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbBuscaTipoEquipamento);

        jtfBuscaNomeTipoEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaNomeTipoEquipamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaNomeTipoEquipamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaNomeTipoEquipamentoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpTipoEquipamentoLayout = new javax.swing.GroupLayout(jpTipoEquipamento);
        jpTipoEquipamento.setLayout(jpTipoEquipamentoLayout);
        jpTipoEquipamentoLayout.setHorizontalGroup(
            jpTipoEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoEquipamentoLayout.createSequentialGroup()
                .addGroup(jpTipoEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTipoEquipamentoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscaNomeTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpTipoEquipamentoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpTipoEquipamentoLayout.setVerticalGroup(
            jpTipoEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTipoEquipamentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTipoEquipamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfBuscaNomeTipoEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTipoEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTipoEquipamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jtfBuscaNomeTipoEquipamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaNomeTipoEquipamentoFocusLost
        jtfBuscaNomeTipoEquipamento.setText(jtfBuscaNomeTipoEquipamento.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaNomeTipoEquipamentoFocusLost

    private void jbBuscaImprimirTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaImprimirTabelaActionPerformed
        try {

            if (jtbBuscaTipoEquipamento.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não há nada na Tabela para ser impresso!", "Atenção", JOptionPane.WARNING_MESSAGE, null);
            } else {
                jtbBuscaTipoEquipamento.print();
            }

        } catch (PrinterException ex) {
            Logger.getLogger(JdBuscaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbBuscaImprimirTabelaActionPerformed
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaImprimirTabela;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpTipoEquipamento;
    private javax.swing.JTable jtbBuscaTipoEquipamento;
    private javax.swing.JTextField jtfBuscaNomeTipoEquipamento;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        cancelar();
        dao = null;
        this.dispose();

    }

    public void cancelar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaTipoEquipamento.getModel();

        jtfBuscaNomeTipoEquipamento.setText("");

        modelo.setRowCount(0);

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaTipoEquipamento.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbBuscaTipoEquipamento.setRowSorter(tabelaSorter);
        
        iniciaDao();

        TipoEquipamento tipoEquipamento;
        DateFormat df = DateFormat.getDateInstance();
        List listaTipoEquipamento = new ArrayList();
        String nomeTipoEquip;

        if (jtfBuscaNomeTipoEquipamento.getText().isEmpty()) {
            nomeTipoEquip = "";
        } else {
            nomeTipoEquip = jtfBuscaNomeTipoEquipamento.getText();
        }

        listaTipoEquipamento = (List) dao.listarTipoEquipamentos(0, nomeTipoEquip);

        modelo.setRowCount(0);
        iniciaEditaOrdemTabela();

        for (int i = 0; i < listaTipoEquipamento.size(); i++) {

            tipoEquipamento = (TipoEquipamento) listaTipoEquipamento.get(i);

            modelo.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), tipoEquipamento.getNomeTipoEquipamento(), String.valueOf(tipoEquipamento.getCodigoTipoEquipamento())});

        }

        if (jtbBuscaTipoEquipamento.getRowCount() > 0) {
            jtbBuscaTipoEquipamento.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há tipos de equipamentos cadastrados com estes dados!");
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaTipoEquipamento();

        int codigo;

        codigo = Integer.valueOf((String) jtbBuscaTipoEquipamento.getValueAt(jtbBuscaTipoEquipamento.getSelectedRow(), 2));

        tipoEquipamento = (TipoEquipamento) dao.busca(tipoEquipamento, codigo);
        dao.encerraSessao();

    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaTipoEquipamento() {
        
        if (tipoEquipamento == null) {
            tipoEquipamento = new TipoEquipamento();
        }
        
    }
    
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
    
    public void iniciaEditaOrdemTabela() {
        
        if (editaOrdemTabela == null) {
            editaOrdemTabela = new EditaOrdemTabela();
        }
        
    }
        
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres() {

        jtfBuscaNomeTipoEquipamento.setDocument(new FixedLengthDocument(120));

    }

    public TipoEquipamento getTipoEquipamento() {

        return tipoEquipamento;

    }

    public void setTipoEquipamento() {
        tipoEquipamento = null;
    }

//Metodos DAO===========================================================================================================================================
    

}
