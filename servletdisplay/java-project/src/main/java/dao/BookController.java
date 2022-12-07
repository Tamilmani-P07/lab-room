package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hi")
public class BookController extends HttpServlet 
{/**
    * @throws SQLException
    */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----------get-in--------");
        Connection con=null;
        CallableStatement cstmt=null;
        ResultSet rs=null;
        String qry="select * from books";
        ArrayList<Book> booklist = new ArrayList<Book>();
        try {
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
             "root", "");
             cstmt = con.prepareCall(qry);
             rs=cstmt.executeQuery();
            while (rs.next()) {
                int id =rs.getInt(1);
                String title=rs.getString(2);
                String author=rs.getString(3);
                float price=rs.getFloat(4);
                int qty=rs.getInt(5);
                booklist.add(new Book(id, title, author, price, qty));
            }
            req.setAttribute("g", booklist);
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
    
            System.out.println("----------get--out-------");
        } catch (Exception e ) {
            e.printStackTrace();
            System.out.println("error is"+e);
        }
        finally{
            if(rs==null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(cstmt==null){
                try {
                    cstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con==null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
