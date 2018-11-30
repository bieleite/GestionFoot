<%-- 
    Document   : AfficherHistoriqueJouer
    Created on : 30/11/2018, 01:03:01
    Author     : gabrielleite
--%>

<%@page import="Entite.Contrat_Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHistoriqueJouer" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Contrat Jouer</title>
    </head>
    <body>
        <h1>Afficher Contrat Jouer</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Equipe</td>
                <td>Jouer</td>
                <td>Date Debut</td>
                <td>Date Fin</td>
                <td>Salaire</td>
                <td>Status</td>
            </tr>
            <% List<Contrat_Jouer> lesContrats=listeHistoriqueJouer;
                for(Contrat_Jouer cp : lesContrats){%>
                <tr>
                    <td width=15%><%=cp.getId()%></td>
                    <td width=15%><%=cp.getEquipe().getNom_Equipe() %></td>
                    <td width=15%><%=cp.getJoeur().getNom() %></td>
                    <td width=15%><%=cp.getDate_Debut() %></td>
                    <td width=15%><%=cp.getDate_fin() %></td>
                    <td width=15%><%=cp.getSalaire() %></td>
                    <td width=15%><%=cp.getStatus().toString() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
