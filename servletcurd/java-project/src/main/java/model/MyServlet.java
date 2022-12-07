package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MyServlet
 */
public class MyServlet extends HttpServlet {
    private BookDao bookDao;
    List<Book> listBook;

    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

        bookDao = new BookDao(jdbcURL, jdbcUsername, jdbcPassword);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();
        try {

            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertBook(req, resp);
                    break;
                case "/delete":
                    deleteBook(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateBook(req, resp);
                    break;
                default:
                    listBook(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void listBook(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        listBook = bookDao.listAllBooks();
        req.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = req.getRequestDispatcher("booklist.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book existingBook = bookDao.getBook(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        req.setAttribute("book", existingBook);
        dispatcher.forward(req, resp);
    }

    private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        float price = Float.parseFloat(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qty"));

        Book book = new Book(id, title, author, price, qty);
        bookDao.updateBook(book);
        resp.sendRedirect("list");
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));

        Book book = new Book(id);
        bookDao.deleteBook(book);
        resp.sendRedirect("list");
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        float price = Float.parseFloat(req.getParameter("price"));
        int qty = Integer.parseInt(req.getParameter("qty"));

        Book book = new Book(id, title, author, price, qty);
        String s=book.getTitle();
        System.out.println(s);
       
        if (containsName(listBook,s)) {
            String er="invalid title--> title already present";
            req.setAttribute("er", er);
            RequestDispatcher requestDispatcher= req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);

        } else {
            
            bookDao.insertBook(book);
            resp.sendRedirect("list");
        }

        
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
    public boolean containsName(final List<Book> list, final String name){
        return list.stream().filter(o -> o.getTitle().equals(name)).findFirst().isPresent();
    }
}