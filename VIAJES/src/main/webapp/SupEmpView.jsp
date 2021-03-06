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
		<td><c:out value="${viaje.destino}" /></td>
		<td><c:out value="${viaje.proyecto}" /></td>
		<td><c:out value="${viaje.inicio}" /></td>
		<td><c:out value="${viaje.fin}" /></td>
		<td><c:out value="${viaje.descripcion}" /></td>
		<td><c:out value="${viaje.estado}" /></td>
		<td>
		<form name="delete" action="/delete" method="post">
		<input type="hidden" name="auth" value="sup">
		<input type="submit" name="deletevia" value="Eliminar viaje">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
		<td>
		<form name="file" action="/formFile" method="post">
		<input type="submit" name="file" value="Subir archivo">
		<input type="hidden" name="auth" value="sup">
		<input type="hidden" name="is" value="via">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
		<td>
		<form name="mail" action="/formMail" method="get">
		<input type="submit" name="mail" value="Enviar correo">
		<input type="hidden" name="proy" value="${viaje.proyecto}"></form>
		</td>
	</tr>
</c:forEach>

<p>Tus reembolsos</p>

<c:forEach items="${rembemp}" var="remb">
	<tr>
		<td><c:out value="${remb.destino}" /></td>
		<td><c:out value="${remb.proyecto}" /></td>
		<td><c:out value="${remb.cantidad}" /></td>
		<td><c:out value="${remb.estado}" /></td>
		<td>
		<form name="delete" action="/delete" method="post">
		<input type="hidden" name="auth" value="sup">
		<input type="submit" name="deletevia" value="Eliminar reembolso">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		<td>
		<form name="file" action="/formFile" method="post">
		<input type="submit" name="file" value="Subir archivo">
		<input type="hidden" name="auth" value="sup">
		<input type="hidden" name="is" value="remb">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		
	</tr>
</c:forEach>

<p>Viajes de tus empleados</p>

<c:forEach items="${viajesup}" var="viaje">
	<tr>
		<td><c:out value="${viaje.solicitanteID}" /></td>
		<td><c:out value="${viaje.destino}" /></td>
		<td><c:out value="${viaje.proyecto}" /></td>
		<td><c:out value="${viaje.inicio}" /></td>
		<td><c:out value="${viaje.fin}" /></td>
		<td><c:out value="${viaje.descripcion}" /></td>
		<td><c:out value="${viaje.estado}" /></td>
		<td>
		<form name="acceptVia" action="/manageVia" method="post">
		<input type="submit" name="acceptvia" value="Aceptar viaje">
		<input type="hidden" name="toDo" value="accept">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
		<td>
		<form name="denyVia" action="/manageVia" method="post">
		<input type="submit" name="denyvia" value="Rechazar viaje">
		<input type="hidden" name="toDo" value="deny">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
		<c:if test="${not empty viaje.document}">
		<td>
		<form name="doc" action="/seedoc" method="get">
		<input type="submit" name="doc" value="Ver archivo">
		<input type="hidden" name="auth" value="sup">
		<input type="hidden" name="is" value="via">
		<input type="hidden" name="via" value="${viaje.ID}"></form>
		</td>
		</c:if>
	</tr>
</c:forEach>

<p>Reembolsos de tus empleados</p>

<c:forEach items="${rembsup}" var="remb">
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
		<input type="hidden" name="auth" value="sup">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		<td>
		<form name="denyRemb" action="/manageRemb" method="post">
		<input type="submit" name="denyremb" value="Rechazar reembolso">
		<input type="hidden" name="toDo" value="deny">
		<input type="hidden" name="auth" value="sup">
		<input type="hidden" name="remb" value="${remb.ID}"></form>
		</td>
		<c:if test="${not empty remb.document}">
			<td>
			<form name="doc" action="/seedoc" method="get">
			<input type="submit" name="doc" value="Ver archivo">
			<input type="hidden" name="auth" value="sup">
			<input type="hidden" name="is" value="remb">
			<input type="hidden" name="remb" value="${remb.ID}"></form>
			</td>
		</c:if>
	</tr>
</c:forEach>

<p><a href="<c:url value="/formViaje"/>"><c:out value="Solicita un nuevo viaje"/></a></p>
<p><a href="<c:url value="/formRemb"/>"><c:out value="Solicita un nuevo reembolso"/></a></p>
<p><a href="<c:url value="/init"/>"><c:out value="Logout"/></a></p>

</body>
</html>