<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/postViajeForm" method="post" acceptcharset="utf-8">
	<input type="text" name="destino" id="destino" maxLength="255"
		size="20" required placeholder="Destino" />
	<input type="text" name="proyecto" id="proyecto"
		maxLength="255" size="20" required placeholder="Proyecto" />
	<input type="text" name="inicio" id="inicio"
		maxLength="255" size="20" required placeholder="Inicio" />
	<input type="text" name="fin" id="fin"
		maxLength="255" size="20" required placeholder="Fin" />
	<input type="text" name="descripcion" id="descripcion"
		maxLength="4096" size="100" required placeholder="Descripcion" />
		
	<input type="submit" value="Enviar" />
</form>

</body>
</html>