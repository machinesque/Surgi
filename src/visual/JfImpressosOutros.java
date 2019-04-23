/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jfImpressosAgendamento.java
 *
 * Created on 03/03/2010, 20:23:35
 */
package visual;

import conexao.Conexao;
import controlador.ClasseGeral;
import controlador.ControleImagem;
import controlador.ControleOutro;
import controlador.ControleVersao;
import dao.DAO;
import excecoes.ExcCadastro;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Outro;
import modelo.Permissoes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luizam
 */
public class JfImpressosOutros extends javax.swing.JFrame {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleOutro controleOutro;
    private DAO dao;
    private Outro outro;
    
    private JasperPrint jPrint;
    private JasperViewer jViewer;
    
    private int codigoUsuario;
    private String tipoStatus;
    private boolean impressosOutros;

    /** Creates new form jfImpressosAgendamento */
    public JfImpressosOutros() {
        super("Impressos Outros - " + versao.getVersao() + " - " + versao.getAno());
        initComponents();

        //Altera icone na barra de titulo
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage("C:/SURGI/imagens/SURGI32x32.png");
        this.setIconImage(img);

        //centraliza tela
        setSize(getWidth(), getHeight());
        setLocationRelativeTo(null);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgModoImpressao = new javax.swing.ButtonGroup();
        jpImprOutros = new javax.swing.JPanel();
        jpModoImpressao = new javax.swing.JPanel();
        jrbTodosOutros = new javax.swing.JRadioButton();
        jrbPorEntidade = new javax.swing.JRadioButton();
        jcbNomeEntidade = new javax.swing.JComboBox();
        jpBotoes = new javax.swing.JPanel();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jpImprOutros.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jpModoImpressao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(1), "Modo Impressão de Outros", 0, 0, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btgModoImpressao.add(jrbTodosOutros);
        jrbTodosOutros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jrbTodosOutros.setSelected(true);
        jrbTodosOutros.setText("Todas as Entidades");
        jrbTodosOutros.setBorder(new javax.swing.border.SoftBevelBorder(1));
        jrbTodosOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosOutrosActionPerformed(evt);
            }
        });

        btgModoImpressao.add(jrbPorEntidade);
        jrbPorEntidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jrbPorEntidade.setText("Por Entidade");
        jrbPorEntidade.setBorder(new javax.swing.border.SoftBevelBorder(1));
        jrbPorEntidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorEntidadeActionPerformed(evt);
            }
        });

        jcbNomeEntidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbNomeEntidade.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jcbNomeEntidade.setEnabled(false);

        javax.swing.GroupLayout jpModoImpressaoLayout = new javax.swing.GroupLayout(jpModoImpressao);
        jpModoImpressao.setLayout(jpModoImpressaoLayout);
        jpModoImpressaoLayout.setHorizontalGroup(
            jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbTodosOutros)
                    .addComponent(jrbPorEntidade)
                    .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jcbNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jpModoImpressaoLayout.setVerticalGroup(
            jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbTodosOutros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbPorEntidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpImprOutrosLayout = new javax.swing.GroupLayout(jpImprOutros);
        jpImprOutros.setLayout(jpImprOutrosLayout);
        jpImprOutrosLayout.setHorizontalGroup(
            jpImprOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImprOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpModoImpressao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpImprOutrosLayout.setVerticalGroup(
            jpImprOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImprOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpModoImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jbExcluir.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setBorder(new javax.swing.border.SoftBevelBorder(0));
        jbAlterar.setEnabled(false);
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbImprimir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jbImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        jbImprimir.setText("Imprimir");
        jbImprimir.setBorder(new javax.swing.border.SoftBevelBorder(0));
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
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jpBotoesLayout.setVerticalGroup(
            jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpImprOutros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpImprOutros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        //();
}//GEN-LAST:event_jbExcluirActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed

        /*abilitaCampos();

        jbNovo.setEnabled(true);
        jbSalvar.setEnabled(true);
        jbCancelar.setEnabled(true);
        jbBuscar.setEnabled(true);
        jbExcluir.setEnabled(true);
        jbAlterar.setEnabled(false);
        jbImprimir.setEnabled(true);

        opcao = "alterar";*/
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed

        //ADOGeral ag = new ADOGeral();
        Conexao conexao = new Conexao();
        HashMap parametros = new HashMap();
        try {
            //System.out.println(codigoRegistro);
            //parametros.put("titulo", "Titulo Relatorio");
            //parametros.put("mesInicio", jDateChooserInicio.getDate());
            //parametros.put("mesTermino", jDateChooserTermino.getDate());
            //parametros.put("codigo", lista.get(0).getNome();
            //ADOGeral.conectar();
            conexao.getConexao();
        } catch (ExcCadastro ex) {
            Logger.getLogger(JfImpressosOutros.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        JRDataSource jrds = new JRBeanCollectionDataSource(lista);

        try {

            //jReport = JasperCompileManager.compileReport("E:/LUIZ/PROJETOS JAVA/CORPORATIVO/m2GestaoClinicas/FichaPaciente.jrxml");
            //jPrint = JasperFillManager.fillReport("C:/m2GestaoClinicas/FichaPaciente.jasper", parametros, ADOGeral.getConexao());
            if (jrbTodosOutros.isSelected()) {

                jPrint = JasperFillManager.fillReport("TodosOutros.jasper", null, conexao.getConexao());
                imprimir();
                
            } else if(jrbPorEntidade.isSelected()) {

                if (jcbNomeEntidade.getSelectedIndex() == 0) {
                    
                    iniciaClasseGeral();
                    classeGeral.msgAtencao("Não há nenhuma Entidade selecinada no campo especifico!");
                    
                } else {
                    
                    iniciaControleOutro();
                    
                    parametros.put("codigoOutro", controleOutro.getCodigoOutro(jcbNomeEntidade.getSelectedItem().toString()));
                    
                    jPrint = JasperFillManager.fillReport("OutrosPorCodigo.jasper", parametros, conexao.getConexao());
                    imprimir();
                    
                }
                
            }

            //jPrint = JasperFillManager.fillReport(jReport, parametros, jrds);

            //if (!(jViewer == null)) {
            //jViewer = new JasperViewer(jPrint, false);
            //jViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //}

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jrbTodosOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosOutrosActionPerformed

        if (jrbTodosOutros.isSelected() == true) {

            jcbNomeEntidade.setEnabled(false);

        }

    }//GEN-LAST:event_jrbTodosOutrosActionPerformed

    private void jrbPorEntidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorEntidadeActionPerformed

        if (jrbPorEntidade.isSelected() == true) {

            jcbNomeEntidade.setEnabled(true);
            preencheComboOutros();

        }

    }//GEN-LAST:event_jrbPorEntidadeActionPerformed
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
    public void run() {
    new jfImpressosAgendamento().setVisible(true);
    }
    });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgModoImpressao;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JComboBox jcbNomeEntidade;
    private javax.swing.JPanel jpBotoes;
    private javax.swing.JPanel jpImprOutros;
    private javax.swing.JPanel jpModoImpressao;
    private javax.swing.JRadioButton jrbPorEntidade;
    private javax.swing.JRadioButton jrbTodosOutros;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        dao = null;
        this.dispose();

    }

    public void preencheComboOutros() {

        iniciaDao();
        List listaOutros = new ArrayList();

        jcbNomeEntidade.removeAllItems();
        jcbNomeEntidade.addItem("");

        listaOutros = dao.listarOutros(0, "", "");

        for (int i = 0; i < listaOutros.size(); i++) {
            iniciaOutro();
            outro = (Outro) listaOutros.get(i);
            jcbNomeEntidade.addItem(outro.getNomeOutro());
        }

    }
    
    public void abilitaBotoes() {

        if (impressosOutros == true) {
            jbImprimir.setEnabled(true);
        } else {
            jbImprimir.setEnabled(false);
        }

    }

    public void desabilitaBotoes() {

        if (impressosOutros == true) {
            jbImprimir.setEnabled(true);
        } else {
            jbImprimir.setEnabled(false);
        }

    }

    public void imprimir() {
        
        if (jPrint != null) {
            jViewer.viewReport(jPrint, false);
            jPrint = null;
        }
        
    }
    
//Geradores, Validadores===========================================================================================================================================
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
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

    public void iniciaOutro() {
        
        if (outro == null) {
            outro = new Outro();
        }
        
    }
    
//Getters and Setters===========================================================================================================================================
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

        permissoes = (Permissoes) dao.buscaPermissoes(codigoUsuario);

        impressosOutros = permissoes.isImpressosOutros();
    }

//Metodos DAO===========================================================================================================================================
    
}
