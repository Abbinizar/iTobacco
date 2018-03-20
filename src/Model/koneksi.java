/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AbbiNizar
 */
public class koneksi {
    private Connection con;
    private Statement stm;

    public DefaultTableModel select(String query) {
        //method untuk membuat kolom dan baris ke tabel yang sesuai dengan query yang
        //dipanggil dan membuat statement untuk mengirim query dan menyimpan hasil
        //pemanggilan dari database
        DefaultTableModel hasilQueryDTM = null;
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            ResultSetMetaData metaData = rs.getMetaData();
            //membuat statement untuk mengirim query dan membuat resultset untuk menyimpan
            //hasil pemanggilan database
            Vector<String> namakolom = new Vector<>();
            int banyakKolom = metaData.getColumnCount();
            for (int column = 1; column <= banyakKolom; column++) {
                namakolom.add(metaData.getColumnName(column));

            }//untuk membuat kolom berdasar banyaknya kolom yang dipanggil di query
            //dan memberikan nama dikolom berdasarkan database yn dipanggil
            Vector<Vector<String>> hasilQuery = new Vector<Vector<String>>();
            while (rs.next()) {
                Vector<String> satuBaris = new Vector<>();
                for (int columnIndex = 1; columnIndex <= banyakKolom; columnIndex++) {
                    satuBaris.add(rs.getString(columnIndex));
                }
                hasilQuery.add(satuBaris);
            }//membuat baris berdasarkan isi dari kolom database yang di panggil
            hasilQueryDTM = new DefaultTableModel(hasilQuery, namakolom);
            //memasukan model ke tabel berdasarkan query yang dipanggil

        } catch (SQLException e) {
            System.out.println("Kesalahan t :" + e);
        }
        return hasilQueryDTM;
    }

    public koneksi(String username, String password, String db) throws SQLException{
        String url = "jdbc:mysql://localhost:3306/"+db;
        con = DriverManager.getConnection(url, username, password);
        stm = con.createStatement();
    }
    public void execute(String sql) throws SQLException{
        this.stm.executeUpdate(sql);
    }
    public ResultSet getResult (String sql) throws SQLException{
        return stm.executeQuery(sql);
    }
    public void insertUpdateDelete(String query) throws SQLException{
        try {
            Statement stmt = con.createStatement();
            
            stmt.execute(query);
            boolean berhasil = true;
            System.out.println("berhasil: " + berhasil);
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException e) {
            boolean berhasil = false;
            System.out.println("berhasil: " + berhasil);
        } catch (SQLException e) {
            System.out.println("Kesalahan i :" + e);
        }

    }


}
