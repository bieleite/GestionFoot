<%-- 
    Document   : CreerButs
    Created on : 24/11/2018, 20:52:57
    Author     : gabrielleite
--%>

<%@page import="Entite.Composition"%>
<%@page import="Entite.Arbitre"%>
<%@page import="Entite.Matchs"%>
<%@page import="Entite.Jouer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/style.css" rel="stylesheet" type="text/css">
        <title>Creer Buts</title>
        <jsp:useBean id="listeCompositionParMatch" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="arbt" scope="session" class="Arbitre"></jsp:useBean>
        <jsp:useBean id="mat" scope="session" class="Matchs"></jsp:useBean>
    </head>
<body>
        <h1>Creer Buts</h1>



               
        <form method="get" action="AccesArbitre">
            <fieldset>
                <legend>Informations But</legend>
                <label for="login"> Arbitre <span class="requis"><%=arbt.getNom() %></span></label>
                <input type="hidden" name="login" value="<%=arbt.getLogin() %>" size="20" maxlength="20"/>
                <br/>
                <label for="pass"><span class="requis"></span></label>
                <input type="hidden" name="pass" value="<%=arbt.getPass() %>" size="20" maxlength="20"/>
                <br/>
                <label for="matchBut"> Match <span class="requis"><%=mat.getInfo() %></span></label>
                <input type="hidden" name="matchBut" value="<%=mat.getId() %>" size="20" maxlength="20"/>
                <br/>
                 <% List<Composition> lesComposition=listeCompositionParMatch;
                for(Composition cp : lesComposition){%>
                <% List<Jouer> lesJouers=cp.getJouers();  
                    for (Jouer j : lesJouers){%> 
                <label for="jouerBut"> Jouer <span class="requis"></span></label>
                
                <table border width=50%>
                        <tr> 
                            
                            <td>Equipe</td>
                            <td>Nom</td>
                            <td>Prenom</td>
                            <td>Select</td>
                        </tr>
                           
                            <tr>
                                <td width=15%><%=cp.getEquipe().getNom_Equipe() %></td>
                                <td width=15%><%=j.getNom()%></td>
                                <td width=15%><%=j.getPrenom() %></td>
                                <td width=15%><input type="checkbox" name="jouerBut" value="<%=j.getId()%>"></td>
                                
                                
                            </tr><%}}%>     
                    </table>
                
                <br/>
                <input type="hidden" name="action" value="insereButs">
                    
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="AccesAbitre?action=MenuArbitre"> Retour Menu </a></td>
    </body>
</html>
