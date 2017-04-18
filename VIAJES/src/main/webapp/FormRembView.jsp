<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/postRembForm" method="post" acceptcharset="utf-8">
	<input type="text" name="destino" id="destino" maxLength="255"
		size="20" required placeholder="Destino" />
	<input type="text" name="proyecto" id="proyecto"
		maxLength="255" size="20" required placeholder="Proyecto" />
	<input type="text" name="cantidad" id="cantidad"
		maxLength="255" size="20" required placeholder="Cantidad" />
	<input type="submit" value="Send" />
</form>

</body>
</html>