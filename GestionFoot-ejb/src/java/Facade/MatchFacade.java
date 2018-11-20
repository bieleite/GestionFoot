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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabrielleite
 */
@Stateless
public class MatchFacade extends AbstractFacade<Match> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Match.class);
    }

    @Override
    public void CreerMatch(Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre,Composition compositiona, Composition compositionb) {
        Match m = new Match();
        m.setStade(stade);
        m.setEquipe_Home(equipeb);
        m.setEquipe_Away(equipea);
        m.setComposition_Away(compositiona);
        m.setComposition_Home(compositionb);
        m.setArbitre(arbitre);
        em.persist(m);
    }
    
    
}
