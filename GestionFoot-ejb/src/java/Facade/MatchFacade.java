/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Arbitre;
import Entite.Composition;
import Entite.Equipe;
import Entite.Stade;
import Entite.Match;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public void CreerMatch(Date date,Stade stade, Equipe equipea,Equipe equipeb,Arbitre arbitre,Composition compositiona, Composition compositionb) {
        Match m = new Match();
        m.setDate(date);
        m.setStade(stade);
        m.setEquipe_Home(equipeb);
        m.setEquipe_Away(equipea);
        m.setComposition_Away(compositiona);
        m.setComposition_Home(compositionb);
        m.setArbitre(arbitre);
        em.persist(m);
    }
    
    @Override
    public List<Match> listMatch() {
        List<Match> fo=null;
        String txt="SELECT fo FROM Match AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Match> result=req.getResultList();
        return result;
    }

    @Override
    public Match rechercheMatch(Long id) {
        Match f = null;        
        String txt = "SELECT f FROM Match AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Match> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Match) res.get(0);
        }
        return f;
    }
    
}
