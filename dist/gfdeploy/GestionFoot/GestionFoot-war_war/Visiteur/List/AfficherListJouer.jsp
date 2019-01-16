<%-- 
    Document   : AfficherListJouer
    Created on : 30/11/2018, 01:00:21
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Jouer</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
<body>
        <h1>List Jouer</h1>
<% List<Jouer> lesJouer=listeJouer;%>
<form method="get" action="AccesVisiteur">
    <fieldset>
 
                <select name="jouerContrat">
                    <% for (Jouer j:lesJouer){%>
                    <option value="<%=j.getId()%>"><%=j.getNom() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="afficherHistoriqueJouer">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    </body>
</html>
