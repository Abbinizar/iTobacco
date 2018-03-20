/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbbiNizar
 */
public class InformasiPetani extends javax.swing.JFrame {

    /**
     * Creates new form InformasiPetani
     */
    public InformasiPetani() {
        initComponents();
    }
    public void klikKembali(ActionListener e) {
        btnKembali.addActionListener(e);
    }

    public String getJudul() {
        return judulDetails.getText();
    }

    public String getDeskripsi() {
        return deskripsiDetails.getText();
    }

    public void setJudul(String kata) {
        judulDetails.setText(kata);
    }

    public void setDeskripsi(String kata) {
        deskripsiDetails.setText(kata);
    }

    public void klikDetails(ActionListener e) {
        btnDetails.addActionListener(e);
    }
       public void setTableData(DefaultTableModel model) {
        informasiTable.setModel(model);
    }

    public String getData() {
        return informasiTable.getValueAt(informasiTable.getSelectedRow(), 0).toString();
    }
 public String getData(int baris, int kolom) {
        return (String) this.informasiTable.getValueAt(baris, kolom);
    }

    public int getRow() {
        System.out.println(informasiTable.getSelectedRow());
        return this.informasiTable.getSelectedRow();
    }

    public int getColumn() {
        return this.informasiTable.getColumnCount();
    }

    public void setTxtID(String id) {
        this.txtID.setText(id);
    }

    public void setTxtJudul(String judulDetails) {
        this.judulDetails.setText(judulDetails);
    }
    public void setTxtDeskripsi(String deskripsiDetails) {
        this.deskripsiDetails.setText(deskripsiDetails);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        informasiTable = new javax.swing.JTable();
        deskripsiDetails = new javax.swing.JTextField();
        judulDetails = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Informasi");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 150, -1));

        btnKembali.setBackground(new Color (0,0,0,0));
        btnKembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Undo_32px.png"))); // NOI18N
        getContentPane().add(btnKembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 40, 30));

        btnDetails.setText("Details");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(btnDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 110, -1));

        informasiTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(informasiTable);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 410, 280));

        deskripsiDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        deskripsiDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deskripsiDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(deskripsiDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 220, 240));

        judulDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulDetailsActionPerformed(evt);
            }
        });
        getContentPane().add(judulDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, -1));

        txtID.setText("1");
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void deskripsiDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deskripsiDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deskripsiDetailsActionPerformed

    private void judulDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulDetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulDetailsActionPerformed

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
            java.util.logging.Logger.getLogger(InformasiPetani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformasiPetani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformasiPetani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformasiPetani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformasiPetani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnKembali;
    private javax.swing.JTextField deskripsiDetails;
    private javax.swing.JTable informasiTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField judulDetails;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables
}