package br.cesjf.lppoexercicio02desc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo
 */
public class ListReclamacao extends javax.swing.JDialog {

    public ListReclamacao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarListBD();
        montarTabela();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbReclamacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbReclamacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Email", "Descricao", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbReclamacao.setName(""); // NOI18N
        tbReclamacao.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(tbReclamacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListReclamacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListReclamacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListReclamacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListReclamacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListReclamacao dialog = new ListReclamacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbReclamacao;
    // End of variables declaration//GEN-END:variables

    private java.sql.Connection conexaoList;
    private java.sql.Statement operacaoList;
    private java.sql.ResultSet resultadoList;

    private void iniciarListBD() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar Driver" + e.getMessage());
        }
        String url = "jdbc:derby://localhost:1527/lppoEx02Reclamacoes";
        try {
            conexaoList = DriverManager.getConnection(url, "usuario", "senha");
            operacaoList = conexaoList.createStatement();
            resultadoList = operacaoList.executeQuery("SELECT * FROM reclamacao");

        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(this, "Erro na conexão" + e1.getMessage());
        }
    }


private void montarTabela() {
    int linha = 0;
         try {
                while(resultadoList.next()){
                    String id = resultadoList.getString("id");
                    String nome = resultadoList.getString("nome");
                    String email = resultadoList.getString("email");
                    String descricao = resultadoList.getString("descricao");
                    String status = resultadoList.getString("status");
                    
                    tbReclamacao.getModel().setValueAt(id, linha, 0);
                    tbReclamacao.getModel().setValueAt(nome, linha, 1);
                    tbReclamacao.getModel().setValueAt(email, linha, 2);
                    tbReclamacao.getModel().setValueAt(descricao, linha, 3);
                    tbReclamacao.getModel().setValueAt(status, linha, 4);
                    linha++;
                }   
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro na indexação da tabela" + e.getMessage());
            }
}
}
