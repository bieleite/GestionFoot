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
                <td width="10%"> <a href="AccesFederation?action=CreerArbitre">Creer Arbitres</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerEntraineur">Creer Entraineurs</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerJouer">Creer Joeurs</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerStade">Creer Stade</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerChampionnat">Creer Championnat</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerClassement">Affecter une equipe a une championnat</a></td>
                <td width="10%"> <a href="AccesFederation?action=CreerMatchs">Creer Matchs</a></td>
            </tr>
        </table>
        <h2>Equipe</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerEquipes">Creer Equipes</a></td>
                <td width="50%"><a href="AccesFederation?action=rechercherEquipes">Afficher Equipes</a></td>
            </tr>
        </table>
        <h2>Entraineur</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerEntraineur">Creer Entraineurs</a></td>
                <td width="50%"><a href="AccesFederation?action=rechercherEntrainuer">Afficher Entraineur</a></td>
            </tr>
        </table>
        <h2>Jouer</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerJouer">Creer Joeurs</a></td>
                <td width="50%"><a href="AccesFederation?action=rechercherJouer">Afficher Jouer</a></td>
            </tr>
        </table>
        <h2>Championnat</h2>
        <table>
            <tr>
                <td width="25%"> <a href="AccesFederation?action=CreerChampionnat">Creer Championnat</a></td>
                <td width="25%"> <a href="AccesFederation?action=CreerClassement">Affecter une equipe a une championnat</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherChampionnat">Afficher Championnat</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherClassement">Afficher Classement</a></td>
            </tr>
        </table>
        <h2>Matchs</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerMatchs">Creer Matchs</a></td>
                <td width="50%"><a href="AccesFederation?action=rechercherMatch">Afficher Match</a></td>
                <td width="50%"><a href="AccesFederation?action=afficherMatch">Afficher Fautes Par Match</a></td>
            </tr>
        </table>
        <h2>Out of game</h2>
        <table>
            <tr>
                <td width="50%"> <a href="AccesFederation?action=CreerOutOfGame">Creer Out of game</a></td>
                <td width="50%"><a href="AccesFederation?action=rechercherOutOfGame">Afficher Out of Game</a></td>
            </tr>
        </table>
        <h2>Contrat</h2>
        <table>
            <tr>
                <td width="25%"> <a href="AccesFederation?action=CreerContratEntraineur">Affecter Entraineur</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherContratEntraineur">Afficher Contrat Entraineur</a></td>
                <td width="25%"> <a href="AccesFederation?action=CreerContratJouer">Affecter Jouer</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherContratJouer">Afficher Contrat jouer</a></td>
            </tr>
        </table>
        <h2>Afficher</h2>
        <table>
            <tr>
                <td width="25%"><a href="AccesFederation?action=afficherFautesMatch">Afficher Fautes par Match</a></td>
                
                
                <td width="25%"><a href="AccesFederation?action=rechercherArbitre">Afficher Arbitre</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherChampionnat">Afficher Championnat</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherClassement">Afficher Classement</a></td>
                
                <td width="25%"><a href="AccesFederation?action=rechercherMatch">Afficher Match</a></td>
                <td width="25%"><a href="AccesFederation?action=rechercherStade">Afficher Stade</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/GestionFoot-war/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
