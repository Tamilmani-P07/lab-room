package demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * MyServlet
 */
@WebServlet("/books")
public class MyServlet extends HttpServlet{
    BookDao bookDao;
    @Override
    public void init() throws ServletException {
         String jdbcURL="jdbc:mysql://localhost:3306/tamildb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
         String jdbcUsername="root";
         String jdbcPassword="";
         bookDao= new BookDao(jdbcURL, jdbcUsername, jdbcPassword);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get all list");
        List<Book> list;
        try {
            list = bookDao.getAllBooks();
            Gson g = new Gson();
            String books;
            books = g.toJson(list);
            list.clear();
            resp.getWriter().print(books);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        String requestData = req.getReader().lines().collect(Collectors.joining());
        Book newBook = new Gson().fromJson(requestData, Book.class);
        System.out.println(newBook.getId()+"  "+ newBook.getTitle()+"  "+newBook.getPrice()+" "+newBook.getAuthor_id());
        try {
            bookDao.insert(newBook.getId(),newBook.getTitle(),newBook.getPrice(),newBook.getAuthor_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Delete");
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("put");

    }
 
    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Head");

    }
}