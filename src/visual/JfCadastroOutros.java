/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfCadastroEscola.java
 *
 * Created on 27/01/2010, 09:03:18
 */
package visual;

import conexao.Conexao;
import controlador.*;
import dao.DAO;
import excecoes.ExcCadastro;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import modelo.Outro;
import modelo.Permissoes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luiz
 */
public class JfCadastroOutros extends javax.swing.JFrame {
    
    private static ControleVersao versao = new ControleVersao();
    private CadastroEmail cadastroEmail;
    private ClasseGeral classeGeral;
    private ControleImagem controleImagem = new ControleImagem();
    private DAO dao;
    private Log geraLog;
    private Outro outro;
    
    private JdBuscaOutros jdbo;
    private JfCadastroEndereco jfCadastroEndereco;
    
    private JasperPrint jPrint;
    private JasperViewer jViewer;
    
    private int codigo = 0;
    private int codigoUsuario;
    private String opcao = "salvar";
    private boolean cadastrarOutros;

    /** Creates new form jfCadastroEscola */
    public JfCadastroOutros() {
        super("Cadastro Outras Entidades - " + versao.getVersao() + " - " + versao.getAno());
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

        try {
            jftfTelefone.setFormatterFactory(getFormatoTelefone());
        } catch (ParseException ex) {
            iniciaClasseGeral();
            Logger.getLogger(JfCadastroOutros.class.getName()).log(Level.SEVERE, null, ex);
            classeGeral.msgErro("Não foi possivel formatar campo de telefone, \n Contate o Administrador!");
        }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfNomeEntidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jftfTelefone = new javax.swing.JFormattedTextField();
        jtfCoordenadorAtual = new javax.swing.JTextField();
        jtfCoordenadorAnterior = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbCadastroEndereco = new javax.swing.JButton();
        jpBotoes = new javax.swing.JPanel();
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

        jPanel1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome da Unidade: ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("E-mail: ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Telefone: ");

        jtfNomeEntidade.setBackground(new java.awt.Color(204, 204, 255));
        jtfNomeEntidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfNomeEntidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfNomeEntidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfNomeEntidadeFocusLost(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Coordenador Atual: ");

        jftfTelefone.setBackground(new java.awt.Color(204, 204, 255));
        jftfTelefone.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jftfTelefone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jftfTelefone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jftfTelefoneFocusLost(evt);
            }
        });

        jtfCoordenadorAtual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfCoordenadorAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfCoordenadorAtual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCoordenadorAtualFocusLost(evt);
            }
        });

        jtfCoordenadorAnterior.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfCoordenadorAnterior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfCoordenadorAnterior.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfCoordenadorAnteriorFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Coordenador Anterior: ");

        jtfEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtfEmail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jtfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfEmailFocusLost(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("@cascavel.pr.gov.br");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Endereço: ");

        jbCadastroEndereco.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbCadastroEndereco.setText("Adicionar | Visualizar");
        jbCadastroEndereco.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbCadastroEndereco.setEnabled(false);
        jbCadastroEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastroEnderecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfNomeEntidade)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jtfCoordenadorAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addGap(203, 203, 203)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jftfTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                            .addComponent(jtfCoordenadorAtual, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addComponent(jbCadastroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfCoordenadorAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfCoordenadorAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

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
                .addContainerGap(143, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalvarActionPerformed
        
        if (opcao.equals("salvar")) {

            salvar();
            opcao = "salvar";

        } else if (opcao.equals("alterar")) {

            atualizar();
            opcao = "salvar";

        }

}//GEN-LAST:event_jbSalvarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed

        if (jdbo == null) {
            jdbo = new JdBuscaOutros(null, true);
        } 

        jdbo.setVisible(true);

        setOutrosBuscado(jdbo.getOutros());
        jdbo.setOutros();
        
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

    private void jtfNomeEntidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNomeEntidadeFocusLost
        jtfNomeEntidade.setText(jtfNomeEntidade.getText().toUpperCase());
    }//GEN-LAST:event_jtfNomeEntidadeFocusLost

    private void jtfCoordenadorAtualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCoordenadorAtualFocusLost
        jtfCoordenadorAtual.setText(jtfCoordenadorAtual.getText().toUpperCase());
    }//GEN-LAST:event_jtfCoordenadorAtualFocusLost

    private void jtfCoordenadorAnteriorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfCoordenadorAnteriorFocusLost
        jtfCoordenadorAnterior.setText(jtfCoordenadorAnterior.getText().toUpperCase());
    }//GEN-LAST:event_jtfCoordenadorAnteriorFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        //ADOGeral ag = new ADOGeral();
        Conexao conexao = new Conexao();
        HashMap parametros = new HashMap();
        try {
            //System.out.println(codigoRegistro);
            //parametros.put("titulo", "Titulo Relatorio");
            parametros.put("codigoOutro", new Integer(codigo));
            //parametros.put("codigo", lista.get(0).getNome();
            //ADOGeral.conectar();
            conexao.getConexao();
        } catch (ExcCadastro ex) {
            Logger.getLogger(JfImpressosAgendamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        JRDataSource jrds = new JRBeanCollectionDataSource(lista);

        try {

            //jReport = JasperCompileManager.compileReport("E:/LUIZ/PROJETOS JAVA/CORPORATIVO/m2GestaoClinicas/FichaPaciente.jrxml");
            //jPrint = JasperFillManager.fillReport("C:/m2GestaoClinicas/FichaPaciente.jasper", parametros, ADOGeral.getConexao());
            jPrint = JasperFillManager.fillReport("Outros.jasper", parametros, conexao.getConexao());
            //jPrint = JasperFillManager.fillReport(jReport, parametros, jrds);

            //if (!(jViewer == null)) {
            //jViewer = new JasperViewer(jPrint, false);
            //jViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
            jViewer.viewReport(jPrint, false);
            //}

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jtfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfEmailFocusLost
        jtfEmail.setText(jtfEmail.getText().toLowerCase());
            
        iniciaCadastroEmail();
        jtfEmail.setText(cadastroEmail.verificaArroba(jtfEmail.getText()));
        
    }//GEN-LAST:event_jtfEmailFocusLost

    private void jbCadastroEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastroEnderecoActionPerformed

        iniciaCadastroEndereco();

        jfCadastroEndereco.setCodigoUsuario(codigoUsuario);
        jfCadastroEndereco.setCodigoOutro(codigo);

        jfCadastroEndereco.setVisible(true);
    }//GEN-LAST:event_jbCadastroEnderecoActionPerformed

    private void jftfTelefoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jftfTelefoneFocusLost
        if (jftfTelefone.getText().equals("(  )    -    ")) {
            jftfTelefone.setValue(null);
        }
    }//GEN-LAST:event_jftfTelefoneFocusLost
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new jfCadastroEscola().setVisible(true);
    }
    });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCadastroEndereco;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JFormattedTextField jftfTelefone;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JTextField jtfCoordenadorAnterior;
    private javax.swing.JTextField jtfCoordenadorAtual;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfNomeEntidade;
    // End of variables declaration//GEN-END:variables

