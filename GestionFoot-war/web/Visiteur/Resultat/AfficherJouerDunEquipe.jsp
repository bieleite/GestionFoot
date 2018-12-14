<%-- 
    Document   : AfficherJouerDunEquipe
    Created on : 30/11/2018, 01:02:49
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeJouerDunEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Jouer</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Afficher Jouer</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Prenom</td>
            </tr>
            <% List<Jouer> lesJoeurs=listeJouerDunEquipe;
                for(Jouer cp : lesJoeurs){%>
                <tr>
                    <td width=15%><%=cp.getId()%></td>
                    <td width=15%><%=cp.getNom() %></td>
                    <td width=15%><%=cp.getPrenom() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
