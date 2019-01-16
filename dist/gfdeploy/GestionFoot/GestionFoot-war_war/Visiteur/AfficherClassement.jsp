<%-- 
    Document   : AfficherClassement
    Created on : 29/11/2018, 21:33:09
    Author     : gabrielleite
--%>

<%@page import="Entite.Classement"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeClassement" scope="request" class="java.util.List"></jsp:useBean>
        <title>Classement</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Afficher Classement</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Championnat</td>
                <td>Equipe</td>
                <td>Point</td>
            </tr>
            <% List<Classement> lesClassement=listeClassement;
                for(Classement cl : lesClassement){%>
                <tr>
                    <td width=15%><%=cl.getId()%></td>
                    <td width=15%><%=cl.getLeChampionnat().getNom_Championnat() %></td>
                    <td width=15%><%=cl.getLeEquipe().getNom_Equipe() %></td>
                    <td width=15%><%=cl.getPoint() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
