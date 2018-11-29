<%-- 
    Document   : AfficherContratEntraineur
    Created on : 29/11/2018, 21:33:23
    Author     : gabrielleite
--%>

<%@page import="Entite.Contrat_Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeContrat" scope="request" class="java.util.List"></jsp:useBean>
        <title>Contrat Entraineur</title>
    </head>
    <body>
        <h1>Afficher Contrat Entraineur</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Entraineur</td>
                <td>Equipe</td>
                <td>Date debut</td>
                <td>Date Fin</td>
                <td>Salaire</td>
                <td>Status</td>
            </tr>
            <% List<Contrat_Entraineur> lesContrat=listeContrat;
                for(Contrat_Entraineur cl : lesContrat){%>
                <tr>
                    <td width=15%><%=cl.getId()%></td>
                    <td width=15%><%=cl.getEntraineur().getNom() %></td>
                    <td width=15%><%=cl.getEquipe().getNom_Equipe() %></td>
                    <td width=15%><%=cl.getDate_debut() %></td>
                    <td width=15%><%=cl.getDate_Fin() %></td>
                    <td width=15%><%=cl.getSalaire() %></td>
                    <td width=15%><%=cl.getStatus().toString() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>