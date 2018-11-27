/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
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
                jspClient="/Federation/CreerEquipes.jsp";
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
                jspClient="/Federation/CreerMatch.jsp";
            }
            else if(act.equals("insereMatch"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererMatch(request,response);
            }
            else if(act.equals("CreerContratEntraineur"))
            {
                List<Entraineur> lists= sessionFederation.afficherEntraineur();
                request.setAttribute("listeEntraineur",lists);
                List<Equipe> liste= sessionFederation.afficherEquipe();
                request.setAttribute("listeEquipe",liste);
                jspClient="/Federation/CreerContratEntraineur.jsp";
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
                jspClient="/Federation/CreerContratJouer.jsp";
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
                jspClient="/Federation/CreerClassement.jsp";
            }
            else if(act.equals("insereClassement"))
            {
                jspClient="/ChoixF.jsp";
                doActionInsererClassement(request,response);
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
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomStade");
        String adresse = request.getParameter("adresseStade");
        String capacite = request.getParameter("capaciteStade");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()|| adresse.trim().isEmpty()||capacite.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerStade.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un stade.";
        }
        else {
            int cap = Integer.valueOf(capacite);
            sessionFederation.CreerStade(login, pass, nom, adresse, cap);
            message= "Stade créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererEquipe(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomEquipe");
        String adresse = request.getParameter("adresseEquipe");
        String stade = request.getParameter("stadeEquipe");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()|| adresse.trim().isEmpty()||stade.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerEquipe.jsp\">Clique ici </a>pour accéder au formulaire de creation d'une Equipe.";
        }
        else {
            Long id = Long.valueOf(stade);
            sessionFederation.CreerEquipe(login, pass, nom, adresse, id);
            message= "Equipe créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererArbitre(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomArbitre");
        String prenom = request.getParameter("nomArbitre");
        String loginar = request.getParameter("loginArbitre");
        String passar = request.getParameter("passArbitre");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()||prenom.trim().isEmpty()|| loginar.trim().isEmpty()|| passar.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerArbitre.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un arbitre.";
        }
        else {
            sessionFederation.CreerArbitre(login, pass, nom, prenom, loginar, passar);
            message= "Arbitre créé avec succès !";

        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererEntraineur(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomEntraineur");
        String prenom = request.getParameter("prenomEntraineur");
        String loginen = request.getParameter("loginEntraineur");
        String passen = request.getParameter("passEntraineur");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()||prenom.trim().isEmpty()|| loginen.trim().isEmpty()|| passen.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Entraineur.";
        }
        else {
            sessionFederation.CreerEntraineur(login, pass, nom, prenom, login, passen);
            message= "Entraineur créé avec succès !";

        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererJouer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomJouer");
        String prenom = request.getParameter("prenomJouer");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()||prenom.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerJouer.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Jouer.";
        }
        else {
            sessionFederation.CreerJouer(login, pass, nom, prenom);
            message= "Jouer créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererChampionnat(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String nom = request.getParameter("nomChampionnat");
        String date_deb = request.getParameter("dtdebChampionnat");
        String date_fin = request.getParameter("dtfinChampionnat");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||nom.trim().isEmpty()||date_deb.trim().isEmpty()||date_fin.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerChampionnat.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Championnat.";
        }
        else {
            Date dd = Date.valueOf(date_deb);
            Date df = Date.valueOf(date_fin);
            sessionFederation.CreerChampionnat(login, pass, nom, dd, df);
            message= "Championnat créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererMatch(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String date = request.getParameter("dateMatch");
        String stade = request.getParameter("stadeMatch");
        String equipeH = request.getParameter("equipeHMatch");
        String equipeA = request.getParameter("equipeAMatch");
        String arbitre = request.getParameter("arbitreMatch");
        String championnat = request.getParameter("championnatMatch");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||date.trim().isEmpty()||stade.trim().isEmpty()||equipeH.trim().isEmpty()||equipeA.trim().isEmpty()||arbitre.trim().isEmpty()||championnat.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerMatch.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Match.";
        }
        else {
            Date d = Date.valueOf(date);
            Long st = Long.valueOf(stade);
            Long eH = Long.valueOf(equipeH);
            Long eA = Long.valueOf(equipeA);
            Long ar = Long.valueOf(arbitre);
            Long ch = Long.valueOf(championnat);
            sessionFederation.CreerMatch(login, pass, d, st, eH, eA, ar, ch);
            message= "Match créé avec succès !";
        }
        request.setAttribute("message", message);    
    }
    protected void doActionInsererContratEntraineur(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String equipe = request.getParameter("equipeContrat");
        String salaire = request.getParameter("salaireContrat");
        String datedeb = request.getParameter("datedebContrat");
        String datefin = request.getParameter("datefinContrat");
        String entraineur = request.getParameter("entraineurContrat");
        String statut = request.getParameter("statutContrat");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||equipe.trim().isEmpty()||salaire.trim().isEmpty()||datedeb.trim().isEmpty()|| datefin.trim().isEmpty()|| entraineur.trim().isEmpty()|| statut.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerContratEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Contrat Entraineur.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Double sal = Double.valueOf(salaire);
            Date db = Date.valueOf(datedeb);
            Date df = Date.valueOf(datefin);
            Long en = Long.valueOf(entraineur);
            Statut stat = Statut.valueOf(statut);
            sessionFederation.CreerContratEntraineur(login, pass, stat, sal, en, eq, db, df);
            message= "Contrat entraineur créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererContratJouer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String equipe = request.getParameter("equipeContrat");
        String salaire = request.getParameter("salaireContrat");
        String datedeb = request.getParameter("datedebContrat");
        String datefin = request.getParameter("datefinContrat");
        String jouer = request.getParameter("jouerContrat");
        String statut = request.getParameter("statutContrat");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||equipe.trim().isEmpty()||salaire.trim().isEmpty()||datedeb.trim().isEmpty()|| datefin.trim().isEmpty()|| jouer.trim().isEmpty()|| statut.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerContratEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Contrat jouer.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Double sal = Double.valueOf(salaire);
            Date db = Date.valueOf(datedeb);
            Date df = Date.valueOf(datefin);
            Long jo = Long.valueOf(jouer);
            Statut stat = Statut.valueOf(statut);
            sessionFederation.CreerContratJouer(login, pass, stat, sal, jo, eq, db, df);
            message= "Contrat jouer créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererClassement(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String equipe = request.getParameter("equipeClassement");
        String championnat = request.getParameter("championnatClassement");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||equipe.trim().isEmpty()||championnat.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerClassement.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Classement.";
        }
        else {
            Long eq = Long.valueOf(equipe);
            Long ch = Long.valueOf(championnat);
            sessionFederation.CreerClassement(login, pass, ch, eq);
            message= "Classement créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
//    protected void doActionInsererV(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String designation = request.getParameter("designationVetement");
//        String prix = request.getParameter("prixVetement");
//        String idd = request.getParameter("fournisseurVetement");
//        String coloris = request.getParameter("colorisVetement");
//        String message;
//        if(designation.trim().isEmpty()|| prix.trim().isEmpty()||idd.trim().isEmpty()||coloris.trim().isEmpty()){
//            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerFounisseur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un fournisseur.";
//        }
//        else {
//            Long id = Long.valueOf(idd);
//            Double pri = Double.valueOf(prix);
//            sessionArticle.creerVetement(coloris, designation, pri,  id);
//            message= "Article créé avec succès !";
//            
//        }
//        request.setAttribute("message", message);
//    }
//    protected void doActionInsererFr(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String designation = request.getParameter("designationFraicheur");
//        String prix = request.getParameter("prixFraicheur");
//        String idd = request.getParameter("fournisseurFraicheur");
//        String date_lim = request.getParameter("dtlimitFraicheur");
//        String message;
//        if(designation.trim().isEmpty()|| prix.trim().isEmpty()||idd.trim().isEmpty()||date_lim.trim().isEmpty()){
//            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerFounisseur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un fournisseur.";
//        }
//        else {
//            Long id = Long.valueOf(idd);
//            Date d = Date.valueOf(date_lim);
//            Double pri = Double.valueOf(prix);
//            sessionArticle.crerrFraicheur(d, designation, pri, id);
//            message= "Article créé avec succès !";
//            
//        }
//        request.setAttribute("message", message);
//    }

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
