<%-- 
    Document   : AfficherFautesParMatch
    Created on : 24/11/2018, 13:56:47
    Author     : gabrielleite
--%>



<%@page import="Entite.Matchs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeMatchParEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Matchs</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Afficher Matchs</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Date</td>
                <td>Heure</td>
                <td>Stade</td>
                <td>Equipe Home</td>
                <td>Equipe Away</td>
            </tr>
            <% List<Matchs> lesMatchs=listeMatchParEquipe;
                for(Matchs m : lesMatchs){%>
                <tr>
                    <td width=15%><%=m.getId()%></td>
                    <td width=15%><%=m.getDate().toString() %></td>
                    <td width=15%><%=m.getHeure() %></td>
                    <td width=15%><%=m.getStade().getNom_Stade() %></td>
                    <td width=15%><%=m.getEquipe_Home().getNom_Equipe() %></td>
                    <td width=15%><%=m.getEquipe_Away().getNom_Equipe() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
