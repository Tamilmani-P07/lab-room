package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@
public class Servlet1 extends HttpServlet{
    {
        System.out.println("-----------Servlet1---------");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("..........in.....");
        Connection con=null;
        CallableStatement cstmt=null;
        Scanner sc=null;
        String qry="insert into sample values (?,?,?,?)";
        try {
            con=DriverManager.getConnection(getServletContext().getInitParameter("DBURL")+"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",getServletContext().getInitParameter("USER"),getServletContext().getInitParameter("pass"));

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
        ServletContext ctx = req.getServletContext();
			ctx.setAttribute("User", "Tamil");
			String user = (String) ctx.getAttribute("User");
			ctx.removeAttribute("User");
			
			HttpSession session = req.getSession();
			session.invalidate();
			
			PrintWriter out = resp.getWriter();
			out.write("Hi "+user);
    }
}
}
