<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nombre mystere</title>
</head>
<body>
	<h1>Nombre mystere</h1>
	<%
		Boolean gain =(Boolean) request.getAttribute("gain");
	if(gain!=null && gain){
	%>
	<h2 style="color:green">Vous avez gagné !</h2>
	<%
	}else if(gain!=null && !gain){ %>
	<h2 style="color:red">Perdu, ré-essayez !</h2>
	<%}%>
	
	<p>Veuillez saisir un nombre compris entre 1 et 10</p>
	
	<form action="/nombreMystere2/jouer" method="post">
	<label for="nombre">Nombre :</label>
		<input type="text" name="tentative" id="nombre"/>
		<button type="submit">JOUER !</button>
	</form>
</body>
</html>