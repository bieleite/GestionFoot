/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Composition;
import Entite.Equipe;
import Entite.Match;
import Entite.Stade;
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

    void CreerMatch(Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre,Composition compositiona, Composition compositionb);
    
}
