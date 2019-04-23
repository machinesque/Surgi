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
import modelo.Cmei;
import modelo.EquipamentoEntidades;
import modelo.Escola;
import modelo.Outro;

/**
 *
 * @author luizam
 */
public class JdBuscaEquipamentosEntidades extends javax.swing.JDialog {

    
    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private Cmei cmei;
    private ControleCmei controleCmei;
    private ControleEscola controleEscola;
    private ControleImagem controleImagem = new ControleImagem();
    private ControleOutro controleOutro;
    private DAO dao;
    private EditaOrdemTabela editaOrdemTabela;
    private EquipamentoEntidades equipamentoEntidades;
    private Escola escola;
    private Outro outro;
    
    private String tipoEntidade = "";

    /** Creates new form jdBuscaAgendamento */
    public JdBuscaEquipamentosEntidades(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Equipamentos Entidades - " + versao.getVersao() + " - " + versao.getAno(), modal);
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

        preencheComboEquipamentoEntidades();
        preencheComboEscolas();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgSelecaoEntidades = new javax.swing.ButtonGroup();
        jpBotoes = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jpBuscaEquipamentoEntidade = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaEquipamentoEntidades = new javax.swing.JTable();
        jcbBuscaMarcaEquipamento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jtfBuscaModelo = new javax.swing.JTextField();
        jtfBuscaPatrimonio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jrbBuscaEquipamentoEntidadeTodos = new javax.swing.JRadioButton();
        jrbBuscaEquipamentoEntidadeEscola = new javax.swing.JRadioButton();
        jrbBuscaEquipamentoEntidadeCmei = new javax.swing.JRadioButton();
        jcbBuscaNomeEntidade = new javax.swing.JComboBox();
        jtfBuscaSetor = new javax.swing.JTextField();
        jrbBuscaEquipamentoEntidadeOutros = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
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
        jbBuscaCancelar.setMnemonic('c');
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

        jpBuscaEquipamentoEntidade.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Modelo: ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Marca: ");

        jtbBuscaEquipamentoEntidades.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtbBuscaEquipamentoEntidades.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbBuscaEquipamentoEntidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Marca", "Modelo", "Patrimonio", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbBuscaEquipamentoEntidades.setGridColor(new java.awt.Color(204, 204, 204));
        jtbBuscaEquipamentoEntidades.setRowHeight(19);
        jtbBuscaEquipamentoEntidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbBuscaEquipamentoEntidades.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbBuscaEquipamentoEntidades);

        jcbBuscaMarcaEquipamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbBuscaMarcaEquipamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jcbBuscaMarcaEquipamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("TipoEntidade: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nome Entidade: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Setor: ");

