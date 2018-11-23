<%-- 
    Document   : CreerEquipes
    Created on : 23/11/2018, 21:53:16
    Author     : gabrielleite
--%>

<%@page import="Entite.Stade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Article</title>
        <jsp:useBean id="listeStade" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Stade> lesStades=listeStade;%>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="nomEquipe"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomEquipe" value="" size="20" maxlength="20"/>
                <br/>
                <label for="adresseEquipe"> Adresse <span class="requis">*</span></label>
                <input type="text" name="adresseEquipe" value="" size="80" maxlength="80"/>
                <br/>
                <label for="stadeEquipe"> Stade<span class="requis">*</span></label>
                <select name="stadeEquipe">
                    <% for (Stade s:lesStades){%>
                    <option value="<%=s.getId()%>"><%=s.getNom_Stade() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="insereEquipe">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=vide"> Retour Menu </a></td>
    </body>
</html>
