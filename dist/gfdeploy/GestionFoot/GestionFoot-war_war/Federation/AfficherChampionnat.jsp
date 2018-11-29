<%-- 
    Document   : AfficherChampionnat
    Created on : 29/11/2018, 21:32:53
    Author     : gabrielleite
--%>

<%@page import="Entite.Championnat"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeChampionnat" scope="request" class="java.util.List"></jsp:useBean>
        <title>Championnat</title>
    </head>
    <body>
        <h1>Afficher Championnat</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Nom</td>
                <td>Date debut</td>
                <td>Date fin</td>
            </tr>
            <% List<Championnat> lesChampionnat=listeChampionnat;
                for(Championnat ch : lesChampionnat){%>
                <tr>
                    <td width=15%><%=ch.getId()%></td>
                    <td width=15%><%=ch.getNom_Championnat() %></td>
                    <td width=15%><%=ch.getDt_debut_champio() %></td>
                    <td width=15%><%=ch.getDt_Fin_Champio() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
