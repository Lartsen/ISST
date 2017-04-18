<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<c:if test="${not empty error}">
	<c:out value="${error}" />
</c:if>

<p></p>

<form action="/login" method="post" acceptcharset="utf-8">
	<input type="text" name="usuario" id="usuario" maxLength="255"
		size="20" required placeholder="Usuario" />
	<input type="password" name="password" id="password"
		maxLength="255" size="20" required placeholder="Contraseña" />
	<input type="submit" value="Send" />
</form>

</body>
</html>