<%-- 
    Document   : AfficherJouer
    Created on : 29/11/2018, 21:34:19
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <title>Jouers</title>
    </head>
    <body>
        <h1>Afficher Jouers</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Prenom</td>
                <td>Equipe</td>
            </tr>
            <% List<Jouer> lesJouer=listeJouer;
                for(Jouer ar : lesJouer){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getNom() %></td>
                    <td width=15%><%=ar.getPrenom() %></td>
                    <td width=15%><%=ar.getEquipe().getNom_Equipe() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
