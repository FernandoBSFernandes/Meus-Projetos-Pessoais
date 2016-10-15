package MyForms;

import DAO.*;
import JavaBeans.*;
import javax.swing.*;
import java.sql.*;
import java.util.List;

public class CadAluno extends JDialog {

    public CadAluno(CadAlunos aThis, boolean b) throws Exception {
        initComponents();
        iniciandoBD();
        montarCidade();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cod = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        sobrenome = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtSobrenome = new javax.swing.JTextField();
        btAnt = new javax.swing.JButton();
        btPrimeiro = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        btUltimo = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        cbCity = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alunos - Cadastro");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cod.setText("Cod:");
        getContentPane().add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        nome.setText("Nome: ");
        getContentPane().add(nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        sobrenome.setText("Sobrenome: ");
        getContentPane().add(sobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        cidade.setText("Cidade: ");
        getContentPane().add(cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 180, -1));

        txtSobrenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSobrenomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtSobrenome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 160, 20));

        btAnt.setText("<");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });
        getContentPane().add(btAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        btPrimeiro.setText("<<");
        btPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrimeiroActionPerformed(evt);
            }
        });
        getContentPane().add(btPrimeiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 50, -1));

        btProx.setText(">");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });
        getContentPane().add(btProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        btUltimo.setText(">>");
        btUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(btUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Add.png"))); // NOI18N
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        getContentPane().add(btNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 60));

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/excluir.jpg"))); // NOI18N
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 60, 60));

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/salvar.png"))); // NOI18N
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, 60));

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/find.jpg"))); // NOI18N
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 60, 60));

        cbCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione..." }));
        getContentPane().add(cbCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSobrenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSobrenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSobrenomeActionPerformed

    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            Aluno a = dao.Anterior();

            if (a != null) {
                mostraData(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btAntActionPerformed

    private void btPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrimeiroActionPerformed
        try {
            Aluno a = dao.First();
            if (a != null) {
                mostraData(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btPrimeiroActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        int cod = Integer.parseInt(txtCode.getText());
        try {
            dao.Excluir(cod);
            JOptionPane.showMessageDialog(this, "Excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        txtCode.setText("");
        cbCity.setSelectedIndex(0);
        txtNome.setText("");
        txtSobrenome.setText("");
        txtCode.requestFocus();
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            int code = Integer.parseInt(txtCode.getText());
            String nome = txtNome.getText();
            String sobrenome = txtSobrenome.getText();
            int codcidade = daoCity.getCodigo(cbCity.getSelectedItem().toString());

            Aluno a = new Aluno();
            a.setCode(code);
            a.setNome(nome);
            a.setSobrenome(sobrenome);
            a.setCodCidade(codcidade);

            dao.Salvar(a);
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            int cod = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código desejado:"));
            Aluno a = dao.Pesquisar(cod);

            if (a != null) {
                JOptionPane.showMessageDialog(this, "Informações encontradas!");
                mostraData(a);
            } else {
                JOptionPane.showMessageDialog(this, "Informações não encontradas!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            Aluno a = dao.Proximo();

            if (a != null) {
                mostraData(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btProxActionPerformed

    private void btUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltimoActionPerformed
        try {
            Aluno a = dao.Last();
            if (a != null) {
                mostraData(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btUltimoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btPrimeiro;
    private javax.swing.JButton btProx;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btUltimo;
    private javax.swing.JComboBox<String> cbCity;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cod;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel sobrenome;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
    private AlunoDAO dao;
    private CidadeDAO daoCity;

    private void iniciandoBD() throws Exception {
        dao = new AlunoDAO();
        daoCity = new CidadeDAO();
    }

    private void mostraData(Aluno a) throws SQLException {
        txtCode.setText(String.valueOf(a.getCode()));
        txtNome.setText(a.getNome());
        txtSobrenome.setText(a.getSobrenome());
        String cidade = daoCity.getCidade(a.getCodCidade());

        if (cidade.equals("")) {
            cidade = "Cidade não cadastrada";
        }
    }

    private void montarCidade() {
        try {
            List<Cidade> city = daoCity.montarCidade();

            for (Cidade c1 : city) {
                cbCity.addItem(c1.getCidade());
            }
            cbCity.addItem("Cidade não cadastrada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro" + ex.getMessage());
        }
    }
}
