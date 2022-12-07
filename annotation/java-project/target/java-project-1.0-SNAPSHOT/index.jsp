<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<h2>Hello World!-><%= getServletContext().getInitParameter("box") %></h2>

<form action="hi" method="get">
    <input type="submit" value="save">
</form>
<%= getServletContext().getInitParameter("box") %>

</body>
</html>
