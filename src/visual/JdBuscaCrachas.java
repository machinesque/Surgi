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

import controlador.ClasseGeral;
import controlador.ControleImagem;
import controlador.ControleVersao;
import controlador.FixedLengthDocument;
import dao.DAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import modelo.Crachas;
import modelo.Permissoes;

/**
 *
 * @author luizam
 */
public class JdBuscaCrachas extends javax.swing.JDialog {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private Crachas crachas;
    
    private int codigoUsuario;

    /** Creates new form jdBuscaAgendamento */
    public JdBuscaCrachas(java.awt.Frame parent, boolean modal) {
        super(parent, "Buscar Crachás - " + versao.getVersao() + " - " + versao.getAno(), modal);
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

        jpBotoes = new javax.swing.JPanel();
        jbBuscaFechar = new javax.swing.JButton();
        jbBuscaEnviarDados = new javax.swing.JButton();
        jbBuscaCancelar = new javax.swing.JButton();
        jbBuscaPesquisar = new javax.swing.JButton();
        jpEdital = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBuscaCrachas = new javax.swing.JTable();
        jDateChooserBuscaData = new com.toedter.calendar.JDateChooser();
        jtfBuscaNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfBuscaDepartamento = new javax.swing.JTextField();
        jtfBuscaCargo = new javax.swing.JTextField();

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

        javax.swing.GroupLayout jpBotoesLayout = new javax.swing.GroupLayout(jpBotoes);
        jpBotoes.setLayout(jpBotoesLayout);
        jpBotoesLayout.setHorizontalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
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
                    .addComponent(jbBuscaEnviarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpEdital.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        jpEdital.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Data: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Departamento: ");

        jtbBuscaCrachas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtbBuscaCrachas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtbBuscaCrachas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome 01", "Depto.", "Cargo", "Nome 02", "Depto.", "Cargo", "Nome 03", "Depto.", "Cargo", "Nome 04", "Depto.", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbBuscaCrachas.setGridColor(new java.awt.Color(204, 204, 204));
        jtbBuscaCrachas.setRowHeight(19);
        jtbBuscaCrachas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtbBuscaCrachas.getTableHeader().setReorderingAllowed(false);
        jtbBuscaCrachas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbBuscaCrachasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBuscaCrachas);

        jDateChooserBuscaData.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jDateChooserBuscaData.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jtfBuscaNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaNome.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaNomeFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Cargo: ");

        jtfBuscaDepartamento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaDepartamento.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaDepartamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaDepartamentoFocusLost(evt);
            }
        });

        jtfBuscaCargo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfBuscaCargo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfBuscaCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscaCargoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpEditalLayout = new javax.swing.GroupLayout(jpEdital);
        jpEdital.setLayout(jpEditalLayout);
        jpEditalLayout.setHorizontalGroup(
            jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditalLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfBuscaDepartamento, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addComponent(jtfBuscaCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addComponent(jDateChooserBuscaData, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(437, Short.MAX_VALUE))
            .addGroup(jpEditalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpEditalLayout.setVerticalGroup(
            jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpEditalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfBuscaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfBuscaDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfBuscaCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpEditalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jDateChooserBuscaData, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpEdital, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpEdital, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
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

    private void jtbBuscaCrachasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBuscaCrachasMouseClicked


            if (evt.getClickCount() == 2) {

                buscaDados();

            }


    }//GEN-LAST:event_jtbBuscaCrachasMouseClicked

    private void jtfBuscaNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaNomeFocusLost
        
    }//GEN-LAST:event_jtfBuscaNomeFocusLost

    private void jtfBuscaDepartamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaDepartamentoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscaDepartamentoFocusLost

    private void jtfBuscaCargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscaCargoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfBuscaCargoFocusLost
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
    private com.toedter.calendar.JDateChooser jDateChooserBuscaData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscaCancelar;
    private javax.swing.JButton jbBuscaEnviarDados;
    private javax.swing.JButton jbBuscaFechar;
    private javax.swing.JButton jbBuscaPesquisar;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpEdital;
    private javax.swing.JTable jtbBuscaCrachas;
    private javax.swing.JTextField jtfBuscaCargo;
    private javax.swing.JTextField jtfBuscaDepartamento;
    private javax.swing.JTextField jtfBuscaNome;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        cancelar();
        this.dispose();

    }

    public void cancelar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaCrachas.getModel();

        jDateChooserBuscaData.setDate(null);
        jtfBuscaCargo.setText("");
        jtfBuscaNome.setText("");
        jtfBuscaDepartamento.setText("");
        
        jDateChooserBuscaData.setDate(null);

        modelo.setRowCount(0);
        
        dao = null;

    }

    public void pesquisar() {

        DefaultTableModel modelo = (DefaultTableModel) jtbBuscaCrachas.getModel();
        final TableRowSorter<TableModel> tabelaSorter = new TableRowSorter<TableModel>(modelo);
        jtbBuscaCrachas.setRowSorter(tabelaSorter);
        
        iniciaDao();
        
        List listaCrachas = new ArrayList();
        Date dataCracha;

        if (jDateChooserBuscaData.getDate() != null) {
            dataCracha = jDateChooserBuscaData.getDate();
        } else {
            dataCracha = null;
        }
        
        listaCrachas = dao.listarCrachas(jtfBuscaNome.getText(), jtfBuscaDepartamento.getText(), jtfBuscaCargo.getText(), dataCracha);
        //listaAgendamento = dao.listarAgendamento(nomeEntid, new java.sql.Date(dataSolic.getTime()), tipoEntid);Usando jFormatedTextField
            
        modelo.setRowCount(0);

        for (int i = 0; i < listaCrachas.size(); i++) {

            iniciaCrachas();
            
            crachas = (Crachas) listaCrachas.get(i);

            modelo.addRow(new String[]{String.valueOf(crachas.getCodigoCrachas()), crachas.getNomeCracha1(), crachas.getDepartamentoCracha1(), crachas.getCargoCracha1(), crachas.getNomeCracha2(), 
                crachas.getDepartamentoCracha2(), crachas.getCargoCracha2(), crachas.getNomeCracha3(), crachas.getDepartamentoCracha3(), crachas.getCargoCracha3(), crachas.getNomeCracha4(),
                crachas.getDepartamentoCracha4(), crachas.getCargoCracha4()});

            crachas = null;
            
        }

        if (jtbBuscaCrachas.getRowCount() > 0) {
            jtbBuscaCrachas.getSelectionModel().setSelectionInterval(0, 0);
        } else {
            iniciaClasseGeral();
            
            classeGeral.msgInforma("Não há crachás com estes dados!");
        }

    }

    public void buscaDados() {

        iniciaDao();
        iniciaCrachas();
        //DAO dao = new DAO();

        int codigo;

        codigo = Integer.valueOf((String) jtbBuscaCrachas.getValueAt(jtbBuscaCrachas.getSelectedRow(), 0));

        crachas = (Crachas) dao.busca(crachas, codigo);
        dao.encerraSessao();

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
    
    public void iniciaCrachas() {
        
        if (crachas == null) {
            crachas = new Crachas();
        }
        
    }
    
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
    
//Getters and Setters===========================================================================================================================================
    public void setNumeroCaracteres(){

        jtfBuscaDepartamento.setDocument(new FixedLengthDocument(30));
        jtfBuscaCargo.setDocument(new FixedLengthDocument(30));
        jtfBuscaNome.setDocument(new FixedLengthDocument(18));

    }

    public Crachas getCrachas() {

        return crachas;

    }

    public void setCrachas() {
        crachas = null;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
        //getPermissoes();
    }

    public void getPermissoes() {
        Permissoes permissoes;
        iniciaDao();
        //DAO dao = new DAO();

        permissoes = (Permissoes) dao.buscaPermissoes(codigoUsuario);

        //visualizarTodos = permissoes.isVisualizarTodosEditais();
    }

//Metodos DAO===========================================================================================================================================
    

}
