<%-- 
    Document   : LoginF
    Created on : 29/11/2018, 13:55:54
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Federation</title>
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Login Federation</h1>
        <form method="get" action="AccesFederation">
            <fieldset>
                <legend>Federation</legend>
                <label for="loginFederation"> Login<span class="requis">*</span></label>
                <input type="text" name="loginFederation" value="" size="20" maxlength="20"/>
                <br/>
                <label for="passFederation"> Pass<span class="requis">*</span></label>
                <input type="text" name="passFederation" value="" size="20" maxlength="20"/>
                <br/>  
                <input type="hidden" name="action" value="LoginFederation">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="/GestionFoot-war/Menu"> Retour Menu </a></td>
    </body>
</html>
