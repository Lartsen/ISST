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

<p>Tus viajes</p>

<c:forEach items="${viajesemp}" var="viaje">
	<tr>
		<td><c:out value=" Destino: ${viaje.destino}" /></td>
		<td><c:out value=" Proyecto: ${viaje.proyecto}" /></td>
		<td><c:out value=" Inicio: ${viaje.inicio}" /></td>
		<td><c:out value=" Fin: ${viaje.fin}" /></td>
		<td><c:out value=" Descripcion: ${viaje.descripcion}" /></td>
		<td><c:out value=" Estado: ${viaje.estado}" /></td>
		<td>
		<form name="delete" action="/delete" method="post">
		<input type="hidden" name="auth" value="emp">
		<input type="submit" name="deletevia" value="Eliminar viaje">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
	</tr>
</c:forEach>

<p>Tus reembolsos</p>

<c:forEach items="${rembemp}" var="remb">
	<tr>
		<td><c:out value=" Destino: ${remb.destino}" /></td>
		<td><c:out value=" Proyecto: ${remb.proyecto}" /></td>
		<td><c:out value=" Cantidad (euros): ${remb.cantidad}" /></td>
		<td><c:out value=" Estado: ${remb.estado}" /></td>
		<td>
		<form name="delete" action="/delete" method="post">
		<input type="submit" name="deleteremb" value="Eliminar reembolso">
		<input type="hidden" name="auth" value="emp">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
	</tr>
</c:forEach>

<p><a href="<c:url value="/formViaje"/>"><c:out value="Solicita un nuevo viaje"/></a></p>
<p><a href="<c:url value="/formRemb"/>"><c:out value="Solicita un nuevo reembolso"/></a></p>
<p><a href="<c:url value="/init"/>"><c:out value="Logout"/></a></p>

</body>
</html>