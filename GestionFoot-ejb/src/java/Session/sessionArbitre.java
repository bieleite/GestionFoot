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
import Entite.Jouer;
import Entite.Matchs;
import Entite.Resultat;
import Facade.ArbitreFacadeLocal;
import Facade.ButsFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.FautesFacadeLocal;
import Facade.JouerFacadeLocal;
import Facade.MatchFacadeLocal;
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
    public void creerFautes(String log, String mdp, String nom, Date dt_match, String carton) {
        Carton cart =null;
        Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            if (carton.contains("Rouge") || carton.contains("Rouge"))
               cart = cart.Rouge;
            else if (carton.contains("Jaune")|| carton.contains("Jaune"))
                cart = cart.Jaune;
            else if (carton.contains("Non")|| carton.contains("Non"))
                cart = cart.Non;
            Matchs match= matchFacade.rechercheMatchParArbitreEtDate(a, dt_match);
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouerParNom(nom);
                if(jo!=null){
                        fautesFacade.CreerFautes(cart, match, a, jo);
                }
                else System.out.println("Jouer inexistant ");
            }
            else System.out.println("Pas de match pour la date ");
        }
        
        else System.out.println("Vous n'avez pas les droits pour créer de Fautes ! ");
    
    }

    @Override
    public void creerButs(String log, String mdp, String nom, Date dt_match) {
           Arbitre a = arbitreFacade.authentification(log, mdp);
        if (a!=null)
        {
            Matchs match= matchFacade.rechercheMatchParArbitreEtDate(a, dt_match);
            if(match!=null){
                Jouer jo= jouerFacade.rechercheJouerParNom(nom);
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
                                matchFacade.setResultat_Away(a, dt_match, Resultat.Loser);
                            }
                            else if(match.getScore_Home()<match.getScore_Away()){
                                matchFacade.setResultat_Home(a, dt_match, Resultat.Loser);
                                matchFacade.setResultat_Away(a, dt_match, Resultat.Winner);
                            }
                            else if(match.getScore_Home()==match.getScore_Away()){
                                matchFacade.setResultat_Home(a, dt_match, Resultat.Nulle);
                                matchFacade.setResultat_Away(a, dt_match, Resultat.Nulle);
                            }
                        }
                    }
                    else{
                        matchFacade.setScore_Away(a, dt_match, qtbuts);
                        if(match.getScore_Home()>match.getScore_Away()){
                            matchFacade.setResultat_Home(a, dt_match, Resultat.Winner);
                            matchFacade.setResultat_Away(a, dt_match, Resultat.Loser);
                        }
                        else if(match.getScore_Home()<match.getScore_Away()){
                            matchFacade.setResultat_Home(a, dt_match, Resultat.Loser);
                            matchFacade.setResultat_Away(a, dt_match, Resultat.Winner);
                        }
                        else if(match.getScore_Home()==match.getScore_Away()){
                            matchFacade.setResultat_Home(a, dt_match, Resultat.Nulle);
                            matchFacade.setResultat_Away(a, dt_match, Resultat.Nulle);
                        }
                    }
                }
                else System.out.println("Jouer inexistant ");
            }
            else System.out.println("Pas de match pour la date ");
        }
         else System.out.println("Vous n'avez pas les droits pour créer de buts ! ");
    }
}
