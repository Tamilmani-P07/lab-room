package com.kgisl.readfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectJDBC {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet rSet = null;
        String strSelect = "select title, price, qty from books";
        try {
            // Class.forName("com.mySQL.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","");
            Statement stmt = connection.createStatement();
            System.out.println("The SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {   
                String title = rset.getString("title");   
                double price = rset.getDouble("price");   
                int    qty   = rset.getInt("qty"); 
                System.out.println(title + ", " + price + ", " + qty);
                ++rowCount;
             }
             System.out.println("Total number of records = " + rowCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if (rSet!=null) {
                try {
                    rSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
