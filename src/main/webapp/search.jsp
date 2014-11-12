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
	}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
    </head>
    <body>
		
		<form method="post" action="GetFood.do">
			<input type="hidden" name="action" value="edit">
			Name: <input type="text" name="query">
			<input type="submit" value="Search">
		</form>
    </body>
</html>
