<%-- 
    Document   : AfficherStade
    Created on : 29/11/2018, 21:32:40
    Author     : gabrielleite
--%>

<%@page import="Entite.Stade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeStade" scope="request" class="java.util.List"></jsp:useBean>
        <title>Stade</title>
    </head>
    <body>
        <h1>Afficher Stade</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Adresse</td>
                <td>Capacite</td>
            </tr>
            <% List<Stade> lesStade=listeStade;
                for(Stade ar : lesStade){%>
                <tr>
                    <td width=15%><%=ar.getId()%></td>
                    <td width=15%><%=ar.getNom_Stade() %></td>
                    <td width=15%><%=ar.getAdresse_Stade() %></td>
                    <td width=15%><%=ar.getCapacite() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
