/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.mUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Beranda;
import view.BerandaPabrik;
import view.BerandaTani;
import view.Login;
import view.laporan;
import view.pemasaran;

/**
 *
 * @author AbbiNizar
 */
public class cLogin {

    Login view;
    mUser model;

    public cLogin(Login view,mUser model)throws SQLException{
        this.view = view;
        this.model=model;
        
        this.view.setVisible(true);
        this.view.klikLogin(new loginAction());
    }

    private class loginAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int level = model.level(view.getTxtUsername(), view.getTxtPassword());
//                int level = model.level("gudang@itobacco.com", "123");
                if (level==1) {
                    Beranda a = new Beranda();
                    a.setVisible(true);
                    new cBeranda(a);
                    view.dispose();
                }
                else if (level==2) {
                    BerandaTani a = new BerandaTani();
                    a.setVisible(true);
                    new cBerandaTani(a);
                    view.dispose();
                }
                else if (level==3) {
                    BerandaPabrik a = new BerandaPabrik();
                    a.setVisible(true);
                    new cBerandaPabrik(a);
                    view.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(cLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        }

    }
//    public void showLogin (){
//        new cLogin(new Login ());
//    }

}
