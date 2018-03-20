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
import view.Login;
import view.awal;

/**
 *
 * @author AbbiNizar
 */
public class cAwal {

    awal view;

    public cAwal(awal view) {
        this.view = view;
        this.view.setVisible(true);
        this.view.klikStart(new startAction());
    }

    private class startAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                new cLogin(new Login(), new mUser());
            } catch (SQLException ex) {
                Logger.getLogger(cAwal.class.getName()).log(Level.SEVERE, null, ex);
            }
            view.setVisible(false);

        }

    }
}
