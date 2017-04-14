
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter Contact</title>
</head>
<body>
<h1>Ajouter Contact</h1>
<form action="AjoutContact?action=ajoutcontact" method="post">
		<fieldset id="section-1">
			<legend>Informations personnelles</legend>
			nom<input type="text" name="nom" /><br /> prenom<input type="text" name="prenom" /><br />
			email<input type="text" name="email" /><br />
		</fieldset>
		<fieldset id="section-2">
			<legend>Informations personelles</legend>
			nom de rue<input type="text" name="numRue" /><br /> code postal<input type="text"
				name="codePostal" /><br /> ville<input type="text" name="ville" /><br /> commentaire<input
				type="text" name="commentaire" /><br />
		</fieldset>
		<button name="ajoutvalider">valider saisie</button>
</form>
</body>
</html>