package demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class Servlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("hi-----------------2");
        String s="Tamil";
        //req.setAttribute("box", s);
        getServletContext().setInitParameter("box", s);
       // ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
