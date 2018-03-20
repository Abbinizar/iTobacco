/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbbiNizar
 */
public class mLaporan extends tembakau{
    private DefaultTableModel tableModel;
    private koneksi con;

    public mLaporan() throws SQLException {
        super();
        con = new koneksi("root", "", "itobacco");
        String header[] = {"id", "Nama", "Jumlah", "Jenis", "Ukuran","Kadar", "Aroma", "Harga"};
        tableModel = new DefaultTableModel(null, header);
    }
//        public boolean save(String[] data) throws SQLException {
//        String query = "INSERT INTO `kualitas`('id','Nama, 'Jumlah', 'Jenis', 'Ukuran','Kadar', 'Aroma', 'Warna') VALUES "
//                + "('" + data[1] + "','" + data[2]+ "','" + data[3]+ "','" 
//                + data[4]+ "','" + data[5]+ "','" + data[6]+ "','" + data[7]+ "','" + "')";
//        con.insertUpdateDelete(query);
//        return false;
//        
//    }
//
//    public DefaultTableModel getList() {
//        return tableModel;
//    }
//
//    public void loadData() {
//        tableModel.removeTableModelListener(null);
//
//        try {
//            String sql = "SELECT * FROM kualitas ORDER BY RIGHT( Id_kualitas, 3 ) ASC";
//            ResultSet r = con.getResult(sql);
//
//            while (r.next()) {
//                //lakukan penelusuran baris
//                Object o = r.getString(2);
//
//                tableModel.addColumn(o);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            System.out.println("terjadi error pada load data");
//
//        }
//    }
//
//    public String[] getKeterangan(int id) {
//        String[] Keterangan = new String[8];
//        try {
//            String sql = "SELECT * FROM kualitas where Id_kualitas =" + id + "";
//            ResultSet r = con.getResult(sql);
//
//            while (r.next()) {
//                //lakukan penelusuran baris
//                Keterangan[0] = r.getString("nama");
//                Keterangan[1] = r.getString(1);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            System.out.println("terjadi error pada load data");
//        }
//        return Keterangan;
//    }
//"Nama", "Jumlah", "Jenis", "Ukuran","Kadar", "Aroma", "Warna"
    public boolean update(String[] data) throws SQLException {
        String query = "UPDATE `kualitas` SET"
                + "`Nama`='" + data[1] + "',"
                + "`Jumlah`='" + data[2] + "'"
                + "`Jenis`='" + data[3] + "'"
                + "`Ukuran`='" + data[4] + "'"
                + "`Kadar`='" + data[5] + "'"
                + "`Aroma`='" + data[7] + "'"
                + "`Harga`='" + data[8] + "'"
                + " WHERE "
                + "`Id_kualitas`='" + data[0] + "'";
        con.insertUpdateDelete(query);
        return false;
    }
    @Override
    public boolean delete(String id) throws SQLException {
        String query = "DELETE FROM `kualitas` WHERE Id_kualitas = " + id + "";
        con.insertUpdateDelete(query);
        return false;
    }

    public DefaultTableModel getData() {
        String query = "SELECT * FROM `kualitas`";
        return con.select(query);
    }
}
