<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Supprimer Adresse</title>
</head>
<body>
	<h1>Supprimer Adresse</h1>
	<hr />
	<form action="DeleteAdresse?action=fromFormDeleteAdresse"
		method="post">
		<fieldset id="section-2">
			<legend>Informations personnelles</legend>
			id<input type="text" name="id" /><br /> 
		</fieldset>
		<button name="deletevalider">valider saisie</button>
	</form>
	<c:if test="${!empty requestScope.deleteOk}">
		<c:out value="Adresse supprimée"></c:out>
		<c:remove var="deleteOk" scope="request" />
	</c:if>
	<hr />
	<a href="index.html">retour accueil</a>
</body>
</html>