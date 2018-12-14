<%-- 
    Document   : AfficherHistoriqueEntraineur
    Created on : 30/11/2018, 01:03:12
    Author     : gabrielleite
--%>

<%@page import="Entite.Contrat_Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHistoriqueEntraineur" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Contrat Entraineur</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
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
                <td>Equipe</td>
                <td>Entraineur</td>
                <td>Date debut contrat</td>
                <td>Date fin contrat</td>
                <td>Salaire</td>
                <td>Status</td>
            </tr>
            <% List<Contrat_Entraineur> lesContrat=listeHistoriqueEntraineur;
                for(Contrat_Entraineur cp : lesContrat){%>
                <tr>
                    <td width=15%><%=cp.getId()%></td>
                    <td width=15%><%=cp.getEquipe().getNom_Equipe() %></td>
                    <td width=15%><%=cp.getEntraineur().getNom() %></td>
                    <td width=15%><%=cp.getDate_debut() %></td>
                    <td width=15%><%=cp.getDate_Fin() %></td>
                    <td width=15%><%=cp.getSalaire() %></td>
                    <td width=15%><%=cp.getStatus().toString() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
