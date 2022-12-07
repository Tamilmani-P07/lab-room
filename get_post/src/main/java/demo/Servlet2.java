package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet{
    {
        System.out.println("----------non static---servlet2---------");
    }
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
}

    // ---------------      include            ------------------

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name=req.getParameter("uname");
    String pass=req.getParameter("pass");
    System.out.println("name : "+name+" ->  password : "+pass);
    req.setAttribute("mass","123");
}
        // ------------        forward           --------------------

    /*
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("-------------servlet2--- in ------");
        String name=req.getParameter("uname");
        String pass=req.getParameter("pass");
        System.out.println("name : "+name+" ->  password : "+pass);
        System.out.println("-------------servlet2--- out ------");

    }*/
}
