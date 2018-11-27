/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Carton;
import Entite.Equipe;
import Entite.Fautes;
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
    public void creerFautes(String log, String mdp, long jouer, Date dt_match, Carton carton) {
        /*
            Method pour creer des fautes d'une jouer
            Si la faute à comme carton: rouge , add le jouer dans la liste OutOfGame
        */
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            Matchs match= matchFacade.rechercheMatchParArbitreEtDate(a, dt_match);
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouer(jouer);
                if(jo!=null){
                       fautesFacade.CreerFautes(carton, match, a, jo);
                        if(carton==carton.Rouge){
                            Matchs prox_match =matchFacade.rechercheProxMatchParDateEtNum(dt_match, 1);
                            Date dt_fin = prox_match.getDate();
                            outOfGameFacade.CreerOutOfGame(jo, dt_match, dt_fin);
                        }
                }
                else System.out.println("Jouer inexistant ");
            }
            else System.out.println("Pas de match pour la date ");
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Fautes ! ");
    
    }

    @Override
    public void creerButs(String log, String mdp, long jouer, Date dt_match) {
        /*
            Method pour creer des buts et au meme moment calculer le resultat du match
            Apres ajouter dans le classement les points
        */
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            Matchs match= matchFacade.rechercheMatchParArbitreEtDate(a, dt_match);//mudar para long e validar a participacao do jogador na partida
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouer(jouer);
                if(jo!=null){
                    Equipe equipe = equipeFacade.rechercheEquipeParJouer(jo);
                    butsFacade.CreerButs(equipe, jo, match);
                    int qtbuts= butsFacade.qntButsParEquipeEtMatch(equipe, match);
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
                    else{
                        matchFacade.setScore_Away(a, dt_match, qtbuts);
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
}
