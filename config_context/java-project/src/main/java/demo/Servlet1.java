package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet{
    
    public Servlet1() {
        System.out.println("cons............");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------in--------");
        String name=req.getParameter("uname");
        String cname=getServletContext().getInitParameter("cname");
        String inname = getInitParameter("inname");
        System.out.println("name :"+name+" => cname : "+cname+" => inname : "+inname);
    }
    @Override
    public void init() throws ServletException {
        System.out.println("init.....");
    }
   
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
       
    }
    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
    static{
        System.out.println("Static...........");
    }
    {
        System.out.println("non-Static...........");
    }
}
