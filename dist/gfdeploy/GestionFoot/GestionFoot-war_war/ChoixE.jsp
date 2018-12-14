<%-- 
    Document   : Choix
    Created on : 23/11/2018, 21:44:17
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
                <td width="25%"><a href="AccesEntraineur?action=CreerComposition">Creer Composition</a></td>
                <td width="25%"><a href="AccesEntraineur?action=CreerContratJouer">Creer Contrat Jouer</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/GestionFoot-war/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
