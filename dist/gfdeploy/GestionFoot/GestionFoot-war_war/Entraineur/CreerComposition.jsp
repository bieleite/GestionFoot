<%-- 
    Document   : CreerComposition
    Created on : 27/11/2018, 21:16:08
    Author     : gabrielleite
--%>

<%@page import="Entite.Entraineur"%>
<%@page import="Entite.Jouer"%>
<%@page import="Entite.Matchs"%>
<%@page import="Entite.Equipe"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Creer Classement</title>
        <jsp:useBean id="listeJouer" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeMatch" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="entr" scope="session" class="Entraineur"></jsp:useBean>
    </head>
<body>
        <h1>Creer Classement</h1>
<% List<Jouer> lesJouers=listeJouer;%>
<% List<Matchs> lesMatch=listeMatch;%>
        <form method="get" action="AccesEntraineur">
            <fieldset>
                <legend>Informations Equipe</legend>
                <label for="login"> Entraineur: <span class="requis"><%=entr.getNom() %></span></label>
                <input type="hidden" name="login" value="<%=entr.getLogin() %>" size="20" maxlength="20"/>
                <br/>
                <label for="pass"> Equipe: <span class="requis"><%=entr.getEquipe().getNom_Equipe() %></span></label>
                <input type="hidden" name="pass" value="<%=entr.getPass() %>" size="20" maxlength="20"/>
                <br/>
                <label for="jouerComposition"> Composition: <span class="requis">*</span></label>
                
                    <table border width=50%>
                        <tr> 
                            <td>Numero</td>
                            <td>Nom</td>
                            <td>Prenom</td>
                            <td>Selecionado</td>
                        </tr>
                            <% for (Jouer j:lesJouers){%>
                            <tr>
                                <td width=15%><%=j.getId()%></td>
                                <td width=15%><%=j.getNom()%></td>
                                <td width=15%><%=j.getPrenom() %></td>
                                <td width=15%><input type="checkbox" name="jouerComposition" value="<%=j.getId()%>"></td>
                            </tr><%}%>     
                    </table>

                
                <br/>
                <label for="matchComposition"> Match <span class="requis">*</span></label>
                <select name="matchComposition">
                    <% for (Matchs m:lesMatch){%>
                    <option value="<%=m.getId()%>"><%=m.getInfo() %></option>
                    <%}%>
                </select>
                <br/>
                <input type="hidden" name="action" value="insereComposition">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesEntraineur?action=MenuEntraineur"> Retour Menu </a></td>
    </body>
</html>
