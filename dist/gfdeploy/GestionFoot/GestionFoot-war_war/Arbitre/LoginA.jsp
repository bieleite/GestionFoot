<%-- 
    Document   : LoginA
    Created on : 29/11/2018, 14:44:54
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Arbitre</title>
    </head>
    <body>
        <h1>Login Arbitrer</h1>
        <p >
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <form method="get" action="AccesArbitre">
            <fieldset>
                <legend>Arbitre</legend>
                <label for="loginArbitre"> Login<span class="requis">*</span></label>
                <input type="text" name="loginArbitre" value="" size="20" maxlength="20"/>
                <br/>
                <label for="passArbitre"> Pass<span class="requis">*</span></label>
                <input type="text" name="passArbitre" value="" size="20" maxlength="20"/>
                <br/>  
                <input type="hidden" name="action" value="LoginArbitre">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
        
              <td width=25%><a href="/GestionFoot-war/Menu"> Retour Menu </a></td>
    </body>
</html>
