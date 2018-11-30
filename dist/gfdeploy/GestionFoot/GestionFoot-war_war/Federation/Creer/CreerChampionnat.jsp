<%-- 
    Document   : CreerChampionnat
    Created on : 24/11/2018, 01:00:37
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creer Championnat</title>
    </head>
    <body>
        <h1>Creer Championnat</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Championnat</legend>
                <label for="login"> Login<span class="requis">*</span></label>
                <input type="text" name="login" value="" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Pass<span class="requis">*</span></label>
                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                <br/>
                <label for="nomChampionnat"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomChampionnat" value="" size="20" maxlength="20"/>
                <br/>
                <label for="dtdebChampionnat"> Date debut<span class="requis">*</span></label>
                <input type="date" name="dtdebChampionnat" value="" size="80" maxlength="80"/>
                <br/> 
                <label for="dtfinChampionnat"> Date Fin<span class="requis">*</span></label>
                <input type="date" name="dtfinChampionnat" value="" size="80" maxlength="80"/>
                <br/>
                <input type="hidden" name="action" value="insereChampionnat">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
