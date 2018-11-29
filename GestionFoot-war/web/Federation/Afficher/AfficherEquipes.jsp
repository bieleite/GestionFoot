<%-- 
    Document   : AfficherEquipes
    Created on : 29/11/2018, 21:34:02
    Author     : gabrielleite
--%>

<%@page import="Entite.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <title>Equipes</title>
    </head>
    <body>
        <h1>Afficher Equipes</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Adresse</td>
            </tr>
            <% List<Equipe> lesEquipe=listeEquipe;
                for(Equipe ar : lesEquipe){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getNom_Equipe() %></td>
                    <td width=15%><%=ar.getAdresse_Equipe() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
