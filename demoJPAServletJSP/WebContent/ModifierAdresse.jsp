<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier Adresse</title>
</head>
<body>
	<h1>Modifier Adresse</h1>
	<hr />
	<form action="ModifierAdresse?action=fromFormModifierAdresse"
		method="post">
		<fieldset id="section-2">
			<legend>Informations personelles</legend>
			id<input type="text" name="id" /><br /> 
			nom de rue<input type="text" name="numRue" /><br /> code postal<input
				type="text" name="codePostal" /><br /> ville<input type="text"
				name="ville" /><br /> commentaire<input type="text"
				name="commentaire" /><br />
		</fieldset>
		<button name="ajoutvalider">valider saisie</button>
	</form>
	<c:if test="${!empty requestScope.modifOk}">
		<c:out value="Adresse modifié"></c:out>
		<c:remove var="modifOk" scope="request" />
	</c:if>
	<hr />
	<a href="index.html">retour accueil</a>
</body>
</html>