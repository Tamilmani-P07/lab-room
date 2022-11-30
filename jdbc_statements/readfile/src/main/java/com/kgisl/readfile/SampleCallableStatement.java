package com.kgisl.readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.CallableStatement;

public class SampleCallableStatement {
    public static void main(String[] args) {
        Connection con=null;
        CallableStatement cstmt=null;
        Scanner sc=null;
        String qry="insert into sample values (?,?,?,?)";
        try {
            con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tamildb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                 "root", "");

            cstmt=con.prepareCall(qry);
            sc=new Scanner(System.in);
            System.out.println("Enter the id,name,doj,sal values");
            cstmt.setInt(1, sc.nextInt());
            cstmt.setString(2, sc.next());
            cstmt.setString(3, sc.next());
            cstmt.setInt(4, sc.nextInt());
            cstmt.executeUpdate();
            System.out.println("---Data Inserted---");    
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(cstmt!=null){
                try {
                    cstmt.close();
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
