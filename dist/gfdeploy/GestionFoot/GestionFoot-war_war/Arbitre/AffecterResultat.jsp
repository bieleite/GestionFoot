<%-- 
    Document   : AffecterResultat
    Created on : 27/11/2018, 14:40:25
    Author     : gabrielleite
--%>

<%@page import="Entite.Matchs"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calcular Resultat</title>
        <jsp:useBean id="listeMatch" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Buts</h1>
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
                <label for="match"> Match <span class="requis">*</span></label>
                <select name="match">
                    <% for (Matchs m:lesMatch){%>
                    
                    <option value="<%=m.getId()%>"><%=m.getInfo() %></option>
                    <%}%>
                </select>
                <br/>
                <input type="hidden" name="action" value="insereResultat">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesArbitre?action=vide"> Retour Menu </a></td>
    </body>
</html>
