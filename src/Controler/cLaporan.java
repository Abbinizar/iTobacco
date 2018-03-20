/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mKualitas;
import Model.mLaporan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Beranda;
import view.kualitas;
import view.laporan;

/**
 *
 * @author AbbiNizar
 */
public class cLaporan {

    laporan a;
    kualitas b;
    mLaporan mk;

    public cLaporan(laporan a, mLaporan mk) {
        this.a = a;
        this.mk = mk;
        this.a.klikUpdate(new updateAction());
        this.a.klikDelete(new deleteAction());
        this.a.klikKembali(new kembaliAction());
        this.a.klikCreate(new createAction());
        a.setTableData(mk.getData());
    }

    class updateAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            kualitas b = new kualitas();
            b.setVisible(true);
            mKualitas mkul;
            int baris = a.getRow();
            try {
                mkul = new mKualitas();
                b.setJudul("update kualitas");
                String Data[] = new String[a.getColumn()];

                for (int i = 0; i < a.getColumn(); i++) {
                    Data[i] = a.getData(baris, i);
                    System.out.println(Data[i]);

                }
                b.setTxtID(Data[0]);
                b.setTxtNama(Data[1]);
                b.setTxtJumlah(Data[2]);
                b.setTxtJenis(Data[3]);
                b.setTxtUkuran(Data[4]);
                b.setTxtKadar(Data[5]);
                b.setTxtAroma(Data[6]);
                b.setTxtWarna(Data[7]);
                cKualitas k = new cKualitas(b, mkul);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.dispose();

        }

    }

    class deleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (mk.delete(a.GetData())) {
                    JOptionPane.showMessageDialog(null, "Berhasil Hapus");
                    a.setTableData(mk.getData());
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
            Beranda b = new Beranda();
            b.setVisible(true);
            cBeranda k = new cBeranda(b);
            a.dispose();
        }
    }

    private class createAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            kualitas b = new kualitas();
            b.setVisible(true);
            mKualitas mk;
            try {
                mk = new mKualitas();
                cKualitas k = new cKualitas(b, mk);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            a.dispose();
        }
    }
}
