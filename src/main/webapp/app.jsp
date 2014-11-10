<%--
	Document   : app
	Created on : Oct 19, 2014, 10:17:09 PM
	Author     : Xan Mead
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Food Dictionary</title>
		<script src="./js/dynaList.js" language="Javascript" type="text/javascript"></script>
    </head>
    <body>
		<h3>Action a Food</h3>
		<form method="POST">
			Name: <input type="text" value="" name="foodName">
			<%-- This is where we populate with FoodItem's ingredients. --%>
			<input type="submit" value="Action"><br>
			<input type="button" value="Add ingredient" onClick="addInput('fieldSet');">
			<input type="button" value="Remove ingredient" onClick="removeInput('fieldSet');">
			<div id="fieldSet"></div>
		</form>
    </body>
</html>
