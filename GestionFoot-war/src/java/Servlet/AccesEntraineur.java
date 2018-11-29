/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Entite.Entraineur;
import Entite.Jouer;
import Entite.Matchs;
import Session.sessionEntraineurLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
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
@WebServlet(name = "AccesEntraineur", urlPatterns = {"/AccesEntraineur"})
public class AccesEntraineur extends HttpServlet {

    @EJB
    private sessionEntraineurLocal sessionEntraineur;

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
                jspClient="/Entraineur/LoginE.jsp";
            }
            else if(act.equals("LoginEntraineur")){
                String login = request.getParameter("loginEntraineur");
                String pass = request.getParameter("passEntraineur");
                if(!(login.trim().isEmpty())||!(pass.trim().isEmpty())){
                Entraineur e=sessionEntraineur.authentification(login, pass);
                    if(e!=null){
                        request.setAttribute("message","Bienvenue: "+ e.getNom());
                        sess.setAttribute("entr", e);
                        jspClient="/ChoixE.jsp";    
                                }   
                    else{
                        request.setAttribute("message","Entraineur non trouvé");
                        jspClient="/Entraineur/LoginE.jsp";
                    }
                }
                else{
                    request.setAttribute("message","Login ou/et password non rempli");
                    jspClient="/Entraineur/LoginE.jsp";
                }
            }
            else if(act.equals("MenuEntraineur"))
            {
                jspClient="/ChoixE.jsp";
                request.setAttribute("message","pas d'information");
            }
            else if(act.equals("CreerComposition"))
            {
               
                List<Jouer> list= sessionEntraineur.afficherJouer();
                request.setAttribute("listeJouer",list);
                List<Matchs> listMatch= sessionEntraineur.afficherMatch();
                request.setAttribute("listeMatch",listMatch);
                jspClient="/Entraineur/CreerComposition.jsp";
            }
            else if(act.equals("insereComposition"))
            {
                jspClient="/ChoixE.jsp";
                doActionInsererComposition(request,response);
            }
            else if(act.equals("CreerContratJouer"))
            {
                List<Jouer> lists= sessionEntraineur.afficherJouer();
                request.setAttribute("listeJouer",lists);
                jspClient="/Entraineur/AffecterJouer.jsp";
            }
            else if(act.equals("insereContratJouer"))
            {
                jspClient="/ChoixE.jsp";
                doActionInsererContratJouer(request,response);
            }
