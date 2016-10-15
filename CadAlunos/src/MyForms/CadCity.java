package MyForms;

import DAO.*;
import JavaBeans.*;
import javax.swing.*;
import java.sql.*;

public class CadCity extends JDialog {

    public CadCity(CadAlunos aThis, boolean b) throws Exception {
        initComponents();
        iniciandoBD();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cod = new javax.swing.JLabel();
        cidade = new javax.swing.JLabel();
        uf = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtUF = new javax.swing.JTextField();
        btAnt = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        btProx = new javax.swing.JButton();
        btUltimo = new javax.swing.JButton();
        btNew = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cidades");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cod.setText("Cod:");
        getContentPane().add(cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cidade.setText("Cidade: ");
        getContentPane().add(cidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        uf.setText("UF:");
        getContentPane().add(uf, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, -1));
        getContentPane().add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 160, -1));

        txtUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUFActionPerformed(evt);
            }
        });
        getContentPane().add(txtUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 180, 30));

        btAnt.setText("<");
        btAnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAntActionPerformed(evt);
            }
        });
        getContentPane().add(btAnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, -1, -1));

        bt1.setText("<<");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 50, -1));

        btProx.setText(">");
        btProx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btProxActionPerformed(evt);
            }
        });
        getContentPane().add(btProx, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        btUltimo.setText(">>");
        btUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUltimoActionPerformed(evt);
            }
        });
        getContentPane().add(btUltimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        btNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/Add.png"))); // NOI18N
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });
        getContentPane().add(btNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 60));

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/excluir.jpg"))); // NOI18N
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 60, 60));

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/salvar.png"))); // NOI18N
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });
        getContentPane().add(btSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 70, 60));

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/find.jpg"))); // NOI18N
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 50, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUFActionPerformed

    private void btAntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAntActionPerformed
        try {
            Cidade a = daoCity.Anterior();

            if (a != null) {
                mostraData(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btAntActionPerformed

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        try {
            Cidade c = daoCity.First();
            if (c != null) {
                mostraData(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_bt1ActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        try {
            int b1 = Integer.parseInt(txtCode.getText());

            daoCity.Excluir(b1);
            JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        try {
            int b1 = Integer.parseInt(txtCode.getText());
            String b2 = txtCity.getText();
            String b3 = txtUF.getText();

            Cidade c = new Cidade();
            c.setCode(b1);
            c.setCidade(b2);
            c.setUf(b3);

            daoCity.Salvar(c);
            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        txtCode.setText("");
        txtCity.setText("");
        txtUF.setText("");
        txtCode.requestFocus();
    }//GEN-LAST:event_btNewActionPerformed

    private void btProxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btProxActionPerformed
        try {
            Cidade c = daoCity.Proximo();

            if (c != null) {
                mostraData(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btProxActionPerformed

    private void btUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUltimoActionPerformed
        try {
            Cidade c = daoCity.Last();
            if (c != null) {
                mostraData(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }

    }//GEN-LAST:event_btUltimoActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            int cod = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o código desejado:"));
            Cidade c = daoCity.Pesquisar(cod);

            if (c != null) {
                JOptionPane.showMessageDialog(this, "Informações encontradas!");
                mostraData(c);
            } else {
                JOptionPane.showMessageDialog(this, "Informações não encontradas!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }//GEN-LAST:event_btSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton btAnt;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btProx;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btUltimo;
    private javax.swing.JLabel cidade;
    private javax.swing.JLabel cod;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtUF;
    private javax.swing.JLabel uf;
    // End of variables declaration//GEN-END:variables
    Statement a;
    Connection c;
    private CidadeDAO daoCity;

    private void iniciandoBD() throws Exception {
        daoCity = new CidadeDAO();
    }

    private void mostraData(Cidade c) throws SQLException {
        txtCode.setText(String.valueOf(c.getCode()));
        txtCity.setText(c.getCidade());
        txtUF.setText(c.getUf());

    }
}
