/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.Medico_DAO;
import controle.Paciente_DAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author henri
 */
public class PacienteJFrame extends javax.swing.JFrame {
    DefaultTableModel modeloTabela = new DefaultTableModel(new Object[][]{}, 
    new Object[]{"CPF", "nome", "Cidade", "Medico", "Cidade"});
    /**
     * Creates new form PacienteJFrame
     */
    public PacienteJFrame() {
        initComponents();
        tblPaciente.setModel(modeloTabela);
        tblPaciente.removeColumn(tblPaciente.getColumnModel().getColumn(4));
        carregarPacientes();
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

        btnRemover = new javax.swing.JButton();
        boxMedico = new javax.swing.JComboBox<>();
        txtPaciente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        boxMedico.setToolTipText("");
        boxMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boxMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxMedicoItemStateChanged(evt);
            }
        });
        boxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMedicoActionPerformed(evt);
            }
        });

        txtPaciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPacienteKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Paciente Cadastrados");

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPaciente);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Médico");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Paciente");

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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(boxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int indiceLinha = tblPaciente.getSelectedRow();
        if(indiceLinha != -1){
            Paciente selecionado = (Paciente) modeloTabela.getValueAt(indiceLinha, 4);
            Paciente_DAO dao = new Paciente_DAO();
            dao.excluir(selecionado);
            carregarPacientes();
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void boxMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxMedicoItemStateChanged
        Medico selecionado = (Medico) boxMedico.getSelectedItem();
        String nome = txtPaciente.getText().trim().toLowerCase();
        if( selecionado != null){
            carregarPacientes(selecionado, nome);
        } else {
            carregarPacientes(nome);
        }
    }//GEN-LAST:event_boxMedicoItemStateChanged

    private void boxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxMedicoActionPerformed

    private void txtPacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPacienteKeyReleased
        Medico selecionado = (Medico) boxMedico.getSelectedItem();
        String nome = txtPaciente.getText().trim().toLowerCase();
        if( selecionado != null){
            carregarPacientes(selecionado, nome);
        } else {
            carregarPacientes(nome);
        }
    }//GEN-LAST:event_txtPacienteKeyReleased

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        CadastroPac_JD telaCadastro = new CadastroPac_JD(this, rootPaneCheckingEnabled);
        telaCadastro.setVisible(true);
        Paciente novo = telaCadastro.getPaciente();
        if (novo != null && novo.getNome() != null && novo.getMedico() != null && novo.getCPF() != null && novo.getCidade() != null) {
            Paciente_DAO dao = new Paciente_DAO();
            dao.inserir(novo);
            carregarPacientes();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar Paciente");
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        int indiceLinha = tblPaciente.getSelectedRow();
        if(indiceLinha != -1)
        {
            Paciente selecionado = (Paciente) modeloTabela.getValueAt(indiceLinha, 4);
            CadastroPac_JD telaCadastro = new CadastroPac_JD(this, rootPaneCheckingEnabled);
            telaCadastro.setPaciente(selecionado);
            telaCadastro.setVisible(true);
            if (selecionado != null && selecionado.getNome() != null && selecionado.getMedico() != null && selecionado.getCPF()!= null && selecionado.getCidade() != null) {
                Paciente_DAO dao = new Paciente_DAO();
                dao.editar(selecionado);
                carregarPacientes();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar Paciente ");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PacienteJFrame().setVisible(true);
            }
        });
    }
    
        public void carregarPacientes(){

        modeloTabela.setNumRows(0);
        Paciente_DAO dao = new Paciente_DAO();
        ArrayList<Paciente> pacientes = dao.buscar();
        for(Paciente pac: pacientes){
            modeloTabela.addRow(new Object[]{pac.getCPF(), 
            pac.getNome(),
            pac.getCidade(),
            pac.getMedico(),
            pac
            });
            }
        
        
        }
    
    public void carregarPacientes(String nome){
        modeloTabela.setNumRows(0);
        Paciente_DAO dao = new Paciente_DAO();
        ArrayList<Paciente> pacientes = dao.buscar(nome);
        for(Paciente pac: pacientes){
            modeloTabela.addRow(new Object[]{pac.getCPF(), 
            pac.getNome(),
            pac.getCidade(),
            pac.getMedico(),
            pac
            });
            }
    }
    
    public void carregarPacientes(Medico selecionado, String nome){
        modeloTabela.setNumRows(0);
        Paciente_DAO dao = new Paciente_DAO();
        ArrayList<Paciente> pacientes = dao.buscar(selecionado,nome);
        for(Paciente pac: pacientes){
            modeloTabela.addRow(new Object[]{pac.getCPF(), 
            pac.getNome(),
            pac.getCidade(),
            pac.getMedico(),
            pac
            });
            }
    }

    public void carregarMedicos(){

        boxMedico.removeAllItems();
        Medico_DAO dao = new Medico_DAO();
        boxMedico.addItem(null);
        for(Medico med: dao.buscar()){
           boxMedico.addItem(med);
        }
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Medico> boxMedico;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}