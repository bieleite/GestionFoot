<%-- 
    Document   : AfficherListMatch
    Created on : 29/11/2018, 23:20:13
    Author     : gabrielleite
--%>

<%@page import="Entite.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:useBean id="listeEquipe" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Equipe> lesEquipes=listeEquipe;%>
<form method="get" action="AccesVisiteur">
    <fieldset>
 
                <select name="equipeJouer">
                    <% for (Equipe e:lesEquipes){%>
                    <option value="<%=e.getId()%>"><%=e.getNom_Equipe() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="afficherJouerDunEquipe">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesVisiteur?action=vide"> Retour Menu </a></td>
    </body>
</html>
