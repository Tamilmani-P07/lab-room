package com.kgisl.readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class SampleStatement {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        String sqlinsert = "insert into sample values "+"(1, 'Tamil', '2022-09-29', 20000),"+"(2, 'sathya', '2022-09-29', 20001)";
        try {
           // Class.forName("com.mySQL.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/tamildb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "");
            stmt = con.createStatement();
            int exeup = stmt.executeUpdate(sqlinsert);
            System.out.println(exeup + " records inserted.\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(stmt!=null)
            { 
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
