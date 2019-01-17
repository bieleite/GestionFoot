<%-- 
    Document   : AfficherMatch
    Created on : 29/11/2018, 21:34:36
    Author     : gabrielleite
--%>

<%@page import="Entite.Matchs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="listeMatch" scope="request" class="java.util.List"></jsp:useBean>
        <title>Match</title>
    </head>
    <body>
        <h1>Afficher Match</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Championnat</td>
                <td>Date</td>
                <td>Heure</td>
                <td>Stade</td>
                <td>Equipe Home</td>
                <td>Score</td>
                <td>Equipe Away</td>
                <td>Score</td>
                <td>Arbitre</td>
            </tr>
            <% List<Matchs> lesMatch=listeMatch;
                for(Matchs ar : lesMatch){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getLeChampionnat().getNom_Championnat() %></td> 
                    <td width=15%><%=ar.getDate() %></td>
                    <td width=15%><%=ar.getHeure() %></td>
                    <td width=15%><%=ar.getStade().getNom_Stade() %></td>
                    <td width=15%><%=ar.getEquipe_Home().getNom_Equipe() %></td>
                    <td width=15%><%=ar.getScore_Home() %></td>
                    <td width=15%><%=ar.getEquipe_Away().getNom_Equipe() %></td>
                    <td width=15%><%=ar.getScore_Away() %></td>
                    <td width=15%><%=ar.getArbitre().getNom() %></td>     
                    
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
