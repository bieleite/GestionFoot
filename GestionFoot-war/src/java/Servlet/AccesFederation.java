/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Classement;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Matchs;
import Entite.OutOfGame;
import Entite.Stade;
import Entite.Statut;
import Session.sessionFederationLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabrielleite
 */
@WebServlet(name = "AccesFederation", urlPatterns = {"/AccesFederation"})
public class AccesFederation extends HttpServlet {



    @EJB
    private sessionFederationLocal sessionFederation;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String jspClient=null;
            String act=request.getParameter("action");
            if((act==null)||(act.equals("vide")))
            {
                jspClient="/Federation/LoginF.jsp";
            }
            else if(act.equals("LoginFederation")){
                String login = request.getParameter("loginFederation");
                String pass = request.getParameter("passFederation");
                if((login.contains("admin"))||(pass.contains("admin"))){
                request.setAttribute("message","Bienvenue ! ");
                jspClient="/ChoixF.jsp";   }
                else{
                     jspClient="/LoginF.jsp";
                }
            }
            else if(act.equals("MenuFederation"))
            {
                jspClient="/ChoixF.jsp";
                request.setAttribute("message","pas d'information");
            }
            else if(act.equals("insereStade"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererStade(request,response);
            }
            else if(act.equals("CreerEquipes"))
            {
                List<Stade> list= sessionFederation.afficherStade();
                request.setAttribute("listeStade",list);
                jspClient="/Federation/Creer/CreerEquipes.jsp";
            }
            else if(act.equals("insereEquipe"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererEquipe(request,response);
            }
            else if(act.equals("insereArbitre"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererArbitre(request,response);
            }
            else if(act.equals("insereEntraineur"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererEntraineur(request,response);
            }
            else if(act.equals("insereJouer"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererJouer(request,response);
            }
            else if(act.equals("insereChampionnat"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererChampionnat(request,response);
            }
            else if(act.equals("CreerMatchs"))
            {
                List<Stade> lists= sessionFederation.afficherStade();
                request.setAttribute("listeStade",lists);
                List<Equipe> liste= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",liste);
                List<Arbitre> lista= sessionFederation.afficherArbitre();
                request.setAttribute("listeArbitre",lista);
                List<Championnat> listc= sessionFederation.afficherChampionnat();
                request.setAttribute("listeChampionnat",listc);
                jspClient="/Federation/Creer/CreerMatch.jsp";
            }
            else if(act.equals("insereMatch"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererMatch(request,response);
            }
            else if(act.equals("CreerArbitre"))
            {
                jspClient="/Federation/Creer/CreerArbitres.jsp";
            }
            else if(act.equals("CreerEntraineur"))
            {
                jspClient="/Federation/Creer/CreerEntraineur.jsp";
            }
            else if(act.equals("CreerJouer"))
            {
                jspClient="/Federation/Creer/CreerJouer.jsp";
            }
            else if(act.equals("CreerStade"))
            {
                jspClient="/Federation/Creer/CreerStade.jsp";
            }
            else if(act.equals("CreerChampionnat"))
            {
                jspClient="/Federation/Creer/CreerChampionnat.jsp";
            }
            else if(act.equals("CreerContratEntraineur"))
            {
                List<Entraineur> lists= sessionFederation.afficherEntraineur();
                request.setAttribute("listeEntraineur",lists);
                List<Equipe> liste= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",liste);
                jspClient="/Federation/Creer/CreerContratEntraineur.jsp";
            }
            else if(act.equals("insereContratEntraineur"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererContratEntraineur(request,response);
            }
            else if(act.equals("CreerContratJouer"))
            {
                List<Jouer> lists= sessionFederation.afficherJouer();
                request.setAttribute("listeJouer",lists);
                List<Equipe> liste= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",liste);
                jspClient="/Federation/Creer/CreerContratJouer.jsp";
            }
            else if(act.equals("insereContratJouer"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererContratJouer(request,response);
            }
            else if(act.equals("CreerClassement"))
            {
                List<Championnat> lists= sessionFederation.afficherChampionnat();
                request.setAttribute("listeChampionnat",lists);
                List<Equipe> liste= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",liste);
                jspClient="/Federation/Creer/CreerClassement.jsp";
            }
            else if(act.equals("insereClassement"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererClassement(request,response);
            }
            else if(act.equals("CreerOutOfGame"))
            {
                List<Fautes> listFautes= sessionFederation.afficherFautes();
                request.setAttribute("listeFautes",listFautes);
                jspClient="/Federation/Creer/CreerOutOfGame.jsp";
            }
            else if(act.equals("insereFautes"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererFautes(request,response);
            }
            else if(act.equals("rechercherArbitre"))
            {
                jspClient="/Federation/Afficher/AfficherArbitre.jsp";
                List<Arbitre> list= sessionFederation.afficherArbitre();
                request.setAttribute("listeArbitre",list);
                request.setAttribute("message","Liste des arbitres existants");
            }
            else if(act.equals("rechercherJouer"))
            {
                jspClient="/Federation/Afficher/AfficherJouer.jsp";
                List<Jouer> list= sessionFederation.afficherJouer();
                request.setAttribute("listeJouer",list);
                request.setAttribute("message","Liste des jouers existants");
            }
            else if(act.equals("rechercherEntrainuer"))
            {
                jspClient="/Federation/Afficher/AfficherEntraineur.jsp";
                List<Entraineur> list= sessionFederation.afficherEntraineur();
                request.setAttribute("listeEntraineur",list);
                request.setAttribute("message","Liste des entraineur existants");
            }
            else if(act.equals("rechercherEquipes"))
            {
                jspClient="/Federation/Afficher/AfficherEquipes.jsp";
                List<Equipe> list= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",list);
                request.setAttribute("message","Liste des equipe existants");
            }
            else if(act.equals("rechercherChampionnat"))
            {
                jspClient="/Federation/Afficher/AfficherChampionnat.jsp";
                List<Championnat> list= sessionFederation.afficherChampionnat();
                request.setAttribute("listeChampionnat",list);
                request.setAttribute("message","Liste des championnats existants");
            }
            else if(act.equals("rechercherOutOfGame"))
            {
                jspClient="/Federation/Afficher/AfficherOutOfGame.jsp";
                List<OutOfGame> list= sessionFederation.afficherOutOfGame();
                request.setAttribute("listeOutOfGame",list);
                request.setAttribute("message","Liste des punitions existants");
            }
            else if(act.equals("rechercherContratEntraineur"))
            {
                jspClient="/Federation/Afficher/AfficherContratEntraineur.jsp";
                List<Contrat_Entraineur> list= sessionFederation.afficherContratEntraineur();
                request.setAttribute("listeContrat",list);
                request.setAttribute("message","Liste des contrat entraineur existants");
            }
            else if(act.equals("rechercherContratJouer"))
            {
                jspClient="/Federation/Afficher/AfficherContratJouer.jsp";
                List<Contrat_Jouer> list= sessionFederation.afficherContratJouer();
                request.setAttribute("listeContrat",list);
                request.setAttribute("message","Liste des contrat jouer existants");
            }
            else if(act.equals("rechercherStade"))
            {
                jspClient="/Federation/Afficher/AfficherStade.jsp";
                List<Stade> list= sessionFederation.afficherStade();
                request.setAttribute("listeStade",list);
                request.setAttribute("message","Liste des stades existants");
            }
            else if(act.equals("rechercherMatch"))
            {
                jspClient="/Federation/Afficher/AfficherMatch.jsp";
                List<Matchs> list= sessionFederation.afficherMatch();
                request.setAttribute("listeMatch",list);
                request.setAttribute("message","Liste des match existants");
            }
            else if(act.equals("rechercherClassement"))
            {
                jspClient="/Federation/Afficher/AfficherClassement.jsp";
                List<Classement> list= sessionFederation.afficherClassement();
                request.setAttribute("listeClassement",list);
                request.setAttribute("message","Classement existants");
            }
            else if(act.equals("afficherMatch"))
            {
                jspClient="/Federation/Afficher/AfficherListMatch.jsp";
                List<Matchs> list= sessionFederation.afficherMatch();
                request.setAttribute("listeMatch",list);
                request.setAttribute("message","Liste des match existants");
            }
            else if(act.equals("afficherFautesParMatch"))
            {
                jspClient="/Federation/Afficher/AfficherFautesParMatch.jsp";
                String ide= request.getParameter("matchFaute");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Fautes> list= sessionFederation.AfficherFautesParMatch(id);
                request.setAttribute("listeFautesParMatch",list);
                request.setAttribute("message","Liste des fautes par match");
                }
            }
            else if(act.equals("afficherJouer"))
            {
                jspClient="/Federation/Afficher/AfficherListJouer.jsp";
                List<Jouer> list= sessionFederation.afficherJouer();
                request.setAttribute("listeJouer",list);
                request.setAttribute("message","Liste des match existants");
            }
            else if(act.equals("afficherFautesParJouer"))
            {
                jspClient="/Federation/Afficher/AfficherFautesParJouer.jsp";
                String ide= request.getParameter("jouerFaute");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Fautes> list= sessionFederation.AfficherFautesParJouer(id);
                request.setAttribute("listeFautesParJouer",list);
                request.setAttribute("message","Liste des fautes par match");
                }
            }
            else if(act.equals("afficherArbitre"))
            {
                jspClient="/Federation/Afficher/AfficherListArbitre.jsp";
                List<Arbitre> list= sessionFederation.afficherArbitre();
                request.setAttribute("listeArbitre",list);
                request.setAttribute("message","Liste des match existants");
            }
            else if(act.equals("afficherFautesParArbitre"))
            {
                jspClient="/Federation/Afficher/AfficherFautesParArbitre.jsp";
                String ide= request.getParameter("arbitreFaute");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Fautes> list= sessionFederation.AfficherFautesParArbitre(id);
                request.setAttribute("listeFautesParArbitre",list);
                request.setAttribute("message","Liste des fautes par match");
                }
            }


        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccesFederation</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccesFederation at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doActionInsererStade(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nomStade");
        String adresse = request.getParameter("adresseStade");
        String capacite = request.getParameter("capaciteStade");
        String message;
        if(nom.trim().isEmpty()|| adresse.trim().isEmpty()||capacite.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerStade.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un stade.";
        }
        else {
            int cap = Integer.valueOf(capacite);
            sessionFederation.CreerStade(nom, adresse, cap);
            message= "Stade créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererEquipe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nomEquipe");
        String adresse = request.getParameter("adresseEquipe");
        String stade = request.getParameter("stadeEquipe");
        String message;
        if(nom.trim().isEmpty()|| adresse.trim().isEmpty()||stade.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerEquipe.jsp\">Clique ici </a>pour accéder au formulaire de creation d'une Equipe.";
        }
        else {
            Long id = Long.valueOf(stade);
            sessionFederation.CreerEquipe(nom, adresse, id);
            message= "Equipe "+nom+" créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererArbitre(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nom = request.getParameter("nomArbitre");
        String prenom = request.getParameter("prenomArbitre");
        String loginar = request.getParameter("loginArbitre");
        String passar = request.getParameter("passArbitre");
        String message;
        if(nom.trim().isEmpty()||prenom.trim().isEmpty()|| loginar.trim().isEmpty()|| passar.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerArbitre.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un arbitre.";
        }
        else {
            sessionFederation.CreerArbitre(nom, prenom, loginar, passar);
            message= "Arbitre: "+nom+ " créé avec succès !";

        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererEntraineur(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nom = request.getParameter("nomEntraineur");
        String prenom = request.getParameter("prenomEntraineur");
        String loginen = request.getParameter("loginEntraineur");
        String passen = request.getParameter("passEntraineur");
        String message;
        if(nom.trim().isEmpty()||prenom.trim().isEmpty()|| loginen.trim().isEmpty()|| passen.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Entraineur.";
        }
        else {
            sessionFederation.CreerEntraineur(nom, prenom, loginen, passen);
            message= "Entraineur: "+nom+ " créé avec succès !";

        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererJouer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nom = request.getParameter("nomJouer");
        String prenom = request.getParameter("prenomJouer");
        String message;
        if(nom.trim().isEmpty()||prenom.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerJouer.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Jouer.";
        }
        else {
            sessionFederation.CreerJouer(nom, prenom);
            message= "Jouer: "+nom+ " créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererChampionnat(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String nom = request.getParameter("nomChampionnat");
        String date_deb = request.getParameter("dtdebChampionnat");
        String date_fin = request.getParameter("dtfinChampionnat");
        String message;
        if(nom.trim().isEmpty()||date_deb.trim().isEmpty()||date_fin.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerChampionnat.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Championnat.";
        }
        else {
            Date dd = Date.valueOf(date_deb);
            Date df = Date.valueOf(date_fin);
            sessionFederation.CreerChampionnat(nom, dd, df);
            message= "Championnat: "+nom+ " créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererMatch(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String date = request.getParameter("dateMatch");
        String stade = request.getParameter("stadeMatch");
        String equipeH = request.getParameter("equipeHMatch");
        String equipeA = request.getParameter("equipeAMatch");
        String arbitre = request.getParameter("arbitreMatch");
        String championnat = request.getParameter("championnatMatch");
        String message;
        if(date.trim().isEmpty()||stade.trim().isEmpty()||equipeH.trim().isEmpty()||equipeA.trim().isEmpty()||arbitre.trim().isEmpty()||championnat.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerMatch.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Match.";
        }
        else {
            Date d = Date.valueOf(date);
            Long st = Long.valueOf(stade);
            Long eH = Long.valueOf(equipeH);
            Long eA = Long.valueOf(equipeA);
            Long ar = Long.valueOf(arbitre);
            Long ch = Long.valueOf(championnat);
            sessionFederation.CreerMatch(d, st, eH, eA, ar, ch);
            message= "Match entre : "+eH +" vs "+eA+ " créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererContratEntraineur(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String equipe = request.getParameter("equipeContrat");
        String salaire = request.getParameter("salaireContrat");
        String datedeb = request.getParameter("datedebContrat");
        String datefin = request.getParameter("datefinContrat");
        String entraineur = request.getParameter("entraineurContrat");
        String statut = request.getParameter("statutContrat");
        String message;
        if(equipe.trim().isEmpty()||salaire.trim().isEmpty()||datedeb.trim().isEmpty()|| datefin.trim().isEmpty()|| entraineur.trim().isEmpty()|| statut.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerContratEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Contrat Entraineur.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Double sal = Double.valueOf(salaire);
            Date db = Date.valueOf(datedeb);
            Date df = Date.valueOf(datefin);
            Long en = Long.valueOf(entraineur);
            Statut stat = Statut.valueOf(statut);
            sessionFederation.CreerContratEntraineur(stat, sal, en, eq, db, df);
            message= "Contrat entraineur créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererContratJouer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String equipe = request.getParameter("equipeContrat");
        String salaire = request.getParameter("salaireContrat");
        String datedeb = request.getParameter("datedebContrat");
        String datefin = request.getParameter("datefinContrat");
        String jouer = request.getParameter("jouerContrat");
        String statut = request.getParameter("statutContrat");
        String message;
        if(equipe.trim().isEmpty()||salaire.trim().isEmpty()||datedeb.trim().isEmpty()|| datefin.trim().isEmpty()|| jouer.trim().isEmpty()|| statut.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerContratEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Contrat jouer.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Double sal = Double.valueOf(salaire);
            Date db = Date.valueOf(datedeb);
            Date df = Date.valueOf(datefin);
            Long jo = Long.valueOf(jouer);
            Statut stat = Statut.valueOf(statut);
            sessionFederation.CreerContratJouer(stat, sal, jo, eq, db, df);
            message= "Contrat jouer créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererClassement(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String equipe = request.getParameter("equipeClassement");
        String championnat = request.getParameter("championnatClassement");
        String message;
        if(equipe.trim().isEmpty()||championnat.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerClassement.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Classement.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Long ch = Long.valueOf(championnat);
            sessionFederation.CreerClassement(ch, eq);
            message= "Classement créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererFautes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String faute = request.getParameter("Faute");
        String puni = request.getParameter("puni");
        String message;
        if( faute.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerFaute.jsp\">Clique ici </a>pour accéder au formulaire de creation d'une Equipe.";
        }
        else {

            int pun = Integer.valueOf(puni);
            Long fa = Long.valueOf(faute);
            sessionFederation.CreerOutOfGame(fa, pun);
            message= "Faute créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
