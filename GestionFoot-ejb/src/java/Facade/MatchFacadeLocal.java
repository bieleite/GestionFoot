/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Composition;
import Entite.Equipe;
import Entite.Stade;
import Entite.Match;
import Entite.Resultat;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gabrielleite
 */
@Local
public interface MatchFacadeLocal {

    void create(Match match);

    void edit(Match match);

    void remove(Match match);

    Match find(Object id);

    List<Match> findAll();

    List<Match> findRange(int[] range);

    int count();

    void CreerMatch(Date date,Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre);
    
    List<Match> listMatch();

    Match rechercheMatch(Long id);
    
    List<Match> rechercheMatchStadeDate(Stade stad,Date dt);
    
    List<Match> rechercheMatchArbitreDate(Arbitre arb,Date dt);
    
    void modifCompositionAway(Composition Com, Equipe equi);
    
    void modifCompositionHome(Composition Com, Equipe equi);
    
    Match rechercheMatchParArbitreEtDate(Arbitre arb, Date dt_match);
    
    void setResultat_Away(Arbitre arb, Date dt_match,Resultat resul);
    
    void setResultat_Home(Arbitre arb, Date dt_match,Resultat resul);
    
    void setScore_Away(Arbitre arb, Date dt_match,int buts);
    
    void setScore_Home(Arbitre arb, Date dt_match,int buts);
    
    List<Match> rechercheMatchEquipe_Home(Equipe eq,Date dt);
    
    List<Match> rechercheMatchEquipe_Away(Equipe eq,Date dt);
}
