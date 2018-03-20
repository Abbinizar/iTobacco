/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mMitra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Beranda;
import view.Mitra;

/**
 *
 * @author AbbiNizar
 */
public class cMitra {

    Mitra mt;
    mMitra model;
    

    public cMitra(Mitra mt, mMitra model) {
        this.mt = mt;
        this.mt.setVisible(true);
        this.model = model;
        this.mt.klikKembali(new kembaliAction());
        this.mt.klikDelete(new deleteAction());
        this.mt.klikCreate(new createAction());
        this.mt.klikUpdate(new updateAction());
        mt.setTableData(model.getData());
    }

    class updateAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int baris = mt.getRow();
            try {
                model = new mMitra();
                String Data[] = new String[mt.getColumn()];

                for (int i = 0; i < mt.getColumn(); i++) {
                    Data[i] = mt.getData(baris, i);
                    System.out.println(Data[i]);

                }
                mt.setTxtID(Data[0]);
                mt.setTxtNama(Data[1]);
                mt.setTxtAlamat(Data[2]);
                mt.setTxtSebagai(Data[3]);
                cMitra b = new cMitra(mt, model);
            } catch (SQLException ex) {
                Logger.getLogger(cBeranda.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    class createAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = mt.getNama();
            String alamat = mt.getAlamat();
            String sebagai = mt.getSebagai();
            try {
                model.createMitra(nama, alamat, sebagai);
                Beranda b = new Beranda();
                cBeranda c = new cBeranda(b);
                mt.setVisible(false);
            } catch (Exception o) {
                o.printStackTrace();
            }

        }
    }

    class deleteAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (model.hapus(mt.GetData())) {
                    JOptionPane.showMessageDialog(null, "Berhasil Hapus");
                    mt.setTableData(model.getData());
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
            Beranda a = new Beranda();
            a.setVisible(true);
            cBeranda k = new cBeranda(a);
            mt.dispose();
        }
    }
}
