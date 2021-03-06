/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Medico_DAO;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Medico;

/**
 *
 * @author henri
 */
public class MedJFrame extends javax.swing.JFrame {
    DefaultListModel lista = new DefaultListModel();
    DefaultTableModel modeloTabela = new DefaultTableModel(new Object[][]{}, 
            new Object[]{"ID", "nome", "Especialização", "Medico"});

    /**
     * Creates new form MedJFrame
     */
    public MedJFrame() {
        initComponents();
        tblMedico.setModel(modeloTabela);
        tblMedico.removeColumn(tblMedico.getColumnModel().getColumn(3));
        carregarMedicos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedico = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        txtMedico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Medicos Cadastrados");

        tblMedico.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblMedico);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Medico");

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

        txtMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMedicoActionPerformed(evt);
            }
        });
        txtMedico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMedicoKeyReleased(evt);
            }
        });

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroMed_JD telaCadastro = new CadastroMed_JD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        Medico novo = telaCadastro.getMedico();
        if (novo != null && novo.getNome() != null && novo.getEspec() != null) {
            Medico_DAO dao = new Medico_DAO();
            dao.inserir(novo);
            carregarMedicos();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Médico");
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indiceLinha = tblMedico.getSelectedRow();
        if(indiceLinha != -1)
        {
            Medico selecionado = (Medico) modeloTabela.getValueAt(indiceLinha, 3);
            CadastroMed_JD telaCadastro = new CadastroMed_JD(this, rootPaneCheckingEnabled);
            telaCadastro.setMedico(selecionado);
            telaCadastro.setVisible(true);
            if (selecionado != null && selecionado.getNome() != null && selecionado.getEspec() != null) {
                Medico_DAO dao = new Medico_DAO();
                dao.editar(selecionado);
                carregarMedicos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar Médico");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int indiceLinha = tblMedico.getSelectedRow();
        if(indiceLinha != -1){
            Medico selecionado = (Medico) modeloTabela.getValueAt(indiceLinha, 3);
            Medico_DAO dao = new Medico_DAO();
            dao.excluir(selecionado);
            carregarMedicos();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void txtMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMedicoActionPerformed

    private void txtMedicoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMedicoKeyReleased
        // UF selecionado = (UF) boxUF.getSelectedItem();
        String nome = txtMedico.getText().trim().toLowerCase();
        carregarMedicos(nome);
        /* if( selecionado != null){
            modeloTabela.setNumRows(0);
            Cidade_DAO dao = new Cidade_DAO();
            for(Cidade cid: dao.buscar(selecionado, nome)){
                modeloTabela.addRow(new Object[]{cid.getId(),
                    cid.getNome(),
                    cid.getUf(),
                    cid
                });
            }
        } else {
            modeloTabela.setNumRows(0);
            Cidade_DAO dao = new Cidade_DAO();
            for(Cidade cid: dao.buscar(nome)){
                modeloTabela.addRow(new Object[]{cid.getId(),
                    cid.getNome(),
                    cid.getUf(),
                    cid
                });
            }  */
    }//GEN-LAST:event_txtMedicoKeyReleased

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
            java.util.logging.Logger.getLogger(MedJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MedJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MedJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MedJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MedJFrame().setVisible(true);
            }
        });
    }
    
    public void carregarMedicos(){

            modeloTabela.setNumRows(0);
            Medico_DAO dao = new Medico_DAO();
            ArrayList<Medico> medicos = dao.buscar();
            for(Medico med: medicos){
                modeloTabela.addRow(new Object[]{med.getId(), 
                med.getNome(),
                med.getEspec(),
                med 
                });
            }
        
        
        }
    
    public void carregarMedicos(String nome) {
        modeloTabela.setNumRows(0);
        Medico_DAO dao = new Medico_DAO();
        ArrayList<Medico> medicos = dao.buscar(nome);
        for(Medico med: medicos){
            modeloTabela.addRow(new Object[]{med.getId(), 
            med.getNome(),
            med.getEspec(),
            med});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedico;
    private javax.swing.JTextField txtMedico;
    // End of variables declaration//GEN-END:variables
}
