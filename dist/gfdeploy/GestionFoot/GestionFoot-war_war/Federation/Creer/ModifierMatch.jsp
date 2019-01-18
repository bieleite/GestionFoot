<%-- 
    Document   : CreerMatch
    Created on : 24/11/2018, 00:37:13
    Author     : gabrielleite
--%>
<%@page import="Entite.Matchs"%>
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
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Modifier Match</title>
        <jsp:useBean id="mat" scope="session" class="Matchs"></jsp:useBean>
    </head>
<body>
        <h1>Modifier Match</h1>
        <table border width=50%>
                <tr> 
                    <td>Equipe Home</td>
                    <td>Equipe Away</td>
                    <td>Date</td>
                    <td>Heure</td>
                    <td>Arbitre</td>
                    <td>Stade</td>
                </tr>
                <tr>
                    <td width=15%><%=mat.getEquipe_Home().getNom_Equipe() %></td>
                    <td width=15%><%=mat.getEquipe_Away().getNom_Equipe() %></td>
                    <td width=15%><%=mat.getDate().toString() %></td>    
                    <td width=15%><%=mat.getHeure() %></td>
                    <td width=15%><%=mat.getArbitre().getNom() %></td>
                    <td width=15%><%=mat.getStade().getNom_Stade() %></td>
                </tr>    
        </table>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Match</legend>
                <input type="hidden" name="Matchs" value="<%=mat.getId() %>" size="20" maxlength="20"/>
                <br/>
                <label for="dateMatch"> Date<span class="requis">*</span></label>
                <input type="date" name="dateMatch" value="" size="20" maxlength="20"/>
                <br/>
                <tr><td> Heure Match</td><td>
                    <select size="1" name="heureMatch">
                       <option value="1">01:00</option>
                       <option value="2">02:00 </option>
                       <option value="3">03:00 </option>
                       <option value="4">04:00 </option>
                       <option value="5">05:00 </option>
                       <option value="6">06:00 </option>
                       <option value="7">07:00 </option>
                       <option value="8">08:00 </option>
                       <option value="9">09:00 </option>
                       <option value="10">10:00 </option>
                       <option value="11">11:00 </option>
                       <option value="12">12:00 </option>
                   </select>
                </td></tr>
                <br/>
                <input type="hidden" name="action" value="modMatchs">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
