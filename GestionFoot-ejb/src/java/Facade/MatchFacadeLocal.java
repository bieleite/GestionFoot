/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Buts;
import Entite.Championnat;
import Entite.Composition;
import Entite.Equipe;
import Entite.Stade;
import Entite.Matchs;
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

    void create(Matchs match);

    void edit(Matchs match);

    void remove(Matchs match);

    Matchs find(Object id);

    List<Matchs> findAll();

    List<Matchs> findRange(int[] range);

    int count();

    void CreerMatch(Date date,String Heure,Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre,Championnat champ);
    
    List<Matchs> listMatch();

    Matchs rechercheMatch(Long id);
    
    List<Matchs> rechercheMatchStadeDate(Stade stad,Date dt);
    
    List<Matchs> rechercheMatchArbitre(Arbitre arb);
    
    List<Matchs> rechercheMatchArbitreDate(Arbitre arb,Date dt);
    
    void modifCompositionAway(Composition Com, Equipe equi);
    
    void modifCompositionHome(Composition Com, Equipe equi);
    
    Matchs rechercheMatchParArbitreEtDate(Arbitre arb, Date dt_match);
    
    Matchs rechercheMatchParDate(Date dt_match);
    
    void setResultat_Away(Arbitre arb, Date dt_match,Resultat resul);
    
    void setResultat_Home(Arbitre arb, Date dt_match,Resultat resul);
    
    void setScore_Away(Arbitre arb, Date dt_match,int buts);
    
    void setScore_Home(Arbitre arb, Date dt_match,int buts);
    
    List<Matchs> rechercheMatchEquipe_Home(Equipe eq,Date dt);
    
    List<Matchs> rechercheMatchEquipe_Away(Equipe eq,Date dt);
    
    Matchs rechercheProxMatchParIdEtNum(long id,int num);
    
    Matchs rechercheProxMatchParDateEtNum(Date dt,int num);
    
    Matchs rechercheMatchArbitreEtId(Arbitre arb,long id);
    
    List<Matchs> rechercheMatchEquipe(Equipe equ);
    
    List<Matchs> listMatchSansResultat();
    
    List<Matchs> listMatchSansAvantAuj();
    
    Matchs rechercheMatchAvecComposition(Long id);
}
