/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbbiNizar
 */
public class mMitra {

    private koneksi con;

    public mMitra() throws SQLException {
        con = new koneksi("root", "", "itobacco");
    }

    public void createMitra(String nama, String alamat, String sebagai) {
        String query = "insert into mitra values" + "(NULL,'" + nama + "','" + alamat + "','" + sebagai + "')";
        //Statement stmt = null;
        try {
//            ResultSet rs = con.getResult(query);
            con.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean update(String[] data) throws SQLException {
        String query = "UPDATE `mitra` SET"
                + "`Nama`='" + data[1] + "',"
                + "`Alamat`='" + data[2] + "'"
                + "`Sebagai`='" + data[3] + "'"
                + " WHERE "
                + "`Id_mitra`='" + data[0] + "'";
        con.insertUpdateDelete(query);
        return false;
    }

    public boolean hapus(String id) throws SQLException {
        String query = "DELETE FROM `mitra` WHERE Id_mitra = " + id + "";
        con.insertUpdateDelete(query);
        return false;
    }

    public DefaultTableModel getData() {
        String query = "SELECT * FROM `mitra`";
        return con.select(query);
    }
}
