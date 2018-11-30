<%-- 
    Document   : CreerClassement
    Created on : 24/11/2018, 21:08:49
    Author     : gabrielleite
--%>

<%@page import="Entite.Championnat"%>
<%@page import="Entite.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Classement</title>
        <jsp:useBean id="listeEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeChampionnat" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Classement</h1>
<% List<Equipe> lesEquipe=listeEquipe;%>
<% List<Championnat> lesChampionnat=listeChampionnat;%>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="equipeClassement"> Equipe<span class="requis">*</span></label>
                <select name="equipeClassement">
                    <% for (Equipe e:lesEquipe){%>
                    <option value="<%=e.getId()%>"><%=e.getNom_Equipe() %></option>
                    <%}%>
                </select>
                <br/>
                <label for="championnatClassement"> Championnat<span class="requis">*</span></label>
                <select name="championnatClassement">
                    <% for (Championnat c:lesChampionnat){%>
                    <option value="<%=c.getId()%>"><%=c.getNom_Championnat() %></option>
                    <%}%>
                </select>
                <br/>
                <input type="hidden" name="action" value="insereClassement">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
