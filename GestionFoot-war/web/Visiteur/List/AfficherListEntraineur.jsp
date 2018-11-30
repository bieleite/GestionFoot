<%-- 
    Document   : AfficherListEntraineur
    Created on : 30/11/2018, 01:00:44
    Author     : gabrielleite
--%>

<%@page import="Entite.Entraineur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="listeEntraineur" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Entraineur> lesEntraineur=listeEntraineur;%>
<form method="get" action="AccesVisiteur">
    <fieldset>
 
                <select name="entraineurContrat">
                    <% for (Entraineur m:lesEntraineur){%>
                    <option value="<%=m.getId()%>"><%=m.getNom() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="afficherHistoriqueEntraineur">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    </body>
</html>
