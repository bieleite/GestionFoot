/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entite.Arbitre;
import Entite.Carton;
import Entite.Jouer;
import Entite.Matchs;
import Session.sessionArbitreLocal;
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
@WebServlet(name = "AccesArbitre", urlPatterns = {"/AccesArbitre"})
public class AccesArbitre extends HttpServlet {

    @EJB
    private sessionArbitreLocal sessionArbitre;

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
            HttpSession sess= request.getSession(true);
            String jspClient=null;
            String act=request.getParameter("action");
            
            if((act==null)||(act.equals("vide")))
            {   
                request.setAttribute("message","Svp remplir Login et password");
                jspClient="/Arbitre/LoginA.jsp";
            }
            else if(act.equals("LoginArbitre")){
                String login = request.getParameter("loginArbitre");
                String pass = request.getParameter("passArbitre");
                if(!(login.trim().isEmpty())||!(pass.trim().isEmpty())){
                Arbitre a = sessionArbitre.authentification(login, pass);
                    if(a!=null){
                        request.setAttribute("message","Bienvenue: "+ a.getNom());
                        sess.setAttribute("arbt", a);
                        jspClient="/ChoixA.jsp";    
                                }   
                    else{
                        request.setAttribute("message","Entraineur non trouvé");
                        jspClient="/Arbitre/LoginA.jsp";
                    }
                }
                else{
                    request.setAttribute("message","Login ou/et password non rempli");
                    jspClient="/Arbitre/LoginA.jsp";
                }
            }
            else if(act.equals("MenuArbitre"))
            {
                jspClient="/ChoixA.jsp";
                request.setAttribute("message","pas d'information");
            }
            else if(act.equals("CreerButs"))
            {
                List<Jouer> list= sessionArbitre.afficherJouer();
                request.setAttribute("listeJouer",list);
                List<Matchs> listMatch= sessionArbitre.afficherMatch();
                request.setAttribute("listeMatch",listMatch);
                jspClient="/Arbitre/CreerButs.jsp";
            }
            else if(act.equals("insereButs"))
            {
                jspClient="/ChoixA.jsp";
                doActionInsererButs(request,response);
            }
            else if(act.equals("CreerFautes"))
            {
                List<Jouer> list= sessionArbitre.afficherJouer();
                request.setAttribute("listeJouer",list);
                List<Matchs> listMatch= sessionArbitre.afficherMatch();
                request.setAttribute("listeMatch",listMatch);
                jspClient="/Arbitre/CreerFaute.jsp";
            }
            else if(act.equals("insereFautes"))
            {
                jspClient="/ChoixA.jsp";
                doActionInsererFautes(request,response);
            }
            else if(act.equals("CalcularMatch"))
            {
                List<Matchs> listMatch= sessionArbitre.afficherMatchSansResultat();
                request.setAttribute("listeMatch",listMatch);
                jspClient="/Arbitre/AffecterResultat.jsp";
            }
            else if(act.equals("insereResultat"))
            {
                jspClient="/ChoixA.jsp";
                doActionCalculerMatch(request,response);
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
            out.println("<title>Servlet AccesArbitre</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccesArbitre at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doActionInsererButs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String jouer = request.getParameter("jouerBut");
        String match = request.getParameter("matchBut");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||jouer.trim().isEmpty()|| match.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerBut.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un stade.";
        }
        else {
            Long jo = Long.valueOf(jouer);
            Long ma = Long.valueOf(match);
            sessionArbitre.creerButs(login, pass, jo, ma);
            message= "But créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererFautes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String jouer = request.getParameter("jouerFaute");
        String match = request.getParameter("matchFaute");
        String carton = request.getParameter("cartonFaute");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||jouer.trim().isEmpty()|| match.trim().isEmpty()||carton.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerFaute.jsp\">Clique ici </a>pour accéder au formulaire de creation d'une Equipe.";
        }
        else {

            Long jo = Long.valueOf(jouer);
            Long mt = Long.valueOf(match);
            Carton cart = Carton.valueOf(carton);
            sessionArbitre.creerFautes(login, pass, jo, mt, cart);
            message= "Faute créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionCalculerMatch(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String match = request.getParameter("match");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||match.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"AffecterResultat.jsp\">Clique ici </a>pour accéder au formulaire láffection d'une resultat";
        }
        else {
            Long mat = Long.valueOf(match);
            sessionArbitre.calculerMatch(login, pass,mat);
            message= "Resultat calculé !";
            
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
