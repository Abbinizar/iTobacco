/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mLaporan;
import Model.mUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Beranda;
import view.BerandaTani;
import view.Statistik;
import view.pemasaran;

/**
 *
 * @author AbbiNizar
 */
public class cStatistik {
    BerandaTani btn;
    Statistik view;
    mLaporan model;
    
    public cStatistik(Statistik view, mLaporan model ){
        this.view=view;
        this.view.klikKembali(new kembaliAction());
        view.setTableData(model.getData());
    }
    private class kembaliAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BerandaTani a = new BerandaTani();
            a.setVisible(true);
            cBerandaTani k = new cBerandaTani(a);
            view.dispose();
        }
    }
    
}
