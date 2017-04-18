<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/sendmail" method="post" acceptcharset="utf-8">
	<input type="text" name="texto" id="texto" maxLength="4096"
		size="20" required placeholder="Texto" />
	<input type="text" name="asunto" id="asunto"
		maxLength="255" size="20" required placeholder="Asunto" />
	<input type="text" name="destino" id="destino"
		maxLength="255" size="20" required placeholder="Destino" />
	<input type="hidden" name="auth" value="ocg">
	<input type="submit" value="Enviar" />
</form>

</body>
</html>