<%-- 
    Document   : ChoixV
    Created on : 23/11/2018, 21:45:48
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
        <link href="style.css" rel="stylesheet" type="text/css">
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
                <td width="10%"><a href="AccesVisiteur?action=afficherEquipe">Afficher Match Par Equipe</a></td>
                <td width="10%"><a href="AccesVisiteur?action=rechercherClassement">Afficher Classement</a></td>
                <td width="10%"><a href="AccesVisiteur?action=afficherMatch">Afficher Composition Par Match</a></td>
                <td width="10%"><a href="AccesVisiteur?action=afficherEquipePourJouer">Afficher Jouer D'un Equipe</a></td>
                <td width="10%"><a href="AccesVisiteur?action=afficherJouer">Afficher Historique Jouer</a></td>
                <td width="10%"><a href="AccesVisiteur?action=afficherEntraineur">Afficher Historique Entraineur</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/GestionFoot-war/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
