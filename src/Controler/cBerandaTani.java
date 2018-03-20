/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mInformasiMasuk;
import Model.mInformasiPabrik;
import Model.mKualitas;
import Model.mLaporan;
import Model.mUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.BerandaTani;
import view.InformasiMasuk;
import view.InformasiPetani;
import view.Login;
import view.Statistik;
import view.laporan;
import view.pemasaran;

/**
 *
 * @author AbbiNizar
 */
public class cBerandaTani {

    BerandaTani btn;

    public cBerandaTani(BerandaTani view) {
        this.btn = view;
        this.btn.setVisible(true);
        this.btn.klikStatistik(new statistikAction());
        this.btn.klikInfo(new infoAction());
        this.btn.klikExit(new exitAction());
    }

    private class statistikAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Statistik a = new Statistik();
            a.setVisible(true);
            mLaporan lp;
            try {
                lp = new mLaporan();
                cStatistik k = new cStatistik(a, lp);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            btn.dispose();
        }
    }

    private class infoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            InformasiPetani a = new InformasiPetani();
            a.setVisible(true);
            mInformasiMasuk mk;
            try {
                mk = new mInformasiMasuk();
                cInformasiPetani k = new cInformasiPetani(a, mk);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            btn.dispose();
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
            btn.dispose();
        }
    }
}
