package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("--------------servlet1-----------");
    }
    // ---------------      include            ------------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/hi");
        requestDispatcher.include(req, resp);
        System.out.println(req.getParameter("uname")+" -> "+req.getParameter("pass")+" -> "+req.getAttribute("mass"));
    }


    // ------------        forward           --------------------
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("servlet1 post--in");
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/hi");
        requestDispatcher.forward(req, resp);
    }
        {
            System.out.println("----------non static---servlet1---------");
        }
*/
    
    
}
