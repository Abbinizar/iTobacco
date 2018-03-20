/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mInformasiMasuk;
import Model.mMitra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Beranda;
import view.BerandaTani;
import view.InformasiPetani;

/**
 *
 * @author AbbiNizar
 */
public class cInformasiPetani {

    InformasiPetani ip;
    mInformasiMasuk model;

    public cInformasiPetani(InformasiPetani ip, mInformasiMasuk model) {
        this.ip = ip;
        this.model = model;
        ip.setVisible(true);
        this.ip.klikKembali(new kembaliAction());
        this.ip.klikDetails(new detailAction());
        ip.setTableData(model.getData());
    }
    private class detailAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = ip.getRow();
            try {
                model = new mInformasiMasuk();
                String Data[] = new String[ip.getColumn()];

                for (int i = 0; i < ip.getColumn(); i++) {
                    Data[i] = ip.getData(baris, i);
                    System.out.println(Data[i]);

                }
                ip.setTxtID(Data[0]);
                ip.setTxtJudul(Data[1]);
                ip.setTxtDeskripsi(Data[2]);
                cInformasiPetani b = new cInformasiPetani(ip, model);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BerandaTani a = new BerandaTani();
            a.setVisible(true);
            cBerandaTani k = new cBerandaTani(a);
            ip.dispose();
        }
    }
}
