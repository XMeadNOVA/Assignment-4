<%--
	Document   : app
	Created on : Oct 19, 2014, 10:17:09 PM
	Author     : Xan Mead
--%>
<%@page import="adt.linked_list.LinkedList"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.FoodItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
	Xan Mead - Fall 2014
	amm28964@email.vccs.edu
-->
	<%-- Build the ingredient list based on the selected item. --%>
	<%
		String ingredientList = "";
		String foodName = "";
		int count = 0;
		if (request.getAttribute("item") != null) {
			FoodItem item = (FoodItem) request.getAttribute("item");
			foodName = item.getName();
			LinkedList<String> list = item.getIngredients();
			for (String i : list) {
				count++;
				ingredientList = "<div>Ingredient " + count + "<br><input type='text' value='" + i + "' name='ingredients'><div>";
			}
		}
		String action = "Add";
		if (request.getAttribute("action") != null) {
			action = (String) request.getAttribute("action");
		}
	%>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Food Dictionary</title>
		<script src="./js/dynaList.js" language="Javascript" type="text/javascript"></script>
		<script language="Javascript" type="text/javascript">
			<%="counter = " + count + ";"%>
		</script>
    </head>
    <body>
		<h1><%=request.getAttribute("action")%> a Food</h1>
		<p>OR <a href="search.jsp">search</a> your dictionary.</p>
		<form method="POST" action="Food.do">
			<input type="hidden" name="action" value="<%=request.getAttribute("action")%>">
			Name: <input type="text" value="<%=foodName%>" name="foodName">
			<input type="submit" value="Go"><br>
			<input type="button" value="Add ingredient" onClick="addInput('fieldSet');">
			<input type="button" value="Remove ingredient" onClick="removeInput('fieldSet');">
			<div id="fieldSet">
				<%=ingredientList%>
			</div>
		</form>
    </body>
</html>
