<%-- 
    Document   : CreerOutOfGame
    Created on : 28/11/2018, 13:36:27
    Author     : gabrielleite
--%>

<%@page import="Entite.Fautes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Creer Faute</title>
        <jsp:useBean id="listeFautes" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Faute</h1>
<% List<Fautes> lesFautes=listeFautes;%>

        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Faute</legend>
                <label for="Faute"> Match <span class="requis">*</span></label>
                <select name="Faute">
                    <% for (Fautes f:lesFautes){%>
                    
                    <option value="<%=f.getId()%>"><%=f.getJoeur().getNom() %> / <%=f.getMatch().getDate() %> / <%=f.getMatch().getEquipe_Home().getNom_Equipe() %> vs <%=f.getMatch().getEquipe_Away().getNom_Equipe() %></option>
                    <%}%>
                </select>
                <br/>
                <label for="puni"> Punition<span class="requis">*</span></label>
                <input type="text" name="puni" value="" size="20" maxlength="20"/>
                <br/>
                <input type="hidden" name="action" value="insereFautes">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
