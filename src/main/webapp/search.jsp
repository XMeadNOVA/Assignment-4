<%-- 
    Document   : search
    Created on : Nov 11, 2014, 9:52:15 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
	Xan Mead - Fall 2014
	amm28964@email.vccs.edu
-->
<%
	String message = "";
	if (request.getAttribute("message") != null) {
		message = (String) request.getAttribute("message");
		message = "<p>" + message + "</p>";
	}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
		<%=message%>
		<h1>Search!</h1>
		<form method="post" action="GetFood.do">
			Name: <input type="text" name="query">
			<input type="submit" value="Search">
		</form>
		<p>OR <a href="item.jsp">add</a> an item...</p>
    </body>
</html>
