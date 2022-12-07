package demo;

import java.io.IOException;
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
@WebServlet("/person")
public class MyServlet extends HttpServlet{
    List<Person> list= new ArrayList<Person>();int i=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // list.add(new Person(1, "Tamil"));
        // list.add(new Person(2, "sathya"));
        // list.add(new Person(3, "praveen"));
        Gson g = new Gson();
       
        String books = g.toJson(list);
        
        resp.getWriter().print(books);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqData=req.getReader().lines().collect(Collectors.joining());
        Person newp=new Gson().fromJson(reqData, Person.class);
        int id=++i;
        String s=newp.getName();
        list.add(new Person(id, s));
        i=id;
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqData=req.getReader().lines().collect(Collectors.joining());
        Person newp=new Gson().fromJson(reqData, Person.class);
        Person p=null;
        int id=newp.getId();
        String s=newp.getName();
        for (Person person : list) {
            if(person.getId()==id){
                p=person;
            }
        }
        int i=list.indexOf(p);  
        list.set(i, new Person(id, s));
        
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("del");
        String reqData=req.getReader().lines().collect(Collectors.joining());
        Person newp=new Gson().fromJson(reqData, Person.class);
        int id=newp.getId();
        System.out.println(id);
        for (Person person : list) {
            if(person.getId()==id){
                list.remove(person);
            }
        }
    }
}