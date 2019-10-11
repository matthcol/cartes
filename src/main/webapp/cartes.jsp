<%@page import="cartes.Carte"%>
<%@page import="cartes.JeuCarte"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Super Poker Las Vegas</title>
</head>
<body>
<% 
	Carte carte = (Carte) request.getAttribute("carte");
	JeuCarte jeu = (JeuCarte) session.getAttribute("jeu");
%>
<main>
<section>
<a href=""><img id="deck" src="images/dos-carte.png" alt="deck"></a>
<p>Nombre de cartes : <%=jeu.taille() %></p>
</section>
<section>
<%if (Objects.nonNull(carte)) {%>
<img id="see" src="images/<%=carte.filename() %>" alt="carte">
<% } %>
</section>
</main>

</body>
</html>