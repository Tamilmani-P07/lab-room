package com.kgisl.readfile;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rSet = null;
        String sqlInsert = "insert into books values (7001, 'Gone Fishing', 'Kumar', 11.11, 11)";
        String strSelect = "select title, price, qty from books";
        try {
            // Class.forName("com.mySQL.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC","root","");
            java.sql.Statement stmt = connection.createStatement();
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");
            //  rSet = stmt.executeQuery(strSelect);

            // while(rSet.next()) {   // Move the cursor to the next row
            //    System.out.println(rSet.getInt("id") + ", "
            //            + rSet.getString("author") + ", "
            //            + rSet.getString("title") + ", "
            //            + rSet.getDouble("price") + ", "
            //            + rSet.getInt("qty"));
           // }
    }
    catch (SQLException e) {
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
