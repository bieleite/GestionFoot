<%-- 
    Document   : AfficherFautesParMatch
    Created on : 24/11/2018, 13:56:47
    Author     : gabrielleite
--%>



<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listefournisseur" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Fautes</title>
    </head>
    <body>
        <h1>Afficher Fautes</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Designation</td>
                <td>Prix</td>
                <td>Fournisseur</td>
            </tr>
            <% List<Article> lesFour=listefournisseur;
                for(Article cp : lesFour){%>
                <tr>
                    <td width=15%><%=cp.getId()%></td>
                    <td width=15%><%=cp.getDesignation()%></td>
                    <td width=15%><%=cp.getPrix()%></td>
                    <td width=15%><%=cp.getFourni().getNom()%></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesArticle?action=vide"> Retour Menu </a></td>
    <hr>
</body>
</html>
