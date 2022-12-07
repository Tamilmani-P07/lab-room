package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    public void connect() throws SQLException{
        if(jdbcConnection==null || jdbcConnection.isClosed()){
        jdbcConnection=DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
    public void disconnect() throws SQLException{
        if(jdbcConnection!=null||!jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }
    public List<Book> getAllBooks() throws SQLException{
        connect();
        // String qry1="select * from books";
        String qry1="SELECT b.id,b.title,b.price,b.author_id,a.a_name FROM author a inner join books b WHERE a.a_id=b.author_id";
        Statement pstmt=jdbcConnection.createStatement();
        ResultSet rs= pstmt.executeQuery(qry1);
        List<Book> listBook=new ArrayList<Book>();
        while (rs.next()) {
            int id=rs.getInt("id");
            String title=rs.getString("title");
            float price=rs.getFloat("price");
            String author_name=rs.getString("a_name");
            System.out.println(id+" "+ title +" "+ price+"  "+author_name);
            Book b=new Book(id, title, price, author_name);
            listBook.add(b);
        }
        rs.close();
        pstmt.close();
        disconnect();
        return listBook;
    }
    public void insert(int i, String t, float p,int aid) throws SQLException {
        String qry = "INSERT INTO books (id,title, price,author_id) VALUES (?,?,?,?)";
        connect();
       
        PreparedStatement pstmt=jdbcConnection.prepareStatement(qry);
        pstmt.setInt(1, i);
        pstmt.setString(2, t);
        pstmt.setFloat(3, p);
        pstmt.setInt(4, aid);
        System.out.println(pstmt.executeUpdate());

        pstmt.close();
        disconnect();
    }
   

}
