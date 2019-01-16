<%-- 
    Document   : AfficherListArbitre
    Created on : 29/11/2018, 23:47:33
    Author     : gabrielleite
--%>

<%@page import="Entite.Arbitre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
        <jsp:useBean id="listeArbitre" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Arbitre> lesArbitre=listeArbitre;%>
<form method="get" action="AccesFederation">
    <fieldset>
 
                <select name="arbitreFaute">
                    <% for (Arbitre m:lesArbitre){%>
                    <option value="<%=m.getId()%>"><%=m.getNom() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="afficherFautesParArbitre">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
