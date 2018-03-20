/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mPemesanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Beranda;
import view.Pemesanan;
import view.PemesananMasuk;

/**
 *
 * @author AbbiNizar
 */
public class cPemesananMasuk {
    PemesananMasuk pm;
    Beranda brd;
    mPemesanan pem;
    
    public cPemesananMasuk(PemesananMasuk pm, mPemesanan pem){

        this.pm = pm;
        this.pem = pem;
        this.pm.klikKembali(new kembaliAction());
        this.pm.klikHapus(new deleteAction());
        this.pm.klikDiterima(new diterimaAction());
        pm.setTableData(pem.getData());
    }
    class diterimaAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Diterima, Proses pengiriman akan memakan waktu 1 minggu");
            Beranda a = new Beranda();
            a.setVisible(true);
            cBeranda k = new cBeranda(a);
            pm.dispose();

        }
        
    }
        class deleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (pem.delete(pm.getData())) {
                    JOptionPane.showMessageDialog(null, "Berhasil Hapus");
                    pm.setTableData(pem.getData());
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Hapus");
                }
            } catch (SQLException ex) {
                Logger.getLogger(cLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class kembaliAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Beranda a = new Beranda();
            a.setVisible(true);
            cBeranda k = new cBeranda(a);
            pm.dispose();
        }
    }
    
}
