package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BookDao {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    public BookDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL+"?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = "";
    }
    protected void connect() throws SQLException{
        if(jdbcConnection==null || jdbcConnection.isClosed())
            {        
            jdbcConnection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            }
    }
    protected void disConnect() throws SQLException{
        if(jdbcConnection != null && !jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }
    public boolean updateBook(Book book) throws SQLException {
        String sql = "UPDATE books SET title = ?, author = ?, price = ?,qty = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setFloat(3, book.getPrice());
        statement.setInt(4, book.getQty());
        statement.setInt(5, book.getId());
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disConnect();
        return rowUpdated;     
    }
    public boolean deleteBook(Book book) throws SQLException {
        String sql = "DELETE FROM books where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disConnect();
        return rowDeleted;    
    }
    public boolean insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (id,title, author, price,qty) VALUES (?,?,?,?,?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, book.getId());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setFloat(4, book.getPrice());
        statement.setInt(5, book.getQty());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disConnect();
        return rowInserted;
    }
    public Book getBook(int id) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
            int qty= resultSet.getInt("qty");
             
            book = new Book(id, title, author, price,qty);
        }
         
        resultSet.close();
        statement.close();
         
        return book;
    }
    public List<Book> listAllBooks() throws SQLException {
        List<Book> listBook = new ArrayList<>();
         
        String sql = "SELECT * FROM books";
         
        connect();
         
         Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            float price = resultSet.getFloat("price");
            int qty= resultSet.getInt("qty");
             
            Book book = new Book(id, title, author, price,qty);
            listBook.add(book);
        }
         
        resultSet.close();
        statement.close();
         
        disConnect();
         
        return listBook;
    }
    
}
