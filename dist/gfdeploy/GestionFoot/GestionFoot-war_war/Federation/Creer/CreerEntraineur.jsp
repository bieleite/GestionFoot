<%-- 
    Document   : CreerEntraineur
    Created on : 24/11/2018, 00:01:27
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Entraineur</title>
    </head>
    <body>
        <h1>Creer Entraineur</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Entraineur</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="nomEntraineur"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomEntraineur" value="" size="20" maxlength="20"/>
                <br/>
                <label for="prenomEntraineur"> Prenom<span class="requis">*</span></label>
                <input type="text" name="prenomEntraineur" value="" size="80" maxlength="80"/>
                <br/>
                <label for="loginEntraineur"> Login Entraineur<span class="requis">*</span></label>
                <input type="text" name="loginEntraineur" value="" size="20" maxlength="20"/>
                <br/>   
                <label for="passEntraineur"> Password Entraineur<span class="requis">*</span></label>
                <input type="text" name="passEntraineur" value="" size="20" maxlength="20"/>
                <br/>   
                <input type="hidden" name="action" value="insereEntraineur">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=vide"> Retour Menu </a></td>
    </body>
</html>
