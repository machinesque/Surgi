/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfAgendamento.java
 *
 * 
 *
 * Created on 27/01/2010, 09:03:31
 */
package visual;

import controlador.*;
import dao.DAO;
import excecoes.MensagensExcessao;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Permissoes;
import modelo.Ata;
import modelo.Usuario;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luiz
 */
public class JfAta extends javax.swing.JFrame {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleUsuario controleUsuario;
    private DAO dao;
    private Log geraLog;
    private MensagensExcessao except;
    private Ata ata;
    private Usuario usuario;

    private JasperPrint jPrint;
    private JasperViewer jViewer;
    private JdBuscaAta jdba;

    private int codigo = 0;
    private int codigoUsuario;
    private String opcao = "salvar";
    private String ataVerificada;
    private boolean gerarNumeracao;

    /** Creates new form jfAgendamento */
    public JfAta() {
        super("ATA - " + versao.getVersao() + " - " + versao.getAno());
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

        jlbAnoAta.setText(getAno());
        jDateChooserPublicacao.setDate(getDateHoje());
        jrbAta.setSelected(true);

        bloqueiaCampos();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgTipoOficio = new javax.swing.ButtonGroup();
        jpAta = new javax.swing.JPanel();
        jlbAnoAta = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jrbAta = new javax.swing.JRadioButton();
        jDateChooserPublicacao = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfNumeroAta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfNumeroModalidade = new javax.swing.JTextField();
        jtfNumeroProcesso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfObjetoAta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbFinalizada = new javax.swing.JComboBox();
        jpBotoes = new javax.swing.JPanel();
        jbNovo = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpAta.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jlbAnoAta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbAnoAta.setText("Ano Resolução");
        jlbAnoAta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tipo: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Data Publicação: ");

        btgTipoOficio.add(jrbAta);
        jrbAta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbAta.setSelected(true);
        jrbAta.setText("Ata");
        jrbAta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jDateChooserPublicacao.setBackground(new java.awt.Color(204, 204, 255));
        jDateChooserPublicacao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 255), null, new java.awt.Color(204, 204, 255)));
        jDateChooserPublicacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Usuário: ");

        jtfUsuario.setBackground(new java.awt.Color(204, 204, 255));
        jtfUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Número Ata: ");

        jtfNumeroAta.setBackground(new java.awt.Color(204, 204, 255));
        jtfNumeroAta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNumeroAta.setText("1");
        jtfNumeroAta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Número Modalidade: ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Número Processo: ");

        jtfNumeroModalidade.setBackground(new java.awt.Color(204, 204, 255));
        jtfNumeroModalidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNumeroModalidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNumeroModalidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNumeroModalidadeFocusLost(evt);
            }
        });

        jtfNumeroProcesso.setBackground(new java.awt.Color(204, 204, 255));
        jtfNumeroProcesso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNumeroProcesso.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNumeroProcesso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNumeroProcessoFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Objeto: ");

        jtfObjetoAta.setBackground(new java.awt.Color(204, 204, 255));
        jtfObjetoAta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfObjetoAta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfObjetoAta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfObjetoAtaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Finalizada: ");

        jcbFinalizada.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbFinalizada.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NÃO", "SIM" }));
        jcbFinalizada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jpAtaLayout = new javax.swing.GroupLayout(jpAta);
        jpAta.setLayout(jpAtaLayout);
        jpAtaLayout.setHorizontalGroup(
            jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtaLayout.createSequentialGroup()
                        .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbAta)
                            .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfObjetoAta)
                                .addGroup(jpAtaLayout.createSequentialGroup()
                                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooserPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jtfNumeroProcesso)
                                .addComponent(jtfNumeroModalidade)
                                .addComponent(jtfNumeroAta))
                            .addComponent(jcbFinalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlbAnoAta))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpAtaLayout.setVerticalGroup(
            jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAtaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbAnoAta)
                .addGap(33, 33, 33)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jrbAta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpAtaLayout.createSequentialGroup()
                        .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfNumeroAta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooserPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfNumeroModalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNumeroProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfObjetoAta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpAtaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jcbFinalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jbNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        jbNovo.setText("Novo");
        jbNovo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbNovo.setEnabled(false);
        jbNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNovoActionPerformed(evt);
            }
        });

        jbSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jbSalvar.setText("Salvar");
        jbSalvar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalvarActionPerformed(evt);
            }
        });

        jbBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/reload.png"))); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(jbNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpAta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpAta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jdba == null) {
            jdba = new JdBuscaAta(null, true);
        }

        jdba.setCodigoUsuario(codigoUsuario);
        jdba.setVisible(true);

        setAtaBuscada(jdba.getAta());
        jdba.setAta();

    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNovoActionPerformed
        cancelar();
    }//GEN-LAST:event_jbNovoActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

        abilitaCampos();

        jbAlterar.setEnabled(false);

        opcao = "alterar";

        jbSalvar.setEnabled(true);

    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed

        if (jtfUsuario.getText().isEmpty() || jtfNumeroModalidade.getText().isEmpty() || jtfNumeroProcesso.getText().isEmpty() || jtfObjetoAta.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Preencha os campos 'Assunto', 'Destinatário' e 'Departamento'!", "Atenção", JOptionPane.WARNING_MESSAGE, null);

        } else {

            if (opcao.equals("salvar")) {

                verificaNumeroAta();
                    
                if (!ataVerificada.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Esse Número já foi cadastrado! \n Cancele o Documento para gerar outro Número!", "Atenção", JOptionPane.WARNING_MESSAGE, null);
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

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        excluir();
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        JOptionPane.showMessageDialog(null, "Atenção, Opção de Impressão ainda não disponivel!", "Atenção", JOptionPane.WARNING_MESSAGE, null);

    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtfNumeroModalidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNumeroModalidadeFocusLost
        iniciaClasseGeral();
        jtfNumeroModalidade.setText(classeGeral.somenteNumero(jtfNumeroModalidade.getText()));
    }//GEN-LAST:event_jtfNumeroModalidadeFocusLost

    private void jtfNumeroProcessoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNumeroProcessoFocusLost
        iniciaClasseGeral();
        jtfNumeroProcesso.setText(classeGeral.somenteNumero(jtfNumeroProcesso.getText()));
    }//GEN-LAST:event_jtfNumeroProcessoFocusLost

private void jtfObjetoAtaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfObjetoAtaFocusLost
    jtfObjetoAta.setText(jtfObjetoAta.getText().toUpperCase());
}//GEN-LAST:event_jtfObjetoAtaFocusLost
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new jfAgendamento().setVisible(true);
    }
    });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgTipoOficio;
    private com.toedter.calendar.JDateChooser jDateChooserPublicacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JComboBox jcbFinalizada;
    private javax.swing.JLabel jlbAnoAta;
    private javax.swing.JPanel jpAta;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JRadioButton jrbAta;
    private javax.swing.JTextField jtfNumeroAta;
    private javax.swing.JTextField jtfNumeroModalidade;
    private javax.swing.JTextField jtfNumeroProcesso;
    private javax.swing.JTextField jtfObjetoAta;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        /*if (!jtfUsuario.getText().equals(nomeUsuario) || !jtfNumeroOficio.getText().equals("0")) {

        JOptionPane.showMessageDialog(null, "Cancele ou Salve o Agendamento em Edição!", "Atenção", JOptionPane.WARNING_MESSAGE, null);

        } else {*/
        dao = null;
        this.dispose();
        //}
    }

    public void cancelar() {

        iniciaControleUsuario();
        
        jtfUsuario.setText(controleUsuario.getNomeUsuario(codigoUsuario));
        jrbAta.setSelected(true);
        jDateChooserPublicacao.setDate(getDateHoje());
        jtfNumeroAta.setText("");
        jtfNumeroModalidade.setText("");
        jtfNumeroProcesso.setText("");
        jtfObjetoAta.setText("");

        abilitaCampos();

        desabilitaBotoes();
        
        ata = null;

        opcao = "salvar";
        codigo = 0;

    }

    public void abilitaCampos() {

        jrbAta.setEnabled(true);
        jDateChooserPublicacao.setEnabled(true);
        jtfNumeroAta.setEditable(true);
        jtfNumeroModalidade.setEditable(true);
        jtfNumeroProcesso.setEditable(true);
        jtfObjetoAta.setEditable(true);

    }

    public void desabilitaCampos() {

        jrbAta.setEnabled(false);
        jDateChooserPublicacao.setEnabled(false);
        jtfNumeroAta.setEditable(false);
        jtfNumeroModalidade.setEditable(false);
        jtfNumeroProcesso.setEditable(false);
        jtfObjetoAta.setEditable(false);

    }

    public void bloqueiaCampos() {

        jtfUsuario.setEditable(false);
        
    }

    public void abilitaBotoes() {

        jbNovo.setEnabled(true);
        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(true);

        if (gerarNumeracao == true) {
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

        jbNovo.setEnabled(false);
        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(false);

        if (gerarNumeracao == true) {
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
    public void iniciaAta() {
        
        if (ata == null) {
            ata = new Ata();
        }
        
    }
    
    public void iniciaClasseGeral() {
    
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaControleUsuario() {
        
        if (controleUsuario == null) {
            controleUsuario = new ControleUsuario();
        }
        
    }
    
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
    
    public void iniciaLog() {
        
        if (geraLog == null) {
            geraLog = new Log();
        }
        
    }
    
    public void iniciaUsuario() {
        
        if (usuario == null) {
            usuario = new Usuario();
        }
        
    }
    
    public void verificaNumeroAta() {

        iniciaDao();

        ataVerificada = dao.verificarAta(Integer.valueOf(jtfNumeroAta.getText()), versao.getAno());

    }

//Getters and Setters===========================================================================================================================================
    public Date getDateHoje() {

        GregorianCalendar calendar = new GregorianCalendar();
        Date data = calendar.getTime();

        return data;

    }

    public String getAno() {

        return "Ano de " + versao.getAno();

    }

    public void setNumeroCaracteres() {
        jtfNumeroModalidade.setDocument(new FixedLengthDocument(240));
        jtfNumeroProcesso.setDocument(new FixedLengthDocument(120));
        jtfObjetoAta.setDocument(new FixedLengthDocument(120));
    }

    public void setAtaBuscada(Ata ataBuscada) {

        if (ataBuscada == null) {
        } else {

            iniciaAta();
            iniciaUsuario();
            
            usuario = (Usuario) ataBuscada.getUsuario();
            
            System.out.println(ataBuscada.getUsuario());
            jtfUsuario.setText(usuario.getNomeUsuario());
            jtfNumeroAta.setText("" + ataBuscada.getNumeroAta());
            jDateChooserPublicacao.setDate(ataBuscada.getDataPublicacaoVencimento());
            jtfNumeroModalidade.setText(ataBuscada.getNumeroModalidade()+"");
            jtfNumeroProcesso.setText(ataBuscada.getNumeroProcesso()+"");
            jtfObjetoAta.setText(ataBuscada.getObjeto());

            codigo = ataBuscada.getCodigoAta();//para testar comando excluir
            ata = ataBuscada;
            ata.setCodigoAta(codigo);

            opcao = "alterar";

            desabilitaCampos();

            abilitaBotoes();

        }
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        iniciaControleUsuario();
        jtfUsuario.setText(controleUsuario.getNomeUsuario(codigoUsuario));
        this.codigoUsuario = codigoUsuario;
        getPermissoes();
        desabilitaBotoes();
        setNumeroCaracteres();
    }

    public void getPermissoes() {
        Permissoes permissoes;
        iniciaDao();

        permissoes = (Permissoes) dao.buscaPermissoes(codigoUsuario);

        gerarNumeracao = permissoes.isGerarNumeracaoAtas();
    }

//Metodos DAO===========================================================================================================================================
    public void salvar() {

        if (!jtfUsuario.getText().isEmpty() && !jtfNumeroAta.getText().isEmpty() && jDateChooserPublicacao.getDate() != null) {

            iniciaDao();
            iniciaAta();
            iniciaUsuario();
            DateFormat df = DateFormat.getDateInstance();
            //int codigoAgend = dao.getCodigoAgendamento();
            
            ata.setAno(versao.getAno());
            ata.setDataPublicacaoVencimento(jDateChooserPublicacao.getDate());
            
            if (jcbFinalizada.getSelectedItem().toString().equals("NÃO")) {
                ata.setFinalizado(false);
            } else {
                ata.setFinalizado(true);
            }
            
            ata.setEmailEnviado(false);
            ata.setNumeroAta(Integer.parseInt(jtfNumeroAta.getText()));
            ata.setNumeroModalidade(Integer.parseInt(jtfNumeroModalidade.getText()));
            ata.setNumeroProcesso(Integer.parseInt(jtfNumeroProcesso.getText()));
            ata.setObjeto(jtfObjetoAta.getText());            
            
            usuario = (Usuario) dao.buscaUsuario(0, jtfUsuario.getText(), "");
            ata.setUsuario(usuario);
                        
            usuario = null;
            
            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Ata", "Tentou Salvar Nº: " + jtfNumeroAta.getText() + " Modalidade Nº: " + jtfNumeroModalidade.getText() + " Processo Nº: " + jtfNumeroProcesso.getText());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.inserir(ata, 7, codigoUsuario);
            cancelar();

        } else {
            JOptionPane.showMessageDialog(null, "Complete os Campos Obrigatórios, destacados em Azul!", "Atenção", JOptionPane.WARNING_MESSAGE, null);
        }

    }

    public void atualizar() {

        if (!jtfUsuario.getText().isEmpty() && !jtfNumeroAta.getText().isEmpty() && jDateChooserPublicacao.getDate() != null) {

            iniciaDao();
            iniciaAta();
            iniciaUsuario();
            DateFormat df = DateFormat.getDateInstance();
            //int codigoAgend = dao.getCodigoAgendamento();
            
            ata.setAno(versao.getAno());
            ata.setDataPublicacaoVencimento(jDateChooserPublicacao.getDate());
            
            if (jcbFinalizada.getSelectedItem().toString().equals("NÃO")) {
                ata.setFinalizado(false);
            } else {
                ata.setFinalizado(true);
            }
            
            ata.setNumeroAta(Integer.parseInt(jtfNumeroAta.getText()));
            ata.setNumeroModalidade(Integer.parseInt(jtfNumeroModalidade.getText()));
            ata.setNumeroProcesso(Integer.parseInt(jtfNumeroProcesso.getText()));
            ata.setObjeto(jtfObjetoAta.getText());            
            
            usuario = (Usuario) dao.buscaUsuario(0, jtfUsuario.getText(), "");
            ata.setUsuario(usuario);
                        
            usuario = null;

            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Ata", "Tentou Alterar Nº: " + jtfNumeroAta.getText() + " Modalidade Nº: " + jtfNumeroModalidade.getText() + " Processo Nº: " + jtfNumeroProcesso.getText());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.atualizar(ata, 7, codigoUsuario);
            cancelar();

        } else {
            JOptionPane.showMessageDialog(null, "Complete os Campos Obrigatórios, destacados em Azul!", "Atenção", JOptionPane.WARNING_MESSAGE, null);
        }

    }

    public void excluir() {

        iniciaClasseGeral();
        
        if (classeGeral.msgConfirma("Deseja excluir a Ata?")) {

            iniciaDao();
            iniciaAta();
            
            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Ata", "Tentou Excluir Nº: " + jtfNumeroAta.getText() + " Modalidade Nº: " + jtfNumeroModalidade.getText() + " Processo Nº: " + jtfNumeroProcesso.getText());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.excluir(ata, codigoUsuario);
            cancelar();

        }

    }
}
