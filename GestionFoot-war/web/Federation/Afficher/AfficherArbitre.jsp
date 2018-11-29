<%-- 
    Document   : AfficherArbitre
    Created on : 29/11/2018, 21:12:05
    Author     : gabrielleite
--%>


<%@page import="Entite.Arbitre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeArbitre" scope="request" class="java.util.List"></jsp:useBean>
        <title>Arbitres</title>
    </head>
    <body>
        <h1>Afficher Arbitre</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Prenom</td>
                <td>Login</td>
            </tr>
            <% List<Arbitre> lesArbitres=listeArbitre;
                for(Arbitre ar : lesArbitres){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getNom() %></td>
                    <td width=15%><%=ar.getPrenom() %></td>
                    <td width=15%><%=ar.getLogin() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
