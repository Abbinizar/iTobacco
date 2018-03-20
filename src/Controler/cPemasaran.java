/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Beranda;
import view.pemasaran;
import Controler.cBeranda;
import Model.mLaporan;
import view.BerandaTani;

/**
 *
 * @author AbbiNizar
 */
public class cPemasaran {
    pemasaran pms;
    Beranda brd;
    mLaporan lp;
    
    public cPemasaran(pemasaran view, mLaporan lp){

        this.pms = view;
        this.lp = lp;
        this.pms.klikKembali(new kembaliAction());
        pms.setTableData(lp.getData());
    }
    private class kembaliAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Beranda a = new Beranda();            
            a.setVisible(true);
            cBeranda k = new cBeranda(a);
            pms.dispose();
        }
    }
}
