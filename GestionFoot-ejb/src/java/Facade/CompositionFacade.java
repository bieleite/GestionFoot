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
    public void CreerComposition(Equipe equipe, Jouer jouer) {
        Composition f = new Composition();
        f.setEquipe(equipe);
        f.setJoeur(jouer);
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
    public  Composition rechercheEquipeParEquipe(Equipe equi) {
        Composition e = null;        
        String txt = "SELECT e FROM Composition AS e WHERE e.Equipe=:nom ";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", equi);
        List<Composition> res = req.getResultList();
        if (res.size() >= 1)
        {
              e = (Composition) res.get(0);
        }
        return e;
        
    }
}
