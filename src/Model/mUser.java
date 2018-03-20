/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author AbbiNizar
 */
public class mUser {
   private koneksi con;
   public mUser() throws SQLException{
       con = new koneksi("root","","itobacco");
   }
   public int level(String username, String password) throws SQLException{
       int level=0;
       String query= "SELECT * from user where username ='"+username+"'and password='"+password+"'";
       ResultSet rs = con.getResult(query);
       rs.next();
       level= Integer.valueOf(rs.getString(4));
       return level;
   }
    public int aktor(String username, String password) throws SQLException{
       int result=0;
       String query ="select * from user where username ='"+username+"'and password='"+password+"'";
       ResultSet rs = con.getResult(query);
       rs.last();
       result = rs.getRow();
       return result;
   }
    public String login(String username, String password) throws SQLException{
       String user="";
       String query ="select * from user where username ='"+username+"'and password='"+password+"'";
       ResultSet rs = con.getResult(query);
       rs.next();
       user = rs.getString(1);
       return user;
   }
}
