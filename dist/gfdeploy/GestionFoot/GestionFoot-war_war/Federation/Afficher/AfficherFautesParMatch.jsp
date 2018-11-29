<%-- 
    Document   : AfficherFautesParMatch
    Created on : 24/11/2018, 13:56:47
    Author     : gabrielleite
--%>



<%@page import="Entite.Fautes"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeFautesParMatch" scope="request" class="java.util.List"></jsp:useBean>
        <title>Afficher Fautes</title>
    </head>
    <body>
        <h1>Afficher Fautes</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Match</td>
                <td>Jouer</td>
                <td>Carton</td>
                <td>Arbitre</td>
            </tr>
            <% List<Fautes> lesFautes=listeFautesParMatch;
                for(Fautes cp : lesFautes){%>
                <tr>
                    <td width=15%><%=cp.getId()%></td>
                    <td width=15%><%=cp.getMatch().getInfo() %></td>
                    <td width=15%><%=cp.getJoeur().getNom() %></td>
                    <td width=15%><%=cp.getCarton().toString() %></td>
                    <td width=15%><%=cp.getArbitre().getNom() %></td>
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="AccesArticle?action=MenuFederation"> Retour Menu </a></td>
    <hr>
</body>
</html>
