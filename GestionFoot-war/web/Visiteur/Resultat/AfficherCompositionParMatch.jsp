<%-- 
    Document   : AfficherCompositionParMatch
    Created on : 30/11/2018, 01:01:18
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="Entite.Composition"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeCompositionParMatch" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Composition</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Afficher Composition</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 

                <td>Equipe</td>

                <td>Jouers</td>
            </tr>
            <% List<Composition> lesComposition=listeCompositionParMatch;
                for(Composition cp : lesComposition){%>
                <tr>
                    <td width=15%><%=cp.getEquipe().getNom_Equipe() %></td>
                    <% List<Jouer> lesJouers=cp.getJouers(); 
                    for (Jouer j : lesJouers){%>
                    <td width=15%><%=j.getNom()+"/"+j.getPrenom() %></td>
                </tr><%}}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
