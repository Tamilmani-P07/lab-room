<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
             "http://www.w3.org/TR/html4/loose.dtd">


            <html lang="en">

            <body>
                <div align="center">
                    <table border="1" cellpadding="5">
                        <caption><h2>List of book</h2></caption>
                        <tr>
                            <th>id</th>
                            <th>title</th>
                            <th>author</th>
                            <th>price</th>
                            <th>qty</th>
                        </tr>
                        <c:forEach var="user" items="${g}">
                            <tr>
                                <td><c:out value="${user.id}" /></td>
                                <td><c:out value="${user.title}" /></td>
                                <td><c:out value="${user.author}" /></td>
                                <td><c:out value="${user.price}" /></td>
                                <td><c:out value="${user.qty}" /></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </body>

            </html>