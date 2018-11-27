<%-- 
    Document   : CreerButs
    Created on : 24/11/2018, 20:52:57
    Author     : gabrielleite
--%>

<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Equipes</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Equipes</h1>
<% List<Jouer> lesJouer=listeJouer;%>
        <form method="get" action="AccesArbitre">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="dtBut"> Date <span class="requis">*</span></label>
                <input type="date" name="dtBut" value="" size="80" maxlength="80"/>
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
