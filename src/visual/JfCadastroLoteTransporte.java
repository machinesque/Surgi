/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import controlador.ClasseGeral;
import controlador.ControleImagem;
import controlador.ControleVersao;
import controlador.FixedLengthDocument;
import dao.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import modelo.Lote;
import modelo.Permissoes;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luizam
 */
public class JfCadastroLoteTransporte extends javax.swing.JFrame {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private Lote lote;
    private Lote loteVerificado;
    private Permissoes permissoes;

    private JdBuscaLote jdbl;
    private JasperViewer jViewer;
    private JasperPrint jPrint;
    
    private int codigo;
    private int codigoUsuario;
    private String opcao = "salvar";
    
    private boolean cadastrarLote;
    
    /**
     * Creates new form JfCadastroBairro
     */
    public JfCadastroLoteTransporte() {
        super("m2 - Cadastro Lote - Transporte Escolar - " + versao.getVersao() + " - " + versao.getAno());
        initComponents();

        //Altera icone na barra de titulo
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("C:/SURGI/imagens/SURGI32x32.png");
        this.setIconImage(img);

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

        jpCadastroLoteFundo = new javax.swing.JPanel();
        jpBotoes = new javax.swing.JPanel();
        jbSalvar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jpCadastroLote = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNomeLote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeroLote = new javax.swing.JTextField();
        jtfKmDia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete02.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/reload.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jbImprimir.setText("Imprimir");
        jbImprimir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbImprimir.setEnabled(false);
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpCadastroLote.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome Lote: ");

        jtfNomeLote.setBackground(new java.awt.Color(205, 204, 255));
        jtfNomeLote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNomeLote.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNomeLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeLoteFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Número Lote: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Total Km/dia: ");

        jtfNumeroLote.setBackground(new java.awt.Color(205, 204, 255));
        jtfNumeroLote.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNumeroLote.setToolTipText("Digite apenas números romanos!");
        jtfNumeroLote.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNumeroLote.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNumeroLoteFocusLost(evt);
            }
        });

        jtfKmDia.setBackground(new java.awt.Color(205, 204, 255));
        jtfKmDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfKmDia.setToolTipText("Neste campo digite apenas números, separados ou não por virgula!");
        jtfKmDia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfKmDia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfKmDiaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpCadastroLoteLayout = new javax.swing.GroupLayout(jpCadastroLote);
        jpCadastroLote.setLayout(jpCadastroLoteLayout);
        jpCadastroLoteLayout.setHorizontalGroup(
            jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLoteLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfNomeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfKmDia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jpCadastroLoteLayout.setVerticalGroup(
            jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCadastroLoteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNumeroLote, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfNomeLote, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCadastroLoteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfKmDia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpCadastroLoteFundoLayout = new javax.swing.GroupLayout(jpCadastroLoteFundo);
        jpCadastroLoteFundo.setLayout(jpCadastroLoteFundoLayout);
        jpCadastroLoteFundoLayout.setHorizontalGroup(
            jpCadastroLoteFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpCadastroLote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpCadastroLoteFundoLayout.setVerticalGroup(
            jpCadastroLoteFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCadastroLoteFundoLayout.createSequentialGroup()
                .addComponent(jpCadastroLote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCadastroLoteFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCadastroLoteFundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        if (jtfKmDia.getText().isEmpty() || jtfNomeLote.getText().isEmpty() || jtfNumeroLote.getText().isEmpty()) {

            iniciaClasseGeral();
            classeGeral.msgAtencao("Preencha os campos Obrigatórios em azul!");

        } else {

            if (opcao.equals("salvar")) {

                verificaCadastroLote();

                if (loteVerificado != null) {
                    iniciaClasseGeral();
                    classeGeral.msgAtencao("Esse Lote já está Cadastrado!");
                } else {
                    salvar();
                    opcao = "salvar";
                }

            } else if (opcao.equals("alterar")) {

                atualizar();
                opcao = "salvar";

            }

        }
    }//GEN-LAST:event_jbSalvarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jdbl == null) {
            jdbl = new JdBuscaLote(null, true);
        }

        jdbl.setVisible(true);

        setLoteBuscado(jdbl.getLote());
        jdbl.setLote();
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

        abilitaCampos();

        jbAlterar.setEnabled(false);

        opcao = "alterar";
        
        jbSalvar.setEnabled(true);
        
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        //ADOGeral ag = new ADOGeral();
        /*Conexao conexao = new Conexao();
        HashMap parametros = new HashMap();
        try {
            //System.out.println(codigoRegistro);
            //parametros.put("titulo", "Titulo Relatorio");
            parametros.put("codigoBairro", new Integer(codigo));
            //parametros.put("codigo", lista.get(0).getNome();
                //ADOGeral.conectar();
                conexao.getConexao();
            } catch (ExcCadastro ex) {
                Logger.getLogger(JfCadastroUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            //        JRDataSource jrds = new JRBeanCollectionDataSource(lista);

            try {

                //jReport = JasperCompileManager.compileReport("E:/LUIZ/PROJETOS JAVA/CORPORATIVO/m2GestaoClinicas/FichaPaciente.jrxml");
                //jPrint = JasperFillManager.fillReport("C:/m2GestaoClinicas/FichaPaciente.jasper", parametros, ADOGeral.getConexao());
                jPrint = JasperFillManager.fillReport("Funcao.jasper", parametros, conexao.getConexao());
                //jPrint = JasperFillManager.fillReport(jReport, parametros, jrds);

                //if (!(jViewer == null)) {
                    //jViewer = new JasperViewer(jPrint, false);
                    //jViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    if (jPrint != null) {
                        jViewer.viewReport(jPrint, false);
                        jPrint = null;
                    }
                    //}

            } catch (Exception ex) {
                ex.printStackTrace();
            }*/
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtfNomeLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeLoteFocusLost
        if (!jtfNomeLote.getText().isEmpty()) {
            jtfNomeLote.setText(jtfNomeLote.getText().toUpperCase());
        }
    }//GEN-LAST:event_jtfNomeLoteFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jtfKmDiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfKmDiaFocusLost
        if (!jtfKmDia.getText().isEmpty()) {
            iniciaClasseGeral();
            jtfKmDia.setText(classeGeral.pontoPorVirgula(classeGeral.somenteDouble(classeGeral.virgulaPorPonto(jtfKmDia.getText()))));
        }
    }//GEN-LAST:event_jtfKmDiaFocusLost

    private void jtfNumeroLoteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNumeroLoteFocusLost
        if (!jtfNumeroLote.getText().isEmpty()) {
            
            jtfNumeroLote.setText(jtfNumeroLote.getText().toUpperCase());
            
        }
    }//GEN-LAST:event_jtfNumeroLoteFocusLost

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
            java.util.logging.Logger.getLogger(JfCadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfCadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfCadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfCadastroBairro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfCadastroBairro().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpCadastroLote;
    private javax.swing.JPanel jpCadastroLoteFundo;
    private javax.swing.JTextField jtfKmDia;
    private javax.swing.JTextField jtfNomeLote;
    private javax.swing.JTextField jtfNumeroLote;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {
        if (!jtfKmDia.getText().isEmpty() || !jtfNomeLote.getText().isEmpty()) {
            iniciaClasseGeral();
            classeGeral.msgAtencao("Salve ou cancele o cadastro em edição!");
        } else {
            this.dispose();
        }
        
    }

    public void cancelar() {

        loteVerificado = null;
        
        jtfKmDia.setText("");
        jtfNomeLote.setText("");
        jtfNumeroLote.setText("");
        
        abilitaCampos();

        desabilitaBotoes();

        opcao = "salvar";
    }

    public void abilitaCampos() {

        jtfKmDia.setEnabled(true);
        jtfNomeLote.setEnabled(true);
        jtfNumeroLote.setEnabled(true);

    }

    public void desabilitaCampos() {

        jtfKmDia.setEnabled(false);
        jtfNomeLote.setEnabled(false);
        jtfNumeroLote.setEnabled(false);

    }

    public void abilitaBotoes() {

        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(false);

        if (cadastrarLote == true) {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(true);
            jbAlterar.setEnabled(true);
        } else {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
        }

    }

    public void desabilitaBotoes() {

        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(false);

        if (cadastrarLote == true) {
            jbSalvar.setEnabled(true);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
        } else {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
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
    
    public void iniciaLote() {
        
        if (lote == null) {
            lote = new Lote();
        }
        
    }
    
    public void iniciaPermissoes() {
        
        if (permissoes == null) {
            permissoes = new Permissoes();
        }
        
    }
    
    public void verificaCadastroLote() {

        iniciaDao();
        
        loteVerificado = (Lote) dao.verificarCadastroLote(jtfNomeLote.getText(), jtfNumeroLote.getText());

    }
    
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres() {

        jtfNomeLote.setDocument(new FixedLengthDocument(240));
        jtfNumeroLote.setDocument(new FixedLengthDocument(10));

    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
        getPermissoes();
        desabilitaBotoes();
    }

    public void getPermissoes() {
        
        iniciaDao();
        iniciaPermissoes();
        
        permissoes = (Permissoes) dao.buscaPermissoes(getCodigoUsuario());

        cadastrarLote = permissoes.isCadastrarLote();
    }

    public void setLoteBuscado(Lote loteBuscado) {
        
        if (loteBuscado == null) {
            
        } else {
            
            iniciaClasseGeral();
            iniciaLote();
            
            jtfKmDia.setText(classeGeral.pontoPorVirgula(String.valueOf(loteBuscado.getKmDia())));
            jtfNomeLote.setText(loteBuscado.getNomeLote());
            jtfNumeroLote.setText(loteBuscado.getNumeroLote());
            
            codigo = loteBuscado.getCodigoLote();
            lote = loteBuscado;
            lote.setCodigoLote(codigo);
            
            desabilitaCampos();

            opcao = "alterar";

            abilitaBotoes();
            
        }
        
    }


//Metodos DAO===========================================================================================================================================
    public void salvar() {

        iniciaDao();
        iniciaClasseGeral();
        iniciaLote();

        lote.setKmDia(Double.parseDouble(classeGeral.virgulaPorPonto(jtfKmDia.getText())));
        lote.setNomeLote(jtfNomeLote.getText());
        lote.setNumeroLote(jtfNumeroLote.getText());

        dao.inserir(lote, 7, codigoUsuario);
        cancelar();

    }
    
    public void atualizar() {

        iniciaDao();
        iniciaClasseGeral();
        iniciaLote();

        lote.setKmDia(Double.parseDouble(classeGeral.virgulaPorPonto(jtfKmDia.getText())));
        lote.setNomeLote(jtfNomeLote.getText());
        lote.setNumeroLote(jtfNumeroLote.getText());
        
        dao.atualizar(lote, 7, codigoUsuario);
        cancelar();

    }

    public void excluir() {

        iniciaClasseGeral();

        if (classeGeral.msgConfirma("Deseja excluir o Lote?")) {

            iniciaDao();
            iniciaLote();
            
            dao.excluir(lote, codigoUsuario);
            cancelar();

        }

    }

}