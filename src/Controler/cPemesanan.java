/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mLaporan;
import Model.mPemesanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Beranda;
import view.BerandaPabrik;
import view.Pemesanan;
import view.PemesananMasuk;

/**
 *
 * @author AbbiNizar
 */
public class cPemesanan {
    Pemesanan p;
    BerandaPabrik brd;
    mPemesanan model;
    mLaporan lp;
    
    public cPemesanan(Pemesanan p, mPemesanan model, mLaporan lp){

        this.p = p;
        this.model=model;
        this.p.klikKembali(new kembaliAction());
        this.p.klikPesen(new pesanAction());
        p.setTableData(lp.getData());
    }
    class pesanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = p.getNama();
            String jumlah = p.getJumlah();
            String jenis = p.getJenis();
            String grade = p.getGrade();
            String harga = p.getHarga();
            try {
                model.createPemesanan(nama, jumlah, jenis, grade, harga);
                BerandaPabrik b = new BerandaPabrik();
                cBerandaPabrik c = new cBerandaPabrik(b);
                p.setVisible(false);
            } catch (Exception o) {
                o.printStackTrace();
            }

        }
    }
    private class kembaliAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BerandaPabrik a = new BerandaPabrik();
            a.setVisible(true);
            cBerandaPabrik k = new cBerandaPabrik(a);
            p.dispose();
        }
    }
}
