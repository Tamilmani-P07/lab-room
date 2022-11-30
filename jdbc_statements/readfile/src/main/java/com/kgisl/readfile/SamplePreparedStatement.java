package com.kgisl.readfile;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SamplePreparedStatement {
    public static void main(String[] args) {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rse=null;
        String qry="select * from Sample";
        try {
            con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tamildb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");
            pstmt=con.prepareStatement(qry);
            rse=pstmt.executeQuery();
            while (rse.next()) {
                int id=rse.getInt(1);
                String name=rse.getString(2);
                Date date=rse.getDate(3);
                int sal=rse.getInt(4);
                System.out.println("-----"+id+" , "+name+" , "+date+" , "+sal +"-----" );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(pstmt!=null)
            { 
                try {
                    pstmt.close();
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
