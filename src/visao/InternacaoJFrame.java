/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Internacao_DAO;
import controle.Medico_DAO;
import controle.Paciente_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Internacao;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author henri
 */
public class InternacaoJFrame extends javax.swing.JFrame {

    /**
     * Creates new form InternacaoJFrame
     */
    DefaultTableModel modeloTabela = new DefaultTableModel(new Object[][]{}, 
    new Object[]{"ID", "Quarto", "Paciente", "Diagnóstico", "Medicamento", "Internacao"});
    
    public InternacaoJFrame() {
        initComponents();
        tblInternacao.setModel(modeloTabela);
        tblInternacao.removeColumn(tblInternacao.getColumnModel().getColumn(5));
        carregarInternacoes();
        carregarPacientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        boxPaciente = new javax.swing.JComboBox<>();
        txtInternacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInternacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Paciente");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Internação");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        boxPaciente.setToolTipText("");
        boxPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boxPaciente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxPacienteItemStateChanged(evt);
            }
        });
        boxPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPacienteActionPerformed(evt);
            }
        });

        txtInternacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtInternacaoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Internações Cadastradas");

        tblInternacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblInternacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRemover))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(boxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInternacao, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroInt_JD telaCadastro = new CadastroInt_JD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        Internacao novo = telaCadastro.getInternacao();
        if (novo != null && novo.getQuarto() != null && novo.getPaciente() != null && novo.getDiag()!= null && novo.getMedicamento() != null) {
            Internacao_DAO dao = new Internacao_DAO();
            dao.inserir(novo);
            carregarInternacoes();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Internação");
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indiceLinha = tblInternacao.getSelectedRow();
        if(indiceLinha != -1)
        {
            Internacao selecionado = (Internacao) modeloTabela.getValueAt(indiceLinha, 5);
            CadastroInt_JD telaCadastro = new CadastroInt_JD(this, rootPaneCheckingEnabled);
            telaCadastro.setInternacao(selecionado);
            telaCadastro.setVisible(true);
            if (selecionado != null && selecionado.getQuarto()!= null && selecionado.getPaciente() != null && selecionado.getDiag()!= null && selecionado.getMedicamento() != null) {
                Internacao_DAO dao = new Internacao_DAO();
                dao.editar(selecionado);
                carregarInternacoes();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar Internação ");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int indiceLinha = tblInternacao.getSelectedRow();
        if(indiceLinha != -1){
            Internacao selecionado = (Internacao) modeloTabela.getValueAt(indiceLinha, 5);
            Internacao_DAO dao = new Internacao_DAO();
            dao.excluir(selecionado);
            carregarInternacoes();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void boxPacienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxPacienteItemStateChanged
        Paciente selecionado = (Paciente) boxPaciente.getSelectedItem();
        String quarto = txtInternacao.getText().trim().toLowerCase();
        if( selecionado != null){
            carregarInternacoes(selecionado, quarto);
        } else {
            carregarInternacoes(quarto);
        }
    }//GEN-LAST:event_boxPacienteItemStateChanged

    private void boxPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxPacienteActionPerformed

    private void txtInternacaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInternacaoKeyReleased
        Paciente selecionado = (Paciente) boxPaciente.getSelectedItem();
        String quarto = txtInternacao.getText().trim().toLowerCase();
        if( selecionado != null){
            carregarInternacoes(selecionado, quarto);
        } else {
            carregarInternacoes(quarto);
        }
    }//GEN-LAST:event_txtInternacaoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InternacaoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InternacaoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InternacaoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InternacaoJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InternacaoJFrame().setVisible(true);
            }
        });
    }
    
    public void carregarInternacoes(){

        modeloTabela.setNumRows(0);
        Internacao_DAO dao = new Internacao_DAO();
        ArrayList<Internacao> internacoes = dao.buscar();
        for(Internacao inte: internacoes){
            modeloTabela.addRow(new Object[]{inte.getId(), 
            inte.getQuarto(),
            inte.getPaciente(),
            inte.getDiag(),
            inte.getMedicamento(),
            inte
            });
            }
        
        
        }
    
    public void carregarInternacoes(String quarto){
        modeloTabela.setNumRows(0);
        Internacao_DAO dao = new Internacao_DAO();
        ArrayList<Internacao> internacoes = dao.buscar(quarto);
        for(Internacao inte: internacoes){
            modeloTabela.addRow(new Object[]{inte.getId(), 
            inte.getQuarto(),
            inte.getPaciente(),
            inte.getDiag(),
            inte.getMedicamento(),
            inte
            });
            }
    }
    
    public void carregarInternacoes(Paciente selecionado, String quarto){
               modeloTabela.setNumRows(0);
        Internacao_DAO dao = new Internacao_DAO();
        ArrayList<Internacao> internacoes = dao.buscar(selecionado, quarto);
        for(Internacao inte: internacoes){
            modeloTabela.addRow(new Object[]{inte.getId(), 
            inte.getQuarto(),
            inte.getPaciente(),
            inte.getDiag(),
            inte.getMedicamento(),
            inte
            });
            }
    
    }

    public void carregarPacientes(){

        boxPaciente.removeAllItems();
        Paciente_DAO dao = new Paciente_DAO();
        boxPaciente.addItem(null);
        for(Paciente pac: dao.buscar()){
           boxPaciente.addItem(pac);
        }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Paciente> boxPaciente;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInternacao;
    private javax.swing.JTextField txtInternacao;
    // End of variables declaration//GEN-END:variables
}
