<%-- 
    Document   : ChoixA
    Created on : 23/11/2018, 21:45:41
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
                <td width="25%"> <a href="CreerFounisseur.jsp">Creer Fournisseur</a></td>
                <!--<td width="25%"><a href="CreerA.jsp">Creer Article</a></td>-->
                <td width="25%"><a href="AccesArticle?action=creerAF">Creer Article</a></td>
                <td width="25%"><a href="AccesArticle?action=creerAFr">Creer Fraicheur</a></td>
                <td width="25%"><a href="AccesArticle?action=creerAFv">Creer Vetement</a></td>
                <td width="25%"><a href="AccesArticle?action=afficheF">Afficher Fournisseur</a></td>
                <td width="25%"><a href="AccesArticle?action=rechercherAPF">Afficher Article</a></td>
                <td width="25%"><a href="AccesArticle?action=rechercherAPFP">Afficher Prix Article</a></td>
            </tr>
        </table>
    </body>
</html>