        btgSelecaoEntidades.add(jrbBuscaEquipamentoEntidadeTodos);
        jrbBuscaEquipamentoEntidadeTodos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbBuscaEquipamentoEntidadeTodos.setSelected(true);
        jrbBuscaEquipamentoEntidadeTodos.setText("Todos");
        jrbBuscaEquipamentoEntidadeTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBuscaEquipamentoEntidadeTodosActionPerformed(evt);
            }
        });

        btgSelecaoEntidades.add(jrbBuscaEquipamentoEntidadeEscola);
        jrbBuscaEquipamentoEntidadeEscola.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbBuscaEquipamentoEntidadeEscola.setText("Escola");
        jrbBuscaEquipamentoEntidadeEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBuscaEquipamentoEntidadeEscolaActionPerformed(evt);
            }
        });

        btgSelecaoEntidades.add(jrbBuscaEquipamentoEntidadeCmei);
        jrbBuscaEquipamentoEntidadeCmei.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbBuscaEquipamentoEntidadeCmei.setText("CMEI");
        jrbBuscaEquipamentoEntidadeCmei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBuscaEquipamentoEntidadeCmeiActionPerformed(evt);
            }
        });

        jcbBuscaNomeEntidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbBuscaNomeEntidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfBuscaSetor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaSetor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaSetor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaSetorFocusLost(evt);
            }
        });

        btgSelecaoEntidades.add(jrbBuscaEquipamentoEntidadeOutros);
        jrbBuscaEquipamentoEntidadeOutros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbBuscaEquipamentoEntidadeOutros.setText("Outros");
        jrbBuscaEquipamentoEntidadeOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbBuscaEquipamentoEntidadeOutrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBuscaEquipamentoEntidadeLayout = new javax.swing.GroupLayout(jpBuscaEquipamentoEntidade);
        jpBuscaEquipamentoEntidade.setLayout(jpBuscaEquipamentoEntidadeLayout);
        jpBuscaEquipamentoEntidadeLayout.setHorizontalGroup(
            jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscaEquipamentoEntidadeLayout.createSequentialGroup()
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBuscaEquipamentoEntidadeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jpBuscaEquipamentoEntidadeLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpBuscaEquipamentoEntidadeLayout.createSequentialGroup()
                                    .addComponent(jrbBuscaEquipamentoEntidadeTodos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jrbBuscaEquipamentoEntidadeEscola)
                                    .addGap(2, 2, 2)
                                    .addComponent(jrbBuscaEquipamentoEntidadeCmei)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jrbBuscaEquipamentoEntidadeOutros))
                                .addComponent(jcbBuscaNomeEntidade, 0, 618, Short.MAX_VALUE)
                                .addComponent(jtfBuscaSetor))
                            .addComponent(jcbBuscaMarcaEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfBuscaPatrimonio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfBuscaModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(259, 259, 259)))
                .addContainerGap())
        );
        jpBuscaEquipamentoEntidadeLayout.setVerticalGroup(
            jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscaEquipamentoEntidadeLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jrbBuscaEquipamentoEntidadeTodos)
                    .addComponent(jrbBuscaEquipamentoEntidadeEscola)
                    .addComponent(jrbBuscaEquipamentoEntidadeCmei)
                    .addComponent(jrbBuscaEquipamentoEntidadeOutros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbBuscaNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfBuscaSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbBuscaMarcaEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfBuscaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jpBuscaEquipamentoEntidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfBuscaPatrimonio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBuscaEquipamentoEntidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpBuscaEquipamentoEntidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        preencheComboEquipamentoEntidades();
    }//GEN-LAST:event_formWindowOpened

    private void jtfBuscaModeloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaModeloFocusLost
        jtfBuscaModelo.setText(jtfBuscaModelo.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaModeloFocusLost

    private void jtfBuscaPatrimonioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaPatrimonioFocusLost
        jtfBuscaPatrimonio.setText(jtfBuscaPatrimonio.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaPatrimonioFocusLost

    private void jrbBuscaEquipamentoEntidadeEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBuscaEquipamentoEntidadeEscolaActionPerformed
        if (jrbBuscaEquipamentoEntidadeEscola.isSelected()) {
            tipoEntidade = "ESCOLA";
            preencheComboEscolas();
        }
    }//GEN-LAST:event_jrbBuscaEquipamentoEntidadeEscolaActionPerformed

    private void jrbBuscaEquipamentoEntidadeCmeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBuscaEquipamentoEntidadeCmeiActionPerformed
        if (jrbBuscaEquipamentoEntidadeCmei.isSelected()) {
            tipoEntidade = "CMEI";
            preencheComboCmeis();
        }
    }//GEN-LAST:event_jrbBuscaEquipamentoEntidadeCmeiActionPerformed

    private void jrbBuscaEquipamentoEntidadeOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBuscaEquipamentoEntidadeOutrosActionPerformed
        if (jrbBuscaEquipamentoEntidadeOutros.isSelected()) {
            tipoEntidade = "OUTROS";
            preencheComboOutros();
        }
    }//GEN-LAST:event_jrbBuscaEquipamentoEntidadeOutrosActionPerformed

    private void jrbBuscaEquipamentoEntidadeTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBuscaEquipamentoEntidadeTodosActionPerformed
        if (jrbBuscaEquipamentoEntidadeTodos.isSelected()) {
            tipoEntidade = "";
        }
    }//GEN-LAST:event_jrbBuscaEquipamentoEntidadeTodosActionPerformed

    private void jtfBuscaSetorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaSetorFocusLost
        jtfBuscaSetor.setText(jtfBuscaSetor.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaSetorFocusLost
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
    private javax.swing.ButtonGroup btgSelecaoEntidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JComboBox jcbBuscaMarcaEquipamento;
    private javax.swing.JComboBox jcbBuscaNomeEntidade;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpBuscaEquipamentoEntidade;
    private javax.swing.JRadioButton jrbBuscaEquipamentoEntidadeCmei;
    private javax.swing.JRadioButton jrbBuscaEquipamentoEntidadeEscola;
    private javax.swing.JRadioButton jrbBuscaEquipamentoEntidadeOutros;
    private javax.swing.JRadioButton jrbBuscaEquipamentoEntidadeTodos;
    private javax.swing.JTable jtbBuscaEquipamentoEntidades;
    private javax.swing.JTextField jtfBuscaModelo;
    private javax.swing.JTextField jtfBuscaPatrimonio;
    private javax.swing.JTextField jtfBuscaSetor;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        cancelar();
        dao = null;
        this.dispose();

    }

    public void cancelar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaEquipamentoEntidades.getModel();

        jcbBuscaMarcaEquipamento.setSelectedIndex(0);
        jtfBuscaModelo.setText("");
        jtfBuscaPatrimonio.setText("");

        cmei = null;
        escola = null;
        outro = null;
        
        modelo.setRowCount(0);
        
        preencheComboEquipamentoEntidades();

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaEquipamentoEntidades.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbBuscaEquipamentoEntidades.setRowSorter(tabelaSorter);
        
        iniciaDao();
        EquipamentoEntidades equipEntidade;
        List listaEquipamentoEntidade = new ArrayList();
        int codigoCmei = 0;
        int codigoEscola = 0;
        int codigoOutro = 0;
        String marcaMulti;
        String nomeEntid;

        if (jcbBuscaMarcaEquipamento.getSelectedIndex() == 0) {
            marcaMulti = "";
        } else {
            marcaMulti = (String) jcbBuscaMarcaEquipamento.getSelectedItem();
        }

        if (jcbBuscaNomeEntidade.getSelectedIndex() == 0) {
            nomeEntid = "";
        } else {
            nomeEntid = jcbBuscaNomeEntidade.getSelectedItem().toString();
        }
        
        if (jcbBuscaNomeEntidade.getSelectedIndex() != 0) {
            switch (tipoEntidade) {
            
                case "CMEI":
                    iniciaCmei();
                    iniciaControleCmei();
                    codigoCmei = controleCmei.getCodigoCmei(jcbBuscaNomeEntidade.getSelectedItem().toString());
                    break;
                
                case "ESCOLA":
                    iniciaControleEscola();
                    iniciaEscola();
                    codigoEscola = controleEscola.getCodigoEscola(jcbBuscaNomeEntidade.getSelectedItem().toString());
                    break;
                
                case "OUTROS":
                    iniciaControleOutro();
                    iniciaOutro();
                    codigoOutro = controleOutro.getCodigoOutro(jcbBuscaNomeEntidade.getSelectedItem().toString());
                    break;
                
            }
        }

        listaEquipamentoEntidade = (List) dao.listarEquipamentoEntidades(codigoCmei, codigoEscola, codigoOutro, marcaMulti, jtfBuscaModelo.getText(), jtfBuscaPatrimonio.getText(), jtfBuscaSetor.getText(), tipoEntidade);

        modelo.setRowCount(0);
        iniciaEditaOrdemTabela();

        for (int i = 0; i < listaEquipamentoEntidade.size(); i++) {

            equipEntidade = (EquipamentoEntidades) listaEquipamentoEntidade.get(i);

            modelo.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), equipEntidade.getMarcaEquipamentoEntidade(), equipEntidade.getModeloEquipamentoEntidade(), equipEntidade.getPatrimonioEquipamentoEntidade(), String.valueOf(equipEntidade.getCodigoEquipamentoEntidade())});

        }

        if (jtbBuscaEquipamentoEntidades.getRowCount() > 0) {
            jtbBuscaEquipamentoEntidades.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há equipamentos cadastrados com estes dados!");
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaEquipamentoEntidades();

        int codigo;

        codigo = Integer.valueOf(jtbBuscaEquipamentoEntidades.getValueAt(jtbBuscaEquipamentoEntidades.getSelectedRow(), 4).toString());

        equipamentoEntidades = (EquipamentoEntidades) dao.busca(equipamentoEntidades, codigo);
        dao.encerraSessao();

    }

    public void preencheComboEscolas() {

        iniciaDao();
        List listaEscolas = new ArrayList();

        jcbBuscaNomeEntidade.removeAllItems();
        jcbBuscaNomeEntidade.addItem("");

        listaEscolas = dao.listarEscolas(0, "", "");

        for (int i = 0; i < listaEscolas.size(); i++) {
            jcbBuscaNomeEntidade.addItem(listaEscolas.get(i));
        }

    }

    public void preencheComboCmeis() {

        iniciaDao();
        List listaCmeis = new ArrayList();

        jcbBuscaNomeEntidade.removeAllItems();
        jcbBuscaNomeEntidade.addItem("");

        listaCmeis = dao.listarCmeis(0, "", "");

        for (int i = 0; i < listaCmeis.size(); i++) {
            jcbBuscaNomeEntidade.addItem(listaCmeis.get(i));
        }
    }

    public void preencheComboOutros() {

        iniciaDao();
        
        List listaOutros = new ArrayList();

        jcbBuscaNomeEntidade.removeAllItems();
        jcbBuscaNomeEntidade.addItem("");

        listaOutros = dao.listarOutros(0, "", "");

        for (int i = 0; i < listaOutros.size(); i++) {
            jcbBuscaNomeEntidade.addItem(listaOutros.get(i));
        }

    }

    public void preencheComboEquipamentoEntidades() {

        iniciaDao();
        
        EquipamentoEntidades equipEntid = new EquipamentoEntidades();
        List listaEquipamentoEntidades = new ArrayList();

        jcbBuscaMarcaEquipamento.removeAllItems();
        jcbBuscaMarcaEquipamento.addItem("");

        listaEquipamentoEntidades = dao.listarEquipamentoEntidades(0, 0, 0, "", "", "", "", "");

        for (int i = 0; i < listaEquipamentoEntidades.size(); i++) {
            equipEntid = (EquipamentoEntidades) listaEquipamentoEntidades.get(i);
            jcbBuscaMarcaEquipamento.addItem(equipEntid.getMarcaEquipamentoEntidade());
        }

    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaCmei() {
        
        if (cmei == null) {
            cmei = new Cmei();
        }
        
    }
    
    public void iniciaControleCmei() {
        
        if (controleCmei == null) {
            controleCmei = new ControleCmei();
        }
        
    }
    
    public void iniciaControleEscola() {
        
        if (controleEscola == null) {
            controleEscola = new ControleEscola();
        }
        
    }
    
    public void iniciaControleOutro() {
        
        if (controleOutro == null) {
            controleOutro = new ControleOutro();
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
    
    public void iniciaEscola() {
        
        if (escola == null) {
            escola = new Escola();
        }
        
    }
    
    public void iniciaEquipamentoEntidades() {
        
        if (equipamentoEntidades == null) {
            equipamentoEntidades = new EquipamentoEntidades();
        }
        
    }
    
    public void iniciaOutro() {
        
        if (outro == null) {
            outro = new Outro();
        }
        
    }
    
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres() {

        jtfBuscaSetor.setDocument(new FixedLengthDocument(120));
        jtfBuscaModelo.setDocument(new FixedLengthDocument(120));
        jtfBuscaPatrimonio.setDocument(new FixedLengthDocument(10));

    }

    public EquipamentoEntidades getEquipamentoEntidades() {

        return equipamentoEntidades;

    }

    public void setEquipamentoEntidades() {
        equipamentoEntidades = null;
    }

//Metodos DAO===========================================================================================================================================
    

}
