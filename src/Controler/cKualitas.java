/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.kualitas;
import Model.mKualitas;
import java.sql.SQLException;
import view.Beranda;
import Controler.cBeranda;
import Model.mUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Login;

/**
 *
 * @author AbbiNizar
 */
public class cKualitas {

    kualitas kls;
    mKualitas model;

    public cKualitas(kualitas kls, mKualitas model) throws SQLException {
        this.kls = kls;
        this.model = model;
        this.kls.setVisible(true);
        this.kls.klikSubmit(new submitAction());
        this.kls.klikKembali(new kembaliAction());
    }

    cKualitas(kualitas b) {
        this.kls = b;
    }

    class submitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int id = Integer.valueOf(kls.getID());
            String nama = kls.getNama();
            String jumlah = kls.getJumlah();
            String jenis = kls.getJenis();
            String ukuran = kls.getUkuran();
            String kadar = kls.getKadar();
            String aroma = kls.getAroma();
            String warna = kls.getWarna();
            try {
                if (kls.getJudul().equalsIgnoreCase("update kualitas")) {
                    model.update(id, nama, jumlah, jenis, kadar, ukuran, aroma, warna);
                    Beranda b = new Beranda();
                    cBeranda c = new cBeranda(b);
                    kls.setVisible(false);
                } else {
                    model.createKualitas(nama, jumlah, jenis, kadar, ukuran, aroma, warna);
                    Beranda b = new Beranda();
                    cBeranda c = new cBeranda(b);
                    kls.setVisible(false);

                }

            } catch (Exception o) {
                o.printStackTrace();
            }

        }
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Beranda a = new Beranda();
            a.setVisible(true);
            cBeranda k = new cBeranda(a);
            kls.dispose();
        }
    }
}
