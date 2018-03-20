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
public class mPemesanan extends tembakau {

    private koneksi con;

    public mPemesanan() throws SQLException {
        super();
        con = new koneksi("root", "", "itobacco");
    }

    public void createPemesanan(String nama, String jumlah, String jenis, String grade, String harga) {
        String query = "insert into pemesanan values" + "(NULL,'" + nama + "','" + jumlah + "','" + jenis + "','" + grade + "','" + harga + "')";
        //Statement stmt = null;
        try {
//            ResultSet rs = con.getResult(query);
            con.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String query = "DELETE FROM `pemesanan` WHERE Id_pemesanan = " + id + "";
        con.insertUpdateDelete(query);
        return false;
    }

    public DefaultTableModel getData() {
        String query = "SELECT * FROM `pemesanan`";
        return con.select(query);
    }
}
