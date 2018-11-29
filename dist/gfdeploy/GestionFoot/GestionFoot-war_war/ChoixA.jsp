<%-- 
    Document   : ChoixA
    Created on : 23/11/2018, 21:45:41
    Author     : gabrielleite
--%>

<%@page import="Entite.Arbitre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Arbitre</title>
    </head>
    <body>
        <h1>Menu Arbitre</h1>
        <p>
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <table>
            <tr>
                <td width="25%"><a href="AccesArbitre?action=CreerButs">Creer Buts</a></td>
                <td width="25%"><a href="AccesArbitre?action=CreerFautes">Creer Fautes</a></td>
                <td width="25%"><a href="AccesArbitre?action=CalcularMatch">Saisir Resultat</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/GestionFoot-war/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
