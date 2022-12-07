<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <html>

        <head>
            <title>Books Store Application</title>
            <link rel="stylesheet" href="aaa.css">
        </head>

        <body>
            <center>
                <h1>Books Management</h1>
                <h2>
                    <a href="/new">Add New Book</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/list">List All Books</a>

                </h2>
            </center>
            <div align="center">
                <c:if test="${book != null}">
                    <form action="update" method="post">
                </c:if>
                <c:if test="${book == null}">
                    <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${book != null}">
                                Edit Book
                            </c:if>
                            <c:if test="${book == null}">
                                Add New Book
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${book != null}">
                        <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                    </c:if>
                    <tr>
                        <th>ID:</th>
                        <td>
                            <input type="text" name="id" size="45" value="<c:out value='${book.id}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Title: </th>
                        <td>
                            <input type="text" name="title" size="45" value="<c:out value='${book.title}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Author: </th>
                        <td>
                            <input type="text" name="author" size="45" value="<c:out value='${book.author}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Price: </th>
                        <td>
                            <input type="text" name="price" size="5" value="<c:out value='${book.price}' />" />
                        </td>
                    </tr>
                    <tr>
                        <th>Qty: </th>
                        <td>
                            <input type="text" name="qty" size="5" value="<c:out value='${book.qty}' />" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
                </form>
                <h1 id="d1">${er}</h1>
            </div>
        </body>
        <style>
            #d1 {
                background-color: crimson;
                border: 1px solid black;
            }

            table {
                background-color: aquamarine;
            }
        </style>

        </html>