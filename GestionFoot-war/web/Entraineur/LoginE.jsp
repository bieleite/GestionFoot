<%-- 
    Document   : LoginE
    Created on : 29/11/2018, 13:30:25
    Author     : gabrielleite
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Entraineur</title>
    </head>
    <body>
        <h1>Login Entraineur</h1>
        <p >
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <form method="get" action="AccesEntraineur">
            <fieldset>
                <legend>Entraineur</legend>
                <label for="loginEntraineur"> Login<span class="requis">*</span></label>
                <input type="text" name="loginEntraineur" value="" size="20" maxlength="20"/>
                <br/>
                <label for="passEntraineur"> Pass<span class="requis">*</span></label>
                <input type="text" name="passEntraineur" value="" size="20" maxlength="20"/>
                <br/>  
                <input type="hidden" name="action" value="LoginEntraineur">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
        
              <td width=25%><a href="/GestionFoot-war/Menu"> Retour Menu </a></td>
    </body>
</html>
