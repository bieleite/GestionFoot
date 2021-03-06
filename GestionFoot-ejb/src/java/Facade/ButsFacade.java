/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entite.Buts;
import Entite.Equipe;
import Entite.Jouer;
import Entite.Matchs;
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
public class ButsFacade extends AbstractFacade<Buts> implements ButsFacadeLocal {

    @PersistenceContext(unitName = "GestionFoot-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ButsFacade() {
        super(Buts.class);
    }
    
    @Override
    public void CreerButs(Equipe equipe, Jouer jouer,Matchs match) {
        Buts f = new Buts();
        f.setLeMatch(match);
        f.setEquipe(equipe);
        f.setJouer(jouer);
        em.persist(f);
    }
    
    @Override
    public List<Buts> listButs() {
        List<Buts> fo=null;
        String txt="SELECT fo FROM Buts AS fo ";
        Query req=getEntityManager().createQuery(txt);
        List<Buts> result=req.getResultList();
        return result;
    }

    @Override
    public Buts rechercheButs(Long id) {
        Buts f = null;        
        String txt = "SELECT f FROM Buts AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);  
        List<Buts> res = req.getResultList();
        if (res.size() >= 1)
        {
              f = (Buts) res.get(0);
        }
        return f;
    }
    
    @Override
    public int qntButsParJouer(Jouer jo) {
        Buts bu=null;
        Query req = getEntityManager().createQuery("SELECT COUNT(bu) FROM Buts AS bu WHERE bu.Jouer=:jo");
        req.setParameter("jo", jo);
        int d = (int)req.getSingleResult();
        return d;
    }
    
    @Override
    public int qntButsParEquipeEtMatch(Equipe eq,Matchs mt ) {
        Buts bu=null;
        Query req = getEntityManager().createQuery("SELECT COUNT(bu) FROM Buts AS bu WHERE bu.Equipe=:equipe and bu.leMatch=:match");
        req.setParameter("equipe", eq);
        req.setParameter("match", mt);
        int d = (int)req.getSingleResult();
        return d;
    }
}
