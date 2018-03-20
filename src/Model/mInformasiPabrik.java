/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;

/**
 *
 * @author AbbiNizar
 */
public class mInformasiPabrik extends informasi{
    

    public mInformasiPabrik() throws SQLException {
        super();
        con = new koneksi("root", "", "itobacco");
    }
    public void createInformasi(String judul, String deskripsi) {
         String query = "insert into informasi values" + "(NULL,'"+judul+"','"+deskripsi+"')";
        //Statement stmt = null;
        try{
//            ResultSet rs = con.getResult(query);
            con.execute(query);
           
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
