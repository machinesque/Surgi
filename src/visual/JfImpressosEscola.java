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
import controlador.ControleEscola;
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
import modelo.Escola;
import modelo.Permissoes;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author luizam
 */
public class JfImpressosEscola extends javax.swing.JFrame {

    private static ControleVersao versao = new ControleVersao();
    private ClasseGeral classeGeral;
    private ControleEscola controleEscola;
    private DAO dao;
    private Escola escola;
    
    private JasperPrint jPrint;
    private JasperViewer jViewer;
    
    private int codigoUsuario;
    private String tipoStatus;
    private boolean impressosEscola;

    /** Creates new form jfImpressosAgendamento */
    public JfImpressosEscola() {
        super("Impressos Escola - " + versao.getVersao() + " - " + versao.getAno());
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
        jpImprEscola = new javax.swing.JPanel();
        jpModoImpressao = new javax.swing.JPanel();
        jrbTodasEscolas = new javax.swing.JRadioButton();
        jrbPorEscola = new javax.swing.JRadioButton();
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

        jpImprEscola.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Impressão", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jpModoImpressao.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Modo Impressão das Escolas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        btgModoImpressao.add(jrbTodasEscolas);
        jrbTodasEscolas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jrbTodasEscolas.setSelected(true);
        jrbTodasEscolas.setText("Todas as Escolas");
        jrbTodasEscolas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jrbTodasEscolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodasEscolasActionPerformed(evt);
            }
        });

        btgModoImpressao.add(jrbPorEscola);
        jrbPorEscola.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jrbPorEscola.setText("Por Escola");
        jrbPorEscola.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jrbPorEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPorEscolaActionPerformed(evt);
            }
        });

        jcbNomeEntidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jcbNomeEntidade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcbNomeEntidade.setEnabled(false);

        javax.swing.GroupLayout jpModoImpressaoLayout = new javax.swing.GroupLayout(jpModoImpressao);
        jpModoImpressao.setLayout(jpModoImpressaoLayout);
        jpModoImpressaoLayout.setHorizontalGroup(
            jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbTodasEscolas)
                    .addComponent(jrbPorEscola)
                    .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jcbNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jpModoImpressaoLayout.setVerticalGroup(
            jpModoImpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpModoImpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbTodasEscolas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbPorEscola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbNomeEntidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpImprEscolaLayout = new javax.swing.GroupLayout(jpImprEscola);
        jpImprEscola.setLayout(jpImprEscolaLayout);
        jpImprEscolaLayout.setHorizontalGroup(
            jpImprEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImprEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpModoImpressao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpImprEscolaLayout.setVerticalGroup(
            jpImprEscolaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpImprEscolaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpModoImpressao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jpBotoes.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());

        jbExcluir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbExcluir.setEnabled(false);
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

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
            .addComponent(jpImprEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpImprEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            Logger.getLogger(JfImpressosEscola.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        JRDataSource jrds = new JRBeanCollectionDataSource(lista);

        try {

            //jReport = JasperCompileManager.compileReport("E:/LUIZ/PROJETOS JAVA/CORPORATIVO/m2GestaoClinicas/FichaPaciente.jrxml");
            //jPrint = JasperFillManager.fillReport("C:/m2GestaoClinicas/FichaPaciente.jasper", parametros, ADOGeral.getConexao());
            if (jrbTodasEscolas.isSelected()) {

                jPrint = JasperFillManager.fillReport("TodasEscolas.jasper", null, conexao.getConexao());
                
            } else if(jrbPorEscola.isSelected()) {

                if (jcbNomeEntidade.getSelectedIndex() == 0) {
                    
                    iniciaClasseGeral();
                    
                    classeGeral.msgAtencao("Não há nenhuma Entidade selecinada no campo especifico!");
                    
                } else {
                    
                    iniciaControleEscola();
                    
                    parametros.put("codigoEscola", controleEscola.getCodigoEscola(jcbNomeEntidade.getSelectedItem().toString()));
                    
                    jPrint = JasperFillManager.fillReport("EscolaPorNomeEntidade.jasper", parametros, conexao.getConexao());
                    
                }
                
            }

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
        }

    }//GEN-LAST:event_jbImprimirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();
    }//GEN-LAST:event_formWindowClosing

    private void jrbTodasEscolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodasEscolasActionPerformed

        if (jrbTodasEscolas.isSelected() == true) {

            jcbNomeEntidade.setEnabled(false);

        }

    }//GEN-LAST:event_jrbTodasEscolasActionPerformed

    private void jrbPorEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPorEscolaActionPerformed

        if (jrbPorEscola.isSelected() == true) {

            jcbNomeEntidade.setEnabled(true);
            preencheComboEscolas();

        }

    }//GEN-LAST:event_jrbPorEscolaActionPerformed
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
    private javax.swing.JPanel jpImprEscola;
    private javax.swing.JPanel jpModoImpressao;
    private javax.swing.JRadioButton jrbPorEscola;
    private javax.swing.JRadioButton jrbTodasEscolas;
    // End of variables declaration//GEN-END:variables

//Outros Metodos ===========================================================================================================================================
    public void fechar() {

        dao = null;
        this.dispose();

    }

    public void preencheComboEscolas() {

        iniciaDao();
        //DAO dao = new DAO();
        List listaEscolas = new ArrayList();

        jcbNomeEntidade.removeAllItems();
        jcbNomeEntidade.addItem("");

        listaEscolas = dao.listarEscolas(0, "", "");

        for (int i = 0; i < listaEscolas.size(); i++) {
            iniciaEscola();
            escola = (Escola) listaEscolas.get(i);
            jcbNomeEntidade.addItem(escola.getNomeEscola());
        }

    }
    
    public void abilitaBotoes() {

        if (impressosEscola == true) {
            jbImprimir.setEnabled(true);
        } else {
            jbImprimir.setEnabled(false);
        }

    }

    public void desabilitaBotoes() {

        if (impressosEscola == true) {
            jbImprimir.setEnabled(true);
        } else {
            jbImprimir.setEnabled(false);
        }

    }

//Geradores, Validadores===========================================================================================================================================
    public void iniciaClasseGeral() {
        
        if (classeGeral == null) {
            classeGeral = new ClasseGeral();
        }
        
    }
    
    public void iniciaControleEscola() {
        
        if (controleEscola == null) {
            controleEscola = new ControleEscola();
        }
        
    }
    
    public void iniciaDao() {

        if (dao == null) {
            dao = new DAO();
        }

    }
     
    public void iniciaEscola() {
        
        if (escola == null) {
            escola = new Escola();
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

        impressosEscola = permissoes.isImpressosEscola();
    }

//Metodos DAO===========================================================================================================================================
   
}
