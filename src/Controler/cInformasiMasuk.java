/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import view.InformasiMasuk;
import Model.mInformasiMasuk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import view.InformasiMasuk;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.BerandaPabrik;

/**
 *
 * @author AbbiNizar
 */
public class cInformasiMasuk {

    InformasiMasuk view;
    mInformasiMasuk model;

    cInformasiMasuk(InformasiMasuk b, mInformasiMasuk model) {
        this.model = model;
        this.view = b;
        this.view.klikKembali(new kembaliAction());
        this.view.klikDelete(new deleteAction());
        b.setVisible(true);
        b.setTableData(model.getData());
    }
    class deleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.hapus(view.getData())) {
                    JOptionPane.showMessageDialog(null, "Berhasil Hapus");
                    view.setTableData(model.getData());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Hapus");
                }
            } catch (SQLException ex) {
                Logger.getLogger(cLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BerandaPabrik a = new BerandaPabrik();
            a.setVisible(true);
            cBerandaPabrik k = new cBerandaPabrik(a);
            view.dispose();
        }

    }

}
