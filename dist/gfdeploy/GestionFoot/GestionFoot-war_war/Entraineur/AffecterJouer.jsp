<%-- 
    Document   : AffecterJoeur
    Created on : 28/11/2018, 13:03:37
    Author     : gabrielleite
--%>

<%@page import="Entite.Entraineur"%>
<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Contrat Jouer</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="entr" scope="session" class="Entraineur"></jsp:useBean>
    </head>
<body>
        <h1>Creer Contrat Jouer</h1>

<% List<Jouer> lesJouer=listeJouer;%>
        <form method="get" action="AccesEntraineur">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Entraineur: <span class="requis"><%=entr.getNom() %></span></label>
                <input type="hidden" name="login" value="<%=entr.getLogin() %>" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Equipe: <span class="requis"><%=entr.getEquipe().getNom_Equipe() %></span></label>
                <input type="hidden" name="pass" value="<%=entr.getPass() %>" size="20" maxlength="20"/>
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
                <label for="jouerContrat"> Jouer<span class="requis">*</span></label>
                <select name="jouerContrat">
                    <% for (Jouer e:lesJouer){%>
                    <option value="<%=e.getId()%>"><%=e.getNom() %></option>
                    <%}%>
                </select>
                <br/>
                <input type="hidden" name="action" value="insereContratJouer">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesEntraineur?action=MenuEntraineur"> Retour Menu </a></td>
    </body>
</html>
