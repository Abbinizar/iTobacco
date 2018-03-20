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
public class informasi {

    koneksi con;

    public informasi() throws SQLException {
        con = new koneksi("root", "", "itobacco");
    }
}