//            else if(act.equals("LoginEntraineur"))
//            {
//                String login = request.getParameter("loginEntraineur");
//                String pass = request.getParameter("passEntraineur");
//                if(!(login.trim().isEmpty())||!(pass.trim().isEmpty())){
//                Entraineur e=sessionEntraineur.authentification(login, pass);
//                sess.setAttribute("entr", e);;
//                jspClient="/ChoixE.jsp";
//                }
//                
//            }
            
            
//            else if(act.equals("CreerFautes"))
//            {
//                List<Jouer> list= sessionArbitre.afficherJouer();
//                request.setAttribute("listeJouer",list);
//                List<Matchs> listMatch= sessionArbitre.afficherMatch();
//                request.setAttribute("listeMatch",listMatch);
//                jspClient="/Arbitre/CreerFaute.jsp";
//            }
//            else if(act.equals("insereFautes"))
//            {
//                jspClient="/ChoixA.jsp";
//                doActionInsererFautes(request,response);
//            }
//            else if(act.equals("CalcularMatch"))
//            {
//                List<Matchs> listMatch= sessionArbitre.afficherMatchSansResultat();
//                request.setAttribute("listeMatch",listMatch);
//                jspClient="/Arbitre/AffecterResultat.jsp";
//            }
//            else if(act.equals("insereResultat"))
//            {
//                jspClient="/ChoixA.jsp";
//                doActionCalculerMatch(request,response);
//            }

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccesEntraineur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccesEntraineur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    protected void doActionInsererComposition(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String jouer = request.getParameter("jouerComposition");
        String match = request.getParameter("matchComposition");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||jouer.trim().isEmpty()|| match.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerBut.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un stade.";
        }
        else {
            Long jo = Long.valueOf(jouer);
            Long ma =Long.valueOf(match);
//            Long[] longObjects = ArrayUtils.toObject(ma);
//            List<Jouer> longList = java.util.Arrays.asList(jo);
//            List<Jouer> list = Arrays.stream(jo).boxed().collect(Collectors.toList());
            Jouer jou= sessionEntraineur.rechercheJouer(jo);
            List<Jouer> jojo = new ArrayList<>();
            jojo.add(jou);
//            List<Jouer> jojo = new ArrayList<Jouer>(jo.longValue());
//            List<Jouer> jojo = new newList<Jouer>(Long.valueOf(jouer));
            sessionEntraineur.CreerComposition_Home(login, pass, ma, jojo);
            Matchs mat = sessionEntraineur.rechercheMatch(ma);
            String matc = mat.getInfo();
            message= "Composition pour le match:"+ matc+ " créé avec succès !";
            
        }
        request.setAttribute("message", message);
        
    }
    protected void doActionInsererContratJouer(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String salaire = request.getParameter("salaireContrat");
        String datedeb = request.getParameter("datedebContrat");
        String datefin = request.getParameter("datefinContrat");
        String jouer = request.getParameter("jouerContrat");
        String message;
        if(login.trim().isEmpty()|| pass.trim().isEmpty()||salaire.trim().isEmpty()||datedeb.trim().isEmpty()|| datefin.trim().isEmpty()|| jouer.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerContratEntraineur.jsp\">Clique ici </a>pour accéder au formulaire de creation d'un Contrat jouer.";
        }
        else {
            Double sal = Double.valueOf(salaire);
            Date db = Date.valueOf(datedeb);
            Date df = Date.valueOf(datefin);
            Long jo = Long.valueOf(jouer);
            sessionEntraineur.affecterJouer(login, pass, jo, sal, db, df);
            Jouer jou = sessionEntraineur.rechercheJouer(jo);
            String nomjou = jou.getNom();
            message= "Contrat avec le jouer:"+ nomjou+" créé avec succès !";
        }
        request.setAttribute("message", message);
        
    }
//    protected void doActionInsererFautes(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String login = request.getParameter("login");
//        String pass = request.getParameter("pass");
//        String jouer = request.getParameter("jouerFaute");
//        String match = request.getParameter("matchFaute");
//        String carton = request.getParameter("cartonFaute");
//        String message;
//        if(login.trim().isEmpty()|| pass.trim().isEmpty()||jouer.trim().isEmpty()|| match.trim().isEmpty()||carton.trim().isEmpty()){
//            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"CreerFaute.jsp\">Clique ici </a>pour accéder au formulaire de creation d'une Equipe.";
//        }
//        else {
//
//            Long jo = Long.valueOf(jouer);
//            Long mt = Long.valueOf(match);
//            Carton cart = Carton.valueOf(carton);
//            sessionArbitre.creerFautes(login, pass, jo, mt, cart);
//            message= "Faute créé avec succès !";
//            
//        }
//        request.setAttribute("message", message);
//        
//    }
//    protected void doActionCalculerMatch(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String login = request.getParameter("login");
//        String pass = request.getParameter("pass");
//        String match = request.getParameter("match");
//        String message;
//        if(login.trim().isEmpty()|| pass.trim().isEmpty()||match.trim().isEmpty()){
//            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires." + "<br/><a href=\"AffecterResultat.jsp\">Clique ici </a>pour accéder au formulaire láffection d'une resultat";
//        }
//        else {
//            Long mat = Long.valueOf(match);
//            sessionArbitre.calculerMatch(login, pass,mat);
//            message= "Resultat calculé !";
//            
//        }
//        request.setAttribute("message", message);
//        
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
