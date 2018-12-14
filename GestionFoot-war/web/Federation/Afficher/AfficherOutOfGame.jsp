<%-- 
    Document   : AfficherOutOfGame
    Created on : 29/11/2018, 21:34:50
    Author     : gabrielleite
--%>

<%@page import="Entite.OutOfGame"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="listeOutOfGame" scope="request" class="java.util.List"></jsp:useBean>
        <title>Punitions</title>
    </head>
    <body>
        <h1>Afficher Punitions</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Jouer</td>
                <td>Date Debut</td>
                <td>Date Fin</td>
            </tr>
            <% List<OutOfGame> lesOutOfGame=listeOutOfGame;
                for(OutOfGame ar : lesOutOfGame){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getLeJouer().getNom() %> / <%=ar.getLeJouer().getPrenom() %></td>
                    <td width=15%><%=ar.getDt_DebutOut() %></td>
                    <td width=15%><%=ar.getDt_FinOut() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
