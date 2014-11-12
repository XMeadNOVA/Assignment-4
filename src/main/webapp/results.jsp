<%-- 
    Document   : results
    Created on : Nov 12, 2014, 3:57:12 PM
    Author     : amm28964
--%>

<%@page import="model.FoodItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	Boolean itemFound = (Boolean) request.getAttribute("result");
	String panel = "<div>";
	if (itemFound != null && itemFound) {
		// Present "Edit or remove"
		FoodItem item = (FoodItem) request.getAttribute("item");
		
		panel += "<p>Item found!</p>";
		
		panel += "<p>";
		panel += item.getName();
		panel += "<ul>";
		for (String s : item.getIngredients()) {
			panel += "<li>" + s + "</li>";
		}
		panel += "</ul></p>";
		
		panel += "<form method='post' action='item.jsp'>";
		panel += "<input type='hidden' name='action' value='Edit'>";
		panel += "<input type='submit' value='Edit'></form>";
		
		panel += "<form method='post' action='DropFood.do'>";
		panel += "<input type='hidden' name='action' value='Remove'>";
		panel += "<input type='submit' value='Remove'></form>";
	}
	else {
		// Present "not found: create it/go back to search"
		panel += "<p>Item not found...</p>";
		
		panel += "<a href='item.jsp'>Add it</a> ";
		panel += "<a href='search.jsp'>New Search</a>";
	}
	panel += "</div>";
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results:</h1>
		<%=panel%>
		<p><a href="search.jsp">New search</a></p>
    </body>
</html>
