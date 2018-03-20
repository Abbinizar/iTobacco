/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mInformasiMasuk;
import Model.mInformasiPabrik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Beranda;
import view.BerandaPabrik;
import view.InformasiMasuk;
import view.InformasiPabrik;
import view.PemesananMasuk;

/**
 *
 * @author AbbiNizar
 */
public class cInformasiPabrik {

    InformasiPabrik ip;
    BerandaPabrik bpk;
    mInformasiPabrik model;

    public cInformasiPabrik(InformasiPabrik pm, mInformasiPabrik model) {

        this.ip = pm;
        this.model = model;
        this.ip.setVisible(true);
        this.ip.klikSave(new saveAction());
        this.ip.klikKembali(new kembaliAction());
        this.ip.klikLihat(new lihatAction());
    }

    private class saveAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String judul = ip.getJudul();
            String deskripsi = ip.getDeskripsi();

            try {
                model.createInformasi(judul, deskripsi);
                mInformasiMasuk model = new mInformasiMasuk();
                InformasiMasuk b = new InformasiMasuk();
                cInformasiMasuk c = new cInformasiMasuk(b, model);
                ip.setVisible(false);
            } catch (Exception o) {
                o.printStackTrace();
            }
        }

    }

    private class lihatAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                InformasiMasuk b = new InformasiMasuk();
                mInformasiMasuk model = new mInformasiMasuk();
                cInformasiMasuk c = new cInformasiMasuk(b, model);
                ip.setVisible(false);

            } catch (Exception o) {
                o.printStackTrace();
            }

        }
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BerandaPabrik a = new BerandaPabrik();
            a.setVisible(true);
            cBerandaPabrik k = new cBerandaPabrik(a);
            ip.dispose();
        }
    }
}
