/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Composition;
import Entite.Entraineur;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
import java.util.Date;
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
public class CompositionFacade extends AbstractFacade<Composition> implements CompositionFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CompositionFacade() {
        super(Composition.class);
    }
    
        @Override
    public void CreerComposition(Date dt_comp,Equipe equipe, List<Jouer> jouers) {
        Composition f = new Composition();
        f.setDate_Comp(dt_comp);
        f.setEquipe(equipe);
        f.setJouers(jouers);
        em.persist(f);
    }
    
    @Override
    public List<Composition> listComposition() {
        List<Composition> fo=null;
        String txt="SELECT fo FROM Composition AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Composition> result=req.getResultList();
        return result;
    }
    
    @Override
    public List<Composition> rechercheCompositionMatch(Matchs ma) {
        String txt = "SELECT com FROM Composition AS com WHERE com.matchs=:ma ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("ma", ma);
        List<Composition> res = req.getResultList();
        return res;
        
    }

    @Override
    public Composition rechercheComposition(Long id) {
        Composition f = null;        
        String txt = "SELECT f FROM Composition AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Composition> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Composition) res.get(0);
        }
        return f;
    }
    
    @Override
    public  Composition rechercheCompositionParEquipeEtDate(Equipe equi,Date dt) {
        Composition e = null;        
        String txt = "SELECT e FROM Composition AS e WHERE e.Equipe=:nom and e.Date_Comp=:dt ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", equi);
        req = req.setParameter("dt", dt);
        List<Composition> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Composition) res.get(0);
        }
        return e;
    }

}