//Outros Metodos===================================================================================================================================
    public void fechar() {

        if (!jtfNomeEntidade.getText().isEmpty() && !jftfTelefone.getText().equals("####-####")) {

            iniciaClasseGeral();
            classeGeral.msgAtencao("Cancele ou Salve o Cadastro em Edição!");

        } else {
            dao = null;
            this.dispose();
        }

    }

    public void cancelar() {

        jtfEmail.setText("");
        jtfNomeEntidade.setText("");
        jftfTelefone.setText("");
        jtfCoordenadorAtual.setText("");
        jtfCoordenadorAnterior.setText("");

        abilitaCampos();

        desabilitaBotoes();

        jftfTelefone.transferFocusBackward();

        opcao = "salvar";
        
        cadastroEmail = null;

    }

    public void abilitaCampos() {

        jtfEmail.setEditable(true);
        jtfNomeEntidade.setEditable(true);
        jftfTelefone.setEditable(true);
        jtfCoordenadorAtual.setEditable(true);
        jtfCoordenadorAnterior.setEditable(true);

    }

    public void desabilitaCampos() {

        jtfEmail.setEditable(false);
        jtfNomeEntidade.setEditable(false);
        jftfTelefone.setEditable(false);
        jtfCoordenadorAtual.setEditable(false);
        jtfCoordenadorAnterior.setEditable(false);

    }

    public void abilitaBotoes() {

        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(true);

        if (cadastrarOutros == true) {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(true);
            jbAlterar.setEnabled(true);
            jbCadastroEndereco.setEnabled(true);
        } else {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
            jbCadastroEndereco.setEnabled(false);
        }

    }

    public void desabilitaBotoes() {

        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbImprimir.setEnabled(false);

        if (cadastrarOutros == true) {
            jbSalvar.setEnabled(true);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
        } else {
            jbSalvar.setEnabled(false);
            jbExcluir.setEnabled(false);
            jbAlterar.setEnabled(false);
        }

    }
    
    public void iniciaCadastroEmail() {
        
        if (cadastroEmail == null) {
            cadastroEmail = new CadastroEmail();
        }
        
    }

