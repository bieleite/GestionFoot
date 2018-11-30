<%-- 
    Document   : CreerContratEntraineur
    Created on : 24/11/2018, 14:06:30
    Author     : gabrielleite
--%>


<%@page import="Entite.Entraineur"%>
<%@page import="Entite.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Contrat Entraineur</title>
        <jsp:useBean id="listeEquipe" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeEntraineur" scope="request" class="java.util.List"></jsp:useBean>
    </head>
<body>
        <h1>Creer Contrat Entraineur</h1>
<% List<Equipe> lesEquipe=listeEquipe;%>
<% List<Entraineur> lesEntraineur=listeEntraineur;%>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="equipeContrat"> Equipe<span class="requis">*</span></label>
                <select name="equipeContrat">
                    <% for (Equipe e:lesEquipe){%>
                    <option value="<%=e.getId()%>"><%=e.getNom_Equipe() %></option>
                    <%}%>
                </select>
                <br/>
                <label for="salaireContrat"> Salaire<span class="requis">*</span></label>
                <input type="text" name="salaireContrat" value="" size="20" maxlength="20"/>
                <br/>
                <label for="datedebContrat"> Date debut<span class="requis">*</span></label>
                <input type="date" name="datedebContrat" value="" size="20" maxlength="20"/>
                <br/>
                <label for="datefinContrat"> Date fin <span class="requis">*</span></label>
                <input type="date" name="datefinContrat" value="" size="80" maxlength="80"/>
                <br/>
                <label for="entraineurContrat"> Entraineur<span class="requis">*</span></label>
                <select name="entraineurContrat">
                    <% for (Entraineur e:lesEntraineur){%>
                    <option value="<%=e.getId()%>"><%=e.getNom() %></option>
                    <%}%>
                </select>
                <br/>
                <tr><td> Statut Contrat</td><td>
                    <select size="1" name="statutContrat">
                       <option value="Ac"> Actif</option>
                       <option value="In">Inactif </option>
                   </select>
                </td></tr>
                <br/>
                <input type="hidden" name="action" value="insereContratEntraineur">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
