/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbbiNizar
 */
public class mKualitas extends tembakau {

    private koneksi con;

    public mKualitas() throws SQLException {
        super();
        con = new koneksi("root", "", "itobacco");
    }

    public void createKualitas(String nama, String jumlah, String jenis, String kadar, String ukuran, String aroma, String harga) {
        String query = "insert into kualitas values" + "(NULL,'" + nama + "','" + jumlah + "','" + jenis + "','" + kadar + "','" + ukuran + "','" + aroma + "','" + harga + "')";
        //Statement stmt = null;
        try {
//            ResultSet rs = con.getResult(query);
            con.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void update(int id, String nama, String jumlah, String jenis, String kadar, String ukuran, String aroma, String warna) throws SQLException {
        String query = "UPDATE `kualitas` SET"
                + "`Nama`='" + nama + "',"
                + "`Jumlah`='" + jumlah + "',"
                + "`Jenis`='" + jenis + "',"
                + "`Ukuran`='" + kadar + "',"
                + "`Kadar`='" + ukuran + "',"
                + "`Aroma`='" + aroma + "',"
                + "`Harga`='" + warna  + "'"
                + " WHERE "
                + "`Id_kualitas`=" + id ;
        con.execute(query);
    }

}
