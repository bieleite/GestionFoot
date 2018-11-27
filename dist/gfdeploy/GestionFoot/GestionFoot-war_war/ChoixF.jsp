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
        <title>Menu Federation</title>
    </head>
    <body>
        <h1>Menu Federation</h1>
        <p>
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <h2>Creer</h2>
        <table>
            <tr>
                <td width="10%"> <a href="AccesFederation?action=CreerEquipes">Creer Equipes</a></td>
                <td width="10%"> <a href="/Federation/CreerArbitres.jsp">Creer Arbitres</a></td>
                <td width="10%"> <a href="/Federation/CreerEntraineur.jsp">Creer Entraineurs</a></td>
                <td width="10%"> <a href="/Federation/CreerJouer.jsp">Creer Joeurs</a></td>
                <td width="10%"> <a href="/Federation/CreerStade.jsp">Creer Stade</a></td>
                <td width="10%"> <a href="/Federation/CreerChampionnat.jsp">Creer Championnat</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerClassement">Affecter une equipe a une championnat</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerMatchs">Creer Matchs</a></td>
            </tr>
        </table>
        <h2>Contrat</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerContratEntraineur">Affecter Entraineur</a></td>
                <td width="50%"> <a href="AccesFederation?action=CreerContratJouer">Affecter Jouer</a></td>
            </tr>
        </table>
        <h2>Afficher</h2>
        <table>
            <tr>
                <td width="25%"><a href="AccesArticle?action=afficherFautesMatch">Afficher Fautes par Match</a></td>
                <td width="25%"><a href="AccesArticle?action=rechercherJouer">Afficher Jouer</a></td>
                <td width="25%"><a href="AccesArticle?action=rechercherEntraineur">Afficher Entraineur</a></td>
                <td width="25%"><a href="AccesArticle?action=rechercherArbitre">Afficher Arbitre</a></td>
            </tr>
        </table>
        <h2>Out of game</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerOutOfGame">Creer Out of game</a></td>
                <td width="50%"> <a href="AccesFederation?action=afficherOutOfGame">Afficher Out of Game</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/GestionFoot-war/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
