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
    <body>
	<h1>Link: <a href="http://a4-novacsc.rhcloud.com/">a4-novacsc.rhcloud.com</a></h1>
	<p><a href="./NewDict.do">Create a new Food Dictionary</a></p>
	<form method="post" action="Upload.do">
		<input type="file"><input type="submit" value="Build">
	</form>
	<%
		BinarySearchTree dictionary = (BinarySearchTree) session.getAttribute("dict");
		if (dictionary != null) {
			out.println("<p>The <a href='search.jsp'>current dictionary</a> has " + dictionary.size() + " entries.</p>");
		}
	%>
    </body>
</html>