//Geradores, Validadores===================================================================================================================================
    public void iniciaCadastroEndereco() {
        
        if (jfCadastroEndereco == null) {
            jfCadastroEndereco = new JfCadastroEndereco();
        }
        
    }
    
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
    
    public void iniciaLog() {
        
        if (geraLog == null) {
            geraLog = new Log();
        }
        
    }
    
    public void iniciaOutro() {
        
        if (outro == null) {
            outro = new Outro();
        }
        
    }
    
//Getters and Setters===================================================================================================================================
    public void setOutrosBuscado(Outro outroBuscado) {

        if (outroBuscado == null) {
        } else {

            iniciaOutro();
            
            jtfNomeEntidade.setText(outroBuscado.getNomeOutro());
            jftfTelefone.setText(outroBuscado.getTelefone());
            jtfCoordenadorAtual.setText(outroBuscado.getCoordenadorAtual());
            jtfCoordenadorAnterior.setText(outroBuscado.getCoordenadorAnterior());
            
            try {
                iniciaCadastroEmail();
                jtfEmail.setText(cadastroEmail.verificaArroba(outroBuscado.getEmailOutro()));
            } catch (Exception e) {
                System.out.println("Não possui email cadastrado!");
                jtfEmail.setText("");
            }

            codigo = outroBuscado.getCodigoOutro();
            outro = outroBuscado;
            outro.setCodigoOutro(codigo);

            desabilitaCampos();

            abilitaBotoes();

        }
    }

    public DefaultFormatterFactory getFormatoTelefone() throws ParseException {

        MaskFormatter comFoco = null;

        try {
            comFoco = new MaskFormatter("(##)####-####"); // passa telefone para o formato [(45)9999-9999]
        } catch (ParseException pe) {
        }

        DefaultFormatterFactory factory = new DefaultFormatterFactory(comFoco);
        return factory;

    }

    public void setNumeroCaracteres() {

        jtfEmail.setDocument(new FixedLengthDocument((120)));
        jtfNomeEntidade.setDocument(new FixedLengthDocument(120));
        jtfCoordenadorAtual.setDocument(new FixedLengthDocument(120));
        jtfCoordenadorAnterior.setDocument(new FixedLengthDocument(120));

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
        Permissoes permissoes;
        iniciaDao();
        //DAO dao = new DAO();

        permissoes = (Permissoes) dao.buscaPermissoes(getCodigoUsuario());

        cadastrarOutros = permissoes.isCadastrarEscola();
    }

//Metodos DAO===================================================================================================================================
    public void salvar() {

        if (!jtfNomeEntidade.getText().isEmpty() || !jftfTelefone.getText().equals("(  )    -    ")) {

            iniciaDao();
            iniciaOutro();

            outro.setCoordenadorAtual(jtfCoordenadorAtual.getText());
            outro.setCoordenadorAnterior(jtfCoordenadorAnterior.getText());
            outro.setEmailOutro(jtfEmail.getText());
            outro.setNomeOutro(jtfNomeEntidade.getText());
            outro.setTelefone(jftfTelefone.getText());

            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Cadastro Outro", "Tentou Salvar Outro" + outro.getNomeOutro());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.inserir(outro, 7, codigoUsuario);
            cancelar();

        } else {
            iniciaClasseGeral();
            classeGeral.msgAtencao("Complete os Campos Obrigatórios, destacados em Azul!");
        }

    }

    public void atualizar() {

        if (!jtfNomeEntidade.getText().isEmpty() || !jftfTelefone.getText().equals("")) {

            iniciaDao();
            iniciaOutro();

            outro.setCoordenadorAtual(jtfCoordenadorAtual.getText());
            outro.setCoordenadorAnterior(jtfCoordenadorAnterior.getText());
            outro.setEmailOutro(jtfEmail.getText());
            outro.setNomeOutro(jtfNomeEntidade.getText());
            outro.setTelefone(jftfTelefone.getText());

            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Cadastro Outro", "Tentou Atualizar Código: " + outro.getCodigoOutro() + " do(a) " + outro.getNomeOutro());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.atualizar(outro, 7, codigoUsuario);
            cancelar();

        } else {
            iniciaClasseGeral();
            classeGeral.msgAtencao("Complete os Campos Obrigatórios, destacados em Azul!");
        }

    }

    public void excluir() {

        iniciaClasseGeral();

        if (classeGeral.msgConfirma("Deseja excluir a entidade ?")) {

            iniciaDao();
            iniciaOutro();
            
            try {
                iniciaLog();
                geraLog.criaLog(codigoUsuario, "Cadastro Outro", "Tentou Excluir Código: " + outro.getCodigoOutro() + " do(a) " + outro.getNomeOutro());
            } catch (IOException ex) {
                Logger.getLogger(JfPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dao.excluir(outro, codigoUsuario);
            cancelar();

        }

    }
}
