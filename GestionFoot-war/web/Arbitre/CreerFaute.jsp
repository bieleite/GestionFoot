<%-- 
    Document   : CreerFaute
    Created on : 24/11/2018, 20:53:07
    Author     : gabrielleite
--%>

<%@page import="Entite.Arbitre"%>
<%@page import="Entite.Matchs"%>
<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Creer Faute</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeMatch" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="arbt" scope="session" class="Arbitre"></jsp:useBean>
    </head>
<body>
        <h1>Creer Faute</h1>
<% List<Jouer> lesJouer=listeJouer;%>
<% List<Matchs> lesMatch=listeMatch;%>
        <form method="get" action="AccesArbitre">
            <fieldset>
                <legend>Informations Faute</legend>
                <label for="login"> Arbitre <span class="requis"><%=arbt.getNom() %></span></label>
                <input type="hidden" name="login" value="<%=arbt.getLogin() %>" size="20" maxlength="20"/>
                <br/>
                <label for="pass"><span class="requis"></span></label>
                <input type="hidden" name="pass" value="<%=arbt.getPass() %>" size="20" maxlength="20"/>
                <br/>
                <label for="matchFaute"> Match <span class="requis">*</span></label>
                <select name="matchFaute">
                    <% for (Matchs m:lesMatch){%>
                    
                    <option value="<%=m.getId()%>"><%=m.getInfo() %></option>
                    <%}%>
                </select>
                <br/>
                <label for="jouerFaute"> Jouer<span class="requis">*</span></label>
                <select name="jouerFaute">
                    <% for (Jouer j:lesJouer){%>
                    <option value="<%=j.getId()%>"><%=j.getNom() %></option>
                    <%}%>
                </select>
                <tr><td> Carton</td><td>
                    <select size="1" name="cartonFaute">
                       <option value="Rouge"> Rouge</option>
                       <option value="Jaune">Jaune </option>
                       <option value="Non">Non </option>
                   </select>
                </td></tr>
                <br/>
                <input type="hidden" name="action" value="insereFautes">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesAbitre?action=MenuArbitre"> Retour Menu </a></td>
    </body>
</html>
