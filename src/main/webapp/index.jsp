<%-- 
    Document   : index
    Created on : Nov 10, 2014, 10:58:24 PM
    Author     : HP
--%>

<%@page import="adt.bst.BinarySearchTree"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
	Xan Mead - Fall 2014
	amm28964@email.vccs.edu
-->
<html>
    <head>
	<title>BST Food Dictionary</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
	<%
		BinarySearchTree dictionary = (BinarySearchTree) session.getAttribute("dict");
		String dictStatus = "";
		if (dictionary != null) {
			dictStatus = "<p>The <a href='search.jsp'>current dictionary</a> has " + dictionary.size() + " entries.</p>";
		}
	%>
    <body>
	<h1>Link: <a href="http://a4-novacsc.rhcloud.com/">a4-novacsc.rhcloud.com</a></h1>
	<p><a href="./NewDict.do">Create a new Food Dictionary</a></p>
	Upload an old dictionary:<br>
		<form method="post" action="Upload.do" enctype="multipart/form-data">
			<input type="file"><br>
			<input type="submit" value="Build">
		</form>
	<p><%=dictStatus%></p>
    </body>
</html>
