/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controlador.*;
import dao.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Permissoes;
import modelo.SolicitacaoRecarga;

/**
 *
 * @author luizam
 */
public class JdBuscaSolicitacaoRecarga extends javax.swing.JDialog {
    
    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private EditaOrdemTabela editaOrdemTabela;
    private Log log;
    private SolicitacaoRecarga solicitacaoRecarga;
    
    private int codigoUsuario;
    
    /**
     * Creates new form jdBuscaSolicitacaoRecarga
     */
    public JdBuscaSolicitacaoRecarga(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Solicitação Recarga - " + versao.getVersao() + " - " + versao.getAno(), modal);
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

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jpBuscaSolicitacaoRecarga = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfBuscaEmissor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfBuscaReceptor = new javax.swing.JTextField();
        jtfBuscaNumeroSolicitacao = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jDateChooserBuscaSolicitacaoInicio = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jDateChooserBuscaSolicitacaoTermino = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jYearChooserBuscaSolicitacaoAno = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbSolicitacaoRecarga = new javax.swing.JTable();
        jpBotoes = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jbBuscaImprimirTabela = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBuscaSolicitacaoRecarga.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Emissor: ");

        jtfBuscaEmissor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaEmissor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaEmissor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaEmissorFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Receptor: ");

        jtfBuscaReceptor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaReceptor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaReceptor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaReceptorFocusLost(evt);
            }
        });

        jtfBuscaNumeroSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaNumeroSolicitacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaNumeroSolicitacao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaNumeroSolicitacaoFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Número Solicitação: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Período: ");

        jDateChooserBuscaSolicitacaoInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDateChooserBuscaSolicitacaoInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText(" até ");

        jDateChooserBuscaSolicitacaoTermino.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDateChooserBuscaSolicitacaoTermino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Ano: ");

        jYearChooserBuscaSolicitacaoAno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jtbSolicitacaoRecarga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Emissor", "Receptor", "Número da Solicitação", "Código da Solicitação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbSolicitacaoRecarga.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtbSolicitacaoRecarga);

        javax.swing.GroupLayout jpBuscaSolicitacaoRecargaLayout = new javax.swing.GroupLayout(jpBuscaSolicitacaoRecarga);
        jpBuscaSolicitacaoRecarga.setLayout(jpBuscaSolicitacaoRecargaLayout);
        jpBuscaSolicitacaoRecargaLayout.setHorizontalGroup(
            jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaSolicitacaoRecargaLayout.createSequentialGroup()
                .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBuscaSolicitacaoRecargaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpBuscaSolicitacaoRecargaLayout.createSequentialGroup()
                                .addComponent(jDateChooserBuscaSolicitacaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserBuscaSolicitacaoTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jYearChooserBuscaSolicitacaoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfBuscaNumeroSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfBuscaEmissor)
                            .addComponent(jtfBuscaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jpBuscaSolicitacaoRecargaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jpBuscaSolicitacaoRecargaLayout.setVerticalGroup(
            jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaSolicitacaoRecargaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfBuscaEmissor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfBuscaReceptor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfBuscaNumeroSolicitacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaSolicitacaoRecargaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDateChooserBuscaSolicitacaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooserBuscaSolicitacaoTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jYearChooserBuscaSolicitacaoAno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );

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
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(jbBuscaImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaImprimirTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBuscaSolicitacaoRecarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpBuscaSolicitacaoRecarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscaFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaFecharActionPerformed
        fechar();
    }//GEN-LAST:event_jbBuscaFecharActionPerformed

    private void jbBuscaEnviarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaEnviarDadosActionPerformed
        buscaDados();
        fechar();
    }//GEN-LAST:event_jbBuscaEnviarDadosActionPerformed

    private void jbBuscaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbBuscaCancelarActionPerformed

    private void jbBuscaPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaPesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_jbBuscaPesquisarActionPerformed

    private void jbBuscaImprimirTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaImprimirTabelaActionPerformed
        try {

            if (jtbSolicitacaoRecarga.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Não há nada na Tabela para ser impresso!", "Atenção", JOptionPane.WARNING_MESSAGE, null);
            } else {
                jtbSolicitacaoRecarga.print();
            }

        } catch (PrinterException ex) {
            Logger.getLogger(JdBuscaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbBuscaImprimirTabelaActionPerformed

    private void jtfBuscaEmissorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaEmissorFocusLost
        jtfBuscaEmissor.setText(jtfBuscaEmissor.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaEmissorFocusLost

    private void jtfBuscaReceptorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaReceptorFocusLost
        jtfBuscaReceptor.setText(jtfBuscaReceptor.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaReceptorFocusLost

    private void jtfBuscaNumeroSolicitacaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaNumeroSolicitacaoFocusLost
        
        if (!jtfBuscaNumeroSolicitacao.getText().isEmpty()) {
            
            iniciaClasseGeral();
        
            classeGeral.somenteNumero(jtfBuscaNumeroSolicitacao.getText());
            
        }
        
    }//GEN-LAST:event_jtfBuscaNumeroSolicitacaoFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jdBuscaSolicitacaoRecarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdBuscaSolicitacaoRecarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdBuscaSolicitacaoRecarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdBuscaSolicitacaoRecarga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        /*java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                jdBuscaSolicitacaoRecarga dialog = new jdBuscaSolicitacaoRecarga(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooserBuscaSolicitacaoInicio;
    private com.toedter.calendar.JDateChooser jDateChooserBuscaSolicitacaoTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private com.toedter.calendar.JYearChooser jYearChooserBuscaSolicitacaoAno;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaImprimirTabela;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpBuscaSolicitacaoRecarga;
    private javax.swing.JTable jtbSolicitacaoRecarga;
    private javax.swing.JTextField jtfBuscaEmissor;
    private javax.swing.JTextField jtfBuscaNumeroSolicitacao;
    private javax.swing.JTextField jtfBuscaReceptor;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {
        
        cancelar();
        dao = null;
        this.dispose();

    }

    public void cancelar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbSolicitacaoRecarga.getModel();

        jtfBuscaEmissor.setText("");
        jtfBuscaNumeroSolicitacao.setText("");
        jtfBuscaReceptor.setText("");
        jDateChooserBuscaSolicitacaoInicio.setDate(null);
        jDateChooserBuscaSolicitacaoTermino.setDate(null);

        modelo.setRowCount(0);

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbSolicitacaoRecarga.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbSolicitacaoRecarga.setRowSorter(tabelaSorter);
        
        iniciaDao();

        SolicitacaoRecarga solicitacao;
        List listaSolicitacaoRecarga = new ArrayList();
        int numeroSolicitacao = 0;
        String nomeEntid;
        Date dataSolicTermino;

        if (!jtfBuscaNumeroSolicitacao.getText().isEmpty()) {
            numeroSolicitacao = Integer.parseInt(jtfBuscaNumeroSolicitacao.getText());
        }
        
        if (jDateChooserBuscaSolicitacaoTermino.getDate() == null) {
            dataSolicTermino = null;
        } else {
            dataSolicTermino = jDateChooserBuscaSolicitacaoTermino.getDate();
        }

        if (jDateChooserBuscaSolicitacaoInicio.getDate() == null) {
            listaSolicitacaoRecarga = dao.listarSolicitacaoRecarga(jtfBuscaEmissor.getText(), jtfBuscaReceptor.getText(), null, dataSolicTermino, numeroSolicitacao, String.valueOf(jYearChooserBuscaSolicitacaoAno.getYear()));
        } else {
            //try {
            //dataSolic = df.parse(jftfBuscaDataSolicitacao.getText()); Usando jFormatedTextField
            //} catch (ParseException ex) {
            //    Logger.getLogger(jdBuscaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            //}
            listaSolicitacaoRecarga = dao.listarSolicitacaoRecarga(jtfBuscaEmissor.getText(), jtfBuscaReceptor.getText(), jDateChooserBuscaSolicitacaoInicio.getDate(), dataSolicTermino, numeroSolicitacao, String.valueOf(jYearChooserBuscaSolicitacaoAno.getYear()));
        }

        //listaAgendamento = dao.listarAgendamento(nomeEntid, new java.sql.Date(dataSolic.getTime()), tipoEntid);Usando jFormatedTextField

        modelo.setRowCount(0);
        iniciaEditaOrdemTabela();

        for (int i = 0; i < listaSolicitacaoRecarga.size(); i++) {

            solicitacao = (SolicitacaoRecarga) listaSolicitacaoRecarga.get(i);

            modelo.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), solicitacao.getEmissor(), solicitacao.getReceptor(), String.valueOf(solicitacao.getNumeroSolicitacao()), String.valueOf(solicitacao.getCodigoSolicitacaoRecarga())});

        }

        if (jtbSolicitacaoRecarga.getRowCount() > 0) {
            jtbSolicitacaoRecarga.getSelectionModel().setSelectionInterval(0, 0);
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaSolicitacaoRecarga();
        //DAO dao = new DAO();

        int codigo;

        codigo = Integer.valueOf((String) jtbSolicitacaoRecarga.getValueAt(jtbSolicitacaoRecarga.getSelectedRow(), 4));

        solicitacaoRecarga = (SolicitacaoRecarga) dao.busca(solicitacaoRecarga, codigo);
        dao.encerraSessao();

    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
    
    public void iniciaClasseGeral() {

        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }

    }
    
    public void iniciaEditaOrdemTabela() {
        
        if (editaOrdemTabela == null) {
            editaOrdemTabela = new EditaOrdemTabela();
        }
        
    }
    
    public void iniciaSolicitacaoRecarga() {
        
        if (solicitacaoRecarga == null) {
            solicitacaoRecarga = new SolicitacaoRecarga();
        }
        
    }
    
//Getters and Setters===========================================================================================================================================
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
        getPermissoes();
    }
    
    public void setNumeroCaracteres() {
        
        jtfBuscaEmissor.setDocument(new FixedLengthDocument(120));
        jtfBuscaReceptor.setDocument(new FixedLengthDocument(120));
        
    }

    public SolicitacaoRecarga getSolicitacaoRecarga() {

        return solicitacaoRecarga;

    }

    public void setSolicitacaoRecarga() {
        solicitacaoRecarga = null;
    }

    public void getPermissoes() {
        Permissoes permissoes = new Permissoes();
        iniciaDao();
        //DAO dao = new DAO();

        permissoes = (Permissoes) dao.buscaPermissoes(codigoUsuario);

    }

//Metodos DAO===========================================================================================================================================
    

}
