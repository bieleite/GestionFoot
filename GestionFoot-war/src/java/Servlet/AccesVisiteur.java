/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entite.Arbitre;
import Entite.Championnat;
import Entite.Classement;
import Entite.Composition;
import Entite.Contrat_Entraineur;
import Entite.Contrat_Jouer;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Fautes;
import Entite.Jouer;
import Entite.Matchs;
import Entite.OutOfGame;
import Entite.Stade;
import Session.sessionVisiteurLocal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AccesVisiteur", urlPatterns = {"/AccesVisiteur"})
public class AccesVisiteur extends HttpServlet {

    @EJB
    private sessionVisiteurLocal sessionVisiteur;

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
                jspClient="/ChoixV.jsp";
                request.setAttribute("message","pas d'information");
            }
      
            else if(act.equals("afficherEquipe"))
            {
                jspClient="/Visiteur/List/AfficherListEquipe.jsp";
                List<Equipe> list= sessionVisiteur.afficherEquipe();
                request.setAttribute("listeEquipe",list);
                request.setAttribute("message","Liste des equipes existants");
            }
            else if(act.equals("afficherMatchParEquipe"))
            {
                jspClient="/Visiteur/Resultat/AfficherMatchParEquipe.jsp";
                String ide= request.getParameter("equipeMatch");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Matchs> list= sessionVisiteur.AfficherMatchParEquipe(id);
                request.setAttribute("listeMatchParEquipe",list);
                request.setAttribute("message","Liste des Matchs");
                }
            }
            
            else if(act.equals("rechercherClassement"))
            {
                jspClient="/Visiteur/AfficherClassement.jsp";
                List<Classement> list= sessionVisiteur.afficherClassement();
                request.setAttribute("listeClassement",list);
                request.setAttribute("message","Classement existants");
            }
            
            else if(act.equals("afficherMatch"))
            {
                jspClient="/Visiteur/List/AfficherListMatch.jsp";
                List<Matchs> list= sessionVisiteur.afficherMatch();
                request.setAttribute("listeMatch",list);
                request.setAttribute("message","Liste des match existants");
            }
            else if(act.equals("afficherCompositionParMatch"))
            {
                jspClient="/Visiteur/Resultat/AfficherCompositionParMatch.jsp";
                String ide= request.getParameter("matchComposition");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Composition> list= sessionVisiteur.AfficherCompositionParMatch(id);
                request.setAttribute("listeCompositionParMatch",list);
                request.setAttribute("message","Liste des Compositions par match");
                }
            }
            else if(act.equals("afficherEquipePourJouer"))
            {
                jspClient="/Visiteur/List/AfficherListEquipePourJouer.jsp";
                List<Equipe> list= sessionVisiteur.afficherEquipe();
                request.setAttribute("listeEquipe",list);
                request.setAttribute("message","Liste des equipes existants");
            }
            else if(act.equals("afficherJouerDunEquipe"))
            {
                jspClient="/Visiteur/Resultat/AfficherJouerDunEquipe.jsp";
                String ide= request.getParameter("equipeJouer");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Jouer> list= sessionVisiteur.AfficherJouerParEquipe(id);
                request.setAttribute("listeJouerDunEquipe",list);
                request.setAttribute("message","Liste des Jouers d'une equipe");
                }
            }
            else if(act.equals("afficherJouer"))
            {
                jspClient="/Visiteur/List/AfficherListJouer.jsp";
                List<Jouer> list= sessionVisiteur.afficherJouer();
                request.setAttribute("listeJouer",list);
                request.setAttribute("message","Liste des Jouers existants");
            }
            else if(act.equals("afficherHistoriqueJouer"))
            {
                jspClient="/Visiteur/Resultat/AfficherHistoriqueJouer.jsp";
                String ide= request.getParameter("jouerContrat");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Contrat_Jouer> list= sessionVisiteur.AfficherContratJouerParJouer(id);
                request.setAttribute("listeHistoriqueJouer",list);
                request.setAttribute("message","Liste contrats par Jouer");
                }
            }
            else if(act.equals("afficherEntraineur"))
            {
                jspClient="/Visiteur/List/AfficherListEntraineur.jsp";
                List<Entraineur> list= sessionVisiteur.afficherEntraineur();
                request.setAttribute("listeEntraineur",list);
                request.setAttribute("message","Liste des entraineurs existants");
            }
            else if(act.equals("afficherHistoriqueEntraineur"))
            {
                jspClient="/Visiteur/Resultat/AfficherHistoriqueEntraineur.jsp";
                String ide= request.getParameter("entraineurContrat");
                if(!ide.trim().isEmpty()){
                Long id = Long.valueOf(ide);
                List<Contrat_Entraineur> list= sessionVisiteur.AfficherContratEntraineurParEntraineur(id);
                request.setAttribute("listeHistoriqueEntraineur",list);
                request.setAttribute("message","Liste des contrats par entraineurs");
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
