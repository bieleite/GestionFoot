/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Carton;
import Entite.Composition;
import Entite.Equipe;
import Entite.Fautes;
import static Entite.Fautes_.Match;
import Entite.Jouer;
import Entite.Matchs;
import Entite.Resultat;
import Facade.ArbitreFacadeLocal;
import Facade.ButsFacadeLocal;
import Facade.ClassementFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.FautesFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
import Facade.OutOfGameFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class sessionArbitre implements sessionArbitreLocal {

    @EJB
    private OutOfGameFacadeLocal outOfGameFacade;

    @EJB
    private ClassementFacadeLocal classementFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

    @EJB
    private JouerFacadeLocal jouerFacade;

    @EJB
    private MatchFacadeLocal matchFacade;

    @EJB
    private FautesFacadeLocal fautesFacade;

    @EJB
    private ButsFacadeLocal butsFacade;

    @EJB
    private ArbitreFacadeLocal arbitreFacade;

    @Override
    public void saisirResultat() {
     
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void creerFautes(String log, String mdp, long jouer, Long id_match, Carton carton) {
        /*
            Method pour creer des fautes d'une jouer
            Si la faute à comme carton: rouge , add le jouer dans la liste OutOfGame
        */
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            Matchs match= matchFacade.rechercheMatchArbitreEtId(a, id_match);
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouer(jouer);
                if(jo!=null){
                       fautesFacade.CreerFautes(carton, match, a, jo);
                        if(carton==carton.Rouge){
                            Date dt_match = match.getDate();
                            Matchs prox_match =matchFacade.rechercheProxMatchParDateEtNum(dt_match, 1);
                            if(prox_match!=null){
                            Date dt_fin = prox_match.getDate();
                            outOfGameFacade.CreerOutOfGame(jo, dt_match, dt_fin);
                            }
                            else System.out.println("Pas de match prochain ");
                        }
                }
                else System.out.println("Jouer inexistant ");
            }
            else System.out.println("Pas de match pour la date ");
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Fautes ! ");
    
    }

    @Override
    public void creerButs(String log, String mdp, long jouer, Long mat) {
        /*
            Method pour creer des buts et au meme moment calculer le resultat du match
            Apres ajouter dans le classement les points
        */
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            Matchs match= matchFacade.rechercheMatchArbitreEtId(a, mat);//mudar para long e validar a participacao do jogador na partida
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouer(jouer);
                if(jo!=null){
                    Equipe equipe = jo.getEquipe();
                    butsFacade.CreerButs(equipe, jo, match);
                    int qtbuts= 1;
                    Date dt_match= match.getDate();
                    List<Matchs> equipe_away = matchFacade.rechercheMatchEquipe_Away(equipe, dt_match);
                    if (equipe_away.isEmpty())
                    {
                        List<Matchs> equipe_home = matchFacade.rechercheMatchEquipe_Home(equipe, dt_match);
                        if (equipe_home.isEmpty())
                        {
                            System.out.println("Equipe non trouve ");
                        }
                        else{
                            matchFacade.setScore_Home(a, dt_match, qtbuts);
//                            if(match.getScore_Home()>match.getScore_Away()){
//                                matchFacade.setResultat_Home(a, dt_match, Resultat.Winner);
//                                Equipe eh = match.getEquipe_Home();
//                                classementFacade.setPointsParEquipeGagnant(eh);
//                                matchFacade.setResultat_Away(a, dt_match, Resultat.Loser);
//                            }
//                            else if(match.getScore_Home()<match.getScore_Away()){
//                                matchFacade.setResultat_Home(a, dt_match, Resultat.Loser);
//                                matchFacade.setResultat_Away(a, dt_match, Resultat.Winner);
//                                Equipe ea =match.getEquipe_Away();
//                                classementFacade.setPointsParEquipeGagnant(ea);
//                            }
//                            else if(match.getScore_Home()==match.getScore_Away()){
//                                matchFacade.setResultat_Home(a, dt_match, Resultat.Nulle);
//                                Equipe eh = match.getEquipe_Home();
//                                classementFacade.setPointsParEquipeNulle(eh);
//                                matchFacade.setResultat_Away(a, dt_match, Resultat.Nulle);
//                                Equipe ea =match.getEquipe_Away();
//                                classementFacade.setPointsParEquipeNulle(ea);
//                            }
                        }
                    }
                    else{
                        matchFacade.setScore_Away(a, dt_match, qtbuts);
//                        if(match.getScore_Home()>match.getScore_Away()){
//                            matchFacade.setResultat_Home(a, dt_match, Resultat.Winner);
//                            Equipe eh = match.getEquipe_Home();
//                            classementFacade.setPointsParEquipeGagnant(eh);
//                            matchFacade.setResultat_Away(a, dt_match, Resultat.Loser);
//                        }
//                        else if(match.getScore_Home()<match.getScore_Away()){
//                            matchFacade.setResultat_Home(a, dt_match, Resultat.Loser);
//                            matchFacade.setResultat_Away(a, dt_match, Resultat.Winner);
//                            Equipe ea =match.getEquipe_Away();
//                            classementFacade.setPointsParEquipeGagnant(ea);
//                        }
//                        else if(match.getScore_Home()==match.getScore_Away()){
//                            matchFacade.setResultat_Home(a, dt_match, Resultat.Nulle);
//                            Equipe eh = match.getEquipe_Home();
//                            classementFacade.setPointsParEquipeNulle(eh);
//                            matchFacade.setResultat_Away(a, dt_match, Resultat.Nulle);
//                            Equipe ea =match.getEquipe_Away();
//                            classementFacade.setPointsParEquipeNulle(ea);
                            
//                        }
                    }
                }
                else System.out.println("Jouer inexistant ");
            }
            else System.out.println("Pas de match pour la date ");
        }
         else System.out.println("Vous n'avez pas les droits pour créer de buts ! ");
    }
    
    @Override
    public List<Jouer> afficherJouer() {
        List<Jouer> liste = jouerFacade.listJouer();
        return liste;
    }

    @Override
    public List<Matchs> afficherMatch() {
        List<Matchs> liste = matchFacade.listMatch();
        return liste;
    }
    @Override
    public void calculerMatch(String log, String mdp,Long id_match) {
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {   
            Matchs match=matchFacade.rechercheMatch(id_match);
            Date dt_match =match.getDate();
            if(match.getScore_Home()>match.getScore_Away()){
                matchFacade.setResultat_Home(a, dt_match, Resultat.Winner);
                Equipe eh = match.getEquipe_Home();
                classementFacade.setPointsParEquipeGagnant(eh);
                matchFacade.setResultat_Away(a, dt_match, Resultat.Loser);
            }
            else if(match.getScore_Home()<match.getScore_Away()){
                matchFacade.setResultat_Home(a, dt_match, Resultat.Loser);
                matchFacade.setResultat_Away(a, dt_match, Resultat.Winner);
                Equipe ea =match.getEquipe_Away();
                classementFacade.setPointsParEquipeGagnant(ea);
            }
            else if(match.getScore_Home()==match.getScore_Away()){
                matchFacade.setResultat_Home(a, dt_match, Resultat.Nulle);
                Equipe eh = match.getEquipe_Home();
                classementFacade.setPointsParEquipeNulle(eh);
                matchFacade.setResultat_Away(a, dt_match, Resultat.Nulle);
                Equipe ea =match.getEquipe_Away();
                classementFacade.setPointsParEquipeNulle(ea);
            }
        }
        
    }
    
    @Override
    public List<Matchs> afficherMatchSansResultat() {
        List<Matchs> liste = matchFacade.listMatchSansResultat();
        return liste;
    }
    
    @Override
    public List<Matchs> afficherMatchSansAvantAuj() {
        List<Matchs> liste = matchFacade.listMatchSansAvantAuj();
        return liste;
    }
    
    @Override
    public List<Matchs> afficherMatchArbitre(long id) {
        Arbitre arb = arbitreFacade.rechercheArbitre(id);
        List<Matchs> liste = matchFacade.rechercheMatchArbitre(arb);
        return liste;
    }
    
    @Override
    public Arbitre authentification(String login ,String pass) {
        Arbitre a = arbitreFacade.authentification(login, pass);
        return a;
    }
    
    @Override
    public List<Matchs> afficherMatchArbitre(Arbitre arb) {
        List<Matchs> liste = matchFacade.rechercheMatchArbitre(arb);
        return liste;
    }
    
    @Override
    public List<Composition> AfficherCompositionParMatch(long match) {
        /*
        Afficher les differents fautes commises pour les matches d'une date donnée
        */
        List<Composition> liste = new ArrayList<Composition>();
        Matchs m= matchFacade.rechercheMatch(match);
        if(m!=null){
            liste.add(m.getComposition_Away());
            liste.add(m.getComposition_Home());
        }
        else{
            System.out.println("Aucune match dans cette date");
        }
        return liste;
    }
    
    
}
