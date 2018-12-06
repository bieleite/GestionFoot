<%-- 
    Document   : CreerJouer
    Created on : 24/11/2018, 00:04:42
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Jouer</title>
    </head>
    <body>
        <h1>Creer Jouer</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Jouer</legend>
                <label for="nomJouer"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomJouer" value="" size="20" maxlength="20"/>
                <br/>
                <label for="prenomJouer"> Prenom<span class="requis">*</span></label>
                <input type="text" name="prenomJouer" value="" size="80" maxlength="80"/>
                <br/>   
                <input type="hidden" name="action" value="insereJouer">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
