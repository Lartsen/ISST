<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>REEMBOLSOS</p>

<c:forEach items="${rembemp}" var="remb">
	<tr>
		<td><c:out value="${remb.solicitanteID}" /></td>
		<td><c:out value="${remb.destino}" /></td>
		<td><c:out value="${remb.proyecto}" /></td>
		<td><c:out value="${remb.cantidad}" /></td>
		<td><c:out value="${remb.estado}" /></td>
		
		<td>
		<form name="acceptRemb" action="/manageRemb" method="post">
		<input type="submit" name="acceptremb" value="Aceptar reembolso">
		<input type="hidden" name="toDo" value="accept">
		<input type="hidden" name="auth" value="ocg">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		<td>
		<form name="denyRemb" action="/manageRemb" method="post">
		<input type="submit" name="denyremb" value="Rechazar reembolso">
		<input type="hidden" name="toDo" value="deny">
		<input type="hidden" name="auth" value="ocg">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		<td>
		<form name="mail" action="/formMail" method="get">
		<input type="submit" name="mail" value="Enviar correo">
		<input type="hidden" name="proy" value="${remb.proyecto}"></form>
		</td>
		<c:if test="${not empty remb.document}">
			<td>
			<form name="doc" action="/seedoc" method="get">
			<input type="submit" name="doc" value="Ver archivo">
			<input type="hidden" name="auth" value="ocg">
			<input type="hidden" name="is" value="remb">
			<input type="hidden" name="remb" value="${remb.ID}"></form>
			</td>
		</c:if>
		
	</tr>
</c:forEach>

<p><a href="<c:url value="/init"/>"><c:out value="Logout"/></a></p>

</body>
</html>