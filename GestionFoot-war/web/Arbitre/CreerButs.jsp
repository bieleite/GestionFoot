<%-- 
    Document   : CreerButs
    Created on : 24/11/2018, 20:52:57
    Author     : gabrielleite
--%>

<%@page import="Entite.Matchs"%>
<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Equipes</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeMatch" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Buts</h1>
<% List<Jouer> lesJouer=listeJouer;%>
<% List<Matchs> lesMatch=listeMatch;%>
        <form method="get" action="AccesArbitre">
            <fieldset>
                <legend>Informations But</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="matchBut"> Match <span class="requis">*</span></label>
                <select name="matchBut">
                    <% for (Matchs m:lesMatch){%>
                    
                    <option value="<%=m.getId()%>"><%=m.getInfo() %></option>
                    <%}%>
                </select>
                <br/>
                <label for="jouerBut"> Jouer<span class="requis">*</span></label>
                <select name="jouerBut">
                    <% for (Jouer j:lesJouer){%>
                    <option value="<%=j.getId()%>"><%=j.getNom() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="insereButs">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesArbitre?action=vide"> Retour Menu </a></td>
    </body>
</html>
