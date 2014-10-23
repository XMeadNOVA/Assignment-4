<%--
	Document   : app
	Created on : Oct 19, 2014, 10:17:09 PM
	Author     : Xan Mead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("username");
	if (name != null && !name.equals("");) {
		name += "'s ";
	}
	else {
		name = "";
	}
%>

<!DOCTYPE html>
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><c:out value="${name}" />Food Dictionary</title>
    </head>
    <body>
		Enter name:
		<form method=post action="app.jsp">
			<input type="text" name="username">
			<input type="submit">
		</form>
	<jsp:include page="footer.jsp"/>
    </body>
</html>
