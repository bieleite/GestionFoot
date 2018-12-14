<%-- 
    Document   : CreerArbitres
    Created on : 23/11/2018, 23:51:56
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Creer Arbitre</title>

    </head>
    <body>
        <h1>Creer Arbitre</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Informations Arbitre</legend>
                <label for="nomArbitre"> Nom<span class="requis">*</span></label>
                <input type="text" name="nomArbitre" value="" size="20" maxlength="20"/>
                <br/>
                <label for="prenomArbitre"> Prenom<span class="requis">*</span></label>
                <input type="text" name="prenomArbitre" value="" size="80" maxlength="80"/>
                <br/>
                <label for="loginArbitre"> Login Arbitre<span class="requis">*</span></label>
                <input type="text" name="loginArbitre" value="" size="20" maxlength="20"/>
                <br/>   
                <label for="passArbitre"> Password Arbitre<span class="requis">*</span></label>
                <input type="text" name="passArbitre" value="" size="20" maxlength="20"/>
                <br/>   
                <input type="hidden" name="action" value="insereArbitre">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesFederation?action=MenuFederation"> Retour Menu </a></td>
    </body>
</html>
