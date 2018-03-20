/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itobacco;

import Controler.cAwal;
import Controler.cLogin;
import Model.mUser;
import java.sql.SQLException;
import view.Login;
import view.awal;
//weighted product
/**
 *
 * @author AbbiNizar
 */
public class ITobacco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        new cAwal(new awal());
        
//        mLogin model = new mLogin();
//        Login view = new Login();
//        cLogin control = new cLogin(view,model);
    }
    
}
