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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Oficio;
import modelo.Permissoes;
import modelo.Usuario;

/**
 *
 * @author luizam
 */
public class JdBuscaOficio extends javax.swing.JDialog {
    
    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private ControleUsuario controleUsuario;
    private DAO dao;
    private EditaOrdemTabela editaOrdemTabela;
    private Oficio oficio;
    private Usuario usuario;
    
    private int codigoUsuario;
    private String modeloOfic = "TODOS";
    private String opcao = "salvar";
    private final String TIPOOFICIO = "GERAL";
    private boolean visualizarTodos;

    /** Creates new form jdBuscaAgendamento */
    public JdBuscaOficio(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Ofício - " + versao.getVersao() + " - " + versao.getAno(), modal);
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

        jtfBuscaUsuario.setEditable(false);
        jrbTodosOficio.setSelected(true);

        setNumeroOficios();

        setNumeroCaracteres();

        /*try {
            jftfBuscaDataSolicitacao.setFormatterFactory(getFormatoData());
        } catch (ParseException ex) {
            Logger.getLogger(jdBuscaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possivel formatar o campo data!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, null);
        }*/

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
        jPanel1 = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaOficio = new javax.swing.JTable();
        jrbOficio = new javax.swing.JRadioButton();
        jrbOficioCircular = new javax.swing.JRadioButton();
        jDateChooserBuscaSolicitacaoInicio = new com.toedter.calendar.JDateChooser();
        jrbCi = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jrbTodosOficio = new javax.swing.JRadioButton();
        jtfBuscaUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jYearChooserAnoOficio = new com.toedter.calendar.JYearChooser();
        jLabel4 = new javax.swing.JLabel();
        jDateChooserBuscaSolicitacaoTermino = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lbOficio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbOficioCircular = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbCi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(573, Short.MAX_VALUE)
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
                    .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Período: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nome Usuário: ");

        jtbBuscaOficio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtbBuscaOficio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbBuscaOficio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ordem", "Nome do Usuário", "Tipo do Ofício", "Assunto", "Número Gerado", "Data da Solicitação", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbBuscaOficio.setGridColor(new java.awt.Color(204, 204, 204));
        jtbBuscaOficio.setRowHeight(19);
        jtbBuscaOficio.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbBuscaOficio.getTableHeader().setReorderingAllowed(false);
        jtbBuscaOficio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbBuscaOficioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBuscaOficio);

