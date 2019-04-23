/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controlador.ClasseGeral;
import controlador.ControleBloco;
import controlador.ControleImagem;
import controlador.ControleVersao;
import controlador.EditaOrdemTabela;
import dao.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Bloco;
import modelo.Linha;

/**
 *
 * @author luizam
 */
public class JdBuscaLinha extends javax.swing.JDialog {

     private static ControleVersao versao = new ControleVersao();
     private Bloco bloco;
     private ClasseGeral classeGeral;
     private ControleBloco controleBloco;
     private ControleImagem controleImagem = new ControleImagem();
     private DAO dao;
     private DefaultTableModel modeloTabela;
     private EditaOrdemTabela editaOrdemTabela;
     private Linha linha;
    
    /**
     * Creates new form JdBuscaLote
     */
    public JdBuscaLinha(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Linha - " + versao.getVersao() + " - " + versao.getAno(), modal);
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
        
        preencheComboBloco();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBuscaLinhaFundo = new javax.swing.JPanel();
        jpBuscaLinha = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNumeroLinha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaLinha = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jcbBloco = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jcbCarro = new javax.swing.JComboBox();
        jpBotoes = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBuscaLinha.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Número Linha: ");

        jtfNumeroLinha.setBackground(new java.awt.Color(205, 204, 255));
        jtfNumeroLinha.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNumeroLinha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNumeroLinhaFocusLost(evt);
            }
        });

        jtbBuscaLinha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Bloco", "Número Linha", "Km", "Km + 10%", "Carro", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtbBuscaLinha);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Bloco: ");

        jcbBloco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbBloco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Carro: ");

        jcbCarro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbCarro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "1 - Ônibus", "2 - Micro Ônibus", "3 - Van", "4 - Kombi" }));
        jcbCarro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpBuscaLinhaLayout = new javax.swing.GroupLayout(jpBuscaLinha);
        jpBuscaLinha.setLayout(jpBuscaLinhaLayout);
        jpBuscaLinhaLayout.setHorizontalGroup(
            jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaLinhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jpBuscaLinhaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumeroLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBuscaLinhaLayout.setVerticalGroup(
            jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaLinhaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNumeroLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaLinhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcbCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpBuscaLinhaFundoLayout = new javax.swing.GroupLayout(jpBuscaLinhaFundo);
        jpBuscaLinhaFundo.setLayout(jpBuscaLinhaFundoLayout);
        jpBuscaLinhaFundoLayout.setHorizontalGroup(
            jpBuscaLinhaFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBuscaLinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpBuscaLinhaFundoLayout.setVerticalGroup(
            jpBuscaLinhaFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaLinhaFundoLayout.createSequentialGroup()
                .addComponent(jpBuscaLinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBuscaLinhaFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBuscaLinhaFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNumeroLinhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNumeroLinhaFocusLost
        if (!jtfNumeroLinha.getText().isEmpty()) {
            jtfNumeroLinha.setText(jtfNumeroLinha.getText().toUpperCase());
        }
    }//GEN-LAST:event_jtfNumeroLinhaFocusLost

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JdBuscaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JdBuscaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JdBuscaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JdBuscaLote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the dialog */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JdBuscaLote dialog = new JdBuscaLote(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JComboBox jcbBloco;
    private javax.swing.JComboBox jcbCarro;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpBuscaLinha;
    private javax.swing.JPanel jpBuscaLinhaFundo;
    private javax.swing.JTable jtbBuscaLinha;
    private javax.swing.JTextField jtfNumeroLinha;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {
    
        cancelar();
        dao = null;
        this.dispose();
    
    }

    public void cancelar() {
        
        iniciaModeloTabela();
        
        preencheComboBloco();
        jcbCarro.setSelectedIndex(0);
        jtfNumeroLinha.setText("");
        modeloTabela.setRowCount(0);
        
    }
    
    public void pesquisar() {
        
        iniciaModeloTabela();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modeloTabela);
        
        int bloco_codigoBloco;
        int numeroLinha;
        String carro;
        
        jtbBuscaLinha.setRowSorter(tabelaSorter);
        
        iniciaDao();
        
        Linha linhaPesquisa;
        List listaLinha = new ArrayList();
        
        if (jcbBloco.getSelectedIndex() != 0) {
            
            iniciaControleBloco();
            bloco_codigoBloco = controleBloco.getCodigoBloco(controleBloco.getNomeBloco(jcbBloco.getSelectedItem().toString()));
            
        } else {
            bloco_codigoBloco = 0;
        }
        
        if (!jtfNumeroLinha.getText().isEmpty()) {
            
            numeroLinha = Integer.valueOf(jtfNumeroLinha.getText());
            
        } else {
            numeroLinha = 0;
        }
        
        if (jcbCarro.getSelectedIndex() == 0) {
            carro = "";
        } else {
            carro = jcbCarro.getSelectedItem().toString();
        }
        
        listaLinha = dao.listarLinhas(numeroLinha, bloco_codigoBloco, carro);
        
        modeloTabela.setRowCount(0);
        iniciaEditaOrdemTabela();
        
        for (int i = 0; i < listaLinha.size(); i++) {
            
            linhaPesquisa = (Linha) listaLinha.get(i);
            
            modeloTabela.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), "BLOCO " + linhaPesquisa.getBloco().getNumeroBloco() + " - " +linhaPesquisa.getBloco().getNomeBloco(),  
                String.valueOf(linhaPesquisa.getNumeroLinha()), String.valueOf(linhaPesquisa.getKm()), String.valueOf(linhaPesquisa.getKm10()), linhaPesquisa.getCarro(), 
                String.valueOf(linhaPesquisa.getCodigoLinha())});
            
        }
        
        if (jtbBuscaLinha.getRowCount() > 0) {
            jtbBuscaLinha.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há linha com estes dados!");
        }
        
    }
    
    public void buscaDados() {
        
        iniciaDao();
        iniciaLinha();
        //DAO dao = new DAO();

        int codigo;

        codigo = Integer.valueOf((String) jtbBuscaLinha.getValueAt(jtbBuscaLinha.getSelectedRow(), 6));

        linha = (Linha) dao.busca(linha, codigo);
        dao.encerraSessao();
        
    }
    
    public void preencheComboBloco() {
        
        iniciaDao();
        List listaBlocos = new ArrayList();

        jcbBloco.removeAllItems();
        jcbBloco.addItem("");

        listaBlocos = dao.listarBlocos("", 0);

        for (int i = 0; i < listaBlocos.size(); i++) {
            iniciaBloco();
            bloco = (Bloco) listaBlocos.get(i);
            jcbBloco.addItem("BLOCO " + bloco.getNumeroBloco() + " - " + bloco.getNomeBloco());
            bloco = null;
        }
        
        jcbBloco.setSelectedIndex(0);
    }
    
//Geradores, Validadores===========================================================================================================================================
    public void iniciaBloco() {
        
        if (bloco == null) {
            bloco = new Bloco();
        }
        
    }
    
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaControleBloco() {
        
        if (controleBloco == null) {
            controleBloco = new ControleBloco();
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
    
    public void iniciaLinha() {
        
        if (linha == null) {
            linha = new Linha();
        }
        
    }
    
    public void iniciaModeloTabela() {
        
        if (modeloTabela == null) {
            modeloTabela = (DefaultTableModel) jtbBuscaLinha.getModel();
        }
        
    }
    
//Getters and Setters===========================================================================================================================================
    public Linha getLinha() {
        return linha;
    }

    public void setLinha() {
        this.linha = null;
    }
    
//Metodos DAO===========================================================================================================================================

    
    
}
