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
public class tembakau {
    private koneksi con;
    String nama;
    String jumlah;
    String jenis;
    String kadar;
    String ukuran;
    String aroma;
    String harga;
    public tembakau() throws SQLException{
        con = new koneksi("root", "", "itobacco");
//        this.aroma=aroma;
//        this.nama=nama;
//        this.jumlah=jumlah;
//        this.jenis=jenis;
//        this.kadar=kadar;
//        this.harga=harga;
//        this.ukuran=ukuran;
    }
    public boolean delete(String id)throws SQLException{
        return false;
        
    }
    public boolean update()throws SQLException{
        return false;
        
    }

}