        btgTipoOficio.add(jrbOficio);
        jrbOficio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOficio.setText("Ofício");
        jrbOficio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jrbOficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOficioActionPerformed(evt);
            }
        });

        btgTipoOficio.add(jrbOficioCircular);
        jrbOficioCircular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbOficioCircular.setText("Ofício Circular");
        jrbOficioCircular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jrbOficioCircular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOficioCircularActionPerformed(evt);
            }
        });

        jDateChooserBuscaSolicitacaoInicio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDateChooserBuscaSolicitacaoInicio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btgTipoOficio.add(jrbCi);
        jrbCi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbCi.setText("CI");
        jrbCi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jrbCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCiActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Tipo de Ofício: ");

        btgTipoOficio.add(jrbTodosOficio);
        jrbTodosOficio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrbTodosOficio.setSelected(true);
        jrbTodosOficio.setText("Todos");
        jrbTodosOficio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosOficioActionPerformed(evt);
            }
        });

        jtfBuscaUsuario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaUsuarioFocusLost(evt);
            }
        });

        jLabel3.setText("Ano: ");

        jYearChooserAnoOficio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("até");

        jDateChooserBuscaSolicitacaoTermino.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDateChooserBuscaSolicitacaoTermino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jDateChooserBuscaSolicitacaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserBuscaSolicitacaoTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jYearChooserAnoOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jrbTodosOficio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbOficio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbOficioCircular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbCi)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jrbTodosOficio)
                    .addComponent(jrbOficio)
                    .addComponent(jrbOficioCircular)
                    .addComponent(jrbCi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfBuscaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDateChooserBuscaSolicitacaoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jYearChooserAnoOficio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jDateChooserBuscaSolicitacaoTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Últimos Números Gerados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Ofício: ");

        lbOficio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbOficio.setText("lbOficio");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Ofício Circular:");

        lbOficioCircular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbOficioCircular.setText("lbOficioCircular");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("CI: ");

        lbCi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbCi.setText("lbCi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbOficio)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbOficioCircular)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbOficio)
                    .addComponent(jLabel6)
                    .addComponent(lbOficioCircular)
                    .addComponent(jLabel7)
                    .addComponent(lbCi))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        setNumeroOficios();
    }//GEN-LAST:event_jbBuscaPesquisarActionPerformed

    private void jbBuscaCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_jbBuscaCancelarActionPerformed

    private void jbBuscaEnviarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscaEnviarDadosActionPerformed
        buscaDados();
        fechar();
    }//GEN-LAST:event_jbBuscaEnviarDadosActionPerformed

    private void jrbOficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOficioActionPerformed

        if (jrbOficio.isSelected() == true) {
            modeloOfic = "OFICIO";
        }

    }//GEN-LAST:event_jrbOficioActionPerformed

    private void jrbOficioCircularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOficioCircularActionPerformed

        if (jrbOficioCircular.isSelected() == true) {
            modeloOfic = "OFICIO CIRCULAR";
        }

    }//GEN-LAST:event_jrbOficioCircularActionPerformed

    private void jrbCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCiActionPerformed

        if (jrbCi.isSelected() == true) {
            modeloOfic = "CI";
        }

    }//GEN-LAST:event_jrbCiActionPerformed

    private void jtbBuscaOficioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBuscaOficioMouseClicked
        
        if (evt.getClickCount() == 2) {

            buscaDados();

        }

    }//GEN-LAST:event_jtbBuscaOficioMouseClicked

    private void jrbTodosOficioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosOficioActionPerformed

        if (jrbTodosOficio.isSelected() == true) {
            modeloOfic = "TODOS";
        }

    }//GEN-LAST:event_jrbTodosOficioActionPerformed

    private void jtfBuscaUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaUsuarioFocusLost
        jtfBuscaUsuario.setText(jtfBuscaUsuario.getText().toUpperCase());
    }//GEN-LAST:event_jtfBuscaUsuarioFocusLost
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
    private javax.swing.ButtonGroup btgTipoOficio;
    private com.toedter.calendar.JDateChooser jDateChooserBuscaSolicitacaoInicio;
    private com.toedter.calendar.JDateChooser jDateChooserBuscaSolicitacaoTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jYearChooserAnoOficio;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JRadioButton jrbCi;
    private javax.swing.JRadioButton jrbOficio;
    private javax.swing.JRadioButton jrbOficioCircular;
    private javax.swing.JRadioButton jrbTodosOficio;
    private javax.swing.JTable jtbBuscaOficio;
    private javax.swing.JTextField jtfBuscaUsuario;
    private javax.swing.JLabel lbCi;
    private javax.swing.JLabel lbOficio;
    private javax.swing.JLabel lbOficioCircular;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        cancelar();
        dao = null;
        this.dispose();

    }

    public void cancelar() {

        iniciaControleUsuario();
        
        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaOficio.getModel();

        jDateChooserBuscaSolicitacaoInicio.setDate(null);
        jDateChooserBuscaSolicitacaoTermino.setDate(null);
        jtfBuscaUsuario.setText(controleUsuario.getNomeUsuario(codigoUsuario));
        jrbOficio.setSelected(false);
        modeloOfic = "TODOS";
        jrbOficioCircular.setSelected(false);
        jrbCi.setSelected(false);
        jrbTodosOficio.setSelected(true);

        modelo.setRowCount(0);

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaOficio.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbBuscaOficio.setRowSorter(tabelaSorter);
        
        iniciaDao();
        iniciaControleUsuario();
        
        Oficio ofic;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        List listaOficio = new ArrayList();
        int codigoBuscaUsuario;
        Date dataSolicTermino;

        if (jDateChooserBuscaSolicitacaoTermino.getDate() == null) {
            dataSolicTermino = null;
        } else {
            dataSolicTermino = jDateChooserBuscaSolicitacaoTermino.getDate();
        }
        
        if (!jtfBuscaUsuario.getText().isEmpty()) {
            codigoBuscaUsuario = controleUsuario.getCodigoUsuario(jtfBuscaUsuario.getText());
        } else {
            codigoBuscaUsuario = 0;
        }
        
        if (jDateChooserBuscaSolicitacaoInicio.getDate() == null) {
            listaOficio = dao.listarOficio(codigoBuscaUsuario, null, dataSolicTermino, modeloOfic, TIPOOFICIO, String.valueOf(jYearChooserAnoOficio.getYear()));
        } else {
            //try {
                //dataSolic = df.parse(jftfBuscaDataSolicitacao.getText()); Usando jFormatedTextField
            //} catch (ParseException ex) {
            //    Logger.getLogger(jdBuscaAgendamento.class.getName()).log(Level.SEVERE, null, ex);
            //}
            listaOficio = dao.listarOficio(codigoBuscaUsuario, jDateChooserBuscaSolicitacaoInicio.getDate(), dataSolicTermino, modeloOfic, TIPOOFICIO, String.valueOf(jYearChooserAnoOficio.getYear()));
        }

        //listaAgendamento = dao.listarAgendamento(nomeEntid, new java.sql.Date(dataSolic.getTime()), tipoEntid);Usando jFormatedTextField
            
        modelo.setRowCount(0);
        iniciaEditaOrdemTabela();

        for (int i = 0; i < listaOficio.size(); i++) {
            
            iniciaUsuario();
            ofic = (Oficio) listaOficio.get(i);
            usuario = (Usuario) ofic.getUsuario();
            
            modelo.addRow(new String[]{editaOrdemTabela.editaOrdem(i + 1), usuario.getNomeUsuario(), ofic.getModeloOficio(), ofic.getAssuntoOficio(), String.valueOf(ofic.getNumero()), String.valueOf(ofic.getDataSolicitacao()), String.valueOf(ofic.getCodigoOficio())});

        }

        if (jtbBuscaOficio.getRowCount() > 0) {
            jtbBuscaOficio.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há Ofícios/Ofícios Circulares/CI's com estes dados!");
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaOficio();

        int codigo;

        codigo = Integer.valueOf((String) jtbBuscaOficio.getValueAt(jtbBuscaOficio.getSelectedRow(), 6));

        oficio = (Oficio) dao.busca(oficio, codigo);

    }

    public void bloqueiaCampos() {

        if (visualizarTodos) {
            jtfBuscaUsuario.setEditable(true);
        } else {
            jtfBuscaUsuario.setEditable(false);
        }
    }

    /*public void preencheCombo() {

    if (jcbBuscaTipoEntidade.getSelectedIndex() == 0) {
    preencheComboEscolas();
    } else {
    preencheComboCmeis();
    }

    }*/

//Geradores, Validadores===========================================================================================================================================
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
    
    public void iniciaEditaOrdemTabela() {
        
        if (editaOrdemTabela == null) {
            editaOrdemTabela = new EditaOrdemTabela();
        }
        
    }
    
    public void iniciaOficio() {
        
        if (oficio == null) {
            oficio = new Oficio();
        }
        
    }
    
    public void iniciaUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
    }
    
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres(){

        jtfBuscaUsuario.setDocument(new FixedLengthDocument(120));

    }

    public void setNumeroOficios() {

        iniciaDao();
        //DAO dao = new DAO();

        lbOficio.setText("" + dao.getNumeroGeradoOficio(versao.getAno(), TIPOOFICIO));
        lbOficioCircular.setText("" + dao.getNumeroGeradoOficioCircular(versao.getAno(), TIPOOFICIO));
        lbCi.setText("" + dao.getNumeroGeradoCi(versao.getAno(), TIPOOFICIO));

    }

    public Oficio getOficio() {

        return oficio;

    }

    public void setOficio() {
        oficio = null;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        iniciaControleUsuario();
        jtfBuscaUsuario.setText(controleUsuario.getNomeUsuario(codigoUsuario));
        this.codigoUsuario = codigoUsuario;
        getPermissoes();
        bloqueiaCampos();
    }

    public void getPermissoes() {
        Permissoes permissoes;
        iniciaDao();
        //DAO dao = new DAO();

        permissoes = (Permissoes) dao.buscaPermissoes(codigoUsuario);

        visualizarTodos = permissoes.isVisualizarTodosOficiosGeral();
    }

//Metodos DAO===========================================================================================================================================
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }

}
