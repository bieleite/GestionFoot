<%-- 
    Document   : AfficherListJouer
    Created on : 29/11/2018, 23:46:18
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Jouer> lesJouers=listeJouer;%>
<form method="get" action="AccesFederation">
    <fieldset>
 
                <select name="jouerFaute">
                    <% for (Jouer m:lesJouers){%>
                    <option value="<%=m.getId()%>"><%=m.getNom() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="afficherFautesParJouer">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
