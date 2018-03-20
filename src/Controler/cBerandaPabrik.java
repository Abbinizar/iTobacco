/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mInformasiPabrik;
import Model.mLaporan;
import Model.mUser;
import Model.mPemesanan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.BerandaPabrik;
import view.InformasiPabrik;
import view.Login;
import view.Pemesanan;

/**
 *
 * @author AbbiNizar
 */
public class cBerandaPabrik {

    BerandaPabrik bpk;

    public cBerandaPabrik(BerandaPabrik view) {
        this.bpk = view;
        this.bpk.setVisible(true);
        this.bpk.klikInformasi(new informasiAction());
        this.bpk.klikBelanja(new belanjaAction());
        this.bpk.klikExit(new exitAction());
    }

    private class informasiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            InformasiPabrik a = new InformasiPabrik();
            a.setVisible(true);
            mInformasiPabrik model;
            try {
                model = new mInformasiPabrik();
                cInformasiPabrik k = new cInformasiPabrik(a, model);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            bpk.dispose();
        }
    }

    private class belanjaAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pemesanan a = new Pemesanan();
            a.setVisible(true);
            mPemesanan model;
            mLaporan lp;
            try {
                model = new mPemesanan();
                lp = new mLaporan();
                cPemesanan k = new cPemesanan(a, model, lp);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            bpk.dispose();
        }
    }

    private class exitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Login a = new Login();
            a.setVisible(true);
            mUser ml;
            try {
                ml = new mUser();
                cLogin k = new cLogin(a, ml);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            bpk.dispose();
        }
    }
}
