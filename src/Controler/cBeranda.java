/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Beranda;
import view.Login;
import view.Mitra;
import view.PemesananMasuk;
import view.kualitas;
import view.laporan;
import view.pemasaran;
import view.Login;
import Controler.cKualitas;
import Model.mKualitas;
import Model.mLaporan;
import Model.mUser;
import Model.mMitra;
import Model.mPemesanan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbbiNizar
 */
public class cBeranda {

    Beranda brd;

    public cBeranda(Beranda view) {
        this.brd = view;
        this.brd.setVisible(true);
        this.brd.klikKualitas(new kualitasAction());
        this.brd.klikPemasaran(new pemasaranAction());
        this.brd.klikLaporan(new laporanAction());
        this.brd.klikMitra(new mitraAction());
        this.brd.klikPemesanan(new pemesananAction());
        this.brd.klikExit(new exitAction());
    }

    private class kualitasAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            kualitas a = new kualitas();
            a.setVisible(true);
            mKualitas mk;
            try {
                mk = new mKualitas();
                cKualitas k = new cKualitas(a, mk);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            brd.dispose();
        }
    }

    private class pemasaranAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            pemasaran a = new pemasaran();
            a.setVisible(true);
            mLaporan lp;
            try {
                lp = new mLaporan();
                cPemasaran p = new cPemasaran(a, lp);
            } catch (Exception ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            brd.dispose();
        }
    }

    private class laporanAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            laporan a = new laporan();
            a.setVisible(true);
            mLaporan mk;
            try {
                mk = new mLaporan();
                cLaporan k = new cLaporan(a, mk);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            brd.dispose();
        }
    }

    private class mitraAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Mitra a = new Mitra();
            a.setVisible(true);
            mMitra model;
            try {
                model = new mMitra();
                cMitra k = new cMitra(a, model);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            brd.dispose();
        }
    }

    private class pemesananAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            PemesananMasuk a = new PemesananMasuk();
            a.setVisible(true);
            mPemesanan pem;
            try {
                pem = new mPemesanan();
                cPemesananMasuk k = new cPemesananMasuk(a, pem);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
            brd.dispose();
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
            brd.dispose();
        }
    }
}
