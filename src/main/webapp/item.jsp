<%--
	Document   : app
	Created on : Oct 19, 2014, 10:17:09 PM
	Author     : Xan Mead
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
Xan Mead - Fall 2014
amm28964@email.vccs.edu
-->
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Food Dictionary</title>
		<script src="./js/dynaList.js" language="Javascript" type="text/javascript"></script>
    </head>
    <body>
		<h3><%= request.getAttribute("action")%> a Food</h3>
		<form method="POST" action="add.jsp">
			Name: <input type="text" value="" name="foodName">
			<%-- This is where we populate with FoodItem's ingredients. --%>
			<input type="submit" value="Action"><br>
			<input type="button" value="Add ingredient" onClick="addInput('fieldSet');">
			<input type="button" value="Remove ingredient" onClick="removeInput('fieldSet');">
			<div id="fieldSet"></div>
		</form>
    </body>
</html>
