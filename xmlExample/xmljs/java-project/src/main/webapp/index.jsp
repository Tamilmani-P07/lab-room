<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <html>
        <head><link rel="stylesheet" href="design1.css"></head>
    <body>
    <div id="demo">Welcome guys</div>

   <!-- <center><h1 id="demo">Welcome!!!</h1></center> -->
   <div id="a">
    <button id="d1" type="button" onclick="loadGet()">click to GET</button><br>
    <button id="d2" type="button" onclick="loadPost()">click to POST</button><br>
    <button id="d3" type="button" onclick="loadPut()">click to PUT</button><br>
    <button id="d4" type="button" onclick="loadDel()">click to DEL</button><br>
    <button id="d6" type="button" onclick="loadHead()">click to HEAD</button><br>
</div>
    <!-- <form >
        <button id="d1" type="button" onclick="loadGet()">click to GET</button><br>
    </form> -->
   
    
    <script src="xmlreq1.js"></script>
    
    </body>
    </html>
