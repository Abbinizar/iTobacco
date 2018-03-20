/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Model.koneksi;

/**
 *
 * @author AbbiNizar
 */
public class mInformasiMasuk extends informasi{

  
    DefaultTableModel tableModel1;

    public mInformasiMasuk() throws SQLException {
        super();
        con = new koneksi("root", "", "itobacco");
        String header[] = {"id", "Judul", "Deskripsi"};
        DefaultTableModel tableModel = new DefaultTableModel(null, header);
    }

    public boolean hapus(String id) throws SQLException {
        String query = "DELETE FROM `informasi` WHERE Id_informasi = " + id + "";
        con.insertUpdateDelete(query);
        return false;
    }

    public DefaultTableModel getData() {
        String query = "SELECT * FROM `informasi`";
        return con.select(query);
    }

}
