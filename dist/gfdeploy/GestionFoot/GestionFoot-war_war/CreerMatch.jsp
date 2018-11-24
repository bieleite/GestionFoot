<%-- 
    Document   : CreerMatch
    Created on : 24/11/2018, 00:37:13
    Author     : gabrielleite
--%>
<%@page import="Entite.Championnat"%>
<%@page import="Entite.Arbitre"%>
<%@page import="Entite.Equipe"%>
<%@page import="Entite.Stade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Article</title>
        <jsp:useBean id="listeStade" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeArbitre" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeChampionnat" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Article</h1>
<% List<Stade> lesStades=listeStade;%>
<% List<Equipe> lesEquipes=listeEquipe;%>
<% List<Arbitre> lesArbitres=listeArbitre;%>
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
                <label for="dateMatch"> Date<span class="requis">*</span></label>
                <input type="date" name="dateMatch" value="" size="20" maxlength="20"/>
                <br/>
                <label for="stadeMatch"> Stade<span class="requis">*</span></label>
                <select name="stadeMatch">
                    <% for (Stade s:lesStades){%>
                    <option value="<%=s.getId()%>"><%=s.getNom_Stade() %></option>
                    <%}%>
                </select>
                <label for="equipeHMatch"> Equipe Home<span class="requis">*</span></label>
                <select name="equipeHMatch">
                    <% for (Equipe e:lesEquipes){%>
                    <option value="<%=e.getId()%>"><%=e.getNom_Equipe() %></option>
                    <%}%>
                </select>
                <label for="equipeAMatch"> Equipe Away<span class="requis">*</span></label>
                <select name="equipeAMatch">
                    <% for (Equipe e:lesEquipes){%>
                    <option value="<%=e.getId()%>"><%=e.getNom_Equipe() %></option>
                    <%}%>
                </select>
                <label for="arbitreMatch"> Arbitre<span class="requis">*</span></label>
                <select name="arbitreMatch">
                    <% for (Arbitre a:lesArbitres){%>
                    <option value="<%=a.getId()%>"><%=a.getNom() %></option>
                    <%}%>
                </select>
                <label for="championnatMatch"> Championnat<span class="requis">*</span></label>
                <select name="championnatMatch">
                    <% for (Championnat c:lesChampionnat){%>
                    <option value="<%=c.getId()%>"><%=c.getNom_Championnat() %></option>
                    <%}%>
                </select>
                <input type="hidden" name="action" value="insereMatch">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=vide"> Retour Menu </a></td>
    </body>
</html>
