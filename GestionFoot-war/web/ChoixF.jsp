<%-- 
    Document   : ChoixF
    Created on : 23/11/2018, 21:45:35
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Menu</h1>
        <p>
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <table>
            <tr>
                <td width="25%"> <a href="AccesFederation?action=CreerEquipes">Creer Equipes</a></td>
                <td width="25%"> <a href="CreerArbitres.jsp">Creer Arbitres</a></td><br/>
                <td width="25%"> <a href="CreerEntraineurs.jsp">Creer Entraineurs</a></td><br/>
                <td width="25%"> <a href="CreerJouers.jsp">Creer Joeurs</a></td><br/>
                <td width="25%"> <a href="CreerStade.jsp">Creer Stade</a></td><br/>
                <td width="25%"><a href="AccesArticle?action=afficherFautesMatch">Afficher Fautes par Match</a></td><br/>
                <td width="25%"><a href="AccesArticle?action=rechercherJouer">Afficher Jouer</a></td><br/>
                <td width="25%"><a href="AccesArticle?action=rechercherEntraineur">Afficher Entraineur</a></td><br/>
                <td width="25%"><a href="AccesArticle?action=rechercherJouer">Afficher Jouer</a></td><br/>
            </tr>
        </table>
    </body>
</html>
