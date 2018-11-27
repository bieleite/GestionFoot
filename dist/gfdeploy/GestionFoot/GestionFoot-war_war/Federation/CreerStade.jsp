<%-- 
    Document   : CreerStade
    Created on : 23/11/2018, 21:57:48
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Stade</title>
    </head>
    <body>
        <h1>Creer Stade</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Stade</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="nomStade"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomStade" value="" size="20" maxlength="20"/>
                <br/>
                <label for="adresseStade"> Adresse<span class="requis">*</span></label>
                <input type="text" name="adresseStade" value="" size="80" maxlength="80"/>
                <br/>
                <label for="capaciteStade"> Capacité<span class="requis">*</span></label>
                <input type="text" name="capaciteStade" value="" size="20" maxlength="20"/>
                <br/>   
                <input type="hidden" name="action" value="insereStade">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=vide"> Retour Menu </a></td>
    </body>
</html>
